package menus;

import entradasalida.Entrada;
import entradasalida.Salida;
import registros.terminos.GestorTerminos;

public class MenuTerminos {
    private GestorTerminos gestorTerm;

    public MenuTerminos(GestorTerminos gestorTerm) {
        this.gestorTerm = gestorTerm;
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

    // Imprime un pequeño separador con un titulo
    private void imprimirTitulo(String titulo){
        Salida.salidaPorDefecto("\n----------" + titulo +"--------------\n");
    }

    // Este metodo imprime el menu basico
    public void imprimirMenuBasico(){
        Salida.salidaPorDefecto("""
                
                ************************************************************************************
                  A) Agregar términos, subtérminos y sus páginas (éstas pueden ser                    
                  individuales o rangos).
                  B) Consultar un término con base en su descripción/nombre.
                  C) Consultar un subtérmino con base en su descripción/nombre.
                  D) Listar todos los términos/subtérminos y sus páginas.
                  E) Listar solo los términos de un rango de letras iniciales, por ejemplo, solo
                  los que inicien con B y D.
                  X. Para Salir
                *************************************************************************************
                """);
    }

    // Este metodo solicita ingresar una opcion numero
    private String leerOpcion(){
        Salida.salidaPorDefecto("\nElige una opción: ");
        return Entrada.terminalCadenas();
    }

    // Este metodo ejecuta el metodo correspondiente segun la opcion elejida
    private void ejecutarOpcion(String opcion){
        switch (opcion){
            case "A":
                agregarTermino();
                break;
            case "B":
                consultarTermino();
                break;
            case "C":
                consultarSubtermino();
                break;
            case "D":
                imprimirTodosTerminos();
                break;
            case "E":
                listarTerminosRango();
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

    // Este metodo le pide una cadena al usuario, ademas se le pueden pasar algunas indicaciones
    private String pedirCadena(String cadena){
        Salida.salidaPorDefecto(cadena);
        return Entrada.terminalCadenas();
    }

    // Este metodo imprime un subtermino si lo encuentra o indica si no existe
    private void consultarSubtermino() {
        imprimirTitulo("Consultando un subtérmino");
        String subTermNombre = pedirCadena("Introduce un subtermino a consultar: ");
        gestorTerm.imprimirSubtermino(subTermNombre);
    }

    // Este metodo imprime todos los subterminos del indice
    private void imprimirTodosTerminos() {
        imprimirTitulo("Imprimiendo todos los términos");
        gestorTerm.imprimirTodos();
    }

    private void listarTerminosRango() {
        imprimirTitulo("Imprimiendo un rango de términos");
        String letraInicial = pedirCadena("Letra inicial: ");
        String letraFinal = pedirCadena("Letra final: ");
        gestorTerm.imprimirRango(letraInicial, letraFinal);
    }

    private void consultarTermino() {
        imprimirTitulo("Consultando un término");
        String termNombre = pedirCadena("Introduce un término a consultar: ");
        gestorTerm.imprimirTermino(termNombre);
    }

    private void agregarTermino() {
        imprimirTitulo("Agregando un término y sus subtérminos");
        gestorTerm.insertarTerminoConsola();
    }

}
