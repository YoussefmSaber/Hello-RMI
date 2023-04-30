import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class HelloServer {

    public static void main(String[] args) {
        try {

            // Clear screen
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Start the RMI registry on port 1099
            LocateRegistry.createRegistry(1099);
            
            // Create an instance of the remote object
            HelloService obj = new HelloServiceImpl();
            
            // Register the remote object with the registry
            Naming.rebind("//localhost/Hello", obj);
            
            // Get a list of all the services in the registry
            String[] services = Naming.list("//localhost/");
            System.out.println("Services in the registry:");
            for (String service : services) {
                System.out.println(service);
            }

            System.out.println("HelloRMI server is ready....");

        } catch (Exception e) {
            System.err.println("HelloRMI server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}