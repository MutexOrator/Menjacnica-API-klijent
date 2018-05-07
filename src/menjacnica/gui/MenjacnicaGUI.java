package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menjacnica.Menjacnica;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox comboBoxLevi;
	private JComboBox comboBoxDesni;
	private JLabel lblNewLabel_2;
	private JLabel label;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnKonvertuj;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menjacnica.fill();
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
		contentPane.add(getTextField());
		contentPane.add(getTextField_1());
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
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(66, 148, 128, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(249, 148, 128, 20);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JButton getBtnKonvertuj() {
		if (btnKonvertuj == null) {
			btnKonvertuj = new JButton("Konvertuj");
			btnKonvertuj.setBounds(175, 204, 89, 23);
		}
		return btnKonvertuj;
	}
}
