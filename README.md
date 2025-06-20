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
y digitales, el mÃ©todo implementado es editarCarrito de compra, dicho método se encarga de agregar, eliminar o 
modificar los productos del carrito de compras. Se implementa con sus respectivas validaciones, apoyado en los 
métodos utiles y usando lambdas.

![image](https://github.com/user-attachments/assets/88693a65-18b7-4a94-946a-9e2518b4af35)

Se crea un método de sobrecarga que imprime la informacián básica de los productos en el carrito estos metodos
son: imprimir todos los productos, filtrados por id, por tipo producto y por categoria, al igual que con editar
carrito, se utiliza lambdas para filtrar las ordenes de compra (Carrito).

![image](https://github.com/user-attachments/assets/38100d59-c817-41c3-a44e-5006d4ff0821)

En la clase padre productos se crea un método que imprime la información detallada de los productos, y en las clases
hijas producto fisico y digital, se realiza una sobreescritura para que cada subclase tenga una adaptación diferente
de la información a imprimir con base a sus atributos. Se implementa validaciones para productos y constructores 
tanto para las clases padres como con las clases hijas.

![image](https://github.com/user-attachments/assets/6b022c45-b6bd-4090-88a9-d7b6900edd66)

#Merge feature/sprint3 to main

----- feature sprint4

#Commit Encapsulation and abstraction

Se cambia los identificadores de acceso de los atributos y métodos de las clases del proyecto con el fin de generar coherencia con el esquema planteado.

![image](https://github.com/user-attachments/assets/18332f4a-7ba2-43cf-bfb4-dddc765ff061)

Por otro lado, se agrega una bandera en la clase de usuario que indica si el usuario se encuentra logeado y tiene permiso de realizar sus funciones, se implementan los métodos para iniciar, cerrar sesión y validar que el usuario este diligenciado correctamente.

![image](https://github.com/user-attachments/assets/912698fa-2557-454a-aed8-c846a9bb7d3f)

En la clase de utiles de string, se agrega un nuevo método estático que valida que un correo sea valido, mediante el uso de expresiones regulares. Adicionalmente, se crea una nueva clase de utiles para fecha y un método que verifique que el usuario tenga al menos 15 años.

![image](https://github.com/user-attachments/assets/00e8969b-71ec-4b3c-9cde-9fa6f46d4762)

Por último, se aplican los conceptos de abastracción creando una nueva clase abstracta llamada Item, está clase contiene la información más básica de los productos, identificador, nombre y precio. Para mantener la jerarquía propuesta, producto extiende a item y de esta manera todas sus subclases podrán acceder a dichos atributos.

![image](https://github.com/user-attachments/assets/430edc8f-f510-4ab0-a083-bc6542dd5ad3)

#Merge feature/sprint4 to main

----- feature sprint5

#Commit Interfaces and Abstract classes

Se crean nuevos paquetes para almacenar las interfaces del proyecto, se actualiza el tipo de clase a Inventario, que ahora pasa a ser una clase abstracta, a la cual se le modifican los atributos y métodos, en está clase abstracta se crea un método abstracto para que sea implementado por las clases que lo hereden.

![image](https://github.com/user-attachments/assets/34659bd7-fc87-476a-9a12-de64b2c39529)

El método abstracto creado se llama gestionar stock, que permite agregar, modificar o eliminar del stock un producto, para facilitar el manejo del inventario se crea una clase intermedia llamada producto inventario, esta clase tiene la información de la cantidad de productos que hay. Se crean dos clases, inventario físico y digital, estas clases heredan de Inventario, la implementación varia en que el inventario digital permite manejar stock negativo. 

![image](https://github.com/user-attachments/assets/dcc00b83-7e56-4856-8bb2-57550ade7d2e)

Se crea una interfaz para llevar le proceso de pago de la plataforma, esta interfaz define los métodos que deben ser implementados según el medio de pago escogido por el usuario.

![image](https://github.com/user-attachments/assets/581dae2b-dfe1-4d39-9b98-44b448c580d3)

Cabe destacar que en las clases que implementan la interfaz se tomó el impuesto de la compra sobre un valor del 20%, sin importar el medio de pago. Algunas de estás clases solicitaran entradas por parte del usuario y se debe asumir que todas al final van a redirigir a una pasarela de pagos.

![image](https://github.com/user-attachments/assets/b694741c-b849-45b4-a326-8e95852c7a67)

Por último, se crea una nueva clase para llevar el control de pagos realizados por la plataforma, está clase no va a tener métodos implementados, únicamente tiene los atributos que identifican la compra y su estado.

![image](https://github.com/user-attachments/assets/e4668656-8534-49c6-92d4-da474ff9d53b)

#Merge feature/sprint5 to main
