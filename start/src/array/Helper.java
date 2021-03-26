package array;

import java.util.Arrays;

public class Helper {
    public static void main(String[] args) {
        
        System.out.println(Arrays.equals(new int[]{1, 2, 3}, new int[]{1, 2}));  
        
        System.out.println(Arrays.toString(new int[]{1, 2, 3}));

        int[] a = new int[]{1, 9, 10, 100, 9, 8};

        Arrays.sort(a);
        
        System.out.println(Arrays.toString(a));
    }
}