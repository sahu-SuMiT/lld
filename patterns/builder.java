class Computer{
  String cpu;
  String ram;
  String memory;
  boolean graphicCard;
  boolean wifiDriver;
  int cores;
  Computer(ComputerBuilder cb){
    this.cpu=cb.cpu;
    this.ram=cb.ram;
    this.graphicCard=cb.graphicCard;
    this.wifiDriver=cb.wifiDriver;
    this.cores=cb.cores;
  }
  void show(){
    System.out.println("cpu:\n"+this.cpu+"\nram:\n"+this.ram+"\ngraphicsCard\n"+this.graphicCard+"\nwifiDriver\n"+this.wifiDriver+"\ncores\n"+this.cores);
  }
  static class ComputerBuilder{
    String cpu;
    String ram;
    boolean graphicCard;
    boolean wifiDriver;
    int cores;
    ComputerBuilder(String cpu){
      this.cpu=cpu;
    }
    ComputerBuilder setMemory(String ram){
      this.ram=ram;
      return this;
    }
    ComputerBuilder buildGraphics(boolean graphicCard){
      this.graphicCard=graphicCard;
      return this;
    }
    ComputerBuilder buildWifi(boolean wifi){
      this.wifiDriver=wifiDriver;
      return this;
    }
    ComputerBuilder setCores(int cores){
      this.cores=cores;
      return this;
    }
    Computer build(){
      return new Computer(this);
    }
  }
}
public class Main{
  public static void main(String[]args){
    Computer gc=new Computer.ComputerBuilder("Intel x85").setCores(8).buildWifi(true).buildGraphics(true).setMemory("16 GB").build();
    gc.show();
  }
}
