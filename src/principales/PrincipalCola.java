package principales;

import edlineal.ColaFija;
import entradasalida.Salida;

public class PrincipalCola {
    public static void main(String[] args) {
        ColaFija cola = new ColaFija(4);

        cola.poner("A");
        cola.poner("B");
        cola.poner("Cp");
        cola.poner("Dx");

        cola.imprimir();

        Salida.salidaPorDefecto("\nEliminando: " +
        cola.quitar() + "\n");

        cola.imprimir();
    }
}
