# User Management System - Design Patterns Assignment

1. Factory Pattern
2. Singleton Pattern
3. Strategy Pattern
4. Adapter Pattern
5. Facade Pattern

---


# 1. Factory Pattern

## Problem Without Factory Pattern

Object creation happens everywhere.

```java
UserRepository repository =
        new InMemoryUserRepository();
```

If the implementation changes:

```java
new MongoUserRepository();
```

every class must be updated.

---

## Solution Using Factory Pattern

Centralize object creation.

```java
public class RepositoryFactory {

    public static UserRepository
            createRepository() {

        return new InMemoryUserRepository();
    }
}
```

Usage:

```java
UserRepository repository =
        RepositoryFactory.createRepository();
```

---

---

# 2. Singleton Pattern

## Problem Without Singleton Pattern

Multiple database connections can be created.

```java
DatabaseConnection db1 =
        new DatabaseConnection();

DatabaseConnection db2 =
        new DatabaseConnection();
```

Result:

```text
Two separate objects
```

This wastes resources.

---

## Solution Using Singleton Pattern

Allow only one object.

```java
public class DatabaseConnection {

    private static DatabaseConnection instance;

    private DatabaseConnection() {
    }

    public static DatabaseConnection
            getInstance() {

        if(instance == null) {
            instance =
                new DatabaseConnection();
        }

        return instance;
    }
}
```

Usage:

```java
DatabaseConnection db1 =
        DatabaseConnection.getInstance();

DatabaseConnection db2 =
        DatabaseConnection.getInstance();
```

---

---

# 4. Strategy Pattern

## Problem Without Strategy Pattern

Suppose notifications are sent like this:

```java
public void sendNotification(
        String type) {

    if(type.equals("EMAIL")) {

        // email logic

    } else if(type.equals("SMS")) {

        // sms logic
    }
}
```

### Problems

* Large if-else blocks
* Difficult to add new notification types
* Violates Open/Closed Principle

---

## Solution Using Strategy Pattern

Create a common interface.

```java
public interface NotificationStrategy {

    void collectNotificationDetails();

    void send(String message);
}
```

### Email Strategy

```java
public class EmailNotification
        implements NotificationStrategy {
}
```

### SMS Strategy

```java
public class SmsNotification
        implements NotificationStrategy {
}
```

### Context

```java
public class NotificationContext {

    public void notifyUser(
            NotificationStrategy strategy,
            String message) {

        strategy.collectNotificationDetails();

        strategy.send(message);
    }
}
```

### Usage

```java
facade.registerUser(
        new User(1, "Mithilesh"),
        new EmailNotification(
                "mithilesh@gmail.com"));
```

or

```java
facade.registerUser(
        new User(2, "Rahul"),
        new SmsNotification(
                "9876543210"));
```

---

## Benefits

* Runtime behavior selection
* No if-else chains
* Easy extension

---

# 5. Adapter Pattern

## Problem Without Adapter Pattern

Suppose a third-party email library provides:

```java
public class ThirdPartyEmailService {

    public void sendMail(
            String message) {
    }
}
```

But our application expects:

```java
public interface NotificationStrategy {

    void send(String message);
}
```

Interfaces are incompatible.

---

## Solution Using Adapter Pattern

Create an adapter.

```java
public class EmailAdapter
        implements NotificationStrategy {
}
```

Implementation:

```java
public void send(String message) {

    emailService.sendMail(message);
}
```

Now the third-party service behaves like a NotificationStrategy.

---

## Benefits

* Reuse external libraries
* No changes to client code
* Loose coupling

---

# 6. Facade Pattern

## Problem Without Facade Pattern

Client must call multiple objects.

```java
service.createUser(user);

context.notifyUser(
        strategy,
        "Welcome");
```

Client understands too many details.

---

## Solution Using Facade Pattern

Create a single entry point.

```java
public class UserManagementFacade {
}
```

Method:

```java
public void registerUser(
        User user,
        NotificationStrategy strategy) {

    service.createUser(user);

    context.notifyUser(
            strategy,
            "Welcome " +
            user.getName());
}
```

### Usage

```java
facade.registerUser(
        user,
        strategy);
```

---