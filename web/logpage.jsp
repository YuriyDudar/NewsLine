<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login page</title>
</head>
<link rel="stylesheet" type="text/css" href="style.css">
<body bgcolor="#F5FFFA" >
      <table width="" height=""  align="center" border="1" bgcolor ="#C0C0C0" frame="box" cellpadding="10" cellspacing="3">
        <tr  bgcolor="#F8F8FF">
          <td >
            <form name="logform" action="/AdminController">
			<p><strong>Enter your email:</strong> <input type="text" name="email" size="23"></p>
			<p><strong>Enter your password: </strong><input type="password" name="password"></p>
			<p><input type="submit" name="login" value="Login"></p>
			 </form>
          </td>
        </tr>
      </table>
   
</body>
</html>