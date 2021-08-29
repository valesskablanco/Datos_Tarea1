package scr;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* Servidor.
* Clase que crea el servidor y logra el cálculo de los datos
* @author Valesska Blanco / ITCR
* @version 0.1, 2021/08/28
*/

public class Server {

    private static final int puerto = 9090;
    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(2);

    @SuppressWarnings({ "resource" })

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(puerto);

        while (true) {

            System.out.println("[SERVER] Esperando conexón...");
            Socket client = server.accept();
            System.out.println("[SERVER] Cliente conectado.");
            ClientHandler clientThread = new ClientHandler(client);
            clients.add(clientThread);

            pool.execute(clientThread);

        }

    }

/**
* Calculadora del monto del producto
* Este método recorre un string, extrayendo los datos útiles
* y los convierte a datos de tipo double. Luego realiza el cálculo y finaliza.
* @param param1 Recibe una cadena de caracteres que incluye números y tokens "."
* @return Monto calculado para el producto
*/

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