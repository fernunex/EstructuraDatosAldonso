package registros.ventas;

import registros.personas.Persona;

public class Cliente extends Persona {
    protected String rfc;

    public Cliente(String rfc, String nombre, char genero){
        this.rfc = rfc;
        this.nombre = nombre;
        this.genero = genero;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @Override
    public String toString(){
        return this.rfc;
    }
}
