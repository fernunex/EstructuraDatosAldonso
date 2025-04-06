package principales;

import edlineal.Arreglo;
import entradasalida.Salida;
import menus.MenuCalculadora;
import tools.matematicas.TratamientoExpresiones;

public class PrincipalExpresionAritmetica {
    public static void main(String[] args) {
        MenuCalculadora miCalculadora = new MenuCalculadora();
        miCalculadora.execute();









        // ----- El codigo comentado de abajo fue para realizar debugging y testing
        // abcd/*+zn^
        // 2+2*(4/2)-2^3 = -2

//        Salida.salidaPorDefecto(
//                TratamientoExpresiones.evaluarPostfija(
//                        "2242/*+23^-"
//                ) + "\n"
//        );

//        Salida.salidaPorDefecto(TratamientoExpresiones.convertirInfijaPostfija(
//                "2+2*(4/2)-2^3"
//        ) + "\n");
//
//        Salida.salidaPorDefecto(TratamientoExpresiones.convertirInfijaPostfija(
//                "2.5+2*(4/2)-25.2^39"
//        ));

        //  (a-2.0)*f/2^(c- 8)
        // (1-2.0)*3/2^(12.0-8)
//        Salida.salidaPorDefecto(TratamientoExpresiones.convertirInfijaPostfija(
//                "(a-2.0)*f/2^(c-8)"
//        ));
//        Salida.salidaPorDefecto(TratamientoExpresiones.convertirInfijaPostfija(
//                "(1-2.0)*3/2^(12.0-8)"
//        ));

        // a 2.0 -f *2 c 8 -^/
        // 1 2.0 -3 *2 12.0 8 -^/
//        Salida.salidaPorDefecto(
//                TratamientoExpresiones.evaluarPostfija(
//                        "1 2.0 -3 *2 12.0 8 -^/"
//                ) + "\n"
//        );

//        Arreglo resultado = TratamientoExpresiones.pedirValoresVariables("(a-2.0)*f/2^(c-8)");
//        Arreglo var = (Arreglo) resultado.obtener(0);
//        var.imprimir();
//        Salida.salidaPorDefecto("\n");
//        Arreglo val = (Arreglo) resultado.obtener(1);
//        val.imprimir();

//        String exprSustituida = TratamientoExpresiones.remplezarVariables("(a-2.0)*f/2^(c-8)",
//                var,
//                val);

//        System.out.println(exprSustituida);

//        System.out.println(TratamientoExpresiones.convertirInfijaPostfija(exprSustituida));
//        System.out.println(TratamientoExpresiones.evaluarInfija(exprSustituida));

//        System.out.println(exprSustituida); // (1.0-2.0)*3.0/2^(12.0-8)
//        Salida.salidaPorDefecto(TratamientoExpresiones.convertirInfijaPostfija(
//                "(1.0-2.0)*3.0/2^(12.0-8)"
//        ));
//        Salida.salidaPorDefecto(TratamientoExpresiones.evaluarPostfija("" +
//                "1.0 2.0 -3.0 *2 12.0 8 -^/") + "");


//        Salida.salidaPorDefecto(
//                TratamientoExpresiones.evaluarPostfija(
//                        exprSustituida
//                ) + "\n"
//        );
    }
}
