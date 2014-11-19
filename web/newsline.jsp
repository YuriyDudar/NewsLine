<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="news" class="by.yura.newsline.dao.beans.News" scope="request"></jsp:useBean>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<title>News Line</title> 
</head>
<link rel="stylesheet" type="text/css" href="websitestyle.css">
<body>
  
<table width="100%" bgcolor="#00FFFF" align="center" cellpadding="20">

<tr id="header" bgcolor="#7FFFD4">
	<td align="center" height="80" colspan="2"><h2>Portal of news</h2></td>
</tr>

<tr id="menu" bgcolor="#F0FFFF">

<td id="category" valign="top"  width="190" height="500"><strong>Category:</strong><br>
<%=request.getAttribute("menu") %>
</td>
 <td id="text" height="500" valign="top"><strong>Annotation:</strong><br>
 <jsp:getProperty name="news" property="annotation"/><br>
 <strong>Text:</strong><br>
 <jsp:getProperty name="news" property="maintext"/></td>
</tr>	

<tr id="end" bgcolor="#00FFFF">
  <td colspan="2" height="30"><jsp:getProperty name="news" property="author"/></td>
</tr>
</table>
</body>
</html>