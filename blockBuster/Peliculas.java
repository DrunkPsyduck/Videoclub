package blockBuster;

import java.io.IOException;

public class Peliculas extends Alquiler {
    private static final long serialVersionUID = 41L;

    private int anio;
    private int duracion;
    private String director;
    private String paisOrigen;

    public Peliculas(int identificador, String genero, double precioAlquiler, String titulo, int anio, int duracion, String director, String paisOrigen) {
        super(identificador, genero, precioAlquiler,titulo);
        this.anio = anio;
        this.duracion = duracion;
        this.director = director;
        this. paisOrigen = paisOrigen;
    }


    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    @Override
    public String toString() {
        return  "Titulo: " + titulo + "\n" +
                " Identificador: " + identificador + "\n" +
                " Año: " + anio + "\n" +
                " Duracion: " + duracion + "\n" +
                " director: " + director + "\n" +
                " Pais de origen: " + paisOrigen + "\n" +
                " Genero: " + genero + "\n" +
                " Precio alquiler: "+ precioAlquiler;
    }

    //    @Override
//    public String toString(){
//        StringBuilder sb = new StringBuilder("Título: ");
//        sb.append(titulo).append("\nAño: ").append(anio).append("\nDuración: ").append(duracion).append("\nDirector ")
//                .append(director).append("\nGenero: ").append(genero).append("\nPaís de origen: ").append(paisOrigen).append("\nPrecio del alquiler por día: ").append(precioAlquiler);
//        return sb.toString();
//    }


}
