package pl.sdacademy.credentials;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {
    private List<User> users = Arrays.asList(
            new User("Wladek","Waldkowicz", LocalDate.of(1989,12,12),false),
            new User("Kazek","Nowak",LocalDate.of(1976,2,27),false),
            new User("Admin","Adminowicz",LocalDate.of(2000,1,1),true));

    @Override
    public User readById() {
        return null;
    }

    @Override
    public List<User> readAll() {
        return null;
    }

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
