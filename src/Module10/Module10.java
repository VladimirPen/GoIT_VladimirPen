package Module10;

import java.io.*;
import java.util.Scanner;

/**
 * Created by corner on 28.01.2016.
 */
public class Module10 {

    private static final String commandExit = "EXIT";
    private static final String commandRead = "READ";
    private static final String commandWrite = "WRITE";
    private static final String commandFinish = "\\FINISH";

    private static int shiftingOfAlgorithm = 15;
    private static int amountOfAlphabet = 265;

    private static String enterWithDescription(final Scanner sc, String desc) {
        System.out.print(desc);
        return sc.nextLine();
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String enteredRow = null;
        String fileName = null;
        while (!(enteredRow = enterWithDescription(scanner, "Enter command (READ,WRITE,EXIT): ")).toUpperCase().equals(commandExit)) {

            if (enteredRow.toUpperCase().equals(commandWrite)) {
                fileName = enterWithDescription(scanner, "Enter name of file : ");
                CustomOutputStream customOutputStream = null;
                try {
                    customOutputStream = new CustomOutputStream(new FileWriter(fileName), shiftingOfAlgorithm, amountOfAlphabet);
                    while (!(enteredRow = enterWithDescription(scanner, "Enter rows(print \\FINISH when the entering will completed): ")).toUpperCase().equals(commandFinish)) {
                        customOutputStream.write(enteredRow + "\n");
                    }
                } catch (IOException e) {
                    System.out.println("IO exception. Check file");
                } finally {
                    try {
                        if (customOutputStream != null)
                        {
                            customOutputStream.close();
                        }
                    } catch (IOException e) {
                        System.out.println("IO exception. Check file");
                    }
                }
            } else if (enteredRow.toUpperCase().equals(commandRead)) {
                fileName = enterWithDescription(scanner, "Enter name of file : ");
                CustomInputStream customInputStream = null;
                try {
                    customInputStream = new CustomInputStream(new FileReader(fileName), shiftingOfAlgorithm, amountOfAlphabet);
                    String readline = null;
                    try {
                        while ((readline = customInputStream.readLine()) != null) {
                            System.out.print(readline);
                        }
                    } catch (IOException e) {
                        System.out.println("IO exception. Check file");
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found");
                } finally {
                    try {
                        if (customInputStream != null)
                        {
                            customInputStream.close();
                        }
                    } catch (IOException e) {
                        System.out.println("IO exception. Check file");
                    }

                }

            }
        }

    }
}
