package Module7;

import java.util.Random;

/**
 * Created by corner on 19.01.2016.
    Boat anchor
    Copy-and-Paste
    Magic numbers
 */
public class TaxCalculation {

    /*Boat anchor*/
    public static void fillArray(float[] arr)
    {
        final Random  rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextFloat();
        }
    }

    public static void main(String[] args) {
        //Copy-and-Paste
        float[] amount1 = {234, 523, 234, 234, 5785, 234, 6234, 542, 42546, 84543};
        int[] taxCategory1 = {0, 2, 32, 21, 2, 0, 3, 1, 2, 1};
        /* Magic numbers
        0 - tax free
        1 - 6% taxation
        2 - 12% taxation
        3 - 20% taxation
        other  - 25% taxation
         */
        float tax = 0;
        for (int i = 0; i < amount1.length; i++) {
            switch (taxCategory1[i]) {
                case 0:tax += amount1[i] * 0;/*HardCode*/
                break;
                case 1:tax += amount1[i] * 0.06;/*HardCode*/
                break;
                case 2:tax += amount1[i] * 0.12;/*HardCode*/
                break;
                case 3:tax += amount1[i] * 0.20;/*HardCode*/
                break;
                default:
                    tax += amount1[i] * 0.25;/*HardCode*/
            }

        }
        System.out.println(tax);
        /**********************************************/
        float[] amount2 = {535, 3456, 234, 2364, 4567, 2345, 23, 6, 675, 5623, 467, 452, 34};
        int[] taxCategory2 = {0, 0, 0, 1, 2, 1, 4, 2, 5, 2, 1, 0, 2};
        tax = 0;
        for (int i = 0; i < amount2.length; i++) {
            switch (taxCategory2[i]) {
                case 0:tax += amount2[i] * 0;/*HardCode*/
                    break;
                case 1:tax += amount2[i] * 0.06;/*HardCode*/
                    break;
                case 2:tax += amount2[i] * 0.12;/*HardCode*/
                    break;
                case 3:tax += amount2[i] * 0.20;/*HardCode*/
                    break;
                default:
                    tax += amount2[i] * 0.25;/*HardCode*/
            }

        }
        System.out.println(tax);
        /**********************************************/
        float[] amount3 = {1234, 545, 56734, 34563, 67546, 746, 454, 52345, 46, 456, 345, 34, 52345, 23, 54};
        int[] taxCategory3 = {1, 1, 2, 2, 1, 1, 3, 4, 2, 1, 0, 2, 1, 2, 3};
        tax = 0;
        for (int i = 0; i < amount3.length; i++) {
            switch (taxCategory3[i]) {
                case 0:tax += amount3[i] * 0;/*HardCode*/
                    break;
                case 1:tax += amount3[i] * 0.06;/*HardCode*/
                    break;
                case 2:tax += amount3[i] * 0.12;/*HardCode*/
                    break;
                case 3:tax += amount3[i] * 0.20;/*HardCode*/
                    break;
                default:
                    tax += amount3[i] * 0.25;/*HardCode*/
            }

        }
        System.out.println(tax);
    }

}
