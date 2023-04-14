package com.javarush.dobrov.DAO;

import com.javarush.dobrov.entity.Rental;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class RentalDAO extends DAO<Rental> {

    public RentalDAO(Class<Rental> clazzToSet, SessionFactory sessionFactory) {
        super(clazzToSet, sessionFactory);
    }


    public Rental customerReturnArendedFilm() {

        Query<Rental> query = getCurrentSession().createQuery("select r from Rental r where r.return_date is null ", Rental.class);
        query.setMaxResults(1);

        return query.getSingleResult();

    }
}
