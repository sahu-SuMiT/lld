interface Vehicle{
  void ride();
}
class Bike implements Vehicle{
  public void ride(){
    System.out.println("Bike Ride");
  }
}
class Car implements Vehicle{
  public void ride(){
    System.out.println("Car Ride");
  }
}
class VehicleFactory{
  public Vehicle createVehicle(String type){
    if(type.equalsIgnoreCase("car")){
      return new Car();
    }else if(type.equalsIgnoreCase("bike")){
      return new Bike();
    }
    return null;
  }
}
public class Main{
  public static void main(String[]args){
    VehicleFactory factory=new VehicleFactory();
    Vehicle bike=factory.createVehicle("bike");
    Vehicle car=factory.createVehicle("car");

    bike.ride();
    car.ride();
  }
}
