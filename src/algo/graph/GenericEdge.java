package algo.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import algo.graph.interfaces.IEdge;
import algo.graph.interfaces.INode;

public class GenericEdge<K,V> implements IEdge{

	HashMap<String,Object> map = new HashMap<>();
	
	public GenericEdge(GenericNode<K,V> g, GenericNode<K,V> o, int i) {
		map.put(String.valueOf(g.getId()), g);
		map.put(String.valueOf(o.getId()), o);
		map.put("cost", i);
		
		List<IEdge> l = g.getListEdge();
		l.add(this);
		g.setListEdge(l);
		List<IEdge> ll = o.getListEdge();
		ll.add(this);
		o.setListEdge(ll);
	}

	@Override
	public INode getOther(INode me) {
		for(String cle : map.keySet()){
			if(!cle.equals((String)me.getId()) && !cle.equals("cost")){
				return (INode) map.get(cle);
			}
		}
		return null;
	}

	@Override
	public void setAttribute(String key, Object value) {
		// TODO Auto-generated method stub
		map.put(key,value);
	}

	@Override
	public Object getAttribute(String value) {
		// TODO Auto-generated method stub
		return map.get(value);
	}

}
