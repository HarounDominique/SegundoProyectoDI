import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    JPanel paSu;
    public Ventana(){
        this.setLayout(new GridLayout(2,1));
        paSu = new JPanel();
        this.add(paSu);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setTitle("Hola");
    }
}
