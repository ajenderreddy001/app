# app
MySQL required---db2.sql import into your local mysql ----some values are populated--------
change DB name in application properties
---HR Login---
  ---username hr password hr---
 
 
 REST API's
    POST http://localhost:8080/login
   with parameters as tname and tpass 
  
  http://localhost:8080/view/attendance
  
  http://localhost:8080/view/all/attendance
  
  POST http://localhost:8080/employee/create
   {"user":"username,"password":"password"} as JSON
  
   http://localhost:8080/getout
   
URL's:
  http://localhost:8080
  http://localhost:8080/go
  http://localhost:8080/out
  
tables:
employee
employee_details
attendance(date,emp_id,type) here type is L Leave P present A Absent O Onduty

DIDn't do client side JSON parsing  but Fetche all correct data
