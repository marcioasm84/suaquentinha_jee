package br.com.suaquentinha.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.suaquentinha.dao.ClienteDAO;
import br.com.suaquentinha.vo.Cliente;

@Stateless
public class ClienteServico {

	@Inject
	private ClienteDAO clienteDao;
	
	public void salvar(Cliente cliente) {		
		if( cliente.getId() == null) {
			clienteDao.salvar(cliente);		
		} else {
			clienteDao.atualizar(cliente);
		}
	}
	
	public List<Cliente> listar() {
		return clienteDao.listar();
	}
	
	public Cliente obter(Long id) {		
		return clienteDao.obter(id);
	}
	
	public void remover(Cliente cliente) {
		clienteDao.remover(cliente);
	}
}
