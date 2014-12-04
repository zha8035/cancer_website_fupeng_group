<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="patientBean" class="patientBean.PatientBean" scope="session"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<center>
<font size=6 color=red face=楷体>病人注册</font>
<br>
<br>
<form action="PatientRegisterActionServlet" name="PatientRegisterAction" method="post" >
昵&nbsp;&nbsp;&nbsp;&nbsp;称:<input type="text" name="nickname" id="nickname"/><br>
<br>
姓&nbsp;&nbsp;&nbsp;&nbsp;名:<input type="text" name="name" id="name"/><br>
<br>
密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="password" id="password"/><br>
<br>
确认密码:&nbsp;&nbsp;<input type="password" name="pwpassword" id="pwpassword"/><br>
<br>
性别:<input type="radio" name="sex" value="男" id="man"/>男
    <input type="radio" name="sex" value="女" id="man"/>女<br>
<br>
年&nbsp;&nbsp;&nbsp;&nbsp;龄:<input type="text" name="age" id="age"/><br>
<br>
职&nbsp;&nbsp;&nbsp;&nbsp;业:<input type="text" name="work" id="work"/><br>
<br>
&nbsp;&nbsp;&nbsp;所在地:<input type="text" name="city" id="city"/><br>
<br>
科&nbsp;&nbsp;&nbsp;&nbsp;室:<input type="text" name="subject" id="subject"/><br>
<br>
电话:<input type="text" name="tel"/><br>
<br>
电子邮件:<input type="text" name="email"/><br>
<br>
<input type="submit" name="submit" class="ipt-b"  value="注册"/>
&nbsp;&nbsp;&nbsp;
<input type="reset" name="reset" class="ipt-b"  value="重置"/>
</form>
</center>
</body>
</html>