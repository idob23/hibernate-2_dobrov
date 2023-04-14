package com.javarush.dobrov.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@SuppressWarnings("ALL")
@Entity
@Table(schema = "movie", name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short country_id;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime last_update;

    public Short getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Short country_id) {
        this.country_id = country_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }
}
