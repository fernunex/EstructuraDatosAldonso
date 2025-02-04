package edlineal;

import entradasalida.Salida;

public class Arreglo implements VectorFijo{

    protected int capacidad;
    protected Object datos[];
    protected int indiceSuperior;

    public Arreglo(int tamanio){
        this.capacidad = tamanio;
        this.datos = new Object[this.capacidad];
        this.indiceSuperior = -1;
    }

    @Override
    public boolean vacia() {
        if (indiceSuperior == -1){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer poner(Object valor) {
        if (this.lleno() == false){
            this.indiceSuperior++;
            datos[this.indiceSuperior] = valor;
            return indiceSuperior;
        } else {
            return -1;
        }
    }

    @Override
    public Object buscar(Object valor) {
        int recorredor = 0;
        while (recorredor <= this.indiceSuperior &&
                valor.toString().equalsIgnoreCase(datos[recorredor].toString()) == false ){
            recorredor++;
        }

        if (recorredor > this.indiceSuperior){
            return -1;
        } else {
            return recorredor;
        }
    }

    @Override
    public void imprimir() {
        int posicion;
        for (posicion = 0; posicion <= this.indiceSuperior; posicion++){
            Salida.salidaPorDefecto(datos[posicion] + "\n");
        }
    }

    @Override
    public void imprimirDes() {
        int posicion;
        for (posicion = this.indiceSuperior; posicion >= 0; posicion--){
            Salida.salidaPorDefecto(datos[posicion] + "\n");
        }
    }

    @Override
    public Object quitar() {
        if (this.vacia() == false){
            Object datoExtraido;
            datoExtraido = datos[this.indiceSuperior];
            this.indiceSuperior--;
            return datoExtraido;
        } else {
            return null;
        }
    }

    @Override
    public Object quitar(Object valor) {
        int posicion = (int) buscar(valor);

        if (posicion >= 0){
            Object respaldo = this.datos[posicion];

            for (int modificacion = posicion; modificacion <= indiceSuperior - 1; modificacion++){
                datos[modificacion] = datos[modificacion + 1];
            }

            this.indiceSuperior--;
            return respaldo;
        } else {
            return null;
        }
    }

    @Override
    public boolean lleno() {
        if (indiceSuperior == (capacidad - 1) ){
            return true;
        } else {
            return false;
        }
    }
}
