<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
	<form action="${pageContext.request.contextPath }/loginServlet" method="post">
		用户名：<input type="text" name="username"/><br/>
		密　码：<input type="text" name="password"/><br/>
		<input type="submit" value="登录"/>
	</form>    
  </body>
</html>
