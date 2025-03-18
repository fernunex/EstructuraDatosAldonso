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
        kilometrosRecorridos = new Arreglo3D(numCorredores, numEventos, numAnios, 0.0);
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
            return kilometrosRecorridos.cambiarCelda(indiceCorredor, indiceEvento, indiceAnio, km);
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

    // Devuelve todos los kilometros del corredor (la suma)
    public Double kilometroXCorredor(int noCorredor, Arreglo carrerasParticipantes, Arreglo aniosParticipantes){
        // Se tiene el cálculo de un solo corredor
        // Se tiene que calcular de varias carreras

        Double kmCorredor = 0.0;

        // carrerasParticipantes guarda solamente los nombres de los eventos

        for (int cadaCarrera = 0; cadaCarrera < carrerasParticipantes.cantidad(); cadaCarrera++){
            // Tengo que ir sumando todos los kilómetros de cada carrera de un corredor en ciertos años
            String carreraTemp = (String) carrerasParticipantes.obtener(cadaCarrera);
            Double kmCarreraEvento = kilometrosXCorredorXCarrera(noCorredor, carreraTemp, aniosParticipantes);


            // Verificamos y Acumulamos los kms de cada carrera para ese corredor
            if (kmCarreraEvento == null){
                return null;
            } else {
                kmCorredor = kmCorredor + kmCarreraEvento;
            }
        }
        return kmCorredor;
    }

    // Obtiene los km de un corredor de una carrera pero de todos los anios
    public Double kilometrosXCorredorXCarrera(int noCorredor, String carreraParticipante, Arreglo aniosParticipantes){

        Double kmAnio = 0.0;

        // Recorremos el arreglo de los anios
        for (int cadaAnio = 0; cadaAnio < aniosParticipantes.cantidad(); cadaAnio++){
            // Obtengo una celda del cubo con kms de fila, col, prof
            // Necesito los 3 datos indirectos de noCoorredor, nombre del evento y el año
            int anioTemp = (int) aniosParticipantes.obtener(cadaAnio);

            // Obtener los indices (datos directos del cubo)
            // de los tres datos indirectos
            Arreglo indicesDirecto = buscarIndicesKms(noCorredor, carreraParticipante, anioTemp);

            // Ahora puedo obtener de una celda los kms
            Double kmsCelda = (Double) kilometrosRecorridos.obtenerCelda(
                    (int) indicesDirecto.obtener(0), // Corredor
                    (int) indicesDirecto.obtener(1), // Evento
                    (int) indicesDirecto.obtener(2) // Anio
            );

            if (kmsCelda == null){
                return null;
            } else {
                // acumulo los kms de cada anio
                kmAnio = kmAnio + kmsCelda;
            }

        }
        return kmAnio;
    }



}

// Realizar un programa que trate de facilitar responder estas preguntas
// Tratar de realizar un programa que resuelva la mayor cantidad de preguntas
// Esto se logra con la modularidad

// Un usuario quiere obtener información de kilometros recorridos usando consultas como esta:
// - Obtener la cantidad de kilómetros recorridos por juan en el año 2010, 2011, 2012 y 2014 en la carrera
//   de "Bicentenario".

// - Obtener la cantidad de kilómetros recorridos de Pedro en el año 1999 en las carreras de "Bicentenario" y
//   "Carrera Max"