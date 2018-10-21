package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import NBAUtil.RBNode;
import NBAUtil.RBTree;

class RBTreeTest {

	RBTree<Integer, String> tree;
	
	void scene1() {
		tree = new RBTree<>();
		tree.insertRB(new RBNode<Integer, String>(54, "A"));
		tree.insertRB(new RBNode<Integer, String>(43, "H"));
		tree.insertRB(new RBNode<Integer, String>(95, "S"));
		tree.insertRB(new RBNode<Integer, String>(72, "C"));
		tree.insertRB(new RBNode<Integer, String>(27, "K"));
		tree.insertRB(new RBNode<Integer, String>(8, "Ñ"));
		tree.insertRB(new RBNode<Integer, String>(15, "G"));
		tree.insertRB(new RBNode<Integer, String>(63, "W"));
	}
	
	void scene2() {
		tree = new RBTree<>();
		for (int i = 0; i < 500; i++) {
			char c = (char)i;
			tree.insertRB(new RBNode<Integer, String>(i, ""+c));
		}
	}

	void scene3() {
		tree = new RBTree<>();
	}

	@Test
	void searchTest()
	{
		scene1();
		assertEquals("Ñ", tree.search(8).getVal().get(0));
		
		scene2();
		char c = (char)75;
		assertEquals(""+c, tree.search(75).getVal().get(0));
		
		scene3();
		assertNull(tree.search(8));
	}
	
	@Test
	void insertTest()
	{
		scene1();
		tree.insertRB(new RBNode<Integer, String>(37, "O"));
		assertEquals("O", tree.search(43).getLeft().getVal().get(0));
		
		scene2();
		tree.insertRB(new RBNode<Integer, String>(500, "O"));
		assertEquals("O", tree.search(499).getRight().getVal().get(0));
		
		scene3();
		tree.insertRB(new RBNode<Integer, String>(45, "K"));
		assertEquals("K", tree.getRoot().getVal().get(0));
	}
	
	@Test
	void getBiggerThanTest()
	{
		scene1();
		assertEquals(5, tree.getBiggerThan(27).size());
		
		scene2();
		assertEquals(424, tree.getBiggerThan(75).size());
		
		scene3();
		assertNull(tree.getBiggerThan(4));
	}
	
	@Test
	void getLessThanTest()
	{
		scene1();
		assertEquals(6, tree.getLessThan(72).size());
		
		scene2();
		assertEquals(75, tree.getLessThan(75).size());
		
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
