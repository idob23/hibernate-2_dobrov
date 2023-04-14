package com.javarush.dobrov.DAO;

import com.javarush.dobrov.entity.Customer;
import org.hibernate.SessionFactory;

public class CustomerDAO extends DAO<Customer> {


    public CustomerDAO(Class<Customer> clazzToSet, SessionFactory sessionFactory) {
        super(clazzToSet, sessionFactory);
    }

}
