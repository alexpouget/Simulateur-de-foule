package algo.graph.router;

import java.util.Iterator;

import algo.graph.interfaces.IElement;
import algo.graph.router.interfaces.IRouteResult;

public class RouteResult implements IRouteResult{
	private Iterable<IElement> iterable;
	
	
	@Override
	public Iterable<IElement> getRoute() {
		return iterable;
		
		
	}
	
	@Override
	public String toString() {
		
		String s= "";
		Iterator<IElement> e = this.getRoute().iterator();
		while(e.hasNext()){
			s += e.toString() + " -> " + e.next().toString();
		}
		return s;
	}

}
