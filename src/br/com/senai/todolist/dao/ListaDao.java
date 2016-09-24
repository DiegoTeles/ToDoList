package br.com.senai.todolist.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import br.com.senai.todolist.modelo.Lista;

@Repository
public class ListaDao {
	@PersistenceContext
	private EntityManager manager;
	
	
	@Transactional
	public void inserir (Lista lista)
	{
		manager.persist(lista);
	}
	
	public List<Lista> listar(){
		TypedQuery<Lista> query = 
				manager.createQuery("select l from lista l", Lista.class);
		return query.getResultList();
 	}
}

