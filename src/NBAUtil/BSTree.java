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
						return;
					}
				}
				else
				{
					aux = aux.getRight();
					if(aux==null)
					{
						dad.setRight(node);
						return;
					}
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
}
