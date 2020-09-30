package pl.sdacademy.entity;


import org.hibernate.SessionFactory;
import pl.sdacademy.apiCore.SessionFactoryProvider;

public class DbCovidDao {
        SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory("hibernate.cfg.xml");

}
