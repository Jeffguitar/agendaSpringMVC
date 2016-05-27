<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de contatos Spring</title>
</head>
<body>

	<h1>Listagem de Contato</h1>
	<div>${sucesso }</div>
	<fieldset>
		<table>
			<tr>
				<td>Nome</td>
				<td>Número</td>
			</tr>
			<c:forEach items="${contatos }" var="contato">
				<tr>
					<td>${contato.nome }</td>
					<td>${contato.numero }</td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>

</body>
</html>