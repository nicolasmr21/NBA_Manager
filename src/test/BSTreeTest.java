package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import NBAUtil.BSTree;
import NBAUtil.Node;

class BSTreeTest {

	BSTree<Integer, String> tree;
	
	void scene1() {
		tree = new BSTree<>();
		tree.insert(new Node<Integer, String>(54, "A"));
		tree.insert(new Node<Integer, String>(43, "H"));
		tree.insert(new Node<Integer, String>(95, "S"));
		tree.insert(new Node<Integer, String>(72, "C"));
		tree.insert(new Node<Integer, String>(27, "K"));
		tree.insert(new Node<Integer, String>(8, "�"));
		tree.insert(new Node<Integer, String>(15, "G"));
		tree.insert(new Node<Integer, String>(63, "W"));
	}
	
	void scene2() {
		tree = new BSTree<>();
		for (int i = 0; i < 500; i++) {
			char c = (char)i;
			tree.insert(new Node<Integer, String>(i, ""+c));
		}
	}

	void scene3() {
		tree = new BSTree<>();
	}
	@Test
	void insertTest()
	{
		scene1();
		tree.insert(new Node<Integer, String>(37, "O"));
		assertEquals("O", tree.search(27).getRight().getVal().get(0));
		
		scene2();
		tree.insert(new Node<Integer, String>(500, "O"));
		assertEquals("O", tree.search(499).getRight().getVal().get(0));
		
		scene3();
		tree.insert(new Node<Integer, String>(45, "K"));
		assertEquals("K", tree.getRoot().getVal().get(0));
	}
	
	@Test
	void searchTest()
	{
		scene1();
		assertEquals("�", tree.search(8).getVal().get(0));
		
		scene2();
		char c = (char)75;
		assertEquals(""+c, tree.search(75).getVal().get(0));
		
		scene3();
		assertNull(tree.search(8));
	}
	
	@Test
	void getBiggerThanTest()
	{
		scene1();
		assertEquals(5, tree.getBiggerThan(27).size());
		
		scene2();
		char c = (char)76;
		assertEquals(""+c, tree.getBiggerThan(75).get(0));
		
		scene3();
		assertNull(tree.getBiggerThan(4));
	}
	
	@Test
	void getLessThanTest()
	{
		scene1();
		assertEquals(6, tree.getLessThan(72).size());
		
		scene2();
		char c = (char)74;
		assertEquals(""+c, tree.getLessThan(75).get(0));
		
		scene3();
		assertNull(tree.getLessThan(4));
	}
	
	@Test
	void searchCloserTest()
	{
		scene1();
		assertEquals("H", tree.searchCloser(45).getVal().get(0));
		
		scene2();
		char c = (char)0;
		assertEquals(""+c, tree.searchCloser(-1).getVal().get(0));
		
		scene3();
		assertNull(tree.searchCloser(4));
	}
}
