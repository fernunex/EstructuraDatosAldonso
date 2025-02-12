//package edlineal;
//
//import tools.comunbase.ManipuladorObjetos;
//import tools.enumerados.TipoOrdenamiento;
//
//public class ArregloOrdenado extends Arreglo{
//    private TipoOrdenamiento orden;
//
//    public ArregloOrdenado(int tamanio, TipoOrdenamiento orden) {
//        super(tamanio);
//        this.orden = orden;
//    }
//
//
//    public Integer poner(Object valor){
//        if(lleno() == false){ // hay espacio
//            int posicionEncontrado = (int) buscar(valor);
//            if (posicionEncontrado < 0) { //no existe
//                posicionEncontrado = posicionEncontrado * (-1);
//                posicionEncontrado = posicionEncontrado - 1;
//
//                for (int posMod = (indiceSuperior + 1); posMod >= (posicionEncontrado + 1); posMod--){
//                    datos[posMod] = datos[posMod - 1];
//                }
//
//                datos[posicionEncontrado] = valor;
//                indiceSuperior++;
//                return posicionEncontrado;
//            } else { // Sí existe
//                return -1;
//            }
//        } else { // no hay espacio
//            return -1;
//        }
//    }
//
//
//     Este metodo retorna un positivo con la posicion + 1 donde se encuentra el objeto que se busca
//     o un negativo si no se encontro pero deberia ir ahi al convertirlo en positivo
//    @Override
//    public Object buscar(Object valor){
//        int posicionB = 0;
//        while (posicionB <= indiceSuperior){
//            if (orden == TipoOrdenamiento.INC){
//                if((ManipuladorObjetos.compararObjetos(valor, datos[posicionB]) < 0) == false){
//                    break;
//                }
//            } else { // Es DEC
//                if((ManipuladorObjetos.compararObjetos(valor, datos[posicionB]) > 0) == false){
//                    break;
//                }
//            }
//            posicionB++;
//        }
//        System.out.println(posicionB);
//
//         Primero no se encontro
//        if (posicionB > indiceSuperior){
//            if (vacia() == true){ // Si esta vacio entonces lo colocamos inmediatamente
//                return (posicionB + 1) * (-1);
//            }
//
//            if (orden == TipoOrdenamiento.INC){
//                System.out.println(posicionB);
//                if((ManipuladorObjetos.compararObjetos(valor, datos[posicionB]) < 0) == true){
//                    return (posicionB + 1) * (-1);
//                }
//            } else { // Es DEC
//                if((ManipuladorObjetos.compararObjetos(valor, datos[posicionB]) > 0) == false){
//                    return (posicionB + 1) * (-1);
//                }
//            }
//
//        }
//         Es igual
//        return posicionB +1;
//    }
//}