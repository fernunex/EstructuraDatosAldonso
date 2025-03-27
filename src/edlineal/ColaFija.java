package edlineal;

import entradasalida.Salida;

public class ColaFija implements LoteDatos{
    protected int ultimo; // indica el que llego al final
    protected int primero; // indica el siguiente elemento a salir
    protected Object datos[]; // Almacenamiento para la cola.
    protected int capacidad;

    public ColaFija(int tamanio){
        this.datos = new Object[tamanio];
        this.primero = -1;
        this.ultimo = -1;
        this.capacidad = tamanio;
    }


    @Override
    public boolean vacio() {
        if (primero == -1){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean lleno() {
        if ((primero == 0 && ultimo == (capacidad - 1)) ||
            (primero == (ultimo + 1))){
            return true;
        } else {
            return false;
        }
    }

    // Este metodo coloca un objeto en la cola
    @Override
    public boolean poner(Object valor) {
        if (lleno() == false){ // Podemos añadir elementos
            if (vacio() == true){ // Caso vacio
                datos[0] = valor;
                primero = 0;
                ultimo = 0;
            } else if (ultimo == (capacidad - 1)) { // Caso frontera circular
                ultimo = 0;
                datos[0] = valor;
            } else { // Caso circular y normal
                ultimo++;
                datos[ultimo] = valor;
            }
            return true;
        } else { // No pudimos añadir un elemento
            return false;
        }
    }

    @Override
    public Object quitar() {
        if(vacio() == false){
            Object respaldo = datos[primero];
            if (primero == ultimo){ // Solo hay un elemento
                primero = -1;
                ultimo = -1;
            } else if (primero == (capacidad - 1)) { // El actual esta al final del arreglo
                primero = 0;
            } else { // El siguiente esta al lado derecho del actual
                primero++;
            }
            return respaldo;
        } else {
            return null;
        }
    }

    // Este metodo imprime la cola donde el primer elemento es el siguiente en salir
    // estan en orden
    @Override
    public void imprimir() {
        if (vacio() == false){
            if (primero <= ultimo){
                for (int pos = primero; pos <= ultimo; pos++){
                    Salida.salidaPorDefecto(datos[pos] + " ");
                }
            } else {
                for (int pos = primero; pos <= capacidad - 1; pos++){
                    Salida.salidaPorDefecto(datos[pos] + " ");
                }

                for (int pos = 0; pos <= ultimo; pos++){
                    Salida.salidaPorDefecto(datos[pos] + " ");
                }
            }
        } else {
            return;
        }
    }

    @Override
    public Object verTope() {
        return null;
    }
}
