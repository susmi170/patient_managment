# patinet_heartRate_management
This is a spring boot patient which contains codebase for CRUD APIs needed for a patient management system  
This is a patient for "patient Managemnet Application"  
Please find below Setup and Run process.  
**Setup and run :-**    
1.Please create a fork of this repo.  
2.Git clone to your local system and open in IDE/ or setup via git link directly to your IDE  
3.DB used H2 in memory with DB name:PatinetHeartrateManagementApplication, username : susmita , no passwrod. (http://localhost:8080/h2-console/)  
4.Run the PatinetHeartrateManagementApplication ( Spring boot application main class)  
5. By default server will start at localhost 8080  
6.You can now start using the apis ( details in Swagger ) in your postman  
7.Here patient is the resouce, so all the apis are created keeping this is mind with just /patient endpoit   
8.With keeping standard rset api in mind have developed the api endpoit accordingly   
7.to save/create use /patient with POST Method  
8.to Update heartrate use /patient with PUT method  
9.to get by ID use /patient/{id} with GET method  
10.to get all use /patient/all with GET method  
11.login a user /user/login
12. to register a user /user/register
  
**note** : we shoud use the resource as it is and use Rest method to define them , should not create endpoint like createpatient or updatepatient .   
as POST is dedicated to create patient , PUT is for update , like wise GET and DELETE  
  
**swagger url**:---http://localhost:8080/swagger-ui/index.html#/   
has all the details for each api and response code and all the details  
  
**patient table has below columns**   
* ID,NAME,ADDRESS,DATEOFBIRTH,CHECKUPDATE,CREATEDBY,UPDATEDBY,HEARTRATE
  **user table has below columns**
* ID,NAME,PASSWORD,PHONE,EMAIL
ID is the primary key ,will be automatcailly genarted by sequence  
  
   
**----Technology used:---**    
 **Java 17 with Spring boot**  
 **Lombok** for data generation(constructor and getter ,setter)  
 **Mapstruct**:(patientDtoMapper.java) For converting Dto to Entity pojo and vice versa . In this patient using patientDto for all api calls , and patient entity for Database table  
 **ControllerAdvice**: (PMExceptionHandlerControllerAdvice.java) -- To handle exception in a cerntarlized place and create custom exception  
					(patientNotFoundException,MethodArgumentNotValidException,patientManagemnetException)  
**Open-API** : for Swagger api documentation **(http://localhost:8080/swagger-ui/index.html#/ )**  
**Database**: H2 inmemory DB with SPring data JPA  
**Junit** for service layer method testing .(patientServiceTest.java)  
**Integration test** for API testing (patientControllerIntegrationTest.java)  
 **Build tool** :Gradle  
   
   
   
**-------API details:----**  



USER :

1.**Register user** :-  
**Endpoint** :http://localhost:8080/user/register  
**Method**: POST  
**Sample request**:-
* {
     "name": "Susmita",
     "email": "msusmita010@gmal.com",
     "password": "test_pass",
     "phone": "9999999999",
     "createdBy":"Susmita",
     "updatedBy":"John"
 }

Response:  *   
{
"id": 1,
*      "name": "Susmita",
   "email": "msusmita010@gmal.com",
   "password": "test_pass",
   "phone": "9999999999",
   "createdBy":"Susmita",
   "updatedBy":"John"
* }

2.


**login user** :-  
**Endpoint** :http://localhost:8080/user/login  
**Method**: POST  
**Sample request**:-
* {
 
  "email": "msusmita010@gmal.com",
  "password": "test_pass",

  }

Response:  *
{
"id": 1,
*      "name": "Susmita",
  "email": "msusmita010@gmal.com",
  "password": "test_pass",
  "phone": "9999999999",
  "createdBy":"Susmita",
  "updatedBy":"John"
* }

PATIENT:

1.**Create patient** :-  
**Endpoint** :http://localhost:8080/patient  
**Method**: POST  
**Sample request**:-  
* {

        "name": "Susmita",
        "address": "Bangalore ",
        "dateOfBirth": "1995-04-27",
        "checkUpDate": "2025-02-17",
        "heartRate": 70,
        "createdBy": "Susmita",
        "updatedBy": "John"
      }  
   
 Response:  
    "id": 2,
     "name": "Susmita",
     "address": "Bangalore ",
     "dateOfBirth": "1995-04-27",
     "checkUpDate": "2025-02-17",
     "heartRate": 70,
     "createdBy": "Susmita",
     "updatedBy": "John"
 
 
2.**Update patient** :
  
  
**Endpoint** :http://localhost:8080/patient  
**Method**: PUT  
**Sample request**:-  
{
"id": 2,
"name": "Susmita",
"address": "Bangalore ",
"dateOfBirth": "1995-04-27",
"checkUpDate": "2025-02-17",
"heartRate": 73,
"createdBy": "Susmita",
"updatedBy": "John"
}

Response:  
"id": 2,
"name": "Susmita",
"address": "Bangalore ",
"dateOfBirth": "1995-04-27",
"checkUpDate": "2025-02-17",
"heartRate": 73,
"createdBy": "Susmita",
"updatedBy": "John"
*


 3.**Get patient by id** :  
 **Endpoint**: http://localhost:8080/patient/2  
 **Method**: GET  
 Request:http://localhost:8080/patient/2  
{
 "id": 2,
 "name": "Susmita",
 "address": "Bangalore ",
 "dateOfBirth": "1995-04-27",
 "checkUpDate": "2025-02-17",
 "heartRate": 73,
 "createdBy": "Susmita",
 "updatedBy": "John"
}
*  
   
   
 4.**Get all patients**:  
 **Endpoint**: http://localhost:8080/patient/all  
**Method**: GET  
 Request:http://localhost:8080/patient/all  
   
 Response:  
   
 [  {
 "id": 2,
 "name": "Susmita",
 "address": "Bangalore ",
 "dateOfBirth": "1995-04-27",
 "checkUpDate": "2025-02-17",
 "heartRate": 73,
 "createdBy": "Susmita",
 "updatedBy": "John"
 },  
 {
 "id": 2,
 "name": "Susmita-1",
 "address": "Bangalore ",
 "dateOfBirth": "1995-04-27",
 "checkUpDate": "2025-02-17",
 "heartRate": 74,
 "createdBy": "Susmita",
 "updatedBy": "John"
 } 
  ]  
   
 

 
