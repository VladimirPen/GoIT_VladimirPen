package core.module61;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Created by corner on 19.01.2016.
 */
public class ParameterList {

    private Properties aParamList = new Properties();

    public ParameterList(String PropFileName) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(PropFileName);
            aParamList.load(inputStream);
        } catch (FileNotFoundException e) {
            System.out.println("File parameter was not found. The extention of the fille will define wrong");
        }
        catch (IOException e) {
            System.out.println("File parameter was not found. The extention of the fille will define wrong");
        }
    }

    public String getParamValue(String ParamName) {

        return aParamList.getProperty(ParamName);
    }

}
