//package registros.ventas;
//
//import edlineal.Arreglo;
//import edlineal.ListaDin;
//import entradasalida.Salida;
//
//public class NotaVenta2 {
//    protected int folio;
//    protected String fecha;
//    protected Vendedor vendedorVenta;
//    protected Cliente clienteVenta;
//    protected ListaDin articulosVenta;
//    protected ListaDin cantidadArticulos;
//    protected double total;
//
//    public NotaVenta2(Cliente cliente, Vendedor vendedor, String fecha, int folio){
//        this.clienteVenta = cliente;
//        this.vendedorVenta = vendedor;
//        this.fecha = fecha;
//        this.articulosVenta = new ListaDin();
//        this.cantidadArticulos = new ListaDin();
//        this.folio = folio;
//        this.total = 0.0;
//    }
//
//    public boolean agregarArticulo(Articulo articuloVendido, int cantidad){
//        int resultadoInsercionArticulo = this.articulosVenta.poner(articuloVendido);
//        int resultadoInsercionCantidad = this.cantidadArticulos.poner(cantidad);
//
//        // Hubo algun error en la insercion
//        if (resultadoInsercionArticulo == -1 || resultadoInsercionCantidad == -1 ){
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    // Este metodo calcula el total de la NotaVenta
//    // Utiliza las listas paralelas de articulos y cantidad
//    private double calcularTotal(){
//        // variable de el total acumulado
//        double total = 0;
//
//
//        articulosVenta.iniciaIterador();
//        cantidadArticulos.iniciaIterador();
//        while (articulosVenta.iteradorValido() == true && cantidadArticulos.iteradorValido() == true ){
//            // Extraer el artículo guardado en la lista de artículo
//            Articulo articuloTemp = (Articulo) this.articulosVenta.obtenerIterador();
//            // Obtener el precio de ese artículo
//            double precioUnitario = articuloTemp.getPrecioUnitario();
//            // obtener la cantidad de elementos de la lista
//            int cantidad = (int) this.cantidadArticulos.obtenerIterador();
//            // multiplicar para obtener subtotal
//            double subtotal = precioUnitario * cantidad;
//            // acumular el subtotal dentro del total
//            total = total + subtotal;
//
//            articulosVenta.moverIterador();
//            cantidadArticulos.moverIterador();
//        }
//        return total;
//    }
//
//    // Metodo para imprimir la nota
//    public void imprimirNota(){
//        // 1. Encabezado
//        Salida.salidaPorDefecto("******NOTA DE VENTA*******");
//        Salida.salidaPorDefecto("Folio: " + this.folio);
//        Salida.salidaPorDefecto("\t\t\tFecha: " + this.fecha + "\n");
//        Salida.salidaPorDefecto("Vendedor: " + this.vendedorVenta.getNombre() + "\n");
//        Salida.salidaPorDefecto("Cliente: " + this.clienteVenta.getNombre() + "\n");
//
//        // 2. Detalla
//        // Títulos de las columnas
//        Salida.salidaPorDefecto("No. art \t\t Clave \t\t Descripción \t\t Cantidad \t\t Precio U. \t\t Subtotal\n");
//
//        // Imprimir los artículos
//        for (int cadaArticulo = 0; cadaArticulo < this.articulosVenta.cantidad(); cadaArticulo++){
//            // Mostrar el consecutivo (No. Art)
//            Salida.salidaPorDefecto("" + (cadaArticulo + 1) + " \t\t\t\t ");
//            // Extraer cada artículo y sus propiedades
//            // para imprimirlas
//            Articulo articuloTemp = (Articulo) this.articulosVenta.obtener(cadaArticulo);
//            Salida.salidaPorDefecto(articuloTemp.getClave() + " \t\t ");
//            Salida.salidaPorDefecto(articuloTemp.getDescripcion() + " \t\t\t\t");
//            // Extraer la cantidad de cada artículo vendido
//            int cantidadTemporal = (int) cantidadArticulos.obtener(cadaArticulo);
//            Salida.salidaPorDefecto(cantidadTemporal + " \t\t\t ");
//
//            // Mostrar el subtotal
//            Salida.salidaPorDefecto(articuloTemp.getPrecioUnitario() + " \t\t\t ");
//            double subtotal = articuloTemp.getPrecioUnitario() * cantidadTemporal;
//            Salida.salidaPorDefecto(subtotal + " \t\t \n");
//
//        }
//        //
//        this.total = this.calcularTotal();
//        Salida.salidaPorDefecto("\t\t\t\t" + "Total: " + this.total);
//    }
//
//    @Override
//    public String toString(){
//        return "" + this.folio;
//    }
//
//    public int getFolio(){
//        return this.folio;
//    }
//
//    public void setFolio(int folio) {
//        this.folio = folio;
//    }
//
//    public String getFecha() {
//        return fecha;
//    }
//
//    public void setFecha(String fecha) {
//        this.fecha = fecha;
//    }
//
//    public Vendedor getVendedorVenta() {
//        return vendedorVenta;
//    }
//
//    public void setVendedorVenta(Vendedor vendedorVenta) {
//        this.vendedorVenta = vendedorVenta;
//    }
//
//    public Cliente getClienteVenta() {
//        return clienteVenta;
//    }
//
//    public void setClienteVenta(Cliente clienteVenta) {
//        this.clienteVenta = clienteVenta;
//    }
//
//    public Arreglo getArticulosVenta() {
//        return articulosVenta;
//    }
//
//    public void setArticulosVenta(Arreglo articulosVenta) {
//        this.articulosVenta = articulosVenta;
//    }
//
//    public Arreglo getCantidadArticulos() {
//        return cantidadArticulos;
//    }
//
//    public void setCantidadArticulos(Arreglo cantidadArticulos) {
//        this.cantidadArticulos = cantidadArticulos;
//    }
//
//    public double getTotal() {
//        return total;
//    }
//
//    public void setTotal(double total) {
//        this.total = total;
//    }
//}
