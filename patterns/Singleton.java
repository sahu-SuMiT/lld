class DatabaseConnection{
  static DatabaseConnection connection;
  static int connectionId=0;
  private DatabaseConnection(){
    System.out.println("connectionID: "+connectionId);
    connectionId++;
  }
  static DatabaseConnection connect(){
    if(connection==null){
      connection=new DatabaseConnection();
    }
    System.out.println("Established connection ID:"+connectionId);
    return connection;
    
  }

}

public class Main {
    public static void main(String[] args) {
      DatabaseConnection conn1=DatabaseConnection.connect();
      DatabaseConnection conn2=DatabaseConnection.connect();
    }
}
