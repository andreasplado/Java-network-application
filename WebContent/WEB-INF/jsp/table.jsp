<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>

<table id="listTable" class="listTable">
<thead>
<tr>
<th scope="col">Nimi</th>
<th scope="col">Kood</th>
<th scope="col"></th>
</tr>
</thead>
<tbody>
	<c:forEach var="each" items="${requestScope[param.rowsKeyAsParam]}">
    	<tr>
	    	<td>
				<div id="row_${each.code}">${each.name}</div>
			</td>
			<td> ${each.code} </td>
			<td>
				<a id="delete_${each.code}" href="<c:url value='Search'/>?do=delete&id=${each.id}">Kustuta</a>
			</td>
		</tr>
	</c:forEach>
</tbody>
</table>

</body>
</html>