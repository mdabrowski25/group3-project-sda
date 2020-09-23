package pl.sdacademy.credentials;

import java.util.List;

public interface UserRepository {
    User readById();
    List<User> readAll();
    void create();
    void update();
    void delete();
}
