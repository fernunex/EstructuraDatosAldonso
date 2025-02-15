package principales;

import menus.MenuTerminos;
import registros.terminos.GestorTerminos;
import registros.terminos.Termino;

// Esta clase ejecuta el programa de la practia 3
public class PrincipalTerminos {
    public static void main(String[] args) {
        //----------------- Ejecutando el Programa
        GestorTerminos miIndice = new GestorTerminos("Estructura de Datos",
                20,
                10);

        miIndice.agregarTermino("Colisión", "341-352, 355-380");
        miIndice.agregarSubtermino("Colisión", "resolución",
                "354");
        miIndice.agregarSubtermino("Colisión", "direccionamiento enlazado",
                "356");

        miIndice.agregarTermino("Dijkstra", "464");

        miIndice.agregarTermino("dirección", "341");
        miIndice.agregarSubtermino("dirección", "enlazado", "341, 350");
        miIndice.agregarSubtermino("dirección", "exploración", "350-351");

        miIndice.agregarTermino("grafo", "431-432, 435");
        miIndice.agregarSubtermino("grafo", "adyacente", "432, 435, 439");
        miIndice.agregarSubtermino("grafo", "árbol de expansión", "454-457");
        miIndice.agregarSubtermino("grafo", "árbol de expansión mínimo", "463-464");

        miIndice.agregarTermino("especificación", "8, 28");

        miIndice.agregarTermino("especificación de acceso", "35-36");
        miIndice.agregarSubtermino("especificación de acceso", "private", "35");
        miIndice.agregarSubtermino("especificación de acceso", "protected", "35, 37");
        miIndice.agregarSubtermino("especificación de acceso", "public", "35");

        miIndice.agregarTermino("FIFO", "293-294");

        miIndice.agregarTermino("final", "65, 110");
        miIndice.agregarSubtermino("final", "clase", "110, 121");

        miIndice.agregarSubtermino("final", "métodos", "110, 121");

        miIndice.agregarTermino("Algoritmo A", "470-475");

        MenuTerminos miMenu = new MenuTerminos(miIndice);
        miMenu.execute();


    }
}
