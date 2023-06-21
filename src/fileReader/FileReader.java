package fileReader;

import java.lang.reflect.Constructor;

import fileReader.processors.FileReaderProcessorFactory;
import fileReader.processors.interfaces.IFileReader;
import shared.errors.BaseRunTimeException;
import shared.errors.FileTypeNotFound;
import shared.errors.ReadingFileError;

public class FileReader {
    private FileReaderProcessorFactory fileReaderProcessorFactory;

    public FileReader() {
        this.fileReaderProcessorFactory = new FileReaderProcessorFactory();
    }

    public void readFile(String fileName, String fileType) {
        Class<? extends IFileReader> fileReaderProcessor = this.fileReaderProcessorFactory
                .getFileReaderProcessor(fileType);
        if (fileReaderProcessor == null) {
            throw new FileTypeNotFound();
        }

        try {
            Constructor<? extends IFileReader> constructor = fileReaderProcessor.getConstructor(String.class);
            IFileReader fileReader = constructor.newInstance(fileName);
            fileReader.readFile();
        } catch (BaseRunTimeException e) {
            throw e;
        } catch (Exception e) {
            System.out.println(e);
            throw new ReadingFileError();
        }

    }
}
