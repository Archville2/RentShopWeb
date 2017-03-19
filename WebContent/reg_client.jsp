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

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.registration" var="reg_button" />
<fmt:message bundle="${loc}" key="local.login" var="login_button" />
<fmt:message bundle="${loc}" key="local.login_text" var="login_text" />
<fmt:message bundle="${loc}" key="local.password_text" var="password_text" />

</head>
<body>

	<script language="Javascript">
		function ChangeColor(text) {
			document.getElementById(text).style.backgroundColor = "white";
		}
	</script>

	<table border="0" width="100%">
		<tr align="right">
			<td><form action="Controller" method="post">
					<input type="hidden" name="command" value="change_language" /> 
					<input type="image" name="local" value="en" src="img/uk_flag.png" width="32" height="32" /> 
					<input type="image" name="local" value="ru" src="img/ru_flag.png" width="32" height="32" />
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
		<table border="0" width="100%">
			<tr align="left">
				<td width="200"><input id="i01" type="text" name="name"
					value="" size="20" oninput="ChangeColor(this.id);"
					style="background-color: ${err_name}"></td>
				<td>Имя</td>
			</tr>
			<tr align="left">
				<td width="200"><input id="i02" type="text" name="surname"
					value="" size="20" oninput="ChangeColor(this.id);"
					style="background-color: ${y}"></td>
				<td>Фамилия</td>
			</tr>
			<tr align="left">
				<td width="200"><input id="i03" type="text" name="phone"
					value="" size="20" oninput="ChangeColor(this.id);"
					style="background-color: ${y}"></td>
				<td>Телефон</td>
			</tr>
			<tr align="left">
				<td width="200"><input id="i04" type="text" name="email"
					value="" size="20" oninput="ChangeColor(this.id);"
					style="background-color: ${y}"></td>
				<td>e-mail</td>
			</tr>
			<tr align="left">
				<td width="200"><input id="i05" type="text" name="login"
					value="" size="20" oninput="ChangeColor(this.id);"
					style="background-color: ${y}"></td>
				<td>Логин</td>
			</tr>
			<tr align="left">
				<td width="200"><input id="i06" type="text" name="password"
					value="" size="20" oninput="ChangeColor(this.id);"
					style="background-color: ${y}"></td>
				<td>Пароль</td>
			</tr>
		</table>

		<br> <input type="hidden" name="command" value="reg_new_client" />
		<input class="new" type="submit" value="Регистрация"
			style="width: 120Px">
	</form>

</body>
</html>