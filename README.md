# Java 21

Este es un proyecto Java para la creación de una plataforma ecommerce. 

----- feature sprint1

#Commit Setup
Se crea los archivos del proyecto, se agrega la dependencia de Lombok para facilitar la creación de las 
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

![image](https://github.com/user-attachments/assets/e00678a7-6618-4679-aeda-bc1f111ec8b8)

Se crean nuevas clases que van a extender las clases abstractas, estas clases van a recibir todos los atributos
e implementaciones de la clase padre, y se agregan nuevos campos y funcionalidades que especializan a las hijas.
En el proceso de venta se actualizan los atributos para relacionarlos con los usuarios que sean tipo Cliente.

![image](https://github.com/user-attachments/assets/b0a5f37f-3561-4d28-9301-f5326a357cfb)


#Merge feature/sprint2 to main

----- feature sprint3

#Commit Polymorphism, overloading and overriding

Se crea un nuevo paquete llamado utils, donde se van a utilizar métodos estáticos que seran utilizados por las
otras clases, se crea uno para String y otro para Colecciones que permitan determinar si el parametro de entrada
es null o vacio. 

![image](https://github.com/user-attachments/assets/907ae7cc-5ab3-452d-8659-b193d44ba8eb)

Se realiza la implementación de polimorfismo para que los métodos de tipo producto, admitan los productos fisicos
y digitales, el método implementado es editarCarrito de compra, dicho método se encarga de agregar, eliminar o 
modificar los productos del carrito de compras. Se implementa con sus respectivas validaciones, apoyado en los 
métodos utiles y usando lambdas.

![image](https://github.com/user-attachments/assets/88693a65-18b7-4a94-946a-9e2518b4af35)

Se crea un método de sobrecarga que imprime la información básica de los productos en el carrito estos metodos
son: imprimir todos los productos, filtrados por id, por tipo producto y por categoria, al igual que con editar
carrito, se utiliza lambdas para filtrar las ordenes de compra (Carrito).

![image](https://github.com/user-attachments/assets/38100d59-c817-41c3-a44e-5006d4ff0821)

En la clase padre productos se crea un método que imprime la información detallada de los productos, y en las clases
hijas producto fisico y digital, se realiza una sobreescritura para que cada subclase tenga una adaptación diferente
de la información a imprimir con base a sus atributos. Se implementa validaciones para productos y constructores 
tanto para las clases padres como con las clases hijas.

![image](https://github.com/user-attachments/assets/6b022c45-b6bd-4090-88a9-d7b6900edd66)

#Merge feature/sprint3 to main
