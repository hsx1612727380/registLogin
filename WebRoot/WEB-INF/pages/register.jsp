<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/WebCalendar.js"></script>
	
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/registerServlet" method="post">
    	<table width="60%" border="1">
    		<tr>
    			<td>用户名</td>
    			<td>
    				<input type="text" name="username" value="${userRegisterFormBean.username }"/>
    				${userRegisterFormBean.errors.username }
    			</td>
    		</tr>
    		<tr>
    			<td>密码</td>
    			<td>
    				<input type="password" name="password" value="${userRegisterFormBean.password }"/>
    				${userRegisterFormBean.errors.password }
    			</td>
    		</tr>
    		<tr>
    			<td>确认密码</td>
    			<td>
    				<input type="password" name="rePassword" value="${userRegisterFormBean.rePassword }"/>
    				${userRegisterFormBean.errors.rePassword }
    			</td>
    		</tr>
    		<tr>
    			<td>出生日期</td>
    			<td>
    				<input type="text" name="birthday" value="${userRegisterFormBean.birthday }" readonly="readonly" onClick="return SelectDate(this,'yyyy-MM-dd');"/>
    				${userRegisterFormBean.errors.birthday }
    			</td>
    		</tr>
    		<tr>
    			<td>邮箱</td>
    			<td>
    				<input type="text" name="email" value="${userRegisterFormBean.email }"/>
    				${userRegisterFormBean.errors.email }
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" value="注册"/></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
