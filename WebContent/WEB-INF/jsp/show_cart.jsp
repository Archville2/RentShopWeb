<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Cart</title>
<link href="<c:url value="css/mix.css" />" rel="stylesheet">

<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="localization.locale" var="loc" />
<fmt:message bundle="${loc}" key="locale.main_button" var="main" />
<fmt:message bundle="${loc}" key="locale.logo_map" var="logo_map" />
<fmt:message bundle="${loc}" key="locale.logo_about" var="logo_about" />
</head>
<body>

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
			<td width="33%">
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="show_main_page" /> 
					<input class="new" type="submit" value="${main}" style="width: 150Px">
				</form>
			</td>
			<td width="33%"><p>${logo_map}</p></td>
			<td width="33%"><p>${logo_about}</p></td>
		</tr>
	</table>

	<table border="0" width="100%">
    <tr>
        <td width="100%" valign="top">
			<c:forEach var="field" items="${cart}">
				<table border="1" width="95%">
					<tr align="center">
						<td rowspan="2" width="20%"><img src="img/${field.img}"></td>
						<td width="20%">Тип: ${field.type}</td>
						<td width="20%">Название: ${field.name}</td>
						<td width="20%">Производитель: ${field.manufacturer}</td>
						<td width="20%">Цена за 30 дней: ${field.price} руб.</td>
					</tr>
					<tr align="center">
						<td colspan="3" width="80%">${field.description}</td>
						<td>
							<form action="Controller" method="post">
							<input type="hidden" name="command" value="rent_item" />
							<input type="hidden" name="equipment_id" value="${field.id}" />
							<input type="hidden" name="client_id" value="${user.id}" />
							срок проката (дней)
							<select name="days" size="1">
								<option value="30">30</option>
								<option value="60">60</option>
								<option value="90">90</option>
							</select><br>
							<input type="submit" name="cart" value="Оформить" /> 
							</form>
						</td>
					</tr>
				</table>
			</c:forEach>
			</td>
        <td align="center">
        <p align="center">Здравствуйте</p>
        <p align="center">${user.name}</p>
        <p align="center">&nbsp;</p>
        <p align="center">Меню:</p>
        <form action="Controller" method="post">
            <p><input class="new" type="submit" name="B1" value="Личный кабинет" style="width: 120Px"></p>
        </form>
        <form action="Controller" method="post">
        	<input type="hidden" name="command"	value="show_my_items" />
        	<input type="hidden" name="client_id" value="${user.id}" />
            <p><input class="new" type="submit" name="B2" value="Мои товары" style="width: 120Px"></p>
        </form>
            <p><input class="old" type="submit" name="B3" value="Корзина" style="width: 120Px"></p>
         <form action="Controller" method="post">
        	<input type="hidden" name="command"	value="logout_client" />
            <p><input class="new" type="submit" value="Выход" style="width: 120Px"></p>
        </form>
        </td>
    </tr>
    
</table>

</body>
</html>