package array;

public class Exchange {

    public static void main(String[] args) {
        
        int []array1, array2;
        array1 = new int[]{1, 2, 3, 4, 5, 6};
        array2 = new int[array1.length];

        // 方式一
        for (int i = 0; i < array1.length; i ++) {
            array2[i] = array1[array1.length - i - 1];
        }

        for (int i = 0; i < array1.length; i ++) {
            System.out.println("key = " + i + " value = " + array2[i]);
        }

        // 方式二
        int length = array1.length / 2;
        for (int i = 0; i < length; i ++) {
            int tmp = array1[i];
            array1[i] = array1[array1.length - i - 1];
            array1[array1.length - i - 1] = tmp;
        }

        for (int i = 0; i < array1.length; i ++) {
            System.out.println("key = " + i + " value = " + array1[i]);
        }
    }
}