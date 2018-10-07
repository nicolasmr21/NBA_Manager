package NBAUtil;

public class AVLTree<K, V> implements IBinaryTree<K, V>{

	
	private Node<K, V> root;
	
	public AVLTree() {
		root = null;
	}
	@Override
	public Node<K, V> getRoot()
	{
		return root;
	}

	
	public Node<K, V> search(K key)
	{
		return searchAVL(key, root);
	}

	public Node<K, V> searchAVL(K key, Node<K, V> node)
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
				return searchAVL(key, node.getRight());
			}
			else
			{
				return searchAVL(key, node.getLeft());
			}
		}
		else
		{
			return null;
		}
	}
	
	private int getFe(Node<K, V> node)
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
	
	private Node<K, V> leftRotation(Node<K, V> node)
	{
		Node<K, V> help = node.getLeft();
		node.setLeft(help.getRight());
		help.setRight(node);
		node.setFe(Math.max(getFe(node.getLeft()), getFe(node.getRight()))+1);
		help.setFe(Math.max(getFe(help.getLeft()), getFe(help.getRight()))+1);
		return help;
	}
	
	private Node<K, V> rightRotation(Node<K, V> node)
	{
		Node<K, V> help = node.getRight();
		node.setRight(help.getLeft());
		help.setLeft(node);
		node.setFe(Math.max(getFe(node.getLeft()), getFe(node.getRight()))+1);
		help.setFe(Math.max(getFe(help.getLeft()), getFe(help.getRight()))+1);
		return help;
	}
	
	private Node<K, V> doubleLeftRotation(Node<K, V> node)
	{
		node.setLeft(rightRotation(node.getLeft()));
		Node<K, V> help = leftRotation(node);
		return help;
	}
	
	private Node<K, V> doubleRightRotation(Node<K, V> node)
	{
		node.setRight(leftRotation(node.getRight()));
		Node<K, V> help = rightRotation(node);
		return help;
	}
	
	private Node<K, V> insertAVL(Node<K, V> novo, Node<K, V> sub)
	{
		Node<K, V> dad = sub;
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
		else
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
	public void insert(Node<K, V> novo)
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

}
