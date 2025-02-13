package registros.carreras;

public class Corredor {
    protected int numCorredor;
    protected String nombre;
    protected int edad;
    protected char sexo;

    public Corredor(int numCorredor, String nombre, int edad, char sexo){
        this.numCorredor = numCorredor;
        this.nombre = nombre;
        this.edad  = edad;
        this.sexo = sexo;
    }


    public int getNumCorredor() {
        return numCorredor;
    }

    public void setNumCorredor(int numCorredor) {
        this.numCorredor = numCorredor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString(){
        return "" + numCorredor;
    }
}
