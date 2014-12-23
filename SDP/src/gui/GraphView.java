package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
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

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import logic2.Comunicate;
import logic2.Logic;
import logic2.Trip;

public class GraphView extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panel;
	private JTextField textField_1;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JButton btnKrok;
	private Logic logic;
	private boolean isStopped;
	private long time = 1000;
	private ArrayList<Trip> tripList;
	private Comunicate communicate;
	private Graph<String, String> graph;
	private BasicVisualizationServer<String, String> vv;
	private String previousCity;
	private ArrayList<String> edgeStringList;
	
	

	/**
	 * Create the frame.
	 */
	public GraphView(Logic l) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 653);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(UIManager.getColor("ArrowButton.background"));
		panel.setBounds(0, 0, 547, 461);
		contentPane.add(panel);

		JLabel lblCzas = new JLabel("Czas:");
		lblCzas.setBounds(590, 187, 46, 14);
		contentPane.add(lblCzas);

		textField_1 = new JTextField();
		textField_1.setBounds(590, 215, 38, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblListaZlecen = new JLabel("Lista paczek w samochodzie:");
		lblListaZlecen.setBounds(590, 274, 176, 14);
		contentPane.add(lblListaZlecen);

		textArea = new JTextArea();
		textArea.setBounds(580, 300, 198, 102);
		contentPane.add(textArea);

		JLabel lblKomunikaty = new JLabel("Komunikaty:");
		lblKomunikaty.setBounds(10, 473, 95, 14);
		contentPane.add(lblKomunikaty);

		textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 504, 490, 94);
		contentPane.add(textArea_1);

		btnKrok = new JButton("KROK");
		btnKrok.setBounds(590, 57, 168, 46);
		contentPane.add(btnKrok);
		btnKrok.addActionListener(this);

		logic = l;
		isStopped = false;
		tripList = new ArrayList<Trip>();
		time = 1000;
		graph = logic.getGraph();
		edgeStringList = new ArrayList<String>();
		previousCity = "Suwa�ki";

		
		SparseMultigraph<String, String> smg = null;
		smg = (SparseMultigraph<String, String>) graph;
		Layout<String, String> layout = new CircleLayout(smg);
		layout.setSize(new Dimension(500, 400));
		vv = new BasicVisualizationServer<String, String>(
				layout);
		vv.setPreferredSize(new Dimension(540, 440));
		
		
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
		vv.getRenderer().getVertexLabelRenderer().setPosition(Position.AUTO);
		panel.add(vv);

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
				previousCity = c.getDestinationCity();
				textField_1.setText(Integer.toString(c.getDistance()));
				textArea.setText(c.getOrderView()); 
				textArea_1.setText(c.getLog());
				
				Transformer<String,Paint> vertexPaint = new Transformer<String,Paint>() {
		            public Paint transform(String i) {
		            	if(i.equalsIgnoreCase(previousCity))
		            		return Color.GREEN;
		            	return Color.RED;
		            }
		        };  
		        
		        float dash[]  = { 10.0f };
		    	final Stroke edgeStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
		    			BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
		        
		    	edgeStringList = c.getEdgesToChange();
		    	System.out.println(edgeStringList);
		    	
		    	Transformer<String, Stroke> edgeStrokeTransformer = new Transformer<String, Stroke>() {
					public Stroke transform(String s) {
						for(String n: edgeStringList)
						if(s.equalsIgnoreCase(n))
							return edgeStroke;
						return new BasicStroke();
					}
				};
		    	
				vv.getRenderContext().setEdgeStrokeTransformer(edgeStrokeTransformer);
		        vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
			 	panel.repaint();			
		 	}else{
				textArea_1.setText("Wszystkie paczki dostarczono!");
		 	}
	 	}

	}
}
