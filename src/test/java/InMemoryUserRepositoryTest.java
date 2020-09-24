import org.junit.jupiter.api.Test;
import pl.sdacademy.credentials.InMemoryUserRepository;

public class InMemoryUserRepositoryTest {
    @Test
    void inMemoryUserRepositoryReadAllTest(){
        InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();
        inMemoryUserRepository.getUsers().forEach(inMemoryUserRepository::create);
        System.out.println(inMemoryUserRepository.readAll());
    }
}
