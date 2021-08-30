package scr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

    /**
    * GUI
    * Clase que crea la interfaz gráfica donde ocurre la comunicacion clientes-servidor
    * @author Valesska Blanco / ITCR
    * @version 0.1, 2021/08/28
    */


public class GUI extends JFrame implements ActionListener {

    public JPanel panel;
    public JButton btnSend;
    public JTextField insertadatos;
    public JLabel total;
    public JLabel instruccion;
    public JLabel instruccion2;
    public JLabel monto;
    public String datos;

    public GUI() {
        
        setTitle("Cliente");
        setVisible(true);
        setSize(300, 300);
        setBackground(Color.getColor("white"));

        panel = new JPanel();
        this.getContentPane().add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.getColor("gray"));

        btnSend = new JButton("Enviar");
        btnSend.setSize(150,50);
        btnSend.setLocation(65, 200);
        btnSend.addActionListener(this);
        panel.add(btnSend);

        instruccion = new JLabel("Indique los datos del producto:");
        instruccion.setBounds(50, 7, 300, 25);
        panel.add(instruccion);

        instruccion2 = new JLabel("         valor.porcentaje.peso ");
        instruccion2.setBounds(50, 30, 300, 25);
        panel.add(instruccion2);

        insertadatos = new JTextField();
        insertadatos.setBounds(50, 60, 200, 25);
        panel.add(insertadatos);

        total = new JLabel("         El monto calculado es: ");
        total.setBounds(50, 85, 200, 25);
        panel.add(total);

        monto = new JLabel(datos);
        monto.setBounds(50, 100, 200, 25);
        panel.add(monto);

        setResizable(false);
        panel.repaint();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnSend){

            datos = insertadatos.getText();
            System.out.println(Server.obtenerDato(datos));

        }
        
    }

    
}
