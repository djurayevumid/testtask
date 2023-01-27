package org.example;

import org.example.model.CityEntity;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static SessionFactory sessionFactory;
    private static final String URL = "jdbc:mysql://localhost:3306/smth";
    private static final String USERNAME = "root";
    private static final String PASS = "James4root";
    private static final Connection connection = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.setProperty("hibernate.current_session_context_class", "thread");
                configuration.setProperty(Environment.URL, URL);
                configuration.setProperty(Environment.USER, USERNAME);
                configuration.setProperty(Environment.PASS, PASS);
                configuration.setProperty("hibernate.connection.release_mode", "auto");
                configuration.setProperty("hibernate.show_sql", "true");
                configuration.addAnnotatedClass(CityEntity.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (HibernateException hibernateException) {
                hibernateException.getStackTrace();
                throw new RuntimeException();
            }
        }
        return sessionFactory;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection;
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection(URL, USERNAME, PASS);
        return connection;
    }
}
