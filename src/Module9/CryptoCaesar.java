package Module9;

/**
 * Created by vladi_000 on 1/26/2016.
 */
public class CryptoCaesar {

    private static int encription = 1;
    private static int decription = -1;

    private static String crypting(final String inputText, final int shiftinOfAlgoritm, int cryptoType, int amountOfAlphabet) throws NullPointerException {
        StringBuilder outputText = new StringBuilder();
        for (char chr : inputText.toCharArray()) {
            outputText.append((char) (((int) chr + cryptoType * shiftinOfAlgoritm) % amountOfAlphabet));
        }
        return outputText.toString();
    }


    public static String encrypting(final String inputText, final int shiftinOfAlgoritm, int amountOfAlphabet
    ) {
        return crypting(inputText, shiftinOfAlgoritm, encription, amountOfAlphabet);
    }

    public static String decrypting(final String inputText, final int shiftinOfAlgoritm, int amountOfAlphabet) {
        return crypting(inputText, shiftinOfAlgoritm, decription, amountOfAlphabet);
    }

}
