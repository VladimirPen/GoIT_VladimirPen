package Module9;

import Module6.Module61.File;
import Module8.Module81.CustomArrayList;

/**
 * Created by vladi_000 on 1/26/2016.
 */
public class Module9 {

    private static int amountOfAlphabet = 256;

    public static void main(String[] args) {
        CustomArrayList<File> arr = new CustomArrayList<File>(File.class);
        arr.add(new File("eee.txt"));
        arr.add(new File("zzz.mp3"));
        arr.add(new File("www.jpg"));
        arr.add(new File("aaa.doc"));
        int shiftingOfAlgoritm = 10;
        String encryptionText = null;
        String inpitText = Math.random() > 0.5 ? arr.toString() : null;
        String decriptionText = null;
        try {
            encryptionText = CryptoCaesar.encrypting(inpitText, shiftingOfAlgoritm, amountOfAlphabet);
            decriptionText = CryptoCaesar.decrypting(encryptionText, shiftingOfAlgoritm, amountOfAlphabet);
            System.out.println("Encryption text\n" + encryptionText);
            System.out.println("Decryption text\n" + decriptionText);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
