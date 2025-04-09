package echoserver;

import java.io.*;
import java.net.*;

public class EchoServer {
    public static final int PORT = 6013;

    public static void main(String[] args) {

        try {
            ServerSocket sock = new ServerSocket(PORT);
            while (true) {
                Socket client = sock.accept();
                System.out.println("Request Received");
                InputStream input = client.getInputStream();
                OutputStream output = client.getOutputStream();
                int b;
                while ((b = input.read()) != -1) {
                    output.write(b);
                }
                client.close();
            }
        } catch (IOException ioe) {
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }
    }
}