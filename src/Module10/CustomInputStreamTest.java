package Module10;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by corner on 02.02.2016.
 */
public class CustomInputStreamTest {

    @Test
    public void testReadLine() throws Exception {
        try {
            String readline;
            CustomInputStream customInputStream = new CustomInputStream(new FileReader("resources\\textInOutModule10.txt"), Module10.shiftingOfAlgorithm, Module10.amountOfAlphabet);
            while ((readline = customInputStream.readLine()) != null) {
            }
            customInputStream.close();
            assertTrue(true);
        }
        catch (IOException e)
        {
            assertTrue(e.getMessage(),false);
        }
    }
}