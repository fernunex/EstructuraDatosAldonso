package principales;

import edlineal.Arreglo;
import edlineal.ArregloNumerico;
import entradasalida.Salida;

public class PrincipalArregloNumerico {
    public static void main(String[] args) {
        String ENDL = "\n";

        // 1) Metodos SobreEscritos
//        ArregloNumerico numerico = new ArregloNumerico(5);
//        numerico.poner(25);
//        Salida.salidaPorDefecto("Agregando 'Juan': " +
//                numerico.poner("Juan") + ENDL);
//        Salida.salidaPorDefecto("Agregando 22: "+
//                numerico.poner(22) + ENDL);
//        Salida.salidaPorDefecto("Encontrando 'Juan': "+
//                numerico.buscar("Juan") + ENDL);
//        Salida.salidaPorDefecto("Encontrando 22: "+
//                numerico.buscar(22) + ENDL);
//        Salida.salidaPorDefecto("Rellenando con 5s" + ENDL);
//        numerico.rellenar(5, 3);
//        numerico.imprimir();

        // 2) porEscalar() y 3) sumarEscalar()
//        ArregloNumerico numerico = new ArregloNumerico(4);
//        numerico.poner(1);
//        numerico.poner(5);
//        numerico.poner(3);
//        Salida.salidaPorDefecto(ENDL +
//                "Despues de multiplicar por 2 a todo" + ENDL);
//        numerico.porEscalar(2);
//        numerico.imprimir();
//        Salida.salidaPorDefecto(
//                "Despues de sumar 3 a todos" + ENDL);
//        numerico.sumarEscalar(3.5);
//        numerico.imprimir();

        // 4) sumar()
//        ArregloNumerico numerico = new ArregloNumerico(4);
//        numerico.poner(1);
//        numerico.poner(5);
//        numerico.poner(3);
//        ArregloNumerico numerico2 = new ArregloNumerico(4);
//        numerico2.poner(3);
//        numerico2.poner(1);
//        numerico2.poner(-15);
//        Salida.salidaPorDefecto(
//                "Despues de sumar lista1 con lista2" + ENDL);
//        numerico.sumar(numerico2);
//        numerico.imprimir();

        // 5) multiplicar()
//        ArregloNumerico numerico = new ArregloNumerico(4);
//        numerico.poner(2);
//        numerico.poner(5);
//        numerico.poner(7);
//        ArregloNumerico numerico2 = new ArregloNumerico(4);
//        numerico2.poner(3);
//        numerico2.poner(4);
//        numerico2.poner(-1);
//        Salida.salidaPorDefecto(
//                "Despues de multiplicar lista1 con lista2"
//                        + ENDL);
//        numerico.multiplicar(numerico2);
//        numerico.imprimir();

//        6) aplicarPotencia()
//        ArregloNumerico numArr = new ArregloNumerico(
//                4);
//        numArr.poner(2);
//        numArr.poner(5);
//        numArr.poner(7);
//        numArr.aplicarPotencia(2);
//        Salida.salidaPorDefecto(
//                "Despues de aplicar ^2"
//                        + ENDL);
//        numArr.imprimir();


//        7) aplicarPotencia()
//        ArregloNumerico numArr = new ArregloNumerico(4);
//        numArr.poner(2);
//        numArr.poner(5);
//        numArr.poner(7);
//        ArregloNumerico potencias = new ArregloNumerico(4);
//        potencias.poner(5);
//        potencias.poner(3);
//        potencias.poner(2);
//        numArr.aplicarPotencia(potencias);
//        Salida.salidaPorDefecto(
//                "Despues de aplicar las potencias"
//                        + ENDL);
//        numArr.imprimir();
//
//
//      8) productoEscalar()
//        ArregloNumerico numArr = new ArregloNumerico(4);
//        numArr.poner(2);
//        numArr.poner(5);
//        numArr.poner(7);
//        ArregloNumerico numArr2 = new ArregloNumerico(4);
//        numArr2.poner(5); // *2 = 10
//        numArr2.poner(3); // *5 = 15
//        numArr2.poner(2); // *7 = 14
//        Salida.salidaPorDefecto( //  = 39
//                "El producto escalar es: "
//                        + numArr.productoEscalar(numArr2)
//                        + ENDL);

        // 9) norma y 10) normaEuclideana
//        ArregloNumerico numArr = new ArregloNumerico(4);
//        numArr.poner(2); numArr.poner(5);
//        numArr.poner(7);
//        ArregloNumerico numArr2 = new ArregloNumerico(4);
//        numArr2.poner(5);numArr2.poner(3);
//        numArr2.poner(2);
//        Salida.salidaPorDefecto(
//                "Norma de numArr: " + ENDL
//                        + numArr.norma()
//                        + ENDL);
//        Salida.salidaPorDefecto(
//                "NormaEuclideana de numArr y numArr2: " + ENDL
//                        + numArr.normaEuclideana(numArr2)
//                        + ENDL);

        // 11) sumarListaEstatica
//        ArregloNumerico numArr = new ArregloNumerico(4);
//        numArr.poner(2); numArr.poner(5); //2,5,7,1
//        numArr.poner(7); numArr.poner(1);
//        ArregloNumerico numArr2 = new ArregloNumerico(4);
//        numArr2.poner(5); numArr2.poner(3); //5,3,2,6
//        numArr2.poner(2); numArr2.poner(6);
//        ArregloNumerico numArr3 = new ArregloNumerico(4);
//        numArr3.poner(3); numArr3.poner(0); //3,0,1,-5
//        numArr3.poner(1); numArr3.poner(-5);
//        ArregloNumerico numArr4 = new ArregloNumerico(4);
//        numArr4.poner(-5); numArr4.poner(3); //-5,3,-1,-3
//        numArr4.poner(-1); numArr4.poner(-3);
//        // Agregamos los arreglos númericos a un arreglo
//        Arreglo listaArrs = new Arreglo(3);
//        listaArrs.poner(numArr2);listaArrs.poner(numArr3);
//        listaArrs.poner(numArr4);
//        // Realizamos la suma e imprimimos
//        numArr.imprimir();
//        numArr.sumarListaEstatica(listaArrs);
//        Salida.salidaPorDefecto(
//                "--Sumada--" + ENDL);
//        numArr.imprimir();

//        12) sumarEscalares()
//        ArregloNumerico numArr = new ArregloNumerico(4);
//        numArr.poner(2); numArr.poner(5); //2,5,7,1
//        numArr.poner(7); numArr.poner(1);
//        ArregloNumerico numArr2 = new ArregloNumerico(4);
//        numArr2.poner(5); numArr2.poner(3); //5,3,2
//        numArr2.poner(2);
//        // Realizamos la suma e imprimimos
//        numArr.imprimir();
//        numArr.sumarEscalares(numArr2);
//        Salida.salidaPorDefecto(
//                "--Sumada Escalares--" + ENDL);
//        numArr.imprimir();

//        13) sumarIndices()
//        ArregloNumerico numArr = new ArregloNumerico(4);
//        numArr.poner(2); numArr.poner(5); //2,5,7,1
//        numArr.poner(7); numArr.poner(1);
//        ArregloNumerico numArr2 = new ArregloNumerico(4);
//        numArr2.poner(0); numArr2.poner(3); //0,3,1
//        numArr2.poner(1);
//        // Realizamos la suma e imprimimos
//        numArr.imprimir();
//        Salida.salidaPorDefecto(
//                "--Sumando el del indice 0,1 y 3--" + ENDL);
//        Salida.salidaPorDefecto(numArr.sumarIndices(numArr2)
//                + "");

//        14) P1 subLista() -- Arreglo
//        Arreglo arr = new Arreglo(6);
//        arr.poner("a");arr.poner("b");
//        arr.poner("c");arr.poner("d");
//        arr.poner("e");arr.poner("f");
//        ArregloNumerico arrIndex = new ArregloNumerico(3);
//        arrIndex.poner(0);arrIndex.poner(3);
//        arrIndex.poner(5);
//        arr.imprimir();
//        Salida.salidaPorDefecto(
//                "--Sub arreglo Indices; 0,3 y 5--" + ENDL);
//        arr.subLista(arrIndex).imprimir();


//        14) P2 subLista() -- ArregloNumerico
//        ArregloNumerico arr = new ArregloNumerico(6);
//        arr.poner(15);arr.poner(0);
//        arr.poner(16);arr.poner(5);
//        arr.poner(-8);arr.poner(2);
//        ArregloNumerico arrIndex = new ArregloNumerico(3);
//        arrIndex.poner(0);arrIndex.poner(3);
//        arrIndex.poner(5);
//        arr.imprimir();
//        Salida.salidaPorDefecto(
//                "--Sub arreglo Indices; 0,3 y 5--" + ENDL);
//        arr.subLista(arrIndex).imprimir();

//        15) sonLinealementeDependientes() y
//        16) sonLinealmenteIndependientes()
//        ArregloNumerico numK = new ArregloNumerico(3);
//        numK.poner(2); numK.poner(-1); //2,-1,0
//        numK.poner(0);
//        ArregloNumerico vec1 = new ArregloNumerico(3);
//        vec1.poner(1); vec1.poner(2); //1,2,3
//        vec1.poner(3);
//        ArregloNumerico vec2 = new ArregloNumerico(3);
//        vec2.poner(2); vec2.poner(4); //2,4,6
//        vec2.poner(6);
//        ArregloNumerico vec3 = new ArregloNumerico(3);
//        vec3.poner(3); vec3.poner(6); //3,6,9
//        vec3.poner(9);
//        Arreglo listaVec = new Arreglo(3);
//        listaVec.poner(vec1);
//        listaVec.poner(vec2);
//        listaVec.poner(vec3);
//                Salida.salidaPorDefecto(
//                "--Linealmente Dependientes: --" +
//                        numK.sonLinealmenteDependientes(
//                                listaVec)
//                        + ENDL);
//        Salida.salidaPorDefecto(
//                "--Linealmente Independientes: --" +
//                        numK.sonLinealmenteIndependientes(
//                                listaVec)
//                        + ENDL);

//        17) esOrtogonal()
//        ArregloNumerico arr1 = new ArregloNumerico(3);
//        ArregloNumerico arr2 = new ArregloNumerico(3);
//        arr1.poner(3);arr1.poner(1); // 3,1,7
//        arr1.poner(7);
//        arr2.poner(7);arr2.poner(0); // 7,0,-3
//        arr2.poner(-3);
//        Salida.salidaPorDefecto(
//                "--Es Ortogonal (7,0,-3): " +
//                        arr1.esOrtogonal(arr2) + ENDL);
//        arr2.modificar(1, 5);
//        Salida.salidaPorDefecto(
//                "--Es Ortogonal (7,5,-3): " +
//                        arr1.esOrtogonal(arr2) + ENDL);


//        18) esParalelo()
        ArregloNumerico arr1 = new ArregloNumerico(3);
        ArregloNumerico arr2 = new ArregloNumerico(3);
        arr1.poner(4);arr1.poner(3); // 4,3,6
        arr1.poner(6);
        arr2.poner(8);arr2.poner(6); // 8,6,12
        arr2.poner(12);
        Salida.salidaPorDefecto(
                "--Vector base (4,3,6)" + ENDL +
                "--Es Paralelo (8,6,12): " +
                        arr1.esParalelo(arr2) + ENDL);
        arr2.modificar(1, 5);
        Salida.salidaPorDefecto(
                "--Es Paralelo (8,5,12): " +
                        arr1.esParalelo(arr2) + ENDL);

    }
}
