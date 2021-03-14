package br.com.suaquentinha.dao;

import java.util.List;

import javax.ejb.Stateless;

import br.com.suaquentinha.vo.Cliente;
import br.com.suaquentinha.vo.Venda;

@Stateless
public class VendaDAO extends GenericDAO<Venda, Long>{

	public List<Venda> listar() {		
		return entityManager.createQuery("select o from Venda o", Venda.class).getResultList();
	}
	
	public Venda obter(Long id) {
		return entityManager.find(Venda.class, id);
	}
	
	public void remover(Long id) {
		Venda entity = entityManager.find(Venda.class, id);		
		Venda mergedEntity = entityManager.merge(entity);
		entityManager.remove(mergedEntity);
		entityManager.flush();
	}
}
