<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>


<form action="createAcc" method="post">
Your 	Username: &nbsp; &nbsp; &nbsp;<input type="text" name="newName"><br><br>
Your 	Password: &nbsp; &nbsp; &nbsp;<input type="password" name="newPassword1"><br><br>
Re-enter Password: &nbsp;<input type="password"               name="newPassword2"><br><br>
<input type="submit" value="Create Account"></form><br><br>
<form action="index.jsp" method="post">
<input type="submit" value="Back">
</form>
</body>
</html>