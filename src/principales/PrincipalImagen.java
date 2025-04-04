package principales;

import registros.imagen.ImageFileRecord;
import tools.enumerados.FactorEscalado;

public class PrincipalImagen {
    public static void main(String[] args) {

        String PATH = "/home/fernunex/Documents/Uni/4_sem/" +
                "EstructuraDatos/ed_aldonso_2025/src/media/images" +
                "/";

//        String PATH_IMG = "/home/fernunex/Documents/Uni/4_sem/EstructuraDatos/ed_aldonso_2025/src/media/images/sonicSS.png";
//        String PATH_IMG_CHANGED = "/home/fernunex/Documents/Uni/4_sem/EstructuraDatos/ed_aldonso_2025/src/media/images/sonic4.png";
//
//
//        ImageFileRecord miSonic = new ImageFileRecord(PATH_IMG);
//        miSonic.grabarImagen(PATH_IMG_CHANGED);

        // Punto 3 Escala grises
//        String PATH_IMG = "/home/fernunex/Documents/Uni/4_sem/EstructuraDatos/ed_aldonso_2025/src/media/images/sonicSS.png";
//        String PATH_IMG_CHANGED = "/home/fernunex/Documents/Uni/4_sem/" +
//                "EstructuraDatos/ed_aldonso_2025/src" +
//                "/media/images/sonicGrises2.png";
//        ImageFileRecord miSonic = new ImageFileRecord(PATH_IMG);
//        miSonic.convertirEscalaGrises();
//        miSonic.grabarImagen(PATH_IMG_CHANGED);

        // Punto 4 Aumentar el brillo
//        String PATH_IMG = PATH + "sonicGrises2.png";
//        String PATH_IMG_CHANGED = PATH + "sonicGrisesBrilloAlto.png";
//        ImageFileRecord miSonic = new ImageFileRecord(PATH_IMG);
//        ImageFileRecord miSonic2 = new ImageFileRecord(PATH_IMG);
//        miSonic.modificarBrillo(100); // Aumeto brillo
//        miSonic.grabarImagen(PATH_IMG_CHANGED);
//        String PATH_IMG_CHANGED2 = PATH  + "sonicGrisesBrilloBajo.png";
//        miSonic2.modificarBrillo(-100); // Decremento Brillo
//        miSonic2.grabarImagen(PATH_IMG_CHANGED2);

        // Punto 5 Inversion en Horizontal
//        String PATH_IMG = PATH + "sonicSS.png";
//        String PATH_IMG_CHANGED = PATH + "sonicInverHoriz.png";
//        ImageFileRecord miSonic = new ImageFileRecord(PATH_IMG);
//        miSonic.invertirHorizontal(); // Inversion
//        miSonic.grabarImagen(PATH_IMG_CHANGED);

        // Punto 6 Inversion en Vertical
//        String PATH_IMG = PATH + "sonicSS.png";
//        String PATH_IMG_CHANGED = PATH + "sonicInverVerti.png";
//        ImageFileRecord miSonic = new ImageFileRecord(PATH_IMG);
//        miSonic.invertirVertical(); // Inversion Vertical
//        miSonic.grabarImagen(PATH_IMG_CHANGED);

        // Punto 7 Rotar90, 180, 270
//        String PATH_IMG = PATH + "sonicSS.png";
//        String PATH_IMG_CHANGED = PATH + "sonic90Degree.png";
//        ImageFileRecord miSonic = new ImageFileRecord(PATH_IMG);
//        miSonic.rotar90(); // Rotación 90
//        miSonic.grabarImagen(PATH_IMG_CHANGED);

//        String PATH_IMG = PATH + "sonicSS.png";
//        String PATH_IMG_CHANGED = PATH + "sonic180Degree.png";
//        ImageFileRecord miSonic = new ImageFileRecord(PATH_IMG);
//        miSonic.rotar180();// Rotación 180
//        miSonic.grabarImagen(PATH_IMG_CHANGED);
//
//        String PATH_IMG = PATH + "sonicSS.png";
//        String PATH_IMG_CHANGED = PATH + "sonic270Degree.png";
//        ImageFileRecord miSonic = new ImageFileRecord(PATH_IMG);
//        miSonic.rotar270();// Rotación 270
//        miSonic.grabarImagen(PATH_IMG_CHANGED);

        // Punto 8 Transpuesta
//        String PATH_IMG = PATH + "sonicSS.png";
//        String PATH_IMG_CHANGED = PATH + "sonicTransponido2.png";
//        ImageFileRecord miSonic = new ImageFileRecord(PATH_IMG);
//        miSonic.transpuesta();// transpuestos
//        miSonic.grabarImagen(PATH_IMG_CHANGED);


        // Punto 9 Redimensionar Agrandar
//        String PATH_IMG = PATH + "sonicSS.png";
//        String PATH_IMG_CHANGED = PATH + "sonicGrande.png";
//        ImageFileRecord miSonic = new ImageFileRecord(PATH_IMG);
//        miSonic.redimensionar(FactorEscalado.DOBLE);
//        miSonic.grabarImagen(PATH_IMG_CHANGED);

        // Punto 9 Redimensionar Achicar
//        String PATH_IMG = PATH + "sonicSS.png";
//        String PATH_IMG_CHANGED = PATH + "sonicChiquto.png";
//        ImageFileRecord miSonic = new ImageFileRecord(PATH_IMG);
//        miSonic.redimensionar(FactorEscalado.MITAD);
//        miSonic.grabarImagen(PATH_IMG_CHANGED);

        // Punto 10 agregar Marco de 15 y rojo
//        String PATH_IMG = PATH + "sonicSS.png";
//        String PATH_IMG_CHANGED = PATH + "sonicMarco.png";
//        ImageFileRecord miSonic = new ImageFileRecord(PATH_IMG);
//        int rojo = 0xFF0000;
//        miSonic.agregarMarco(15, rojo);
//        miSonic.grabarImagen(PATH_IMG_CHANGED);

        // Punto 11 Convertir a blanco y negro
        String PATH_IMG = PATH + "sonicSS.png";
        String PATH_IMG_CHANGED = PATH + "sonicBlancoNegro.png";
        ImageFileRecord miSonic = new ImageFileRecord(PATH_IMG);
        miSonic.aBlancoNegro();
        miSonic.grabarImagen(PATH_IMG_CHANGED);
    }

}





