package br.com.atallsolutions.sistemademonstracao.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.atallsolutions.sistemademonstracao.dao.UsuarioDAO;

public class VerificaEmail {
	;

	public boolean emailEhValido(Usuario usuario, List<Usuario> listaUsuarios) {

		for (Usuario usuarios : listaUsuarios) {
			String email = usuarios.getEmail();
			if (usuario.getEmail().equals(email)) {
				return false;
			}
		}
		return true;

	}

}
