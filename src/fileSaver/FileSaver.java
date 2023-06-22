package fileSaver;

import java.lang.reflect.Constructor;

import fileSaver.processors.FileSaverProcessorFactory;
import fileSaver.processors.interfaces.IFileSaver;
import shared.errors.BaseRunTimeException;
import shared.errors.FileTypeNotFound;
import shared.errors.WritingFileError;

public class FileSaver {
    private FileSaverProcessorFactory fileSaverProcessorFactory;

    public FileSaver() {
        this.fileSaverProcessorFactory = new FileSaverProcessorFactory();
    }

    public void saveFile(String fileName, String fileType) {
        Class<? extends IFileSaver> fileSaverProcessor = this.fileSaverProcessorFactory
                .getFileSaverProcessor(fileType);
        if (fileSaverProcessor == null) {
            throw new FileTypeNotFound();
        }

        try {
            Constructor<? extends IFileSaver> constructor = fileSaverProcessor.getConstructor(String.class);
            IFileSaver fileSaver = constructor.newInstance(fileName);
            fileSaver.saveFile();
        } catch (BaseRunTimeException e) {
            throw e;
        } catch (Exception e) {
            throw new WritingFileError();
        }

    }
}
