package shared.errors;

public class BaseRunTimeException extends RuntimeException {
    private String translation;
    private String description;
    private String title;
    private String code;

    public BaseRunTimeException(String translation, String description, String title, String code) {
        super(title);
        this.translation = translation;
        this.description = description;
        this.title = title;
        this.code = code;
    }

    public String getTranslation() {
        return translation;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }
}
