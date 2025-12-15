## Detalle de los form y cómo se conectan
* Primero lo que hice fue estructurar mis carpetas para intentar seguir una lógica de capas
Los form en la UI solo llaman a un metodo el cual es la lógica
![img_1.png](img_1.png)
* Validaciones
La logica es la que se encarga de las validaciones, por ejemplo comprobar si hay campos vacios o que las contraseñas coincidad con 
las registradas en la Base de datos
![img_2.png](img_2.png)
* Tambien hice el modelo, la cual es la entidad del mundo real 
En esta parte declaro u objeto el cual me ayudara a ser el que tenga temporalmente los datos rescatados de la base de datos
![img_3.png](img_3.png)
* La capa de Datos
Es la que me ayuda tanto a hacer los Select, abrir la conexion y a que sus metodos puedan ser utilizados por la Logica
![img_4.png](img_4.png)
![img_5.png](img_5.png)
* El Main
Solo se hace el llamado a la pantalla del login
![img_6.png](img_6.png)
* Base de datos
En la Base de datos puse el Usuario y la contraseña quemada
![img_9.png](img_9.png)
### EXTRAS DE MI PARTE
* Agregue un boton para que se puedan registrar cuentas 
Al darle click te salta el formulario y si todo va bien te registra en la base de datos
![img_7.png](img_7.png)
![img_8.png](img_8.png)




