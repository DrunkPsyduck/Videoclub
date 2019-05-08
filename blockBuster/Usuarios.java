package blockBuster;

public class Usuarios {

    private int asignarIdentificador=0;

    private int identificador;
    private String nombre;
    private String apellido;

    public Usuarios(int identificador, String nombre, String apellido) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                ", identificador=" + identificador +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
