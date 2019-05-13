package blockBuster;

import java.io.Serializable;

public class Videojuegos extends Alquiler{


    private String clasificacionEdad;
    private String multijugador; //si/no
    private String plataforma;

    public Videojuegos(int identificador, String genero, double precioAlquiler, String titulo, String clasificacionEdad, String multijugador, String plataforma) {
        super(identificador, genero, precioAlquiler, titulo);
        this.clasificacionEdad = clasificacionEdad;
        this.multijugador = multijugador;
        this.plataforma = plataforma;
    }

    @Override
    public String toString() {
        return
                 titulo + '\'' +
                " genero: " + genero + "\n" +
                " clasificacionEdad: " + clasificacionEdad + "\n" +
                " multijugador: " + multijugador + "\n" +
                " plataforma: " + plataforma + "\n" +
                " identificador: " + identificador + "\n" +
                " precioAlquiler: " + precioAlquiler;
    }

    //    @Override
//    public String toString(){
//        StringBuilder sb = new StringBuilder("Título: ");
//        sb.append(titulo).append("\nGenero: ").append(genero).append("\nClasisficacion edad: ").append(clasificacionEdad).append("\nMultijugador: ")
//                .append(multijugador).append("\nPlataforma: ").append(genero).append("\nPrecio del alquiler por día: ").append(precioAlquiler);
//        return sb.toString();
//    }

}
