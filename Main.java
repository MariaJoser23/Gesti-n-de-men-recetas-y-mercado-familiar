import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuRecetasDeMercado sistema = new MenuRecetasDeMercado();

        System.out.println("Ingrese el nombre del usuario:");
        String nombreUsuario = scanner.nextLine();
        Usuario usuario = new Usuario(nombreUsuario);

        MenuDiario menuHoy = new MenuDiario(new Date());

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Ingrese los ingredientes disponibles");
            System.out.println("2. Ingrese los ingredientes que necesita comprar");
            System.out.println("3. Crear una receta");
            System.out.println("4. Marcar la receta como favorita");
            System.out.println("5. Mostrar recetas favoritas");
            System.out.println("6. Crear menú diario");
            System.out.println("7. Mostrar menú diario");
            System.out.println("8. Generar lista de compras");
            System.out.println("9. Marcar ingrediente como comprado");
            System.out.println("10. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del ingrediente disponible:");
                    String nombreIngrediente = scanner.nextLine();
                    System.out.println("Ingrese la cantidad del ingrediente disponible:");
                    double cantidadIngrediente = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Ingrese la unidad de medida:");
                    String unidadMedida = scanner.nextLine(); // Permitir que el usuario ingrese la unidad
                    Ingrediente ingrediente = new Ingrediente(nombreIngrediente, cantidadIngrediente, unidadMedida);
                    sistema.agregarIngredienteMercado(ingrediente);
                    break;

                case 2:
                    System.out.println("Ingrese el nombre del ingrediente que necesita comprar:");
                    String nombreIngredienteCompra = scanner.nextLine();
                    System.out.println("Ingrese la cantidad del ingrediente que necesita comprar:");
                    double cantidadCompra = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Ingrese la unidad de medida:");
                    String unidadCompra = scanner.nextLine(); // Permitir que el usuario ingrese la unidad
                    break;

                case 3:
                    System.out.println("Ingrese el nombre de la receta:");
                    String nombreReceta = scanner.nextLine();
                    System.out.println("Ingrese las instrucciones para la receta:");
                    String instruccionesReceta = scanner.nextLine();
                    Receta receta = new Receta(nombreReceta, instruccionesReceta);

                    while (true) {
                        System.out.println("¿Desea agregar un ingrediente a la receta? (si o no)");
                        String respuesta = scanner.nextLine();
                        if (respuesta.equalsIgnoreCase("no")) {
                            break;
                        }

                        System.out.println("Ingrese el nombre del ingrediente para la receta:");
                        nombreIngrediente = scanner.nextLine();
                        System.out.println("Ingrese la cantidad del ingrediente:");
                        cantidadIngrediente = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Ingrese la unidad de medida:");
                        unidadMedida = scanner.nextLine(); // Permitir que el usuario ingrese la unidad
                        ingrediente = new Ingrediente(nombreIngrediente, cantidadIngrediente, unidadMedida);
                        receta.agregarIngrediente(ingrediente);
                    }

                    sistema.agregarReceta(receta);
                    System.out.println("La Receta fue creada exitosamente.");
                    break;

                case 4:
                    System.out.println("Ingrese el nombre de la receta que desea marcar como favorita:");
                    String nombreRecetaFavorita = scanner.nextLine();
                    Receta recetaFavorita = buscarReceta(sistema, nombreRecetaFavorita);
                    if (recetaFavorita != null) {
                        usuario.marcarRecetaFavorita(recetaFavorita);
                        System.out.println("La Receta fue marcada como favorita.");
                    } else {
                        System.out.println("La Receta no fue encontrada.");
                    }
                    break;

                case 5:
                    System.out.println(usuario.mostrarRecetasFavoritas());
                    break;

                case 6:
                    while (true) {
                        System.out.println("¿Desea agregar una receta al menú diario? (si o no)");
                        String respuesta = scanner.nextLine();
                        if (respuesta.equalsIgnoreCase("no")) {
                            break;
                        }

                        System.out.println("Ingrese el nombre de la receta:");
                        String nombreRecetaParaMenu = scanner.nextLine();
                        Receta recetaParaMenu = buscarReceta(sistema, nombreRecetaParaMenu);
                        if (recetaParaMenu != null) {
                            menuHoy.agregarReceta(recetaParaMenu);
                            System.out.println("La Receta fue agregada al menú diario.");
                        } else {
                            System.out.println("La Receta no fue encontrada.");
                        }
                    }
                    break;

                case 7:
                    System.out.println(menuHoy.mostrarMenu());
                    break;

                case 8:
                    sistema.generarListaCompras();
                    break;

                case 9:
                    System.out.println("Ingrese el nombre del ingrediente que desea marcar como comprado:");
                    String nombreComprado = scanner.nextLine();
                    System.out.println("El ingrediente ha sido marcado como comprado.");
                    break;

                case 10:
                    System.out.println("Cerró sesión, exitosamente.");
                    scanner.close();
                    return;

                default:
                    System.out.println("La Opción no es válida.");
                    break;
            }
        }
    }

    private static Receta buscarReceta(MenuRecetasDeMercado sistema, String nombreReceta) {
        for (Receta receta : sistema.getRecetas()) {
            if (receta.getNombre().equalsIgnoreCase(nombreReceta)) {
                return receta;
            }
        }
        return null;
    }
}




