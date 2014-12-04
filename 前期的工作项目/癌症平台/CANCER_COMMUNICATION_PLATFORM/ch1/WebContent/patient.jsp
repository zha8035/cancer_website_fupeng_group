<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="patientBean.PatientBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="patientbean" class="patientBean.PatientBean" scope="session"/>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/a.css"/>
<style type="text/css">
<!--
/* a:link { text-decoration: none;}
a:visited { text-decoration: none;}
a:hover { text-decoration: none;}
a:active{ text-decoration: none;} */
center{
margin-top:450px;
}
body{
background-image:url(image/bg5.jpg);
background-position:center center;
background-repeat:no-repeat ;
}
-->
 </style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>病友之家</title>
</head>
<body >
<jsp:setProperty property="name" name="patientbean"/>
<center>
<form action="ConfirmPInfo" method="post">
姓&nbsp;&nbsp;名:<input type="text" name="name" id="name"/><br>
<br>
<%-- <%
session.setAttribute("username", request.getParameter("name"));
%> --%>
密&nbsp;&nbsp;码:<input type="password" name="password" value=""/><br>
<br>
<!--  确认密码:<input type="password" name="pwpassword" value=""/>-->
<input type="submit" name="submit" value="登陆"/>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="getpassword.jsp">找回密码?</a><br>
<br>
<!-- <a href="doctorRegister.jsp" ><font size=4 >医生注册</font></a> -->
<a href="PRegister.jsp"><font size=4 > 病人注册</font></a>
</form>
</center>
</body>
</html>