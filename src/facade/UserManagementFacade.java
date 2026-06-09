package facade;
import model.User;
import service.UserService;
import strategy.*;

public class UserManagementFacade{

 private UserService service;
 private NotificationContext context;

    public UserManagementFacade(UserService service  ,  NotificationContext context){
        this.service=service; 
        this.context=context;
    }

    public void registerUser(User user , NotificationStrategy strategy){
        service.createUser(user);
        context.notifyUser(strategy ,  "Welcome " + user.getName());
    }
}