package com.javarush.dobrov.DAO;

import com.javarush.dobrov.entity.Language;
import org.hibernate.SessionFactory;

public class LanguageDAO extends DAO<Language> {
    public LanguageDAO(Class<Language> clazzToSet, SessionFactory sessionFactory) {
        super(clazzToSet, sessionFactory);
    }
}
