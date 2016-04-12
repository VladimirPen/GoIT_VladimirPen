package core.module5.Module51;


public class MaxMin {

    public static int max(int... arr) {
        try {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            return max;
        } catch (NullPointerException e) {
            System.out.println("Array is null");
            throw e;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Array is empty");
            throw e;
        }
    }

    public static int min(int... arr) {
        try {
            int min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            return min;
        } catch (NullPointerException e) {
            System.out.println("Array is null");
            throw e;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Array is empty");
            throw e;
        }
    }

}
