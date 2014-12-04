<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="news" class="newsBean.NewsBean" scope="request"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
<!--
form{border-width:2px;
     border-color:black;
     border-type:solid;
}
-->
</style>
</head>
<body>
<jsp:setProperty property="*" name="news"/>
<% 
/* String title = request.getParameter("title"); */
application.setAttribute("newstitle", "title");
%>
<form action="NewsPostServlet" name="newsform" method="post">
<table align="center" >
<tr>
<td>标题</td>
<td><input type="text" name="title" id="title" size="40"/></td>
</tr>
<tr>
<td>作者</td>
<td><input type="text" name="author" id="author" size="40"/></td>
</tr>
<tr>
<td>分类</td>
<td><select name="catelog">
<option value="internationnews">国际新闻</option>
<option value="countrynews">国内新闻</option>
<option value="news">实时新闻</option>
</select></td>
</tr>
<tr>
<td>内容</td>
<td><textarea rows="5" cols="40" name="content">
</textarea></td>
</tr>
<tr>
<td align="right"><input type="submit" name="submit" value="发布"></td>
<td align="center"><input type="reset" name="reset" value="重置"></td>
</tr>
</table>
</form>
</body>
</html>