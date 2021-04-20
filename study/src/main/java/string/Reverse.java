package string;

public class Reverse {

    /**
     * 字符串反转
     *
     * @param str   需要反转的字符串
     * @param start 起始位置
     * @param end   结束位置
     * @return 反转后的字符串
     */
    public static String to(String str, int start, int end) {
        // 字符串为空
        if (empty(str)) {
            return null;
        }

        // 兼容索引超出
        if (end >= str.length()) {
            end = str.length() - 1;
        }

        char[] array = str.toCharArray();
        for (int x = start, y = end; x < y; x++, y--) {
            char tmp = array[x];
            array[x] = array[y];
            array[y] = tmp;
        }

        return new String(array);
    }

    /**
     * 字符串反转(通过拼接的方式)
     *
     * @param str   需要反转的字符串
     * @param start 起始位置
     * @param end   结束位置
     * @return 反转后的字符串
     */
    public static String toJoinHandle(String str, int start, int end) {
        // 字符串为空
        if (empty(str)) {
            return null;
        }

        // 兼容索引超出
        if (end >= str.length()) {
            end = str.length() - 1;
        }

        String newStr = str.substring(0, start);
        for (int i = end; i >= start; i--) {
            newStr += str.charAt(i);
        }

        return newStr + str.substring(end + 1);
    }

    public static String toBuilderHandle(String str, int start, int end) {
        // 字符串为空
        if (empty(str)) {
            return null;
        }

        // 兼容索引超出
        if (end >= str.length()) {
            end = str.length() - 1;
        }

        StringBuffer buffer = new StringBuffer(str.length());
        buffer.append(str, 0, start);
        for (int i = end; i >= start; i--) {
            buffer.append(str.charAt(i));
        }

        buffer.append(str.substring(end + 1));
        return buffer.toString();
    }

    /**
     * 判断字符串为空
     *
     * @param str 需要验证的字符串
     * @return 为空返回true
     */
    public static boolean empty(String str) {
        return str == null || str.equals("") || str.length() == 0;
    }
}
