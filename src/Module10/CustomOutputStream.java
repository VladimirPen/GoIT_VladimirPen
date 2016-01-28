package Module10;


import Module9.CryptoCaesar;
import Module9.CustomNullPointerException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by corner on 28.01.2016.
 */
public class CustomOutputStream extends BufferedWriter {

    private int shiftingOfAlgorithm;
    private int amountOfAlphabet;

    public CustomOutputStream(Writer out, int shiftingOfAlgorithm, int amountOfAlphabet) {
        super(out);
        this.shiftingOfAlgorithm = shiftingOfAlgorithm;
        this.amountOfAlphabet = amountOfAlphabet;
    }

    @Override
    public void write(String str) throws IOException {
        try {
            super.write(CryptoCaesar.encrypting(str, shiftingOfAlgorithm, amountOfAlphabet));
        } catch (CustomNullPointerException e) {
        }
    }
}
