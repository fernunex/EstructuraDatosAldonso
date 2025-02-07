package principales;

import registros.agricultura.CosechaAnual;

import static enumerados.ConstanteAgrigultura.*;

// Esta clase es la que contiene el main y corre la Practica #2
public class PrincipalAgricultura {
    public static void main(String[] args) {
        CosechaAnual miCosecha = new CosechaAnual(2025, "Maiz");

        miCosecha.agregarProduccion(ENERO, 40.5);
        miCosecha.agregarProduccion(FEBRERO, 35.2);
        miCosecha.agregarProduccion(MARZO, 25.8);
        miCosecha.agregarProduccion(ABRIL, 50.7);
        miCosecha.agregarProduccion(MAYO, 30.4);
        miCosecha.agregarProduccion(JUNIO, 45.1);
        miCosecha.agregarProduccion(JULIO, 20.9);
        miCosecha.agregarProduccion(AGOSTO, 38.3);
        miCosecha.agregarProduccion(SEPTIEMBRE, 28.6);
        miCosecha.agregarProduccion(OCTUBRE, 48.5);
        miCosecha.agregarProduccion(NOVIEMBRE, 15.3);
        miCosecha.agregarProduccion(DICIEMBRE, 42);

        System.out.println("Promedio Anual: " + miCosecha.calcularPromedio());
        System.out.println("Total Anual: " + miCosecha.calcularTotal());
        System.out.println("Mes con Máxima Producción: " + miCosecha.obtenerMaxMesProduccion());
        System.out.println("Producción en Marzo: " + miCosecha.consultarMes(MARZO));
        System.out.println("Producción Intervalo (Enero - Abril): " + miCosecha.calcularProduccionIntervalo(ENERO, ABRIL));
        System.out.println("Promedio Intervalo (Enero - Abril): " + miCosecha.calcularPromedioIntervalo(ENERO, ABRIL));
        System.out.println("Total Producción Primavera: " + miCosecha.calcularTotalPrimavera());
        System.out.println("Total Producción Verano: " + miCosecha.calcularTotalVerano());
        System.out.println("Total Producción Otoño: " + miCosecha.calcularTotalOtonio());
        System.out.println("Total Producción Invierno: " + miCosecha.calcularTotalInvierno());

        //for (int indexMes = ENERO; indexMes <= DICIEMBRE; indexMes++){
          //  System.out.println(miCosecha.consultarMes(indexMes));
        //}







    }
}
