package Module6.Module61;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Module6.Module61.Command.*;

/**
 * Created by corner on 29.12.2015.
 */
public class Module61 {

    private static List<Command> listOfCommand = Arrays.asList(Command.values());

    private static String enterWithDescription(final Scanner sc, String desc) {
        System.out.print(desc);
        return sc.nextLine();
    }

    public static void main(String[] args) {

        final Directory dir = new Directory();
        final Scanner sc = new Scanner(System.in);
        String fileName = null;
        String command = null;
        while (!(command = enterWithDescription(sc, "Enter command for the file : ")).toUpperCase().equals(EXIT.toString())) {
            try {
                switch (Command.valueOf(command.toUpperCase())) {
                    case ADD:
                        fileName = enterWithDescription(sc, "Enter filename : ");
                        dir.add(fileName);
                        break;
                    case CREATE:
                        fileName = enterWithDescription(sc, "Enter filename : ");
                        dir.create(fileName);
                        break;
                    case REMOVE:
                        fileName = enterWithDescription(sc, "Enter filename : ");
                        dir.remove(new File(fileName));
                        break;
                    case PRINT:
                        dir.printDir();
                        break;
                }
            } catch (FileNotExistsException e) {
                System.out.println("Not existing file cannot be remover");
            } catch (FileNotFoundException e) {
                System.out.println("File \"" + fileName + "\" is not exits. You can create it.");
            } catch (NullPointerException e) {
                System.out.println("File cannot exists with empty name");
            } catch (IllegalArgumentException e) {
                System.out.println("You can use following command only(no case sensitive) : " + listOfCommand.toString());
            }
        }
        dir.printDir();

    }


}
