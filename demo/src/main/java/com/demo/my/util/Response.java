package com.demo.my.util;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.security.Permission;
import java.util.List;
import java.util.Map;

public class Response {
    // 二进制文件
    private byte[] byteContent;

    // 错误信息
    private String errorMessage;

    // 响应状态码
    private int responseCode;

    // 请求连接对象
    private HttpURLConnection connection;

    public Response(HttpURLConnection connection, String encode) {
        this.connection = connection;
        BufferedInputStream input = null;
        ByteArrayOutputStream output = null;

        try {
            input = new BufferedInputStream(connection.getInputStream());
            output = new ByteArrayOutputStream();
            byte[] bytes = new byte[2048];
            int len = 0;
            while (-1 != (len = input.read(bytes))) {
                output.write(bytes, 0, len);
            }

            byteContent = output.toByteArray();
            responseCode = connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
            BufferedReader in = null;
            try {
                StringBuffer message = new StringBuffer(30);
                in = new BufferedReader(new InputStreamReader(connection.getErrorStream(), encode));
                String line;
                while ((line = in.readLine()) != null) {
                    message.append(line);
                }

                this.errorMessage = message.toString();
                this.responseCode = -1;
            } catch (IOException encodeException) {
                encodeException.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        } finally {
            try {
                if (input != null) {
                    input.close();
                }

                if (output != null) {
                    output.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }

        }
    }

    public byte[] getByteContent() {
        return this.byteContent;
    }

    public String getContent() {
        return byteContent == null ? "" : new String(byteContent);
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    @Override
    public String toString() {
        if (errorMessage != null) {
            return errorMessage;
        }

        return this.getContent();
    }

    public String getResponseMessage() {
        try {
            return connection.getResponseMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getHeaderFieldKey(int n) {
        return connection.getHeaderFieldKey(n);
    }

    public String getHeaderField(int n) {
        return connection.getHeaderField(n);
    }

    public long getHeaderFieldDate(String name, long defaultValue) {
        return connection.getHeaderFieldDate(name, defaultValue);
    }

    public Permission getPermission() {
        try {
            return connection.getPermission();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int getContentLength() {
        return connection.getContentLength();
    }

    public long getContentLengthLong() {
        return connection.getContentLengthLong();
    }

    public String getContentType() {
        return connection.getContentType();
    }

    public String getContentEncoding() {
        return connection.getContentEncoding();
    }

    public long getExpiration() {
        return connection.getExpiration();
    }

    public long getDate() {
        return connection.getDate();
    }


    public String getHeaderField(String name) {
        return connection.getHeaderField(name);
    }

    public Map<String,List<String>> getHeaderFields() {
        return connection.getHeaderFields();
    }


    public int getHeaderFieldInt(String name, int Default) {
        return connection.getHeaderFieldInt(name, Default);
    }

    public long getHeaderFieldLong(String name, long Default) {
        return connection.getHeaderFieldLong(name, Default);
    }

    public HttpURLConnection getConnection() {
        return connection;
    }

}
