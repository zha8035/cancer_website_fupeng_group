<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>病友之家</title>
<link rel="stylesheet" type="text/css" href="css/a.css"/>
<style type="text/css">
<!--
/* a:link { text-decoration: none;}
a:visited { text-decoration: none;}
a:hover { text-decoration: none;}
a:active{ text-decoration: none;} */
center{margin-top:450px;}
body{
background-image:url(image/bg5.jpg);
background-repeat:no-repeat; 
background-position:center center;
     }
-->
 </style>
</head>
<body>
<center>
<form action="ConfirmDInfo" method="post">
姓&nbsp;&nbsp;名:<input type="text" name="name"/><br>
<br>
密&nbsp;&nbsp;码:<input type="password" name="password" value=""/><br>
<br>
<input type="submit" name="submit" value="登陆"/>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="getpassword.jsp">找回密码?</a><br>
<br>
<a href="DRegister.jsp" ><font size=4 >医生注册</font></a>
</form>
</center>
</body>
</html>