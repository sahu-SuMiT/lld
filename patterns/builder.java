import java.util.*;
class Desktop{
  private final String processor;
  private final String ram;
  private final String storage;
  private final String graphicsCard;

  private Desktop(DesktopBuilder builder){
    this.processor=builder.processor;
    this.ram=builder.ram;
    this.storage=builder.storage;
    this.graphicsCard=builder.graphicsCard;
  }

  public String getProcessor(){
    return processor;
  }
  public String getRam(){
    return ram;
  }
  public String getStorage(){
    return storage;
  }
  public String getGraphicsCard(){
    return graphicsCard;
  }
  @Override 
  public String toString(){
    return "Desktop Configuration, CPU:"+processor+", RAM: "+ram+", storage:"+storage+" GPU: "+graphicsCard;
  }

  public static class DesktopBuilder{
    private final String processor;
    private final String ram;
    private String storage;
    private String graphicsCard;

    public DesktopBuilder(String processor, String ram){
      this.processor=processor;
      this.ram=ram;
      this.storage="256GB SSD";
      this.graphicsCard="Integrated Graphics";
    }

    public DesktopBuilder setStorage(String storage){
      this.storage=storage;
      return this;
    }
    public DesktopBuilder setGraphicsCard(String graphicsCard){
      this.graphicsCard=graphicsCard;
      return this;
    }
    public Desktop build(){
      return new Desktop(this);
    }
  }
}
public class Main{
  public static void main(String[]args){
    Desktop desktop=new Desktop.DesktopBuilder("Intel", "8GB").setStorage("100000TB").setGraphicsCard("NVDIA").build();
    System.out.println(desktop);
  }
}
