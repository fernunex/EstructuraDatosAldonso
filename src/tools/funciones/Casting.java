package tools.funciones;

public class Casting {

    // Funciones auxiliares
    public static Object[] double2object(double arr[]){
        Object[] datosObjeto = new Object[arr.length];

        for (int indexBuffer = 0; indexBuffer < datosObjeto.length; indexBuffer++) {
            datosObjeto[indexBuffer] = arr[indexBuffer];
        }

        return datosObjeto;
    }

    public static double[] object2double(Object arr[]){
        double[] datosDouble = new double[arr.length];

        for (int indexBuffer = 0; indexBuffer < datosDouble.length; indexBuffer++) {
            datosDouble[indexBuffer] = Double.parseDouble(arr[indexBuffer] + "");
        }
        return datosDouble;
    }

    public static double object2double(Object obj){
        return (double) obj;
    }
}
