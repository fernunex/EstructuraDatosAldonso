package principales;

import edlineal.Arreglo;
import edlineal.ListaDatos;
import entradasalida.Salida;

// En esta clase se encuentran los test a los métodos de la práctica 1
public class PrincipalArrayPractica1 {
    public static void main(String[] args) {

        // Metodo: esIgual -----------------------------------------------
        Arreglo miArreglo = new Arreglo(5);
        miArreglo.poner("a");
        miArreglo.poner("b");
        miArreglo.poner("c");

        Arreglo miArreglo2Igual = new Arreglo(5);
        miArreglo2Igual.poner("a");
        miArreglo2Igual.poner("b");
        miArreglo2Igual.poner("c");

        Arreglo miArreglo3Diferente = new Arreglo(5);
        miArreglo3Diferente.poner("a");
        miArreglo3Diferente.poner("c");
        miArreglo3Diferente.poner("k");

        // Metodo 1 esIgual
//        Salida.salidaPorDefecto(miArreglo.esIgual(miArreglo2Igual) + "\n");
//        Salida.salidaPorDefecto(miArreglo.esIgual(miArreglo3Diferente) + "\n");
//         Metodo 2 get
//        Salida.salidaPorDefecto(miArreglo.obtener(1) + "\n");
//        Salida.salidaPorDefecto(miArreglo.obtener(0) + "\n");

        // Metodo 3 y 4 modificar
//        Arreglo miArregloModi = new Arreglo(5);
//        miArregloModi.poner("a");
//        miArregloModi.poner("x");
//        miArregloModi.poner("a");
//        miArregloModi.poner("a");
//        miArregloModi.poner("a");
//        miArregloModi.modificar(1, "O");
//        miArregloModi.modificar("a", "p", 3);
//        miArregloModi.imprimir();

        //Metodo 5 modificarLista
        Arreglo original = new Arreglo(5);
        original.poner("x");
        original.poner("x");
        original.poner("x");
        original.poner("x");
        original.poner("x");
        Arreglo indices = new Arreglo(3);
        indices.poner(0);
        indices.poner(4);
        indices.poner(2);
        Arreglo nuevosValores = new Arreglo(3);
        nuevosValores.poner("a");
        nuevosValores.poner("b");
        nuevosValores.poner("c");
        // Metodo 5 modificarLista
        original.modificarLista(indices, nuevosValores);
//        original.imprimir();

//         Metodo 6: buscarValores y 17:redimensionar
        original.imprimir();
        original.buscarValores("x").imprimir();
        Salida.salidaPorDefecto("---\n");
        original.redimensionar(3);
        original.imprimir();

        // Metodo 7 y 8; quitar
//        original.imprimir();
//        Salida.salidaPorDefecto("---\n");
//        original.quitar(0);
//        original.quitar();
//        original.imprimir();

        // Metodo 9:Vaciar y 10 agregarLista
//        Arreglo original = new Arreglo(10);
//        original.poner("a");
//        original.poner("b");
//        Arreglo aniadir = new Arreglo(5);
//        aniadir.poner("c");
//        aniadir.poner("a");
//        aniadir.poner("a");
        // Metodo 9:Vaciar y 10 agregarLista
//        original.agregarLista(aniadir);
//        original.imprimir();
//        Salida.salidaPorDefecto("---\n");
//        original.vaciar();
//        original.imprimir();

        // Metodo 11:invertir y 12:contar
//        original.imprimir();
//        Salida.salidaPorDefecto("---\n");
//        original.invertir();
//        original.imprimir();
//        Salida.salidaPorDefecto(original.contar("a") + "");

        //Metodo 13:borrarLista y 14:rellenar
//        Arreglo lis1 = new Arreglo(5);
//        lis1.poner("a");
//        lis1.poner("e");
//        lis1.poner("i");
//        lis1.poner("i");
//        Arreglo lis2 = new Arreglo(5);
//        lis2.poner("s");
//        lis2.poner("a");
//        lis2.poner("p");
//        lis2.poner("a");
//        lis2.poner("e");
        //Metodo 13:borrarLista y 14:rellenar
//        lis1.borrarLista(lis2);
//        lis2.imprimir();
//        Salida.salidaPorDefecto("---\n");
//        lis2.rellenar("x", 3);
//        lis2.imprimir();

        // Metodo 15:clonar 16:sublista
//        Arreglo lis1 = new Arreglo(5);
//        lis1.poner("a");
//        lis1.poner("e");
//        lis1.poner("i");
//        lis1.poner("i");
//        Arreglo list2 = (Arreglo) lis1.clonar();
//        list2.imprimir();
//        Salida.salidaPorDefecto("---\n");
//        Arreglo list3 = (Arreglo) lis1.subLista(1, 2);
//        list3.imprimir();

        //Metodo 18:substituir
//        Arreglo lis1 = new Arreglo(5);
//        lis1.poner("a");
//        lis1.poner("e");
//        lis1.poner("i");
//        lis1.poner("i");
//        Arreglo lis2 = new Arreglo(25);
//        lis2.substituir((ListaDatos) lis1);
//        lis2.imprimir();
//        Salida.salidaPorDefecto(lis2.getCapacidad() + " de Capacidad");




    }
}
