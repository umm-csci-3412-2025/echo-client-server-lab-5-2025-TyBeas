package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static final int PORT = 6013;

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(PORT);
            int b;
            while (true) {
                Socket client = server.accept();
                InputStream input = client.getInputStream();
                OutputStream output = client.getOutputStream();
                while ((b = input.read()) >= 0) {
                    output.write(b);
                }
                output.flush();
                client.close();
                sock.close();
            }
        } catch (IOException ioe) {
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }
    }
}