package br.com.suaquentinha.dao;

import java.util.List;

import javax.ejb.Stateless;

import br.com.suaquentinha.vo.Cliente;

@Stateless
public class ClienteDAO extends GenericDAO<Cliente, Long> {

	public List<Cliente> listar() {		
		return entityManager.createQuery("select o from Cliente o", Cliente.class).getResultList();
	}
	
	public void remover(Cliente cliente) {
		System.out.println("Removendo cliente do DAO " + cliente.getId());
		Cliente entity = entityManager.find(Cliente.class, cliente.getId());		
		Cliente mergedEntity = entityManager.merge(entity);
		entityManager.remove(mergedEntity);
		entityManager.flush();
	}
	
	public Cliente obter(Long id) {
		return entityManager.find(Cliente.class, id);
	}
}
