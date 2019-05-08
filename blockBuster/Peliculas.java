package blockBuster;

public class Peliculas {

    private String titulo;
    private int anio;
    private int duracion;
    private String director;
    private String genero;
    private String paisOrigen;
    private double precioAlquiler;

    public Peliculas(String titulo, int anio, int duracion, String director, String genero, String paisOrigen, double precioAlquiler) {
        this.titulo = titulo;
        this.anio = anio;
        this.duracion = duracion;
        this.director = director;
        this.genero = genero;
        this.paisOrigen = paisOrigen;
        this.precioAlquiler = precioAlquiler;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Título: ");
        sb.append(titulo).append("\nAño: ").append(anio).append("\nDuración: ").append(duracion).append("\nDirector ")
                .append(director).append("\nGenero: ").append(genero).append("\nPaís de origen: ").append(paisOrigen).append("\nPrecio del alquiler por día: ").append(precioAlquiler);
        return sb.toString();
    }
}
