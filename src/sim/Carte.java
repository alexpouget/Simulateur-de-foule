package sim;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import algo.graph.GenericEdge;
import algo.graph.GenericNode;
import algo.graph.Graph;

public class Carte {
	private char[][] el;
	private int row;
	private int col;
	private List<GenericNode<String, Object>>  start = new ArrayList<>();
	private List<GenericNode<String, Object>>  fin = new ArrayList<>();
	private HashMap<String,GenericNode<String, Object>> hash = new HashMap<>();
	private Graph<String,Object> graph;
	
	public Carte(String file){
		File fichier = new File(file);
        if (!fichier.exists() || !fichier.canRead()) {
            System.out.println("pb file");
            
        } else try {
            FileReader f = new FileReader(fichier);
            BufferedReader in = new BufferedReader(f);
            String line;
            line = in.readLine();
            row = Integer.parseInt(line);
            line = in.readLine();
            col = Integer.parseInt(line);
            
            this.el = new char[row][col];
            
            for(int i=0;i<row;i++){
            	line = in.readLine();
            	for(int y=0;y<col;y++){
            		el[i][y] = line.charAt(y);
            		
            	}
            	
            }
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }
        initGraph();
        
	}

	public char[][] getEl() {
		return el;
	}

	public void setEl(char[][] el) {
		this.el = el;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Graph<String, Object> getGraph() {
		return graph;
	}

	public void setGraph(Graph<String, Object> graph) {
		this.graph = graph;
	}
	public void initGraph(){
		graph = new Graph<>();
		for(int i = 0;i<this.getRow();i++){
			for(int y = 0;y<this.getCol();y++){
				GenericNode<String, Object> node = new GenericNode<>(String.valueOf((i*this.getCol())+y+1));
				graph.registerNode(node);
				hash.put(String.valueOf((i*this.getCol())+y+1), node);
				System.out.println((i*this.getCol())+y+1);
			}
		}
		for(int i = 0;i<this.getRow();i++){
			for(int y = 0;y<this.getCol();y++){
				GenericNode<String, Object>  l = hash.get(String.valueOf((i*this.getCol())+y+1));
				if(this.getEl()[i][y]=='A'){
					this.fin.add(l);
				}
				else if(this.getEl()[i][y]=='D'){
					this.start.add(l);
					l.setValue(0);
				}
				GenericNode<String, Object>  droite = null;
				GenericNode<String, Object>  bas = null;
				if((i*this.getCol())+y+1==this.getCol()){
					droite = null;
				}else{
					droite = hash.get(String.valueOf(String.valueOf((i*this.getCol())+y+1+1)));
				}
				if(i+1==this.getRow()){
					bas = null;
				}else{
					bas = hash.get(String.valueOf(((i+1)*this.getCol())+y+1));
				}
				if(droite!=null){
					if(this.getEl()[i][y]=='*'){
						
					}
					else if(this.getEl()[i][y]=='G'){
						new GenericEdge(l, droite, 2);
					}
					else if(this.getEl()[i][y]==' '){
						new GenericEdge(l, droite, 1);
					}
					else if(this.getEl()[i][y]=='D'){
						new GenericEdge(l, droite, 1);
					}
					else if(this.getEl()[i][y]=='A'){
						new GenericEdge(l, droite, 1);
					}
				}
				if(bas!=null){
					if(this.getEl()[i][y]=='*'){
						
					}
					else if(this.getEl()[i][y]=='G'){
						new GenericEdge<>(l, bas, 2);
					}
					else if(this.getEl()[i][y]==' '){
						new GenericEdge<>(l, bas, 1);
					}
					else if(this.getEl()[i][y]=='D'){
						new GenericEdge<>(l, bas, 1);
					}
					else if(this.getEl()[i][y]=='A'){
						new GenericEdge<>(l, bas, 1);
					}
					
				}
				
			}
		}
	}

	public List<GenericNode<String, Object>> getStart() {
		return start;
	}

	public void setStart(List<GenericNode<String, Object>> start) {
		this.start = start;
	}

	public List<GenericNode<String, Object>> getFin() {
		return fin;
	}

	public void setFin(List<GenericNode<String, Object>> fin) {
		this.fin = fin;
	}

	public HashMap<String, GenericNode<String, Object>> getHash() {
		return hash;
	}

	public void setHash(HashMap<String, GenericNode<String, Object>> hash) {
		this.hash = hash;
	}
	
	
}
