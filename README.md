# CrudEmployeed
Este es un programa de tipo Spring tools, donde se pueden dar de alta empleados y asignar su genero, 
trabajo o puesto con ciertas validaciones para que este pueda darse de alta y cuenta con otras todas 
las operaciones CRUD.


![image](https://github.com/ReyesGa/CrudEmployeed/assets/100898695/9af1ad11-e869-4ee7-af87-603dc21c1e71)

Validaciones:

Para que se pueda registrar un empleado debe cumplir lo siguiente:
    * El nombre y apellido del empleado no existan registrados en base de datos.
    * Ser mayor de edad.
    * El sexo asignado debe existir en la tabla de Genders.
    * El puesto asignado debe existir en la tabla de Jobs.
Para que se puedan registrar las horas trabajadas debe cumplir lo siguiente:
    * El empleado debe estar registrado en la tabla de Employees
