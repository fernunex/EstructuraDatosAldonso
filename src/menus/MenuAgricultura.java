package menus;

import entradasalida.Entrada;
import entradasalida.Salida;
import registros.agricultura.GestorAgricultura;

public class MenuAgricultura {
    private GestorAgricultura gestorAgri;

    public MenuAgricultura(GestorAgricultura gestorAgri){
        this.gestorAgri = gestorAgri;
    }

    // Este metodo corre el menu principal en un bucle
    public void execute(){
        String opcion;
        while (true){
            imprimirMenuBasico();
            opcion = leerOpcion();
            if (opcion.equalsIgnoreCase("x")){
                System.out.println("Saliendo del sistema.........");
                break;
            }
            ejecutarOpcion(opcion);
        }
    }

    // Este metodo ejecuta el metodo correspondiente segun la opcion elejida
    private void ejecutarOpcion(String opcion){
        switch (opcion){
            case "A":
                imprimirPromedioAnual();
                break;
            case "B":
                imprimirMesMasProductivo();
                break;
            case "C":
                imprimirToneladasUltimoMes();
                break;
            case "D":
                imprimirToneladasCuatrimestre();
                break;
            case "E":
                break;
            case "F":
                break;
            case "G":
                break;
            default:
                Salida.salidaPorDefecto("¡Opción Inválida!");
                break;

        }
    }

    // Imprime las toneladas por cuatrimestre de cada año por campesino
    private void imprimirToneladasCuatrimestre() {
        imprimirTitulo("Toneladas Cuatrimestre");
        Salida.salidaPorDefecto("Introduce el nombre del campesino: ");
        String nombreCampesino = Entrada.terminalCadenas();
        getGestorAgri().imprimirTonelajeSegCuatri(nombreCampesino);
    }

    // Imprime toneladas ultimo mes de cada año por campesino
    private void imprimirToneladasUltimoMes() {
        imprimirTitulo("Toneladas ultimo mes");
        Salida.salidaPorDefecto("Introduce el nombre del campesino: ");
        String nombreCampesino = Entrada.terminalCadenas();
        getGestorAgri().imprimirToneladasUltimas(nombreCampesino);
    }

    // Imprime  el mes mas productivo de cada año por campesino
    private void imprimirMesMasProductivo() {
        imprimirTitulo("Meses mas productivos");
        Salida.salidaPorDefecto("Introduce el nombre del campesino: ");
        String nombreCampesino = Entrada.terminalCadenas();
        getGestorAgri().imprimirMesMasProductivo(nombreCampesino);
    }

    // Imprime el promedio anual de toneladas cada año por campesino
    private void imprimirPromedioAnual() {
        imprimirTitulo("Tonelaje anual");
        getGestorAgri().imprimirPromedioAnual();
    }

    // Imprime un pequeño separador con un titulo
    private void imprimirTitulo(String titulo){
        Salida.salidaPorDefecto("\n----------" + titulo +"--------------\n");
    }

    // Este metodo imprime el menu basico
    public void imprimirMenuBasico(){
        Salida.salidaPorDefecto("""
                \nA. El promedio anual de toneladas por campesino.
                B. ¿Cuál fue el mes más productivo de cada año del campesino X?
                C. ¿Cuántas toneladas se obtuvieron el último mes de cada año del campesino X?
                D. ¿Cuántas toneladas se obtuvieron en el segundo cuatrimestre de cada año del
                campesino X?
                E. ¿Qué campesino ha realizado peor su trabajo en cada año?
                F. ¿Qué año es el que produce mayores dividendos a los campesinos?
                G. ¿Qué época del año (primavera, verano, otoño o invierno) genera mayor ganancia
                en producción?
                X. Para Salir
                """);
    }

    // Este metodo solicita ingresar una opcion numero
    private String leerOpcion(){
        Salida.salidaPorDefecto("\nElige una opción: ");
        return Entrada.terminalCadenas();
    }


    public GestorAgricultura getGestorAgri() {
        return gestorAgri;
    }

    public void setGestorAgri(GestorAgricultura gestorAgri) {
        this.gestorAgri = gestorAgri;
    }
}
