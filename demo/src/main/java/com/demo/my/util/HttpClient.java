package com.demo.my.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpClient {

    public static final class Method {
        private Method() {

        }

        public static final String GET = "GET";
        public static final String POST = "POST";
        public static final String HEAD = "HEAD";
        public static final String OPTIONS = "OPTIONS";
        public static final String PUT = "PUT";
        public static final String DELETE = "DELETE";
        public static final String TRACE = "TRACE";
    }

    public static final class Encode {
        private Encode() {

        }

        public static final String UTF8 = "UTF-8";
        public static final String UTF16 = "UTF-16";
        public static final String GB18030 = "GB18030";
        public static final String GBK = "GBK";
        public static final String GB2312 = "GB2312";
        public static final String ISO_8859_1 = "ISO-8859-1";
        public static final String ASCII = "ASCII";
    }

    // 请求地址
    private String url;

    // 路径中请求参数
    private Map<String, Object> query = new HashMap<String, Object>();

    // 请求方法
    private String method = Method.GET;

    // 请求数据 post
    private Map data = new HashMap();

    // Cookies 请求参数
    private String cookies = "";

    // 请求header头信息
    private Map<String, String> headers = new HashMap<String, String>();

    // 返回结果的编码
    private String encode = Encode.UTF8;

    // 返回连接对象
    private HttpURLConnection connection;

    // 请求之后是否关闭连接
    private boolean requestAfterCloseConnection = true;

    private boolean doInput = true;

    private boolean doOutput = false;

    // 读取数据超时时间
    private int readTimeout = -1;

    // 连接超时时间
    private int connectionTimeout = -1;

    private boolean useCaches = false;

    public HttpClient(String url) {
        this.url = url;
    }

    public HttpClient() {

    }

    public static HttpClient builder() {
        return new HttpClient();
    }

    public HttpClient build() {
        return this;
    }

    private HttpURLConnection getConnection() {
        this.openConnection();
        return this.connection;
    }

    private void openConnection() {
        if (this.url == null || "".equals(url)) {
            throw new RuntimeException("URL不能为空");
        }

        try {
            URL url = new URL(this.url + this.toQueryString());
            this.connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Response request() {
        Response response = null;
        this.openConnection();

        try {
            setRequestProperties(connection);
            response = new Response(connection, encode);
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (this.requestAfterCloseConnection && connection != null) {
                connection.disconnect();
            }
        }

        return response;
    }

    public Response get() {
        this.method = Method.GET;
        return this.request();
    }

    public Response post() {
        this.method = Method.POST;
        return this.request();
    }

    public Response put() {
        this.method = Method.PUT;
        return this.request();
    }

    public Response delete() {
        this.method = Method.DELETE;
        return this.request();
    }

    public static Response request(String url, Object... params) {
        HttpClient client = new HttpClient(url);
        parseParams(client, params);
        return client.request();
    }

    public static Response get(String url, Object... params) {
        return request(url, Method.GET, params);
    }

    public static Response post(String url, Object... params) {
        return request(url, Method.POST, params);
    }

    private static void parseParams(HttpClient client, Object[] params) {
        int length = params.length;

        // 第一个参数设置请求方法
        if (length > 0) {
            Object param = params[1];
            if (param instanceof String) {
                client.setMethod((String) param);
            }
        }

        // 第二个参数为：query 请求参数
        if (length > 1) {
            Object param = params[1];
            if (param instanceof Map) {
                client.setQuery((Map) param);
            }
        }

        // 第三个参数为：post 请求数据
        if (length > 2) {
            Object param = params[2];
            if (param instanceof Map) {
                client.setPostData((Map) param);
            }
        }

        // 第四个参数设置信息
        if (length > 3) {
            Object param = params[3];
            if (param instanceof Map) {
                client.setHeaders((Map) param);
            }
        }

        //  第五个参数设置cookies 信息
        if (length > 4) {
            Object param = params[4];
            if (param instanceof String) {
                client.setCookies((String) param);
            }
        }
    }

    /**
     * 设置请求属性
     *
     * @param conn
     * @throws IOException
     */
    private void setRequestProperties(HttpURLConnection conn) throws IOException {

        conn.setDoInput(doInput);
        conn.setDoOutput(doOutput);
        conn.setUseCaches(useCaches);
        if (readTimeout > 0)
            conn.setReadTimeout(readTimeout);
        if (connectionTimeout > 0)
            conn.setConnectTimeout(connectionTimeout);

        conn.setRequestMethod(method);

        if (!headers.isEmpty()) {
            for (Map.Entry<String, String> header : headers.entrySet())
                conn.setRequestProperty(header.getKey(), header.getValue());
        }

        if (cookies != null && !"".equals(cookies.trim())) {
            conn.setRequestProperty("Cookie", cookies);
        }

        if (Method.POST.equals(method.toUpperCase())) {
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            os.write(toPostDataString().getBytes());
            os.flush();

        }
    }

    private String toPostDataString() {
        if (data.size() < 1)
            return "";
        String postDataString = null;

        String contentType = headers.get("Content-Type");

        if (contentType != null && contentType.contains("form")) {
            postDataString = toQueryString(this.data);
            postDataString = postDataString.substring(1, postDataString.length());
        }
//        else if (ContentType.contains("json"))
        else {
            postDataString = toJSONString(this.data);
        }

        return postDataString;
    }

    /**
     * 查询参数转为字符串
     *
     * @return
     */
    private String toQueryString(Map<String, Object> query) {
        StringBuilder sb = new StringBuilder();
        if (!query.isEmpty()) {
            if (url.contains("?"))
                sb.append("&");
            else
                sb.append("?");

            for (Map.Entry entry : query.entrySet())
                sb.append(entry.getKey().toString() + "=" + entry.getValue().toString() + "&");
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    /**
     * 查询参数转为字符串
     *
     * @return
     */
    private String toQueryString() {
        return this.toQueryString(this.query);
    }

    /**
     * 添加一条路径参数
     *
     * @param var 路径参数
     * @return
     */
    public HttpClient addPathVariable(Object var) {
        this.url += "/" + var;
        return this;
    }

    /**
     * 添加一条路径参数
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public HttpClient addQuery(String key, Object value) {
        if (key == null || value == null)
            throw new IllegalArgumentException("key或value不可为空");

        query.put(key, value);
        return this;
    }


    /**
     * @param key   字段名称
     * @param value 字段值
     * @return 自己
     */
    public HttpClient addPostData(String key, Object value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("key或value不可为空");
        }

        data.put(key, value);
        return this;
    }

    /**
     * 添加一条cookie
     *
     * @param key   字段名称
     * @param value 字段值
     * @return 自己
     */
    public HttpClient addCookie(String key, String value) {
        if (key == null || value == null)
            throw new IllegalArgumentException("key或value不可为空");

        cookies = cookies.trim() + ("".equals(cookies.trim()) ? "" : ";") + key + "=" + value;
        return this;
    }

    public HttpClient addCookies(String cookie) {
        if (cookie == null)
            throw new IllegalArgumentException("cookie不可为空");

        this.cookies = this.cookies.trim() + ("".equals(this.cookies.trim()) ? "" : ";") + cookie;
        return this;
    }

    /**
     * 添加一条header
     *
     * @param key   字段名称
     * @param value 字段值
     * @return 自己
     */
    public HttpClient addHeader(String key, String value) {
        if (key == null || "".equals(key) || value == null)
            throw new IllegalArgumentException("key或value不可为空");

        headers.put(key, value);
        return this;
    }

    /**
     * 转为Json字符串
     *
     * @param obj Map或List类型
     * @return 字符串
     */
    public String toJSONString(Object obj) {
        if (obj instanceof Map) {
            Map dataMap = (Map) obj;
            StringBuffer sb = new StringBuffer();
            Iterator entries = dataMap.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();
                sb.append("\"").append(entry.getKey()).append("\":");

                Object value = entry.getValue();
                parseValue(sb, value);

                if (entries.hasNext())
                    sb.append(",");
            }
            sb.insert(0, "{").append("}");
            return sb.toString();
        } else if (obj instanceof List) {
            List dataList = (List) obj;
            StringBuffer sb = new StringBuffer();
            Iterator entries = dataList.iterator();
            while (entries.hasNext()) {
                Object value = entries.next();
                parseValue(sb, value);

                if (entries.hasNext())
                    sb.append(",");

            }
            sb.insert(0, "[").append("]");

            return sb.toString();
        } else
            throw new RuntimeException("类型不支持");
    }

    private void parseValue(StringBuffer sb, Object value) {
        if (value == null)
            sb.append("null");
        else if (value instanceof Integer || value instanceof Double || value instanceof Float)
            sb.append(value);
        else if (value instanceof Map || value instanceof List)
            sb.append(toJSONString(value));
        else
            sb.append("\"").append(value).append("\"");
    }

    public String getUrl() {
        return url;
    }

    public HttpClient setUrl(String url) {
        if (url == null || "".equals(url))
            throw new IllegalArgumentException("url不能为空或空串");

        this.url = url;
        return this;
    }

    public Map<String, Object> getQuery() {
        return query;
    }

    public HttpClient setQuery(Map<String, Object> query) {
        if (query == null)
            throw new IllegalArgumentException("param不能为空");

        this.query = query;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public HttpClient setMethod(String method) {
        if (method == null || "".equals(method))
            throw new IllegalArgumentException("method不能为空");

        this.method = method;
        return this;
    }

    public Map getPostData() {
        return data;
    }

    public HttpClient setPostData(Map postData) {
        if (postData == null)
            throw new IllegalArgumentException("data不能为空");

        this.data = postData;
        return this;
    }

    public String getCookies() {
        return cookies;
    }

    public HttpClient setCookies(String cookies) {
        if (cookies == null || "".equals(cookies))
            throw new IllegalArgumentException("cookie不能为空");

        this.cookies = cookies;
        return this;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public HttpClient setHeaders(Map<String, String> headers) {
        if (headers == null)
            throw new IllegalArgumentException("headers不能为空");

        this.headers = headers;
        return this;
    }

    public String getEncode() {
        return encode;
    }

    public HttpClient setEncode(String encode) {
        if (encode == null || "".equals(encode))
            throw new IllegalArgumentException("encode不能为空");

        this.encode = encode;
        return this;
    }

    public boolean isDoInput() {
        return doInput;
    }

    public HttpClient setDoInput(boolean doInput) {
        this.doInput = doInput;
        return this;
    }

    public boolean isDoOutput() {
        return doOutput;
    }

    public HttpClient setDoOutput(boolean doOutput) {
        this.doOutput = doOutput;
        return this;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public HttpClient setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public HttpClient setConnectionTimeout(int connectTimeout) {
        this.connectionTimeout = connectTimeout;
        return this;
    }

    public boolean isUseCaches() {
        return useCaches;
    }

    public HttpClient setUseCaches(boolean useCaches) {
        this.useCaches = useCaches;
        return this;
    }
}
