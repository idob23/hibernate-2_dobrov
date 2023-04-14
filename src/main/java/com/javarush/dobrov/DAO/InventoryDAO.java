package com.javarush.dobrov.DAO;

import com.javarush.dobrov.entity.Inventory;
import org.hibernate.SessionFactory;

public class InventoryDAO extends DAO<Inventory>{
    public InventoryDAO(Class<Inventory> clazzToSet, SessionFactory sessionFactory) {
        super(clazzToSet, sessionFactory);
    }

}
