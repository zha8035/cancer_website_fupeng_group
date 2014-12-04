<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>脑癌专题</title>
<style>
<!--
a:link{text-decoration:none;}
a:active{text-decoration:none;}
a:visited{text-decoration:none;}
body{
background-image:url(../image/bg10.jpg);
background-repeat:no-repeat;
background-position:center center;}
-->
</style>
</head>
<body>
<img src="../image/collection.jpg"  alt="收藏本站">
<a onclick="window.external.addFavorite(location.href,document.title)" href="#ecms">[收藏本站]</a>　
<img src="../image/homepage.gif" alt="设为首页">
<a onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('/')" href="#ecms">[设为首页]</a>
<!-- <a href="collevtion.jsp" alt="收藏本站"></a>
<a href="" >设为首页</a> -->
<br>
<br>
<form action=""  method="post">
<input type="text" name="keyword" value="请输入关键词"/>
<input type="submit" name="submit" value="搜索">
</form>

<table>
<tr>
<td ><img src="../image/bg7.jpg"  width=109 height=80>
</td>
<td>首页</td>
<td><a href="../braincancer/braincancer.jsp">脑癌</a></td>
<td><a href="">胃癌</a></td>
<td><a href="">肝癌</a></td>
</tr>
<tr>
<td>脑癌专题</td>
<td><a href="../braincancer/BCReason.jsp">发病原因</a></td>
<td><a href="../braincancer/BCComplication.jsp">并发症</a></td>
<td><a href="../braincancer/BCSymptom.jsp">症状</a></td>
<td><a href="../braincancer/BCCure.jsp">治疗</a></td>
<td><a href="../braincancer/BCNurse.jsp">护理</a></td>
<td><a href="../braincancer/BCPrevent.jsp">预防</a></td>
</tr>
</table>
</body>
</html>