package scr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientHandler implements Runnable {

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket clientSocket) throws IOException {
        
        this.client = clientSocket;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
    }

    @Override
    public void run() {
        
        try {

            while (true) {

                String datos = in.readLine();
                out.println(Server.obtenerDato(datos));

            }

        } catch (IOException e) {
            
            System.err.println("IOException in ClientHandler");
            System.err.println(e.getStackTrace());
            
        } finally {

            try {

                in.close();

            } catch (IOException e) {

                e.printStackTrace();
            }
            
            out.close();
    }
        
    }
    
}
