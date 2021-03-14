package br.com.suaquentinha.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.suaquentinha.servico.ClienteServico;
import br.com.suaquentinha.servico.VendaServico;
import br.com.suaquentinha.vo.Cliente;
import br.com.suaquentinha.vo.Produto;
import br.com.suaquentinha.vo.Venda;

@Path("teste")
public class SuaQuentinhaController {
	
	@Inject
	private VendaServico vendaServico;
	
	@Inject
	private ClienteServico clienteServico;

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response cadastrar() {
		
		Cliente c = clienteServico.obter(1L);
		System.out.println("Cliente obtido " + c.getId() + " Nome : " + c.getNome());
		
		/*
		Cliente c = new Cliente();
		c.setNome("Marcio");
		c.setEmail("masmstick@gmail.com");
		c.setEndereco("Av Jaime vieira lima");
		c.setTelefone("71 98888-8888");
		c.setCep("42700-000");
		
		Produto p = new Produto();
		p.setNome("Comida baiana");
		p.setPreco(15.00);
		
		Produto p2 = new Produto();
		p2.setNome("Refrigerante Coca-cola 2L");
		p2.setPreco(7.00);
		
		Venda venda = new Venda();
		venda.setDataVenda(LocalDateTime.now());
		venda.setCliente(c);
		venda.setProdutos(List.of(p, p2));
				
		vendaServico.salvar(venda);
		*/
		
		
		return Response.ok("").build();
	}
}
