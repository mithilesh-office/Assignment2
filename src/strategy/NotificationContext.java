package strategy;

public class NotificationContext{

 public void notifyUser(NotificationStrategy strategy , String message){
    
  strategy.collectNotificationDetails();
  strategy.send(message);
  
 }

}