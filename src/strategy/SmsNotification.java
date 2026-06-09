package strategy;

public class SmsNotification implements NotificationStrategy{
 
 private String mobileNumber;

  public SmsNotification(String mobileNumber){
    this.mobileNumber = mobileNumber;
  }
 
  public void collectNotificationDetails(){
     System.out.println("Collecting Mobile Number...");
  }

 public void send(String message){
  System.out.println("SMS sent to "+ mobileNumber);
  System.out.println("Message: "+ message);
 } 
 
}