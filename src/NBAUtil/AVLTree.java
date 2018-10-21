package NBAUtil;

public class AVLTree<K extends Comparable <? super K>, V> implements IBinaryTree<K, V>{

	
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
			if(node.getKey().compareTo(key)==0)
			{
				return node;
			}
			else if(node.getKey().compareTo(key)<0)
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
		Node<K, V> dad = node.getDad();
		Node<K, V> help = node.getLeft();
		node.setLeft(help.getRight());
		if(help.getRight()!=null)
		{
			help.getRight().setDad(node);
		}
		help.setRight(node);
		node.setDad(help);
		help.setDad(dad);
		node.setFe(Math.max(getFe(node.getLeft()), getFe(node.getRight()))+1);
		help.setFe(Math.max(getFe(help.getLeft()), getFe(help.getRight()))+1);
		return help;
	}
	
	private Node<K, V> rightRotation(Node<K, V> node)
	{
		Node<K, V> dad = node.getDad();
		Node<K, V> help = node.getRight();
		node.setRight(help.getLeft());
		if(help.getLeft()!=null)
		{
			help.getLeft().setDad(node);
		}
		help.setLeft(node);
		node.setDad(help);
		help.setDad(dad);
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
		if(novo.getKey().compareTo(sub.getKey())<0)
		{
			if(sub.getLeft()==null)
			{
				sub.setLeft(novo);
				novo.setDad(sub);
			}
			else
			{
				sub.setLeft(insertAVL(novo, sub.getLeft()));
				sub.getLeft().setDad(dad);
				if(getFe(sub.getLeft())-getFe(sub.getRight())==2)
				{
					if(novo.getKey().compareTo(sub.getLeft().getKey())<0)
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
		else if(novo.getKey().compareTo(sub.getKey())>0)
		{
			if(sub.getRight()==null)
			{
				sub.setRight(novo);
				novo.setDad(sub);
			}
			else
			{
				sub.setRight(insertAVL(novo, sub.getRight()));
				sub.getRight().setDad(sub);
			}
			if(getFe(sub.getRight())-getFe(sub.getLeft())==2)
			{
				if(novo.getKey().compareTo(sub.getRight().getKey())>0)
				{
					dad = rightRotation(sub);
				}
				else
				{
					dad = doubleRightRotation(sub);
				}
			}
		}
		else
		{
			sub.getVal().add(novo.getVal().get(0));
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
	
	private Node<K, V> searchCloserAVL(K key, Node<K, V> node)
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
			return searchCloserAVL(key, n);
		}
		
	}
	
	public Node<K, V> searchCloser(K key)
	{
		return searchCloserAVL(key, root);
	}
}
