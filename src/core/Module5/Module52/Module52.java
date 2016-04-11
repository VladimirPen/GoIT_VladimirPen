package core.module5.Module52;

import java.util.Arrays;

/**
 * Created by corner on 24.12.2015.
 */
public class Module52 {

    public static void main(String... args) {
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(ArraySort.Sort(arr));
        System.out.println(Arrays.toString(arr));

    }
}