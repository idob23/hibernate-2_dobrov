package com.javarush.dobrov.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@SuppressWarnings("ALL")
@Entity
@Table(schema = "movie", name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte category_id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime last_update;

    @ManyToMany
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "category_id",referencedColumnName = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id",referencedColumnName = "film_id")
    )
    private Set<Film> films;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Byte category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
