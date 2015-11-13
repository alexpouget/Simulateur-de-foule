package algo.graph;

import java.util.ArrayList;
import java.util.List;
import algo.binarytree.node.interfaces.IBinaryTreeNode;
import algo.graph.interfaces.IEdge;
import algo.graph.interfaces.INode;

public class GenericNode<K,V> implements INode<K,V>{
	
	
	private V value;
	private K key;
	private List<IEdge> listEdge;
	
	public GenericNode(K name){
		this.key = name;
		this.value = null;
		listEdge = new ArrayList<IEdge>();
	}
	
	@Override
	public K getId() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}

	@Override
	public List getEdges() {
		// TODO Auto-generated method stub
		return listEdge;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public List<IEdge> getListEdge() {
		return listEdge;
	}

	public void setListEdge(List<IEdge> listEdge) {
		this.listEdge = listEdge;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (String)key;
	}
	
}
