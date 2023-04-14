package com.javarush.dobrov.DAO;

import com.javarush.dobrov.entity.Film;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class FilmDAO extends DAO<Film>{
    public FilmDAO(Class<Film> clazzToSet, SessionFactory sessionFactory) {
        super(clazzToSet, sessionFactory);
    }

    public Film getFilm() {
        Query<Film> query = getCurrentSession().createQuery("select f from Film f where f.film_id not in(select distinct film.film_id from Inventory )", Film.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
