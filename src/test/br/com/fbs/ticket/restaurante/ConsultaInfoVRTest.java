/**
 * 
 */
package test.br.com.fbs.ticket.restaurante;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.fbs.ticket.restaurante.model.TicketRestaurante;
import br.com.fbs.ticket.restaurante.webservices.TicketRestauranteWS;

/**
 * Classe de Teste para consultas do VR
 * 
 * @author rvidal
 * 
 */
public class ConsultaInfoVRTest {

	private static final String CARD_NUMBER = "coloque o numero do cartao";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	/**
	 * Deve consultar o saldo do ticket
	 */
	@Test
	public void deveConsultarSaldoVR() {		
		TicketRestauranteWS ws = new TicketRestauranteWS();
		TicketRestaurante retorno = ws.consultaSaldo(CARD_NUMBER);	
		assertTrue(retorno.getCardNumber().equals(CARD_NUMBER) && retorno.getSeeBalance() > 0);
		System.out.println("Cartao n:" + retorno.getCardNumber() +" saldo � de :" + retorno.getSeeBalance()  );
	}
	
	/**
	 * Deve consultar a lista de Compras
	 */
	@Test
	public void deveConsultarUltimasComprasVR(){
		TicketRestauranteWS ws = new TicketRestauranteWS();
		TicketRestaurante retorno = ws.consultaUltimosLancamentos(CARD_NUMBER);		
		assertNotNull(retorno.getReleases());
		assertTrue(retorno.getReleases().size() > 0);
		System.out.println("Cartao n:" + retorno.getCardNumber() +" ultimos lancamentos :" + retorno.getReleases());
	}
	
	
}
