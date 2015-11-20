package algo.graph.router;

import java.util.List;

import algo.graph.GenericNode;
import algo.graph.Graph;
import algo.graph.interfaces.IEdge;
import algo.graph.interfaces.INode;
import algo.queue.LinkedPriorityQueue;
import algo.queue.interfaces.IPriorityQueue;
import algo.stack.LinkedStack;
import algo.stack.interfaces.ILifo;

public class PathFinder {
	
	public void Find(Graph g, INode<String, Object> from, INode<String, Object> to){
		if(to.getId().equals(from.getId())){
			System.out.println("fin");
			return;
		}
		List<IEdge> edges = from.getEdges();
		for (IEdge edge : edges){
			GenericNode<String,Object> node = (GenericNode<String, Object>) edge.getOther(from);
			GenericNode<String,Object> t = (GenericNode<String, Object>) edge.getAttribute(String.valueOf(from));
			if(node.getValue()==null){
				node.setValue((Integer)t.getValue()+(Integer)edge.getAttribute("cost"));
				//System.out.println(edge.getOther(from) + "-->" + edge.getAttribute("cost")+ "cout" + node.getValue()); 
				this.Find(g,edge.getOther(from),to);
				}
			else if((Integer)node.getValue()>((Integer)t.getValue()+(Integer)edge.getAttribute("cost"))){
				node.setValue((Integer)t.getValue()+(Integer)edge.getAttribute("cost"));
				//System.out.println(edge.getOther(from) + "-->" + edge.getAttribute("cost")+ "cout" + node.getValue()+ "--> t"+  t.getValue()); 
				this.Find(g,edge.getOther(from),to);
				}
			}
	}
	
	public ILifo<INode<String, Object>> recompile(INode<String, Object> from, INode<String, Object> to){
		ILifo<INode<String, Object>> pile = new LinkedStack();
		pile.push(to);
		INode<String, Object> i = to;
		if(to.getId().equals(from.getId())){
			System.out.println("debut");
			return null;
		}
		do{
			i = compare(i);
			pile.push(i);
		}while(i!=from);
		return pile;
	}
	
	public INode<String, Object> compare(INode<String, Object> un){
		List<IEdge> edges = un.getEdges();
		INode<String, Object> res = null;
		for (IEdge edge : edges){
			GenericNode<String,Object> node = (GenericNode<String, Object>) edge.getOther(un);
			GenericNode<String,Object> t = (GenericNode<String, Object>) edge.getAttribute(String.valueOf(un));
			if(node.getValue()!=null && t.getValue()!=null){
					if(res==null || (Integer)res.getValue()>=(Integer)node.getValue()){
						res = node;
					}
				}
			}
		return res;
	}
}