<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
<!--
@import url("<c:url value='/static/style.css'/>");
-->
</style>
</head>
<body>

	<jsp:include page="menu.jsp"/>

	<form method="post" action="<c:url value='Add'/>">
		<table id="formTable" class="formTable">
			<tr>
				<td>Nimi: </td>
				<td><input id="nameBox" name="name" value="${param.name}"></td>
			</tr>
			<tr>
				<td>Kood: </td>
				<td><input id="codeBox" name="code" value="${param.code}"></td>
			</tr>
			<tr>
				<td align="right" colspan="2">
					<br />
					<input id="addButton" type="submit" value="Lisa">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>