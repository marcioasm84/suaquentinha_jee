package br.com.suaquentinha.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.suaquentinha.servico.ProdutoServico;
import br.com.suaquentinha.vo.Produto;

@ManagedBean
public class ProdutoBean {

	private Produto produto = new Produto();
	
	@Inject
	private ProdutoServico produtoServico;
	
	public String gravar() {
		produtoServico.salvar(produto);
		produto = new Produto();
		return "produto";
	}
	
	public List<Produto> getListaProdutos() {
		return produtoServico.listar();
	}
	
	public void carregar(Produto produto) {
		System.out.println("Carregando produto para edicao " + produto.getNome());
		this.produto = produto;
	}
	
	public String remover(Produto produto) {
		produtoServico.remover(produto);
		return "produto?faces-redirect=true";
	}
	
	//Getters and Setters	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
