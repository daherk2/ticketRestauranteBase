package br.com.fbs.ticket.restaurante.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe de Retorno da consulta do Ws do Ticket Restaurante
 * 
 * @author rvidal
 *
 */
@XmlRootElement
public class TicketRestaurante {

	private boolean status;
	private String url;
	private String type;
	private String messageError;
	private String nextStep;
	private String erros;
	private String cardNumber;
	private Date consultDate;
	private String seeBalance;
	private String token;
	private List<TicketRestauranteSchedulings> schedulings;
	private List<TicketRestauranteReleases> releases;

	public TicketRestaurante(){
		
	}
	
	public TicketRestaurante(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

	public String getNextStep() {
		return nextStep;
	}

	public void setNextStep(String nextStep) {
		this.nextStep = nextStep;
	}

	public String getErros() {
		return erros;
	}

	public void setErros(String erros) {
		this.erros = erros;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getConsultDate() {
		return consultDate;
	}

	public void setConsultDate(Date consultDate) {
		this.consultDate = consultDate;
	}

	public double getSeeBalance() {
		Double valor = 0.0;
		try{
			valor = Double.parseDouble(seeBalance.replace(",","."));
		}catch(Exception e){
			valor = 0.0;
		}
		
		return valor;
	}

	public void setSeeBalance(String seeBalance) {
			this.seeBalance = seeBalance;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<TicketRestauranteReleases> getReleases() {
		return releases;
	}

	public void setReleases(List<TicketRestauranteReleases> releases) {
		this.releases = releases;
	}

	
	public List<TicketRestauranteSchedulings> getSchedulings() {
		return schedulings;
	}

	public void setSchedulings(List<TicketRestauranteSchedulings> schedulings) {
		this.schedulings = schedulings;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cardNumber == null) ? 0 : cardNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketRestaurante other = (TicketRestaurante) obj;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TicketRestaurante [status=" + status + ", url=" + url
				+ ", type=" + type + ", messageError=" + messageError
				+ ", nextStep=" + nextStep + ", erros=" + erros
				+ ", cardNumber=" + cardNumber + ", consultDate=" + consultDate
				+ ", seeBalance=" + seeBalance + ", token=" + token
				+ ", schedulings=" + schedulings
				+ ", releases=" + releases + "]";
	}

}
