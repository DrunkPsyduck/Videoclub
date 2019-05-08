package blockBuster;

import java.io.IOException;

public class Tester {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();


        System.out.println("BlockBuster");

        try {
            gestor.leerFicheroUsuarios();
        } catch (IOException ex){
            ex.getMessage();
        }
        boolean salir = false;

        while (!salir) {
            System.out.println("Seleccione una opcion.\n1. Mostrar catalogo\n2. Para administradores \n3. Mostrar alquileres \n4. Dars alta usuarios\n5. consultas\n8. Salir");
            int opciones = EntradaSalida.leerEnteros();
            switch (opciones) {
                case 1:
                    //
                    gestor.mostrarContenido();
                    break;
                case 2:


                    break;
                case 3:


                    break;
                case 4:

                    break;
                //dar alta nuevo jugador
                case 5:
                    gestor.consultas();
                    break;

                case 8:
                    salir = true;
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("No valido");
                    break;
            }
        }
    }
}


