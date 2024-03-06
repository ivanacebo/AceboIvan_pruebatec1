package principal.empleados;

import static principal.empleados.logica.Pregunta.*;

public class Empleados {

    //Usa clase pregunta del package logica.
    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = leerOpcion();
            switch (opcion) {
                case 0 -> 
                    salir = true;
                case 1 ->
                    agregarEmpleado();
                case 2 ->
                    listarEmpleados();
                case 3 ->
                    actualizarEmpleado();
                case 4 ->
                    eliminarEmpleado();
                case 5 ->
                    buscarPorCargo();
                default ->
                    System.out.println("La opción seleccionada no es válida");
            }
        }
    }
}
