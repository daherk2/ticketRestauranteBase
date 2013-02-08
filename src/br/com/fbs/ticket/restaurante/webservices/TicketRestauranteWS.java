package br.com.fbs.ticket.restaurante.webservices;

import br.com.fbs.json.JsonUtil;
import br.com.fbs.ticket.restaurante.model.TicketRestaurante;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class TicketRestauranteWS {

	// constantes
	private final String HOST_URL = "http://www.ticket.com.br/ticket-corporativo-web/ticket-consultcard";

	private Client client;

	/**
	 * Construtor simples, inicia o client do jersey
	 * 
	 */
	public TicketRestauranteWS() {
		client = new Client();
		client.addFilter(new ClientFilterMaxRetries());
	}

	/**
	 * Metodo consulta o ws do ticket pelo numero do cartao e retorna um objeto
	 * TicketRestaurante onde contem o saldo *
	 * 
	 * @param cardNumber
	 *            numero do ticket
	 * 
	 * @return TicketRestaurante
	 */
	public TicketRestaurante consultaSaldo(String cardNumber) {
		WebResource resource = client.resource(this.HOST_URL)
				.queryParam("chkProduto", "Ticket+Restaurante")
				.queryParam("txtNumeroCartao", cardNumber)
				.queryParam("txtOperacao", "saldo_agendamentos");
		String json = resource.get(String.class);
		System.out.println(json);
		Gson gson = JsonUtil.getGson();
		TicketRestaurante ticket = gson.fromJson(json, TicketRestaurante.class);
		return ticket;
	}

	/**
	 * Metodo consulta o ws do ticket pelo numero do cartao e retorna um objeto
	 * TicketRestaurante onde contem uma lista com os ultimos lancamentos
	 * 
	 * @param cardNumber
	 *            numero do ticket
	 * 
	 * @return TicketRestaurante
	 */
	public TicketRestaurante consultaUltimosLancamentos(String cardNumber) {
		WebResource resource = client.resource(this.HOST_URL)
				.queryParam("txtNumeroCartao", cardNumber)
				.queryParam("txtOperacao", "lancamentos");

		String json = resource.get(String.class);
		Gson gson = JsonUtil.getGson();
		TicketRestaurante ticket = gson.fromJson(json, TicketRestaurante.class);
		return ticket;
	}
}
