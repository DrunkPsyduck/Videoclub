package blockBuster;

import java.io.*;
import java.util.ArrayList;

public class Gestor {

    public static final String ruta = "..\\BlockBuster\\src\\blockBuster\\";
    protected File FicheroUsuarios = new File(ruta + "FicheroUsuarios.dat");
    protected File FicheroPeliculas = new File(ruta + "FicheroPeliculas.dat");
    protected File FicheroVideojuegos = new File(ruta + "FicheroVideojuegos.dat");

    private String contrasena = "0000";
    private int identificadorUsuario = 0;

    public boolean accesoAdministrador() {
        boolean accesoValido = false;
        System.out.println("Para acceder a la consola de administracion debe introducir una contraseña válida.");
        String intentoPass = EntradaSalida.leerTexto();

        if (contrasena.equals(intentoPass)) {
            accesoValido = true;
        }
        return accesoValido;
    }

    public void gestionAdministrador() {
        if (accesoAdministrador()) {
            System.out.println("Bienvenido al sistema de administracion.\nIntroduzca la opcion deseada.");
            System.out.println("1. ñanadir pelicula \n2. Añadir videojuego \n3. Añadir usuario\n4. volcar datos a otro fichero\n5. Borrar colecciones\n6. Actualizar los ficheros\n7. Consultas\n8. Ranking top 10 \n9. Salir");

            int opcion = EntradaSalida.leerEnteros();
            boolean fin = false;
            while (!fin) {
                switch (opcion) {
                    case 1:

                        break;
                    case 2:
                        // dar de baja un usario
                        break;
                    case 3:
                        // volcar datos a otro fichero
                    case 4:
                        // borrar colecciones
                        break;
                    case 5:
                        //actualizar ficheros
                        break;
                    case 6:
                        //consultas
                        break;
                    case 7:
                        // ranking top 10
                        break;

                    case 8:

                        break;

                    case 9:
                        fin = true;
                        break;
                    default:
                        System.out.println("no valido");
                }
            }
        }

    }

    public void cuentaCliente() throws InterruptedException, IOException {
        System.out.println("introduzca su identificador: ");
        String identificador = EntradaSalida.leerTexto();
        // Comprobar identificador en el fichero. Si existe se accede a la consola de

        ArrayList<String> usuarios = new ArrayList<>();

        boolean salir = false;
    }

    // generar ficheros

    public void generarFicheroUsuarios() throws IOException {
        File FicheroUsuarios = new File(ruta + "FicheroUsuarios.dat");
        if (!FicheroUsuarios.exists()) {
            FicheroUsuarios.createNewFile();
        }
    }

    public void generarFicheroPeliculas() throws IOException {
        File ficheroPeliculas = new File(ruta + "FicheroPeliculas.dat");
        if (!ficheroPeliculas.exists()) {
            ficheroPeliculas.createNewFile();
        }
    }

    public void generarFicheroVideojuegos() throws IOException {
        File ficheroVideojuegos = new File(ruta + "FicheroVideojuegos.dat");
        if (!ficheroVideojuegos.exists()) {
            ficheroVideojuegos.createNewFile();
        }
    }

    //introducir contenido

    public void introducirContenidoFichero() throws IOException {
        System.out.println("Que desea añadir: pelicula, videojuego o usuario");
        String seleccion = EntradaSalida.leerTexto();

        FileOutputStream fos = null;
        DataOutputStream salida = null;

        if (seleccion.equalsIgnoreCase("Pelicula")) {

            if (FicheroPeliculas.exists()) {
                fos = new FileOutputStream(FicheroPeliculas);
                salida = new DataOutputStream(fos);
                System.out.println("introduca el nombre de la pelicula");


                salida.close();
                fos.close();
            }

        } else if (seleccion.equalsIgnoreCase("videojuego")) {

        } else if (seleccion.equalsIgnoreCase("usuario")) {

            if (FicheroUsuarios.exists()) {
                fos = new FileOutputStream(FicheroUsuarios);
                salida = new DataOutputStream(fos);
                System.out.println("introduca el nombre del usuario");
                String nombreUsuario = EntradaSalida.leerTexto();

                salida.writeUTF(identificadorUsuario + ";" + nombreUsuario);
                identificadorUsuario++;


                salida.close();
                fos.close();
            }

        } else {
            System.out.println("No se ha reconocido la opción introducida");
        }


    }


    //Metodo para introducir peliculas en un fichero peliculas


    //metodo para introducir videojuegos en un fichero de videojuegos

    public void leerFicheroUsuarios() throws IOException {
        //File FicheroUsuarios = new File(nombre);
        FileInputStream fis = null;
        DataInputStream entrada = null;

        if (FicheroUsuarios.exists()) {
            fis = new FileInputStream(FicheroUsuarios);
            entrada = new DataInputStream(fis);
            System.out.println(entrada.readUTF());
            entrada.close();
            fis.close();
        }
    }

    //leer fichero peliculas

    public void mostrarContenido() {
        System.out.println("1. mostrar peliculas 2. Mostrar Videojuegos");
        int opcion = EntradaSalida.leerEnteros();

        if (opcion == 1) {
            while (FicheroPeliculas.canRead()) {
                System.out.println(FicheroPeliculas);
            }
        } else if (opcion == 2) {
            System.out.println(FicheroVideojuegos.toString());
        } else {
            System.out.println("Opción no válida");
        }
        // consultas
    }

    public void consultas() {
        System.out.println("De que dese hacer las consultas. 1. Peliculas 2. Videojuegos 3. usuarios");
        int opcion = EntradaSalida.leerEnteros();
        String busqueda = "";
        switch (opcion) {
            case 1:

                while (!busqueda.equalsIgnoreCase("salir")) {
                    System.out.println("Introduzca su busqueda. Introduzca salir para volver al ménu");

                    busqueda = EntradaSalida.leerTexto();

                    if (FicheroPeliculas.toString().contains(busqueda)) {
                        //resultado busqueda
                    } else {
                        System.out.println("No se ha encontrado nada. Quizas quiera volver a introdcir otro parametro de busqueda");

                    }
                }
        }
    }


}
