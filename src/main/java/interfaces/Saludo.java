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
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Cris
 */
public class Saludo extends JPanel implements ActionListener {

    private JButton botonSaludar;
    private JTextArea texto;

    public Saludo() {
        initComponents();
    }

    private void initComponents() {

        botonSaludar = new JButton("Saludar");
        texto = new JTextArea(1, 25);
        texto.setBackground(Color.ORANGE);

        this.setLayout(new FlowLayout());

        this.add(botonSaludar);
        this.add(texto);

// Se le indica al objeto boton que escuche eventos tipo click
// y se pasa como argumento una referencia de tipo ActionListener
// En este caso se pasa this que es el panel sobre el 
// que está el botón y que implementa la interfaz ActionListener
        botonSaludar.addActionListener(this);

    }

    // Sobrescribimos el método de la interfaz
    public void actionPerformed(ActionEvent ae) {

        // Este ejemplo es tan básico que no hemos usado el objeto ae
// Indicamos el texto que queremos mostrar en el área de texto
        texto.setText("Hola amigos!!");
    }

}

