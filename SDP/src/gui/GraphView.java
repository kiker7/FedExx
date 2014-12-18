package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

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
	private Logic logic;
	private JButton btnStart;
	private JButton btnStop;
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

		btnStart = new JButton("START");
		btnStart.setBounds(510, 50, 89, 23);
		contentPane.add(btnStart);
		btnStart.addActionListener(this);
		btnStart.setToolTipText("Naci�nij aby rozpocz��");

		btnStop = new JButton("STOP");
		btnStop.setBounds(628, 50, 89, 23);
		contentPane.add(btnStop);
		btnStart.addActionListener(this);
		btnStart.setToolTipText("Naci�nij aby zako�czy�");

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
		textArea.setBounds(520, 239, 168, 102);
		contentPane.add(textArea);

		JLabel lblKomunikaty = new JLabel("Komunikaty:");
		lblKomunikaty.setBounds(10, 411, 95, 14);
		contentPane.add(lblKomunikaty);

		textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 438, 490, 94);
		contentPane.add(textArea_1);

		logic = l;
		isStopped = false;
		tripList = new ArrayList<Trip>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object choosen = e.getSource();

		if (choosen == btnStart) {
			isStopped = false;

			new Thread() {
				@Override
				public void run() {
					tripList = logic.getMessage().getTripList();
					while (isStopped == false) {
						for (Trip n : tripList) {
							// imitacja jednego rozwozenia w petli
							// czyli tak jakby jeden samochod
							for (int i = n.getLogListSize() - 1; i < 0; i--) {
								communicate = n.getLastComunicate();
								// tutaj juz mam gotowy komunikat do
								// uaktualnienia w gui
								// ZOSTA�O ZAKTUALIZOWAC KOMUNIKATY ZROBIC GRAF
								// I WYSWIETLAC
								textField.setText(Integer.toString(1)); // ustawiay nr samochodu
								textField_1.setText(Integer.toString(communicate.getDistance())); // ustawiamy
																				// czas
								textArea.setText(communicate.getordersView()); // ustawiamy
																				// liste
																				// zlecen
								textArea_1.setText(communicate.getLog());
							}

							try {
								Thread.sleep(time);
							} catch (InterruptedException ew) {
								Logger.getLogger(GraphView.class.getName())
										.log(Level.SEVERE, null, ew);
							}
						}
					}
				}
			}.start();

		} else if (choosen == btnStop) {
			isStopped = true;
			textArea_1.setText("nie dzialat");
		}
	}
}
