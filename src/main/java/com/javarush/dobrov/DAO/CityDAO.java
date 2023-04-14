package com.javarush.dobrov.DAO;

import com.javarush.dobrov.entity.City;
import org.hibernate.SessionFactory;

public class CityDAO extends DAO<City> {


    public CityDAO(Class<City> clazzToSet, SessionFactory sessionFactory) {
        super(clazzToSet, sessionFactory);
    }
}
