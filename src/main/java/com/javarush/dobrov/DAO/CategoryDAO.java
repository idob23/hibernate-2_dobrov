package com.javarush.dobrov.DAO;

import com.javarush.dobrov.entity.Category;
import org.hibernate.SessionFactory;

public class CategoryDAO extends DAO<Category> {
    public CategoryDAO(Class<Category> clazzToSet, SessionFactory sessionFactory) {
        super(clazzToSet, sessionFactory);
    }
}
