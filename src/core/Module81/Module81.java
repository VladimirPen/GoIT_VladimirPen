package core.module81;

import core.module61.File;

/**
 * Created by vladi_000 on 1/19/2016.
 */
public class Module81 {

    public static void main(String[] args) {
        CustomArrayList<File> arr = new CustomArrayList<File>(File.class);
        arr.add(new File("eee.txt"));
        arr.add(new File("zzz.mp3"));
        arr.add(new File("www.jpg"));
        arr.add(new File("aaa.doc"));
        System.out.println(arr.toString());
        arr.sort();
        System.out.println(arr.toString());
        arr.sort(arr.desc);
        System.out.println(arr.toString());




    }
}
