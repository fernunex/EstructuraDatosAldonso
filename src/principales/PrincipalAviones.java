package principales;

import edlineal.ArregloOrdenado;
import edlineal.ColaFijaPrioridad;
import edlineal.auxiliares.DatoPrioridad;
import entradasalida.Salida;
import registros.aviones.GestorAviones;
import tools.enumerados.TipoOrdenamiento;
import tools.enumerados.TipoPrioridad;

public class PrincipalAviones {
    public static void main(String[] args) {
        GestorAviones miAeropuerto = new GestorAviones(2, 6);
        // Agregamos aviones a nuestra pista 2 porque la 1 esta en reparacion
        miAeropuerto.agregarAvionPista("F16", 70, 2);
        miAeropuerto.agregarAvionPista("Boeing 5", 10, 2);
        miAeropuerto.agregarAvionPista("Avionetita", 180, 2);
        miAeropuerto.agregarAvionPista("Avión Jenny Rivera", 240, 2);
        miAeropuerto.agregarAvionPista("F16 Pareja", 70, 2);

        // Despegando cada avion según su prioridad
        miAeropuerto.despegarAvionPista(2);
        miAeropuerto.despegarAvionPista(2);
        miAeropuerto.despegarAvionPista(2);
        miAeropuerto.despegarAvionPista(2);
        miAeropuerto.despegarAvionPista(2);

















        // Testing de la estructura de datos
//        ColaFijaPrioridad miCola = new ColaFijaPrioridad(5, TipoPrioridad.DEC);
//        DatoPrioridad av1, av2, av3, av4, av5;
//        av1 = new DatoPrioridad("Avion 1", 45); // 3rd
//        av2 = new DatoPrioridad("Avion 65", 30); // 5th
//        av3 = new DatoPrioridad("Avion A56", 50); // 2nd
//        av4 = new DatoPrioridad("Avion Boeing", 45); // 4th
//        av5 = new DatoPrioridad("Avion de Jenny Rivera", 90); // 1st
//
//        // Colocando en la cola de prioridad
//        miCola.poner(av1);
//        miCola.poner(av2);
//        miCola.poner(av3);
//        miCola.poner(av4);
//        miCola.poner(av5);
//
//        // Sacando de la cola de prioridad
//        Salida.salidaPorDefecto(((DatoPrioridad) miCola.quitar()).getDato() + "\n");
//        Salida.salidaPorDefecto(((DatoPrioridad) miCola.quitar()).getDato() + "\n");
//        Salida.salidaPorDefecto(((DatoPrioridad) miCola.quitar()).getDato() + "\n");
//        Salida.salidaPorDefecto(((DatoPrioridad) miCola.quitar()).getDato() + "\n");
//        Salida.salidaPorDefecto(((DatoPrioridad) miCola.quitar()).getDato() + "\n");
    }
}
