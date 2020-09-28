package pl.sdacademy.credentials;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {
    private  List<User> users = new ArrayList<>();
    //private  User wladek = new User("Wladek", "Waldkowicz", LocalDate.of(1989, 12, 12), false);
    //private  User kazek = new User("Kazek", "Nowak", LocalDate.of(1976, 2, 27), false);
    //private  User admin = new User("Admin", "Adminowicz", LocalDate.of(2000, 1, 1), true);

    @Override
    public User readById(int id) {
        return users.get(id);
    }

    @Override
    public List<User> readAll() {
        return users;
    }

    @Override
    public void create(User user) {
        users.add(user);
    }

    @Override
    public void update(User user) {
        delete(users.get(user.getId()));
        create(user);
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }
}
