package repository;
import model.User;
import java.util.List;

public interface UserRepository {
    void create(User user);
    User read(int id);
    void update(User user);
    void delete(int id);
    List<User> getAll();
}