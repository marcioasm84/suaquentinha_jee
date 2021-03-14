package br.com.suaquentinha.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.suaquentinha.dao.VendaDAO;
import br.com.suaquentinha.vo.Venda;

@Stateless
public class VendaServico {

	@Inject
	private VendaDAO vendaDAO;
	
	public void salvar(Venda venda) {
		if(venda.getId() == null) {
			vendaDAO.salvar(venda);
		} else {
			vendaDAO.atualizar(venda);
		}
	}
	
	public List<Venda> listar() {
		return vendaDAO.listar();
	}
	
	public void remover(Venda venda) {
		vendaDAO.remover(venda.getId());
	}
}
