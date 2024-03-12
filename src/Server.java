import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private Socket socket;
    private Connection conn;

    public Server(){

        // create new socket to listen to
        try{
            serverSocket = new ServerSocket(5155);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // listen for connections
        System.out.println("****** Server is listening ******");

        try {
            while(true){
                // Accept client socket
                socket = serverSocket.accept();
                // Create a thread for client service
                conn = new Connection(socket);
                conn.start();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }



    public static void main(String[] args){
        Server s = new Server();
    }
}
