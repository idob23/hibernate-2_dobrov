package com.javarush.dobrov.DAO;

import com.javarush.dobrov.entity.FilmText;
import org.hibernate.SessionFactory;

public class FilmTextDAO extends DAO<FilmText> {
    public FilmTextDAO(Class<FilmText> clazzToSet, SessionFactory sessionFactory) {
        super(clazzToSet, sessionFactory);
    }
}
