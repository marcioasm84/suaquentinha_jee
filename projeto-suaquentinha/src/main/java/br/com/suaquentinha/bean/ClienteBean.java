package br.com.suaquentinha.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.suaquentinha.servico.ClienteServico;
import br.com.suaquentinha.vo.Cliente;

@ManagedBean
public class ClienteBean {

	private Cliente cliente = new Cliente();

	@Inject
	private ClienteServico clienteServico;

	public String gravar() {
		clienteServico.salvar(cliente);
		cliente = new Cliente();
		return "cliente";
	}
	
	public List<Cliente> getListaClientes() {
		return clienteServico.listar();
	}
		
	public void carregar(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String remover(Cliente cliente) {
		clienteServico.remover(cliente);
		return "cliente";
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
