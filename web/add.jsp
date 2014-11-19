<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Page Title</title>
</head>
<body>
<form action="AdminController">
<input type="hidden" name="operation" value="addwrite">
<p><strong>ID</strong><input type="text" name="id"></p>
<p><strong>CATEGORY</strong><input type="text" name="category"><br></p>
<p><strong>NAME</strong><input type="text" name="name"><br></p>
<p><strong>ANNOTATION</strong>	<input type="text" name="annotation"></p>
<p><strong>AUTHOR</strong>	<input type="text" name="author"></p>
<p><strong>CREATE DATE</strong>	<input type="text" name="createdate"></p>
<p><strong>MAINTEXT</strong>	<textarea name="maintext" cols="40" rows="10"></textarea></p>
<p>
<input type="submit" name="submit" value="Save">
</p>
</form>
</body>
</html>