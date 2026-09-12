interface Button{
  void push();
}
interface CheckBox{
  void click();
}
class WindowsButton implements Button{
  public void push(){
    System.out.println("Windows Button pushed");
  }
}
class WindowsCheckBox implements CheckBox{
  public void click(){
    System.out.println("Windows CheckBox clicked");
  }
}
class MacButton implements Button{
  public void push(){
    System.out.println("Mac Button pushed");
  }
}
class MacCheckBox implements CheckBox{
  public void click(){
    System.out.println("Mac Button clicked");
  }
}

interface GUIFactory{
  Button createButton();
  CheckBox createCheckBox();
}
class MacFactory implements GUIFactory{
  public Button createButton(){
    return new MacButton();
  }
  public CheckBox createCheckBox(){
    return new MacCheckBox();
  }
}
class WindowsFactory implements GUIFactory{
  public Button createButton(){
    return new WindowsButton();
  }
  public CheckBox createCheckBox(){
    return new WindowsCheckBox();
  }
}
class Application{
  private Button button;
  private CheckBox checkbox;
  
  public Application(GUIFactory factory){
    button=factory.createButton();
    checkbox=factory.createCheckBox();
  }
  public void renderUI(){
    button.push();
    checkbox.click();
  }
}
public class Main{
  public static void main(String[]args){
    GUIFactory factory= new MacFactory();
    Button button=factory.createButton();
    CheckBox checkbox=factory.createCheckBox();
    button.push();
    checkbox.click();

  }
}
