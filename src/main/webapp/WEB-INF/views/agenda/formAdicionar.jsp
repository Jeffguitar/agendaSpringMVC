<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Agenda de contatos Spring</title>
</head>
<body>

	<h1>Adicionar Contato</h1>
	<fieldset>
		<form action="adicionarNaAgenda.do" method="POST">
			<div>
				<label>Primeiro nome: </label><input type="text"
					placeholder="informe o nome" name="nome"> <br>
			</div>
			<div>
				<label> Número: </label><input type="text"
					placeholder="informe o número" name="numero"> <br> <input
					type="submit" value="Enviar">
			</div>
		</form>
	</fieldset>
</body>
</html>