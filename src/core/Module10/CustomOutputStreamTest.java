package core.module10;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by corner on 02.02.2016.
 */
public class CustomOutputStreamTest {

    final static String textForTest = "testtest";

    @Test
    public void testWrite() throws Exception {
        try {
            CustomOutputStream customOutputStream = new CustomOutputStream(new FileWriter("resources\\textInOutModule10.txt"), Module10.shiftingOfAlgorithm, Module10.amountOfAlphabet);
            customOutputStream.write(textForTest);
            customOutputStream.close();
            assertTrue(true);
        } catch (IOException e) {
            assertTrue(e.getMessage(), false);
        }
    }
}