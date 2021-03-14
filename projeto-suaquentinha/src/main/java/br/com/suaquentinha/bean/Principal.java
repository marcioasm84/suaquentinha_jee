package br.com.suaquentinha.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Principal {
	
	public String irParaInicio() {
		System.out.println("irParaInicio");
		return "index?faces-redirect=true";
	}
	public String irParaCadastroProduto() {
		System.out.println("irParaCadastroProduto");
		return "produto?faces-redirect=true";
	}
	
	public String irParaCadastroCliente() {
		System.out.println("irParaCadastroCliente");
		return "cliente?faces-redirect=true";
	}
	
	public String irParaCadastroVenda() {
		System.out.println("irParaCadastroVenda");
		return "venda?faces-redirect=true";
	}
}
