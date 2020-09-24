import org.junit.jupiter.api.Test;
import pl.sdacademy.SessionFactoryProvider;

public class SessionFactoryProviderTest {
    @Test
    void SessionFactoryTest() {
        SessionFactoryProvider sessionFactoryProvider = new SessionFactoryProvider();
        sessionFactoryProvider.createSession();
        sessionFactoryProvider.closeSession();
    }
}
