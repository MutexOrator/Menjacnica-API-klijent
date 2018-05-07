package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menjacnica.Menjacnica;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox comboBoxLevi;
	private JComboBox comboBoxDesni;
	private JLabel lblNewLabel_2;
	private JLabel label;
	private JTextField textFieldLevi;
	private JTextField textFieldDesni;
	private JButton btnKonvertuj;
	
	private static Menjacnica m;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					m =  new Menjacnica();
					m.fill();
					MenjacnicaGUI frame = new MenjacnicaGUI();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getComboBoxLevi());
		contentPane.add(getComboBoxDesni());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLabel());
		contentPane.add(getTextFieldLevi());
		contentPane.add(getTextFieldDesni());
		contentPane.add(getBtnKonvertuj());
		for (int i = 0; i < Menjacnica.d.size(); i++) {
			comboBoxLevi.addItem(Menjacnica.d.get(i).getName());
			comboBoxDesni.addItem(Menjacnica.d.get(i).getName());
		}
		
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Iz valute zemlje");
			lblNewLabel.setBounds(66, 45, 128, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("U valutu zemlje");
			lblNewLabel_1.setBounds(249, 45, 128, 14);
		}
		return lblNewLabel_1;
	}
	private JComboBox getComboBoxLevi() {
		if (comboBoxLevi == null) {
			comboBoxLevi = new JComboBox();
			comboBoxLevi.setBounds(66, 77, 128, 20);
		}
		return comboBoxLevi;
	}
	private JComboBox getComboBoxDesni() {
		if (comboBoxDesni == null) {
			comboBoxDesni = new JComboBox();
			comboBoxDesni.setBounds(249, 77, 128, 20);
		}
		return comboBoxDesni;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Iznos");
			lblNewLabel_2.setBounds(66, 123, 128, 14);
		}
		return lblNewLabel_2;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Iznos");
			label.setBounds(249, 123, 128, 14);
		}
		return label;
	}
	private JTextField getTextFieldLevi() {
		if (textFieldLevi == null) {
			textFieldLevi = new JTextField();
			textFieldLevi.setBounds(66, 148, 128, 20);
			textFieldLevi.setColumns(10);
		}
		return textFieldLevi;
	}
	private JTextField getTextFieldDesni() {
		if (textFieldDesni == null) {
			textFieldDesni = new JTextField();
			textFieldDesni.setBounds(249, 148, 128, 20);
			textFieldDesni.setColumns(10);
		}
		return textFieldDesni;
	}
	private JButton getBtnKonvertuj() {
		if (btnKonvertuj == null) {
			btnKonvertuj = new JButton("Konvertuj");
			btnKonvertuj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						konvertuj();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			btnKonvertuj.setBounds(175, 204, 89, 23);
		}
		return btnKonvertuj;
	}
	private void konvertuj() throws Exception {
		
			try {
				String s1 = comboBoxLevi.getSelectedItem().toString();
				String s2 = comboBoxDesni.getSelectedItem().toString();
				String v1 = new String();
				String v2 = new String();
				for (int i = 0; i < m.d.size(); i++) {
					if(s1.equals(m.d.get(i).getName()))
						v1 = m.d.get(i).getCurrencyId();
					if(s2.equals(m.d.get(i).getName()))
						v2 = m.d.get(i).getCurrencyId();
				}
				Double val = Double.parseDouble(textFieldLevi.getText());
				Double r = m.vratiKurs(v1, v2);
				if(r == -1) {
					JOptionPane.showMessageDialog(null, "Ne postoje rezultati za zadate valute",
							"Paznja", JOptionPane.ERROR_MESSAGE);
				}
				textFieldDesni.setText(String.valueOf(val*r));
//				System.out.println(v1);
//				System.out.println(v2);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unesite iznos za konverziju",
						"Paznja", JOptionPane.INFORMATION_MESSAGE);
			}
		
			
		
	}
}
