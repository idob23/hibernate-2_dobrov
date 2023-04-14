package com.javarush.dobrov.DAO;

import com.javarush.dobrov.entity.Address;
import org.hibernate.SessionFactory;

public class AddressDAO extends DAO<Address> {
    public AddressDAO(Class<Address> clazzToSet, SessionFactory sessionFactory) {
        super(clazzToSet, sessionFactory);
    }
}
