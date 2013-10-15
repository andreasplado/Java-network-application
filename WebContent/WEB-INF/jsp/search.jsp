<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.LinkedHashMap"%>
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

	<jsp:include page="menu.jsp" />

	<form method="post" action="<c:url value='Search'/>">
		<input id="searchStringBox" name="searchString" value="${param.searchString}">
		<input id="filterButton" type="submit" value="Filtreeri">
	</form>
	<br>
	<br>
	<jsp:include page="table.jsp">
		<jsp:param name="rowsKeyAsParam" value="unitList" />
	</jsp:include>

	<%-- 
	<c:forEach items="${requestScope.unitList}" var="each">
		<div class="listTable">${each.name}.${each.code}</div>
	</c:forEach>
	--%>

</body>
</html>