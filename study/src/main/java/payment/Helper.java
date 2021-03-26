package payment;

import java.util.Scanner;

public class Helper {
    //
    private static Scanner scanner = new Scanner(System.in);

    public static boolean search(char c, char[] allow) {
        for (int i = 0; i < allow.length; i++) {
            if (allow[i] == c) {
                return true;
            }
        }

        return false;
    }

    public static char readMenuSelection(char[] allow) {
        char c;
        for (;;) {
            String str = readKeyBoard(1);
            c = str.charAt(0);
            if (!search(c, allow)) {
                System.out.println("选择错误，请重新输入:");
            } else
                break;
        }

        return c;
    }

    /**
     * 界面选择
     * 
     * @return 输入字符串
     */
    public static char readMenuSelection() {
        char c;
        for (;;) {
            String str = readKeyBoard(1);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4') {
                System.out.println("选择错误，请重新输入:");
            } else
                break;
        }

        return c;
    }

    public static int readNumber(String description, boolean notEmpty) {
        System.out.print(description);
        int n;
        for (;;) {
            String str = readKeyBoard(4);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("[" + str + "]" + description);
            }
        }

        // 不允许为空
        if (notEmpty && n == 0) {
            return readNumber(description, notEmpty);
        }

        return n;
    }

    public static int readNumber() {
        int n;
        for (;;) {
            String str = readKeyBoard(4);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("数字输入错误" + str + "，请重新输入:");
            }
        }

        return n;
    }

    /**
     * 读取字符串
     * 
     * @param description 说明信息
     * @param args        输入的参数必须是args里面
     * @return
     */
    public static String readString(String description, String[] args) {
        System.out.print(description);
        String s = readKeyBoard(0);
        for (int i = 0; i < args.length; i++) {
            if (s.equals(args[i])) {
                return s;
            }
        }

        return readString(description, args);
    }

    /**
     * 读取字符串
     * 
     * @param description 说明信息
     * @param notEmpty    不能为空
     * @return
     */
    public static String readString(String description, boolean notEmpty) {
        System.out.print(description);
        String s = readKeyBoard(0);
        if (s.equals("") && notEmpty) {
            return readString(description, notEmpty);
        }

        return s;
    }

    public static String readString(String description) {
        System.out.print(description);
        return readKeyBoard(8);
    }

    public static String readString() {
        return readKeyBoard(8);
    }

    public static char readConfirmSelection() {
        char c;
        for (;;) {
            String str = readKeyBoard(1).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入:");
            }
        }

        return c;
    }

    public static String readKeyBoard(int number) {

        String s = "";

        if (scanner.hasNextLine()) {
            s = scanner.nextLine();
        }

        // 读取所有
        if (number == 0) {
            return s;
        }

        return s.substring(0, number > s.length() ? s.length() : number);
    }
}