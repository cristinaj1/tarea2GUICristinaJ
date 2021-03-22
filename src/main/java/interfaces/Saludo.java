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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Cris
 */
public class Saludo extends JPanel implements ActionListener {
    
    private JButton botonSaludar, botonDespedir;
    private JTextArea texto;
    
    public Saludo() {
        initComponents();
    }
    
    private void initComponents() {
        
        botonSaludar = new JButton("Nombre");
        botonDespedir = new JButton("Apellidos");
        texto = new JTextArea(1, 25);
        texto.setBackground(Color.ORANGE);
        
        this.setLayout(new FlowLayout());
        
        this.add(botonSaludar);
        this.add(texto);
        // Añadimos el botón al panel
        this.add(botonDespedir);
        // Controlador del evento
        botonDespedir.addActionListener(this);

// Se le indica al objeto boton que escuche eventos tipo click
// y se pasa como argumento una referencia de tipo ActionListener
// En este caso se pasa this que es el panel sobre el 
// que está el botón y que implementa la interfaz ActionListener
        //botonSaludar.addActionListener(this);
        // Clase anónima (sin nombre) anidada (dentro de un método)
        botonSaludar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText("Cristina");
                texto.setBackground(Color.white);
            }
        });
        botonDespedir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText("Jiménez Fernández");
                texto.setBackground(Color.blue);
            }
        });
        botonDespedir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonDespedirActionPerformed(e);
            }
            
            private void botonDespedirActionPerformed(ActionEvent e) {
                //Código a ejecutar
            }
        });
        
    }

    // Sobrescribimos el método de la interfaz
    public void actionPerformed(ActionEvent ae) {
        // Este ejemplo es tan básico que no hemos usado el objeto ae
        // Indicamos el texto que queremos mostrar en el área de texto
        //texto.setText("Hola amigos!!");
        // Si el botón pulsado es botonSaludar
        if (ae.getSource() == botonSaludar) {
            texto.setText("Cristina");
        } else {
            texto.setText("Jiménez Fernández");
        }
    }
    public static void main(String[] args) {
        // Construimos la ventana
        JFrame frame = new JFrame("App");
        // La ventana no se puede redimensionar
        frame.setResizable(false);
        // Posición de la ventana
        frame.setLocationRelativeTo(null);
        // Incluimos el panel en la ventana
        frame.add(new Saludo());
        // Ajusta el frame al contenido
        frame.pack();
        // Hacemos visible la ventana
        frame.setVisible(true);
        //Acción por defecto al pulsar el botón de cierre de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
}
