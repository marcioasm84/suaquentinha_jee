package br.com.suaquentinha.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Entity
public class Venda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date dataVenda;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "venda_produto",
		joinColumns = @JoinColumn(name="venda_id"),
		inverseJoinColumns = @JoinColumn( name="produto_id" )
	)
	private List<Produto> produtos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}	
	
	public String toString() {
		String prod = "";
		
		for(Produto p : this.getProdutos()) {
			prod += p.getId() + "-"+p.getNome() + ", ";
		}
		
		
        return "Venda: " + this.getId() + " - Produtos: " + prod;
    }
	
}
