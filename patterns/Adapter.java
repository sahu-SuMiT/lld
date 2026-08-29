interface USBsocket{
  void connectUSB();
}
class USBDevice implements USBsocket{
  public void connectUSB(){
    System.out.println("USB connected");
  }
}
class MemoryCard{
  public void connectMemory(){
    System.out.println("MemoryDevice connected");
  }
}

class CardReader implements USBsocket{
  private MemoryCard memoryCard;
  CardReader(MemoryCard memoryCard){
    this.memoryCard=memoryCard;
  }
  public void connectUSB(){
    memoryCard.connectMemory();
    System.out.println("memory successfully inserted using adapter");
  }
}

class ComputerPort{
  public void connectDevice(USBDevice device){
    device.connectUSB();
  }
}
//The computer only has usb port
public class Main {
  public static void main(String[] args) {
    ComputerPort port= new ComputerPort();
    
    USBsocket usbDevice=new USBDevice();
    usbDevice.connectUSB();
    MemoryCard card=new MemoryCard();

    CardReader cardReader=new CardReader(card);
    cardReader.connectUSB();

  }
}
