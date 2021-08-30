package scr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

    /**
    * ClientHandler.
    * Clase que maneja varios clientes y les comunica con el servidor
    * @author Valesska Blanco / ITCR
    * @version 1.0, 2021/08/29
    */

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
            
            System.err.println("Cliente Desconectado...");
            
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
