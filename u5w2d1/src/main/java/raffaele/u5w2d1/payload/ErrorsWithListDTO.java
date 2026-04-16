package raffaele.u5w2d1.payload;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorsWithListDTO(String message, LocalDateTime timestamp, List<String> errors) {
}
