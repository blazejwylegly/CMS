package com.wylegly.clinic.domain.procedures.details;

import javax.persistence.*;
import java.time.Duration;

@Entity
@Table(name = "dentalDetails")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class DentalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public DentalDetails() {

    }

    public abstract Double getCost();
    public abstract Duration getDuration();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + name;
    }
}
