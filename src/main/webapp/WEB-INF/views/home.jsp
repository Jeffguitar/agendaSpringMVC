<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<link href="resources/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agenda de contatos Spring</title>
</head>
<body>

	<h1>Agenda Spring, bem-vindo!</h1>
	<br> Qual ação você deseja realizar?
	<br>
	<img src="resources/images/meucore.png" />
	<br>

	<form action="adicionaContato.do">
		<button type="submit">Adicionar Contato</button>
	</form>

	<form action="alteraContato.do">
		<button type="submit">Alterar Contato</button>
	</form>

	<form action="listaContato.do">
		<button type="submit">Listar Contato</button>
	</form>

	<form action="removeContato.do">
		<button type="submit">Remover Contato</button>
	</form>

</body>
</html>
