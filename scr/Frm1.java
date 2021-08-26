package scr;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")

public class Frm1 extends javax.swing.JFrame implements Observer {

    public Frm1() {

        initComponents();

        this.getRootPane().setDefaultButton(this.btnEnviar);
        Server s = new Server(5000);
        s.addObserver(this);
        Thread t = new Thread(s);
        t.start();
    }

    @SuppressWarnings("unchecked")

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {

        String datos = "1: " + this.txtTextoEnviar.getText() + "\n";

        this.txtTexto.append(datos);

        Client c = new Client(datos, 6000);
        Thread t = new Thread(c);
        t.start();
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {

                new Frm1().setVisible(true);
            }
        });
    }

    //Declaracion de variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JScrollPane jScrollPanel;
    private javax.swing.JTextArea txtTexto;
    private javax.swing.JTextField txtTextoEnviar;
    //Fin de declaración de variables


    @Override
    public void update(Observable o, Object arg) {
        
        this.txtTexto.append(arg);
        
    }
    
}
