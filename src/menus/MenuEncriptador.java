package menus;

import edlineal.ArregloOrdenado;
import entradasalida.Entrada;
import entradasalida.Salida;
import registros.encriptador.EncriptadorTextoBasico;
import tools.enumerados.TipoOrdenamiento;

public class MenuEncriptador {


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

    // Este metodo imprime el menu basico
    private void imprimirMenuBasico(){
        Salida.salidaPorDefecto("""
                \n--------------------------------------------------------------------------------
                \n A) Encriptar
                \n B) Desencriptar
                ('x' Para Salir):
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
                encriptarTexto();
                break;
            case "B":
                desencriptarTexto();
                break;
            default:
                Salida.salidaPorDefecto("¡Opción Inválida!");
                break;

        }
    }

    private void desencriptarTexto() {
        String textoEncriptado = pedirCadena("Introduce el texto a desencriptar:");
        String textoPlano = EncriptadorTextoBasico.desencriptar(textoEncriptado);
        Salida.salidaPorDefecto(
                "El texto plano es: " + textoPlano
        );
    }

    private void encriptarTexto() {
        String textoPlano = pedirCadena("Introduce el texto a encriptar:");
        ArregloOrdenado indices = pedirGrupos();

        if (indices == null){ // Hubo un error al leer los grupos, no hacemos na
            return;
        } else{ // Lo encriptamos
            String textoEncriptado = EncriptadorTextoBasico.encriptar(textoPlano, indices);
            Salida.salidaPorDefecto(
                    "El texto encriptado es: " + textoEncriptado
            );
        }

    }

    // Este metodo pide los valores de los indices y el tamaño de cada grupo. Ademas valida que no se traslapen
    private ArregloOrdenado pedirGrupos(){
        int cantidadGrupos =  Integer.parseInt(pedirCadena("Cantidad de grupos:"));
        ArregloOrdenado indices = new ArregloOrdenado(cantidadGrupos * 2, TipoOrdenamiento.INC);

        int startPoint, longitudGpo, finishPoint, possibleInicio, possibleFinal;

        for (int numGrupo = 1; numGrupo <= cantidadGrupos; numGrupo++){
            startPoint = Integer.parseInt(pedirCadena("Indice del grupo No. " + numGrupo + ":"));
            longitudGpo = Integer.parseInt(pedirCadena("Longitud del grupo No. " + numGrupo + ":"));
            finishPoint = startPoint + longitudGpo - 1;

            possibleInicio = (int) indices.buscar(startPoint);
            possibleFinal = (int) indices.buscar(finishPoint);

            if (possibleInicio > 0 || possibleFinal > 0){ // Ya se encuentra alguno de ambos y se traslapan
                Salida.salidaPorDefecto("Error. LOS INDICES SE TRASLAPAN");
                return null;
            } else {
                if (possibleInicio != possibleFinal){ // Se traslapan con otros indices
                    Salida.salidaPorDefecto("Error. LOS INDICES SE TRASLAPAN");
                    return null;
                } else {
                    if ((possibleInicio * - 1) % 2 == 0){ // Es par y se traslapa con otros indices
                        Salida.salidaPorDefecto("Error. LOS INDICES SE TRASLAPAN");
                        return null;
                    } else {
                        indices.poner(startPoint);
                        indices.poner(finishPoint);
                    }
                }
            }
        }
        return indices;
    }

    // Este metodo le pide una cadena al usuario, ademas se le pueden pasar algunas indicaciones
    private String pedirCadena(String cadena){
        Salida.salidaPorDefecto(cadena);
        return Entrada.terminalCadenas();
    }

}