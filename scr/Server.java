package scr;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Server {

    private static final int puerto = 5000;

    public static void main(String[] args) throws IOException {
        
        ServerSocket server = new ServerSocket(puerto);

        System.out.println("[SERVER] Esperando conexón...");
        Socket client = server.accept();
        System.out.println("[SERVER] Cliente conectado.");

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        out.println(obtenerDato("Aquí llega el mensaje"));

        server.close();
        client.close();

    }

    public static double obtenerDato(String datos) {

        StringTokenizer tokens = new StringTokenizer(datos, ".");
        String[] datosArray = new String[tokens.countTokens()];
        int i = 0;

        while (tokens.hasMoreTokens()) {

            String num = tokens.nextToken();
            datosArray[i] = num;
            i++;
        }

        double valor = Integer.parseInt(datosArray[0]);
        double porcentaje = Integer.parseInt(datosArray[1]);
        double peso = Integer.parseInt(datosArray[2]);

        double monto = (valor * porcentaje / 100) + (peso * 0.15);

        return monto;

    }

}