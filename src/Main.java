import facade.UserManagementFacade;
import factory.RepositoryFactory;
import model.User;
import repository.UserRepository;
import service.UserService;
import singleton.DatabaseConnection;
import strategy.*;

public class Main{
 public static void main(String[] args){


// Singleton Pattern 
  DatabaseConnection db1 = DatabaseConnection.getInstance();
  DatabaseConnection db2 = DatabaseConnection.getInstance();
  


  // Factory Pattern
  UserRepository repository = RepositoryFactory.createRepository();

// RepositoryFactory factory = new RepositoryFactory();
// UserRepository repository =  factory.createRepository("MEMORY");


  UserService service = new UserService(repository);
  NotificationContext context = new NotificationContext();
  UserManagementFacade facade =  new UserManagementFacade(service,context);

  System.out.println("\nEmail Strategy ");
  facade.registerUser(new User(1,"Mithilesh"),
      new EmailNotification("mithilesh@gmail.com"));

  System.out.println("\n SMS Strategy");
  facade.registerUser(new User(2,"Rahul"),
      new SmsNotification("9876543210"));

  System.out.println("\n--- Read User ");
  System.out.println(service.getUser(1));
 }
 
}