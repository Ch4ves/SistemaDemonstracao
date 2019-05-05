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
<link rel="stylesheet" href="../css/pesquisa.css">
</head>
<body>

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

			<div style="float:left; width:85%;text-align:left;">
            
            	<h2>Pesquisa De Clientes</h2>

				<label for="filtrar-tabela">Filtro por Nome:</label> <input
					type="text" name="filtro" id="filtrar-tabela"
					placeholder="Digite o nome do usuario"> <label
					for="filtrar-email">Filtro por Email:</label> <input type="text"
					name="filtro" id="filtrar-email" placeholder="Filtre por E-mail">


				<table width="100%">
					<tr class="th">
						<th>Nome</th>
						<th>E-mail</th>
						<th>Telefone</th>
						<th>Ações</th>
					</tr>

					<c:forEach items="${usuarios }" var="usuario">
						<tbody id="tabela-usuarios">
							<tr class="usuario">
								<td class="info-nome">${usuario.nome }</td>
								<td class="info-email">${usuario.email }</td>
								<td>${usuario.telefone }</td>
								<td><a
									href="${s:mvcUrl('CC#detalhe').arg(0, usuario.id).build() }">Editar</a></td>
							</tr>
					</c:forEach>
					</tbody>
				</table>
				<span id="erro-ajax" class="invisivel">Erro ao Filtrar
					Usuários</span>
			</div>
		</div>
	</section>


</body>
<script src="../js/filtro.js"></script>
</html>