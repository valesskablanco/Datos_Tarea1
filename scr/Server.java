package scr;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.crypto.Data;

import java.util.StringTokenizer;

public class Server implements Runnable {
    
    static int port = 5000;
    static int myport;
    private int mipuerto;

    @Override
    public void run() {

        ServerSocket servidor = null;
        Socket clientSocket = null;
        DataInputStream inputStream;

        try {

            //suave
        } catch {

            //
        }
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
    
}
