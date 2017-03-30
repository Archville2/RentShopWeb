<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Cart</title>
<link href="<c:url value="css/mix.css" />" rel="stylesheet">

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
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
			<td width="33%"><p>Список товаров</p></td>
			<td width="33%"><p>Карта проезда</p></td>
			<td width="33%"><p>Контактные данные</p></td>
		</tr>
	</table>

	<table border="0" width="100%">
    <tr>
        <td width="100%" valign="top">
			<c:forEach var="field" items="${cart}">
				<table border="1" width="95%">
					<tr align="center">
						<td rowspan="2" width="20%"><img src="img/${field.img}"></td>
						<td width="20%">${field.type}</td>
						<td width="20%">${field.name}</td>
						<td width="20%">${field.manufacturer}</td>
						<td width="20%">${field.price}</td>
					</tr>
					<tr align="center">
						<td colspan="3" width="80%">${field.description}</td>
						<td>
							<form action="Controller" target="dummyframe" method="post">
							<input type="hidden" name="command" value="add_to_cart" /> 
							<input type="image" name="cart" value="${field.id}" src="img/icon_cart.gif" width="32" height="32" /> 
							</form>
						</td>
					</tr>
				</table>
			</c:forEach>
			</td>
        <td align="center">
        <p align="center">Здравствуйте</p>
        <p align="center">${c_name}</p>
        <p align="center">&nbsp;</p>
        <p align="center">Меню:</p>
        <form action="Controller" method="post">
            <p><input type="submit" name="B1" value="Личный кабинет" style="width: 120Px"></p>
        </form>
        <form action="Controller" method="post">
            <p><input type="submit" name="B2" value="Мои товары" style="width: 120Px"></p>
        </form>
        <form action="Controller" method="post">
        	<input type="hidden" name="command"	value="show_cart" />
            <p><input type="submit" name="B3" value="Корзина" style="width: 120Px"></p>
        </form>
        <form action="Controller" method="post">
        	<input type="hidden" name="command"	value="logout_client" />
            <p><input type="submit" value="Выход" style="width: 120Px"></p>
        </form>
        </td>
    </tr>
    
</table>

</body>
</html>