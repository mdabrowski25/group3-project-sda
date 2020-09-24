package pl.sdacademy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionFactoryProvider {
public static SessionFactory getSessionFactory(String facetName) {
    Configuration configuration = new Configuration().configure(facetName);
    return configuration.buildSessionFactory();

//    private static SessionFactory sessionFactory;
//
//    public Session createSession() {
//        sessionFactory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .buildSessionFactory();
//        return sessionFactory.openSession();
//    }
//
//    public void closeSession(){
//        sessionFactory.close();
//    }
}

}
