package principales;

import edlineal.Arreglo;
import edlineal.ArregloNumerico;
import entradasalida.archivos.ArchivoTextoD;
import menus.MenuRegresionLineal;
import registros.machineLearning.RegresionLineal;

public class PrincipalRegresionLineal {
        public static void main(String[] args) {
            String PATH_X = "src/media/datosEstadistica/x_Cuartos.txt";
            String PATH_Y = "src/media/datosEstadistica/y_precios.txt";

            Arreglo x_datos = ArchivoTextoD.leer(PATH_X);
            Arreglo y_datos = ArchivoTextoD.leer(PATH_Y);

            ArregloNumerico x_datos_num = x_datos.convertirArregloNumerico();
            ArregloNumerico y_datos_num = y_datos.convertirArregloNumerico();

            RegresionLineal miReg = new RegresionLineal(x_datos_num, y_datos_num);

            MenuRegresionLineal miMenu = new MenuRegresionLineal(miReg);
            miMenu.execute();
    }
}
