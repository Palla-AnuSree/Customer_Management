<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login page</title>
</head>
<body>
<h1>Customer Login Page</h1>
  <form action="logCustomer" method="post">  
    <label for="tbemail">Email:</label>
    <input type="email" name="tbemaillog" id="tbemail" value="<%=  request.getParameter("tbemail")%> "/><br>
     <label for="tbpw">Password:</label>
    <input type="password" name="tbpwlog" id="tbpw" value="<%= request.getParameter("tbpw")%>"/><br>
    <input type="submit" value="Login"/>
</form>
</body>
</html>