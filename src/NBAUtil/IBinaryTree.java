package NBAUtil;

public interface IBinaryTree<K, V> {

	public Node<K, V> getRoot();
	public Node<K, V> search(K key);
	public void insert(Node<K, V> novo);
	
}
