package fileSaver.processors;

import java.io.FileWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import fileSaver.processors.interfaces.IFileSaver;
import modules.ship.ShipController;
import modules.ship.entities.interfaces.IShipReadable;

public class FileSaveShipProcessor extends BaseFileSaverProcessor implements IFileSaver {

    private ShipController shipController;
    private ObjectMapper objectMapper;
    private FileWriter fileWriter;

    public FileSaveShipProcessor(String fileName) throws Exception {
        super(fileName);
        this.shipController = new ShipController();
        this.objectMapper = new ObjectMapper();
        this.fileWriter = new FileWriter(getFilePath());
    }

    @Override
    public void saveFile() throws Exception {
        List<IShipReadable> ships = shipController.onFindAllShips();
        fileWriter.write("[\n");

        for (int i = 0; i < ships.size(); i++) {
            IShipReadable ship = ships.get(i);
            String shipJson = objectMapper.writeValueAsString(ship);
            fileWriter.write(shipJson);

            if (i < ships.size() - 1) {
                fileWriter.write(",\n");
            }
        }

        fileWriter.write("\n]");

        fileWriter.close();
    }

}
