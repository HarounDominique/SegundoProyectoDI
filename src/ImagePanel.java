import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel implements Serializable {

    private String imageSource;
    private BufferedImage image;

    public ImagePanel(String imageSource) {

        this.imageSource = imageSource;

        int counter = 1;

        try {
            // Cargar la imagen desde la carpeta "images" dentro del proyecto
            image = ImageIO.read(getClass().getResource("/Resources/Images/" + imageSource + counter + ".jpg"));
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

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}