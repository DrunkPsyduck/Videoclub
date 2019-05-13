package blockBuster;

import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";


    protected ArrayList<Peliculas> peliculas;
    protected ArrayList<Videojuegos> videojuego;
    protected ArrayList<Usuarios> usuarios;



    public App(ArrayList<Peliculas> peliculas, ArrayList<Videojuegos> videojuego, ArrayList<Usuarios> usuarios) {
        this.peliculas = peliculas;
        this.videojuego = videojuego;
        this.usuarios = usuarios;
    }

    public App() {
        peliculas = new ArrayList();
        videojuego = new ArrayList();
        usuarios = new ArrayList();
    }

    public void nuevaPelicula() {
        int index = 0;

        int identificador = index;
        System.out.println("Introduzca el genero de la pelicula");
        String genero = EntradaSalida.leerTexto();
        System.out.println("precio del alquiler");
        double precioAlquiler = EntradaSalida.leerDouble();
        System.out.println("Introduzca el titulo de la pelicula");
        String titulo = EntradaSalida.leerTexto();
        System.out.println("Introduzca el año");
        int anio = EntradaSalida.leerEnteros();
        System.out.println("introduzca la duracion en minutos");
        int duracion = EntradaSalida.leerEnteros();
        System.out.println("Introduzca el nombre del director");
        String director = EntradaSalida.leerTexto();
        System.out.println("Introduzca el pais de origen");
        String paisOrigen = EntradaSalida.leerTexto();

        peliculas.add(index, new Peliculas(identificador, genero, precioAlquiler, titulo, anio, duracion, director, paisOrigen));
        index++;
    }

    public void nuevoVideojuego() {
        int index = 0;
        //int identificador, String genero, double precioAlquiler, String titulo, String clasificacionEdad, String multijugador, String plataforma
        int identificador = index;
        System.out.println("Introduzca el genero del videojuego");
        String genero = EntradaSalida.leerTexto();
        System.out.println("precio del alquiler");
        double precioAlquiler = EntradaSalida.leerDouble();
        System.out.println("Introduzca el titulo");
        String titulo = EntradaSalida.leerTexto();
        System.out.println("Introduzca la clasificacion de edad");
        String clasificacionEdad = EntradaSalida.leerTexto();
        System.out.println("¿Tiene multijugador?");
        String multijugador = EntradaSalida.leerTexto();
        System.out.println("Introduzca la plataforma");
        String plataforma = EntradaSalida.leerTexto();

        videojuego.add(index, new Videojuegos(identificador, genero, precioAlquiler, titulo, clasificacionEdad, multijugador, plataforma));
        index++;
    }

    public void nuevoUsuario() {
        //int identificador, String nombre, String apellido, String peliculasAlquiladas
        int index = 0;
        int identificador = index;

        System.out.println("introduzca el nombre");
        String nombre = EntradaSalida.leerTexto();
        System.out.println("introduzca el apellido");
        String apellido = EntradaSalida.leerTexto();
        System.out.println("Cuantas peliculas tiene alquiladas");
        int nPeliculasAlquiladas = EntradaSalida.leerEnteros();

        String peliculasAlquiladas = "";
        if (nPeliculasAlquiladas != 0) {
            int aux = 0;

            while (aux < nPeliculasAlquiladas) {
                System.out.println("introduzca el nombre de la pelicula");
                peliculasAlquiladas += EntradaSalida.leerTexto();
                aux++;
            }
        }
        usuarios.add(identificador, new Usuarios(identificador, nombre, apellido, nPeliculasAlquiladas, peliculasAlquiladas));
        index++;
    }

    // metodo selector
    public void selector() {
        System.out.println("Que opcion deasea. 1. mostrar peliculas 2. Mostrar videojugos");
        int opcion = EntradaSalida.leerEnteros();

        switch (opcion) {
            case 1:
                mostrarContenidoPeliculas();
                break;
            case 2:
                mostrarContenidoVideojuegos();
                break;
            default:
                System.out.println("No valido");

        }
    }


    public void mostrarContenidoPeliculas() {
        if (peliculas.isEmpty()) {
            System.out.println("No existe ningun registro");
        } else {

            for (int i = 0; i < peliculas.size(); i++) {
                System.out.println(ANSI_BLUE + peliculas.get(i) + ANSI_RESET
                );
            }
            System.out.println();
        }
    }

    public void mostrarContenidoVideojuegos() {

        if (videojuego.isEmpty()) {
            System.out.println("NO existe ningun registro");
        } else {
            for (int i = 0; i < videojuego.size(); i++) {
                System.out.println(videojuego.get(i));
            }
        }
        System.out.println("Fin del fichero");
    }

    public void mostrarUsuarios() {
        if (!usuarios.isEmpty()) {
            for (int i = 0; i < usuarios.size(); i++) {
                System.out.println(usuarios.get(i));
            }
        } else {
            System.out.println("No hay usuarios");
        }
    }
    public void borrarColecciones(){
        for (int i = 0; i < usuarios.size() ; i++) {
            usuarios.remove(i);
        }

        for (int i = 0; i < peliculas.size(); i++) {
            peliculas.remove(i);
        }

        for (int i = 0; i < videojuego.size(); i++) {
            videojuego.remove(i);
        }

    }
}
