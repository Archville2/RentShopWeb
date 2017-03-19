<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sport Equipment Shop</title>
<link href="<c:url value="css/mix.css" />" rel="stylesheet">


<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.registration" var="reg_button" />
<fmt:message bundle="${loc}" key="local.login" var="login_button" />
<fmt:message bundle="${loc}" key="local.login_text" var="login_text" />
<fmt:message bundle="${loc}" key="local.password_text" var="password_text" />

</head>
<body>
<table border="0" width="100%">
		<tr align="right">
	     	<td><form action="Controller" method="post">
	     		<input type="hidden" name="command" value="change_language" />
	     		<input type="image" name="local" value="en" src="img/uk_flag.png" width="32" height="32"/>
	     		<input type="image" name="local" value="ru" src="img/ru_flag.png" width="32" height="32"/>
	     		</form>
	     	</td>
    	</tr>
 </table>
    
	<table border="0" width="100%">
		<tr align="center">
			<td></td>
			<td><img src="img/shop_logo.gif"></td>
			<td></td>
		</tr>
	</table>
	<br>
	<table border="0" bgcolor="f0f0f0" width="100%">
		<tr align="center">
			<td width="33%"><p>Список товаров</p></td>
			<td width="33%"><p>Карта проезда</p></td>
			<td width="33%"><p>Контактные данные</p></td>
		</tr>
	</table>
	<br>
<form action="Controller" method="post">
	<table border="0" bgcolor="d0d0d0" width="100%">

		<tr align="center">
			<td width="50%">&nbsp;</td>
			<td width="20%">&nbsp;</td>
			<td colspan="2" width="300">
				
					<input type="text" name="login" value="" size="20"><br>${login_text}
				
			</td>
		</tr>
		<tr align="center">
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td colspan="2">

					<input type="password" name="password" value="" size="20"><br>${password_text}
				
			</td>
		</tr>

		<tr align="center">
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td width="150">
				<a href="reg_client.jsp">
					<input class="new" type="button" value="${reg_button}" style="width: 120Px">
				</a>
			</td>
			<td width="150">

					<input type="hidden" name="command" value="login_client" /> 
					<input class="new" type="submit" value="${login_button}" style="width: 120Px">
				
			</td>
		</tr>
	</table>
</form>
</body>
</html>