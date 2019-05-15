package blockBuster;

import java.io.Serializable;

public class Videojuegos extends Alquiler{
    private static final long serialVersionUID = 40L;


    private String clasificacionEdad;
    private String multijugador; //si/no
    private String plataforma;

    public Videojuegos(int identificador, String genero, double precioAlquiler, String titulo, String clasificacionEdad, String multijugador, String plataforma) {
        super(identificador, genero, precioAlquiler, titulo);
        this.clasificacionEdad = clasificacionEdad;
        this.multijugador = multijugador;
        this.plataforma = plataforma;
    }

    public String getClasificacionEdad() {
        return clasificacionEdad;
    }

    public void setClasificacionEdad(String clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    public String getMultijugador() {
        return multijugador;
    }

    public void setMultijugador(String multijugador) {
        this.multijugador = multijugador;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
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
