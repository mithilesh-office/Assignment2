package factory;
import repository.*;


public class RepositoryFactory {

    public static UserRepository createRepository(){
        return new InMemoryUserRepository();
    }
}



// package factory;

// import repository.InMemoryUserRepository;
// import repository.MongoUserRepository;
// import repository.UserRepository;

// public class RepositoryFactory {

//     public UserRepository createRepository(String type) {

//         if(type.equalsIgnoreCase("MEMORY")) {
//             return new InMemoryUserRepository();
//         }

//         if(type.equalsIgnoreCase("MONGO")) {
//             return new MongoUserRepository();
//         }

//         throw new IllegalArgumentException(
//                 "Invalid Repository Type");
//     }
// }