package principales;

import edlineal.ArregloNumerico;
import entradasalida.Salida;

public class PrincipalArregloNumerico {
    public static void main(String[] args) {
        String ENDL = "\n";

        // 1) Metodos SobreEscritos
//        ArregloNumerico numerico = new ArregloNumerico(5);
//        numerico.poner(25);
//        Salida.salidaPorDefecto("Agregando 'Juan': " +
//                numerico.poner("Juan") + ENDL);
//        Salida.salidaPorDefecto("Agregando 22: "+
//                numerico.poner(22) + ENDL);
//        Salida.salidaPorDefecto("Encontrando 'Juan': "+
//                numerico.buscar("Juan") + ENDL);
//        Salida.salidaPorDefecto("Encontrando 22: "+
//                numerico.buscar(22) + ENDL);
//        Salida.salidaPorDefecto("Rellenando con 5s" + ENDL);
//        numerico.rellenar(5, 3);
//        numerico.imprimir();

        // 2) porEscalar() y 3) sumarEscalar()
//        ArregloNumerico numerico = new ArregloNumerico(4);
//        numerico.poner(1);
//        numerico.poner(5);
//        numerico.poner(3);
//        Salida.salidaPorDefecto(ENDL +
//                "Despues de multiplicar por 2 a todo" + ENDL);
//        numerico.porEscalar(2);
//        numerico.imprimir();
//        Salida.salidaPorDefecto(
//                "Despues de sumar 3 a todos" + ENDL);
//        numerico.sumarEscalar(3.5);
//        numerico.imprimir();

        // 4) sumar()
//        ArregloNumerico numerico = new ArregloNumerico(4);
//        numerico.poner(1);
//        numerico.poner(5);
//        numerico.poner(3);
//        ArregloNumerico numerico2 = new ArregloNumerico(4);
//        numerico2.poner(3);
//        numerico2.poner(1);
//        numerico2.poner(-15);
//        Salida.salidaPorDefecto(
//                "Despues de sumar lista1 con lista2" + ENDL);
//        numerico.sumar(numerico2);
//        numerico.imprimir();

        // 5) multiplicar()
//        ArregloNumerico numerico = new ArregloNumerico(4);
//        numerico.poner(2);
//        numerico.poner(5);
//        numerico.poner(7);
//        ArregloNumerico numerico2 = new ArregloNumerico(4);
//        numerico2.poner(3);
//        numerico2.poner(4);
//        numerico2.poner(-1);
//        Salida.salidaPorDefecto(
//                "Despues de multiplicar lista1 con lista2"
//                        + ENDL);
//        numerico.multiplicar(numerico2);
//        numerico.imprimir();

//        6) aplicarPotencia()
//        ArregloNumerico numArr = new ArregloNumerico(
//                4);
//        numArr.poner(2);
//        numArr.poner(5);
//        numArr.poner(7);
//        numArr.aplicarPotencia(2);
//        Salida.salidaPorDefecto(
//                "Despues de aplicar ^2"
//                        + ENDL);
//        numArr.imprimir();


//        7) aplicarPotencia()
//        ArregloNumerico numArr = new ArregloNumerico(4);
//        numArr.poner(2);
//        numArr.poner(5);
//        numArr.poner(7);
//        ArregloNumerico potencias = new ArregloNumerico(4);
//        potencias.poner(5);
//        potencias.poner(3);
//        potencias.poner(2);
//        numArr.aplicarPotencia(potencias);
//        Salida.salidaPorDefecto(
//                "Despues de aplicar las potencias"
//                        + ENDL);
//        numArr.imprimir();
//
//
//      8) productoEscalar()
        ArregloNumerico numArr = new ArregloNumerico(4);
        numArr.poner(2);
        numArr.poner(5);
        numArr.poner(7);
        ArregloNumerico numArr2 = new ArregloNumerico(4);
        numArr2.poner(5); // *2 = 10
        numArr2.poner(3); // *5 = 15
        numArr2.poner(2); // *7 = 14
        Salida.salidaPorDefecto( //  = 39
                "El producto escalar es: "
                        + numArr.productoEscalar(numArr2)
                        + ENDL);

    }
}
