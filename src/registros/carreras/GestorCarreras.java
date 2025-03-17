package registros.carreras;

import edlineal.Arreglo;
import ednolineal.Arreglo3D;
import entradasalida.Salida;

public class GestorCarreras {
    protected Arreglo3D kilometrosRecorridos; // Solo guarda kilometros
    protected Arreglo corredores; // Guarda info de corredores
    protected Arreglo eventos; // Guarda info de carreras
    protected Arreglo anios; // Guarda info de anios

    // Constructor que me indica cuantos hay de cada cosa
    public GestorCarreras(int numCorredores, int numEventos, int numAnios){
        corredores = new Arreglo(numCorredores);
        eventos = new Arreglo(numEventos);
        anios = new Arreglo(numAnios);
        kilometrosRecorridos = new Arreglo3D(numEventos, numCorredores, numAnios, 0.0);
    }

    // Metodo para agregar corredores
    public boolean agregarCorredor(int noCorredorAsignado, String nombre, int edad, char sexo){
        // Para crear un corredor, me pasan sus datos y luego hago hago un new, despues lo meto al arreglo de
        // corredores
        Corredor nuevoCorredor = new Corredor(noCorredorAsignado, nombre, edad, sexo);

        // antes de ponerlo en el arreglo de corredores, hay que verificar que no se duplique ese numero de corredor
        int busquedaCorredor = (int) corredores.buscar(nuevoCorredor);

        if (busquedaCorredor >= 0){
            // sí existe, no lo agregamos
            return false;
        }
        // Si no entonces hacemos lo de abajo

        int retorno = corredores.poner(nuevoCorredor);
        if (retorno >= 0){
            return true;
        } else { // me regresó -1, es un error
            return false;
        }
    }

    // Metodo para agregar eventos
    public boolean agregarEvento(String nombre, String lugar, int anioFundacion){
        // Recibo los datos del evento
        // Checo que no exista ese evento
        int busquedaEvento = (int) eventos.buscar(nombre);

        // Sino existe lo agregamos al arreglo
        if (busquedaEvento >= 0){
            // Ya existe entonces no lo agregamos
            return false;
        }

        // Solo creamos el objeto si lo vamos agregar
        Evento nuevoEvento = new Evento(nombre, lugar, anioFundacion);

        // Agregamos al arreglo de eventos
        int retorno = eventos.poner(nuevoEvento);
        if (retorno >= 0){
            // SI se puedo agregar
            return true;
        } else {
            // NO se pudo agregar
            return false;
        }
    }

    // Metodo para agregar anios
    public boolean agregarAnio(int anio){
        //Verifico que el anio no exista
        int busquedaAnio = (int) anios.buscar(anio);
        if (busquedaAnio < 0){
            // NO existe, -1
            // Entonces lo agregamos
            int retorno = anios.poner(anio);
            if (retorno >= 0){
                // SÍ se pudo
                return true;
            } else {
                // Hubo un error
                return false;
            }
        } else {
            // Ya existe
            return false;
        }
    }

    // Busca los indices de una celda y me los regresa
    // en un arreglo [corredor, evento, anio]
    private Arreglo buscarIndicesKms(int noCorredor, String nombreE, int anio){
        int indiceEvento = (int) eventos.buscar(nombreE);
        int indiceCorredor = (int) corredores.buscar(noCorredor);
        int indiceAnio = (int) anios.buscar(anio);

        if (indiceEvento >= 0 && indiceCorredor >= 0 && indiceAnio >= 0){
            // Son validos
            // Creo un arreglo con esos indices y lo retorno
            Arreglo indices = new Arreglo(3);
            indices.poner(indiceCorredor);
            indices.poner(indiceEvento);
            indices.poner(indiceAnio);
            return indices;
        } else {
            // Al menos alguno no se encontro
            return null;
        }
    }

    // Metodo para agregar kilometros
    public boolean agregarKilometros(double km, int noCorredor, String nombreEvento, int anio){
        // Me dan los datos de donde se ca a guardar el kilometraje recorrido
        // Necesito encontrar los indices de esos datos
        Arreglo indicesKms = buscarIndicesKms(noCorredor, nombreEvento, anio);
        if (indicesKms != null){
            // Para con esos indices poner en el cubo, guardar los kms
            int indiceEvento = (int) indicesKms.obtener(1);
            int indiceCorredor = (int) indicesKms.obtener(0);
            int indiceAnio = (int) indicesKms.obtener(2);
            return kilometrosRecorridos.cambiarCelda(indiceEvento, indiceCorredor, indiceAnio, km);
        } else {
            // El arreglo de indices es nulo, no podemos hacer nada
            return false;
        }
    }

    public void mostrarDatos(){
        Salida.salidaPorDefecto("Eventos: \n");
        eventos.imprimirDes();
        Salida.salidaPorDefecto("\n");
        Salida.salidaPorDefecto("Corredores: \n");
        corredores.imprimirDes();
        Salida.salidaPorDefecto("\n");
        Salida.salidaPorDefecto("Anios: \n");
        anios.imprimirDes();
        Salida.salidaPorDefecto("\n");
        Salida.salidaPorDefecto("Kms: \n");
        kilometrosRecorridos.imprimirXColumnas();
        Salida.salidaPorDefecto("\n");

    }
}
