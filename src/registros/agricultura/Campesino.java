package registros.agricultura;

import edlineal.Arreglo;
import registros.personas.Persona;

public class Campesino extends Persona {
    Arreglo cosechas; // contiene CosechaAnual
    int aniosProduccion;

    public Campesino(String nombre, int edad, char genero, int anios){
        this.cosechas = new Arreglo(anios);
    }
}
