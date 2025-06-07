# Java 21

Este es un proyecto Java para la creación de una plataforma ecommerce. 

----- feature sprint1

#Commit Setup
Se crea los archivos del proyecto, se agrega la dependencia de Lombok para facilitar la creaciÃ³n de las 
clases, se definen las clases con sus atributos y métodos que van a ser utilizados sin implementación, 
se crea un main donde es implementado todas las clases.

![image](https://github.com/user-attachments/assets/94dc62b8-7945-4d6e-8ca9-561f4ed7ba6b)

#Commit shopping cart update
Se crea una nueva clase para almacenar la cantidad de cada producto, se cambia orden de compra se deja de
referenciar a un listado de productos por la clase producto orden, se agrega un método para calcular el 
valor total de la orden de compra.

#Merge feature/sprint1 to main

----- feature sprint2

#Commit Inheritance
Se crea un nuevo paquete para organizar el proyecto, separando las clases normales de las abstractas, en el 
nuevo paquete se mueven las clases Producto y Usuario, y se les actualiza el tipo de clase a abstracto, esto
implica que se deben remover las anotaciones de lombok relacionadas con los constructores. Adicionalmente, 
se cambia la anotación Data y se colocan getters y setters para mayor claridad.

Image

Se crean nuevas clases que van a extender las clases abstractas, estas clases van a recibir todos los atributos
e implementaciones de la clase padre, y se agregan nuevos campos y funcionalidades que especializan a las hijas.
Para el proceso de venta se actualizan los atributos para relacionarlos con los usuarios que sean tipo Cliente.


#Merge feature/sprint2 to main
