package it.gssi.cs.allarmeteo.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("dam_operators")
public class DamOperator extends User {}
