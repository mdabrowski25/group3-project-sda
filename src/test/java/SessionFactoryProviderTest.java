import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import pl.sdacademy.SessionFactoryProvider;

public class SessionFactoryProviderTest {
    @Test
    void SessionFactoryTest() {
//        SessionFactoryProvider sessionFactoryProvider = new SessionFactoryProvider();
//        Session session = sessionFactoryProvider.createSession();
//        session.createQuery(...);
//        sessionFactoryProvider.closeSession();
        SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory("hibernate.cfg.xml");
        Session session = sessionFactory.openSession();
    }
}
