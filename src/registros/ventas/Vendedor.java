package registros.ventas;

import registros.personas.Empleado;
import registros.personas.Persona;

public class Vendedor extends Empleado {
    protected int numeroVendedor;

    public Vendedor(String nombre, String rfc, int numeroVendedor, String fechaNacimiento){
        this.rfc = rfc;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroVendedor = numeroVendedor;
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return this.numeroVendedor + "";
    }
}
