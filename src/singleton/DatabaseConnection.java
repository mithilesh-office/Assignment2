package singleton;

public class DatabaseConnection {

    private static DatabaseConnection instance;

    private DatabaseConnection(){
        //  database  connection setup
        System.out.println("Database connection established.");
    }
    
    public static DatabaseConnection getInstance(){
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }
}