package principales;

import edlineal.ArregloNumerico;
import ednolineal.Arreglo2DNumerico;
import entradasalida.Salida;

public class PrincipalArreglo2DNum {
    public static void main(String[] args) {

        // Punto 1,2,3 Constructores y sobreescritura
//        Arreglo2DNumerico miArr2DNum =
//                new Arreglo2DNumerico(3,3);
//        miArr2DNum.imprimirXRenglones();
//        Salida.salidaPorDefecto("\n");
//        miArr2DNum =
//                new Arreglo2DNumerico(3,
//                        3,7.5);
//        miArr2DNum.imprimirXRenglones();


//        ArregloNumerico arrNum = new ArregloNumerico(9);
//        // Punto 4 y 5 porEscalar/Escalares()
//        Arreglo2DNumerico miArr2DNum =
//                new Arreglo2DNumerico(3,
//                        3, 1.0);
//        arrNum.poner(1.0);arrNum.poner(2.0);
//        arrNum.poner(3.0);arrNum.poner(4.0);
//        arrNum.poner(5.0);arrNum.poner(6.0);
//        arrNum.poner(7.0);arrNum.poner(8.0);
//        arrNum.poner(9.0);
//        miArr2DNum.porEscalar(6.66);
//        miArr2DNum.imprimirXRenglones();
//        Salida.salidaPorDefecto("\n");
//        miArr2DNum.rellenar(1.0);
//        miArr2DNum.porEscalares(arrNum);
//        miArr2DNum.imprimirXRenglones();


//        ArregloNumerico arrNum = new ArregloNumerico(9);
//        // Punto 6 y 7 sumarEscalar/Escalares()
//        Arreglo2DNumerico miArr2DNum =
//                new Arreglo2DNumerico(3,
//                        3, 1.0);
//        arrNum.poner(1.0);arrNum.poner(2.0);
//        arrNum.poner(3.0);arrNum.poner(4.0);
//        arrNum.poner(5.0);arrNum.poner(6.0);
//        arrNum.poner(7.0);arrNum.poner(8.0);
//        arrNum.poner(9.0);
//        miArr2DNum.sumarEscalar(6.66);
//        miArr2DNum.imprimirXRenglones();
//        Salida.salidaPorDefecto("\n");
//        miArr2DNum.rellenar(1.0);
//        miArr2DNum.sumarEscalares(arrNum);
//        miArr2DNum.imprimirXRenglones();

        // Punto 8 multiplicar()-----------------
        Arreglo2DNumerico matrix1, matrix2;
        matrix1 = new Arreglo2DNumerico(2,
                        3);
        matrix2 = new Arreglo2DNumerico(3,
                2);
        matrix1.cambiar(0,0,1.0);
        matrix1.cambiar(0,1,2.0);
        matrix1.cambiar(0,2,3.0);
        matrix1.cambiar(1,0,4.0);
        matrix1.cambiar(1,1,5.0);
        matrix1.cambiar(1,2,6.0);

        matrix2.cambiar(0,0,7.0);
        matrix2.cambiar(0,1,8.0);
        matrix2.cambiar(1,0,9.0);
        matrix2.cambiar(1,1,10.0);
        matrix2.cambiar(2,0,11.0);
        matrix2.cambiar(2,1,12.0);
        // Punto 8 multiplicar()-----------------
        matrix1.imprimirXRenglones();
        Salida.salidaPorDefecto("\n");
        matrix2.imprimirXRenglones();
        Salida.salidaPorDefecto("\n" +
                "Multiplicación:\n");
        matrix1.multiplicar(matrix2);
        matrix1.imprimirXRenglones();



    }
}
