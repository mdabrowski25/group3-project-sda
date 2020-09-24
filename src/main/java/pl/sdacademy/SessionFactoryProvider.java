package pl.sdacademy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;


public class SessionFactoryProvider {
    private static SessionFactory sessionFactory;

    public void createSession() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        sessionFactory.openSession();
    }

    public void closeSession(){
        sessionFactory.close();
    }
}
