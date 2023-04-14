package com.javarush.dobrov.DAO;

import com.javarush.dobrov.entity.Store;
import org.hibernate.SessionFactory;

public class StoreDAO extends DAO<Store> {


    public StoreDAO(Class<Store> clazzToSet, SessionFactory sessionFactory) {
        super(clazzToSet, sessionFactory);
    }


}
