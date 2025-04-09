package echoserver;

import java.io.*;
import java.net.*;

public class EchoClient {
    public static final int PORT = 6013;

    public static void main(String[] args) throws IOException{
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
            while ((b = System.in.read()) != -1) {
                output.write(b);
                System.out.write(input.read());
            }
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