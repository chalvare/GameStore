# GameStore
Aplicación para la gestión de una tienda de videojuegos (JAVA)

Una aplicación totalmente funcional, a falta de crear la BD, para la gestión de la compra-venta de juegos. Gestiona a clientes, sus compras, los artículos y su almacenaje, los empleados de la tienda, los departamentos de la misma y los contratos de los propios empleados. 

Para esta aplicación usamos una arquitectura multicapa (Presentación, Negocio, Integración) que facilita mucho la actualización y mejora de la app. También se usaron los siguientes patrones: Singleton, Factory, Commando, MVC, Controller, Data Access Object, Application service y  Transfer.

Para el control de la concurrencia en la BD, hemos usado un control pesimista que bloquea el acceso mientras se está usando el dato y si llega otra hebra, esta espera(si queremos) hasta que esta libre. También comprueba la versión del dato.
