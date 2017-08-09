<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="">

</head>
<body>
	<form method="post">
	<table>
		<tr>
			<td>用户名:</td>
			<td><input type="text" name="username"/></td>
		</tr>
		<tr>
			<td>密码:</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="登录"/></td>
		</tr>
	</table>
	</form>
</body>
<script type="text/javascript">

</script>
</html>