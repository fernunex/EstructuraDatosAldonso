package registros.ventas;

import edlineal.Arreglo;

public class NotaVenta {
    protected int folio;
    protected String fecha;
    protected Vendedor vendedorVenta;
    protected Cliente clienteVenta;
    protected Arreglo articulosVenta;
    protected Arreglo cantidadArticulos;
    protected double total;

    public NotaVenta(int cantidadArticulosVenta, Cliente cliente, Vendedor vendedor, String fecha){
        this.clienteVenta = cliente;
        this.vendedorVenta = vendedor;
        this.fecha = fecha;
        this.articulosVenta = new Arreglo(cantidadArticulosVenta);
        this.cantidadArticulos = new Arreglo(cantidadArticulosVenta);
        this.folio = 0;
        this.total = 0.0;
    }

    public boolean agregarArticulo(Articulo articuloVendido, int cantidad){
        int resultadoInsercionArticulo = this.articulosVenta.poner(articuloVendido);
        int resultadoInsercionCantidad = this.cantidadArticulos.poner(cantidad);

        // Hubo algun error
        if (resultadoInsercionArticulo == -1 || resultadoInsercionCantidad == -1 ){
            return false;
        } else {
            return true;
        }
    }

    private double calcularTotal(){
        //Recorrer los arreglos paralelos
        //obtener los articulos y sus costos
        //para multiplicarlos por la cantidad vendida
        for(int posicionArreglo = 0; posicionArreglo < articulosVenta.cantidad(); posicionArreglo++){

        }
        return 0.0;
    }
}
