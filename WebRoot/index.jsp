<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	
		<title>主页</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>

	<body>
		hsx网站
		<hr/>
		<c:if test="${empty sessionScope.loginUser }">
			<a href="${pageContext.request.contextPath }/registerUIServlet">注册</a>
			<a href="${pageContext.request.contextPath }/loginUIServlet">登录</a>
		</c:if>
		<c:if test="${!empty sessionScope.loginUser }">
			欢迎您：${sessionScope.loginUser.username }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath }/logoutServlet">注销</a>	
		</c:if>
	</body>
</html>
