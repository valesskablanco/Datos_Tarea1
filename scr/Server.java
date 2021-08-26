package scr;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.StringTokenizer;

public class Server /*implements Runnable*/ {
    
    static int port = 5000;

    //@Override
    //public void run() {
    public static void main(String args[]){

        ServerSocket servidor = null;
        Socket clientSocket = null;
        DataInputStream inputStream;

        try {

            servidor = new ServerSocket(port);
            System.out.print("Servidor Iniciado");

            while (true) {

                clientSocket = servidor.accept();
                System.out.println("Cliente conectado");
                inputStream = new DataInputStream(clientSocket.getInputStream());

                String datos = inputStream.readUTF();
                String[] mensaje = separaDatos(datos); //Datos separados en números enteros
                System.out.println(mensaje[0]+mensaje[1]+mensaje[2]);

                //this.setChanged();
                //this.notifyObservers(datos);
                //this.clearChanged();

                clientSocket.close();
                System.out.println("Cliente desconectado");

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
    
}
