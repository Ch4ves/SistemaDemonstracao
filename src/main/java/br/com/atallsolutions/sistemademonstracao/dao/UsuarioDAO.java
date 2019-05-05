package br.com.atallsolutions.sistemademonstracao.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.atallsolutions.sistemademonstracao.model.Usuario;

@Repository
@Transactional
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager manager;
	

	public void salvar(Usuario Usuario) {
		manager.persist(Usuario);
	}

	public List<Usuario> listaUsuarios() {
		return manager.createQuery("select u from Usuario u", Usuario.class).getResultList();
	}

	public Usuario find(Integer id) {

		return manager.find(Usuario.class, id);

	}

	public void delete(Usuario usuario) {
		manager.remove(usuario);
	}

	

}
