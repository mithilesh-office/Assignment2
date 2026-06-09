package adapter;
import strategy.NotificationStrategy;

public class EmailAdapter implements NotificationStrategy{

  private ThirdPartyEmailService service = new ThirdPartyEmailService();

  public void collectNotificationDetails(){

  System.out.println("Collecting Third Party Email Details...");

 }
 
  public void send(String message){
  service.sendMail(message);

 }
}