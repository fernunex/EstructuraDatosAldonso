package principales;

import menus.MenuAgricultura;
import registros.agricultura.Campesino;
import registros.agricultura.CosechaAnual;
import registros.agricultura.GestorAgricultura;

import static enumerados.ConstanteAgrigultura.*;

// Esta clase es la que contiene el main y corre la Practica #2
public class PrincipalAgricultura {
    public static void main(String[] args) {
//        CosechaAnual miCosecha = new CosechaAnual(2025, "Maiz");
//
//        miCosecha.agregarProduccion(ENERO, 40.5);
//        miCosecha.agregarProduccion(FEBRERO, 35.2);
//        miCosecha.agregarProduccion(MARZO, 25.8);
//        miCosecha.agregarProduccion(ABRIL, 50.7);
//        miCosecha.agregarProduccion(MAYO, 30.4);
//        miCosecha.agregarProduccion(JUNIO, 45.1);
//        miCosecha.agregarProduccion(JULIO, 20.9);
//        miCosecha.agregarProduccion(AGOSTO, 38.3);
//        miCosecha.agregarProduccion(SEPTIEMBRE, 28.6);
//        miCosecha.agregarProduccion(OCTUBRE, 48.5);
//        miCosecha.agregarProduccion(NOVIEMBRE, 15.3);
//        miCosecha.agregarProduccion(DICIEMBRE, 42);
//
//        System.out.println("Promedio Anual: " + miCosecha.calcularPromedio());
//        System.out.println("Total Anual: " + miCosecha.calcularTotal());
//        System.out.println("Mes con Máxima Producción: " + miCosecha.obtenerMaxMesProduccion());
//        System.out.println("Producción en Marzo: " + miCosecha.consultarMes(MARZO));
//        System.out.println("Producción Intervalo (Enero - Abril): " + miCosecha.calcularProduccionIntervalo(ENERO, ABRIL));
//        System.out.println("Promedio Intervalo (Enero - Abril): " + miCosecha.calcularPromedioIntervalo(ENERO, ABRIL));
//        System.out.println("Total Producción Primavera: " + miCosecha.calcularTotalPrimavera());
//        System.out.println("Total Producción Verano: " + miCosecha.calcularTotalVerano());
//        System.out.println("Total Producción Otoño: " + miCosecha.calcularTotalOtonio());
//        System.out.println("Total Producción Invierno: " + miCosecha.calcularTotalInvierno());

        //for (int indexMes = ENERO; indexMes <= DICIEMBRE; indexMes++){
          //  System.out.println(miCosecha.consultarMes(indexMes));
        //}

        //------------------------------ Probando la clase de Campesino

//        Campesino cap1 = new Campesino("Juan", 25, 'M', 2);
//        cap1.agregarCosechaAnual(2022, "Maiz");
//        cap1.agregarCosechaAnual(2023, "Maiz");
//
//        // Llenando Produccion Año 2022
//        cap1.agregarProduccionMes(2022, ENERO, 40.5);
//        cap1.agregarProduccionMes(2022, FEBRERO, 35.2);
//        cap1.agregarProduccionMes(2022, MARZO, 25.8);
//        cap1.agregarProduccionMes(2022, ABRIL, 50.7);
//        cap1.agregarProduccionMes(2022, MAYO, 30.4);
//        cap1.agregarProduccionMes(2022, JUNIO, 45.1);
//        cap1.agregarProduccionMes(2022, JULIO, 20.9);
//        cap1.agregarProduccionMes(2022, AGOSTO, 38.3);
//        cap1.agregarProduccionMes(2022, SEPTIEMBRE, 28.6);
//        cap1.agregarProduccionMes(2022, OCTUBRE, 48.5);
//        cap1.agregarProduccionMes(2022, NOVIEMBRE, 15.3);
//        cap1.agregarProduccionMes(2022, DICIEMBRE, 42.9);
//
//        // LLenado Produccion Año 2023
//        cap1.agregarProduccionMes(2023, ENERO, 38.2);
//        cap1.agregarProduccionMes(2023, FEBRERO, 29.7);
//        cap1.agregarProduccionMes(2023, MARZO, 33.5);
//        cap1.agregarProduccionMes(2023, ABRIL, 47.9);
//        cap1.agregarProduccionMes(2023, MAYO, 28.3);
//        cap1.agregarProduccionMes(2023, JUNIO, 42.6);
//        cap1.agregarProduccionMes(2023, JULIO, 22.1);
//        cap1.agregarProduccionMes(2023, AGOSTO, 40.2);
//        cap1.agregarProduccionMes(2023, SEPTIEMBRE, 26.9);
//        cap1.agregarProduccionMes(2023, OCTUBRE, 51.3);
//        cap1.agregarProduccionMes(2023, NOVIEMBRE, 18.7);
//        cap1.agregarProduccionMes(2023, DICIEMBRE, 39.4);


//        System.out.println("--- Promedio anual");
//        System.out.println(cap1.obtenerPromediosAnuales().obtener(0));
//        System.out.println(cap1.obtenerPromediosAnuales().obtener(1));
//        System.out.println("-----Top meses");
//        System.out.println(cap1.obtenerMesesTopProduccion().obtener(0));
//        System.out.println(cap1.obtenerMesesTopProduccion().obtener(1));
//        System.out.println("--- Tonelaje x Mes");
//        System.out.println(cap1.obtenerTonelajesUltimoMes().obtener(0));
//        System.out.println(cap1.obtenerTonelajesUltimoMes().obtener(1));
//        System.out.println("--- Tonelaje Intervalo");
//        System.out.println(cap1.obtenerTonelajesIntervalo(ABRIL, JULIO).obtener(0));
//        System.out.println(cap1.obtenerTonelajesIntervalo(ABRIL, JULIO).obtener(1));


        // Creando el gestor y llenandolo de datos ---------------
        GestorAgricultura miGestorAgricultura = new GestorAgricultura(
                2,
                "El rancho",
                "Fresnillo, Zac",
                2
                );
        // Agregamos nuestros campesinos
        miGestorAgricultura.agregarCampesino("Juan", 25, 'M', 2);
        miGestorAgricultura.agregarCampesino("Maria", 50, 'F', 2);
        // Agregamos sus cosechas anuales de produccion
        miGestorAgricultura.agregarCosechaAnual("Juan", 2023, "Maiz");
        miGestorAgricultura.agregarCosechaAnual("Juan", 2024, "Maiz");
        miGestorAgricultura.agregarCosechaAnual("Maria", 2023, "Maiz");
        miGestorAgricultura.agregarCosechaAnual("Maria", 2024, "Maiz");

        //Agregamos sus producciones para cada mes de cada año
        miGestorAgricultura.agregarProduccion("Juan", 2023, ENERO, 53.3);
        miGestorAgricultura.agregarProduccion("Juan", 2023, FEBRERO, 42.7);
        miGestorAgricultura.agregarProduccion("Juan", 2023, MARZO, 33.8);
        miGestorAgricultura.agregarProduccion("Juan", 2023, ABRIL, 60.2);
        miGestorAgricultura.agregarProduccion("Juan", 2023, MAYO, 39.5);
        miGestorAgricultura.agregarProduccion("Juan", 2023, JUNIO, 60.8);
        miGestorAgricultura.agregarProduccion("Juan", 2023, JULIO, 25.4);
        miGestorAgricultura.agregarProduccion("Juan", 2023, AGOSTO, 120.6);
        miGestorAgricultura.agregarProduccion("Juan", 2023, SEPTIEMBRE, 30.7);
        miGestorAgricultura.agregarProduccion("Juan", 2023, OCTUBRE, 50.9);
        miGestorAgricultura.agregarProduccion("Juan", 2023, NOVIEMBRE, 19.2);
        miGestorAgricultura.agregarProduccion("Juan", 2023, DICIEMBRE, 45.6);
        // Anio 2024
        miGestorAgricultura.agregarProduccion("Juan", 2024, ENERO, 52.8);
        miGestorAgricultura.agregarProduccion("Juan", 2024, FEBRERO, 38.6);
        miGestorAgricultura.agregarProduccion("Juan", 2024, MARZO, 29.4);
        miGestorAgricultura.agregarProduccion("Juan", 2024, ABRIL, 28.7);
        miGestorAgricultura.agregarProduccion("Juan", 2024, MAYO, 37.9);
        miGestorAgricultura.agregarProduccion("Juan", 2024, JUNIO, 49.2);
        miGestorAgricultura.agregarProduccion("Juan", 2024, JULIO, 100.1);
        miGestorAgricultura.agregarProduccion("Juan", 2024, AGOSTO, 44.3);
        miGestorAgricultura.agregarProduccion("Juan", 2024, SEPTIEMBRE, 32.8);
        miGestorAgricultura.agregarProduccion("Juan", 2024, OCTUBRE, 53.4);
        miGestorAgricultura.agregarProduccion("Juan", 2024, NOVIEMBRE, 61.5);
        miGestorAgricultura.agregarProduccion("Juan", 2024, DICIEMBRE, 80.9);
        // Maria
        miGestorAgricultura.agregarProduccion("Maria", 2023, ENERO, 48.2);
        miGestorAgricultura.agregarProduccion("Maria", 2023, FEBRERO, 33.9);
        miGestorAgricultura.agregarProduccion("Maria", 2023, MARZO, 27.5);
        miGestorAgricultura.agregarProduccion("Maria", 2023, ABRIL, 43.1);
        miGestorAgricultura.agregarProduccion("Maria", 2023, MAYO, 41.3);
        miGestorAgricultura.agregarProduccion("Maria", 2023, JUNIO, 100.8);
        miGestorAgricultura.agregarProduccion("Maria", 2023, JULIO, 22.4);
        miGestorAgricultura.agregarProduccion("Maria", 2023, AGOSTO, 80.7);
        miGestorAgricultura.agregarProduccion("Maria", 2023, SEPTIEMBRE, 30.1);
        miGestorAgricultura.agregarProduccion("Maria", 2023, OCTUBRE, 50.2);
        miGestorAgricultura.agregarProduccion("Maria", 2023, NOVIEMBRE, 130.6);
        miGestorAgricultura.agregarProduccion("Maria", 2023, DICIEMBRE, 44.5);
        // 2024
        miGestorAgricultura.agregarProduccion("Maria", 2024, ENERO, 50.5);
        miGestorAgricultura.agregarProduccion("Maria", 2024, FEBRERO, 36.2);
        miGestorAgricultura.agregarProduccion("Maria", 2024, MARZO, 29.9);
        miGestorAgricultura.agregarProduccion("Maria", 2024, ABRIL, 10.4);
        miGestorAgricultura.agregarProduccion("Maria", 2024, MAYO, 39.5);
        miGestorAgricultura.agregarProduccion("Maria", 2024, JUNIO, 12.0);
        miGestorAgricultura.agregarProduccion("Maria", 2024, JULIO, 25.7);
        miGestorAgricultura.agregarProduccion("Maria", 2024, AGOSTO, 42.9);
        miGestorAgricultura.agregarProduccion("Maria", 2024, SEPTIEMBRE, 34.2);
        miGestorAgricultura.agregarProduccion("Maria", 2024, OCTUBRE, 35.8);
        miGestorAgricultura.agregarProduccion("Maria", 2024, NOVIEMBRE, 20.9);
        miGestorAgricultura.agregarProduccion("Maria", 2024, DICIEMBRE, 15.3);



        // Le pasamos el gestor a un Menu de agricultura.
        MenuAgricultura miMenu = new MenuAgricultura(miGestorAgricultura);
        miMenu.execute();





    }
}
