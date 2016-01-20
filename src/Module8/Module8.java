package Module8;

import Module6.Module61.File;

/**
 * Created by vladi_000 on 1/19/2016.
 */
public class Module8 {


    public static void main(String[] args) {
        CustomArrayList<File> arr = new CustomArrayList<File>(File.class);
        arr.add(new File("asdas.txt"));
        arr.add(new File("asasdfas.mp3"));
        arr.add(new File("aswdf.jpg"));
        arr.add(new File("ttt.doc"));
        System.out.println(arr.toString());
    }
}
