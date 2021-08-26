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
	private JScrollPane jScrollPane1;
	private JTextArea txtTexto;
	private JTextField txtTextoEnviar;
	private JTextField txtPuertoEnviar;

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
        txtTexto = new JTextArea();
		btnEnviar = new JButton();
		txtTextoEnviar = new JTextField(25);
        txtPuertoEnviar = new JTextField(3);
        
        txtTexto.setColumns(20);
		txtTexto.setRows(5);
        jScrollPane1.setViewportView(txtTexto);
        
        btnEnviar.setText("Enviar");
		btnEnviar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnEnviarActionPerformed(evt);
			}
        });
        
        // investigar sobre GroupLayout
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        
    }
    
}
