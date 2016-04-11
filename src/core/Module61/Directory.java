package core.module61;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by corner on 11.12.2015.
 */
public class Directory {

    private ArrayList<File> listOfFiles = new ArrayList<File>();

    public Directory() {
    }

    public void create(final String fileName) throws FileNotFoundException {
        create(fileName, FileType.OTHER);
    }

    public void create(final String fileName, FileType fileType) throws NullPointerException {
        File file = null;
        switch (fileType) {
            case TEXT:
                file = new TextFile(fileName);
                break;
            case AUDIO:
                file = new AudioFile(fileName);
                break;
            case IMAGE:
                file = new ImageFile(fileName);
                break;
            default:
                file = new File(fileName);
                break;
        }
        listOfFiles.add(file);
    }

    public void add(final String fileName) throws NullPointerException, FileNotFoundException {
        add(fileName, File.getExtension(fileName));
    }

    public void add(final String fileName, FileType fileType) throws NullPointerException, FileNotFoundException {
        File file = null;
        switch (fileType) {
            case TEXT:
                file = new TextFile(fileName);
                break;
            case AUDIO:
                file = new AudioFile(fileName);
                break;
            case IMAGE:
                file = new ImageFile(fileName);
                break;
            default:
                file = new File(fileName);
                break;
        }
        if (file.exists() && !file.isDirectory()) {
            listOfFiles.add(file);
        } else {
            throw new FileNotFoundException(fileName);
        }
    }

    public void remove(final File file) throws FileNotExistsException {
        if (!listOfFiles.remove(file)) {
            throw new FileNotExistsException(file.getName());
        }
        ;
    }

    public void printDir() {
        System.out.println("------------------------------------------------");
        for (File file : listOfFiles) {
            System.out.println(file.getClass().getName() + " " + file.getName());
        }
        System.out.println("------------------------------------------------");
        System.out.println("            " + listOfFiles.size() + " files");


    }

}
