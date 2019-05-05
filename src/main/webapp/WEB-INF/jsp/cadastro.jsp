<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema Demonstração</title>

<link rel="stylesheet" href="../css/cadastro.css">
</head>

<body>

	<div>${sucesso }</div>
	<div>${semsucesso }</div>


	<h1>Sistema Demonstração</h1>

	<hr>

	<section class="container">
		<div>
			<div style="float:left; width:15%;">
				<aside class="menu-lateral">
					<h2>Menu</h2>
					<nav>
						<ul>
							<li><a href="/">Cadastro</a></li>
							<li><a href="../pesquisa">Pesquisa</a></li>
						</ul>
					</nav>
				</aside>
			</div>
			
			<div style="float:left; width:85%; text-align:left;">

				<h2>Cadastro De Clientes</h2>

				<form id="formUsuario" action="/cadastro" method="POST">

					<table width="100%">
							<input type="hidden" value="${usuario.id}" name="id" name="id" />
					<tr> <td>
							<label>Nome:</label></td><td> <input type="text" name="nome" id="nome" size="50" maxlength="100"
								value="${usuario.nome }"></td>
						</tr>
						<tr><td>
							<label>E-mail:</label></td><td> <input type="email" name="email"
								id="email" placeholder="email@mail.com" size="50" maxlength="100"
								pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
								value="${usuario.email }" /></td>
						</tr>
						<tr><td>
							<label>Endereço:</label></td><td> <input type="text" name="endereco"
								id="endereco" size="50" maxlength="100" value="${usuario.endereco }" /></td>
						</tr>
						<tr><td>
							<label>Telefone:</label></td><td> <input type="tel" name="telefone"
								id="telefone" size="15" maxlength="13" placeholder="(11)1111-5555" maxlength="11"
								value="${usuario.telefone }" /></td>
						</tr>
						<tr><td>
							<label class="radio-label">Sexo:</label></td><td>
							<div class="radio-button">
								<input type="radio" name="sexo" value="MASCULINO" id="sexo"
									class="radio">masculino<br> <input type="radio"
									name="sexo" value="FEMININO" id="sexo" class="radio">
								feminino<br>
							</div>
                            </td>
						</tr>
						<tr><td>
							<label>Newsletter:</label></td><td> <input type="checkbox"
								name="newsletter" value="Newsletter" id="newsletter">Sim<br></td>
						</tr>
					</table>
					<input class="button" id="button" type="submit" value="Salvar" />

				</form>

				<ul id="mensagens-erro"></ul>
			</div>
		</div>
	</section>
</body>

<script src="../js/validador.js"></script>
</html>