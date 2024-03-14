package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("administrators")
public class Administrator extends User {}
