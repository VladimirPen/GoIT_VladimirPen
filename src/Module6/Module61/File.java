package Module6.Module61;

/**
 * Created by corner on 14.12.2015.
 */
public class File extends java.io.File {

    private FileType extension;

    public FileType getExtension() {/*BoatAnchor. No using method should be removed*/
        return extension;
    }

    public static FileType getExtension(String fileName) {
        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }
        /*HardCode. The list of extensions should be got from file of parameter*/
        switch (extension) {
            case "bmp":
            case "gif":
            case "jpg":
            case "png":
            case "psd":
            case "pspimage":
            case "thm":
            case "tif":
            case "yuv":
                return FileType.IMAGE;
            case "aif":
            case "iff":
            case "m3uv":
            case "m4a":
            case "mid":
            case "mp3":
            case "mpa":
            case "ra":
            case "wav":
            case "wma":
                return FileType.AUDIO;
            case "doc":
            case "docx":
            case "log":
            case "msg":
            case "pages":
            case "rtf":
            case "txt":
            case "wpd":
            case "wps":
                return FileType.TEXT;
            default:
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
