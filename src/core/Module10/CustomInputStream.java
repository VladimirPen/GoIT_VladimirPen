package core.module10;


import core.module9.CryptoCaesar;
import core.module9.CustomNullPointerException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by corner on 28.01.2016.
 */
public class CustomInputStream extends BufferedReader {

    private int shiftingOfAlgorithm;
    private int amountOfAlphabet;

    public CustomInputStream(Reader in, int shiftingOfAlgorithm, int amountOfAlphabet) {
        super(in);
        this.shiftingOfAlgorithm = shiftingOfAlgorithm;
        this.amountOfAlphabet = amountOfAlphabet;
    }

    @Override
    public String readLine() throws IOException {
        String readLine = super.readLine();
        try {
            return CryptoCaesar.decrypting(readLine, shiftingOfAlgorithm, amountOfAlphabet);
        } catch (CustomNullPointerException e) {
            System.out.print("Empty row cannot be decoded");
            return null;
        }
    }


}
