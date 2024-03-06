#Sistema de Gestión de Empleados

## Descripción del proyecto

Este proyecto consiste en un sistema de gestión de empleados desarrollado en Java. 
Permite realizar operaciones básicas como agregar, listar, actualizar y eliminar empleados, así como también buscar empleados por su cargo.

## Modelo de capas

**Interfaz gráfica (igu):** No se utiliza para este caso; en su lugar, se emplea la introducción de datos por parte del usuario en la consola. En este caso, se utiliza la metodología ASCII.
**Persistencia de datos:** Se emplea una base de datos llamada "empleados", a la cual se conecta mediante JPA.
**Lógica:** Capa donde se introduce la lógica del código. Incluye la clase Empleado, la clase controladora y los distintos métodos que se utilizarán para desarrollar el sistema.

##Explicación del proyecto por modelo de capas
## Explicación del proyecto por modelo de capas

**Persistencia ->** 
   * En este paquete se encuentra la clase EmpleadoJpaController, la cual establece la conexión con la base de datos y permite, mediante distintos métodos, extraer, introducir, eliminar o modificar datos. Aquí se añaden consultas personalizadas, como por ejemplo, traer solo los empleados que no estén borrados y que tengan un determinado cargo.
   * También se encuentra la clase ControladoraPersistencia, donde se trabajan los métodos para unir la clase anterior de persistencia a la base de datos con la lógica del sistema. Aquí se crean los distintos métodos para eliminar, crear, modificar o buscar empleados.

**Lógica ->**
   * La clase Empleado es la base para la persistencia de datos en la base de datos. Contiene atributos, constructores, getters, setters y métodos necesarios para el funcionamiento del sistema, como la sobreescritura del método `toString()` para mostrar los datos del objeto.
   * La clase Controladora actúa como nexo entre la capa de persistencia y la capa de la interfaz gráfica. Aquí se hacen llamadas a la controladora de persistencia y se utilizan los métodos previamente creados. Además, se definen otros métodos necesarios para el sistema.
   * Se añade una clase Pregunta en este paquete de lógica, donde se encuentran los métodos utilizados en la interfaz ASCII generada. Incluye funciones para mostrar menús, leer la entrada del usuario y realizar ciertas validaciones.

**Interfaz gráfica ->** 
	Recordemos que no usamos una interfaz gráfica como tal sino que introducimos un metodo ascii para que el usuario vaya interactuan y poder seguir la serie de pasos que este desee en este sistema.
	En mi caso incorporo un bucle con bandera y un swicht en el que llamo a los metodos de la clase explicada anteriormente (Pregunta)

##Explicación breve de la logica

	**Métodos:**
   		* `mostrarMenu`: Genera el menú que utilizará el usuario para interactuar.
   		* `leerOpcion`: Lee la opción ingresada por el usuario y valida la entrada.
   		* `agregarEmpleado`: Solicita al usuario los datos necesarios para agregar un empleado y los guarda en la base de datos.
   		* `leerTextoNoVacio` y `esTextoValido`: Validan los datos introducidos por el usuario para campos como nombre, apellido y cargo.
   		* `leerSalarioValido`: Verifica que el salario ingresado por el usuario sea válido.
   		* `leerFechaValida`: Comprueba que la fecha ingresada por el usuario tenga un formato correcto.
   		* `listarEmpleados`: Trae la lista completa de empleados de la empresa.
   		* `actualizarEmpleado`: Permite la modificación de un empleado existente.
   		* `eliminarEmpleado`: Elimina un empleado de la base de datos. Borrado logico modificando un atributo.
   		* `buscarPorCargo`: Busca empleados por cargo.
		
##Supuestos técnicos

	1. Se incorporan varias queries para traer datos de empleados según su cargo.
	2. Se implementa el borrado lógico con un campo booleano en la clase Empleado.
	3. Se asegura que los campos obligatorios nunca estén vacíos.
	4. Se realizan comprobaciones para garantizar que los valores introducidos por el usuario sean adecuados.
	5. Se implementa la estructura para el borrado lógico de empleados.
	6. Se utiliza el principio de responsabilidad única en la creación de métodos.
	7. Se manejan excepciones, como ParseException, en el método `leerFechaValida`.
	8. Se repiten condiciones en algunos métodos para evitar errores.

## Distintos escenarios considerados

	1. **Eliminación de empleados por ID conocido:**  
	En el caso más común, el usuario conoce el ID del empleado que desea eliminar. Se proporciona al usuario la información del ID al listar todos los empleados en pantalla.

	2. **Inmutabilidad del ID en la base de datos:**  
	Se garantiza al usuario que el ID de un empleado no puede ser modificado, ya que sirve como identificador único en la base de datos.

	3. **Prevención de duplicación de datos:**  
	Se considera que el usuario debe evitar la duplicación de datos. En caso de confusión, se le ofrece la opción de eliminar empleados duplicados. Además, se proporciona la capacidad de listar empleados para verificar su existencia.

	4. **Gestión de empleados dados de baja:**  
	Se contempla la posibilidad de que la empresa desee mantener un registro de empleados que ya no están activos. Se puede implementar una función para listar los empleados borrados de la base de datos, aprovechando el borrado lógico ya implementado.

	5. **Manejo de excepciones:**  
	Se utilizan bucles y comprobaciones para resolver problemas comunes, como la selección incorrecta de opciones en el menú. (Se incorpora una única excepción del sistema ParseException).

	### Solución para evitar la duplicidad de datos

	Para prevenir la duplicación de datos, se propone agregar un nuevo atributo llamado "dni" a la clase Empleado. Se implementarán los métodos necesarios para validar y comparar el nuevo DNI con los existentes en la base de datos. En caso de encontrar una coincidencia, se informará al usuario y se mostrarán los datos del empleado asociado al DNI duplicado.


##Requisitos del sistema

	- Java Development Kit (JDK) instalado en el sistema.
	- Acceso a una base de datos relacional compatible (por ejemplo, MySQL, PostgreSQL, phpMyAdmin). Se añade archivo.sql con los datos de prueba del sistema de gestión de empleados.
	- Instalación y configuración
	- Clonar el repositorio desde GitHub.
	- Configurar la conexión a la base de datos en el archivo de configuración correspondiente.
	- Configuración del proyecto y ejecución desde un IDE de desarrollo.

## Contribuciones

Las contribuciones al proyecto son bienvenidas. Se agradece cualquier corrección o sugerencia para mejorar el sistema.