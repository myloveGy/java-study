package array;

public class Search {
    public static void main(String[] args) {
        System.out.println(search(new String[]{"jinxing.liu", "hahaha", "myName", "HaHaHa"}, "hahaha"));
    }

    public static boolean search(String[] s, String dest) {
        for (int i = 0; i < s.length; i ++) {
            if (dest.equals(s[i])) {
                return true;
            }
        }

        return false;
    }
}