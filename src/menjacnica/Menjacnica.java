package menjacnica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class Menjacnica {
	public static final String COUNTRY_API_URL  = "http://free.currencyconverterapi.com/api/v3/countries";
	public static LinkedList<Drzava> d = new LinkedList<Drzava>();
	
	public static void fill() throws Exception {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonObject o=gson.fromJson(getContent(COUNTRY_API_URL), JsonObject.class);
		JsonObject jo = o.get("results").getAsJsonObject();
		for (Map.Entry<String, JsonElement> entry : jo.entrySet()) {
			Drzava drz = gson.fromJson(entry.getValue(), Drzava.class);
			d.add(drz);
		}
	}
	public static String getContent(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		con.setRequestMethod("GET");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		boolean endReading = false;
		String response = "";
		
		while (!endReading) {
			String s = in.readLine();
			
			if (s != null) {
				response += s;
			} else {
				endReading = true;
			}
		}
		in.close();
 
		return response.toString();
	}
	
}
