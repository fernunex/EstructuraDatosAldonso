package registros.agricultura;

import edlineal.Arreglo;
import static enumerados.ConstanteAgrigultura.*;

// Esta clase representa un registro anual de produccion
// El arreglo mesesProduccion contiene la produccion por mes (12 meses)
public class CosechaAnual {
    String tipoCosecha;
    int anio;
    Arreglo mesesProduccion;

    public CosechaAnual(int anio, String tipoCosecha){
        this.tipoCosecha = tipoCosecha;
        this.anio = anio;
        this.mesesProduccion = new Arreglo(TOTAL_MESES);
        inicializarMesesProduccion();
    }

    // Este metodo agrega la produccion al mes indicado
    public boolean agregarProduccion(int mesIndex, double produccion){
        boolean retorno = this.mesesProduccion.modificar(mesIndex, produccion);
        return retorno;
    }

    // Este metodo inicializa el arreglo de mesesProduccion con 0
    // en todos sus meses
    private void inicializarMesesProduccion(){
        for (int indexMes = ENERO; indexMes <= DICIEMBRE; indexMes++){
            this.mesesProduccion.poner(0.0);
        }
    }

    // Este metodo calcula el promedio anual y lo retorna
    public double calcularPromedio(){
        double promedio = calcularTotal() / TOTAL_MESES;
        return promedio;
    }

    // Este metodo calcula la suma total de la produccion anual
    public double calcularTotal(){
        double total = 0;
        for (int indexMes = ENERO; indexMes <= DICIEMBRE; indexMes++){
            total += consultarMes(indexMes);
        }
        return total;
    }

    // Este metodo retorna el indice del mes en el cual la produccion fue mayor
    public int obtenerMaxMesProduccion(){
        int indexMaxProd = ENERO;
        double maxProduccion = consultarMes(ENERO);
        double tempProduccion;

        for (int indexMes = FEBRERO; indexMes <= DICIEMBRE; indexMes++){
            tempProduccion = consultarMes(indexMes);

            if ((tempProduccion > maxProduccion) == true){
                indexMaxProd = indexMes;
                maxProduccion = tempProduccion;
            }
        }

        return indexMaxProd;
    }

    // Este metodo regresa la produccion de un mes indicado
    public double consultarMes(int indexMes){
        return (double) this.mesesProduccion.obtener(indexMes);
    }

    // Este metodo calcula la produccion total por cuatrimestre
    public double calcularProduccionIntervalo(int mes_inicial, int mes_final){
        double total = 0;
        for (int indexMes = mes_inicial; indexMes <= mes_final; indexMes++){
            total += consultarMes(indexMes);
        }

        return total;
    }

    // Este metodo calcula el promedio por intervalo
    public double calcularPromedioIntervalo(int mes_inicial, int mes_final){
        int cantMeses = mes_final - mes_inicial + 1;
        double total = calcularProduccionIntervalo(mes_inicial, mes_final);
        double promedio = total / cantMeses;
        return promedio;
    }

    // Este metodo calcula el total de produccion en primavera
    public double calcularTotalPrimavera(){
        double total = calcularProduccionIntervalo(INICIO_PRIMAVERA, FINAL_PRIMAVERA);
        return total;
    }

    // Este metodo calcula el total de produccion en verano
    public double calcularTotalVerano() {
        double total = calcularProduccionIntervalo(INICIO_VERANO, FINAL_VERANO);
        return total;
    }

    // Este metodo calcula el total de produccion en otoño
    public double calcularTotalOtonio() {
        double total = calcularProduccionIntervalo(INICIO_OTONIO, FINAL_OTONIO);
        return total;
    }

    // Este metodo calcula el total de produccion en invierno
    public double calcularTotalInvierno() {
        double total = calcularProduccionIntervalo(INICIO_INVIERNO, FINAL_INVIERNO);
        return total;
    }

    public String getTipoCosecha() {
        return tipoCosecha;
    }

    public void setTipoCosecha(String tipoCosecha) {
        this.tipoCosecha = tipoCosecha;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Arreglo getMesesProduccion() {
        return mesesProduccion;
    }

    public void setMesesProduccion(Arreglo mesesProduccion) {
        this.mesesProduccion = mesesProduccion;
    }

    @Override
    public String toString(){
        return anio + "";
    }
}
