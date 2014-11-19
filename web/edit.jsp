<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="pagenews" class="by.yura.newsline.dao.beans.News" scope="request"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:setProperty name="pagenews" property="*"></jsp:setProperty>
<form action="AdminController">
<input type="hidden" name="operation" value="addedit">
<p><strong>ID</strong><input type="text" name="id" value="<jsp:getProperty property="id" name="pagenews"/>" readonly="readonly"></p>
<p><strong>CATEGORY</strong><input type="text" name="category" value="<jsp:getProperty property="category" name="pagenews"/>"><br></p>
<p><strong>NAME</strong><input type="text" name="name" value="<jsp:getProperty property="name" name="pagenews"/>"><br></p>
<p><strong>ANNOTATION</strong>	<input type="text" name="annotation" value="<jsp:getProperty property="annotation" name="pagenews"/>"></p>
<p><strong>AUTHOR</strong>	<input type="text" name="author" value="<jsp:getProperty property="author" name="pagenews"/>"></p>
<p><strong>CREATE DATE</strong>	<input type="text" name="createdate" value="<jsp:getProperty property="createdate" name="pagenews"/>"></p>
<p><strong>MAINTEXT</strong><textarea name="maintext" cols="50" rows="10"><jsp:getProperty property="maintext" name="pagenews"/></textarea>
</p>
<p>
<input type="submit" name="submit" value="Save">
</p>
</form>
</body>
</html>