package algo.binarytree.node;

import algo.binarytree.node.interfaces.IBinaryTreeNode;

public class BinaryTreeNode<V> implements IBinaryTreeNode<V> {
	
	private V value;
	private IBinaryTreeNode<V> right;
	private IBinaryTreeNode<V> left;
	private IBinaryTreeNode<V> father;
	private Boolean changed = false;

	public BinaryTreeNode()
	{
		super();
	}
	
	public BinaryTreeNode(V value)
	{
		super();
		this.value = value;
	}
	
	

	@Override
	public void setValue(V value)
	{
		this.value = value;
		changed = true;
	}

	@Override
	public V getValue()
	{
		changed = false;
		return value;
	}

	@Override
	public boolean isValueChanged()
	{
		return changed;
	}



	@Override
	public void setParent(IBinaryTreeNode<V> parent)
	{
		this.father = parent;
	}

	@Override
	public IBinaryTreeNode<V> getParent()
	{
		return father;
	}

	@Override
	public IBinaryTreeNode<V> getGrandParent()
	{
		if (father != null && father.getParent() != null)
			return father.getParent();
		return null;
	}

	@Override
	public void setLeftChild(IBinaryTreeNode<V> leftChild)
	{
		left = leftChild;
		if (leftChild != null)
			leftChild.setParent(this);
	}

	@Override
	public void setRightChild(IBinaryTreeNode<V> rightChild)
	{
		right = rightChild;
		if (rightChild != null)
			rightChild.setParent(this);
	}

	@Override
	public IBinaryTreeNode<V> getLeftChild()
	{
		return left;
	}

	@Override
	public IBinaryTreeNode<V> getRightChild()
	{
		return right;
	}

	@Override
	public IBinaryTreeNode<V> getUncle()
	{
		IBinaryTreeNode<V> grandParent = getGrandParent();
		
		if (grandParent != null)
		{
			if (father.isLeftChild())
			{
				return grandParent.getRightChild();
			}
			return grandParent.getLeftChild();
		}
		return null;
	}

	@Override
	public int getLevel()
	{
		if (father == null)
			return 0;
		return (father.getLevel() + 1);
	}

	@Override
	public boolean isSimplePoint()
	{
		return ((left == null) ^ (right == null));
	}

	@Override
	public boolean isDoublePoint()
	{
		return ((left != null) && (right != null));
	}

	@Override
	public boolean isLeaf()
	{
		return ((left == null) && (right == null));
	}

	@Override
	public boolean isLeftChild()
	{
		if (father != null)
			return (this == father.getLeftChild());
		return false;
	}

	@Override
	public boolean isRightChild()
	{
		if (father != null)
			return (this == father.getRightChild());
		return false;
	}

	@Override
	public void rotateLeft()
	{
		if (right != null)
		{
			if (father != null)
			{
				if (this.isRightChild())
					father.setRightChild(right);
				else
					father.setLeftChild(right);
			}
			
			IBinaryTreeNode<V> buffer = right.getLeftChild();
			right.setLeftChild(this);
			setRightChild(buffer);
		}
	}

	@Override
	public void rotateRight()
	{
		if (left != null)
		{
			if (father != null)
			{
				if (this.isRightChild())
					father.setRightChild(left);
				else
					father.setLeftChild(left);
			}
			
			IBinaryTreeNode<V> buffer = left.getRightChild();
			left.setRightChild(this);
			setLeftChild(buffer);
		}
	}

	@Override
	public String getPath()
	{
		if (father != null)
		{
			return (father.getPath() + ((isLeftChild()) ? "0" : "1"));
		}
		return "";
	}

}
