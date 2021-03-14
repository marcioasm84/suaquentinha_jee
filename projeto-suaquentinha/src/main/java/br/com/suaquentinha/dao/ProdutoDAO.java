package br.com.suaquentinha.dao;

import java.util.List;

import javax.ejb.Stateless;
import br.com.suaquentinha.vo.Produto;

@Stateless
public class ProdutoDAO extends GenericDAO<Produto, Long>{
	
	public List<Produto> listar() {		
		return entityManager.createQuery("select o from Produto o", Produto.class).getResultList();
	}
	
	public void remover(Produto produto) {
		Produto entity = entityManager.find(Produto.class, produto.getId());
		Produto mergedEntity = entityManager.merge(entity);
		entityManager.remove(mergedEntity);
		entityManager.flush();
	}
	
	public Produto obter(Long id) {
		return entityManager.find(Produto.class, id);
	}
}
