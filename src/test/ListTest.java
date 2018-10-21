package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import NBAUtil.List;

class ListTest {
	
	List<Integer> list;
	void escenario1() {
		list = new List<>();
		for (int i = 0; i < 40; i++) {
			Integer k = 2*i;
			list.add(k);
		}
	}
	
	void escenario2() {
		list = new List<>();
		for (int i = 0; i < 15; i++) {
			Integer k = (int)(Math.random()*15);
			list.add(k);
		}
	}
	
	void escenario3() {
		list = new List<>();
	}

	@Test
	void addTest()
	{
		escenario1();
		int j = list.size();
		list.add(3);
		Integer s = 3;
		assertEquals(s, list.get(j));
		
		escenario3();
		list.add(3);
		assertNotEquals(0, list.size());
	}
	
	@Test
	void removeTest()
	{
		escenario1();
		list.remove(6);
		assertNotEquals(10, list.get(6));
		
		escenario2();
		int k = list.size();
		list.remove(0);
		
		assertEquals(k-1, list.size());
		
		escenario3();
		boolean f = false;
		try {
			list.remove(4);
		} catch (Exception e) {
			f = true;
		}
		
		assertTrue(f);
		
	}
	
	@Test
	void getTest()
	{
		escenario1();
		assertEquals(14, list.get(7).intValue());
		
		escenario2();
		assertNotNull(list.get(3));
		
		escenario3();
		boolean f = false;
		try {
			list.get(5);
		} catch (Exception e) {
			f = true;
		}
		
		assertTrue(f);
	}
	
	@Test
	void sizeTest()
	{
		escenario1();
		assertEquals(40, list.size());
		
		escenario3();
		assertEquals(0, list.size());
	}
	
	
}

