# Java 21

Este es un proyecto Java para la creaci�n de una plataforma ecommerce. 

----- feature sprint1

#Commit Setup
Se crea los archivos del proyecto, se agrega la dependencia de Lombok para facilitar la creaci�n de las 
clases, se definen las clases con sus atributos y m�todos que van a ser utilizados sin implementaci�n, 
se crea un main donde es implementado todas las clases.

![image](https://github.com/user-attachments/assets/94dc62b8-7945-4d6e-8ca9-561f4ed7ba6b)

#Commit shopping cart update
Se crea una nueva clase para almacenar la cantidad de cada producto, se cambia orden de compra se deja de
referenciar a un listado de productos por la clase producto orden, se agrega un m�todo para calcular el 
valor total de la orden de compra.

#Merge feature/sprint1 to main

----- feature sprint2

#Commit Inheritance

Se crea un nuevo paquete para organizar el proyecto, separando las clases normales de las abstractas, en el 
nuevo paquete se mueven las clases Producto y Usuario, y se les actualiza el tipo de clase a abstracto, esto
implica que se deben remover las anotaciones de lombok relacionadas con los constructores. Adicionalmente, 
se cambia la anotaci�n Data y se colocan getters y setters para mayor claridad.

![image](https://github.com/user-attachments/assets/e00678a7-6618-4679-aeda-bc1f111ec8b8)

Se crean nuevas clases que van a extender las clases abstractas, estas clases van a recibir todos los atributos
e implementaciones de la clase padre, y se agregan nuevos campos y funcionalidades que especializan a las hijas.
En el proceso de venta se actualizan los atributos para relacionarlos con los usuarios que sean tipo Cliente.

![image](https://github.com/user-attachments/assets/b0a5f37f-3561-4d28-9301-f5326a357cfb)


#Merge feature/sprint2 to main

----- feature sprint3

#Commit Polymorphism, overloading and overriding

Se crea un nuevo paquete llamado utils, donde se van a utilizar m�todos est�ticos que seran utilizados por las
otras clases, se crea uno para String y otro para Colecciones que permitan determinar si el parametro de entrada
es null o vacio. 

![image](https://github.com/user-attachments/assets/907ae7cc-5ab3-452d-8659-b193d44ba8eb)

Se realiza la implementación de polimorfismo para que los métodos de tipo producto, admitan los productos fisicos
y digitales, el método implementado es editarCarrito de compra, dicho m�todo se encarga de agregar, eliminar o 
modificar los productos del carrito de compras. Se implementa con sus respectivas validaciones, apoyado en los 
m�todos utiles y usando lambdas.

![image](https://github.com/user-attachments/assets/88693a65-18b7-4a94-946a-9e2518b4af35)

Se crea un m�todo de sobrecarga que imprime la informaci�n b�sica de los productos en el carrito estos metodos
son: imprimir todos los productos, filtrados por id, por tipo producto y por categoria, al igual que con editar
carrito, se utiliza lambdas para filtrar las ordenes de compra (Carrito).

![image](https://github.com/user-attachments/assets/38100d59-c817-41c3-a44e-5006d4ff0821)

En la clase padre productos se crea un m�todo que imprime la informaci�n detallada de los productos, y en las clases
hijas producto fisico y digital, se realiza una sobreescritura para que cada subclase tenga una adaptaci�n diferente
de la informaci�n a imprimir con base a sus atributos. Se implementa validaciones para productos y constructores 
tanto para las clases padres como con las clases hijas.

![image](https://github.com/user-attachments/assets/6b022c45-b6bd-4090-88a9-d7b6900edd66)

#Merge feature/sprint3 to main

----- feature sprint4

#Commit Encapsulation and abstraction

Se cambia los identificadores de acceso de los atributos y m�todos de las clases del proyecto con el fin de generar coherencia con el esquema planteado.

Image

Por otro lado, se agrega una bandera en la clase de usuario que indica si el usuario se encuentra logeado y tiene permiso de realizar sus funciones, se implementan los m�todos para iniciar, cerrar sesi�n y validar que el usuario este diligenciado correctamente.

Image

En la clase de utiles de string, se agrega un nuevo m�todo est�tico que valida que un correo sea valido, mediante el uso de expresiones regulares. Adicionalmente, se crea una nueva clase de utiles para fecha y un m�todo que verifique que el usuario tenga al menos 15 a�os.

Image

Por ultimo, se aplican los conceptos de abastracci�n creando una nueva clase abstracta llamada Item, est� clase contiene la informaci�n m�s b�sica de los productos, identificador, nombre y precio. Para mantener la jerarqu�a propuesta, producto extiende a item y de esta manera todas sus subclases podr�n acceder a dichos atributos.

Image

#Merge feature/sprint4 to main
