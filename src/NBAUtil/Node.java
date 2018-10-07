package NBAUtil;

public class Node<K, V> {

	private K key;
	private V val;
	private int fe;
	private Node<K, V> left, right;
	
	public Node(K k, V v) {
		key = k;
		val = v;
		fe = 0;
		left = null;
		right = null;
	}
	public K getKey() {
		return key;
	}
	public V getVal() {
		return val;
	}
	public Node<K, V> getLeft() {
		return left;
	}
	public void setLeft(Node<K, V> izq) {
		this.left = izq;
	}
	public Node<K, V> getRight() {
		return right;
	}
	public void setRight(Node<K, V> der) {
		this.right = der;
	}
	public int getFe() {
		return fe;
	}
	public void setFe(int fe) {
		this.fe = fe;
	}
}
