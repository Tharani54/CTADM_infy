<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie Rating</title>
</head>
<body>

 <form action="addrating">
  
  Customer id : <input type ="text" name="customerid"> <br> <br>
  Customer FirstName :<input type = "text" name = "customerfirstname"> <br> <br>
  Customer SecondName :<input type = "text" name = "customersecondname"> <br> <br>
  Movie :
  <select name="Movie">
<option value="Movie 1">Movie 1</option>
<option value="Movie 2">Movie 2</option>
<option value="Movie 3">Movie 3</option>
</select> <br> <br>
  Customer Rating : <input type = "text" name = "customerRating"> <br> <br>
  <input  type="submit"> 
  
  </form><br>
  
  
  
   
  
</body>
</html>