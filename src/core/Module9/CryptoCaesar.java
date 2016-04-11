package core.module9;

/**
 * Created by vladi_000 on 1/26/2016.
 */
public class CryptoCaesar {

    private static int encription = 1;
    private static int decription = -1;

    private static String crypting(final String inputText, final int shiftingOfAlgorithm, int cryptoType, int amountOfAlphabet) throws CustomNullPointerException {
        StringBuilder outputText = new StringBuilder();
        if (inputText == null) {
            throw new CustomNullPointerException("Input text cannot be \"null\"");
        }
        for (char chr : inputText.toCharArray()) {
            outputText.append((char) (((int) chr + cryptoType * shiftingOfAlgorithm) % amountOfAlphabet));
        }
        return outputText.toString();
    }


    public static String encrypting(final String inputText, final int shiftingOfAlgorithm, int amountOfAlphabet) throws CustomNullPointerException {
        return crypting(inputText, shiftingOfAlgorithm, encription, amountOfAlphabet);
    }

    public static String decrypting(final String inputText, final int shiftingOfAlgorithm, int amountOfAlphabet) throws CustomNullPointerException {
        return crypting(inputText, shiftingOfAlgorithm, decription, amountOfAlphabet);
    }

}
