package br.com.atallsolutions.sistemademonstracao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.atallsolutions.sistemademonstracao.dao.UsuarioDAO;
import br.com.atallsolutions.sistemademonstracao.model.Usuario;
import br.com.atallsolutions.sistemademonstracao.model.VerificaEmail;

@Controller
public class CadastroController {

	@Autowired
	private UsuarioDAO dao;

	@RequestMapping(value = { "/", "/cadastro" }, method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("cadastro");

	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public ModelAndView salvar(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("endereco") String endereco, @RequestParam("telefone") String telefone,
			@RequestParam(value = "sexo", required = false) String sexo,
			@RequestParam(value = "newsletter", required = false) String newsletter, RedirectAttributes redirectAttrs) {

		int newsletterstatus = 0;
		if (!(newsletter == null)) {
			newsletterstatus = 1;
		}

		Sexo sex = Sexo.valueOf(sexo.toUpperCase());

		Usuario usuario = new Usuario(nome, email, endereco, telefone, sex, Integer.toString(newsletterstatus));
		VerificaEmail verificarEmail = new VerificaEmail();
		List<Usuario> listaUsuarios = dao.listaUsuarios();

		if (id != null) {
			Usuario updateUsuario = dao.find(id);
			updateUsuario.setId(id);
			updateUsuario.setNome(nome);
			updateUsuario.setEmail(email);
			updateUsuario.setendereco(endereco);
			updateUsuario.setTelefone(telefone);
			updateUsuario.setSexo(sex);
			updateUsuario.setNewsletter(Integer.toString(newsletterstatus));
			dao.salvar(updateUsuario);
			redirectAttrs.addFlashAttribute("sucesso", "Usuário editado com sucesso!");
			return new ModelAndView("redirect:cadastro");

		} else if (verificarEmail.emailEhValido(usuario, listaUsuarios)) {

			dao.salvar(usuario);
			redirectAttrs.addFlashAttribute("sucesso", "Usuário Cadastrado com sucesso!");
			return new ModelAndView("redirect:cadastro");
		}

		redirectAttrs.addFlashAttribute("semsucesso", "Email já cadastrado");

		return new ModelAndView("redirect:cadastro");
	}

	@RequestMapping(value = "/pesquisa", method = RequestMethod.GET)
	public ModelAndView usuarioLista(Model model) {
		List<Usuario> usuarios = dao.listaUsuarios();
		model.addAttribute("usuarios", usuarios);

		return new ModelAndView("pesquisa");

	}

	@RequestMapping(value = "/edit/{id}")
	public ModelAndView detalhe(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("/cadastro");
		Usuario usuario = dao.find(id);
		modelAndView.addObject("usuario", usuario);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView atualizar(@PathVariable("id") Integer id, @RequestParam("nome") String nome,
			@RequestParam("email") String email, @RequestParam("endereco") String endereco,
			@RequestParam("telefone") String telefone, @RequestParam(value = "sexo", required = false) String sexo,
			@RequestParam(value = "newsletter", required = false) String newsletter, Model model) {

		ModelAndView modelAndView = new ModelAndView("/cadastro");

		int newsletterstatus = 0;
		if (!(newsletter == null)) {
			newsletterstatus = 1;
		}

		Sexo sex = Sexo.valueOf(sexo.toUpperCase());

		Usuario usuario = dao.find(id);

		modelAndView.addObject("usuario", usuario);
		model.addAttribute("id", id);
		model.addAttribute("email", email);
		model.addAttribute("endereco", endereco);
		model.addAttribute("telefone", telefone);
		model.addAttribute("sex", sex);
		model.addAttribute("newsletter", newsletter);

		return modelAndView;
	}

}
