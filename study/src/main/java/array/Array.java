package array;

public class Array {

    public static void main(String[] args) {
        
        int []array1, array2;

        array1 = new int[]{1, 2, 3, 4, 5, 6};

        array2 = new int[array1.length];

        System.out.println("数组: array length = " + array1.length);

        for (int i = 0; i < array1.length; i++) {
            array2[i] = array1[i];
        }

        for (int i = 0; i < array2.length; i++) {
            System.out.println("数组 Array2 key = " + i + " value = " + array2[i]);
        }
    }


}