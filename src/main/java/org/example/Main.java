package org.example;


import org.example.dao.AutorDAO;
import org.example.dao.LibroDAO;
import org.example.dao.MiembroDAO;
import org.example.dao.PrestamoDAO;
import org.example.dao.impl.AutorDAOImpl;
import org.example.dao.impl.LibroDAOImpl;
import org.example.dao.impl.MiembroDAOImpl;
import org.example.dao.impl.PrestamoDAOImpl;
import org.example.model.Autor;
import org.example.model.Libro;
import org.example.model.Miembro;
import org.example.model.Prestamo;
import org.example.util.ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = ConexionBD.obtenerConexion()) {
            AutorDAO autorDAO = new AutorDAOImpl(connection);
            LibroDAO libroDAO = new LibroDAOImpl(connection);
            MiembroDAO miembroDAO = new MiembroDAOImpl(connection);
            PrestamoDAO prestamoDAO = new PrestamoDAOImpl(connection);

            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\nMenu:");
                System.out.println("1. Registrar Autor");
                System.out.println("2. Leer Autor");
                System.out.println("3. Actualizar Autor");
                System.out.println("4. Eliminar Autor");
                System.out.println("5. Listar Autores");
                System.out.println("6. Registrar Libro");
                System.out.println("7. Leer Libro");
                System.out.println("8. Actualizar Libro");
                System.out.println("9. Eliminar Libro");
                System.out.println("10. Listar Libros");
                System.out.println("11. Registrar Miembro");
                System.out.println("12. Leer Miembro");
                System.out.println("13. Actualizar Miembro");
                System.out.println("14. Eliminar Miembro");
                System.out.println("15. Listar Miembros");
                System.out.println("16. Registrar Prestamo");
                System.out.println("17. Leer Prestamo");
                System.out.println("18. Actualizar Prestamo");
                System.out.println("19. Eliminar Prestamo");
                System.out.println("20. Listar Prestamos");
                System.out.println("0. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1 ->  
                        System.out.print("Nombre: ");
                        String nombreAutor = scanner.nextLine();
                        System.out.print("Apellido: ");
                        String apellidoAutor = scanner.nextLine();
                        System.out.print("Nacionalidad: ");
                        String nacionalidad = scanner.nextLine();
                        Autor autor = new Autor(0, nombreAutor, apellidoAutor, nacionalidad);
                        autorDAO.crear(autor);
                        break;

                    case 2:
                        System.out.print("ID del autor: ");
                        int idAutorLeer = scanner.nextInt();
                        scanner.nextLine();
                        Autor autorLeer = autorDAO.leer(idAutorLeer);
                        System.out.println(autorLeer != null ? autorLeer : "Autor no encontrado.");
                        break;

                    case 3:
                        System.out.print("ID del autor: ");
                        int idAutorActualizar = scanner.nextInt();
                        scanner.nextLine();
                        Autor autorActualizar = autorDAO.leer(idAutorActualizar);
                        if (autorActualizar != null) {
                            System.out.print("Nuevo nombre: ");
                            autorActualizar.setNombre(scanner.nextLine());
                            System.out.print("Nuevo apellido: ");
                            autorActualizar.setApellido(scanner.nextLine());
                            System.out.print("Nueva nacionalidad: ");
                            autorActualizar.setNacionalidad(scanner.nextLine());
                            autorDAO.actualizar(autorActualizar);
                        } else {
                            System.out.println("Autor no encontrado.");
                        }
                        break;

                    case 4:
                        System.out.print("ID del autor: ");
                        int idAutorEliminar = scanner.nextInt();
                        scanner.nextLine();
                        autorDAO.eliminar(idAutorEliminar);
                        break;

                    case 5:
                        List<Autor> autores = autorDAO.listar();
                        autores.forEach(System.out::println);
                        break;

                    case 6:
                        System.out.print("Título: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Género: ");
                        String genero = scanner.nextLine();
                        System.out.print("ID del Autor: ");
                        int idAutorLibro = scanner.nextInt();
                        scanner.nextLine();
                        Libro libro = new Libro(0, titulo, genero, idAutorLibro);
                        libroDAO.crear(libro);
                        break;

                    case 7:
                        System.out.print("ID del libro: ");
                        int idLibroLeer = scanner.nextInt();
                        scanner.nextLine();
                        Libro libroLeer = libroDAO.leer(idLibroLeer);
                        System.out.println(libroLeer != null ? libroLeer : "Libro no encontrado.");
                        break;

                    case 8:
                        System.out.print("ID del libro: ");
                        int idLibroActualizar = scanner.nextInt();
                        scanner.nextLine();
                        Libro libroActualizar = libroDAO.leer(idLibroActualizar);
                        if (libroActualizar != null) {
                            System.out.print("Nuevo título: ");
                            libroActualizar.setTitulo(scanner.nextLine());
                            System.out.print("Nuevo género: ");
                            libroActualizar.setGenero(scanner.nextLine());
                            libroDAO.actualizar(libroActualizar);
                        } else {
                            System.out.println("Libro no encontrado.");
                        }
                        break;

                    case 9:
                        System.out.print("ID del libro: ");
                        int idLibroEliminar = scanner.nextInt();
                        scanner.nextLine();
                        libroDAO.eliminar(idLibroEliminar);
                        break;

                    case 10:
                        List<Libro> libros = libroDAO.listar();
                        libros.forEach(System.out::println);
                        break;

                    case 11:
                        System.out.print("Nombre: ");
                        String nombreMiembro = scanner.nextLine();
                        System.out.print("Apellido: ");
                        String apellidoMiembro = scanner.nextLine();
                        System.out.print("Fecha de inscripción (yyyy-MM-dd): ");
                        String fechaInscripcion = scanner.nextLine();
                        Miembro miembro = new Miembro(0, nombreMiembro, apellidoMiembro, LocalDate.parse(fechaInscripcion));
                        miembroDAO.crear(miembro);
                        break;

                    case 12:
                        System.out.print("ID del miembro: ");
                        int idMiembroLeer = scanner.nextInt();
                        scanner.nextLine();
                        Miembro miembroLeer = miembroDAO.leer(idMiembroLeer);
                        System.out.println(miembroLeer != null ? miembroLeer : "Miembro no encontrado.");
                        break;

                    case 13:
                        System.out.print("ID del miembro: ");
                        int idMiembroActualizar = scanner.nextInt();
                        scanner.nextLine();
                        Miembro miembroActualizar = miembroDAO.leer(idMiembroActualizar);
                        if (miembroActualizar != null) {
                            System.out.print("Nuevo nombre: ");
                            miembroActualizar.setNombre(scanner.nextLine());
                            System.out.print("Nuevo apellido: ");
                            miembroActualizar.setApellido(scanner.nextLine());
                            System.out.print("Nueva fecha de inscripción (yyyy-MM-dd): ");
                            miembroActualizar.setFechaInscripcion(LocalDate.parse(scanner.nextLine()));
                            miembroDAO.actualizar(miembroActualizar);
                        } else {
                            System.out.println("Miembro no encontrado.");
                        }
                        break;

                    case 14:
                        System.out.print("ID del miembro: ");
                        int idMiembroEliminar = scanner.nextInt();
                        scanner.nextLine();
                        miembroDAO.eliminar(idMiembroEliminar);
                        break;

                    case 15:
                        List<Miembro> miembros = miembroDAO.listar();
                        miembros.forEach(System.out::println);
                        break;

                    case 16:
                        System.out.print("ID del libro: ");
                        int libroId = scanner.nextInt();
                        System.out.print("ID del miembro: ");
                        int miembroId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Fecha de préstamo (yyyy-MM-dd): ");
                        String fechaPrestamo = scanner.nextLine();
                        System.out.print("Fecha de devolución (yyyy-MM-dd): ");
                        String fechaDevolucion = scanner.nextLine();
                        Prestamo prestamo = new Prestamo(libroId, miembroId, LocalDate.parse(fechaPrestamo), LocalDate.parse(fechaDevolucion));
                        prestamoDAO.crear(prestamo);
                        break;

                    case 17:
                        System.out.print("ID del préstamo: ");
                        int idPrestamoLeer = scanner.nextInt();
                        scanner.nextLine();
                        Prestamo prestamoLeer = prestamoDAO.leer(idPrestamoLeer);
                        System.out.println(prestamoLeer != null ? prestamoLeer : "Préstamo no encontrado.");
                        break;

                    case 18:
                        System.out.print("ID del préstamo: ");
                        int idPrestamoActualizar = scanner.nextInt();
                        scanner.nextLine();
                        Prestamo prestamoActualizar = prestamoDAO.leer(idPrestamoActualizar);
                        if (prestamoActualizar != null) {
                            System.out.print("Nueva fecha de préstamo (yyyy-MM-dd): ");
                            prestamoActualizar.setFechaPrestamo(LocalDate.parse(scanner.nextLine()));
                            System.out.print("Nueva fecha de devolución (yyyy-MM-dd): ");
                            prestamoActualizar.setFechaDevolucion(LocalDate.parse(scanner.nextLine()));
                            prestamoDAO.actualizar(prestamoActualizar);
                        } else {
                            System.out.println("Préstamo no encontrado.");
                        }
                        break;

                    case 19:
                        System.out.print("ID del préstamo: ");
                        int idPrestamoEliminar = scanner.nextInt();
                        scanner.nextLine();
                        prestamoDAO.eliminar(idPrestamoEliminar);
                        break;

                    case 20:
                        List<Prestamo> prestamos = prestamoDAO.listar();
                        prestamos.forEach(System.out::println);
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
