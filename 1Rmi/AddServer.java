import java.rmi.*;

public class AddServer {
    public static void main(String args[]) {
        try { 
            //create remote object
            AddServerImpl obj = new AddServerImpl(); 
            //bind the remote object
            Naming.rebind("AddServer", obj);
        }
        catch (Exception e) {
            System.out.println("Exception: "+ e);
        }
    }
}