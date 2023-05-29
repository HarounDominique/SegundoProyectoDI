import javax.imageio.ImageIO;
import java.io.IOException;

public class Contador extends Thread {

    private int tiempo;
    private boolean activo;
    private ImagePanel imagePanel;
    private int counter=1;

    public Contador(ImagePanel imagePanel) {
        this.imagePanel = imagePanel;
    }

    public void startContador() {
        activo = true;
        tiempo = 0;
        while (activo) {
            try {
                Thread.sleep(1000); // Esperar 1 segundo
                tiempo++;
                if (tiempo == 3) {
                    counter++;
                    // Cambiar imágenes en los ImagePanel
                    imagePanel.setImage(ImageIO.read(getClass().getResource("/Resources/Images/" + imagePanel.getImageSource() + counter + ".jpg")));
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopContador() {
        activo = false;
    }

    public void resetContador() {
        counter = 1;
        tiempo = 0;
        // Restaurar imágenes iniciales en los ImagePanel
        imagePanel.setImage(ImageIO.read(getClass().getResource("/Resources/Images/" + imagePanel.getImageSource() + counter + ".jpg");

    }


}