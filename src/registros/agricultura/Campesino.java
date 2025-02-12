package registros.agricultura;

import edlineal.Arreglo;
import registros.personas.Persona;

import static tools.enumerados.ConstanteAgricultura.ENERO;
import static tools.enumerados.ConstanteAgricultura.*;

// Esta clase representa a los campesinos
// En ella se guardan cada uno de los años de produccion de sus cosechas
// el tipo de estas cosechas son de CosechaAnual
public class Campesino extends Persona {
    private Arreglo cosechas; // contiene CosechaAnual
    private int aniosProduccion;

    public Campesino(String nombre, int edad, char genero, int aniosProduccion){
        this.cosechas = new Arreglo(aniosProduccion);
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.aniosProduccion = aniosProduccion;
    }

    // Este metodo agrega una cosecha anual al arreglo de cosechas
    public boolean agregarCosechaAnual(int anio, String tipoCosecha){
        int retorno = (int) this.getCosechas().poner(new CosechaAnual(anio, tipoCosecha));
        if (retorno != -1){
            return true;
        }
        return false;
    }

    // Este metodo agrega una produccion a un anio y mes en especifico
    public boolean agregarProduccionMes(int anio, int mes, double produccion){
        CosechaAnual cosechaTemp = encontrarCosecha(anio);
        boolean retorno = cosechaTemp.agregarProduccion(mes, produccion);
        return retorno;
    }

    // Este metodo retorna un arreglo con los años de produccion (el año)
    public Arreglo obtenerAniosProduccion(){
        Arreglo anios = new Arreglo(getAniosProduccion());

        for (int indexAnio = 0; indexAnio < getAniosProduccion(); indexAnio++){
            anios.poner(((CosechaAnual) obtenerCosechaXIndice(indexAnio)).getAnio());
        }
        return anios;
    }

    // Este metodo busca una cosecha por anio y la regresa.
    private CosechaAnual encontrarCosecha(int anio){
        return (CosechaAnual) getCosechas().obtener((int) getCosechas().buscar(anio));
    }

    // Este metodo obtiene una cosecha por indice
    public CosechaAnual obtenerCosechaXIndice(int index){
        return (CosechaAnual) this.cosechas.obtener(index);
    }

    // Este metodo devuelve el promedio anual del campesinos.
    public double obtenerPromedioTotalAnios(){
        double sumaAniosTotal = 0;

        for (int indexCosecha = 0; indexCosecha < getAniosProduccion(); indexCosecha++){
            sumaAniosTotal += obtenerCosechaXIndice(indexCosecha).calcularTotal();
        }

        return sumaAniosTotal / getAniosProduccion();
    }

    // Este metodo devuelve un arreglo con el promedio anual de cada cosecha
    public Arreglo obtenerPromediosAnuales(){
        Arreglo promedios = new Arreglo(getAniosProduccion());

        for (int indexCosecha = 0; indexCosecha < getAniosProduccion(); indexCosecha++){
            promedios.poner(
                    obtenerCosechaXIndice(indexCosecha).calcularPromedio()
            );

        }
        return promedios;
    }

    // Este metodo obtiene el mes mas productivo por cosecha anual
    public int obtenerTopProdMes(CosechaAnual cosecha){
        return cosecha.obtenerMaxMesProduccion();
    }

    // Este metodo retorna un arreglo de Strings con los meses en los cuales la produccion
    // fue mayor para cada año el mes en la posicion 0 corresponde al la cosecha en la posicion
    // 0 del arreglo de cosechas anuales.
    public Arreglo obtenerMesesTopProduccion() {
        Arreglo mesesTopProduccion = new Arreglo(getAniosProduccion());
        int mesCodificado;
        String mesDecodificado;

        for (int indexCosecha = 0; indexCosecha < getAniosProduccion(); indexCosecha++){
            mesCodificado = obtenerTopProdMes(obtenerCosechaXIndice(indexCosecha));
            mesDecodificado = obtenerNombreMes(mesCodificado);
            mesesTopProduccion.poner(mesDecodificado);
        }
        return mesesTopProduccion;
    }

    // Este metodo retorna un arreglo con los tonelajes del ultimo mes de cada cosecha
    public Arreglo obtenerTonelajesUltimoMes(){
        Arreglo tonelajes = new Arreglo(getAniosProduccion());

        for (int indexCoseha = 0; indexCoseha < getAniosProduccion(); indexCoseha++){
            tonelajes.poner(obtenerCosechaXIndice(indexCoseha).consultarMes(DICIEMBRE));
        }

        return tonelajes;
    }

    // Este metodo calcula las toneladas por intervalo de todas las cosechas y retorna un
    // arreglo con esos valores.
    public Arreglo obtenerTonelajesIntervalo(int mes_inicial, int mes_final){
        Arreglo tonelajesIntervalo = new Arreglo(getAniosProduccion());

        for (int indexCosecha = 0; indexCosecha < getAniosProduccion(); indexCosecha++){
            tonelajesIntervalo
                    .poner(obtenerCosechaXIndice(indexCosecha)
                            .calcularProduccionIntervalo(mes_inicial, mes_final));
        }
        return tonelajesIntervalo;
    }


    // Este metodo decodifica los numeros enteros (codigos de los meses) a cadenas
    // , segun corresponda el mes.
    public String obtenerNombreMes(int mes) {
        switch (mes) {
            case ENERO -> { return "Enero"; }
            case FEBRERO -> { return "Febrero"; }
            case MARZO -> { return "Marzo"; }
            case ABRIL -> { return "Abril"; }
            case MAYO -> { return "Mayo"; }
            case JUNIO -> { return "Junio"; }
            case JULIO -> { return "Julio"; }
            case AGOSTO -> { return "Agosto"; }
            case SEPTIEMBRE -> { return "Septiembre"; }
            case OCTUBRE -> { return "Octubre"; }
            case NOVIEMBRE -> { return "Noviembre"; }
            case DICIEMBRE -> { return "Diciembre"; }
            default -> { return "Mes inválido"; }
        }
    }



    public Arreglo getCosechas() {
        return cosechas;
    }

    public void setCosechas(Arreglo cosechas) {
        this.cosechas = cosechas;
    }

    public int getAniosProduccion() {
        return aniosProduccion;
    }

    public void setAniosProduccion(int aniosProduccion) {
        this.aniosProduccion = aniosProduccion;
    }

    @Override
    public String toString(){
        return this.nombre;
    }
}
