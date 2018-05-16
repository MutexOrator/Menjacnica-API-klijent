package menjacnica.gui.kontroler;

import java.awt.EventQueue;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import menjacnica.gui.MenjacnicaGUI;
import servisi.Menjacnica;




public class GUIKontroler {
	public static MenjacnicaGUI gui;
	public static Menjacnica menjacnica; 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menjacnica = new Menjacnica();
					menjacnica.fill();
					gui = new MenjacnicaGUI();
					gui.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static String konvertuj(String s1, String s2, String s3) throws Exception {
		String result = new String();
		try {
			Date d = new Date();
			SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss.SSSSSS");
			String date = simple.format(d);
			// System.out.println(date);
//			String s1 = comboBoxLevi.getSelectedItem().toString();
//			String s2 = comboBoxDesni.getSelectedItem().toString();
			String v1 = new String();
			String v2 = new String();
			for (int i = 0; i < Menjacnica.drzava.size(); i++) {
				if (s1.equals(Menjacnica.drzava.get(i).getName()))
					v1 = Menjacnica.drzava.get(i).getCurrencyId();
				if (s2.equals(Menjacnica.drzava.get(i).getName()))
					v2 = Menjacnica.drzava.get(i).getCurrencyId();
			}
			Double val = Double.parseDouble(s3);
			Double r = menjacnica.vratiKurs(v1, v2);
			if (r == -1) {
				JOptionPane.showMessageDialog(null, "Ne postoje rezultati za zadate valute", "Greska",
						JOptionPane.ERROR_MESSAGE);
			}
			String zaSer = "{" + "\"datumVreme\"" + ":" + "\"" + date + "\"" + "," + "\"izValuta\"" + ":" + "\"" + v1
					+ "\"" + "," + "\"uValuta\"" + ":" + "\"" + v2 + "\"" + "," + "\"kurs\"" + ":" + r + "}";
			serijal(zaSer);
			result = String.valueOf(val * r);
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null, "Unesite iznos za konverziju",
			 "Paznja", JOptionPane.INFORMATION_MESSAGE);
		}
		return result;
		
	}

	public static void serijal(String zaSer) throws Exception {
		JsonArray a = new JsonArray();
		a = deserijal();
		FileWriter writer = new FileWriter("data/log.json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonObject o = gson.fromJson(zaSer, JsonObject.class);
		
	
		if (a == null) {
			JsonArray b = new JsonArray();
			b.add(o);
			writer.write(gson.toJson(b));
			writer.close();
		} else {
			a.add(o);
			writer.write(gson.toJson(a));
			writer.close();
		}
	}

	public static JsonArray deserijal() throws Exception {
		FileReader reader = new FileReader("data/log.json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray a = gson.fromJson(reader, JsonArray.class);
		return a;
	}
	public static void fillComboBox(JComboBox<String> levi, JComboBox<String> desni) {
		for (int i = 0; i < Menjacnica.drzava.size(); i++) {
			levi.addItem(Menjacnica.drzava.get(i).getName());
			desni.addItem(Menjacnica.drzava.get(i).getName());
		}
	}
}
