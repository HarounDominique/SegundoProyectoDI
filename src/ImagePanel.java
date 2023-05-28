import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    private BufferedImage image;

    public ImagePanel(String imageSource) {

        try {
            // Cargar la imagen desde la carpeta "images" dentro del proyecto
            image = ImageIO.read(getClass().getResource("/Resources/Images/"+imageSource));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen en el panel
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}