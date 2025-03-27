package principales;

import edlineal.Arreglo;
import ednolineal.Arreglo2D;
import entradasalida.Salida;
import tools.enumerados.TipoColumna;
import tools.enumerados.TipoRenglon;

public class PrincipalArreglo2D {
    public static void main(String[] args) {

        // 1 y 2. Constructores
//        Arreglo2D arrAbc = new Arreglo2D(
//                3,4,
//                "X");
//        arrAbc.imprimirXRenglones();

        // 3 y 4 obtener y cambiar
        // Cambiamos el elemento 2,2 por C
//        arrAbc.cambiar(2,2, "C");
//        arrAbc.imprimirXRenglones();
        // Obtenemos el elmento 2,2
//        Salida.salidaPorDefecto(
//                "\nEl elmento 2,2 es: "
//        + arrAbc.obtener(2,2));

        // 5. renglones y columnas
//        Salida.salidaPorDefecto(
//                "\nEl arrAbc tiene\n" +
//                        "Renglones: " +
//                        arrAbc.obtenerRenglones()
//                        +"\nColumnas: " +
//                        arrAbc.obtenerColumnas());

        // 6 y 7 imprimir
//        Arreglo2D arrAbc = new Arreglo2D(
//                2,3,
//                "X");
//        Salida.salidaPorDefecto("" +
//                "Por Renglones:\n");
//        arrAbc.cambiar(0,0, "a");
//        arrAbc.cambiar(0,1, "b");
//        arrAbc.cambiar(0,2, "c");
//        arrAbc.cambiar(1,0, "d");
//        arrAbc.cambiar(1,1, "e");
//        arrAbc.cambiar(1,2, "f");
//        arrAbc.imprimirXRenglones();
//        Salida.salidaPorDefecto("" +
//                "Por Columnas:\n");
//        arrAbc.imprimirXColumnas();

        // 8 transpuesta
//        Arreglo2D arrAbc = new Arreglo2D(
//                2,3,
//                "X");
//        Salida.salidaPorDefecto("" +
//                "Original:\n");
//        arrAbc.cambiar(0,0, "a");
//        arrAbc.cambiar(0,1, "b");
//        arrAbc.cambiar(0,2, "c");
//        arrAbc.cambiar(1,0, "d");
//        arrAbc.cambiar(1,1, "e");
//        arrAbc.cambiar(1,2, "f");
//        arrAbc.imprimirXRenglones();
//        arrAbc.transpuesta();
//        Salida.salidaPorDefecto("" +
//                "Transpuesta:\n");
//        arrAbc.imprimirXRenglones();

        // 9 y 10 Rellenar y clonar
//        Arreglo2D arrAbc = new Arreglo2D(
//                2,3,
//                "X");
//        Salida.salidaPorDefecto("" +
//                "Clon relleno " +
//                "con ceros (0):\n");
//        arrAbc.rellenar(0);
//
//        Arreglo2D arrClon = arrAbc.clonar();
//        arrClon.imprimirXRenglones();

        // 11. esIgual()
//        Arreglo2D arrAbc = new Arreglo2D(
//                2,3,
//                "X");
//        arrAbc.cambiar(1,2, "A");
//
//        Arreglo2D arrAbc2 = new Arreglo2D(
//                2,3,
//                "X");
//        Salida.salidaPorDefecto("" +
//                "(Antes) Son iguales: " +
//                arrAbc.esIgual(arrAbc2));
//        // Una matriz identica
//        arrAbc2.cambiar(1,2, "A");
//        Salida.salidaPorDefecto("" +
//                "\n(Después) Son iguales: " +
//                arrAbc.esIgual(arrAbc2));

        // 12 y 13. vectorColumna() y vectorRenglon()
//        Arreglo2D arrAbc = new Arreglo2D(
//                2,3,
//                "X");
//        // El vector columna de 5 filas y de "z"
//        arrAbc.vectorColumna(5, "z");
//        arrAbc.imprimirXRenglones();
//        // El vector fila de 4 columnas y de "r"
//        Salida.salidaPorDefecto("\n");
//        arrAbc.vectorRenglone(4, "r");
//        arrAbc.imprimirXRenglones();

        // 14 redefinir()
//        Arreglo2D arrAbc = new Arreglo2D(
//                2,3,
//                "X");
//        Arreglo2D arrXyz = new Arreglo2D(
//                2,2,
//                "p");
//        arrAbc.redefinir(arrXyz);
//        arrAbc.imprimirXRenglones();

        // 15 y 16 agregarRenglon()
        // agregarColumna
//        Arreglo2D arrAbc = new Arreglo2D(
//                2,3,
//                "X");
//        Arreglo letras1, letras2;
//        letras1 = new Arreglo(2);
//        letras1.poner("S");
//        letras1.poner("T");
//        letras2 = new Arreglo(3);
//        letras2.poner("F");
//        letras2.poner("E");
//        letras2.poner("R");
//        arrAbc.agregarColumna(letras1);
//        arrAbc.agregarRenglon(letras2);
//        arrAbc.imprimirXRenglones();

        // 20 y 21 aVectorColumna()
        // aVectorRenglon()
//        Arreglo2D arrAbc = new Arreglo2D(
//                2,3,
//                "X");
//        arrAbc.cambiar(1,1, "P");
//        arrAbc.cambiar(1,0, "L");
//        arrAbc.cambiar(0,2, "O");
//        arrAbc.imprimirXRenglones();
//        Salida.salidaPorDefecto("" +
//                "\nA Columna:\n");
//        arrAbc.aVectorColumna()
//                .imprimirXRenglones();
//        Salida.salidaPorDefecto("" +
//                "\nA Renglón:\n");
//        arrAbc.aVectorRenglon()
//                .imprimirXRenglones();

        // 22 y 23 quitarColumna()
//        // quitarRenglon()
//        Arreglo2D arrAbc = new Arreglo2D(
//                3,4,
//                "X");
//        arrAbc.cambiar(1,1, "P");
//        arrAbc.cambiar(1,0, "L");
//        arrAbc.cambiar(2,3, "O");
//        arrAbc.imprimirXRenglones();
//        Salida.salidaPorDefecto("" +
//                "\nEliminamos la columna izq:\n");
//        arrAbc.quitarColumna(TipoColumna.IZQUIERDA);
//        arrAbc.imprimirXRenglones();
//        Salida.salidaPorDefecto("" +
//                "\nEliminamos el renglón inferior:" +
//                "\n");
//        arrAbc.quitarRenglon(TipoRenglon.INFERIOR);
//        arrAbc.imprimirXRenglones();

        // 24 y 25 eliminarColumna()
        // eliminarRenglon()
        Arreglo2D arrAbc = new Arreglo2D(
                3,4,
                "X");
        arrAbc.cambiar(1,1, "P");
        arrAbc.cambiar(1,0, "L");
        arrAbc.cambiar(2,3, "O");
        arrAbc.imprimirXRenglones();
        Salida.salidaPorDefecto("" +
                "\nEliminamos la 2da columna:\n");
        arrAbc.eliminarColumna(1);
        arrAbc.imprimirXRenglones();
        Salida.salidaPorDefecto("" +
                "\nEliminamos el 2do renglón:" +
                "\n");
        arrAbc.eliminarRenglon(1);
        arrAbc.imprimirXRenglones();

    }
}
