import java.rmi.*;

public interface AddServerIntf extends Remote { 
//method declaration 
double add(double d1, double d2) throws RemoteException;
}

//Commands
// javac *.java      
// rmic AddServerImpl

// rmiregistry

// java AddServer

// java AddClient 127.0.0.1 5 6 