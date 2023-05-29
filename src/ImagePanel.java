import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
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

    public void setImageUrl(String imageUrl) {
        try {
            URL resourceUrl = getClass().getResource(imageUrl);
            if (resourceUrl != null) {
                image = ImageIO.read(resourceUrl);
                repaint(); // Repintar el panel con la nueva imagen
            } else {
                System.err.println("Image resource not found: " + imageUrl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}