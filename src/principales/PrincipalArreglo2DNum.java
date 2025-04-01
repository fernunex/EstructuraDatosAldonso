package principales;

import edlineal.ArregloNumerico;
import ednolineal.Arreglo2DNumerico;
import entradasalida.Salida;
import tools.enumerados.TipoLogaritmo;

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

//        // Punto 8 multiplicar()-----------------
//        Arreglo2DNumerico matrix1, matrix2;
//        matrix1 = new Arreglo2DNumerico(2,
//                        3);
//        matrix2 = new Arreglo2DNumerico(3,
//                2);
//        matrix1.cambiar(0,0,1.0);
//        matrix1.cambiar(0,1,2.0);
//        matrix1.cambiar(0,2,3.0);
//        matrix1.cambiar(1,0,4.0);
//        matrix1.cambiar(1,1,5.0);
//        matrix1.cambiar(1,2,6.0);
//
//        matrix2.cambiar(0,0,7.0);
//        matrix2.cambiar(0,1,8.0);
//        matrix2.cambiar(1,0,9.0);
//        matrix2.cambiar(1,1,10.0);
//        matrix2.cambiar(2,0,11.0);
//        matrix2.cambiar(2,1,12.0);
//        // Punto 8 multiplicar()-----------------
//        matrix1.imprimirXRenglones();
//        Salida.salidaPorDefecto("\n");
//        matrix2.imprimirXRenglones();
//        Salida.salidaPorDefecto("\n" +
//                "Multiplicación:\n");
//        matrix1.multiplicar(matrix2);
//        matrix1.imprimirXRenglones();


        // Punto 9 ------------------
//        Arreglo2DNumerico matrix1, matrix2;
//        matrix1 = new Arreglo2DNumerico(3,
//                        3);
//        matrix2 = new Arreglo2DNumerico(3,
//                3);
//        matrix1.cambiar(0,0,1.0);
//        matrix1.cambiar(0,1,2.0);
//        matrix1.cambiar(0,2,3.0);
//        matrix1.cambiar(1,0,4.0);
//        matrix1.cambiar(1,1,5.0);
//        matrix1.cambiar(1,2,6.0);
//        matrix1.cambiar(2,0,5.0);
//        matrix1.cambiar(2,1,12.0);
//        matrix1.cambiar(2,2,-9.0);
//
//        matrix2.cambiar(0,0,7.0);
//        matrix2.cambiar(0,1,8.0);
//        matrix2.cambiar(0,2,4.5);
//        matrix2.cambiar(1,0,9.0);
//        matrix2.cambiar(1,1,10.0);
//        matrix2.cambiar(1,2,1.0);
//        matrix2.cambiar(2,0,11.0);
//        matrix2.cambiar(2,1,12.0);
//        matrix2.cambiar(2,2,5.0);

//        // Punto 9 sumar()
//        Salida.salidaPorDefecto(
//                "Matriz A\n");
//        matrix1.imprimirXRenglones();
//        Salida.salidaPorDefecto(
//                "\nMatriz B\n");
//        matrix2.imprimirXRenglones();
//        Salida.salidaPorDefecto(
//                "\nMatriz A+B:\n");
//        matrix1.sumar(matrix2);
//        matrix1.imprimirXRenglones();


//        // Punto 10 ------------------
//        Arreglo2DNumerico matrix1, matrix2;
//        matrix1 = new Arreglo2DNumerico(3,
//                        3);
//        matrix2 = new Arreglo2DNumerico(3,
//                3);
//        matrix1.cambiar(0,0,1.0);
//        matrix1.cambiar(0,1,2.0);
//        matrix1.cambiar(0,2,3.0);
//        matrix1.cambiar(1,0,4.0);
//        matrix1.cambiar(1,1,5.0);
//        matrix1.cambiar(1,2,6.0);
//        matrix1.cambiar(2,0,5.0);
//        matrix1.cambiar(2,1,12.0);
//        matrix1.cambiar(2,2,-9.0);
//        // Punto 10 aplicarPotencia()
//        Salida.salidaPorDefecto(
//                "Matriz A\n");
//        matrix1.imprimirXRenglones();
//        Salida.salidaPorDefecto(
//                "\nPotencia 3:\n");
//        matrix1.aplicarPotencia(3.0);
//        matrix1.imprimirXRenglones();


        // Punto 11 ------------------
//        Arreglo2DNumerico matrix1, matrix2;
//        matrix1 = new Arreglo2DNumerico(3,
//                3);
//        matrix2 = new Arreglo2DNumerico(3,
//                3);
//        matrix1.cambiar(0,0,2.0);
//        matrix1.cambiar(0,1,4.0);
//        matrix1.cambiar(0,2,256.0);
//        matrix1.cambiar(1,0,16.0);
//        matrix1.cambiar(1,1,32.0);
//        matrix1.cambiar(1,2,4.0);
//        matrix1.cambiar(2,0,512.0);
//        matrix1.cambiar(2,1,64.0);
//        matrix1.cambiar(2,2,156.0);
//        // Punto 11 aplicarLogaritmo()
//        Salida.salidaPorDefecto(
//                "Matriz A\n");
//        matrix1.imprimirXRenglones();
//        Salida.salidaPorDefecto(
//                "\nLog2:\n");
//        matrix1.aplicarLogaritmo(
//                TipoLogaritmo.BASE_2
//        );
//        matrix1.imprimirXRenglones();

        // Punto 12
//        Arreglo2DNumerico matrix1, matrix2;
//        matrix1 = new Arreglo2DNumerico(3,
//                3);
//        matrix2 = new Arreglo2DNumerico(3,
//                3);
//        // Punto 12 matrizDiagonal()
//        Salida.salidaPorDefecto(
//                "Matriz " +
//                        "Diagonal\n");
//        matrix1.matrizDiagonal(
//                6.6);
//        matrix1.imprimirXRenglones();



//        // Punto 13 y 14
                Arreglo2DNumerico matrix1, matrix2;
        matrix1 = new Arreglo2DNumerico(3,
                        3);
        matrix2 = new Arreglo2DNumerico(3,
                3);
        matrix1.cambiar(0,0,1.0);
        matrix1.cambiar(0,1,2.0);
        matrix1.cambiar(0,2,3.0);
        matrix1.cambiar(1,0,0.0);
        matrix1.cambiar(1,1,5.0);
        matrix1.cambiar(1,2,6.0);
        matrix1.cambiar(2,0,0.0);
        matrix1.cambiar(2,1,0.0);
        matrix1.cambiar(2,2,-9.0);

        matrix2.cambiar(0,0,7.0);
        matrix2.cambiar(0,1,0.0);
        matrix2.cambiar(0,2,0.0);
        matrix2.cambiar(1,0,9.0);
        matrix2.cambiar(1,1,10.0);
        matrix2.cambiar(1,2,0.0);
        matrix2.cambiar(2,0,11.0);
        matrix2.cambiar(2,1,12.0);
        matrix2.cambiar(2,2,5.0);
        String STR_A = "\n Matriz A Diagonal Superior:";
        String STR_B = "\n Matriz B Diagonal Inferior:";

        // Punto 13 y 14 esDiagonalSuperior
        // /Inferior()
        Salida.salidaPorDefecto(
                "Matriz A\n");
        matrix1.imprimirXRenglones();
        Salida.salidaPorDefecto(
                "\nMatriz B\n");
        matrix2.imprimirXRenglones();
        Salida.salidaPorDefecto(
                STR_A +
                matrix1.esDiagonalSuperior());
        Salida.salidaPorDefecto(
                STR_B +
                matrix2.esDiagonalInferior());

        // Punto 15 ------------------
//        Arreglo2DNumerico matrix1, matrix2;
//        matrix1 = new Arreglo2DNumerico(3,
//                3);
//        matrix2 = new Arreglo2DNumerico(3,
//                3);
//        matrix1.cambiar(0,0,2.0);
//        matrix1.cambiar(0,1,4.0);
//        matrix1.cambiar(0,2,5.0);
//        matrix1.cambiar(1,0,7.0);
//        matrix1.cambiar(1,1,3.0);
//        matrix1.cambiar(1,2,4.0);
//        matrix1.cambiar(2,0,6.0);
//        matrix1.cambiar(2,1,2.0);
//        matrix1.cambiar(2,2,3.0);
//        // Punto 15 potencia()
//        Salida.salidaPorDefecto(
//                "Matriz A\n");
//        matrix1.imprimirXRenglones();
//        Salida.salidaPorDefecto(
//                "\nMatriz A³:\n");
//        matrix1.potencia(
//                3);
//        matrix1.imprimirXRenglones();


        // Punto 16 --------------------------------------
//
//                        Arreglo2DNumerico matrix1, matrix2;
//        matrix1 = new Arreglo2DNumerico(4,
//                        4);
//        matrix2 = new Arreglo2DNumerico(4,
//                4);
//        matrix2.cambiar(0, 0, 3.0);
//        matrix2.cambiar(0, 1, 7.0);
//        matrix2.cambiar(0, 2, 1.0);
//        matrix2.cambiar(0, 3, 5.0);
//        matrix2.cambiar(1, 0, 8.0);
//        matrix2.cambiar(1, 1, 3.0);
//        matrix2.cambiar(1, 2, 6.0);
//        matrix2.cambiar(1, 3, 0.0);
//        matrix2.cambiar(2, 0, 7.0);
//        matrix2.cambiar(2, 1, 5.0);
//        matrix2.cambiar(2, 2, 7.0);
//        matrix2.cambiar(2, 3, 4.0);
//        matrix2.cambiar(3, 0, 5.0);
//        matrix2.cambiar(3, 1, 6.0);
//        matrix2.cambiar(3, 2, 2.0);
//        matrix2.cambiar(3, 3, 7.0);
        // Punto 16 Doblar matrix
//        Salida.salidaPorDefecto("" +
//                "Matrix 4x4 A\n");
//        matrix2.imprimirXRenglones();
//        Salida.salidaPorDefecto("" +
//                "Doblada 4x2 A\n");
//        matrix2.doblarRenglones();
//        matrix2.imprimirXRenglones();

        // Punto 16 Doblar Matrix impar
//        Arreglo2DNumerico matrix1, matrix2;
//        matrix1 = new Arreglo2DNumerico(4,
//                        4);
//        matrix2 = new Arreglo2DNumerico(4,
//                5);
//        matrix2.cambiar(0, 0, 3.0);
//        matrix2.cambiar(0, 1, 7.0);
//        matrix2.cambiar(0, 2, 1.0);
//        matrix2.cambiar(0, 3, 5.0);
//        matrix2.cambiar(0, 4, 2.0);
//        matrix2.cambiar(1, 0, 8.0);
//        matrix2.cambiar(1, 1, 3.0);
//        matrix2.cambiar(1, 2, 6.0);
//        matrix2.cambiar(1, 3, 0.0);
//        matrix2.cambiar(1, 4, 4.0);
//        matrix2.cambiar(2, 0, 7.0);
//        matrix2.cambiar(2, 1, 5.0);
//        matrix2.cambiar(2, 2, 7.0);
//        matrix2.cambiar(2, 3, 4.0);
//        matrix2.cambiar(2, 4, 6.0);
//        matrix2.cambiar(3, 0, 5.0);
//        matrix2.cambiar(3, 1, 6.0);
//        matrix2.cambiar(3, 2, 2.0);
//        matrix2.cambiar(3, 3, 7.0);
//        matrix2.cambiar(3, 4, 1.0);
//
//        // Punto 16 doblar() en impar
//        Salida.salidaPorDefecto("" +
//                "Matrix 4x5 B\n");
//        matrix2.imprimirXRenglones();
//        Salida.salidaPorDefecto("" +
//                "\nDoblada 4x3 B\n");
//        matrix2.doblarRenglones();
//        matrix2.imprimirXRenglones();


        // Punto 17 --------------------------------------
//
//                        Arreglo2DNumerico matrix1, matrix2;
//        matrix1 = new Arreglo2DNumerico(4,
//                        4);
//        matrix2 = new Arreglo2DNumerico(4,
//                4);
//        matrix2.cambiar(0, 0, 3.0);
//        matrix2.cambiar(0, 1, 7.0);
//        matrix2.cambiar(0, 2, 1.0);
//        matrix2.cambiar(0, 3, 5.0);
//        matrix2.cambiar(1, 0, 8.0);
//        matrix2.cambiar(1, 1, 3.0);
//        matrix2.cambiar(1, 2, 6.0);
//        matrix2.cambiar(1, 3, 0.0);
//        matrix2.cambiar(2, 0, 7.0);
//        matrix2.cambiar(2, 1, 5.0);
//        matrix2.cambiar(2, 2, 7.0);
//        matrix2.cambiar(2, 3, 4.0);
//        matrix2.cambiar(3, 0, 5.0);
//        matrix2.cambiar(3, 1, 6.0);
//        matrix2.cambiar(3, 2, 2.0);
//        matrix2.cambiar(3, 3, 7.0);
//        // Punto 17 DoblarColumnas Par matrix
//        Salida.salidaPorDefecto("" +
//                "Matrix 4x4 A\n");
//        matrix2.imprimirXRenglones();
//        Salida.salidaPorDefecto("" +
//                "\nDoblada 2x4 A\n");
//        matrix2.doblarColumnas();
//        matrix2.imprimirXRenglones();


        // Punto 17 DoblarColumnas Matrix impar
//        Arreglo2DNumerico matrix1, matrix2;
//        matrix1 = new Arreglo2DNumerico(4,
//                        4);
//        matrix2 = new Arreglo2DNumerico(4,
//                5);
//        matrix2.cambiar(0, 0, 3.0);
//        matrix2.cambiar(0, 1, 7.0);
//        matrix2.cambiar(0, 2, 1.0);
//        matrix2.cambiar(0, 3, 5.0);
//        matrix2.cambiar(0, 4, 2.0);
//        matrix2.cambiar(1, 0, 8.0);
//        matrix2.cambiar(1, 1, 3.0);
//        matrix2.cambiar(1, 2, 6.0);
//        matrix2.cambiar(1, 3, 0.0);
//        matrix2.cambiar(1, 4, 4.0);
//        matrix2.cambiar(2, 0, 7.0);
//        matrix2.cambiar(2, 1, 5.0);
//        matrix2.cambiar(2, 2, 7.0);
//        matrix2.cambiar(2, 3, 4.0);
//        matrix2.cambiar(2, 4, 6.0);
//        matrix2.cambiar(3, 0, 5.0);
//        matrix2.cambiar(3, 1, 6.0);
//        matrix2.cambiar(3, 2, 2.0);
//        matrix2.cambiar(3, 3, 7.0);
//        matrix2.cambiar(3, 4, 1.0);
//        matrix2.transpuesta();
////
//        // Punto 17 doblarColumnas() en impar
//        Salida.salidaPorDefecto("" +
//                "Matrix 5x4 B\n");
//        matrix2.imprimirXRenglones();
//        Salida.salidaPorDefecto("" +
//                "\nDoblada 3x4 B\n");
//        matrix2.doblarColumnas();
//        matrix2.imprimirXRenglones();


    }
}
