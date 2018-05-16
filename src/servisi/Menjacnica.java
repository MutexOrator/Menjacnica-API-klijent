package servisi;


import java.util.LinkedList;

import domen.Drzava;
import sistemske_operacije.SOFill;
import sistemske_operacije.SOVratiKurs;


public class Menjacnica {
	public static final String COUNTRY_API_URL  = "http://free.currencyconverterapi.com/api/v3/countries";
	public static final String CONVERT_API_URL  = "http://free.currencyconverterapi.com/api/v3/convert?q=";
	public static LinkedList<Drzava> drzava = new LinkedList<Drzava>();
	
	public double vratiKurs(String v1, String v2) throws Exception {
	return SOVratiKurs.izvrsi(v1, v2, CONVERT_API_URL);
	}
	
	public void fill() throws Exception {
		SOFill.izvrsi(COUNTRY_API_URL, drzava);
	}
	
	
}
