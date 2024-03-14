package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("citizens")
public class Citizen extends User {}
