<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="patientBean.PatientBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="news" class="newsBean.NewsBean" scope="request"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>病人首页</title>
<style>
<!--
a:link{text-decoration:none;}
a:active{text-decoration:none;}
a:visited{text-decoration:none;}
body{
background-image:url(../image/bg10.jpg);
background-repeat:no-repeat;
background-position:center center;}
#style1{white-space:nowrap;
/*         width:600px; */
        border-width:thin;
        border-color:black;
        border-style:outset;
        border-left:30dx;}
#style2{/* margin-left:650px; */
        position:absolute;
        top:170px;
        left:600px;
        border-width:thin;
        border-style:inside;
        border-color:black;
        width:200px;height:200px;}
#style3{white-space:nowrap;
        margin-top:10px;
        border-width:thin;
        border-color:black;
        border-style:outset;
        /* width:300px; */}
#style4{white-space:nowrap;
        margin-top:10px;
        border-width:thin;
        border-color:black;
        border-style:outset;
        height:250px;
        width:500px;}
font.first{border-width:2px;}
-->
</style>
</head>
<body>
<img src="../image/collection.jpg"  alt="收藏本站">
<a onclick="window.external.addFavorite(location.href,document.title)" href="#ecms">[收藏本站]</a>　
<img src="../image/homepage.gif" alt="设为首页">
<a onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('/')" href="#ecms">[设为首页]</a>
<%-- 欢迎您:<jsp:getProperty property="name" name="patientbean"/> --%>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%
out.print("欢迎您："+(String)session.getAttribute("username"));
%>
<font>&nbsp;&nbsp;&nbsp;我的消息&nbsp;&nbsp;&nbsp;</font>
<font><a href="../NewFile.jsp">论坛发帖</a></font>
<!-- <a href="collevtion.jsp" alt="收藏本站"></a>
<a href="" >设为首页</a> -->
<br>
<br>
<form action=""  method="post">
<input type="text" name="keyword" value="请输入关键词"/>
<input type="submit" name="submit" value="搜索">
</form>
<table id="style1">
<tr>
<td  rowspan="2">
<img src="../image/bg7.jpg"  width=109 height=80></td>
<td></td>
<td></td>
<td><a href="patientmain.jsp">首页</a></td>
<td><a href="../braincancer/braincancer.jsp">脑癌</a></td>
<td><a href="">胃癌</a></td>
<td><a href="">肝癌</a></td>
</tr>
<tr>
<td></td>
<td></td>
<td><a href="">乳癌</a></td>
<td><a href="../gastriccancer/gastriccancer.jsp">高血压</a></td>
<td><a href="">冠心病</a></td>
</tr>
</table>
<!-- <div id="style1">
<ul >
<li><a href="patientmain.jsp">首页</a></li>
<li><a href="../braincancer/braincancer.jsp">脑癌</a></li>
<li><a href="../gastriccancer/gastriccancer.jsp">胃癌</a></li>
<li><a href="../gastriccancer/gastriccancer.jsp">肝癌</a></li>
</ul>
<ul>
<li><a href="../gastriccancer/gastriccancer.jsp">乳癌</a></li>
<li><a href="../gastriccancer/gastriccancer.jsp">高血压</a></li>
<li><a href="../gastriccancer/gastriccancer.jsp">高血压</a></li>
<li><a href="../gastriccancer/gastriccancer.jsp">冠心病</a></li>
</ul>
</div> -->
<div id="style2">
<font color="red" size=5px face="楷体">&nbsp;&nbsp;&nbsp;在线咨询</font>
<ul>
<li>
<img src="../image/doctorone.jpg" width="109" height="80"><a href="doctorone.jsp">咨询</a>
</li>
<li><img src="../image/doctortwo.jpg" width="109" height="80"><a href="doctorone.jsp">咨询</a></li>
<li>
<img src="../image/doctorone.jpg" width="109" height="80"><a href="doctorone.jsp">咨询</a>
</li>
</ul>
</div>
<font class="first" face="楷体" size=10px >最新动态</font>
<div id="style4">
</div>
<div id="style3">
<ul>
<li><a href="../newsone.jsp"><% out.print((String)session.getAttribute("title"));%></a></li>
<%= (String)("        "+session.getAttribute("author")+"      ") %>
<%= (String)session.getAttribute("time") %>
<li>新闻二</li>
<li>新闻三</li>
<li>新闻四</li>
</ul>
</div>
</body>
</html>