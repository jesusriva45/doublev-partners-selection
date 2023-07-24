# Getting Started

## Reference Documentation

## Pasos para desplegar la aplicación en DOCKER

- ### ejecutar una sola vez el siguiente comando
- #### docker network create doublev

- #### ubicarse en el directorio raiz -> doublev-partners-selection
- #### mvn clean package install
- #### docker build -t dp-api-rest . -f .\doublev-partners-api-rest\Dockerfile
- #### docker run -p 9520:9520 -d --rm --name container-dp-api-rest --network doublev dp-api-rest


## Listado de endpoints en localhost

### POST - http://localhost:9520/ticket-api-rest/ticket
- {"identificacion": "72748394","nombre": "Jesus","apellido": "Rivadeneyra"}

### DELETE - http://localhost:9520/ticket-api-rest/eliminar/{idTicket}
- idTicket debe tener el valor de algun ticket registrado


### PUT - http://localhost:9520/ticket-api-rest/actualizar
- ### REQUEST - {"idTicket": 1,"estado":"C"}
-  el campo estado solo puede tener valor A o C

### GET - http://localhost:9520/ticket-api-rest/paginacion-ticket

- #### REQUEST - {"idTicket":1,"offset": 0,"pageSize": 10,"fieldName": "fechaCreacion"}
-  el campo idTicket solo se le da valor si se quiere buscar un ticket en especifico
-  el campo offset indica en que numero de paginas te ubicas
-  el campo pageSize indica el numero de registros que se mostrará por página
-  el campo fieldName indica cual es el el campo por el cual es va a ordenar la lista

### Pasos para desplegar la aplicación en DOCKER - GRAPHQL

#### URL BASE - http://localhost:9520/ticket-api-rest/graphiql?path=/ticket-api-rest/graphql

##### REQUEST MUTATION PARA REGISTRAR TICKET

##### mutation {
##### registrarTicket(
##### registrarTicketRequest: {identificacion: "95147862", nombre: "Jaime", apellido: "Suarez"}
##### ) { idTicket,fechaCreacion,fechaActualizacion,estado, usuario {
##### idUsuario,nombre,apellido, identificacion }}}


##### REQUEST QUERY PARA CONSULTA PAGINADA DE TICKETS

##### query {
##### listarTicketPorCampo(request: {idTicket: null, offset: 0, pageSize: 10, fieldName: ""}
##### ) {totalElementByPage,totalElements,response}}