package registros.agricultura;

import edlineal.Arreglo;
import entradasalida.Salida;
import static enumerados.ConstanteAgricultura.*;

public class GestorAgricultura {
    private Arreglo campesinos;
    private String nombreEmpresa;
    private String direccion;
    private int aniosProduccion;
    private int numeroCampesinos;

    public GestorAgricultura(int numeroCampesinos, String nombreEmpresa, String direccion, int aniosProduccion){
        this.campesinos = new Arreglo(numeroCampesinos);
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.aniosProduccion = aniosProduccion;
        this.numeroCampesinos = numeroCampesinos;
    }


    // ----------------------------------------------------------------- Metodos para imprimir

    // Este metodo imprime el promedio anual x campesino
    public void imprimirPromedioAnual(){

        for (int indexCampesino = 0; indexCampesino < getNumeroCampesinos(); indexCampesino++){
            Campesino camp = obtenerCampesino(indexCampesino);
            Salida.salidaPorDefecto("Campesino: " + camp.getNombre() + "\n");
            Arreglo promedios = camp.obtenerPromediosAnuales();
            Arreglo aniosProduccion = camp.obtenerAniosProduccion();
            for (int indexCosecha = 0; indexCosecha < camp.getAniosProduccion(); indexCosecha++){
                double promedio = (double) promedios.obtener(indexCosecha);
                int anio = (int) aniosProduccion.obtener(indexCosecha);
                Salida.salidaPorDefecto(anio + " : " + promedio + "\n");
            }
        }
    }

    // Este metodo imprime el mes mas productivo de cada año por campesino
    public void imprimirMesMasProductivo(String nombreCampesino){
        Campesino camp = obtenerCampesino(nombreCampesino);
        Salida.salidaPorDefecto("Campesino: " + camp.getNombre() + "\n");
        Arreglo meses = camp.obtenerMesesTopProduccion();
        Arreglo aniosProduccion = camp.obtenerAniosProduccion();
        for (int indexCosecha = 0; indexCosecha < camp.getAniosProduccion(); indexCosecha++){
            String mes = (String) meses.obtener(indexCosecha);
            int anio = (int) aniosProduccion.obtener(indexCosecha);
            Salida.salidaPorDefecto(anio + " : " + mes + "\n");
        }
    }

    // Este metodo imprime las toneladas que se obtuvieron el ultimo mes de cada año
    public void imprimirToneladasUltimas(String nombreCampesino){
        Campesino camp = obtenerCampesino(nombreCampesino);
        Salida.salidaPorDefecto("Campesino: " + camp.getNombre() + "\n");
        Arreglo tonelajes = camp.obtenerTonelajesUltimoMes();
        Arreglo aniosProduccion = camp.obtenerAniosProduccion();
        for (int indexCosecha = 0; indexCosecha < camp.getAniosProduccion(); indexCosecha++){
            double mes = (double) tonelajes.obtener(indexCosecha);
            int anio = (int) aniosProduccion.obtener(indexCosecha);
            Salida.salidaPorDefecto(anio + " : " + mes + "\n");
        }
    }

    // Este metodo imprime el tonelaje total del segundo cuatrimestre de cada anio para un campesino
    public void imprimirTonelajeSegCuatri(String nombreCampesino){
        Campesino camp = obtenerCampesino(nombreCampesino);
        Salida.salidaPorDefecto("Campesino: " + camp.getNombre() + "\n");
        Arreglo tonelajesCuatri = camp.obtenerTonelajesIntervalo(MAYO, AGOSTO);
        Arreglo aniosProduccion = camp.obtenerAniosProduccion();
        for (int indexCosecha = 0; indexCosecha < camp.getAniosProduccion(); indexCosecha++){
            double mes = (double) tonelajesCuatri.obtener(indexCosecha);
            int anio = (int) aniosProduccion.obtener(indexCosecha);
            Salida.salidaPorDefecto(anio + " : " + mes + "\n");
        }
    }


    // Este metodo obtiene un campesino del arreglo por su nombre
    public Campesino obtenerCampesino(String nombre){
        return (Campesino) getCampesinos().obtener((int) getCampesinos().buscar(nombre));

    }


    // Este metodo agrega un campesino a los campesinos
    public boolean agregarCampesino(String nombre, int edad, char genero, int aniosProduccion){
        int retorno = (int) this.getCampesinos().poner(new Campesino(nombre, edad, genero, aniosProduccion));
        if (retorno != -1){
            return true;
        }
        return false;
    }

    // Este metodo le agrega una cosecha anual a los campesinos
    public boolean agregarCosechaAnual(String nombre, int anio, String tipoCosecha){
        Campesino campesino = (Campesino) getCampesinos().obtener((int) getCampesinos().buscar(nombre));
        return campesino.agregarCosechaAnual(anio, tipoCosecha);
    }

    // Este metodo le agrega una produccion mensual a un mes identificado por su nombre
    // tambien requiere como parametro que se le pase el anio, mes, y produccion.
    public boolean agregarProduccion(String nombre, int anio, int mes, double produccion){
        boolean retorno = encontrarCampesino(nombre).agregarProduccionMes(anio, mes, produccion);
        return retorno;
    }

    // Este metodo encuentra un campesinos y lo retorna. Si no, retrona un null
    public Campesino encontrarCampesino(String nombre){
        int campesinoIndex = (int) getCampesinos().buscar(nombre);
        if ((campesinoIndex != -1) == true){
            return (Campesino) getCampesinos().obtener(campesinoIndex);
        }
        return null;
    }

    // Este metodo encuentra un campesino por indice
    public Campesino obtenerCampesino(int index){
        return (Campesino) getCampesinos().obtener(index);
    }


    public Arreglo getCampesinos() {
        return campesinos;
    }

    public void setCampesinos(Arreglo campesinos) {
        this.campesinos = campesinos;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAniosProduccion() {
        return aniosProduccion;
    }

    public void setAniosProduccion(int aniosProduccion) {
        this.aniosProduccion = aniosProduccion;
    }

    public int getNumeroCampesinos() {
        return numeroCampesinos;
    }

    public void setNumeroCampesinos(int numeroCampesinos) {
        this.numeroCampesinos = numeroCampesinos;
    }

}
