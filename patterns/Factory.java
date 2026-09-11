interface Notification{
  void send();
}
class SmsNotification implements Notification{
  public void send(){
    System.out.println("SMS notify all");
  }
}
class EmailNotification implements Notification{
  public void send(){
    System.out.println("Email notify all");
  }
}
class WhatsappNotification implements Notification{
  public void send(){
    System.out.println("Whatsapp notify all");
  }
}

class NotificationFactory{
  public Notification createNotification(String type){
    if(type.equalsIgnoreCase("sms"))return new SmsNotification();
    else if(type.equalsIgnoreCase("email"))return new EmailNotification();
    else if(type.equalsIgnoreCase("whatsapp"))return new WhatsappNotification();
    else return null;
  }
}

public class Main{
  public static void main(String[]args){
    NotificationFactory factory=new NotificationFactory();
    Notification email=factory.createNotification("email");
    Notification whatsapp=factory.createNotification("whatsapp");
    Notification sms=factory.createNotification("sms");

    email.send();
    whatsapp.send();
    sms.send();

  }
}
