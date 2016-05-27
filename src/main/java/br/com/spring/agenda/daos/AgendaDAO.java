package br.com.spring.agenda.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.spring.agenda.models.Contato;

//mapeia o Dao
@Repository
// O Spring vai cuidar das transações
@Transactional
public class AgendaDAO {

	// Gerenciamento do Spring
	@PersistenceContext
	// gerenciador das entidades
	private EntityManager manager;

	public void gravar(Contato contato) {
		manager.persist(contato);
	}

	public List<Contato> listar() {
		return manager.createQuery("SELECT p FROM Contato p", Contato.class).getResultList();
	}
}
