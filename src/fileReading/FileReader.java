package fileReading;

public class FileReader {

    private String fileName;
    private String fileReadType;
    private String filePath;

    public FileReader(String fileName) {
        this.fileName = fileName;
        this.filePath = fileName + ".csv";
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
