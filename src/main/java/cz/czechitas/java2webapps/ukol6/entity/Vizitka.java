package cz.czechitas.java2webapps.ukol6.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
public class Vizitka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 100)
    @NotBlank
    private String celeJmeno;

    @Length(max = 100)
    @NotBlank
    private String firma;

    @Length(max = 200)
    @NotBlank
    private String ulice;

    @Length(max = 200)
    @NotBlank
    private String obec;

    @Length(max = 200)
    @NotBlank
    private String psc;

    @Length(max = 100)
    @Email
    private String email;

    @Length(min = 9, max = 13)
    @Pattern(regexp = "\\+?\\d+")
    private String telefon;

    @Length(max = 100)
    @NotBlank
    private String web;

    public Vizitka() {
    }

    public Vizitka(Long id, String celeJmeno, String firma, String ulice, String obec, String psc, String email, String telefon, String web) {
        this.id = id;
        this.celeJmeno = celeJmeno;
        this.firma = firma;
        this.ulice = ulice;
        this.obec = obec;
        this.psc = psc;
        this.email = email;
        this.telefon = telefon;
        this.web = web;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCeleJmeno() {
        return celeJmeno;
    }

    public void setCeleJmeno(String celeJmeno) {
        this.celeJmeno = celeJmeno;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getObec() {
        return obec;
    }

    public void setObec(String obec) {
        this.obec = obec;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getCelaAdresa() {
        return ulice + ", " + psc + " " + obec;
    }
}
