<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix='fmt' %>  
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
<style type="text/css">
	td {padding:5px}
</style>
</head>
<body>
	<strong><fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/></strong>
	<table border="1" cellspacing="0" cellpadding="0">
		<tr>
			<td>序号</td>
			<td>ID</td>
			<td>英雄名</td>
			<td>HP</td>
			<td>伤害</td>
		</tr>
		<tr>
		<c:forEach items="${heros}" var="hero" varStatus="st">
		<tr>
			<td>${st.count}</td>
			<td>${hero.id }</td>
			<td>${hero.name }</td>
			<td>${hero.hp }</td>
			<td>${hero.damage }</td>
			<td style="width:40px;text-align:center"  id="${hero.id}"><a href="javascript:void(0)">X</td>
		</tr>
		</c:forEach>
	</table>
</body>
<script type="text/javascript">
	var tds = document.getElementsByTagName("td");
	for(var i=0;i<tds.length;i++){
		var td = tds[i];
		if(td.hasAttribute("id")){
			td.onclick = function(){
				var xhr = new XMLHttpRequest();
				xhr.open("get", "delHeroServlet?id="+this.id,true);
				xhr.send();
				xhr.onreadystatechange = function(){
					if(xhr.status === 200 && xhr.readyState === 4 ){
						window.location.href = "listHeroServlet";
					}
				}
			}
		}
	}
</script>
</html>