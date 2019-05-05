var btnSalvar = document.querySelector("#button");
var radio = document.getElementsByName("sexo");

btnSalvar.addEventListener("click", function(event) {
	event.preventDefault();

	var form = document.getElementById("formUsuario");
	var usuario = obtemUsuario(form);

	var erros = validaUsuario(usuario);

	if (erros.length > 0) {
		exibeMensagensDeErro(erros);

		return;
	}

	var mensagensErro = document.querySelector("#mensagens-erro");
	mensagensErro.innerHTML = "";

	if (erros.length == 0) {
		form.submit();
	}

});

function selecionouRadio(radio) {

	for (var i = 0, len = radio.length; i < len; i++) {
		if (radio[i].checked) {
			return true;
		}
	}

	return false;
}

function obtemUsuario(form) {
	var usuario = {
		nome : form.nome.value,
		email : form.email.value,
		endereco : form.endereco.value,
		telefone : form.telefone.value,
	}
	return usuario;
}

function exibeMensagensDeErro(erros) {
	var ul = document.querySelector("#mensagens-erro");
	ul.innerHTML = "";

	erros.forEach(function(erro) {
		var li = document.createElement("li");
		li.textContent = erro;
		ul.appendChild(li);
	});
}

function emailEhValido(email) {

	return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}

function validaUsuario(usuario) {

	var erros = [];

	if (usuario.nome.length == 0) {
		erros.push("O nome não pode ser em branco");
	}

	if (usuario.email.length == 0) {
		erros.push("O E-mail não pode ser em branco");
	}

	if (usuario.endereco.length == 0) {
		erros.push("O endereco não pode ser em branco");
	}

	if (usuario.telefone.length == 0 || usuario.telefone.length < 11) {
		erros
				.push("O telefone não pode ser em branco ou ter menos de 11 digitos");
	}

	if (!selecionouRadio(radio)) {
		erros.push("Selecione o sexo");
	}

	if (!emailEhValido(usuario.email)) {
		erros.push("E-mail invalido");
	}

	return erros;
}