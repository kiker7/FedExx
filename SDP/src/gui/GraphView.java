package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import edu.uci.ics.jung.graph.Graph;
import logic2.Comunicate;
import logic2.Logic;
import logic2.Trip;

public class GraphView extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JButton btnKrok;
	private Logic logic;
	private boolean isStopped;
	private long time = 1000;
	private ArrayList<Trip> tripList;
	private Comunicate communicate;
	private Graph<String, String> graph; // PRAWDOPODOBNIE TRZEBA BEDZIE
											// PRZEKAZAC DO PANELU
											// WYSWIETLAJACEGO

	/**
	 * Create the frame.
	 */
	public GraphView(Logic l) {
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
		lblListaZlecen.setBounds(520, 214, 176, 14);
		contentPane.add(lblListaZlecen);

		textArea = new JTextArea();
		textArea.setBounds(520, 239, 198, 102);
		contentPane.add(textArea);

		JLabel lblKomunikaty = new JLabel("Komunikaty:");
		lblKomunikaty.setBounds(10, 411, 95, 14);
		contentPane.add(lblKomunikaty);

		textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 438, 490, 94);
		contentPane.add(textArea_1);

		btnKrok = new JButton("KROK");
		btnKrok.setBounds(528, 43, 168, 46);
		contentPane.add(btnKrok);
		btnKrok.addActionListener(this);

		logic = l;
		isStopped = false;
		tripList = new ArrayList<Trip>();
		time = 1000;

		try {
			UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object choosen = e.getSource();

		if (choosen == btnKrok) {
			if (!logic.getMessage().getFinalComunicateList().isEmpty()) {
				Comunicate c = logic.getMessage().getFinalComunicateList()
						.remove(0);
				textField.setText("1");
				textField_1.setText(Integer.toString(c.getDistance()));
				textArea.setText(c.getOrderView()); 
				textArea_1.setText(c.getLog());
			}
		}

	}
}
