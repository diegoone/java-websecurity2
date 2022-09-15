# exploring web security


Este proyecto integra autenticación con JSON Web Tokens, autorizacion basada en permisos. 

Un usuario puede tener muchos roles, cada rol puede tener muchos permisos, lo cual permite crear, personalizar (agregar o quitar permisos) o eliminar, dando la flexibilidad al no tener condicionales del tipo: 

	SI es rol = Ventas haga esto, esto otro y esto otro ...

En su lugar: 

	if tiene permiso inventario.crear haga esto
	
Lo cual nos permite un control más avanzado y personalizado. 
Se utiliza en conjunto con componentes de vista de Javascript como Angular, para poner restringir también elementos en la interfaz de usuario

## Resumiendo
Se soportan roles que se pueden personalizar en cualquier momento

# Software a utilizar
- Java 8
- Spring boot
- Spring Security
- JPA / Hibernate
- PostgreSQL
- Eclipse
- Apache Maven
