<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Control Panel</title>
</head>
<link rel="stylesheet" type="text/css" href="adminstyle.css">
<body>
<table>
<tr>
<td><%=request.getAttribute("commandmenu")%></td>
</tr>
</table>

<p><a href="http://localhost:8080/SiteController"><button><h3>Web Site</h3></button></a></p>

</body>
</html>