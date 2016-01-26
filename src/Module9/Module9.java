package Module9;

import Module6.Module61.File;
import Module8.Module81.CustomArrayList;

/**
 * Created by vladi_000 on 1/26/2016.
 */
public class Module9 {

    public static void main(String[] args) {
        CustomArrayList<File> arr = new CustomArrayList<File>(File.class);
        arr.add(new File("eee.txt"));
        arr.add(new File("zzz.mp3"));
        arr.add(new File("www.jpg"));
        arr.add(new File("aaa.doc"));
        int shiftinOfAlgoritm = 10;
        String encriptionText = CryptoCaesar.encrinting(arr.toString(), shiftinOfAlgoritm);
        System.out.println(encriptionText);
        encriptionText = CryptoCaesar.decrinting(encriptionText, shiftinOfAlgoritm);
        System.out.println(encriptionText);
    }
}
