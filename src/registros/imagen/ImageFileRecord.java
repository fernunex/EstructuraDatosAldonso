package registros.imagen;

import ednolineal.Arreglo2DNumerico;
import entradasalida.Salida;
import tools.enumerados.FactorEscalado;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ImageFileRecord {
    private String path;
    private BufferedImage image;
    private int alto;
    private int ancho;
    private Arreglo2DNumerico imageMatriz;


    // Pasar la ruta absoluta absoluto
    public ImageFileRecord(String ruta) {
        path = ruta;

        // Leemos la imagen
        try {
            image = ImageIO.read(new File(ruta));
        } catch (IOException e) { // No se pudo leer por algo y terminamos inmediatamente
            Salida.salidaPorDefecto("Ocurrio un error:\n");
            Salida.salidaPorDefecto(e.toString());
            System.exit(0);
        }

        // Si se pudo leer entonces podemos trabajar con la imagen buffered
        alto = image.getHeight();
        ancho = image.getWidth();
        imageMatriz = new Arreglo2DNumerico(alto, ancho);
        pasarAMatriz();
//        System.out.println(alto);
//        System.out.println(ancho);


    }

    // Punto 1
    // Este metodo pasa la imageBuffered a nuestra matriz numerica
    public void pasarAMatriz() {
        int pixelNumber;

        for (int indexPixelAlto = 0; indexPixelAlto < alto; indexPixelAlto++) {

            for (int indexPixelAncho = 0; indexPixelAncho < ancho; indexPixelAncho++) {

                pixelNumber = image.getRGB(indexPixelAncho, indexPixelAlto); // La x son las columnas, y son las filas
                imageMatriz.cambiar(indexPixelAlto, indexPixelAncho, pixelNumber);

            }
        }
    }

    // Este metodo guarda la matriz actual en una nueva imagen y la graba en disco
    // Se debe especificar la ruta absoluta
    public boolean grabarImagen(String ruta) {
        BufferedImage imagen2 = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);

        int pixelNumber;

        for (int indexPixelAlto = 0; indexPixelAlto < alto; indexPixelAlto++) {

            for (int indexPixelAncho = 0; indexPixelAncho < ancho; indexPixelAncho++) {

                pixelNumber = imageMatriz.obtener(indexPixelAlto, indexPixelAncho);
                imagen2.setRGB(indexPixelAncho, indexPixelAlto, pixelNumber);
            }
        }
        try{
            ImageIO.write(imagen2, "PNG", new File(ruta));
            return true;
        } catch (IOException e) {
            Salida.salidaPorDefecto("Ocurrió un error:\n");
            Salida.salidaPorDefecto(e.toString());
            return false;
        }
    }


    // Punto 3 Escala Grises
    // Este metodo convierte la imagen a una imagen en escala de grises
    public boolean convertirEscalaGrises(){
        if ((alto > 0 && ancho > 0) == false){
            return false;
        } else {
            int pixelNumber, promedio;
            PixelARGB pixel;

            for (int indexFila = 0; indexFila < alto; indexFila++){
                for (int indexColumna = 0; indexColumna < ancho; indexColumna++){
                    pixelNumber = imageMatriz.obtener(indexFila, indexColumna);

                    // Convertimos a pixel
                    pixel = new PixelARGB(pixelNumber);

                    // Calculamos el promedio
                    promedio = (pixel.getColorRed() + pixel.getColorGreen() + pixel.getColorBlue()) / 3;

                    // Reasignamos el promedio a todos los 3 colores
                    pixel.setColorRed(promedio);
                    pixel.setColorGreen(promedio);
                    pixel.setColorBlue(promedio);

                    // Reasignamos el valor en la matriz
                    imageMatriz.cambiar(indexFila, indexColumna, pixel.getColorIntModificado());
                }
            }
            return true;
        }
    }

    // Punto 4 Brillo
    // Este metodo aumenta o disminuye el brillo segun el valor indicado
    public boolean modificarBrillo(int cantidad){
        if (alto > 0 && ancho > 0){
            int pixelNumber, nuevaEscala;
            PixelARGB pixel;

            for (int indexFila = 0; indexFila < alto; indexFila++){

                for (int indexColumna = 0; indexColumna < ancho; indexColumna++){
                    pixelNumber = imageMatriz.obtener(indexFila, indexColumna);

                    // Convertimos a pixel
                    pixel = new PixelARGB(pixelNumber);

                    // Modificamos el brillo
                    nuevaEscala = pixel.getColorBlue() + cantidad;

                    if (nuevaEscala > 255){ // Se paso de blanco, entonces lo dejamos en blanco
                        nuevaEscala = 255;
                    }
                    if (nuevaEscala < 0) { // Se paso de negro, entonces lo dejamos en negro
                        nuevaEscala = 0;
                    }
                    pixel.setColorRed(nuevaEscala);
                    pixel.setColorGreen(nuevaEscala);
                    pixel.setColorBlue(nuevaEscala);


                    // Reasignamos el valor en la matriz
                    imageMatriz.cambiar(indexFila, indexColumna, pixel.getColorIntModificado());
                }
            }
            return true;
        } else {
            return false;
        }
    }

    // Punto 5 Invertir Horizontal
    // Este metodo invierte la imagen en el eje de las y
    public boolean invertirHorizontal(){
        if (alto > 0 && ancho > 0){ // Existe una imagen

            int pixelNumber, indexInvertido;
            Arreglo2DNumerico matrizInvertida = new Arreglo2DNumerico(alto, ancho);

            for (int indexFila = 0; indexFila < alto; indexFila++) {
                for (int indexColumna = 0; indexColumna < ancho; indexColumna++) {
                    pixelNumber = imageMatriz.obtener(indexFila, indexColumna);

                    // Guardamos al reves
                    indexInvertido = (ancho - 1) - indexColumna;
                    matrizInvertida.cambiar(indexFila, indexInvertido , pixelNumber);
                }
            }

            // Reasignamos la imageMatriz
            imageMatriz = matrizInvertida;

            return true;
        } else {
            return false;
        }
    }

    // Punto 6 Invertir Vertical
    // Esta imagen invierte en el eje de las x
    public boolean invertirVertical(){
        if (alto > 0 && ancho > 0){ // Existe una imagen

            int pixelNumber, indexInvertido;
            Arreglo2DNumerico matrizInvertida = new Arreglo2DNumerico(alto, ancho);

            for (int indexFila = 0; indexFila < alto; indexFila++) {
                for (int indexColumna = 0; indexColumna < ancho; indexColumna++) {
                    pixelNumber = imageMatriz.obtener(indexFila, indexColumna);

                    // Guardamos al reves
                    indexInvertido = (alto - 1) - indexFila;
                    matrizInvertida.cambiar(indexInvertido,  indexColumna, pixelNumber);
                }
            }

            // Reasignamos la imageMatriz
            imageMatriz = matrizInvertida;

            return true;
        } else {
            return false;
        }
    }

    // Punto 7
    // Punto 7.1 Rotar 90 Grados ClockWise
    // Este metodo rota la imagen 90 grados clockwise
    public boolean rotar90(){
        if (alto > 0 && ancho > 0){ // Hay una imagen
            // Trasponer
            imageMatriz.transpuesta();
            alto = imageMatriz.obtenerRenglones();
            ancho = imageMatriz.obtenerColumnas();

            // invertir horizontal
            return invertirHorizontal();
        } else {
            return false;
        }
    }

    // Este metodo rota la imagen 180 grados clockwise
    public boolean rotar180(){
        invertirVertical();
        return invertirHorizontal();
    }

    // Este metodo rota la imagen 270 clockwise
    public boolean rotar270(){
        imageMatriz.transpuesta();
        alto = imageMatriz.obtenerRenglones();
        ancho = imageMatriz.obtenerColumnas();
        return invertirVertical();
    }

    // Punto 8
    // Este metodo le aplica la transpuesta del TDA Arreglo2DNumerico
    public void transpuesta(){
        imageMatriz.transpuesta();
        alto = imageMatriz.obtenerRenglones();
        ancho = imageMatriz.obtenerColumnas();
    }

    // Punto 10
    // Este metodo agrega un marco de un color y un grosor especificado por el usuario
    // Recibe el grosor que es la cantidad de pixeles y un color en formato RGB no ARGB.
    // RGB = 0xFFFFFF - 0x000000
    public boolean agregarMarco(int grosor, int colorRGB){
        if (alto > 0 && ancho > 0){
            int alto2 = alto + (grosor * 2);
            int ancho2 = ancho + (grosor * 2);

            int colorARGB = 0xFF000000 | colorRGB;

            Arreglo2DNumerico matriz2 = new Arreglo2DNumerico(alto2, ancho2);

            for (int indexFila = 0; indexFila < alto2; indexFila++){
                for (int indexCol = 0; indexCol < ancho2; indexCol++){

                    // Si es imagen
                    if (((indexFila >= grosor) && (indexFila < alto2 - grosor))
                        && ((indexCol >= grosor) && (indexCol < ancho2 - grosor))
                    ){
                            matriz2.cambiar(indexFila, indexCol,
                                    imageMatriz.obtener(indexFila - grosor, indexCol - grosor));
                    } else { // Entonces es marco
                        matriz2.cambiar(indexFila, indexCol, colorARGB);
                    }

                }
            }
            imageMatriz = matriz2;
            alto = alto2;
            ancho = ancho2;

            return true;
        } else { // No hay una imagen valida
            return false;
        }
    }


    // Punto 9
    // Este metodo escala o redimensiona la imagen según el factor enumerado especificado por el usuario en el enum
    public boolean redimensionar(FactorEscalado factor){
        if (factor == FactorEscalado.CUADRUPLE){
            return redimensionarAgrandar(4);
        } else if (factor == FactorEscalado.TRIPLE) {
            return redimensionarAgrandar(3);
        } else if (factor == FactorEscalado.DOBLE) {
            return redimensionarAgrandar(2);
        } else if (factor == FactorEscalado.MITAD) {
            return redimensionarAchicar(2);
        } else if (factor == FactorEscalado.TERCIO) {
            return redimensionarAchicar(3);
        } else if (factor == FactorEscalado.CUARTO) {
            return redimensionarAchicar(4);
        } else {
            return false;
        }
    }

    // Este metodo escala o redimensiona (agranda) la imagen según el factor pasado como entero por el usuario
    public boolean redimensionarAgrandar(int factor){
        if (alto > 0 && ancho > 0){ // Hay una imagen valida

            int alto2 = alto * factor;
            int ancho2 = ancho * factor;
            Arreglo2DNumerico matriz2 = new Arreglo2DNumerico(alto2, ancho2);
            int pixelNum;

            for (int indexFila = 0; indexFila < alto; indexFila++){
                for (int indexCol = 0; indexCol < ancho; indexCol++){
                    pixelNum = imageMatriz.obtener(indexFila, indexCol);

                    // Insertamos el bloque del color de ese pixel
                    for (int indexFactorFila = 0; indexFactorFila < factor; indexFactorFila++){
                        for (int indexFactorCol = 0; indexFactorCol < factor; indexFactorCol++){
                            matriz2.cambiar(
                                    (indexFila * factor) + indexFactorFila,
                                    (indexCol * factor) + indexFactorCol,
                                    pixelNum
                            );
                        }
                    }
                }
            }
            imageMatriz = matriz2;
            alto = alto2;
            ancho = ancho2;

            return true;
        } else { // No hay una imagen valida
            return false;
        }
    }

    // Este metodo escala o redimensiona (achica) la imagen según el fator especificado por el usuario con un entero
    public boolean redimensionarAchicar(int factor){
        if (alto > 0 && ancho > 0){ // Hay una imagen valida

            int alto2 = alto / factor;
            int ancho2 = ancho / factor;
            Arreglo2DNumerico matriz2 = new Arreglo2DNumerico(alto2, ancho2);
            int pixelNum, sumaRed, sumaGreen, sumaBlue;
            PixelARGB pixelLeido, pixelPromedio;
            pixelPromedio = new PixelARGB(0xFF000000); // Aqui guardaremos el pixel promedio

            for (int indexFila = 0; indexFila < alto2; indexFila++){
                for (int indexCol = 0; indexCol < ancho2; indexCol++){

                    // Calculamos una suma del bloque de ese color
                    sumaRed = 0;
                    sumaGreen = 0;
                    sumaBlue = 0;
                    for (int indexFactorFila = 0; indexFactorFila < factor; indexFactorFila++){
                        for (int indexFactorCol = 0; indexFactorCol < factor; indexFactorCol++){
                            pixelNum = imageMatriz.obtener(
                                (indexFila * factor) + indexFactorFila,
                                (indexCol * factor) + indexFactorCol);
                            pixelLeido = new PixelARGB(pixelNum);

                            sumaRed += pixelLeido.getColorRed();
                            sumaGreen += pixelLeido.getColorGreen();
                            sumaBlue += pixelLeido.getColorBlue();
                        }
                    }
                    pixelPromedio.setColorRed(sumaRed / (factor * factor));
                    pixelPromedio.setColorGreen(sumaGreen / (factor * factor));
                    pixelPromedio.setColorBlue(sumaBlue / (factor * factor));

                    // Insertamos ese promedio del bloque de color
                    matriz2.cambiar(indexFila, indexCol, pixelPromedio.getColorIntModificado());
                }
            }
            imageMatriz = matriz2;
            alto = alto2;
            ancho = ancho2;

            return true;
        } else { // No hay una imagen valida
            return false;
        }
    }

    // Punto 11
    // Este metodo convierte la imagen a blanco y negro
    public boolean aBlancoNegro(){
        if ((alto > 0 && ancho > 0) == false){
            return false;
        } else {
            // Convertir a escala de grises
            convertirEscalaGrises();

            int pixelNumber;
            int UMBRAL = 127;
            int BLANCO = 255;
            int NEGRO = 0;
            PixelARGB pixel;

            for (int indexFila = 0; indexFila < alto; indexFila++){
                for (int indexColumna = 0; indexColumna < ancho; indexColumna++){
                    pixelNumber = imageMatriz.obtener(indexFila, indexColumna);

                    // Convertimos a pixel
                    pixel = new PixelARGB(pixelNumber);

                    // Checamos si se convierte a blanco o negro
                    if (pixel.getColorRed() > UMBRAL){ // Se convierte a blanco
                        // Reasignamos los colores
                        pixel.setColorRed(BLANCO);
                        pixel.setColorGreen(BLANCO);
                        pixel.setColorBlue(BLANCO);
                    } else { // Se convierte a negro
                        pixel.setColorRed(NEGRO);
                        pixel.setColorGreen(NEGRO);
                        pixel.setColorBlue(NEGRO);
                    }

                    // Reasignamos el valor en la matriz
                    imageMatriz.cambiar(indexFila, indexColumna, pixel.getColorIntModificado());
                }
            }
            return true;
        }
    }


    // Metodos setters y getters
    public Arreglo2DNumerico getImageMatriz(){
        return imageMatriz;
    }
}