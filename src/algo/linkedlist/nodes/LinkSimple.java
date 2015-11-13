package algo.linkedlist.nodes;

import algo.linkedlist.nodes.interfaces.ILinkSimple;

public class LinkSimple<v> implements ILinkSimple<v> {

	private v value;
	private ILinkSimple<v> next;
	
	@Override
	public v getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}

	@Override
	public void setValue(v value) {
		this.value = value;
		
	}

	@Override
	public ILinkSimple<v> getNext() {
		
		return next;
	}

	@Override
	public void setNext(ILinkSimple<v> next) {
		this.next = next;
		
	}

}
