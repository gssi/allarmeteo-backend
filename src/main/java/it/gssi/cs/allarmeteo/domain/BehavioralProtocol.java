package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;

@Embeddable
public class BehavioralProtocol {
    @Column(name = "behavioral_protocol_name", nullable = false)
    private String name;

    @Lob
    @Column(name = "behavioral_protocol_description", nullable = false)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}