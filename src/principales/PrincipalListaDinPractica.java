package principales;

import edlineal.Arreglo;
import edlineal.ListaDin;
import ednolineal.Arreglo2D;
import entradasalida.Salida;

public class PrincipalListaDinPractica {
    public static void main(String[] args) {
        // a) mostrarOI()
//        ListaDin lis = new ListaDin();
//        lis.poner("A");
//        lis.poner("B");
//        lis.poner("C");
//        lis.imprimirDes();

        // b) encontrarLista()
//        ListaDin lis = new ListaDin();
//        lis.poner("A");
//        lis.poner("B");
//        lis.poner("A");
//        lis.poner("D");
//        lis.encontrarLista("A")
//                .imprimir();

        // c) aListaEstatica()
//        ListaDin lis = new ListaDin();
//        lis.poner("A");
//        lis.poner("B");
//        lis.poner("A");
//        lis.poner("D");
//        Arreglo arr = lis.aListaEstatica();
//        arr.imprimir();

        // d) aListaEstatica(elementosADescartar)
//        ListaDin lis = new ListaDin();
//        lis.poner("A");
//        lis.poner("B");
//        lis.poner("X");
//        lis.poner("D");
//        Arreglo descart = new Arreglo(2);
//        descart.poner("D");
//        descart.poner("A");
//        Arreglo arr = lis.aListaEstatica(descart);
//        arr.imprimir();

        // e) aMatriz2D()
//        ListaDin lis = new ListaDin();
//        lis.poner("A");
//        lis.poner("B");
//        lis.poner("X");
//        lis.poner("D");
//        Arreglo2D arr2d = lis.aMatriz2D(3,
//                3);
//        arr2d.imprimirXRenglones();

        // f) agregarLista()
//        ListaDin lis = new ListaDin();
//        lis.poner("A");
//        lis.poner("X");
//        Arreglo arr2 = new Arreglo(
//                2);
//        arr2.poner("O");
//        arr2.poner("L");
//        lis.agregarLista(arr2);
//        lis.imprimir();

        // g) clonar()
//        ListaDin lis = new ListaDin();
//        lis.poner("A");
//        lis.poner("X");
//        lis.poner("Aldonso");
//        ListaDin clon =(ListaDin)
//                lis.clonar();
//        clon.imprimir();

        // g) SALTADO

        // i) vaciar() y j) rellenar()
        // y k) contar()
//        ListaDin lis = new ListaDin();
//        lis.rellenar("A", 3);
//        lis.imprimir();
//        Salida.salidaPorDefecto(
//                "\nSon "
//                + lis.contar("A") +
//                        " As\n"
//        );
//        lis.vaciar();
//        lis.imprimir();

        // l) invertir()
//        ListaDin lis = new ListaDin();
//        lis.poner("A");
//        lis.poner("X");
//        lis.poner("Aldonso");
//        lis.imprimir();
//        lis.invertir();
//        Salida.salidaPorDefecto("\n");
//        lis.imprimir();

        // m) cambiar()
//        ListaDin lis = new ListaDin();
//        lis.poner("A");
//        lis.poner("B");
//        lis.poner("A");
//        lis.poner("A");
//        lis.imprimir();
//        Salida.salidaPorDefecto("\n");
//        lis.modificar("A", "X",
//                2);
//        lis.imprimir();

        // n) cambiar() y o) obtener()
        ListaDin lis = new ListaDin();
        lis.poner("A");
        lis.poner("B");
        lis.poner("A");
        lis.poner("A");
        lis.imprimir();
        Salida.salidaPorDefecto("\n");
        lis.cambiar(1, "PP");
        lis.imprimir();
        Salida.salidaPorDefecto("\n" +
                "Posición 2: "+
                lis.obtener(1));

        // p) esIgual()
//        ListaDin lis = new ListaDin();
//        lis.poner("A");
//        lis.poner("B");
//        lis.poner("C");
//        ListaDin lis2 = new ListaDin();
//        lis2.poner("A");
//        lis2.poner("B");
//        lis2.poner("C");
//        lis.imprimir();
//        Salida.salidaPorDefecto("" +
//                "\nLista 2:\n");
//        lis2.imprimir();
//        Salida.salidaPorDefecto("" +
//                "\nSon iguales: " +
//                lis.esIgual(lis2));

        // r) quitar()
//        ListaDin lis = new ListaDin();
//        lis.poner("A");
//        lis.poner("B");
//        lis.poner("C");
//        lis.poner("D");
//        lis.poner("X");
//        lis.imprimir();
//        lis.quitar(0);
//        Salida.salidaPorDefecto("" +
//                "\nQuitar index:0\n");
//        lis.imprimir();
//        Salida.salidaPorDefecto("" +
//                "\nQuitar index:1\n");
//        lis.quitar(1);
//        lis.imprimir();


    }
}
