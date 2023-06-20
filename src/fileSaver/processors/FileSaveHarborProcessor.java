package fileSaver.processors;

import java.io.FileWriter;
import java.util.List;

import fileSaver.processors.interfaces.IFileSaver;
import modules.harbor.HarborController;
import modules.harbor.entities.interfaces.IHarborReadable;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileSaveHarborProcessor extends BaseFileSaverProcessor implements IFileSaver {

    private HarborController harborController;
    private ObjectMapper objectMapper;
    private FileWriter fileWriter;

    public FileSaveHarborProcessor(String fileName) throws Exception {
        super(fileName);
        this.harborController = new HarborController();
        this.objectMapper = new ObjectMapper();
        this.fileWriter = new FileWriter(getFilePath());
    }

    @Override
    public void saveFile() throws Exception {
        List<IHarborReadable> harbors = this.harborController.onFindAllHarbors();

        fileWriter.write("[\n");

        for (int i = 0; i < harbors.size(); i++) {
            IHarborReadable harbor = harbors.get(i);
            String harborJson = objectMapper.writeValueAsString(harbor);
            fileWriter.write(harborJson);

            if (i < harbors.size() - 1) {
                fileWriter.write(",\n");
            }
        }

        fileWriter.write("\n]");

        fileWriter.close();
    }

}
