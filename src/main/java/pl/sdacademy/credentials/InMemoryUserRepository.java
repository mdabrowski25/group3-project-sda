package pl.sdacademy.credentials;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import pl.sdacademy.SessionFactoryProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {
    private List<User> users = Arrays.asList(
            new User("Wladek", "Waldkowicz", LocalDate.of(1989, 12, 12), false),
            new User("Kazek", "Nowak", LocalDate.of(1976, 2, 27), false),
            new User("Admin", "Adminowicz", LocalDate.of(2000, 1, 1), true));

    @Override
    public User readById(int id) {
        SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory("hibernate.cfg.xml");
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        sessionFactory.close();
        return user;
    }

    @Override
    public List<User> readAll() {
        SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory("hibernate.cfg.xml");
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("SELECT u FROM User u WHERE u.id > 0", User.class);
        List <User> users = query.getResultList();
        session.close();
        sessionFactory.close();
        return users;

    }

    @Override
    // nie wydaje mi sie by metoda powinna przyjmowac usera za argument
    public void create(User user) {
        SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory("hibernate.cfg.xml");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        sessionFactory.close();

    }

    @Override
    public void update(User user) {
        SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory("hibernate.cfg.xml");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Override
    public void delete(User user) {
        SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory("hibernate.cfg.xml");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
