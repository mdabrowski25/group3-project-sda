import org.junit.jupiter.api.Test;
import pl.sdacademy.credentials.InMemoryUserRepository;
import pl.sdacademy.credentials.User;

public class InMemoryUserRepositoryTest {
    @Test
    void inMemoryUserRepositoryReadAllTest(){
        InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();
        inMemoryUserRepository.addExampleUsers();
        inMemoryUserRepository.getUsers().forEach(inMemoryUserRepository::create);
        System.out.println(inMemoryUserRepository.readAll());
    }
}
