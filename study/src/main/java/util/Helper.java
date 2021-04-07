package util;

import java.nio.charset.StandardCharsets;

public class Helper {
    public static String Snake(String s) {
        byte[] arr = s.getBytes(StandardCharsets.UTF_8);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 65 && arr[i] <= 90) {
                if (i > 0) {
                    str.append("_");
                }

                byte in = (byte) (arr[i] + (byte)32);
                str.append(new String(new byte[]{in}));
            } else {
                str.append(new String(new byte[]{arr[i]}));
            }
        }

        return str.toString();
    }
}
