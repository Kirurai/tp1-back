# TP 1 - BACK 

Se creo una API utilizando springboot, lombok y jpa. El objetivo de esta api es poder cargar los datos de una empresa y algunas noticias relacionadas referentes al trabajo práctico número 1. El puerto base para usar por defecto es el 8080

##Endpoints

###Relacionados a empresa

| Endpoint   | Verbo HTTP | Descripción |
| ------ | ------ | ------ |
| /api/empresas | POST | Crea una empresa. Se le puede entregar un body en forma de json con los datos de la empresa (Denominación, telefono, etc etc) |
| /api/empresas | GET  | Devuelve un array con los json de todas las empresas existentes en la base de datos|
| /api/empresas/{id} | GET | Devuelve especificamente la empresa asociada al id|
| /api/empresas/{id} | PUT | Actualiza los datos de una empresa con los datos entregados en el body del request |
| /api/empresas/{id} | DELETE | Elimina de la base de datos la empresa asociada al id|

Los datos que puede aceptar una empresa son:
- denominacion
- telefono
- horarioDeAtencion
- quienesSomos
- latitud
- longitud
- domicilio
- email

