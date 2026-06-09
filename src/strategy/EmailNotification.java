package strategy;


public class EmailNotification implements NotificationStrategy{
 private String email;

 public EmailNotification(String email){
    this.email=email;
}
 public void collectNotificationDetails(){
  System.out.println("Collecting Email Details...");
 }

 public void send(String message){
  System.out.println("Email sent to "+email);
  System.out.println("Message: "+message);
 }
 
}