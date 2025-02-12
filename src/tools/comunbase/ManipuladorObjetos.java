package tools.comunbase;

public class ManipuladorObjetos {

    // Compara dos objetos y me dice
    // positivo si es objeto1 mayor que objeto2
    // cero si es objeto1 es igual que objeto2
    // negativo si es objeto1 es menor que objeto2
    public static int compararObjetos(Object objeto1, Object objeto2){
        if(objeto1 instanceof Number && objeto2 instanceof Number){
            // Los dos son números
            Double numero1 = Double.parseDouble(objeto1.toString());
            Double numero2 = Double.parseDouble(objeto2.toString());

            if (numero1 > numero2){
                return 1;
            } if (numero1 < numero2){
                return -1;
            } else { // igual
                return 0;
            }
        } else { // Por lo menos uno no es número
            // El metodo compareTo regresa un positivo si Ob1 > Ob2
            // si Ob1 < Ob2 regresa un negativo
            // si Ob1 == Ob2 regresa un cero
            return objeto1.toString().compareToIgnoreCase(objeto2.toString());

        }

    }
}
