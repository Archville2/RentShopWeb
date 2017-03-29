<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Registration</title>
<link href="<c:url value="css/mix.css" />" rel="stylesheet">

<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="localization.locale" var="loc" />
<fmt:message bundle="${loc}" key="locale.client_name" var="client_name" />
<fmt:message bundle="${loc}" key="locale.client_surname" var="client_surname" />
<fmt:message bundle="${loc}" key="locale.client_email" var="client_email" />
<fmt:message bundle="${loc}" key="locale.client_phone" var="client_phone" />
<fmt:message bundle="${loc}" key="locale.login_text" var="client_login" />
<fmt:message bundle="${loc}" key="locale.password_text" var="client_password" />
<fmt:message bundle="${loc}" key="locale.registration" var="registration" />
<fmt:message bundle="${loc}" key="locale.main_button" var="main" />

</head>
<body>

	<script language="Javascript">
		function ChangeColor(text) {
			document.getElementById(text).style.backgroundColor = "white";
		}
	</script>

	<table border="0" width="100%">
		<tr align="center">
			<td width="20%"></td>
			<td width="60%"><img src="img/shop_logo.gif"></td>
			<td width="20%" valign="top" align="right">
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="change_language" /> 
					<input type="image" name="locale" value="en" src="img/uk_flag.png" width="32" height="32" /> 
					<input type="image" name="locale" value="ru" src="img/ru_flag.png" width="32" height="32" />
				</form>
			</td>
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
		<table border="0" width="100%">
			<tr align="left">
				<td width="200">
				<input id="i01" type="text" name="name"	value="" style="width: 200Px"></td>
				<td>${client_name}</td>
			</tr>
			<tr align="left">
				<td width="200">
				<input id="i02" type="text" name="surname" value="" style="width: 200Px"></td>
				<td>${client_surname}</td>
			</tr>
			<tr align="left">
				<td width="200">
				<input id="i03" type="text" name="phone" value="" style="width: 200Px"></td>
				<td>${client_email}</td>
			</tr>
			<tr align="left">
				<td width="200">
				<input id="i04" type="text" name="email" value="" style="width: 200Px"></td>
				<td>${client_phone}</td>
			</tr>
			<tr align="left">
				<td width="200">
				<input id="i05" type="text" name="login" value="" style="width: 200Px"></td>
				<td>${client_login}</td>
			</tr>
			<tr align="left">
				<td width="200">
				<input id="i06" type="text" name="password"	value="" style="width: 200Px"></td>
				<td>${client_password}</td>
			</tr>
		</table>

		<br> 
		<input type="hidden" name="command" value="reg_new_client" />
		<input class="new" type="submit" value="${registration}" style="width: 200Px">
	</form>
	
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="show_main_page" />
		<input class="new" type="submit" value="${main}" style="width: 200Px">
	</form>
	
</body>
</html>