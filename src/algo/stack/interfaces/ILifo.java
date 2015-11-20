package algo.stack.interfaces;

import algo.stack.exception.StackEmptyException;

public interface ILifo<V> extends Iterable<V>{

	public V pop()throws StackEmptyException;
	public V peek() throws StackEmptyException;
	public void push(V value);
	public int size();
	public boolean isEmpty();
}
