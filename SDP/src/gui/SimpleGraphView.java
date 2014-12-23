package gui;

import io.MapRead;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import org.apache.commons.collections15.Transformer;

import dijsktra.Map;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

public class SimpleGraphView {
	Graph<Integer, String> g;

	/** Creates a new instance of SimpleGraphView */
	public SimpleGraphView() {
		
		
		
		// Graph<V, E> where V is the type of the vertices and E is the type of
		// the edges
		g = new SparseMultigraph<Integer, String>();
		// Add some vertices. From above we defined these to be type Integer.
		g.addVertex((Integer) 1);
		g.addVertex((Integer) 2);
		g.addVertex((Integer) 3);
		// Note that the default is for undirected edges, our Edges are Strings.
		g.addEdge("Edge-A", 1, 3); // Note that Java 1.5 auto-boxes primitives
		g.addEdge("Edge-B", 2, 3); 
	}
	
	
	

 
	public static void main(String[] args) throws IOException {
		SparseMultigraph<String, String> smg = null;
		Map map = null;
		MapRead mprd = new MapRead();
		map = mprd.mapRead(new File(args[0]));
		//SimpleGraphView sgv = new SimpleGraphView(); // This builds the graph
		smg = (SparseMultigraph<String, String>) mprd.getGraph();
		
		/*final int [] cityNumbers = new int [4];
		for(int i = 0 ; i < 4 ; i++)
			cityNumbers[i] = i;*/
		// Layout<V, E>, BasicVisualizationServer<V,E>
		Layout<String, String> layout = new CircleLayout(smg);
		layout.setSize(new Dimension(500, 400));
		BasicVisualizationServer<String, String> vv = new BasicVisualizationServer<String, String>(
				layout);
		vv.setPreferredSize(new Dimension(500, 400));
		// Setup up a new vertex to paint transformer...
		Transformer<String, Paint> vertexPaint = new Transformer<String, Paint>() {
			@Override
			public Paint transform(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		// Set up a new stroke Transformer for the edges
		float dash[] = { 10.0f };
		final Stroke edgeStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
		
		final Stroke edgeStroke2 = new BasicStroke(2.0f, BasicStroke.CAP_SQUARE,
				BasicStroke.JOIN_ROUND, 8.0f, dash, 0.0f);
		
		Transformer<String, Stroke> edgeStrokeTransformer = new Transformer<String, Stroke>() {
			public Stroke transform(String s) {
				if(s.equalsIgnoreCase("Edge-B"))
					return edgeStroke;
				return edgeStroke2;
			}
		};

		vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
		vv.getRenderContext().setEdgeStrokeTransformer(edgeStrokeTransformer);
	
		
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
		vv.getRenderer().getVertexLabelRenderer().setPosition(Position.AUTO);
		
		
		JFrame frame = new JFrame("Simple Graph View 2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(vv);
		frame.pack();
		frame.setVisible(true);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

}