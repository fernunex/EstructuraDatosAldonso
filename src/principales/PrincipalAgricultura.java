package principales;

import menus.MenuAgricultura;
import registros.agricultura.GestorAgricultura;

import static enumerados.ConstanteAgricultura.*;

// Esta clase es la que contiene el main y corre la Practica #2
public class PrincipalAgricultura {
    public static void main(String[] args) {

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

        //Agregamos sus producciones para cada mes de cada año para cada usuario
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
