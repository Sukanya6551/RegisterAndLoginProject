<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<h1>Customer Registration Page</h1>
<form action = "regCustomer" method = "post">
   <label for = "tbName">Name:</label>
   <input type = "text" id = "tbName" name = "tbName"/>
   <br><br>
   <label for = "tbEmail">Email:</label>
   <input type = "email" id = "tbEmail" name= "tbEmail"/>
   <br><br>
   <label for = "">Mobile no:</label>
   <input type = "number" id ="tbMob" name = "tbMob"/>
   <br><br>
   <label for="tbPass">Password:</label>
   <input type = "password" id = "tbPass" name = "tbPass"/>
   <br><br>
   <label for = "tbSt">Select State:</label>
   <select name = "ddlstates">
   <option value = "">---Select---</option>
   <option value = "Karnataka">KA</option>
   <option value = "Tamil Nadu">TN</option>
   <option value = "Andhra Pradesh">AP</option>
   <option value = "Kerala">KL</option>
   
   </select>
   <br><br>
   
   <input type = "submit" value = "Register"/>
  
   
   
</form>
</body>
</html>