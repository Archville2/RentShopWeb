<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Client page</title>
<link href="<c:url value="css/mix.css" />" rel="stylesheet">

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
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
	
	<table border="0" bgcolor="ffffff" width="100%">
		<tr align="center">
			<td>Категория:
				<select name="D1" size="1">
                	<c:forEach var="f" items="${folder}">
                	<option>${f}</option>
                	</c:forEach>
            	</select>
			</td>
			<td>Тип товара:
				<select name="D2" size="1">
                	<option>Велосипеды</option>
                	<option>Самокаты</option>
                	<option>Лыжи</option>
            	</select>
			</td>
		</tr>
	</table>

	<table border="0" width="100%">
    <tr>
        <td width="100%" valign="top">
<c:forEach var="l" items="${items}">
				<table border="1" width="95%">
					<tr align="center">
						<td rowspan="2" width="20%"><img src="img/${l.img}"></td>
						<td width="20%">${l.type}</td>
						<td width="20%">${l.name}</td>
						<td width="20%">${l.manufacturer}</td>
						<td width="20%">${l.price}</td>
					</tr>
					<tr align="center">
						<td colspan="4" width="80%">${l.description}</td>
					</tr>
				</table>
</c:forEach>
			</td>
        <td align="center">
        <p align="center">Здравствуйте</p>
        <p align="center">${c_name}</p>
        <p align="center">&nbsp;</p>
        <p align="center">Меню:</p>
        <form method="POST">
            <p><input type="submit" name="B1" value="Личный кабинет" style="width: 120Px"></p>
        </form>
        <form method="POST">
            <p><input type="submit" name="B2" value="Мои товары" style="width: 120Px"></p>
        </form>
        <form method="POST">
            <p><input type="submit" name="B3" value="Корзина" style="width: 120Px"></p>
        </form>
        <form method="POST">
            <p><input type="submit" name="B4" value="Выход" style="width: 120Px"></p>
        </form>
        </td>
    </tr>
</table>
	

</body>
</html>