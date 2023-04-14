package com.javarush.dobrov.DAO;

import com.javarush.dobrov.entity.Payment;
import org.hibernate.SessionFactory;

public class PaymentDAO extends DAO<Payment>{
    public PaymentDAO(Class<Payment> clazzToSet, SessionFactory sessionFactory) {
        super(clazzToSet, sessionFactory);
    }
}
