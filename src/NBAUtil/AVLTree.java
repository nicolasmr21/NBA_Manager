package NBAUtil;

public class AVLTree<K, V> implements IAVLTree<K, V>{

	
	private AVLNode<K, V> root;
	
	public AVLTree() {
		root = null;
	}
	@Override
	public AVLNode<K, V> getRoot()
	{
		return root;
	}
	@Override
	public AVLNode<K, V> search(K key, AVLNode<K, V> node)
	{
		if(node!=null)
		{
			int d = key.hashCode();
			int s = node.getKey().hashCode();
			if(s==d)
			{
				return node;
			}
			else if(s<d)
			{
				return search(key, node.getRight());
			}
			else
			{
				return search(key, node.getLeft());
			}
		}
		else
		{
			return null;
		}
	}
	
	private int getFe(AVLNode<K, V> node)
	{
		if(node==null)
		{
			return -1;
		}
		else
		{
			return node.getFe();
		}
	}
	
	private AVLNode<K, V> leftRotation(AVLNode<K, V> node)
	{
		AVLNode<K, V> help = node.getLeft();
		node.setLeft(help.getRight());
		help.setRight(node);
		node.setFe(Math.max(getFe(node.getLeft()), getFe(node.getRight()))+1);
		help.setFe(Math.max(getFe(help.getLeft()), getFe(help.getRight()))+1);
		return help;
	}
	
	private AVLNode<K, V> rightRotation(AVLNode<K, V> node)
	{
		AVLNode<K, V> help = node.getRight();
		node.setRight(help.getLeft());
		help.setLeft(node);
		node.setFe(Math.max(getFe(node.getLeft()), getFe(node.getRight()))+1);
		help.setFe(Math.max(getFe(help.getLeft()), getFe(help.getRight()))+1);
		return help;
	}
	
	private AVLNode<K, V> doubleLeftRotation(AVLNode<K, V> node)
	{
		node.setLeft(rightRotation(node.getLeft()));
		AVLNode<K, V> help = leftRotation(node);
		return help;
	}
	
	private AVLNode<K, V> doubleRightRotation(AVLNode<K, V> node)
	{
		node.setRight(leftRotation(node.getRight()));
		AVLNode<K, V> help = rightRotation(node);
		return help;
	}
	
	private AVLNode<K, V> insertAVL(AVLNode<K, V> novo, AVLNode<K, V> sub)
	{
		AVLNode<K, V> dad = sub;
		if(novo.getKey().hashCode()<sub.getKey().hashCode())
		{
			if(sub.getLeft()==null)
			{
				sub.setLeft(novo);
			}
			else
			{
				sub.setLeft(insertAVL(novo, sub.getLeft()));
				if(getFe(sub.getLeft())-getFe(sub.getRight())==2)
				{
					if(novo.getKey().hashCode()<sub.getLeft().getKey().hashCode())
					{
						dad = leftRotation(sub);
					}
					else
					{
						dad = doubleLeftRotation(sub);
					}
				}
			}
			
		}
		else if(novo.getKey().hashCode()>sub.getKey().hashCode())
		{
			if(sub.getRight()==null)
			{
				sub.setRight(novo);
			}
			else
			{
				sub.setRight(insertAVL(novo, sub.getRight()));
			}
			if(getFe(sub.getRight())-getFe(sub.getLeft())==2)
			{
				if(novo.getKey().hashCode()>sub.getRight().getKey().hashCode())
				{
					dad = rightRotation(sub);
				}
				else
				{
					dad = doubleRightRotation(sub);
				}
			}
		}
		if(sub.getLeft()==null&&sub.getRight()!=null)
		{
			sub.setFe(sub.getRight().getFe()+1);
		}
		else if(sub.getLeft()!=null&&sub.getRight()==null)
		{
			sub.setFe(sub.getLeft().getFe()+1);
		}
		else
		{
			sub.setFe(Math.max(getFe(sub.getLeft()), getFe(sub.getRight()))+1);
		}
		return dad;
	}
	@Override
	public void insert(AVLNode<K, V> novo)
	{
		if(root==null)
		{
			root = novo;
		}
		else
		{
			root = insertAVL(novo, root);
		}
	}
	
	public void preOrden(AVLNode<K, V> node)
	{
		if(node != null)
		{
			preOrden(node.getLeft());
			System.out.println(node.getKey());
			preOrden(node.getRight());
		}
	}

}
