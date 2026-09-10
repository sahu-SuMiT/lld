import java.util.*;
interface Observer{
  void update(String vidTitle);
}
interface Subject{
  void subscribe(Observer o);
  void unsubscribe(Observer o);
  void notifyall();
}

class YouTubeChannel implements Subject{
  List<Observer>subscribers=new ArrayList<>();
  String latestVideoTitle;
  public void subscribe(Observer o){
    subscribers.add(o);
  }
  public void unsubscribe(Observer o){
    subscribers.remove(o);
  }
  public void notifyall(){
    for(Observer sub:subscribers){
      sub.update(latestVideoTitle);
    }
  }
  
  public void upload(String vidTitle){
    this.latestVideoTitle=vidTitle;
    System.out.println("channel uploaded new video:"+latestVideoTitle);
    notifyall();
  }
}

class Subscriber implements Observer{
  String name;
  Subscriber(String name){
    this.name=name;
  }
  public void update(String vidTitle){
    System.out.println("Hey "+name+" new video uploaded "+vidTitle);
  }
}

public class Main{
  public static void main(String[]args){
    YouTubeChannel c1=new YouTubeChannel();
    YouTubeChannel c2=new YouTubeChannel();

    Observer alice=new Subscriber("Alice");
    Observer bob=new Subscriber("Bob");
    Observer charlie=new Subscriber("Charlie");

    c1.subscribe(alice);
    c1.subscribe(bob);
    c1.upload("Jhunjuna Ka video");
    c1.subscribe(charlie);
    c1.upload("Rinkiya ke papa");

    c1.unsubscribe(alice);
    c1.upload("Mohni Roy");


  }
}
