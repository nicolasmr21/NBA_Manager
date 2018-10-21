package NBAUtil;

public class BSTree<K extends Comparable <? super K>, V> implements IBinaryTree<K, V>{

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
				if(node.getKey().compareTo(aux.getKey())<0)
				{
					aux = aux.getLeft();
					if(aux==null)
					{
						dad.setLeft(node);
						node.setDad(dad);
						return;
					}
				}
				else if(node.getKey().compareTo(aux.getKey())>0)
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
		if(aux==null)
		{
			return null;
		}
		while(aux.getKey().compareTo(k)!=0)
		{
			if(k.compareTo(aux.getKey())<0)
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
			if(node == null)
			{
				return null;
			}
			if(node.getRight()!=null&&(node.getRight().getKey().compareTo(k)>0))
			{
				l.addList(node.getRight().getSubTree());
			}
		}
		
		while(node!=null)
		{
			if(node.getKey().compareTo(k)>0)
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
			if(node == null)
			{
				return null;
			}
			if(node.getLeft()!=null&&(node.getLeft().getKey().compareTo(k)<0))
			{
				l.addList(node.getLeft().getSubTree());
			}
		}
		
		while(node!=null)
		{
			if(node.getKey().compareTo(k)<0)
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
	
	private Node<K, V> searchCloserBST(K key, Node<K, V> node)
	{
		Node<K, V> n;
		if(node==null)
		{
			return null;
		}
		if(node.getKey().compareTo(key)<0)
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
			return searchCloserBST(key, n);
		}
		
	}
	
	public Node<K, V> searchCloser(K key)
	{
		return searchCloserBST(key, root);
	}
}
