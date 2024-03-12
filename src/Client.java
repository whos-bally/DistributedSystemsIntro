import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private final int READ_LINES = 3;

    public Client(){
        try{
            System.out.println("Hello");
            Socket s = new Socket("127.0.0.1", 5155);
            InputStream in = s.getInputStream();
            BufferedReader buffReader = new BufferedReader(new InputStreamReader(in));

            // print buffered reader contents
           for (int i = 0; i < READ_LINES; i++){
               System.out.println(buffReader.readLine());
           }


            // close socket
            s.close();
        } catch (UnknownHostException e) {
            System.out.println("Unknown Host");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args){
        Client c = new Client();
    }
}
