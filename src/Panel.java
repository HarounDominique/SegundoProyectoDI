import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    public Panel() {
        //this.setLayout(new BorderLayout());
        JLabel l = new JLabel();
        l.setText("Hola");
        this.add(l);
    }

}
