<%@page import="com.dataserver.data"%>  
<html>

<body>

<% 

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

session.setMaxInactiveInterval(60);
try{
if(session.getAttribute("username")==null || session.getAttribute("username").toString().equals("")) {
	response.sendRedirect("index.jsp");
}
else{
	out.print("<br><h5> Welcome " + session.getAttribute("username") + "</h5><br>");
	out.print("<br><p>" + data.giveInfoList((int)session.getAttribute(session.getAttribute("username").toString())) + "</p><br>");
}}
catch(Exception e){
	response.sendRedirect("index.jsp");
}
%>
<form action="saveInfo" method="post">
<textarea type="text" name="txt" cols="50" rows="20"></textarea>
<br>
<input type="submit" value="Save">
</form>
<br><br>
<form action="logOut" method="post">
<input type="submit" value="Log out">
</form>
</body>


</html>