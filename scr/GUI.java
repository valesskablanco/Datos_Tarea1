package scr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.StringTokenizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("deprecation")

public class GUI extends JFrame implements Observer {

    private JButton btnEnviar;
	private JButton btnChats;
	private JScrollPane jScrollPane1;
	private JTextArea txtTexto;
	private JTextField txtTextoEnviar;
	private JTextField txtPuertoEnviar;
	private JLabel puerto;
    private JPopupMenu jPopupMenu;
    
    static JFrame frame;

    Server servidor = new Server();

    private static final long serialVersionUID = 1L;

    public GUI() {

        servidor.addObserver(this);
        Thread t = new Thread(servidor);
        t.start();
        initComponets();

    }
    
    public void initComponets() {

        jScrollPane1 = new JScrollPane();
        
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        
    }
    
}
