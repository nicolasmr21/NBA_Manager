package NBAUtil;

public class RBNode<K extends Comparable <? super K>, V>{

	public static final int BLACK = 0;
	public static final int RED = 1;
	private K key;
	private List<V> vals;
	private RBNode<K, V> left, right, dad;
	
	private int color;
	public RBNode(K k, V v) {
		vals = new List<>();
		color = RED;
		key = k;
		vals.add(v);
		left = null;
		right = null;
		dad = null;
	}
	
	public int getColor()
	{
		return color;
	}
	
	public void flipColor()
	{
		if(color==BLACK)
		{
			color = RED;
		}
		else
		{
			color = BLACK;
		}
	}

	public RBNode<K, V> getLeft() {
		return left;
	}

	public void setLeft(RBNode<K, V> left) {
		this.left = left;
	}

	public RBNode<K, V> getRight() {
		return right;
	}

	public void setRight(RBNode<K, V> right) {
		this.right = right;
	}

	public RBNode<K, V> getDad() {
		return dad;
	}

	public void setDad(RBNode<K, V> dad) {
		this.dad = dad;
	}

	public K getKey() {
		return key;
	}

	public List<V> getVal() {
		return vals;
	}
	public List<V> getSubTree()
	{
		List<V> l = new List<>();
		l.addList(vals);
		if(right!=null)
		{
			l.addList(right.getSubTree());
		}
		if(left!=null)
		{
			l.addList(left.getSubTree());
		}
		return l;
	}
}
