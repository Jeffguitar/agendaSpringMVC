package br.com.spring.agenda.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.spring.agenda.daos.AgendaDAO;
import br.com.spring.agenda.models.Contato;
import br.com.spring.agenda.validation.ContatoValidation;

//é possível anotar a classe inteira utilizando o RequestMapping tbm
@Controller
public class AgendaController {

	// pedir para o Spring injetar o dao
	@Autowired
	private AgendaDAO agendaDao;

	// anotação do Spring
	@InitBinder
	// método para fazer o bind entre as validações
	public void InitBinder(WebDataBinder binder) {
		binder.addValidators(new ContatoValidation());
	}

	// Recebendo dados do menu 'AdicionaContato'
	@RequestMapping(value = "/adicionaContato.do")
	public ModelAndView formAdicionarContato() {

		return new ModelAndView("agenda/formAdicionar");
	}

	// Recebendo dados do formulario do contato
	@RequestMapping(value = "/adicionarNaAgenda.do")
	// anotação de validação do Spring
	public ModelAndView gravar(@Valid Contato contato, BindingResult result, RedirectAttributes redirectAttributes) {

		// verificação para saber se houve erro
		if (result.hasErrors()) {
			// se houver, retorna para o formulário
			return formAdicionarContato();
		}
		agendaDao.gravar(contato);

		// escopo curto que dura de um request até outro
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
		// redirect para a listagem (o redirect utilizar o GET)
		return new ModelAndView("redirect:/listaContato.do");
	}

	// Recebendo parametro da homer (botão Listar)
	@RequestMapping(value = "/listaContato.do", method = RequestMethod.GET)
	public ModelAndView listarContato() {

		List<Contato> contatos = agendaDao.listar();
		ModelAndView modelAndView = new ModelAndView("agenda/listar");
		modelAndView.addObject("contatos", contatos);

		return modelAndView;
	}

	@RequestMapping("/alteraContato.do")
	public String alterarContato() {
		System.out.println("TELA ALTERAR CONTAT");
		return "agenda/alterar";
	}

	@RequestMapping("/removeContato.do")
	public String removerContato() {
		System.out.println("TELA REMOVER CONTATO");
		return "agenda/remover";
	}

}
