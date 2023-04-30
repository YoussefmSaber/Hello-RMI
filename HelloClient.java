import java.rmi.Naming;

public class HelloClient {

    public static void main(String[] args) {
        try {
            
            // Clear screen
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Get a reference to the remote object
            HelloService helloService = (HelloService) Naming.lookup("//localhost/Hello");
            System.out.println(helloService.sayHello());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}