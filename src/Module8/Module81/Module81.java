package Module8.Module81;

import Module6.Module61.File;

import java.util.ArrayList;

/**
 * Created by vladi_000 on 1/19/2016.
 */
public class Module81 {

    private static <T extends Comparable> void sortArrayList(ArrayList<T> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(i).compareTo(arr.get(j)) > 0) {
                    T tmp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, tmp);
                }
            }
        }
    }


    public static void main(String[] args) {
        CustomArrayList<File> arr = new CustomArrayList<File>(File.class);
        arr.add(new File("eee.txt"));
        arr.add(new File("zzz.mp3"));
        arr.add(new File("www.jpg"));
        arr.add(new File("aaa.doc"));
        System.out.println(arr.toString());
        sortArrayList(arr);
        System.out.println(arr.toString());




    }
}
