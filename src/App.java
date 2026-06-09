import java.util.Scanner;

import facade.UserManagementFacade;
import factory.RepositoryFactory;
import model.User;
import repository.UserRepository;
import service.UserService;
import singleton.DatabaseConnection;
import strategy.*;

public class App {

    public static void main(String[] args) {

        DatabaseConnection db1 =  DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        System.out.println( (db1 == db2));
        
        UserRepository repository = RepositoryFactory.createRepository();

        UserService service = new UserService(repository);

        NotificationContext context = new NotificationContext();

        UserManagementFacade facade =  new UserManagementFacade( service, context);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create User");
            System.out.println("2. Read User");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. View All Users");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter User Id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter User Name: ");
                    String name = scanner.nextLine();
                    System.out.println( "Choose Notification Service Subscrption");
                    System.out.println("1. Email");
                    System.out.println("2. SMS");
                    int notificationChoice =  scanner.nextInt();
                    scanner.nextLine();
                    NotificationStrategy strategy;
                    if (notificationChoice == 1) {
                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();
                        strategy = new EmailNotification(email);
                    } else {
                        System.out.print( "Enter Mobile Number: ");
                        String mobile =scanner.nextLine();
                        strategy = new SmsNotification( mobile);
                    }

                    facade.registerUser(new User(id, name),strategy);
                    break;

                case 2:

                    System.out.print(   "Enter User Id: ");
                    User user = service.getUser( scanner.nextInt());
                    System.out.println(user);
                    break;

                case 3:
                    System.out.print("Enter User Id: ");
                    int updateId =  scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName =scanner.nextLine();
                    service.updateUser( new User(updateId,newName));
                    System.out.println(  "User Updated");
                   break;

                case 4:

                    System.out.print( "Enter User Id: ");
                    int deleteId =scanner.nextInt();
                    service.deleteUser(deleteId);
                    System.out.println("User Deleted");
                    break;

                case 5:
                    repository.getAll().forEach(System.out::println);
                    break;
                case 6:
                    System.out.println( "Exiting Application...");
                    scanner.close();
                    System.exit(0);
                default:
                        System.out.println("Invalid Choice");
            }
        }
    }
}