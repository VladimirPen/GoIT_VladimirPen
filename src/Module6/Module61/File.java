package Module6.Module61;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by corner on 14.12.2015.
 */
public class File extends java.io.File {

    private FileType extension;

    public static FileType getExtension(String fileName) {
        String extension = "";
        ParameterList prmLst = new ParameterList("resources\\extentions.properties");

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }

        if (Arrays.asList(prmLst.getParamValue("IMAGE").split("\\s*,\\s*")).contains(extension)) {
            return FileType.IMAGE;
        } else if (Arrays.asList(prmLst.getParamValue("AUDIO").split("\\s*,\\s*")).contains(extension)) {
            return FileType.AUDIO;
        } else if (Arrays.asList(prmLst.getParamValue("TEXT").split("\\s*,\\s*")).contains(extension)) {
            return FileType.TEXT;
        } else {
            return FileType.OTHER;

        }
    }

    public File(String fileName) throws NullPointerException {
        super(fileName);
        if (fileName.isEmpty()) {
            throw new NullPointerException();
        }
        extension = getExtension(fileName);
    }

}
