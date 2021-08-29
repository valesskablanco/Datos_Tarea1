package scr;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Server {

    /**
    * Servidor
    * Clase que crea el servidor y logra el cálculo de los datos
    * @author Valesska Blanco / ITCR
    * @version 0.1, 2021/08/28
    */

    private static final int puerto = 9090;

    public static void main(String[] args) throws IOException {
        
        ServerSocket server = new ServerSocket(puerto);

        System.out.println("[SERVER] Esperando conexón...");
        Socket client = server.accept();
        System.out.println("[SERVER] Cliente conectado.");

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        try {

            while (true) {

                String datos = in.readLine();
                out.println(obtenerDato(datos));

            }

        } finally {

        server.close();
        client.close();
    }

    }

    public static double obtenerDato(String datos) {

        /**
        * Calculadora del monto del producto
        * Este método recorre un string, extrayendo los datos útiles
        * y los convierte a datos de tipo double. Luego realiza el cálculo y finaliza.
        * @param param1 Recibe una cadena de caracteres que incluye números y tokens "."
        * @return Monto calculado para el producto
        */

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