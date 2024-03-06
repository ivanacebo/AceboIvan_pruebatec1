package principal.empleados.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Pregunta {

    public static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    public static Controladora control = new Controladora();

    /**
     * Introduce el menu principal de la consola cada vez que lo necesite
     */
    public static void mostrarMenu() {
        System.out.println("\n--- SISTEMA DE GESTIÓN DE EMPLEADOS ---");
        System.out.println("0. Salir");
        System.out.println("1. Agregar empleado");
        System.out.println("2. Listar empleados");
        System.out.println("3. Actualizar información de empleado");
        System.out.println("4. Eliminar empleado");
        System.out.println("5. Buscar empleados por cargo");
    }

    /**
     * Leo la opción seleccionada por el usuario del menú, la interpreto y solo
     * hago que sea valido la selección de un número entre 0 y 5. De seleccionar
     * un valor distinto entre estos dos o una letra hago que se repita la
     * pregunta.
     *
     * @return número válido entre 0 y 5
     */
    public static int leerOpcion() {
        int opcion = -1;
        while (opcion < 0 || opcion > 5) {
            String input = scanner.nextLine();
            if (input.matches("\\d+")) {
                opcion = Integer.parseInt(input);
                if (opcion < 0 || opcion > 5) {
                    System.out.println("Toma otra decisión válida. Número entre 0 y 5");
                }
            } else {
                System.out.println("Esto no fue un número ,por favor, ingresa un número válido.");
            }
        }
        return opcion;
    }

    /**
     * Metodo con el que hago que el usuario complete la información necesaria
     * para crear un nuevo Empleado en la base de datos. Uso también otro
     * metodos explicados a continuación.
     */
    public static void agregarEmpleado() {
        System.out.println("Vamos a proceder a agregar un nuevo empleado:");
        String nombre = leerTextoNoVacio("Nombre: ");
        String apellido = leerTextoNoVacio("Apellido: ");
        String cargo = leerTextoNoVacio("Cargo: ");
        double salario = leerSalarioValido("Salario: ");
        Date fechaInicio = leerFechaValida("Fecha de inicio (formato: dd/MM/yyyy): ");
        Empleado empleado = new Empleado(nombre, apellido, cargo, salario, fechaInicio);
        control.crearEmpleado(empleado);
        System.out.println("Empleado creado exitosamente.");
    }

    /**
     * Metodo con el que leo que los campos no esten vacios como nombre
     * apellidos y cargo. Si el usuario no rellena los campos hago que vuelva
     * apedir que los rellene con los datos adecuados
     *
     * @param mensaje lo que escribe el usuario
     * @return texto escrito por el usuario
     */
    public static String leerTextoNoVacio(String mensaje) {
        String texto = "";
        while (texto.trim().isEmpty() || !esTextoValido(texto)) {
            System.out.print(mensaje);
            texto = scanner.nextLine();
            if (texto.trim().isEmpty()) {
                System.out.println("El campo no puede estar vacío.");
            } else if (!esTextoValido(texto)) {
                System.out.println("El campo debe contener solo letras y tener una longitud mayor que 1.");
            }
        }
        return texto;
    }

    /**
     * Funcion que comprueba que el texto solo lleve letras y
     * tenga una longitud mayor que 1
     *
     * @param texto escrito por el usuario
     * @return texto comprobado
     */
    public static boolean esTextoValido(String texto) {
        return texto.matches("\\p{L}+") && texto.length() > 1;
    }

    /**
     * Función con la que compruebo que el salario no sea negativo ya que nadie
     * paga a la empresa. Compruebo que no se escriban letras ya que el salario
     * es un numero.
     *
     * @param mensaje lo que escribe el usuario
     * @return salario del empleado
     */
    public static double leerSalarioValido(String mensaje) {
        double salario = 0;
        while (salario <= 0) {
            System.out.print(mensaje);
            if (scanner.hasNextDouble()) {
                salario = scanner.nextDouble();
                if (salario <= 0) {
                    System.out.println("El salario debe ser un número positivo.");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido para el salario.");
                scanner.next(); // Limpiar el búfer
            }
        }
        scanner.nextLine(); // Limpiar el búfer
        return salario;
    }

    /**
     * Leo que la fecha tenga un formato requerido. día/Mes/año. No permito
     * fechas que no cumplan por ejemplo 13 no es un mes valido o 32 un dia
     * valido.
     *
     * @param mensaje Fecha escrita por el usuario
     * @return fecha que necesito bien formada
     */
    public static Date leerFechaValida(String mensaje) {
        Date fecha = null;
        boolean fechaValida = false;
        while (!fechaValida) {
            System.out.print(mensaje);
            String fechaStr = scanner.nextLine();
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false); // No permitir fechas inválidas (por ejemplo, 32/13/2022)
                fecha = dateFormat.parse(fechaStr);
                fechaValida = true;
            } catch (ParseException e) {
                System.out.println("Formato de fecha inválido. Por favor, inténtelo de nuevo.");
            }
        }
        return fecha;
    }

    /**
     * Función encargada de traer a todos los usuarios de la base de datos en
     * una colecion y pintarla
     */
    public static void listarEmpleados() {
        List<Empleado> empleados = control.traerEmpleados();
        System.out.println("--- Lista de empleados ---");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }

    /**
     * Función con la cual actualizo a un empleado por el ID que me pasa el
     * usuario. Aquí si encuentro el ID vuelvo a comprobar con las anteriores
     * funciones que los datos estén bien formados y no vacíos para modificar
     * justamente el dato específico que el usuario quiere de su empleado.
     */
    public static void actualizarEmpleado() {
        System.out.print("Ingrese el ID del empleado que desea actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiamos buffer
        Empleado empleado = control.traerEmpleado(id);
        if (empleado != null) {
            System.out.println("Empleado encontrado: " + empleado);
            System.out.println("¿Qué dato desea modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido");
            System.out.println("3. Cargo");
            System.out.println("4. Salario");
            System.out.println("5. Fecha de inicio");

            int opcion = leerOpcion(); // Utilizamos la función leerOpcion() para validar la entrada del usuario

            switch (opcion) {
                case 1:
                    empleado.setNombre(leerTextoNoVacio("Nuevo nombre: "));
                    System.out.println("Nombre actualizado exitosamente.");
                    break;
                case 2:
                    empleado.setApellido(leerTextoNoVacio("Nuevo apellido: "));
                    System.out.println("Apellido actualizado exitosamente.");
                    break;
                case 3:
                    empleado.setCargo(leerTextoNoVacio("Nuevo cargo: "));
                    System.out.println("Cargo actualizado exitosamente.");
                    break;
                case 4:
                    empleado.setSalario(leerSalarioValido("Nuevo salario: "));
                    System.out.println("Salario actualizado exitosamente.");
                    break;
                case 5:
                    empleado.setFechaInicio(leerFechaValida("Nueva fecha de inicio (formato: dd/MM/yyyy): "));
                    System.out.println("Fecha de inicio actualizada exitosamente.");
                    break;
                default:
                    System.out.println("Opción no válida");
                    return;
            }
            control.editarEmpleado(empleado);
        } else {
            System.out.println("No se encontró ningún empleado con el ID especificado.");
        }
    }

    /**
     * Función con el que elimino un empleado según su ID. Restricción: El
     * usuario tiene que saber el ID del empleado. Si usa la opcion de Listar
     * Empleados puede saberla.
     */
    public static void eliminarEmpleado() {
        System.out.print("Ingrese el ID del empleado que desea eliminar: ");
        if (scanner.hasNextInt()) {
            int id = scanner.nextInt();
            scanner.nextLine(); // Limpiamos buffer
            Empleado empleado = control.traerEmpleado(id);
            if (empleado != null) {
                control.eliminarEmpleado(id);
                System.out.println("Empleado eliminado exitosamente.");
            } else {
                System.out.println("No se encontró ningún empleado con el ID especificado.");
            }
        } else {
            System.out.println("Por favor, ingrese un número válido para el ID del empleado.");
            scanner.nextLine(); // Limpiar el búfer
        }
    }

    /**
     * Función con la que filtramos por el cargo de los empleados Tendremos una
     * colección con la que pintaremos los usuarios que tenemos con ese
     * determinado cargo
     */
    public static void buscarPorCargo() {
        System.out.print("Ingrese el cargo que desea buscar: ");
        String cargo = scanner.nextLine();
        List<Empleado> empleados = control.buscarEmpleadosCargo(cargo);
        if (!empleados.isEmpty()) {
            System.out.println("--- Empleados con el cargo '" + cargo + "' ---");
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
            }
        } else {
            System.out.println("No se encontraron empleados con el cargo '" + cargo + "'.");
        }
    }
}
