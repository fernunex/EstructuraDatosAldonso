package principales;

import edlineal.Arreglo;
import edlineal.ArregloNumerico;
import entradasalida.archivos.ArchivoTextoD;
import menus.MenuKNN;
import registros.machineLearning.modelosClasificacion.KNNModel;

public class PrincipalKNNWineQuality {
    public static void main(String[] args) {
        //        x1.imprimir();
//        x2.imprimir();
//        x3.imprimir();
//        x4.imprimir();
//        x5.imprimir();
//        x6.imprimir();
//        x7.imprimir();
//        x8.imprimir();
//        x9.imprimir();
//        x10.imprimir();
//        x11.imprimir();
//        etiquetas.imprimir();



        String BASE_PATH_FILES = "src/media/datosWineQuality/";
        // Leyendo las caracteristicas:
        ArregloNumerico x1 = ArchivoTextoD.leer(BASE_PATH_FILES + "/AfixedAcidity.txt")
                .convertirArregloNumerico();
        ArregloNumerico x2 = ArchivoTextoD.leer(BASE_PATH_FILES + "/BvolatileAcidity.txt").convertirArregloNumerico();
        ArregloNumerico x3 = ArchivoTextoD.leer(BASE_PATH_FILES + "/CcitricAcid.txt").convertirArregloNumerico();
        ArregloNumerico x4 = ArchivoTextoD.leer(BASE_PATH_FILES + "/DresidualSugar.txt").convertirArregloNumerico();
        ArregloNumerico x5 = ArchivoTextoD.leer(BASE_PATH_FILES + "/Echlorides.txt").convertirArregloNumerico();
        ArregloNumerico x6 = ArchivoTextoD.leer(BASE_PATH_FILES + "/FfreeSulfur.txt").convertirArregloNumerico();
        ArregloNumerico x7 = ArchivoTextoD.leer(BASE_PATH_FILES + "/GtotalSulfur.txt").convertirArregloNumerico();
        ArregloNumerico x8 = ArchivoTextoD.leer(BASE_PATH_FILES + "/Hdensity.txt").convertirArregloNumerico();
        ArregloNumerico x9 = ArchivoTextoD.leer(BASE_PATH_FILES + "/IpH.txt").convertirArregloNumerico();
        ArregloNumerico x10 = ArchivoTextoD.leer(BASE_PATH_FILES + "/Jsulphates.txt").convertirArregloNumerico();
        ArregloNumerico x11 = ArchivoTextoD.leer(BASE_PATH_FILES + "/Kalcohol.txt").convertirArregloNumerico();
        Arreglo etiquetas = ArchivoTextoD.leer(BASE_PATH_FILES + "/Lquality.txt");

        // Arreglo de caracteristicas
        Arreglo caracteristicas = new Arreglo(11);
        caracteristicas.poner(x1);caracteristicas.poner(x2);caracteristicas.poner(x3);
        caracteristicas.poner(x4);caracteristicas.poner(x5);caracteristicas.poner(x6);
        caracteristicas.poner(x7);caracteristicas.poner(x8);caracteristicas.poner(x9);
        caracteristicas.poner(x10);caracteristicas.poner(x11);

        // Clases posibles
        Arreglo clasesPosibles = new Arreglo(10);
        clasesPosibles.poner("1");clasesPosibles.poner("2");clasesPosibles.poner("3");
        clasesPosibles.poner("4");clasesPosibles.poner("5");clasesPosibles.poner("6");
        clasesPosibles.poner("7");clasesPosibles.poner("8");clasesPosibles.poner("9");
        clasesPosibles.poner("10");

        // Nombre caracteristicas
        Arreglo caracteristicasNombres = new Arreglo(11);
        caracteristicasNombres.poner("fixed acidity");
        caracteristicasNombres.poner("volatile acidity");
        caracteristicasNombres.poner("citric acid");
        caracteristicasNombres.poner("residual sugar");
        caracteristicasNombres.poner("chlorides");
        caracteristicasNombres.poner("free sulfur dioxide");
        caracteristicasNombres.poner("total sulfur dioxide");
        caracteristicasNombres.poner("density");
        caracteristicasNombres.poner("pH");
        caracteristicasNombres.poner("sulphates");
        caracteristicasNombres.poner("alcohol");

        // Creando el modelo KNN y pasandole las etiquetas, etc
        KNNModel miModelo = new KNNModel(
                caracteristicas,
                etiquetas,
                clasesPosibles,
                false,
                7
        );
        // Creando el menu
        MenuKNN miMenu = new MenuKNN(
                "Calidad del vino",
                miModelo,
                caracteristicasNombres,
                clasesPosibles);

        miMenu.execute(); // Ejecutamos el pdrograma
    }
}
