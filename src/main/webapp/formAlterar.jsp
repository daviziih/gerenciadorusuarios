<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.turma.modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Usuários</title>
</head>
<body>


	<h1>Alteração dos Dados do Usuário</h1>

	<form method="post" action="alterar">

		Codigo: <input type="text" name="txtcodigo" value="${usuario.codigo}" readonly > <br> <br>
		Nome: <input type="text" name="txtnome" value="${usuario.nome}" required autocomplete="off"> <br> <br>
		Data de Nascimento: <input type="date"
			name="txtdatanascimento"
			value=<fmt:formatDate value="${usuario.dataNascimento}" pattern="yyyy-MM-dd"/>
			required autocomplete="off"> <br> <br>
			
	    Login: <input type="text" name="txtlogin" value="${usuario.login}" required autocomplete="off"> <br> <br> 
		Senha: <input type="password" name="txtsenha" value="${usuario.senha}" required autocomplete="off"><br> <br>
		
		<input type="submit" value="Salvar"><br> <br>

	</form>

</body>
</html>