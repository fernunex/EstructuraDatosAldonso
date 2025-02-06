package registros.ventas;

import edlineal.Arreglo;
import entradasalida.Salida;

public class NotaVenta {
    protected int folio;
    protected String fecha;
    protected Vendedor vendedorVenta;
    protected Cliente clienteVenta;
    protected Arreglo articulosVenta;
    protected Arreglo cantidadArticulos;
    protected double total;

    public NotaVenta(int cantidadArticulosVenta, Cliente cliente, Vendedor vendedor, String fecha, int folio){
        this.clienteVenta = cliente;
        this.vendedorVenta = vendedor;
        this.fecha = fecha;
        this.articulosVenta = new Arreglo(cantidadArticulosVenta);
        this.cantidadArticulos = new Arreglo(cantidadArticulosVenta);
        this.folio = folio;
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

    // Este metodo calcula el total de la NotaVenta
    // Utiliza los arreglos paralelos de articulos y cantidad
    private double calcularTotal(){
        // variable de el total acumulado
        double total = 0;

        for(int posicionArreglo = 0; posicionArreglo < articulosVenta.cantidad(); posicionArreglo++){
            // Extraer el artículo guardado en el arreglo de artículo
            Articulo articuloTemp = (Articulo) this.articulosVenta.obtener(posicionArreglo);
            // Obtener el precio de ese artículo
            double precioUnitario = articuloTemp.getPrecioUnitario();
            // obtener la cantidad de elementos
            int cantidad = (int) this.cantidadArticulos.obtener(posicionArreglo);
            // multiplicar para obtener subtotal
            double subtotal = precioUnitario * cantidad;
            // acumular el subtotal dentro del total

        }
        return total;
    }

    // Metodo para imprimir la nota
    public void imprimirNota(){
        // Encabezado
        Salida.salidaPorDefecto("******NOTA DE VENTA*******");
        Salida.salidaPorDefecto("Folio: " + this.folio);
        Salida.salidaPorDefecto("\t\t\tFecha: " + this.fecha + "\n");
        Salida.salidaPorDefecto("Vendedor: " + this.vendedorVenta.getNombre() + "\n");





    }
}
