package br.com.fbs.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Classe responsável por utilidades com json utilizando Gson
 * 
 * @author rvidal
 * 
 */
public class JsonUtil {

	private static Gson gson;

	static {
		gson = new GsonBuilder()
		.setDateFormat("dd/MM/yyyy")
		.setPrettyPrinting()		
		.create();
	}

	/**
	 * Metodo retorna instância configurada do Gson
	 * 
	 * @return Gson
	 */
	public static Gson getGson() {
		return gson;
	}
}
