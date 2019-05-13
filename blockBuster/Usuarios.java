package blockBuster;

import java.io.Serializable;

public class Usuarios implements Serializable {

    //Incluir treeSet
    private int asignarIdentificador=0;

    private int identificador;
    private String nombre;
    private String apellido;
    private int nPeliculasAlquiladas;
    private String peliculasAlquiladas;

    public Usuarios(int identificador, String nombre, String apellido, int nPeliculasAlquiladas, String peliculasAlquiladas) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nPeliculasAlquiladas = nPeliculasAlquiladas;
        this.peliculasAlquiladas = peliculasAlquiladas;
    }

    @Override
    public String toString() {
        return  "Identificador: " + identificador +
                "\n Nombre: '" + nombre + '\'' +
                "\n Apellido: '" + apellido + '\'' +
                "\n Peliculas Alquiladas: " + peliculasAlquiladas
                + " " ;
    }
}
