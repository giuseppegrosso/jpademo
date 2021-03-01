package it.plansoft.demojpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "user_profiles")
public class UserProfile extends BaseId<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "sesso", length = 10)
    private Gender gender;

    @Column(name = "telefono")
    private String numeroTelefono;

    @Column(name = "data_nascita")
    @Temporal(TemporalType.DATE)
    private Date dataNascita;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "citta")
    private String citta;

    @Column(name = "nazione")
    private String nazione;

    @Column(name = "cap")
    private String cap;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public UserProfile(Gender gender,
                       String numeroTelefono,
                       Date dataNascita,
                       String indirizzo,
                       String citta,
                       String nazione,
                       String cap) {
        this.gender = gender;
        this.numeroTelefono = numeroTelefono;
        this.dataNascita = dataNascita;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.nazione = nazione;
        this.cap = cap;
    }

    public UserProfile() {
    }
}
