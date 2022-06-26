<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Usuários</title>
</head>
<body>


	<h1>Lista de Usuários</h1>

	<a href="formCadastro.html">
		<button>Cadastrar Usuário</button>
	</a>
	<br>
	<br>

	<c:if test="${not empty usuarios }">
		<table border="1" style="width: 70%">
			<thead>
				<tr style="background-color: black; color: white">
					<th>Código</th>
					<th>Nome</th>
					<th>Data Nascimento</th>
					<th>Login</th>
					<th>Senha</th>
					<th colspan="2">Ação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${usuarios }">
					<tr>
						<td>${usuario.codigo}</td>
						<td>${usuario.nome}</td>
						<td><fmt:formatDate value="${usuario.dataNascimento}"
								pattern="dd/MM/yyyy" /></td>
						<td>${usuario.login}</td>
						<td>${usuario.senha}</td>
						<td><a href="alterar?codigo=${usuario.codigo}">Alterar</a></td>
						<td><a href="excluir?codigo=${usuario.codigo}">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${empty usuarios }">
		<h1>Nenhum usuário cadastrado!</h1>
	</c:if>
</body>
</html>