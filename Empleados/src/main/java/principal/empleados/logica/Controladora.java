package principal.empleados.logica;

import java.util.List;
import principal.empleados.persistencia.ControladoraPersistencia;

public class Controladora {

    ControladoraPersistencia control = new ControladoraPersistencia();

    public List<Empleado> traerEmpleados() {
        return control.traerEmpleados();
    }

    public void crearEmpleado(Empleado empleado) {
        control.crearEmpleado(empleado);
    }

    public void eliminarEmpleado(int id) {
        control.eliminarEmpleado(id);
    }

    public Empleado traerEmpleado(int id) {
        return control.traerEmpleado(id);
    }

    public void editarEmpleado(Empleado empleado) {
        control.editarEmpleado(empleado);
    }

    public List<Empleado> buscarEmpleadosCargo(String cargo) {
        return control.buscarEmpleadodCargo(cargo);
    }
}
