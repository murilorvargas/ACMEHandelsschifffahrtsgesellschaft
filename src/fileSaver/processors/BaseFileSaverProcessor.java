package fileSaver.processors;

public class BaseFileSaverProcessor {

    private String fileName;
    private String fileReadType;
    private String filePath;

    public BaseFileSaverProcessor(String fileName) {
        this.fileName = fileName;
        this.filePath = "files/" + fileName + ".CSV";
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileReadType() {
        return fileReadType;
    }

    public String getFilePath() {
        return filePath;
    }
}
