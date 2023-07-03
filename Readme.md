# Manager Societies V3.5.0
## Tabla de Contenido:
- [Inicio](#inicio)
- [Control de Versiones](#control-de-versiones)
    + [V0.0.0](#V000)
    + [V0.1.3](#V013)
    + [V1.0.0](#V100)
    + [V1.0.1](#V101)
    + [V2.0.0](#V200)
    + [V2.1.0](#V210)
    + [V2.2.0](#V220)
    + [V2.3.0](#V230)
    + [V2.3.1](#V231)
    + [V2.4.0](#V240)
    + [V2.5.0](#V250)
    + [V2.6.0](#V260)
    + [V2.7.0](#V270)
    + [V2.8.0](#V280)
    + [V2.9.0](#V290)
    + [V2.10.0](#V2100)
    + [V3.0.0](#V300)
    + [V3.1.0](#V310)
    + [V3.2.0](#V320)
    + [V3.3.0](#V330)
    + [V3.4.0](#V340)
    + [V3.5.0](#V350)
- [Herramientas](#herramientas-utilizadas)
- [Autores](#autores)

El objetivo del proyecto es el diseño y desarrollo de una WEB APP que ofrezca un ERP completo para autónomos y PYMES.

## Inicio:
Si deseas conseguir una copia del proyecto para su desarrollo y testeo puedes descargarlo en: https://github.com/JaviBarrio6/ManagerSocieties

## Control de Versiones:
El control de versiones que se va a utilizar a lo largo de todo el proyecto se basa en el uso de tres números separados por tres puntos, 
para su correcto entendimiento los representaremos mediante las letras X-Y-Z.

Por lo que nuestra versión tendrá la forma X.Y.Z, siendo cada letra un valor numérico con un significado, el valor X hace referencia a 
versiones principales de software, en nuestro caso, tendremos una por cada sprint englobando todas las funcionalidades diseñadas y 
desarrolladas.

El valor Y representará versiones menores, una para cada funcionalidad añadida, mientras que el valor Z se reserva a la corrección de errores 
o revisión del código.

### V0.0.0

* Elaboración de la Memoria hasta finalizar el estudio de mercado, y el funcionamiento del control de versiones.

### V0.1.3

* La versión V0.1.0 surge para la elaboración de este documento README.

* Las tres versiones del valor Z se utilizaron para resolver distintos errores encontrados en el README.

### V1.0.0

* La versión V1.0.0 agrupa el Sprint 1, centrado en el desarrollo de la memoria al margen de la elaboración de código.

### V1.0.1

* Revisión de la memoria sobre el Sprint 1 para añadir mejoras y resolver ciertos errores de redacción.

### V2.0.0

* Con el fin del segundo Sprint se añade la maquetación HTML y CSS casi completa, abierta a mejoras o ciertos cambios, pero plantean la base
para poder desarrollar la parte backend de la aplicación. Se añaden los diecisiete primeros templates de la aplicación.

### V2.1.0

* Se genera el código Java utilizando Maven y Spring Boot para generar la parte Backend de la aplicación, se adaptan los archivos HTML, CSS y
Javascript para mantener su correcto funcionamiento.


* Se desarrolla la aplicación y el primer controlador que permite navegar por las distintas secciones de la aplicación.


* Los controladores desarrollados son ApplicationController y CustomErrorController que permiten gestionar los errores y la visualización de los templates.

### V2.2.0

* Se genera el código Java que permite la funcionalidad de crear clientes, modificarlos y borrarlos dentro de la Agenda, la funcionalidad de las
facturas de los clientes quedan limitadas hasta la creación del apartado de facturación.


* Para ello se crea la clase Persona y la Clase Cliente que hereda de la anterior. Además, generamos la clase Clientes donde se ubican los por defecto.

### V2.3.0

* Se genera el código Java que permite la funcionalidad de toda la agenda, además, se realiza un refactor para mejorar el código realizado en la
versión anterior. Y utilizada para el resto de la agenda, Clientes, Empleados, Empresas y Proveedores.


* Creamos las clases Empleado, Empresa, Proveedor heredando de Persona, así como las clases plurales donde se registran los datos.

### V2.3.1

* Revisión del documento README para la corrección de errores.

### V2.4.0

* Se ha realizado un refactor de nuestro controlador principal, para ello, hemos creado un controlador específico para 
la agenda, de esta forma, nuestro controlador posee una mayor encapsulación y limpieza del código.

### V2.5.0

* Generamos la lógica para el inventario, creando la clase Objeto de la que herederán el resto. Nos encontramos con las clases Herramienta, Máquina, Material, Producto y Vehículo.
Así como sus plurales de igual manera que en la agenda. Además, se genera el controlador InventarioController y se enlaza con el controlador de la aplicación.

### V2.6.0

* Se genera el código Java y la lógica que permite la funcionalidad de los productos del inventario que no se implementó en la versión anterior.

### V2.7.0

* De igual manera que en las versiones anteriores se hace lo correspondiente para la sección de Tareas.

### V2.8.0

* Se genera la clase Usuario, Usuarios y Empresa. Que nos permite el Login en la aplicación a través del UsuarioController, así como cambiar la información de cada usuario y la edición y visualización de la información de la empresa para los administradores.


* Además, se regula los campos visualizados por los administradores y por los empleados sin poderes de admin. Adicionalmente, se plantea un refactor para la plantilla del Index en el que se haga distinción para perfiles administradores y para los que no.

### V2.9.0

* Se ha eliminado el calendario diseñado anteriormente mediante JavaScript, para diseñar uno nuevo mediante HTML & CSS. A su vez, se ha elaborado un controlador para el Calendario que nos permite desplazarnos por los diferentes meses y años.


* Para el correcto funcionamiento del controlador hemos diseñado la clase Mes, donde cada mes tiene un número de días y un nombre asociado. Además, la clase Calendario con todos los métodos e información necesarios.

### V2.10.0

* Se genera el código necesario para la creación, gestión y borrado de eventos en el calendario.


* Se genera el código para que las tareas creadas y existentes aparezcan en el calendario.

### V3.0.0

* Se Actualiza la memoria hasta la fecha.

### V3.1.0

* Se genera la tabla de la base de datos de la clase Cliente, borrando la clase Clientes, migrando el controlador AgendaController a AgendaService y generando la clase ClientesRepository.

* Se modifica el tipo de variable de antigüedad del empleado para guardar la fecha de dada de alta.

### V3.2.0

* Se migra el estado de la aplicación actual al necesario para que la Agenda funcione conectada a la base de datos. Para ello se han creado los repositorios de Empleados, Empresas y Proveedores. Se ha modificado el servicio de la Agenda y el controlador de la aplicación.

### V3.3.0

* Se ha reestructurado las carpetas de la Aplicación de la forma: Módulo de la Aplicación > Entidad | Repository | Service.

* Se ha generado el repositorio de eventos y modificado el controlador de eventos por un Servicio.

* Se ha generado el repositorio de herramientas, máquinas, materiales, productos y vehículos del inventario, y se ha modificado el InventarioController por un InventarioService.

* Se ha generado el repositorio de tareas y modificado TareasController por un TareasService.

* Se ha generado el repositorio de usuarios y de empresa, se ha modificado el UsuariosController por un UsuarioService.

* Se ha mejorado el controlador de errores.

### V3.4.0

* Se ha generado el repositorio de gastos Externos y modificado el controlador de Facturación por un Service.

* Se ha generado el repositorio de nóminas.

* Se ha generado el repositorio de Albaranes y las nuevas funcionalidades referidas a esta.

* Se ha generado el repositorio de Facturas y las nuevas funcionalidades referidas a esta.

### V3.5.0

* Se ha creado la parte backend de la sección de Finanzas, para ello se ha añadido una columna a la base de datos con la información de la empresas

## Herramientas Utilizadas:

  + Adobe Creator Reader
  + Git-Bash
  + Git-Hub
  + Intel J Idea
  + Microsoft Word  
  + MySql
  + Trello
  + Visual Studio Code

## Autores
* **Javier Barrio Martín** - *Programmer* - [Git Account](https://github.com/JaviBarrio6) - Mail: j.barrio.2016@alumnos.urjc.es
