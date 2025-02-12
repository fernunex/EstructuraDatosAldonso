package edlineal;

import tools.comunbase.ManipuladorObjetos;
import tools.enumerados.TipoOrdenamiento;

public class ArregloOrdenado extends Arreglo {
    private TipoOrdenamiento orden;

    public ArregloOrdenado(int tamanio, TipoOrdenamiento orden) {
        super(tamanio);
        this.orden = orden;
        if (orden == TipoOrdenamiento.INC) {
            System.out.println("Incre");
        }
    }


    public Integer poner(Object valor) {
        if (lleno() == false) { // hay espacio
            int posicionEncontrado = (int) buscar(valor);
            if (posicionEncontrado < 0) { //no existe
                posicionEncontrado = posicionEncontrado * (-1);
                posicionEncontrado = posicionEncontrado - 1;

                for (int posMod = (indiceSuperior + 1); posMod >= (posicionEncontrado + 1); posMod--) {
                    datos[posMod] = datos[posMod - 1];
                }

                datos[posicionEncontrado] = valor;
                indiceSuperior++;
                return posicionEncontrado;
            } else { // Sí existe
                return -1;
            }
        } else { // no hay espacio
            return -1;
        }
    }


    // Este metodo retorna un positivo con la posicion + 1 donde se encuentra el objeto que se busca
    // o un negativo si no se encontro pero deberia ir ahi al convertirlo en positivo
    @Override
    // saber si esa un objeto o no en un arreglo ordenado i para cuando el objeto no esta en la posicion donde deberia ir o esta
    public Object buscar(Object valor) {
        int posicionB = 0;
        while ((posicionB <= indiceSuperior) && (ManipuladorObjetos.compararObjetos(valor, datos[posicionB]) > 0)) {
            posicionB++;
        }
        if (posicionB > indiceSuperior || ManipuladorObjetos.compararObjetos(valor, datos[posicionB]) < 0) {
            return (posicionB + 1) * -1; //no se encontro
        } else {
            return posicionB + 1; //si se encontro
        }
    }
}
