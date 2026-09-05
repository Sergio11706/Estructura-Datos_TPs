package TP2.Ejercicio5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anioPublicacion;

    public Libro(String isbn, String titulo, String autor, int anioPublicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + " | Título: " + titulo + " | Autor: " + autor + " | Año: " + anioPublicacion;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Libro> biblioteca = new ArrayList<>();
        
        boolean salir = false;
        
        System.out.println("=== MI BIBLIOTECA PERSONAL ===");

        while (!salir) {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Agregar un nuevo libro");
            System.out.println("2. Buscar un libro por Título o ISBN");
            System.out.println("3. Modificar Autor o Año de un libro (por ISBN)");
            System.out.println("4. Eliminar un libro (por ISBN)");
            System.out.println("5. Mostrar todos los libros");
            System.out.println("6. Salir");
            
            int opcion = leerEntero(scanner, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    agregarLibro(scanner, biblioteca);
                    break;
                case 2:
                    buscarLibro(scanner, biblioteca);
                    break;
                case 3:
                    modificarLibro(scanner, biblioteca);
                    break;
                case 4:
                    eliminarLibro(scanner, biblioteca);
                    break;
                case 5:
                    mostrarTodos(biblioteca);
                    break;
                case 6:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    private static void agregarLibro(Scanner scanner, ArrayList<Libro> biblioteca) {
        System.out.println("\n--- AGREGAR LIBRO ---");
        String isbn = leerString(scanner, "Ingrese el ISBN: ");
        
        if (buscarPorIsbn(biblioteca, isbn) != null) {
            System.out.println("Error: Ya existe un libro registrado con el ISBN " + isbn);
            return;
        }

        String titulo = leerString(scanner, "Ingrese el título: ");
        String autor = leerString(scanner, "Ingrese el autor: ");
        int anio = leerEntero(scanner, "Ingrese el año de publicación: ");

        biblioteca.add(new Libro(isbn, titulo, autor, anio));
        System.out.println("¡Libro agregado con éxito!");
    }

    private static void buscarLibro(Scanner scanner, ArrayList<Libro> biblioteca) {
        if (biblioteca.isEmpty()) {
            System.out.println("La biblioteca está vacía.");
            return;
        }

        String termino = leerString(scanner, "\nIngrese el Título o el ISBN a buscar: ");
        boolean encontrado = false;

        for (Libro libro : biblioteca) {
            if (libro.getIsbn().equalsIgnoreCase(termino) || libro.getTitulo().toLowerCase().contains(termino.toLowerCase())) {
                System.out.println("Libro encontrado:");
                System.out.println(libro.toString());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún libro con ese Título o ISBN.");
        }
    }

    private static void modificarLibro(Scanner scanner, ArrayList<Libro> biblioteca) {
        if (biblioteca.isEmpty()) {
            System.out.println("La biblioteca está vacía.");
            return;
        }

        String isbn = leerString(scanner, "\nIngrese el ISBN del libro que desea modificar: ");
        Libro libro = buscarPorIsbn(biblioteca, isbn);

        if (libro == null) {
            System.out.println("Error: No se encontró ningún libro con el ISBN " + isbn);
            return;
        }

        System.out.println("Libro actual: " + libro.toString());
        System.out.println("¿Qué desea modificar?");
        System.out.println("1. Autor");
        System.out.println("2. Año de publicación");
        
        int opcion = leerEntero(scanner, "Opción: ");
        
        if (opcion == 1) {
            String nuevoAutor = leerString(scanner, "Ingrese el nuevo autor: ");
            libro.setAutor(nuevoAutor);
            System.out.println("¡Autor actualizado con éxito!");
        } else if (opcion == 2) {
            int nuevoAnio = leerEntero(scanner, "Ingrese el nuevo año de publicación: ");
            libro.setAnioPublicacion(nuevoAnio);
            System.out.println("¡Año actualizado con éxito!");
        } else {
            System.out.println("Opción incorrecta, volviendo al menú.");
        }
    }

    private static void eliminarLibro(Scanner scanner, ArrayList<Libro> biblioteca) {
        if (biblioteca.isEmpty()) {
            System.out.println("La biblioteca está vacía.");
            return;
        }

        String isbn = leerString(scanner, "\nIngrese el ISBN del libro que desea eliminar: ");
        Libro libroAEliminar = buscarPorIsbn(biblioteca, isbn);

        if (libroAEliminar != null) {
            biblioteca.remove(libroAEliminar);
            System.out.println("El libro ha sido eliminado de la biblioteca con éxito.");
        } else {
            System.out.println("Error: No se encontró ningún libro con el ISBN " + isbn + " para eliminar.");
        }
    }

    private static void mostrarTodos(ArrayList<Libro> biblioteca) {
        if (biblioteca.isEmpty()) {
            System.out.println("\nLa biblioteca está vacía.");
            return;
        }
        System.out.println("\n--- LISTA DE LIBROS ---");
        for (Libro libro : biblioteca) {
            System.out.println(libro.toString());
        }
    }

    private static Libro buscarPorIsbn(ArrayList<Libro> biblioteca, String isbn) {
        for (Libro libro : biblioteca) {
            if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                return libro;
            }
        }
        return null;
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            try {
                numero = scanner.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor ingrese un valor numérico entero válido.");
                scanner.next();
            }
        }
        scanner.nextLine();
        return numero;
    }

    private static String leerString(Scanner scanner, String mensaje) {
        String texto = "";
        while (texto.trim().isEmpty()) {
            System.out.print(mensaje);
            texto = scanner.nextLine();
            if (texto.trim().isEmpty()) {
                System.out.println("Error: El campo no puede estar vacío.");
            }
        }
        return texto;
    }
}