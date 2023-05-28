public class Contador extends Thread {
    private int tiempo;
    private boolean activo;
    private ImagePanel imagePanelInfantil;
    private ImagePanel imagePanelRomantica;
    private ImagePanel imagePanelTerror;

    public Contador(ImagePanel imagePanelInfantil, ImagePanel imagePanelRomantica, ImagePanel imagePanelTerror) {
        this.imagePanelInfantil = imagePanelInfantil;
        this.imagePanelRomantica = imagePanelRomantica;
        this.imagePanelTerror = imagePanelTerror;
    }

    public void startContador() {
        activo = true;
        tiempo = 0;
        while (activo) {
            try {
                Thread.sleep(1000); // Esperar 1 segundo
                tiempo++;
                if (tiempo == 3) {
                    // Cambiar imágenes en los ImagePanel
                    imagePanelInfantil(""));
                    imagePanelRomantica.setImage("nueva_imagen_romantica.jpg");
                    imagePanelTerror.setImage("nueva_imagen_terror.jpg");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopContador() {
        activo = false;
    }

    public void resetContador() {
        tiempo = 0;
        // Restaurar imágenes iniciales en los ImagePanel
        imagePanelInfantil.setImage("imagen_inicial_infantil.jpg");
        imagePanelRomantica.setImage("imagen_inicial_romantica.jpg");
        imagePanelTerror.setImage("imagen_inicial_terror.jpg");
    }
}