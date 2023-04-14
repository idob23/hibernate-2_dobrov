package com.javarush.dobrov;

import com.javarush.dobrov.DAO.*;
import com.javarush.dobrov.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Properties;
import java.util.Set;

public class Main {
    private final SessionFactory sessionFactory;
    private final StoreDAO storeDAO;
    private final CityDAO cityDAO;
    private final CustomerDAO customerDAO;
    private final AddressDAO addressDAO;
    private final RentalDAO rentalDAO;
    private final FilmDAO filmDAO;
    private final InventoryDAO inventoryDAO;
    private final PaymentDAO paymentDAO;
    private final ActorDAO actorDAO;
    private final CategoryDAO categoryDAO;
    private final LanguageDAO languageDAO;
    private final FilmTextDAO filmTextDAO;

    public Main() {
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.DRIVER, "com.p6spy.engine.spy.P6SpyDriver");
        properties.put(Environment.URL, "jdbc:p6spy:mysql://localhost:3306/movie");
        properties.put(Environment.USER, "admin");
        properties.put(Environment.PASS, "admin");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.HBM2DDL_AUTO, "validate");

        sessionFactory = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Feature.class)
                .addAnnotatedClass(Film.class)
                .addAnnotatedClass(FilmText.class)
                .addAnnotatedClass(Inventory.class)
                .addAnnotatedClass(Language.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(Rating.class)
                .addAnnotatedClass(Rental.class)
                .addAnnotatedClass(Staff.class)
                .addAnnotatedClass(Store.class)
                .addProperties(properties)
                .buildSessionFactory();

        storeDAO = new StoreDAO(Store.class, sessionFactory);
        cityDAO = new CityDAO(City.class, sessionFactory);
        customerDAO = new CustomerDAO(Customer.class, sessionFactory);
        addressDAO = new AddressDAO(Address.class, sessionFactory);
        rentalDAO = new RentalDAO(Rental.class, sessionFactory);
        filmDAO = new FilmDAO(Film.class, sessionFactory);
        inventoryDAO = new InventoryDAO(Inventory.class, sessionFactory);
        paymentDAO = new PaymentDAO(Payment.class, sessionFactory);
        actorDAO = new ActorDAO(Actor.class, sessionFactory);
        categoryDAO = new CategoryDAO(Category.class, sessionFactory);
        languageDAO = new LanguageDAO(Language.class, sessionFactory);
        filmTextDAO = new FilmTextDAO(FilmText.class, sessionFactory);

    }

    public static void main(String[] args) {
        Main main = new Main();
        Customer customer = main.createCustomer();
        main.customerReturnRental();
        main.customerRentInventory(customer);
        main.createNewFilm();

    }

    private void createNewFilm() {
        try (Session currentSession = sessionFactory.getCurrentSession()) {
            Transaction transaction = currentSession.beginTransaction();

            Film film = new Film();
            film.setActors(Set.of(actorDAO.getItems(0, 1).get(0), actorDAO.getItems(2, 4).get(3)));
            film.setCategories(Set.of(categoryDAO.getItems(0, 4).get(3)));
            film.setDescription("film");
            film.setLength((short) 99);
            film.setLanguage_id(languageDAO.getItems(2, 3).get(2));
            film.setRating(Rating.PG);
            film.setRelease_year(Year.now());
            film.setRental_rate(BigDecimal.valueOf(2.3));
            film.setReplacement_cost(BigDecimal.valueOf(23.34));
            film.setSpecial_features("Trailers");
            film.setTitle("Best Film");
            film.setOriginal_language_id(languageDAO.getItems(0, 1).get(0));
            film.setRental_duration((byte) 7);
            filmDAO.create(film);

            FilmText text = new FilmText();
            text.setFilm(film);
            text.setFilm_id((short) film.getFilm_id());
            text.setDescription("film");
            text.setTitle("Best Film");
            filmTextDAO.create(text);

            transaction.commit();
        }

    }

    private void customerRentInventory(Customer customer) {
        try (Session currentSession = sessionFactory.getCurrentSession()) {
            Transaction transaction = currentSession.beginTransaction();

            Store store = storeDAO.getItems(0, 1).get(0);
            Staff staff = store.getStaff();
            Film film = filmDAO.getFilm();
            customer.setStore(store);

            Inventory inventory = new Inventory();
            inventory.setFilm(film);
            inventory.setStore(store);
            inventoryDAO.create(inventory);


            Rental rental = new Rental();
            rental.setCustomer(customer);
            rental.setInventory(inventory);
            rental.setStaff(staff);
            rental.setRental_date(LocalDateTime.now());
            rentalDAO.create(rental);

            Payment payment = new Payment();
            payment.setCustomer(customer);
            payment.setAmount(BigDecimal.valueOf(23.23));
            payment.setRental(rental);
            payment.setStaff(staff);
            paymentDAO.create(payment);

            transaction.commit();
        }

    }

    private void customerReturnRental() {
        Session currentSession = sessionFactory.getCurrentSession();
        try (currentSession) {
            Transaction transaction = currentSession.beginTransaction();

            Rental rental = rentalDAO.customerReturnArendedFilm();

            rental.setReturn_date(LocalDateTime.now());
            rentalDAO.create(rental);

            transaction.commit();
        }
    }


    private Customer createCustomer() {
        try (Session currentSession = sessionFactory.getCurrentSession()) {
            Transaction transaction = currentSession.beginTransaction();

            Store store = storeDAO.getItems(0, 1).get(0);
            City city = cityDAO.getItems(0, 123).get(56);

            Address address = new Address();
            address.setAddress("Kommunist");
            address.setCity(city);
            address.setDistrict("RuS");
            address.setPhone("12345");
            address.setPostal_code("11");
            addressDAO.create(address);

            Customer customer = new Customer();
            customer.setActive(true);
            customer.setAddress(address);
            customer.setEmail("asd");
            customer.setFirst_name("ivan");
            customer.setLast_name("ivanov");
            customer.setStore(store);
            customerDAO.create(customer);

            transaction.commit();
            return customer;
        }
    }
}