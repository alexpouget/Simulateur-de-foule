package algo.queue;

import java.util.Comparator;

import algo.linkedlist.nodes.LinkSimple;
import algo.linkedlist.nodes.interfaces.ILinkSimple;
import algo.queue.interfaces.IPriorityQueue;

public class LinkedPriorityQueue<T> implements IPriorityQueue<T>{
	
	private ILinkSimple<T> file;
	private Comparator<T> comparator;
	
	
	public LinkedPriorityQueue() {
		super();
		file = null;
		comparator = null;
	}
	
	

	public LinkedPriorityQueue(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
		file = null;
	}



	@Override
	public void add(T e) {
		ILinkSimple<T> temp = file;
		ILinkSimple<T> ne = new LinkSimple<T>();
		ne.setValue(e);
		ILinkSimple<T> prev = temp;
		while(temp != null){
			if(comparator.compare(temp.getValue(), e)>=0){
				if(prev!=temp){
					prev.setNext(ne);
					ne.setNext(temp);
					
				}else{
					ne.setNext(prev);
					file = ne;	
				}
				return;
			}
			prev = temp;
			temp = temp.getNext();
		}
		
		if(file == null){
			file = ne;
		}else{
			temp=ne;
			prev.setNext(temp);
		}
		
	}

	@Override
	public T remove() {
		if(file == null){
			return null;
		}
		T res = file.getValue();
		file = file.getNext();
		return res;
	}

	@Override
	public T peek() {
		if(file == null){
			return null;
		}
		return file.getValue();
	}

}
