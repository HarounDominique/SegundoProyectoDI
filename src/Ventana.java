import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Ventana extends JFrame {
    JPanel northPanel;
    JPanel centerPanel;
    JPanel southPanel;

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


        //centerPanel
        centerPanel.setLayout(new GridBagLayout());
        // Crear los ImagePanel
        ImagePanel ip1 = new ImagePanel("infantil");
        ImagePanel ip2 = new ImagePanel("infantil");
        ImagePanel ip3 = new ImagePanel("infantil");

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


        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);


        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setTitle("Hola");
    }
}

