<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="doctorBean.DoctorBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="doctorbean" class="doctorBean.DoctorBean" scope="application"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>确认信息</title>
</head>
<body>
<center>
<h2>确认信息</h2><br>
昵称:<jsp:getProperty property="name" name="doctorbean"/><br>
<br>
密码:<jsp:getProperty property="password" name="doctorbean"/><br>
<br>
确认密码:<jsp:getProperty property="pwpassword" name="doctorbean"/><br>
<br>
性别:<jsp:getProperty property="sex" name="doctorbean"/>男
   <jsp:getProperty property="sex" name="doctorbean"/>女<br>
<br>
年龄:<jsp:getProperty property="age" name="doctorbean"/><br>
<br>
科室:<jsp:getProperty property="subject" name="doctorbean"/><br>
<br>
职称:<jsp:getProperty property="position" name="doctorbean"/><br>
<br>
电话:<jsp:getProperty property="tel" name="doctorbean"/><br>
<br>
电子邮件:<jsp:getProperty property="email" name="doctorbean"/><br>
</center>
</body>
</html>