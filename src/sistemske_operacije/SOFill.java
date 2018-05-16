package sistemske_operacije;


import java.util.LinkedList;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import domen.Drzava;
import utility.KursUtility;

public class SOFill {
	public static void izvrsi(String COUNTRY_API_URL, LinkedList<Drzava> drzava ) throws Exception {
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	JsonObject o=gson.fromJson(KursUtility.getContent(COUNTRY_API_URL), JsonObject.class);
	JsonObject jo = o.get("results").getAsJsonObject();
	for (Map.Entry<String, JsonElement> entry : jo.entrySet()) {
		Drzava drz = gson.fromJson(entry.getValue(), Drzava.class);
		drzava.add(drz);
	}
	}
}
