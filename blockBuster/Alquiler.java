package blockBuster;

import java.io.Serializable;

public abstract class Alquiler implements Serializable {

    protected int identificador;
    protected String genero;
    protected double precioAlquiler;
    protected String titulo;

    public Alquiler(int identificador, String genero, double precioAlquiler,String titulo) {
        this.identificador = identificador;
        this.genero = genero;
        this.precioAlquiler = precioAlquiler;
        this.titulo = titulo;
    }

}
