import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import pl.sdacademy.SessionFactoryProvider;

public class TestSessionFactoryProvider {
    @Test
    void SessionFactoryTest() {
        SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory("hibernate.cfg.xml");
        Session session = sessionFactory.openSession();
    }
}
