package algo.graph.router;

import java.util.Comparator;
import java.util.List;

import algo.graph.interfaces.IEdge;
import algo.graph.interfaces.IGraph;
import algo.graph.interfaces.INode; 
import algo.graph.router.interfaces.IRouteResult;
import algo.graph.router.interfaces.IRouter;
import algo.queue.LinkedPriorityQueue;

public class RouterDijkstra<K,V> implements IRouter<K,V>{

	private IGraph<K, V> graph;
	private Comparator comparator;
	
	
	@Override
	public void setGraph(IGraph<K, V> graph) {
		// TODO Auto-generated method stub
		this.graph = graph;
	}

	@Override
	public IGraph<K, V> getGraph() {
		// TODO Auto-generated method stub
		return graph;
	}

	@Override
	public void setComparator(Comparator comparator) {
		// TODO Auto-generated method stub
		this.comparator = comparator;
	}

	@Override
	public IRouteResult route(INode<K, V> from, INode<K, V> to) {
		RouteResult rt = new RouteResult();
		List<IEdge> edges = from.getEdges();
		INode<K, V> n;
		Integer cost = null;
//		for(IEdge edge : edges){
//			n = edge.getOther(from);
//		}
		return rt;
	}

}
