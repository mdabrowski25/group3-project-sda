package pl.sdacademy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        ApiDataProvider apiDataProvider = new ApiDataProvider();
        WorldCoronaPeople worldCoronaPeople = apiDataProvider.get();
        System.out.println(worldCoronaPeople.toString());
        System.out.println(worldCoronaPeople.getResult().getTotal_active_cases());

        SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory("hibernate.cfg.xml");
        Session session = sessionFactory.openSession();
        session.close();
        sessionFactory.close();
    }
}
