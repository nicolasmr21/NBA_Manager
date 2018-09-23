package NBAUtil;

public interface IAVLTree<K, V> {

	public AVLNode<K, V> getRoot();
	public AVLNode<K, V> search(K key, AVLNode<K, V> node);
	public void insert(AVLNode<K, V> novo);
	
}
