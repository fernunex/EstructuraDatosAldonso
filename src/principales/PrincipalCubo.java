package principales;

import ednolineal.Arreglo3D;
import entradasalida.Salida;

public class PrincipalCubo {
    public static void main(String[] args) {
        Arreglo3D cubo = new Arreglo3D(5, 4,
                3, 0);

        cubo.imprimirXColumnas();

        Salida.salidaPorDefecto("\n-------------\n");
        cubo.cambiarCelda(1, 2, 0, 90);

        cubo.imprimirXColumnas();

        Salida.salidaPorDefecto("Valor Celda: " + cubo.obtenerCelda(1,2,0) + "\n");

    }
}
