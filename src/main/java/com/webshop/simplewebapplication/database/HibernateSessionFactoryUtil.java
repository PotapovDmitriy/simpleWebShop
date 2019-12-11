package com.webshop.simplewebapplication.database;


import com.webshop.simplewebapplication.model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Product.class);
                sessionFactory = configuration.buildSessionFactory();

            } catch (Exception e) {
                System.out.println("EXCEPTION!!!   " + e);
            }
        }
        return sessionFactory;
    }
}