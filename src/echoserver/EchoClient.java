package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;

public class EchoClient {
    public static final int PORT = 6013;

    public static void main(String[] args) {
        String server;
        if (args.length == 0){
            server = "127.0.0.1";
        } else {
            server = args[0];
        }
        try {
            Socket socket = new Socket("localhost", PORT);
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            int b;
            while ((b = System.in.read()) >= 0) {
                output.write(b);
                System.out.write(input.read());
                b = System.in.read();
            }
            output.flush();
            System.out.flush();
            socket.close();

        } catch (ConnectException ce) {
            System.out.println("We were unable to connect to " + server);
            System.err.println("You should make sure the server is running.");
        } catch (IOException ioe) {
            System.out.println("We caught an exception");
            System.err.println(ioe);
        }
    }
}