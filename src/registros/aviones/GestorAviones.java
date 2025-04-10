package registros.aviones;

import edlineal.ColaFijaPrioridad;
import edlineal.auxiliares.DatoPrioridad;
import entradasalida.Salida;
import tools.enumerados.TipoPrioridad;

public class GestorAviones {
    private ColaFijaPrioridad pistas[];
    private int numeroPistas;
    private int maxAvionesEspera;

    // Se creara un arreglo de colas de prioridad con la maxima
    // cantidad de aviones en espera como parametro de su capacidad
    public GestorAviones(int numeroPistas, int maxAvionesEspera) {
        this.numeroPistas = numeroPistas;
        this.maxAvionesEspera = maxAvionesEspera;
        pistas = new ColaFijaPrioridad[numeroPistas];
        inicializarPistas();
    }

    // Este metodo inicializa las colas de prioridad en el arreglo de pistas
    // Por defecto seran en DEC. El de mayor prioridad sale primero.
    private void inicializarPistas(){
        for (int indexPista = 0; indexPista < numeroPistas; indexPista++){
            pistas[indexPista] = new ColaFijaPrioridad(this.maxAvionesEspera, TipoPrioridad.DEC);
        }
    }

    // Este metodo permite agregar un avion a la pista indicada
    // Retorna true si lo pudo realizar
    // El tiempoEspera es el tiempo que ya tiene en espera desde que su hora de salida llego, esta la indica el usuario
    // E.g. 25 --> Significa que el avion ya lleva 25 min en espera desde su hora de salida
    // pistaNum indica en cual pista se agregara el avion
    public boolean agregarAvionPista(Object avion, int tiempoEspera, int pistaNum){
        int pistaReal = pistaNum - 1;
        if (pistaReal >= 0 && pistaReal < numeroPistas){ // Se escogio una pista valida
            DatoPrioridad avionEspera = new DatoPrioridad(avion, tiempoEspera);
            return pistas[pistaReal].poner(avionEspera);
        } else {
            return false;
        }
    }

    // Este metodo imprime el siguiente avión en salir de la pista indicada
    public void despegarAvionPista(int pistaNum){
        int pistaReal = pistaNum - 1;
        if (pistaReal >= 0 && pistaReal < numeroPistas){ // Se escogio una pista valida
            DatoPrioridad nextAvion = (DatoPrioridad) pistas[pistaReal].quitar();

            if (nextAvion == null){
                Salida.salidaPorDefecto("\nYa no hay aviones en espera en la pista " + pistaNum);
            } else {
                Salida.salidaPorDefecto("\nDespega el avión ->" + nextAvion.getDato() + "<- que tiene " +
                        nextAvion.getPrioridad() + " minutos en espera.");
            }
        } else {
            return ;
        }
    }

}
