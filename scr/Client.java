package scr;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements Runnable {
    
    private String send;
    private String port;

    public Client(String port, String send) {

        this.send = send;
        this.port = port;
    }
    
    @Override

    public void run() {

        // ahí vamos
    }
    
}
