package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class GraphView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphView frame = new GraphView();
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
	public GraphView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 600);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 500, 400);
		contentPane.add(panel);
		
		JButton btnStart = new JButton("START");
		btnStart.setBounds(510, 50, 89, 23);
		contentPane.add(btnStart);
		
		JButton btnStop = new JButton("STOP");
		btnStop.setBounds(628, 50, 89, 23);
		contentPane.add(btnStop);
		
		JLabel lblNumerSamochodu = new JLabel("Numer samochodu:");
		lblNumerSamochodu.setBounds(522, 123, 114, 14);
		contentPane.add(lblNumerSamochodu);
		
		textField = new JTextField();
		textField.setBounds(522, 148, 38, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCzas = new JLabel("Czas:");
		lblCzas.setBounds(650, 123, 46, 14);
		contentPane.add(lblCzas);
		
		textField_1 = new JTextField();
		textField_1.setBounds(650, 148, 38, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblListaZlecen = new JLabel("Lista paczek w samochodzie:");
		lblListaZlecen.setBounds(520, 214, 157, 14);
		contentPane.add(lblListaZlecen);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(520, 239, 168, 102);
		contentPane.add(textArea);
		
		JLabel lblKomunikaty = new JLabel("Komunikaty:");
		lblKomunikaty.setBounds(10, 411, 95, 14);
		contentPane.add(lblKomunikaty);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 438, 490, 94);
		contentPane.add(textArea_1);
	}
}
