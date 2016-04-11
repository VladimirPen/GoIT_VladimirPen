package core.module10;

import java.io.*;
import java.util.Scanner;

/**
 * Created by corner  on 28.01.2016.
 */
public class Module10 {

    private static final String commandExit = "EXIT";
    private static final String commandRead = "READ";
    private static final String commandWrite = "WRITE";
    private static final String commandFinish = "\\FINISH";

    static int shiftingOfAlgorithm = 15;
    static int amountOfAlphabet = 265;

    private static String enterWithDescription(final Scanner sc, String desc) {
        System.out.print(desc);
        return sc.nextLine();
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String enteredRow = null;
        String fileName = null;
        try {
            while (!(enteredRow = enterWithDescription(scanner, "Enter command (READ,WRITE,EXIT): ")).toUpperCase().equals(commandExit)) {

                if (enteredRow.toUpperCase().equals(commandWrite)) {
                    fileName = enterWithDescription(scanner, "Enter name of file : ");
                    CustomOutputStream customOutputStream = null;
                    try {
                        customOutputStream = new CustomOutputStream(new FileWriter(fileName), shiftingOfAlgorithm, amountOfAlphabet);
                        while (!(enteredRow = enterWithDescription(scanner, "Enter rows(print \\FINISH when the entering will completed): ")).toUpperCase().equals(commandFinish)) {
                            customOutputStream.write(enteredRow + "\n");
                        }
                    } finally {
                        if (customOutputStream != null) {
                            customOutputStream.close();
                        }
                    }
                } else if (enteredRow.toUpperCase().equals(commandRead)) {
                    fileName = enterWithDescription(scanner, "Enter name of file : ");
                    CustomInputStream customInputStream = null;
                    try {
                        customInputStream = new CustomInputStream(new FileReader(fileName), shiftingOfAlgorithm, amountOfAlphabet);
                        String readline = null;
                        while ((readline = customInputStream.readLine()) != null) {
                            System.out.print(readline);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found");
                    } finally {
                        if (customInputStream != null) {
                            customInputStream.close();
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
