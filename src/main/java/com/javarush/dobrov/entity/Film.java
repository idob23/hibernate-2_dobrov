package com.javarush.dobrov.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Set;

@SuppressWarnings("ALL")
@Entity
@Table(schema = "movie", name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short film_id;
    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "text")
    @Type(type = "text")
    private String description;
    @Column(columnDefinition = "year")
    @Convert(converter = YearConverter.class)
    private Year release_year;
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language_id;
    @ManyToOne
    @JoinColumn(name = "original_language_id")
    private Language original_language_id;
    @Column(nullable = false)
    private Byte rental_duration;
    @Column(nullable = false)
    private BigDecimal rental_rate;
    private Short length;
    @Column(nullable = false)
    private BigDecimal replacement_cost;
    @Column(columnDefinition = "enum('G', 'PG', 'PG-13', 'R', 'NC-17')")
    @Convert(converter = RatingConverter.class)
    private Rating rating;
    @Column(columnDefinition = "set('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')")
    private String special_features;
    @UpdateTimestamp
    private LocalDateTime last_update;
    @ManyToMany
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id")
    )
    private Set<Actor> actors;

    @ManyToMany
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "film_id",referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id",referencedColumnName = "category_id")
    )
    private Set<Category> categories;

    public String getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Short film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Year getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Year release_year) {
        this.release_year = release_year;
    }

    public Language getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(Language language_id) {
        this.language_id = language_id;
    }

    public Language getOriginal_language_id() {
        return original_language_id;
    }

    public void setOriginal_language_id(Language original_language_id) {
        this.original_language_id = original_language_id;
    }

    public int getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(Byte rental_duration) {
        this.rental_duration = rental_duration;
    }

    public BigDecimal getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(BigDecimal rental_rate) {
        this.rental_rate = rental_rate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    public BigDecimal getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(BigDecimal replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
//
//    public Set<Feature> getSpecial_feature() {
//        if(special_features==null){
//            return null;
//        }
//        Set<Feature>set = new HashSet<>();
//        String[] split = special_features(",");
//        for (String s : split) {
//            set.add(Feature.getFeatureByValue(s));
//        }
//        return set;
//    }
//
//    public void setSpecial_feature(Set<Feature> special_feature) {
//        if(special_feature==null){
//            special_feature = null;
//        }else {
//            special_feature.stream().map(Feature::getValue).collect(Collectors.joining(","));
//        }
//    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
