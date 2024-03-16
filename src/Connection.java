import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class Connection extends Thread {
    private Socket outputLine;
    private final int WRITE_LINE = 3;

    public Connection(Socket s) {
        this.outputLine = s;
    }

    @Override
    public void run() {

        try {
            // create a new data output stream
            DataOutputStream poutdata = new DataOutputStream(outputLine.getOutputStream());

            // send a message to the client
            for (int i = 0; i < WRITE_LINE; i++){
                poutdata.writeDouble(1.5);
                Thread.sleep(1000);
            }

            // close socket
            outputLine.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
