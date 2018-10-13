package NBAUtil;

public class BSTree<K, V> implements IBinaryTree<K, V>{

	Node<K, V> root;
	
	public BSTree()
	{
		root = null;
	}
	@Override
	public Node<K, V> getRoot()
	{
		return root;
	}
	@Override
	public void insert(Node<K, V> node)
	{
		if(root == null)
		{
			root = node;
		}
		else 
		{
			Node<K, V> aux = root;
			Node<K, V> dad = null;
			while(true)
			{
				dad = aux;
				if(node.getKey().hashCode()<aux.getKey().hashCode())
				{
					aux = aux.getLeft();
					if(aux==null)
					{
						dad.setLeft(node);
						node.setDad(dad);
						return;
					}
				}
				else if(node.getKey().hashCode()>aux.getKey().hashCode())
				{
					aux = aux.getRight();
					if(aux==null)
					{
						dad.setRight(node);
						node.setDad(dad);
						return;
					}
				}
				else
				{
					dad.getVal().add(node.getVal().get(0));
					return;
				}
			}
		}
	}
	@Override
	public Node<K, V> search(K k)
	{
		Node<K, V> aux = root;
		while(aux.getKey().hashCode()!=k.hashCode())
		{
			if(k.hashCode()<aux.getKey().hashCode())
			{
				aux = aux.getLeft();
			}
			else
			{
				aux = aux.getRight();
			}
			if(aux==null)
			{
				return null;
			}
		}
		return aux;
	}
	
	public List<V> getBiggerThan(K k)
	{
		Node<K, V> node;
		List<V> l = new List<>();
		if(search(k)!=null)
		{
			node = search(k);
			if(node.getRight()!=null)
			{
				l.addList(node.getRight().getSubTree());
			}
		}
		else
		{
			node = searchCloser(k);
			if(node.getRight()!=null&&(node.getRight().getKey().hashCode()>k.hashCode()))
			{
				l.addList(node.getRight().getSubTree());
			}
		}
		
		while(node!=null)
		{
			if(node.getKey().hashCode()>k.hashCode())
			{
				l.addList(node.getVal());
				if(node.getRight()!=null)
				{
					l.addList(node.getRight().getSubTree());
				}
			}
			node = node.getDad();
		}
		return l;
	}
	
	public List<V> getLessThan(K k)
	{
		Node<K, V> node;
		List<V> l = new List<>();
		if(search(k)!=null)
		{
			node = search(k);
			if(node.getLeft()!=null)
			{
				l.addList(node.getLeft().getSubTree());
			}
		}
		else
		{
			node = searchCloser(k);
			if(node.getLeft()!=null&&(node.getLeft().getKey().hashCode()<k.hashCode()))
			{
				l.addList(node.getLeft().getSubTree());
			}
		}
		
		while(node!=null)
		{
			if(node.getKey().hashCode()<k.hashCode())
			{
				l.addList(node.getVal());
				if(node.getLeft()!=null)
				{
					l.addList(node.getLeft().getSubTree());
				}
			}
			node = node.getDad();
		}
		return l;
	}
	
	private Node<K, V> searchCloserAVL(K key, Node<K, V> node)
	{
		Node<K, V> n;
		if(node.getKey().hashCode()<key.hashCode())
		{
			n = node.getRight();
		}
		else
		{
			n = node.getLeft();
		}
		if(n == null)
		{
			return node;
		}
		else
		{
			return searchCloserAVL(key, n);
		}
		
	}
	
	public Node<K, V> searchCloser(K key)
	{
		return searchCloserAVL(key, root);
	}
}
