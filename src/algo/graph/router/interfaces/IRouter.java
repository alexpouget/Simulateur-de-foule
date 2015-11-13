package algo.graph.router.interfaces;

import java.util.Comparator;

import algo.graph.interfaces.IGraph;
import algo.graph.interfaces.INode;

public interface IRouter<K, V> {
	 public void setGraph(IGraph<K,V> graph);
     public IGraph<K,V> getGraph();
     public void setComparator(Comparator comparator);
     public IRouteResult route(INode<K,V> from, INode<K,V> to);
}
