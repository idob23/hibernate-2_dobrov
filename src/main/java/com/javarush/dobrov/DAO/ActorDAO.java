package com.javarush.dobrov.DAO;

import com.javarush.dobrov.entity.Actor;
import org.hibernate.SessionFactory;

public class ActorDAO extends DAO<Actor> {
    public ActorDAO(Class<Actor> clazzToSet, SessionFactory sessionFactory) {
        super(clazzToSet, sessionFactory);
    }
}
