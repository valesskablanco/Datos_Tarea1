package scr;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client /*implements Runnable*/ {
    

    //@Override

    //public void run() {
    public static void main(String args[]) {

        final String host = "127.0.0.1";
        final int port = 5000;
        DataOutputStream outputStream; //objeto usado para enviar los datos

        try{

            Socket socketClient = new Socket(host, port);
            outputStream = new DataOutputStream(socketClient.getOutputStream());
            outputStream.writeUTF("Hola mundo desde el cliente");
            socketClient.close();


        } catch (IOException ex) {
            
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
