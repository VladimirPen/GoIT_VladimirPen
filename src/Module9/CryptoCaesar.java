package Module9;

/**
 * Created by vladi_000 on 1/26/2016.
 */
public class CryptoCaesar {

    private static int encrintion = 1;
    private static int decrintion = -1;

    private static String crypting(final String inputText, final int shiftinOfAlgoritm, int cryptoType) {
        StringBuilder outputText = new StringBuilder();
        for (char chr : inputText.toCharArray()) {
            outputText.append((char) (((int) chr + cryptoType * shiftinOfAlgoritm) % 256));
        }
        return outputText.toString();
    }


    public static String encrinting(final String inputText, final int shiftinOfAlgoritm) {
        return crypting(inputText, shiftinOfAlgoritm, encrintion);
    }

    public static String decrinting(final String inputText, final int shiftinOfAlgoritm) {
        return crypting(inputText, shiftinOfAlgoritm, decrintion);
    }

}
