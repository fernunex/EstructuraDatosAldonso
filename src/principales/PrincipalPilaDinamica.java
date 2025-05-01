package principales;

import edlineal.PilaDinamica;
import entradasalida.Salida;

// Este programa es para testear la clase PilaDinamica
public class PrincipalPilaDinamica {
    public static void main(String[] whishesForChristmas) {
        PilaDinamica miPilaDin = new PilaDinamica();

        miPilaDin.poner("Nuñez");
        miPilaDin.poner("Valdez");
        miPilaDin.poner("Jesús");
        miPilaDin.poner("Fernando");

        Salida.salidaPorDefecto(
                miPilaDin.quitar() + "\n");
        Salida.salidaPorDefecto(
                "Imprimiendo la pila:\n");
        miPilaDin.imprimir();
    }
}
