package sim;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import algo.graph.GenericEdge;
import algo.graph.GenericNode;
import algo.graph.Graph;
import algo.graph.interfaces.IEdge;
import algo.graph.interfaces.INode;
import algo.graph.router.PathFinder;
import algo.queue.interfaces.IPriorityQueue;
import algo.stack.exception.StackEmptyException;
import algo.stack.interfaces.ILifo;
import sim.graph.JCarte;
import sim.graph.Window;

public class Main {
	
	public static Integer souris1 = 1;
	public static Integer souris2 = 1;
	public static List<Integer> posSouris = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Carte c  = new Carte("ressources/terrain/g2.txt");
		Window w = new Window(c);
		Souris[] souri = new Souris[2];
		List<ILifo<INode<String, Object>>> chemins = new ArrayList<>();
		for(int i = 0;i<souri.length;i++){
			souri[i] = new Souris(i+1);
			souri[i].setCarte(c);
			souri[i].findChemin();
			chemins.add(souri[i].getChemin());
		}
		INode<String, Object> actu = null;
		List<Integer> position = new ArrayList<>();
		try {
			while(souri[0]!=null || souri[1]!=null){
				for(int i = 0;i<chemins.size();i++){
					if(!chemins.get(i).isEmpty()){
						actu = chemins.get(i).pop();
						position.add(Integer.parseInt(actu.getId()));;
						System.out.println(position); 
					}
					else{
						souri[i] = null;
					}
				}
				((JCarte) w.getP()).setPosSouris(position);
				w.repaint();
				//Pause for 10 seconds
	            try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            ((JCarte) w.getP()).setPosSouris(null);
	            position.removeAll(position);
			}
		} catch (StackEmptyException e) {
			e.printStackTrace();
		} 
	}
	
	public static void start(){
		
	}

}
