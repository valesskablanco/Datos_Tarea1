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
        
        GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap().addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup().addComponent(txtPuertoEnviar)
								.addComponent(txtTextoEnviar).addComponent(btnEnviar)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
						.addGroup(layout.createSequentialGroup().addComponent(jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)))
						.addContainerGap()));

		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(txtPuertoEnviar).addComponent(txtTextoEnviar).addComponent(btnEnviar))

				.addContainerGap()));

		pack();
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        
    }
    
}
