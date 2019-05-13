package blockBuster;

import java.io.IOException;

public class Peliculas extends Alquiler {


    private int anio;
    private int duracion;
    private String director;
    private String paisOrigen;

    public Peliculas(int identificador, String genero, double precioAlquiler, String titulo, int anio, int duracion, String director, String paisOrigen) {
        super(identificador, genero, precioAlquiler,titulo);
        this.anio = anio;
        this.duracion = duracion;
        this.director = director;
        this. paisOrigen = paisOrigen;
    }


    @Override
    public String toString() {
        return  "Titulo: " + titulo + "\n" +
                " Identificador: " + identificador + "\n" +
                " Año: " + anio + "\n" +
                " Duracion: " + duracion + "\n" +
                " director: " + director + "\n" +
                " Pais de origen: " + paisOrigen + "\n" +
                " Genero: " + genero + "\n" +
                " Precio alquiler: "+ precioAlquiler;
    }

    //    @Override
//    public String toString(){
//        StringBuilder sb = new StringBuilder("Título: ");
//        sb.append(titulo).append("\nAño: ").append(anio).append("\nDuración: ").append(duracion).append("\nDirector ")
//                .append(director).append("\nGenero: ").append(genero).append("\nPaís de origen: ").append(paisOrigen).append("\nPrecio del alquiler por día: ").append(precioAlquiler);
//        return sb.toString();
//    }

    public static class TesterGema {
        public static void main(String[] args) {
            Gestor gestor = new Gestor();
            App app = null;
            //app = new App();
            //Primera ejecución tras cargar en RAM películas, videojuegos, usuarios, escribir los ficheros


    //        try {
    //            gestor.generarFicheroPeliculas();
    //            gestor.generarFicheroVideojuegos();
    //            gestor.generarFicheroUsuarios();
    //        } catch (IOException e) {
    //            e.printStackTrace();
    //        }


            try {
                    app = new App(gestor.leerFicheroPeliculas(), gestor.leerFicheroVideojuegos(), gestor.leerFicheroUsuarios());
                    System.out.println(app.peliculas);
                } catch (ClassNotFoundException | IOException e) {
                    e.getMessage();
                }



            boolean salir = false;

            while (!salir) {
                boolean guardado = false;
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

                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                        ficherosGuardados = true;

                        break;

                    case 7:

                        break;
                    case 99:

                            try {

                                gestor.escribirPeliculas(app);
                                //gestor.escribirVideojuegos(app);
                                //gestor.escribirUsuarios(app);
                                System.out.println("Datos copiados");

                            } catch (IOException e) {
                                e.printStackTrace();
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
}
