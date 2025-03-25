package principales;

import entradasalida.Salida;
import tools.matematicas.TratamientoExpresiones;

public class PrincipalExpresionAritmetica {
    public static void main(String[] args) {
        // abcd/*+zn^
        // 2+2*(4/2)-2^3 = -2

        Salida.salidaPorDefecto(
                TratamientoExpresiones.evaluarPostfija(
                        "2242/*+23^-"
                ) + "\n"
        );
    }
}
