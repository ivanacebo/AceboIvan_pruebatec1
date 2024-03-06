package principal.empleados.persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import principal.empleados.logica.Empleado;

public class ControladoraPersistencia {

    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();

    public void crearEmpleado(Empleado empleado) {
        empleadoJpa.create(empleado);
    }

    //Traigo el empleado a eliminar, modifico el atributo borrado a verdadero y lo persisto en la base de datos.
    public void eliminarEmpleado(int id) {
        Empleado empleado = empleadoJpa.findEmpleado(id);
        if (empleado != null && !empleado.isBorrado()) {
            empleado.setBorrado(true);
            editarEmpleado(empleado);
        }
    }

    public List<Empleado> traerEmpleados() {
        return empleadoJpa.buscarEmpleadosNoBorrados();
    }

    public List<Empleado> buscarEmpleadodCargo(String cargo) {
        return empleadoJpa.findEmpleadoByCargo(cargo);
    }

    public Empleado traerEmpleado(int id) {
        Empleado empleado = empleadoJpa.findEmpleado(id);
        if (empleado != null && !empleado.isBorrado()) {
            return empleado;
        } else {
            return null;
        }
    }

    public void editarEmpleado(Empleado empleado) {
        try {
            empleadoJpa.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
