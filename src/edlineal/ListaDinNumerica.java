package edlineal;

import edlineal.auxiliares.Nodo;

public class ListaDinNumerica extends ListaDin{


    // Validamos que solo los valores sean numericos
    @Override
    public Integer ponerInicio(Object valor) {
        if (valor instanceof Number){
            return super.ponerInicio(valor);
        } else {
            return -1;
        }
    }

    // Validamos que solo los valores sean numericos
    @Override
    public Integer poner(Object valor) {
        if (valor instanceof Number){
            return super.poner(valor);
        } else if (valor instanceof String) { // Tal vez lo que nos mandaron es un numero en formato de string
            // si es asi, intentamos castearlo a double
            try{
                valor = Double.parseDouble(valor.toString());
                return super.poner(valor);
            } catch (Exception e){
                return -1;
            }
        } else {
            System.out.println("Entro");
            return -1;
        }
    }

    // Calcula la sumatoria de la lista actual de numeros
    public double calcularSumatoria(){
        double suma = 0;
        iniciaIterador();
        while (iteradorValido()){
            suma += (double) obtenerIterador();
            moverIterador();
        }
        return suma;
    }

    // Calcula la multiplicacion de una lista por otra lista
    public void multiplicarPorLista(ListaDinNumerica lista2){
        iniciaIterador();
        lista2.iniciaIterador();
        while (iteradorValido() && lista2.iteradorValido()){
            iterador.setDato(
                    ((double) obtenerIterador()) *
                            ((double) lista2.obtenerIterador())
            );
            lista2.moverIterador();
            moverIterador();
        }
    }

    // Este metodo eleva a una potencia indicada
    public void elevarAPotencia(int pot){
        iniciaIterador();
        while (iteradorValido()){
            iterador.setDato(
                    Math.pow(((double) obtenerIterador()), pot)
            );
            moverIterador();
        }
    }

    // Este metodo retorna una ListaDinNumerica clonada de la actual
    @Override
    public ListaDatos clonar() {
        ListaDinNumerica listaClon = new ListaDinNumerica();

        iniciaIterador();
        while (iteradorValido()){
            listaClon.poner(obtenerIterador());
            moverIterador();
        }

        return listaClon;
    }
}
