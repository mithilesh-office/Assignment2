package service;
import model.User;
import repository.UserRepository;

public class UserService{

 private UserRepository repository;

    public UserService(UserRepository repository){
        this.repository=repository;
    }

    public void createUser(User user){
        repository.create(user);
    }

    public User getUser(int id){
        return repository.read(id);
    }

    public void updateUser(User user){
     repository.update(user);
    }

  public void deleteUser(int id){
    repository.delete(id);

    }
     public void getAllUsers() {
        repository.getAll().forEach(System.out::println);
    }
}