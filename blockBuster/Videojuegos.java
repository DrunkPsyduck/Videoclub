package blockBuster;

public class Videojuegos {

    private String titulo;
    private String genero;
    private String clasificacionEdad;
    private String multijugador; //si/no
    private String plataforma;
    private double precioAlquiler;

    public Videojuegos(String titulo, String genero, String clasificacionEdad, String multijugador, String plataforma, double precioAlquiler) {
        this.titulo = titulo;
        this.genero = genero;
        this.clasificacionEdad = clasificacionEdad;
        this.multijugador = multijugador;
        this.plataforma = plataforma;
        this.precioAlquiler = precioAlquiler;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Título: ");
        sb.append(titulo).append("\nGenero: ").append(genero).append("\nClasisficacion edad: ").append(clasificacionEdad).append("\nMultijugador: ")
                .append(multijugador).append("\nPlataforma: ").append(genero).append("\nPrecio del alquiler por día: ").append(precioAlquiler);
        return sb.toString();
    }

}
