<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<ul id="menu">
		<li>
    		<a id="menu_Search" href="<c:url value='Search'/>">Otsi</a>
    	</li>
    	<li>
    		<a id="menu_Add" href="<c:url value='Add'/>">Lisa</a>
    	</li>
    	<li>
    		<a id="menu_ClearData" href="<c:url value='Admin'/>?do=clear_data">Tühjenda</a>
    	</li>
    	<li>
    		<a id="menu_InsertData" href="<c:url value='Admin'/>?do=insert_data">Sisesta näidisandmed</a>
    	</li>
	</ul>
	<br>
	<br>
	<br>

</body>
</html>