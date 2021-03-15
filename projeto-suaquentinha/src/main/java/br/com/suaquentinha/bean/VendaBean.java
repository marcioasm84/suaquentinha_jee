package br.com.suaquentinha.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.suaquentinha.servico.ClienteServico;
import br.com.suaquentinha.servico.ProdutoServico;
import br.com.suaquentinha.servico.VendaServico;
import br.com.suaquentinha.vo.Cliente;
import br.com.suaquentinha.vo.Produto;
import br.com.suaquentinha.vo.Venda;

@ManagedBean
@ViewScoped
public class VendaBean {
	
	private Venda venda = new Venda();
	private Long clienteId;
	private Long produtoId;

	@Inject
	private VendaServico vendaServico;
	
	@Inject
	private ClienteServico clienteServico;
	
	@Inject
	private ProdutoServico produtoServico;
		
	public VendaBean() {
		venda.setCliente(new Cliente());
		venda.setProdutos(new ArrayList<Produto>());
	}
	
	public String gravar() {
		System.out.println("Gravando Venda " + venda.getDataVenda() + " clienteId = " + clienteId);
		
		Cliente c = clienteServico.obter(clienteId);
		venda.setCliente(c);
		
		System.out.println("Buscando o cliente " + venda.getCliente().getNome());
		
		System.out.println("VENDA A GRAVAR " + venda);
		
		
		vendaServico.salvar(venda);
		/*
		venda = new Venda();
		venda.setCliente(new Cliente());
		venda.setProdutos(new ArrayList<Produto>());
		*/
		return "venda?faces-redirect=true";
	}
	
	public String novo() {		
		venda = new Venda();
		venda.setCliente(new Cliente());
		venda.setProdutos(new ArrayList<Produto>());
		return "venda?faces-redirect=true";
	}
	
	public void carregar(Venda venda) {
		this.venda = venda;		
		this.clienteId = venda.getCliente().getId();
		//this.venda.getProdutos().size();
	}
	
	public String remover(Venda venda) {
		vendaServico.remover(venda);
		return "venda?faces-redirect=true";
	}
	
	public void inserirProduto(Venda venda) {
		System.out.println("Inserindo um produto na venda - Produto : " + produtoId);		
		Produto produto = produtoServico.obter(produtoId);		
		System.out.println("Produto encontrado: " + produto.getNome() + " - " + produto.getPreco());
		
		this.venda = venda;
		this.venda.getProdutos().add(produto);
	}
	
	public List<Venda> getListaVendas() {
		return vendaServico.listar();
	}

	public List<Cliente> getListaClientes() {
		return clienteServico.listar();
	}
	
	public List<Produto> getListaProdutos() {
		return produtoServico.listar();
	}
	
	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}
}
