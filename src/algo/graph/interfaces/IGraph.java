package algo.graph.interfaces;

public interface IGraph<K,V> {
	public INode getNode(K key);
	public void registerNode(INode node);
	public void unregisterNode(K key);
}
