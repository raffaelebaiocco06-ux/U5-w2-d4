package raffaele.u5w2d1.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AutoreDTO(
        @NotBlank(message = "Il nome proprio è obbligatorio e non può essere una stringa vuota")
        @Size(min = 2, max = 30, message = "Il nome proprio deve essere compreso tra i 2 e i 30 caratteri")
        String nome,
        @NotBlank(message = "Il nome proprio è obbligatorio e non può essere una stringa vuota")
        @Size(min = 2, max = 30, message = "Il nome proprio deve essere compreso tra i 2 e i 30 caratteri")
        String cognome,
        @NotBlank(message = "L'email è obbligatoria e non può essere una stringa vuota")
        @Email(message = "L'email inserita non è nel formato corretto")
        String email,
        @Past
        LocalDate nascita,
        String avatar
) {

}
