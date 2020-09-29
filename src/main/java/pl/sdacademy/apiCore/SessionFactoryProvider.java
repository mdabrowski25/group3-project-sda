package pl.sdacademy.apiCore;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionFactoryProvider {
public static SessionFactory getSessionFactory(String facetName) {
    Configuration configuration = new Configuration()
            .configure(facetName);
    return configuration.buildSessionFactory();

}

}
