package sim;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.List;

import algo.graph.GenericEdge;
import algo.graph.GenericNode;
import algo.graph.Graph;
import algo.graph.interfaces.IEdge;
import algo.graph.interfaces.INode;
import sim.graph.Window;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Carte c  = new Carte("ressources/terrain/g.txt");
		HashMap<String,GenericNode<String, Object>> hash = new HashMap<>();
//		new Window(c);
		Graph<String,Object> graph = new Graph<>();
		for(int i = 0;i<c.getRow();i++){
			for(int y = 0;y<c.getCol();y++){
				GenericNode<String, Object> node = new GenericNode<>(String.valueOf((i*c.getCol())+y+1));
				graph.registerNode(node);
				hash.put(String.valueOf((i*c.getCol())+y+1), node);
				System.out.println((i*c.getCol())+y+1);
			}
		}
		for(int i = 0;i<c.getRow();i++){
			for(int y = 0;y<c.getCol();y++){
				GenericNode<String, Object>  l = hash.get(String.valueOf((i*c.getCol())+y+1));
				GenericNode<String, Object>  droite = null;
				GenericNode<String, Object>  bas = null;
				if((i*c.getCol())+y+1==c.getCol()){
					droite = null;
				}else{
					droite = hash.get(String.valueOf(String.valueOf((i*c.getCol())+y+1+1)));
				}
				if(i+1==c.getRow()){
					bas = null;
				}else{
					bas = hash.get(String.valueOf(((i+1)*c.getCol())+y+1+1));
				}
				if(droite!=null){
					if(c.getEl()[i][y]=='*'){
						
					}
					else if(c.getEl()[i][y]=='G'){
						new GenericEdge(l, droite, 2);
					}
					else{
						new GenericEdge(l, droite, 1);
					}
				}
				if(bas!=null){
					if(c.getEl()[i][y]=='*'){
						
					}
					else if(c.getEl()[i][y]=='G'){
						new GenericEdge<>(l, bas, 2);
					}
					else{
						new GenericEdge<>(l, bas, 1);
					}
					
				}
				
			}
		}
INode<String, Object> node = graph.getNode("52");
		
		List<IEdge> edges = node.getEdges();
		for (IEdge edge : edges)
			System.out.println(edge.getOther(node) + " -> " + edge.getAttribute("cost")); 
		  

    
	}

}
