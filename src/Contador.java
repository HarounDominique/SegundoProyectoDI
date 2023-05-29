import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.SwingUtilities;

public class Contador implements Runnable, Serializable {
    private int tiempo = 0;
    private boolean activo;
    private ImagePanel imagePanel;
    private int counter = 0;

    public Contador(ImagePanel imagePanel) {
        this.imagePanel = imagePanel;
    }

    public void startContador() {
        activo = true;
        tiempo = 0;
        Thread thread = new Thread(this);  // Crear un nuevo hilo para ejecutar el contador
        thread.start();  // Iniciar el hilo
    }

    public void stopContador() {
        activo = false;
    }

    public void resetContador() throws IOException {
        counter = 1;
        //tiempo = 0;
        // Restaurar imágenes iniciales en los ImagePanel
        //imagePanel.setImage(ImageIO.read(getClass().getResource("/Resources/Images/" + imagePanel.getImageSource() + counter + ".jpg")));
        imagePanel.setImageUrl("/Resources/Images/" + imagePanel.getImageSource() + counter + ".jpg");
    }

    @Override
    public void run() {
        while (activo) {
            try {
                Thread.sleep(1000); // Esperar 1 segundo
                tiempo++;
                if (tiempo == 3) {
                    if (counter != 3) {
                        counter++;
                        // Cambia imágenes en los ImagePanel
                        SwingUtilities.invokeLater(() -> {
                            try {
                                imagePanel.setImageUrl("/Resources/Images/" + imagePanel.getImageSource() + counter + ".jpg");
                                System.out.println("dentro del bucle while de contador:"+counter+". Tiempo:"+tiempo);
                            } catch (/*IO*/Exception e) {
                                e.printStackTrace();
                            }
                        });
                        tiempo = 0;
                    } else {
                        counter = 1;
                        // Cambiar imágenes en los ImagePanel
                        SwingUtilities.invokeLater(() -> {
                            try {
                                imagePanel.setImageUrl("/Resources/Images/" + imagePanel.getImageSource() + counter + ".jpg");
                                System.out.println("dentro del bucle while de contador:"+counter+". Tiempo:"+tiempo);
                            } catch (/*IO*/Exception e) {
                                e.printStackTrace();
                            }
                        });
                        tiempo = 0;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}