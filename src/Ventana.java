import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Ventana extends JFrame {
    JPanel northPanel;
    JPanel centerPanel;
    JPanel southPanel;

    Contador c1;
    Contador c2;
    Contador c3;

    public Ventana() {

        this.setLayout(new BorderLayout());
        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        //botones

        JButton buttonInfantil = new JButton("INFANTIL");

        JButton buttonRomantica = new JButton("ROMÁNTICA");

        JButton buttonTerror = new JButton("TERROR");

        JButton buttonReiniciar = new JButton("Reiniciar");

        JButton buttonSalir = new JButton("Salir");

        //contraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 10, 5, 10);

        //northPanel
        northPanel.setLayout(new GridBagLayout());
        northPanel.add(buttonInfantil, constraints, 0);
        northPanel.add(buttonRomantica, constraints, 1);
        northPanel.add(buttonTerror, constraints, 2);

        //southPanel
        constraints.gridx = 0;
        southPanel.setLayout(new GridBagLayout());
        southPanel.add(buttonReiniciar, constraints);
        constraints.gridx = 2;
        southPanel.add(buttonSalir, constraints);

        buttonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //centerPanel
        centerPanel.setLayout(new GridBagLayout());
        // Crear los ImagePanel
        ImagePanel ip1 = new ImagePanel("infantil");
        c1 = new Contador(ip1);
        //botón infantil:
        buttonInfantil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1.startContador();
            }
        });
        ImagePanel ip2 = new ImagePanel("romantica");
        c2 = new Contador(ip2);
        //botón romántica
        buttonRomantica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c2.startContador();
            }
        });
        ImagePanel ip3 = new ImagePanel("terror");
        c3 = new Contador(ip3);
        //botón terror
        buttonTerror.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c3.startContador();
            }
        });

        // Configurar las restricciones para ocupar todo el espacio disponible
        constraints.fill = GridBagConstraints.BOTH; // Ocupar tanto el ancho como el alto del espacio disponible
        constraints.weightx = 1.0; // Peso horizontal
        constraints.weighty = 1.0; // Peso vertical

        // Agregar los ImagePanel al contenedor con las restricciones
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        centerPanel.add(ip1, constraints);

        constraints.gridx = 1;
        centerPanel.add(ip2, constraints);

        constraints.gridx = 2;
        centerPanel.add(ip3, constraints);

        //botón reiniciar:
        buttonReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    c1.resetContador();
                    c2.resetContador();
                    c3.resetContador();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);


        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setTitle("Hola");
    }
}

