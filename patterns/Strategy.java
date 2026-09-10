interface Strategy{
  int execute(int a,int b);
}
class MulStrategy implements Strategy{
  public int execute(int a,int b){return a*b;}
}
class AddStrategy implements Strategy{
  public int execute(int a,int b){return a+b;}
}
class DivStrategy implements Strategy{
  public int execute(int a,int b){return a/b;}
}
class Context{
  private Strategy sty;
  public void setStrategy(Strategy sty){
    this.sty=sty;
  } 
  public int executeStrategy(int a,int b){
    return sty.execute(a,b);
  }
}
public class Main{
  public static void main(String[]args){
    Context ctx=new Context();
    ctx.setStrategy(new MulStrategy());
    System.out.println(ctx.executeStrategy(10,20));
  }
}
