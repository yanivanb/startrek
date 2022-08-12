package be.vdab.startrek.domain;

import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

public class Werknemer {
    private final long id;
    private final String naam;
    private final String familienaam;
    @NumberFormat(pattern = "0.00") private final BigDecimal budget;
    private final String foto;

    public Werknemer(long id, String naam, String familienaam, BigDecimal budget, String foto) {
        this.id = id;
        this.naam = naam;
        this.familienaam = familienaam;
        this.budget = budget;
        this.foto = foto;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public String getFoto() {
        return foto;
    }
}
