package fileReader.processors;

import java.util.HashMap;
import java.util.Map;

import fileReader.processors.interfaces.IFileReader;

public class FileReaderProcessorFactory {
    private Map<String, Class<? extends IFileReader>> processorSelector;

    public FileReaderProcessorFactory() {
        this.processorSelector = new HashMap<>();

        this.processorSelector.put("cargo", FileReadCargoProcessor.class);
        this.processorSelector.put("cargoType", FileReadCargoTypeProcessor.class);
        this.processorSelector.put("client", FileReadClientProcessor.class);
        this.processorSelector.put("harbor", FileReadHarborProcessor.class);
        this.processorSelector.put("harborDistance", FileReadHarborDistanceProcessor.class);
        this.processorSelector.put("ship", FileReadShipProcessor.class);
    }

    public Class<? extends IFileReader> getFileReaderProcessor(String fileType) {
        return processorSelector.get(fileType);
    }
}
