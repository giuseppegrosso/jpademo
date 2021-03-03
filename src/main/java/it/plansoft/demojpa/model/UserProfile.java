package it.plansoft.demojpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
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

    @OneToOne(fetch = FetchType.LAZY)
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

    public void setId(Long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public User getUser() {
        return user;
    }
}
