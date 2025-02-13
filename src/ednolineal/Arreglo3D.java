package ednolineal;

import entradasalida.Salida;

public class Arreglo3D {
    protected int ancho;
    protected int alto;
    protected int profundo;

    protected Object datos[][][]; // To' lo guardaremos como object

    public Arreglo3D(int ancho, int alto, int profundo) {
        this.ancho = ancho;
        this.alto = alto;
        this.profundo = profundo;
    }

    // Constructor que crea el cubo relleno con un valor por defecto
    public Arreglo3D(int ancho, int alto, int profundo, Object valor){
        this(ancho, alto, profundo);
        // Invocar al metodo rellenar usando valor...

    }

    // Este metodo rellena el cubo con un valor indicado
    public void rellenar(Object valor){
        // Hacer mi ciclo par alo alto (filas)
        for (int cadaFila = 0; cadaFila < alto; cadaFila++){



            // Hacer el ciclo de lo ancho (columnas)
            for (int cadaCol=0; cadaCol < ancho; cadaCol++){

                // Hacer la profundidad
                for (int cadaProf = 0; cadaProf < profundo; cadaProf++){
                    // Por cada celda [ ] [ ] [ ]
                    datos [cadaFila][cadaCol][cadaProf] = valor;
                }
            }

        }
    }

    // Este metodo imprime por columnas
    public void imprimirXColumnas(){
        // Dividir el cubo en rebanadas de columnas
        for (int cadaRebanada = 0; cadaRebanada < ancho; cadaRebanada++){ // Estamos accesando al datos[][this][]

            // Ahora debo imprimir una rebanada y como esta formada.
            // Primero agarro los renglones de la matriz que es una rebanada
            for (int cadaFila = 0; cadaFila < alto; cadaFila++){

                // Asumo que hay un arreglo unidimensional para las columnas
                for (int cadaColumna = 0; cadaColumna < profundo; cadaColumna++){
                    Salida.salidaPorDefecto(datos[cadaFila][cadaRebanada][cadaColumna].toString() + " ");
                }
                Salida.salidaPorDefecto("\n");
            }
            // Cuando se hayan impreso todos los renglones de una rebanada, hacemos un salto de línea
            Salida.salidaPorDefecto("\n");
        }
    }
}


















