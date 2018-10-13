package NBAUtil;

public class Node<K, V> {

	private K key;
	private List<V> vals;
	private int fe;
	private Node<K, V> left, right, dad;
	
	public Node(K k, V v) {
		vals = new List<>();
		key = k;
		vals.add(v);
		fe = 0;
		left = null;
		right = null;
		dad = null;
	}
	public K getKey() {
		return key;
	}
	public List<V> getVal() {
		return vals;
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
	public Node<K, V> getDad() {
		return dad;
	}
	public void setDad(Node<K, V> dad) {
		this.dad = dad;
	}
}
