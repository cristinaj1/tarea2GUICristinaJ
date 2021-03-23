/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

/**
 *
 * @author Cris
 */
public class Saludo extends JPanel implements ActionListener {

    private Random random = new Random();
    private JLabel numero;
    private JButton botonSaludar, botonDespedir, botonAleatorio;
    private JTextArea texto;

    public Saludo() {
        initComponents();
    }

    private void initComponents() {

        botonSaludar = new JButton("Nombre");
        botonDespedir = new JButton("Apellidos");
        botonAleatorio = new JButton("Generar Aleatorio");
        numero = new JLabel("Número");
        texto = new JTextArea(1, 25);
        texto.setBackground(Color.ORANGE);

        this.setLayout(new FlowLayout());

        //El orden en el que se añade es como aparecerá en el panel
        this.add(botonSaludar);
        this.add(botonDespedir);
        // Añadimos el botón al panel
        this.add(botonAleatorio);
        this.add(numero);
        this.add(texto);

        // Controlador del evento
        botonSaludar.addActionListener(this);
        botonDespedir.addActionListener(this);
        botonAleatorio.addActionListener(this);
        botonAleatorio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                botonAleatorio.setBackground((Color.PINK));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonAleatorio.setBackground(UIManager.getColor("control"));
            }
        });

    }

    // Sobrescribimos el método de la interfaz
    @Override
    public void actionPerformed(ActionEvent ae) {
        // Si el botón pulsado es botonSaludar
        if (ae.getSource() == botonSaludar) {
            texto.setText("Cristina");
            texto.setBackground(Color.white);
        } else if (ae.getSource() == botonDespedir) {
            texto.setText("Jiménez Fernández");
            texto.setBackground(Color.blue);
        } else if (ae.getSource() == botonAleatorio) {
            int numRandom = random.nextInt(11);
            numero.setText(String.valueOf(numRandom));
        }
    }

}
