package shared.errors;

public class FileTypeNotFound extends BaseRunTimeException {

    public FileTypeNotFound() {
        super("Nenhum arquivo com esse tipo encontrado",
                "No file found with that type",
                "File type not found", "HUSM0021");
    }

}