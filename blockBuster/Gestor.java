package blockBuster;

import java.io.*;
import java.util.ArrayList;

public class Gestor {

    public static final String ruta = "..\\BlockBuster\\src\\blockBuster\\";
    protected static final String FichUsuarios = "FicheroUsuarios.dat";
    protected static final String FichVideojuegos = "FicheroVideojuegos.dat";
    protected static final String FichPeliculas = "FicheroPeliculas.dat";

    //poner nombre de fichero como cte


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

    public void gestionAdministrador(App app) {
        if (accesoAdministrador()) {
            System.out.println("Bienvenido al sistema de administracion.\nIntroduzca la opcion deseada.");

            boolean fin = false;
            while (!fin) {
                System.out.println("1. Añadir pelicula \n2. Añadir videojuego \n3. Añadir usuario\n4. volcar datos a otro fichero\n5. Borrar colecciones\n6. Actualizar los ficheros\n7. Consultas\n8. Ranking top 10 \n9. Salir");

                int opcion = EntradaSalida.leerEnteros();
                switch (opcion) {
                    case 1:
                        app.nuevaPelicula();
                        break;
                    case 2:
                        app.nuevoVideojuego();
                        break;
                    case 3:
                        app.nuevoUsuario();
                        break;
                    case 4:
                        // volcar datos a otro fichero

                        break;
                    case 5:
                        //borrar colecciones
                        app.borrarColecciones();

                        break;
                    case 6:
                        //actualizar los ficheros

                        try {
                            escribirPeliculas(app);
                            escribirVideojuegos(app);
                            escribirUsuarios(app);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        break;
                    case 7:
                        // consultas
                        break;

                    case 8:
                        //Ranking top 10
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


//    public void cuentaCliente() throws InterruptedException, IOException {
//        System.out.println("introduzca su identificador: ");
//        String identificador = EntradaSalida.leerTexto();
//        // Comprobar identificador en el fichero. Si existe se accede a la consola de
//
//        ArrayList<String> usuarios = new ArrayList<>();
//
//        boolean salir = false;
//    }

    // generar ficheros

    public void generarFicheroUsuarios() throws IOException {
        File FicheroUsuarios = new File(ruta + FichUsuarios);
        if (!FicheroUsuarios.exists()) {
            FicheroUsuarios.createNewFile();
        }
    }

    public void generarFicheroPeliculas() throws IOException {
        File ficheroPeliculas = new File(ruta + FichPeliculas);
        if (!ficheroPeliculas.exists()) {
            ficheroPeliculas.createNewFile();
        }
    }

    public void generarFicheroVideojuegos() throws IOException {
        File ficheroVideojuegos = new File(ruta+FichVideojuegos);
        if (!ficheroVideojuegos.exists()) {
            ficheroVideojuegos.createNewFile();
        }
    }

    //introducir contenido
    @Deprecated
    public void introducirContenidoFichero(App app) throws IOException {

        File FicheroPeliculas = new File(ruta + FichUsuarios);
        File FicheroVideojuegos = new File(ruta + FichVideojuegos);
        File FicheroUsuarios = new File(ruta + FichVideojuegos);
        System.out.println("Que desea añadir: pelicula, videojuego o usuario");
        String seleccion = EntradaSalida.leerTexto();

        FileOutputStream fos = null;
        ObjectOutputStream salida = null;

        if (seleccion.equalsIgnoreCase("Pelicula")) {

            if (FicheroPeliculas.exists()) {
                fos = new FileOutputStream(FicheroPeliculas, true);
                salida = new ObjectOutputStream(fos);

                salida.writeObject(app.peliculas);

                salida.close();
                fos.close();
            }

        } else if (seleccion.equalsIgnoreCase("videojuego")) {

            if (FicheroVideojuegos.exists()) {
                fos = new FileOutputStream(FicheroVideojuegos);
                salida = new ObjectOutputStream(fos);

                salida.writeObject(app.videojuego);

                salida.close();
                fos.close();
            }

        } else if (seleccion.equalsIgnoreCase("usuario")) {

            if (FicheroUsuarios.exists()) {
                fos = new FileOutputStream(FichUsuarios, true);
                salida = new ObjectOutputStream(fos);
                System.out.println("introduca el nombre del usuario");
                String nombreUsuario = EntradaSalida.leerTexto();

                salida.writeObject(app.usuarios);

                salida.close();
                fos.close();
            }

        } else {
            System.out.println("No se ha reconocido la opción introducida");
        }

    }


    //leer fichero peliculas


    public void consultas() {
        System.out.println("De que dese hacer las consultas. 1. Peliculas 2. Videojuegos 3. usuarios");
        int opcion = EntradaSalida.leerEnteros();
        String busqueda = "";
        switch (opcion) {
            case 1:

                while (!busqueda.equalsIgnoreCase("salir")) {
                    System.out.println("Introduzca su busqueda. Introduzca salir para volver al ménu");

                    busqueda = EntradaSalida.leerTexto();

                    if (FichPeliculas.toString().contains(busqueda)) {
                        //resultado busqueda
                    } else {
                        System.out.println("No se ha encontrado nada. Quizas quiera volver a introdcir otro parametro de busqueda");

                    }
                }
        }
    }

    //lectura de ficheros
    public ArrayList<Peliculas> leerFicheroPeliculas() throws IOException, ClassNotFoundException {
        File FicheroPeliculas = new File(ruta + FichPeliculas);
        FileInputStream fis = null;
        ObjectInputStream entrada = null;
        ArrayList<Peliculas> lista = null;
        if (FicheroPeliculas.exists() && FicheroPeliculas.length() > 0) {
            fis = new FileInputStream(FicheroPeliculas);
            entrada = new ObjectInputStream(fis);
            lista = (ArrayList<Peliculas>) entrada.readObject();
            System.out.println(lista);
            entrada.close();


        }
        return lista;
    }

    public ArrayList<Videojuegos> leerFicheroVideojuegos() throws IOException, ClassNotFoundException {
        File FicheroVideojuegos = new File(ruta + FichVideojuegos);
        FileInputStream fis = null;
        ObjectInputStream entrada = null;
        ArrayList<Videojuegos> lista = null;
        try {
            if (FicheroVideojuegos.exists()) {
                fis = new FileInputStream(FicheroVideojuegos);
                entrada = new ObjectInputStream(fis);
                lista = (ArrayList<Videojuegos>) entrada.readObject();
                entrada.close();
            }
        } catch (EOFException e) {
            System.out.println("");
            // System.out.println("Fichero videojuegos cargado");
        }
        return lista;
    }

    public ArrayList<Usuarios> leerFicheroUsuarios() throws IOException, ClassNotFoundException {
        File FicheroUsuarios = new File(ruta + FichUsuarios);
        FileInputStream fis = null;
        ObjectInputStream entrada = null;
        ArrayList<Usuarios> lista = null;
        if (FicheroUsuarios.exists() && FicheroUsuarios.length()>0) {
            fis = new FileInputStream(FicheroUsuarios);
            entrada = new ObjectInputStream(fis);
            lista = (ArrayList<Usuarios>) entrada.readObject();

            entrada.close();
        }

        return lista;
    }


    //guardar contenido ficheros

    public void escribirPeliculas(App app) throws IOException {
        File FicheroPeliculas = new File(ruta + FichPeliculas);
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;

        if (FicheroPeliculas.exists()) {
            fos = new FileOutputStream(FicheroPeliculas, true);
            salida = new ObjectOutputStream(fos);

            salida.writeObject(app.peliculas);
            salida.close();
            fos.close();

        }
    }

    public void escribirVideojuegos(App app) throws IOException {
        File FicheroVideojuegos = new File(ruta + FichVideojuegos);
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;

        if (FicheroVideojuegos.exists()) {
            fos = new FileOutputStream(FichVideojuegos,true);
            salida = new ObjectOutputStream(fos);
//escribir un fichero de texto,
          /*  for (int i = 0; i < app.videojuego.size(); i++) {
                salida.writeObject(app.videojuego + System.lineSeparator());
            }
*/

            salida.writeObject(app.videojuego);
            salida.close();
            fos.close();

        }
    }

    public void escribirUsuarios(App app) throws IOException {
        File FicheroUsuarios = new File(ruta + FichUsuarios);
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;

        if (FicheroUsuarios.exists()) {
            fos = new FileOutputStream(FicheroUsuarios, true);
            salida = new ObjectOutputStream(fos);

            salida.writeObject(app.usuarios);
            salida.close();
            fos.close();

        }
    }

}
