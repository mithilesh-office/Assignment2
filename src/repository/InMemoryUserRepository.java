package repository;
import model.User;
import java.util.*;

public class InMemoryUserRepository implements UserRepository {
    private List<User> users = new ArrayList<>();

    public void create(User user){
         users.add(user); 
        }

    public User read(int id){
        for(User user : users){
            if(user.getId()==id) return user;
        }
        return null;
    }

    public void update(User updatedUser){
        User user = read(updatedUser.getId());
        if(user!=null) user.setName(updatedUser.getName());
    }


    public void delete(int id){
        users.removeIf(user -> user.getId()==id);
    }


    public List<User> getAll(){
         return users; 
    }
}