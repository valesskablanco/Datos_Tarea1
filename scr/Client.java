package scr;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements Runnable {

    private String datos;
    private int puerto;

    public Client(String datos, int puerto) {
        
        this.datos = datos;
        this.puerto = puerto;
    }

    @Override
    public void run() {

        final String host = "127.0.0.1";
        DataOutputStream outputStream; //objeto usado para enviar los datos

        try {

            Socket socketClient = new Socket(host, puerto);
            outputStream = new DataOutputStream(socketClient.getOutputStream());
            outputStream.writeUTF(datos);
            socketClient.close();

        } catch (IOException ex) {

            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}