package sistemske_operacije;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;


import utility.KursUtility;

public class SOVratiKurs {
	public static double izvrsi(String v1, String v2, String CONVERT_API_URL) throws Exception {
		String s = CONVERT_API_URL + v1 + "_" + v2;
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonObject o = gson.fromJson(KursUtility.getContent(s), JsonObject.class);
		if(((JsonObject) o.get("query")).get("count").getAsInt() == 0) {
			return -1;
		}
		double val = ((JsonObject) ((JsonObject) o.get("results")).get(v1+"_"+v2)).get("val").getAsDouble();
		return val;
		
	}
}
