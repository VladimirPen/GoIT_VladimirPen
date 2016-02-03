package Module9;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by corner on 02.02.2016.
 */
public class CryptoCaesarTest {

    final static int shiftingOfAlgorithm = 32;
    final static int amountOfAlphabet = 256;


    @Test(timeout = 1000)
    public void cryptoCaesarTest() throws Exception {
        final String basicText = "abcdefghijklmn0987654321";
        String encyptingText = CryptoCaesar.encrypting(basicText, shiftingOfAlgorithm, amountOfAlphabet);
        assertNotEquals(basicText, encyptingText);
        String decyptingText = CryptoCaesar.decrypting(encyptingText, shiftingOfAlgorithm, amountOfAlphabet);
        assertEquals(decyptingText, basicText);
    }


}