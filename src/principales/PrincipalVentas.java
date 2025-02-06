package principales;

import registros.ventas.Articulo;
import registros.ventas.Cliente;
import registros.ventas.GestorTienda;

public class PrincipalVentas {
    public static void main(String[] args) {
        GestorTienda tienda = new GestorTienda("PatitoSA",
                5, 2);

        tienda.agregarVendedor("Peter", "BESA3495115",
                1, "12/12/2000");
        tienda.agregarVendedor("Lupe", "SEAA3495999",
                1, "12/12/2001");

        Cliente cliente1 = new Cliente("CALEB55466", "Caleb",
                'M');

        Articulo papitas = new Articulo("001", "Ruffles", 19.9);
        Articulo jugo = new Articulo("067", "Jugo", 29.9);
        Articulo galleta = new Articulo("050", "Galleta", 10.9);

        tienda.agregarNota(cliente1, "06/02/2025", 10);

        tienda.agregarArticuloNota(1, papitas, 3);
        tienda.agregarArticuloNota(1, galleta, 2);
        tienda.agregarArticuloNota(1, jugo, 2);

        tienda.imprimirNota(1);
    }
}
