import java.util.*;
interface VendingMachineState{
  void insertCoin(VendingMachine machine);
  void ejectCoin(VendingMachine machine);
  void pressButton(VendingMachine machine);
}

class NoCoinState implements VendingMachineState{

  public void insertCoin(VendingMachine machine){
    System.out.println("Coin inserted");
    machine.setState(machine.getHasCoinState());
  }

  public void ejectCoin(VendingMachine machine){
    System.out.println("You haven't inserted a coin.");
  }

  public void pressButton(VendingMachine machine){
    System.out.println("Button pressed, but you need to insert a coin first.");
  }
}

class HasCoinState implements VendingMachineState{

  public void insertCoin(VendingMachine machine){
    System.out.println("Coin already inserted. Rejecting extra cion.");
  }

  public void ejectCoin(VendingMachine machine){
    System.out.println("Coin returned");
    machine.setState(machine.getNoCoinState());
  }

  public void pressButton(VendingMachine machine){
    System.out.println("Button Pressed. Dispensing product...");
    machine.setState(machine.getNoCoinState());
  }
}

class VendingMachine{
  private final VendingMachineState noCoinState;
  private final VendingMachineState hasCoinState;

  private VendingMachineState currentState;

  public VendingMachine(){
    noCoinState=new NoCoinState();
    hasCoinState=new HasCoinState();

    currentState=noCoinState;
  }
  public void insertCoin(){
    currentState.insertCoin(this);
  }
  public void ejectCoin(){
    currentState.ejectCoin(this);
  }
  public void pressButton(){
    currentState.pressButton(this);
  }
  public void setState(VendingMachineState state){
    currentState=state;
  }
  public VendingMachineState getNoCoinState(){return noCoinState;}
  public VendingMachineState getHasCoinState(){return hasCoinState;}
}

public class Main{
  public static void main(String[]args){
    VendingMachine machine=new VendingMachine();
    machine.insertCoin();
    machine.ejectCoin();
    machine.ejectCoin();
    machine.insertCoin();
    machine.pressButton();
  }
}

