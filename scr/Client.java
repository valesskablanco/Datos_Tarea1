package scr;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements Runnable {
    
    private String datos;

    @Override

    public void run() {

        final String host = "127.0.0.1";
        final int port = 5000;
        DataOutputStream outputStream; //objeto usado para enviar los datos

        try{

            Socket socketClient = new Socket(host, port);
            outputStream = new DataOutputStream(socketClient.getOutputStream());
            outputStream.writeUTF(datos);
            socketClient.close();


        } catch (IOException ex) {
            
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
