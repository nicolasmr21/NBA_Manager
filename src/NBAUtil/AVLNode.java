package NBAUtil;

public class AVLNode<K, V> {

	private K key;
	private V val;
	private int fe;
	private AVLNode<K, V> left, right;
	
	public AVLNode(K k, V v) {
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
	public AVLNode<K, V> getLeft() {
		return left;
	}
	public void setLeft(AVLNode<K, V> izq) {
		this.left = izq;
	}
	public AVLNode<K, V> getRight() {
		return right;
	}
	public void setRight(AVLNode<K, V> der) {
		this.right = der;
	}
	public int getFe() {
		return fe;
	}
	public void setFe(int fe) {
		this.fe = fe;
	}
}
