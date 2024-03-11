package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;

@Entity
@DiscriminatorValue("fire")
public class FireBulletin extends CriticalityBulletin {
    @Lob
    @Column(name = "synoptic_situation")
    private String synopticSituation;

    @Embedded
    private FireForecast forecast;

    public String getSynopticSituation() {
        return synopticSituation;
    }

    public void setSynopticSituation(String synopticSituation) {
        this.synopticSituation = synopticSituation;
    }

    public FireForecast getForecast() {
        return forecast;
    }

    public void setForecast(FireForecast forecast) {
        this.forecast = forecast;
    }
}
