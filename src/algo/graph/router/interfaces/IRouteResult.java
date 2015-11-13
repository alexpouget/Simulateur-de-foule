package algo.graph.router.interfaces;

import algo.graph.interfaces.IElement;

public interface IRouteResult {
	Iterable<IElement> getRoute();
    String toString();
}
