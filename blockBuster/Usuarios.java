package blockBuster;

import java.io.Serializable;

public class Usuarios implements Serializable,Comparable<Usuarios> {
    private static final long serialVersionUID = 42L;
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

    public int getAsignarIdentificador() {
        return asignarIdentificador;
    }

    public void setAsignarIdentificador(int asignarIdentificador) {
        this.asignarIdentificador = asignarIdentificador;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getnPeliculasAlquiladas() {
        return nPeliculasAlquiladas;
    }

    public void setnPeliculasAlquiladas(int nPeliculasAlquiladas) {
        this.nPeliculasAlquiladas = nPeliculasAlquiladas;
    }

    public String getPeliculasAlquiladas() {
        return peliculasAlquiladas;
    }

    public void setPeliculasAlquiladas(String peliculasAlquiladas) {
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

    public int compareTo(Usuarios usuarios)
    {
        int res=0;
        if (nPeliculasAlquiladas < usuarios.nPeliculasAlquiladas) {res=-1;  }
        if (nPeliculasAlquiladas > usuarios.nPeliculasAlquiladas){res=1;}
        return res;
         //return this.nPeliculasAlquiladas-usuarios.nPeliculasAlquiladas;
    }
}
