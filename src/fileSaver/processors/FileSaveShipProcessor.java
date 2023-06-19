package fileSaver.processors;

import fileSaver.processors.interfaces.IFileSaver;
import modules.ship.ShipController;

public class FileSaveShipProcessor extends BaseFileSaverProcessor implements IFileSaver {

    private ShipController shipController;

    public FileSaveShipProcessor(String fileName) {
        super(fileName);
        this.shipController = new ShipController();
    }

    @Override
    public void saveFile() throws Exception {
        // TODO save ship file
    }
}
