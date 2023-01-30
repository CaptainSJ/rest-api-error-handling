## Rest API Custom Error Handling Demo
_Implemented custom Exception handling that handles almost all 
the exception occur in the application and make a custom 
ApiError Object with the required details and sends that to 
the client or the requester.
Also handles the Error thrown during model level validation and
maps them to a subError List which contains the Rejected Value and Expected value details._

### API Details

**1. GET** `/api/student/{id}`
> gets Student through given ID

#### Response:
```json
{
  "id" : 1,
  "name" : "PanduRanga",
  "email" : "panduranga@email.com",
  "std" : "TENTH"
}
```
---------------

**2. POST** `/api/student/add`
> adds the student into the database

#### Request:
```json
{
  "name" : "PanduRanga",
  "email" : "panduranga@email.com",
  "std" : "TENTH"
}
```

#### Response:
```json
{
  "name" : "PanduRanga",
  "email" : "panduranga@email.com",
  "std" : "TENTH"
}
```
----------------
### Exception Format
#### Response:
```json

{
  "status": "NOT_FOUND",
  "localDateTime": "30-01-2023 09:37:48",
  "message": "Student was not found for parameters {id=5}",
  "debugMessage": null,
  "subErrors": null
}

```
-----------------

### Technical Specifications:
```Text
Spring Boot Version : 3.0.2
Database used       : H2 In memeory Database
JDK                 : 17
```


