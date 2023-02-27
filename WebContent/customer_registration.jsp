<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<h1>Customer Registration Page</h1>
<form action="regCustomer">
<label for="tbname">Name:</label>
<input type="text" name="tbname" id="tbname"/><br>
<label for="tbemail">Email</label>
<input type="email" name="tbemail" id="tbemail"/><br>
<label for="tbmobile">Mobile:</label>
<input type="tel" name="tbmobile" id="tbmobile"/><br>
<label for="tbpw">Password:</label>
<input type="password" name="tbpw" id="tbpw"/><br>
<label>State:</label>
<select name="ddlstates">
	<option >--select--</option>
	<option value="Karnataka">KA</option>
	<option value="Tamilnadu">TN</option>
	<option value="AndhraPradesh">AP</option>
	<option value="Kerala">KL</option>
</select><br>
<input type="submit" value="Register"/>
</form>

</body>
</html>