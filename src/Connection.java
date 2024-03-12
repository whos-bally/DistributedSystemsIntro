import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class Connection implements Runnable {
    private Socket outputLine;

    public Connection(Socket s) {
        this.outputLine = s;
    }

    @Override
    public void run() {

        System.out.println("Connection running");

        try {
            // create a new printwriter with autoflushing
            PrintWriter pout = new PrintWriter(outputLine.getOutputStream(), true);

            // send a message to the client
            pout.println("The Date and Time is: " + new Date().toString());

            // close socket
            outputLine.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
