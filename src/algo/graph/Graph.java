package algo.graph;

import java.util.HashMap;

import algo.graph.interfaces.IGraph;
import algo.graph.interfaces.INode;

public class Graph<K,V> implements IGraph<K,V>{

	private HashMap<K,Object> map = new HashMap<>();
	
	@Override
	public INode getNode(K key){
		return (INode)map.get(key);
	}

	@Override
	public void registerNode(INode node) {
		// TODO Auto-generated method stub
		map.put((K)node.getId(), node);
		
	}

	@Override
	public void unregisterNode(K key) {
		map.remove(key);
	}

	

}
