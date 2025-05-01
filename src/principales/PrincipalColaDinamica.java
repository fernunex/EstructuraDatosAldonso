package principales;

import edlineal.ColaDinamica;
import entradasalida.Salida;

public class PrincipalColaDinamica {
    public static void main(String[] args) {
        ColaDinamica miCola = new ColaDinamica();

        miCola.poner("Fernando");
        miCola.poner("Jesús");
        miCola.poner("Núñez");
        miCola.poner("Valdez");

        //Imprimendo
        Salida.salidaPorDefecto(
                miCola.quitar() + "\n"
        );
        Salida.salidaPorDefecto(
                "Imprimiendo la cola:\n"
        );
        miCola.imprimir();
    }
}
