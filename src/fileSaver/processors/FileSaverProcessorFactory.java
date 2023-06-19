package fileSaver.processors;

import java.util.HashMap;
import java.util.Map;

import fileSaver.processors.interfaces.IFileSaver;

public class FileSaverProcessorFactory {

    private Map<String, Class<? extends IFileSaver>> processorSelector;

    public FileSaverProcessorFactory() {
        this.processorSelector = new HashMap<>();

        this.processorSelector.put("cargo", FileSaveCargoProcessor.class);
        this.processorSelector.put("cargoType", FileSaveCargoTypeProcessor.class);
        this.processorSelector.put("client", FileSaveClientProcessor.class);
        this.processorSelector.put("harbor", FileSaveHarborProcessor.class);
        this.processorSelector.put("harborDistance", FileSaveHarborDistanceProcessor.class);
        this.processorSelector.put("ship", FileSaveShipProcessor.class);
        this.processorSelector.put("freight", FileSaveFreightProcessor.class);
    }

    public Class<? extends IFileSaver> getFileSaverProcessor(String fileType) {
        return processorSelector.get(fileType);
    }

}
