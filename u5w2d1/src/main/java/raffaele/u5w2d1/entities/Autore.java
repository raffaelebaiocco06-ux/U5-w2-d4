package raffaele.u5w2d1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "autori")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Autore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate nascita;

    @Column(nullable = false)
    private String avatar;

    public Autore(String nome, String cognome, String email, LocalDate nascita, String avatar) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.nascita = nascita;
        this.avatar = avatar;
    }
}
