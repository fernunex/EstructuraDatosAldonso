package principales;

import edlineal.ArregloOrdenado;
import entradasalida.Salida;
import tools.enumerados.TipoOrdenamiento;

public class PrincipalAOrdenado {
    public static void main(String[] args) {

        TipoOrdenamiento INC = TipoOrdenamiento.INC;
        TipoOrdenamiento DEC = TipoOrdenamiento.INC;

        ArregloOrdenado lista = new ArregloOrdenado(6, INC);

        lista.poner("M");
        lista.poner("O"); // M n o
        lista.poner("S");
        lista.poner("V");
        lista.poner("B");
        lista.imprimir();

//        lista.imprimirDes();
//        Salida.salidaPorDefecto("\n");
//        Salida.salidaPorDefecto("Buscando Z: " + lista.buscar("Z") + "\n");
//        Salida.salidaPorDefecto("Buscando S: " + lista.buscar("S") + "\n");

    }
}
