package blockBuster;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.InputMismatchException;

public class Tester {
    public static void main(String[] args) throws IOException {
        Gestor gestor = new Gestor();
        App app = null;
        //Primera ejecución tras cargar en RAM películas, videojuegos, usuarios, escribir los ficheros


        boolean cargadoPeliculas = false;
        boolean cargadoVideojuegos = false;
        boolean cargadoUsuarios = false;


        try {
            if (gestor.leerFicheroUsuarios() == null) {
                gestor.generarFicheroUsuarios();
            } else {
                cargadoUsuarios = true;
            }
            if (gestor.leerFicheroPeliculas() == null) {
                gestor.generarFicheroPeliculas();
            } else {
                cargadoPeliculas = true;
            }
            if (gestor.leerFicheroVideojuegos() == null) {
                gestor.generarFicheroVideojuegos();
            } else {
                cargadoVideojuegos = true;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        //Si uno esta a false no entra. Si no entrano caraga los arrays con los valores de los ficheros
        if (cargadoPeliculas && cargadoVideojuegos && cargadoUsuarios) {
            try {
                app = new App(gestor.leerFicheroPeliculas(), gestor.leerFicheroVideojuegos(), gestor.leerFicheroUsuarios());

            } catch (ClassNotFoundException | IOException e) {
                e.getMessage();
            }
        } else {
            app = new App();
        }

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
                        gestor.guardarFicheros(app);
                        ficheroGuardado = true;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 7:

                    break;
                case 99:

                    if (!ficheroGuardado) {
                        try {
                            gestor.guardarFicheros(app);
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
