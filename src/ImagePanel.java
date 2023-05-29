import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class ImagePanel extends JPanel implements Serializable {
    private BufferedImage image;
    private ImageTimer imageTimer;

    public ImagePanel(String imageSource) {
        try {
            // Cargar la imagen desde la carpeta "images" dentro del proyecto
            image = ImageIO.read(getClass().getResource("/Resources/Images/"+imageSource+"1.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Crear un objeto ImageTimer que se ejecute cada 3 segundos
        imageTimer = new ImageTimer(3000, new ActionListener() {
            int count = 1;
            public void actionPerformed(ActionEvent e) {
                // Cambiar la imagen que se muestra en el panel
                try {
                    image = ImageIO.read(getClass().getResource("/Resources/Images/"+imageSource + count + ".jpg"));
                    count++;
                    if (count > 3) {
                        count = 1;
                    }
                    repaint();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        imageTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen en el panel
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(imageTimer);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        imageTimer = (ImageTimer) in.readObject();
        imageTimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cambiar la imagen que se muestra en el panel
                try {
                    image = ImageIO.read(getClass().getResource("/Resources/Images/image" + imageTimer.getCount() + ".jpg"));
                    repaint();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        imageTimer.start();
    }

    private class ImageTimer extends Timer implements Serializable {
        private int count;

        public ImageTimer(int delay, ActionListener listener) {
            super(delay, listener);
            count = 1;
        }

        public int getCount() {
            return count;
        }

        public void actionPerformed(ActionEvent e) {
            super.fireActionPerformed(e);
            count++;
            if (count > 3) {
                count = 1;
            }
        }
    }
}


