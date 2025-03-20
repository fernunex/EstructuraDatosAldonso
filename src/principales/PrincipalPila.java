package principales;

import edlineal.PilaFija;

public class PrincipalPila {
    public static void main(String[] args) {
        PilaFija miPila = new PilaFija(6);
        miPila.poner("A");
        miPila.poner("S");
        miPila.poner("T");
        miPila.poner("M");
        miPila.poner("R");

        miPila.imprimir();
    }
}
