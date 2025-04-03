package registros.imagen;

// Esta es una clase que recibe en el constructor un entero ARGB y lo
// descompone en Alpha, Red, Gree, Blue para poder modificarlos individualmente
// y despues obtenerlos como un valor entero ARGB nuevamente
public class PixelARGB {
    private int alpha;
    private int colorRed;
    private int colorGreen;
    private int colorBlue;
    private int colorIntOriginal;
    private int colorIntModificado;

    public PixelARGB(int colorIntOriginal) {
        this.colorIntOriginal = colorIntOriginal;
        descomponer(); // Este metodo extrae los diferentes campos ARGB del  entero original
    }

    // Este metodo descompone el entero original en Alpha, Red, Green, Blue
    public void descomponer(){
        // Triple >>> para que tambien mueva el bit del signo
        alpha = (colorIntOriginal & 0xFF000000) >>> 24;
        colorRed = (colorIntOriginal & 0x00FF0000) >> 16;
        colorGreen = (colorIntOriginal & 0x0000FF00) >> 8;
        colorBlue = (colorIntOriginal & 0x000000FF);
    }

    // Este metodo compone Alpha, Red, Green, Blue a un Entero ARGB de nuevo
    public void recomponer(){
        colorIntModificado = (alpha << 24) | (colorRed << 16) | (colorGreen) << 8 | (colorBlue);
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public int getColorRed() {
        return colorRed;
    }

    public void setColorRed(int colorRed) {
        this.colorRed = colorRed;
    }

    public int getColorGreen() {
        return colorGreen;
    }

    public void setColorGreen(int colorGreen) {
        this.colorGreen = colorGreen;
    }

    public int getColorBlue() {
        return colorBlue;
    }

    public void setColorBlue(int colorBlue) {
        this.colorBlue = colorBlue;
    }

    public int getColorIntOriginal() {
        return colorIntOriginal;
    }

    public void setColorIntOriginal(int colorIntOriginal) {
        this.colorIntOriginal = colorIntOriginal;
        descomponer();
    }

    public int getColorIntModificado() {
        recomponer();
        return colorIntModificado;
    }
}
