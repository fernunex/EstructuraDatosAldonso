package principales;

import edlineal.ListaDin;
import entradasalida.Salida;

public class PrincipalListaDin {

    public static void main(String[] args) {
        ListaDin lista = new ListaDin();

        lista.poner("A");
        lista.ponerInicio("X");
        lista.poner("M");
        lista.poner("R");

        lista.imprimir();
        Salida.salidaPorDefecto("\n");
        lista.imprimirDes();
    }

}
