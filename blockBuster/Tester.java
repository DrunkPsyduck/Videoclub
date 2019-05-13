package blockBuster;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.InputMismatchException;

public class Tester {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        App app = null;
        //Primera ejecución tras cargar en RAM películas, videojuegos, usuarios, escribir los ficheros

        boolean cargadoPeliculas = false;
        boolean cargadoVideojuegos = false;
        boolean cargadoUsuarios = false;


//        try {
//            gestor.generarFicheroPeliculas();
//            gestor.generarFicheroVideojuegos();
//            gestor.generarFicheroUsuarios();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        try {
            if (gestor.leerFicheroPeliculas() != null) {
                cargadoPeliculas = true;
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace().toString());
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            if (gestor.leerFicheroVideojuegos() != null)
                cargadoVideojuegos = true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            if (gestor.leerFicheroUsuarios() != null)
                cargadoUsuarios = true;
        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //Si uno esta a false no entra. Si no entrano caraga los arrays con los valores de los ficheros
        if (cargadoPeliculas && cargadoVideojuegos && cargadoUsuarios) {
            try {
                app = new App(gestor.leerFicheroPeliculas(), gestor.leerFicheroVideojuegos(), gestor.leerFicheroUsuarios());
                System.out.println(app.peliculas);
            } catch (ClassNotFoundException | IOException e) {
                e.getMessage();
            }
        } else {
            app = new App();
        }
        //Segunda ejecución: esto
        /*try {
            app = new App(gestor.leerFicheroPeliculas(), gestor.leerFicheroVideojuegos(), gestor.leerFicheroUsuarios());
        } catch (ClassNotFoundException | IOException e) {
            e.getMessage();
        }*/

        boolean salir = false;

        while (!salir) {
            boolean ficheroGuardado = false;
            System.out.println("Seleccione una opcion.\n1. Mostrar catalogo\n2. Para administradores \n3. Mostrar alquileres \n4. Dar alta usuarios\n5. Mostrar usuarios\n6. Guardar datos introducidos\n99. Salir");
            System.out.print("> ");
            int opciones = EntradaSalida.leerEnteros();
            boolean ficherosGuardados = false;
            switch (opciones) {
                case 1:
                    //
                    app.selector();

                    break;
                case 2:
                    gestor.gestionAdministrador(app);
                    break;
                case 3:

                    app.mostrarContenidoPeliculas();
                    break;
                case 4:
                    app.nuevoUsuario();
                    app.mostrarUsuarios();
                    break;

                case 5:
                    app.mostrarUsuarios();

                    break;
                case 6:
                    //copiar a fichero
                    try {

                        gestor.escribirPeliculas(app);
                        gestor.escribirVideojuegos(app);
                        gestor.escribirUsuarios(app);
                        System.out.println("Datos copiados");
                        ficheroGuardado = true;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    ficherosGuardados = true;

                    break;

                case 7:

                    break;
                case 99:

                    if (!ficheroGuardado) {
                        try {

                            gestor.escribirPeliculas(app);
                            //gestor.escribirVideojuegos(app);
                            //gestor.escribirUsuarios(app);
                            System.out.println("Datos copiados");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    salir = true;

                    System.out.println("Vuelva pronto");
                    break;
                default:
                    System.out.println("No valido");
                    break;
            }

        }
    }
}
