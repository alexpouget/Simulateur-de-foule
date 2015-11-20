package algo.stack;

import java.util.Iterator;

import algo.linkedlist.nodes.LinkSimple;
import algo.linkedlist.nodes.interfaces.ILinkSimple;
import algo.stack.exception.StackEmptyException;
import algo.stack.interfaces.ILifo;

public class LinkedStack<V> implements ILifo{

	private int size;
	private ILinkSimple<V> first;
	
	public LinkedStack() {
		this.size = 0;
		this.first = null;
	}
	
	@Override
	public Iterator iterator() {
		return new LinkIterator();
		}
		
	private class LinkIterator implements Iterator<V> {

		private ILinkSimple<V> current = first;
		
		@Override
		public boolean hasNext() {
			return this.current != null;
		}

		@Override
		public V next() {
			if(!hasNext())
				try {
					throw new StackEmptyException();
				} catch (StackEmptyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			ILinkSimple<V> next = (ILinkSimple<V>) current.getValue();
			this.current = (ILinkSimple<V>) this.current.getNext();
			
			return (V) next;
		}	
	}


	@Override
	public Object pop() throws StackEmptyException {
		if(isEmpty()){
			throw new StackEmptyException();
		}
		V pop = this.first.getValue();
		this.first = this.first.getNext();
		this.size--;
		return pop;
	}

	@Override
	public Object peek() throws StackEmptyException {
		if(isEmpty()){
			throw new StackEmptyException();
		}
		return this.first.getValue();
	}

	
	@Override
	public void push(Object value) {
		ILinkSimple<V> old = this.first;
		this.first = new LinkSimple<V>();
		this.first.setValue((V)value);
		this.first.setNext(old);
		this.size++;
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.first == null;
	}

}
