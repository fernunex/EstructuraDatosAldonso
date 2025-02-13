package principales;

import edlineal.Arreglo;
import edlineal.ArregloOrdenado;
import edlineal.ListaDatos;
import entradasalida.Entrada;
import entradasalida.Salida;
import tools.enumerados.TipoOrdenamiento;

public class PrincipalAOrdenado {
    public static void main(String[] args) {

        TipoOrdenamiento INC = TipoOrdenamiento.INC;
        TipoOrdenamiento DEC = TipoOrdenamiento.DEC;

        // Probando los metodos de 1. Constructor 2. Buscar 3. Poner
//        ArregloOrdenado listaINC = new ArregloOrdenado(6, INC);
//        ArregloOrdenado listaDEC = new ArregloOrdenado(6, DEC);
//        listaINC.poner("B");
//        listaINC.poner("A");
//        listaINC.poner("C");
//        listaDEC.poner("B");
//        listaDEC.poner("A");
//        listaDEC.poner("C");
//        listaINC.imprimir();
//        Salida.salidaPorDefecto("------------------\n");
//        listaDEC.imprimir();

        //Metodo 4. Modificar, 5 Quitar y 7 invertir
//        ArregloOrdenado listaINC = new ArregloOrdenado(6, INC);
//        listaINC.poner("B");
//        listaINC.poner("A");
//        listaINC.poner("D");
//        listaINC.poner("C");
//        listaINC.imprimir();
//        Salida.salidaPorDefecto("--------0 -> Z----------\n");
//        listaINC.modificar(0, "Z");
//        listaINC.imprimir();
//        Salida.salidaPorDefecto("---Invertir y quitar D-----\n");
//        listaINC.invertir();
//        Salida.salidaPorDefecto("\nSe quito el elemento: "  +
//                listaINC.quitar("D") + "\n");
//        listaINC.imprimir();

        // Metodo 9. arregloDesordenado
//        ArregloOrdenado listaINC = new ArregloOrdenado(6, INC);
//        listaINC.poner("B");
//        listaINC.poner("A");
//        listaINC.poner("C");
//        listaINC.imprimir();
//        Salida.salidaPorDefecto("---Arreglo Desordenado-----\n");
//        Arreglo arregloDesordenado = (Arreglo) listaINC.arregloDesordenado();
//        arregloDesordenado.imprimir();

        // Metodo 6 agregarLista
//        ArregloOrdenado listaINC = new ArregloOrdenado(6, INC);
//        listaINC.poner("B");
//        listaINC.poner("A");
//        listaINC.poner("C");
//        ArregloOrdenado arr2 = new ArregloOrdenado(4, INC);
//        arr2.poner("X");
//        arr2.poner("Z");
//        arr2.poner("Y");
//        listaINC.agregarLista(arr2);
//        listaINC.imprimir();

        // Metodo 10
//        ArregloOrdenado listaINC = new ArregloOrdenado(6, INC);
//        listaINC.poner("B");
//        listaINC.poner("A");
//        listaINC.poner("C");
//        listaINC.poner("D");
//        listaINC.poner("E");
//        listaINC.poner("F");
//        ArregloOrdenado sublist = new ArregloOrdenado(6, INC);
//        sublist.poner("C");
//        sublist.poner("D");
//        sublist.poner("E");
//        Salida.salidaPorDefecto("¿Es sublista?: "
//                + listaINC.esSublista(sublist) + "\n");
//        sublist.poner("Z");
//        Salida.salidaPorDefecto("¿Y ahora es sublista?: "
//                + listaINC.esSublista(sublist) + "\n");

        // Metodo 11 modificarLista
//        ArregloOrdenado listaINC = new ArregloOrdenado(6, INC);
//        listaINC.poner("H");
//        listaINC.poner("A");
//        listaINC.poner("C");
//        listaINC.poner("D");
//        listaINC.poner("E");
//        listaINC.poner("G");
//        Arreglo arr1 = new Arreglo(4);
//        arr1.poner("A");
//        arr1.poner("D");
//        arr1.poner("R");
//        arr1.poner("H");
//        Arreglo arr1Nuevo = new Arreglo(4);
//        arr1Nuevo.poner("X");
//        arr1Nuevo.poner("Y");
//        arr1Nuevo.poner("Z");
//        arr1Nuevo.poner("K");
//        Salida.salidaPorDefecto(listaINC.modificarLista(
//                (ListaDatos) arr1, (ListaDatos) arr1Nuevo) + "\n");
//        arr1.imprimir();
//
//         Metodo 12 retenerLista
        ArregloOrdenado listaINC = new ArregloOrdenado(6, INC);
        listaINC.poner("D");
        listaINC.poner("C");
        listaINC.poner("B");
        listaINC.poner("A");
        Arreglo lista2 = new Arreglo(3);
        lista2.poner("A");
        lista2.poner("D");
        lista2.poner("E");
        listaINC.retenerLista((ListaDatos) lista2);
        listaINC.imprimir();



    }
}
