package Module10;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;

import static org.junit.Assert.*;

/**
 * Created by corner on 02.02.2016.
 */
public class CustomOutputStreamTest {

    final static String textForTest = "testtest";

    @Test
    public void testWrite() throws Exception {
        CustomOutputStream customOutputStream = new CustomOutputStream(new FileWriter("resources\\textInOutModule10.txt"), Module10.shiftingOfAlgorithm, Module10.amountOfAlphabet);
        customOutputStream.write(textForTest);
        customOutputStream.close();
    }
}