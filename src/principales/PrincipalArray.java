package principales;

import edlineal.Arreglo;
import edlineal.ListaDatos;
import entradasalida.Salida;

public class PrincipalArray {
    public static void main(String[] args) {
        Arreglo lista = new Arreglo(5);
        lista.poner("S");
        lista.poner("T");
        lista.poner("M");
        lista.poner("R");

        lista.imprimirDes();

        Salida.salidaPorDefecto("\n");
        Salida.salidaPorDefecto("Buscando: M");
        Salida.salidaPorDefecto("\n");
        Salida.salidaPorDefecto(lista.buscar("M") + "\n");
        Salida.salidaPorDefecto("\n");
        Salida.salidaPorDefecto("\n");
        Salida.salidaPorDefecto("Buscando: Z");
        Salida.salidaPorDefecto("\n");
        Salida.salidaPorDefecto(lista.buscar("Z") + "\n");

        lista.imprimirDes();
        Salida.salidaPorDefecto("Eliminando M: " + lista.quitar("M") + "\n");
        lista.imprimirDes();
        Salida.salidaPorDefecto("Eliminando el de arriba: " + lista.quitar() + "\n");
        lista.imprimirDes();

    }
}
