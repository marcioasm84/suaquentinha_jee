package br.com.suaquentinha.bean.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.suaquentinha.servico.ClienteServico;
import br.com.suaquentinha.vo.Cliente;

@FacesConverter("clienteConversor")
public class ClienteConversor implements Converter<Cliente> {

	@Inject
	private ClienteServico clienteServico;
	
	@Override
	public Cliente getAsObject(FacesContext context, UIComponent component, String value) {
		Long id = Long.parseLong(value);
		Cliente c = clienteServico.obter(id);
		System.out.println("id = " + id + " Cliente: " + c.getNome());
		return c;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Cliente value) {
		return value.getId().toString();
	}

}
