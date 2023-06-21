package fileSaver.processors;

import java.io.FileWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import fileSaver.processors.interfaces.IFileSaver;
import modules.harborDistance.HarborDistanceController;
import modules.harborDistance.entities.interfaces.IHarborDistanceReadable;

public class FileSaveHarborDistanceProcessor extends BaseFileSaverProcessor implements IFileSaver {

    private HarborDistanceController harborDistanceController;
    private ObjectMapper objectMapper;
    private FileWriter fileWriter;

    public FileSaveHarborDistanceProcessor(String fileName) throws Exception {
        super(fileName);
        this.harborDistanceController = new HarborDistanceController();
        this.objectMapper = new ObjectMapper();
        this.fileWriter = new FileWriter(getFilePath());
    }

    @Override
    public void saveFile() throws Exception {
        List<IHarborDistanceReadable> harborDistances = harborDistanceController.onFindAll();
        fileWriter.write("[\n");

        for (int i = 0; i < harborDistances.size(); i++) {
            IHarborDistanceReadable harborDistance = harborDistances.get(i);
            String harborDistanceJson = objectMapper.writeValueAsString(harborDistance);
            fileWriter.write(harborDistanceJson);

            if (i < harborDistances.size() - 1) {
                fileWriter.write(",\n");
            }
        }

        fileWriter.write("\n]");

        fileWriter.close();
    }

}
