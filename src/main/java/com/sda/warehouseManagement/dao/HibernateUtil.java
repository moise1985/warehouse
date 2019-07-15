package com.sda.warehouseManagement.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory = new Configuration()
            .configure("warehouse.cfg.xml")
            .buildSessionFactory();

    public static SessionFactory getSession() {
        return sessionFactory;
    }
    
}
