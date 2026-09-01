interface Server{
  void start();
}
interface Storage{
  void save();
}
class AwsServer implements Server{
  public void start(){
    System.out.println("Aws Server started");
  }
}

class AwsStorage implements Storage{
  public void save(){
    System.out.println("saved to AWS");
  }
}

class GcpServer implements Server{
  public void start(){
    System.out.println("Gcp Server started");
  }
}

class GcpStorage implements Storage{
  public void save(){
    System.out.println("Saved to Gcp");
  }
}

interface CloudFactory{
  Server createServer();
  Storage createStorage();
}
class AwsFactory implements CloudFactory{
  public Server createServer(){
    return new AwsServer();
  }
  public Storage createStorage(){
    return new AwsStorage();
  }
}

class GcpFactory implements CloudFactory{
  public Server createServer(){
    return new GcpServer();
  }
  public Storage createStorage(){
    return new GcpStorage();  
  }
}

class CloudDeployer{
  private Server server;
  private Storage storage;
  public CloudDeployer(CloudFactory factory){
    server=factory.createServer();
    storage=factory.createStorage();
  }
  public void deploySystem(){
    server.start();
    storage.save();
    System.out.println("cloud deployed, server started and storage saved");
  }
}

public class Main {
    public static void main(String[] args) {
      CloudFactory awsFactory=new AwsFactory();
      CloudFactory GcpFactory=new GcpFactory();
      
      CloudDeployer awsDeployer=new CloudDeployer(awsFactory);
      CloudDeployer gcpDeployer=new CloudDeployer(GcpFactory);

      awsDeployer.deploySystem();
      gcpDeployer.deploySystem();
    }
}
