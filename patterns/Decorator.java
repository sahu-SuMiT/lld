//Component
interface Coffee{
  String show();
  double price();
}
//Concrete Base Component
class SimpleCoffee implements Coffee{
  public String show(){
    return "Plain Coffee";
  }
  public double price(){
    return 2.0;
  }
}
//Concrete Decorator
class Decorator implements Coffee{
  private Coffee decoratedCoffee;
  Decorator(Coffee coffee){
    this.decoratedCoffee=coffee;
  }
  public String show(){
    return decoratedCoffee.show();
  }
  public double price(){
    return decoratedCoffee.price();
  }
}
//Decorator1
class Milk extends Decorator{
  Milk(Coffee coffee){
    super(coffee);
  }
  @Override
  public String show(){
    return super.show()+" ,Milk";
  }
  @Override
  public double price(){
    return super.price()+1.5;
  }
}
//Decorator2
class Caramel extends Decorator{
  Caramel(Coffee coffee){
    super(coffee);
  }
  @Override
  public String show(){
    return super.show()+" ,caramel";
  }
  @Override
  public double price(){
    return super.price()+0.75;
  }
}
public class Main{
  public static void main(String[]args){
    Coffee coffee=new SimpleCoffee();
    System.out.println(coffee.show()+" "+coffee.price());

    Coffee decoratedCoffee=new Decorator(coffee);
    System.out.println(decoratedCoffee.show()+" "+decoratedCoffee.price());

    Decorator milkyCoffee=new Milk(decoratedCoffee);
    System.out.println(milkyCoffee.show()+" "+milkyCoffee.price());

    Decorator caramelMilkyCoffee=new Caramel(milkyCoffee);
    System.out.println(caramelMilkyCoffee.show()+" "+caramelMilkyCoffee.price());   
    
  }
}
