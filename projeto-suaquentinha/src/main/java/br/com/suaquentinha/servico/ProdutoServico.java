package br.com.suaquentinha.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.suaquentinha.dao.ProdutoDAO;
import br.com.suaquentinha.vo.Cliente;
import br.com.suaquentinha.vo.Produto;

@Stateless
public class ProdutoServico {

	@Inject
	private ProdutoDAO produtoDAO;
	
	public void salvar(Produto produto) {
		if(produto.getId() == null) {
			produtoDAO.salvar(produto);
		} else {
			produtoDAO.atualizar(produto);
		}
	}
	
	public List<Produto> listar() {
		return produtoDAO.listar();
	}
	
	public Produto obter(Long id) {
		return produtoDAO.obter(id);
	}
	
	public void remover(Produto produto) {
		produtoDAO.remover(produto);
	}
}
