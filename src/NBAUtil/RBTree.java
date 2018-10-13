package NBAUtil;

public class RBTree<K, V> {

	private RBNode<K, V> root;
	
	public RBTree()
	{
		root = null;
	}

	public RBNode<K, V> getRoot() {
		return root;
	}

	public RBNode<K, V> search(K key)
	{
		return searchRB(key, root);
	}

	private RBNode<K, V> searchRB(K key, RBNode<K, V> node)
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
				return searchRB(key, node.getRight());
			}
			else
			{
				return searchRB(key, node.getLeft());
			}
		}
		else
		{
			return null;
		}
	}

	public void insertRB(RBNode<K, V> node) {
		
		if(root == null)
		{
			root = node;
			root.flipColor();
		}
		else 
		{
			RBNode<K, V> aux = root;
			RBNode<K, V> dad = null;
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
						if(dad.getColor()==RBNode.RED)
						{
							correct(node);
						}
						
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
						if(dad.getColor()==RBNode.RED)
						{
							correct(node);
						}
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
	
	private void correct(RBNode<K, V> z)
	{
		while(z.getDad()!=null&&z.getDad().getColor()==RBNode.RED)
		{
			if(z.getDad().equals( z.getDad().getDad().getLeft()))
			{
				RBNode<K, V> y = z.getDad().getDad().getRight();
				if(y!=null && y.getColor() == RBNode.RED)
				{
					z.getDad().flipColor();
					y.flipColor();
					z.getDad().getDad().flipColor();
					z = z.getDad().getDad();
				}
				else if(z.equals(z.getDad().getRight()))
				{
					z = z.getDad();
					leftRotation(z);
				}
				else
				{
					z.getDad().flipColor();
					z.getDad().getDad().flipColor();
					rightRotation(z.getDad().getDad());
				}
			}
			else
			{
				RBNode<K, V> y = z.getDad().getDad().getLeft();
				if(y != null && y.getColor() == RBNode.RED)
				{
					z.getDad().flipColor();
					y.flipColor();
					z.getDad().getDad().flipColor();
					z = z.getDad().getDad();
				}
				else if(z.equals(z.getDad().getLeft()))
				{
					z = z.getDad();
					rightRotation(z);
				}
				else
				{
					z.getDad().flipColor();
					z.getDad().getDad().flipColor();
					leftRotation(z.getDad().getDad());
				}
				
			}
		}
		if(root.getColor()==RBNode.RED)
		{
			root.flipColor();
		}
	}
	
	private void leftRotation(RBNode<K, V> node)
	{
		RBNode<K, V> help = node.getRight();
		node.setRight(help.getLeft());
		if(help.getLeft()!=null)
		{
			help.getLeft().setDad(node);
		}
		help.setDad(node.getDad());
		if(node.getDad()==null)
		{
			root = help;
			root.setDad(null);
		}
		else if(node.equals(node.getDad().getLeft()))
		{
			node.getDad().setLeft(help);
		}
		else
		{
			node.getDad().setRight(help);
		}
		help.setLeft(node);
		node.setDad(help);
	}
	
	private void rightRotation(RBNode<K, V> node)
	{
		RBNode<K, V> help = node.getLeft();
		node.setLeft(help.getRight());
		if(help.getRight()!=null)
		{
			help.getRight().setDad(node);
		}
		help.setDad(node.getDad());
		if(node.getDad()==null)
		{
			root = help;
			root.setDad(null);
		}
		else if(node.equals(node.getDad().getRight()))
		{
			node.getDad().setRight(help);
		}
		else
		{
			node.getDad().setLeft(help);
		}
		help.setRight(node);
		node.setDad(help);
	}
}
