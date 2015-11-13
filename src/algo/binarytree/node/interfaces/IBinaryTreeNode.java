package algo.binarytree.node.interfaces;

public interface IBinaryTreeNode<V> {

	public V getValue();
	public void setValue(V v);
	/** set to true at set time, to false at get time. */
	public boolean isValueChanged();
	
	public IBinaryTreeNode<V> getParent();
	public IBinaryTreeNode<V> getLeftChild();
	public IBinaryTreeNode<V> getRightChild();
	public IBinaryTreeNode<V> getGrandParent();
    public IBinaryTreeNode<V> getUncle();

	public void setParent(IBinaryTreeNode<V> n);
	public void setRightChild(IBinaryTreeNode<V> n);
	public void setLeftChild(IBinaryTreeNode<V> n);
	
	public boolean isSimplePoint();
	public boolean isDoublePoint();
	public boolean isLeaf();
	public boolean equals(Object o);
	/**
	* return true if this node is leftchild of his parent.
	*/
	public boolean isLeftChild();

	public boolean isRightChild();
	
	/**
	 * 
	 *   the rightNode replace this node in the parent
	 *   this node inherit of his rightchild.leftchild 
	 *   this node becomes the leftchild of his rightchild.
	 *   
	 */
	public void rotateLeft();
	
	/**
	 * 
	 *   the leftNode replace this node in the parent
	 *   this node inherit of his leftchild.rightchild 
	 *   this node becomes the rightchild of his leftchild.
	 *   
	 */
	public void rotateRight();
 
   /**
    * according to this tree 
	*
	*        5
	*    3       7
	* 1    2   6
	*
	* node with value 1 has path 00
	* node with value 6 has path 10
	* root has path empty.
	*
    */
	public String getPath();
	
   /**
	* Root tree is level 0, children of root tre are level 1 .... 
	*/
	public int getLevel();
}
