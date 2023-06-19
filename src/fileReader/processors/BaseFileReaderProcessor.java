package fileReader.processors;

public class BaseFileReaderProcessor {

    private String fileName;
    private String fileReadType;
    private String filePath;

    public BaseFileReaderProcessor(String fileName) {
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
