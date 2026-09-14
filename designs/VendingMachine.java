
interface State{
  void insertCoin(VendingMachine machine, int amount);
  void pickItem(VendingMachine machine);
  void dispense(VendingMachine machine);
  void cancel(VendingMachine machine);
}
class VendingMachine{
  private State currentState;
  private int balance;
  private int itemPrice;
  private int inventoryCount;

  VendingMachine(){
    this.currentState=new IdleState();
    this.balance=0;
    this.itemPrice=10;
    this.inventoryCount=2;
  } 
  //balance
  public void addBalance(int amount){
    this.balance+=amount;
  }
  public int getBalance(){
    return this.balance;
  }
  public void resetBalance(){
    this.balance=0;
  }
  //Item
  public int getItemPrice(){
    return itemPrice;
  }
  public void releaseItem(){
    inventoryCount--;
    this.balance-=this.itemPrice;
    System.out.println("Item Released. Remaining:"+inventoryCount);
  }
  public boolean hasInventory(){
    return inventoryCount>0;
  }
  //States
  public void setState(State state){
    currentState=state;
  }
  public void pickItem(){
    currentState.pickItem(this);
  }
  public void insertCoin(int amount){
    currentState.insertCoin(this,amount);
  }
  public void dispense(){
    currentState.dispense(this);
  }
  public void cancel(){
    currentState.cancel(this);
  }
  
}

class IdleState implements State{
  public void insertCoin(VendingMachine machine,int amount){
    machine.addBalance(amount);
    System.out.println("Machine was added a balance of: "+amount+" Current Balance: "+machine.getBalance());
    machine.setState(new HasMoneyState());
  }
  public void pickItem(VendingMachine machine){
    System.out.println("Idle state Cannot Pick");
  }
  public void dispense(VendingMachine machine){
    System.out.println("Idle State Cannot dispense");
  }
  public void cancel(VendingMachine machine){
    System.out.println("Idle State Cannot Cancel");
  }
}
class HasMoneyState implements State{
  public void insertCoin(VendingMachine machine,int amount){
    machine.addBalance(amount);
    System.out.println("Machine was added a balance of: "+amount+" Current Balance: "+machine.getBalance());
  }
  public void pickItem(VendingMachine machine){
    int currBalance=machine.getBalance();
    int itemPrice=machine.getItemPrice();
    if(currBalance<itemPrice){
      System.out.println("Insufficient Funds");
    }else{
      System.out.println("Item Successfully Picked, Returning Remaining Balance: "+(currBalance-itemPrice));
      machine.setState(new VendingState());
      machine.dispense();
    }

  }
  public void dispense(VendingMachine machine){
    System.out.println("HasMoneyState unable to dispense, Select a Product First");
  }
  public void cancel(VendingMachine machine){
    System.out.println("Transaction cancelled, Returning $:"+machine.getBalance());
    machine.resetBalance();
    machine.setState(new IdleState());
  }
}
class VendingState implements State{
  public void insertCoin(VendingMachine machine,int amount){
    System.out.println("Machine is in vending State");
  }
  public void pickItem(VendingMachine machine){
    System.out.println("Machine is in vending State");
  }
  public void dispense(VendingMachine machine){
    System.out.println("processing...");
    if(machine.hasInventory()){
      machine.releaseItem();
      machine.setState(new IdleState());
    }else{
      System.out.println("Machine is Out of Items");
      machine.setState(new OutOfItemState());
    }
  }
  public void cancel(VendingMachine machine){
    System.out.println("Cannot Cancel while Dispensing");
  }
}
class OutOfItemState implements State{
  public void insertCoin(VendingMachine machine,int amount){
    System.out.println("Out of Items");
  }
  public void pickItem(VendingMachine machine){
    System.out.println("Out of Items");
  }
  public void dispense(VendingMachine machine){
    System.out.println("Out of Items");
  }
  public void cancel(VendingMachine machine){
    System.out.println("Out of Items");
  }
}

public class Main{
  public static void main(String[]args){
    VendingMachine machine=new VendingMachine();
    //unsuccessful Buy
    // machine.pickItem();
    // machine.insertCoin(5);
    // machine.pickItem();
    // machine.cancel();

    machine.insertCoin(20);
    machine.pickItem();
    

  }
}
