package scr;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.crypto.Data;

import java.util.Observable;
import java.util.StringTokenizer;

public class Server extends Observable implements Runnable {
    
    static int port = 5000;
    static int myport;
    private int mipuerto;

    @Override
    public void run() {

        ServerSocket servidor = null;
        Socket clientSocket = null;
        DataInputStream inputStream;

        try {

            myport = findPort(servidor, clientSocket);
            servidor = new ServerSocket(myport);
            mipuerto = servidor.getLocalPort();

            while (true) {

                clientSocket = servidor.accept();
                inputStream = new DataInputStream(clientSocket.getInputStream());

                String datos = inputStream.readUTF();
                System.out.println(datos);

                this.setChanged();
                this.notifyObservers(datos);
                this.clearChanged();
                
            }
        } catch (IOException ex) {

            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);

            //Handle exception
        }
    }
    
    public static String[] separaDatos(String datos) {
        
        StringTokenizer tokens = new StringTokenizer(datos, ".");
        String[] datosArray = new String[tokens.countTokens()];
        int i = 0;

        while (tokens.hasMoreTokens()) {
            
            String num = tokens.nextToken();
            datosArray[i] = num;
            i++;

        }
        return datosArray;


    }

    public static int findPort(ServerSocket servidor, Socket clientSocket) {

        int puerto;
        puerto = port;

        boolean freePort = false;

        while (!freePort) {

            try {

                servidor = new ServerSocket(puerto);
                Server.port = puerto;
                servidor.close();
                freePort = true;
                System.out.println("Servidor en" + puerto);

            } catch (Exception e2) {

                System.out.println("Puerto ocupado, intentando con el siguiente...");
                puerto++;
            }

        }
        return puerto;
    }

    public int getPort() {
        
        return mipuerto;
    }
    
}
