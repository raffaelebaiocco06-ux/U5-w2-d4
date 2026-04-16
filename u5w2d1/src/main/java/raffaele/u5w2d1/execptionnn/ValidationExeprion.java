package raffaele.u5w2d1.execptionnn;

import java.util.List;

public class ValidationExeprion extends RuntimeException {
    private List<String> errors;

    public ValidationExeprion(String message) {
        super(message);
    }
    public ValidationExeprion(List<String> errors) {
        super("Errori di validazione");
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
