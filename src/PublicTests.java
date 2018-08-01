package src;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PublicTests {

	@Test
	public void testClass1() {
		Colors colors = new Colors(null);
		Class<? extends Colors> klass = colors.getClass();
		String[] s = klass.toString().split("\\.");
		String className = s[s.length-1];
		assertEquals("Colors", className);
		
	}
	
	
	@Test
	public void testConstructor() {
		ArrayList<String> t = new ArrayList<>();
		t.add("a");
		t.add("b");
		t.add("c");
		Colors colors = new Colors(t);
		assertTrue(t.equals(colors.getColorsList()));
		
	}
	
	@Test
	public void testPrivateArrayList() {
		final Field fields[] =	Colors.class.getDeclaredFields();
		boolean found = false;
		for (int i = 0; i < fields.length; ++i) {
			if(fields[i].getName().equals("colorsList")){
				found = true;
				Object c1 = fields[i].getType();
				ArrayList<Object> a = new ArrayList<>();
				Object c2 = a.getClass();
				assertEquals(c1,c2);
				
				String[] t = fields[i].toString().split(" ");
				assertEquals(t[0],"private");
				break;
			}
		     
		}
		assertTrue(found);
		
	}
	

	@Test
	public void testSetGet() {
		ArrayList<String> t = new ArrayList<>();
		t.add("a");
		t.add("b");
		t.add("c");
		Colors colors = new Colors(null);
		colors.setColorsList(t);
		assertTrue(t.equals(colors.getColorsList()));
		
	}
	
	@Test
	public void testAddColor() {
		ArrayList<String> t = new ArrayList<>();
		Colors colors = new Colors(t);
		colors.addColor("red");
		colors.addColor("blue");
		colors.addColor("green");
		colors.addColor("black");
		t.add("red");
		t.add("blue");
		t.add("green");
		t.add("black");
		assertTrue(t.equals(colors.getColorsList()));
		
	}
	
	@Test
	public void testAddColors() {
		ArrayList<String> t = new ArrayList<>();
		t.add("red");
		t.add("blue");
		t.add("green");
		t.add("black");
		Colors colors = new Colors(null);
		colors.addColors(t);
		
		assertTrue(t.equals(colors.getColorsList()));
		
	}
	
	@Test
	public void testchangeSecondToOrange1() {
		Colors colors = new Colors(null);
		colors.addColor("0");
		colors.addColor("1");
		colors.addColor("2");
		colors.addColor("3");	
		ArrayList<String> result = colors.changeSecondToOrange();
		ArrayList<String> expected = new ArrayList<>();
		expected.add("0");
		expected.add("Orange");
		expected.add("2");
		expected.add("Orange");	
		assertEquals(expected, result);	
	}
	
	@Test
	public void testchangeSecondToOrange2() {
		Colors colors = new Colors(null);
		ArrayList<String> result = colors.changeSecondToOrange();
		ArrayList<String> expected = new ArrayList<>();
		assertEquals(expected, result);	
	}
	
	@Test
	public void testchangeSecondToOrange3() {
		Colors colors = new Colors(null);
		colors.addColor("0");
		ArrayList<String> result = colors.changeSecondToOrange();
		ArrayList<String> expected = new ArrayList<>();
		expected.add("0");
		assertEquals(expected, result);	
	}
	
	
	
	@Test
	public void testFindColor1() {
		Colors colors = new Colors(null);
		colors.addColor("white");
		colors.addColor("green");
		colors.addColor("blue");
		colors.addColor("red");	
		int expected =3;
		int result = colors.findColor("red");
		assertEquals(expected, result);	
	}
	
	@Test
	public void testFindColor2() {
		Colors colors = new Colors(null);
		colors.addColor("white");
		colors.addColor("green");
		colors.addColor("blue");
		colors.addColor("red");	
		int expected =-1;
		int result = colors.findColor("black");
		assertEquals(expected, result);	
	}
	
	@Test
	public void testGetColorCount1() {
		Colors colors = new Colors(null);
		colors.addColor("white");
		colors.addColor("green");
		colors.addColor("blue");
		colors.addColor("red");	
		int expected = 1;
		int result = colors.getColorCount("blue");
		assertEquals(expected, result);	
	}
	
	@Test
	public void testGetColorCount2() {
		Colors colors = new Colors(null);
		colors.addColor("white");
		colors.addColor("green");
		colors.addColor("blue");
		colors.addColor("red");	
		int expected = 0;
		int result = colors.getColorCount("black");
		assertEquals(expected, result);	
	}
	
	@Test
	public void testGetColorCount3() {
		Colors colors = new Colors(null);
		colors.addColor("white");
		colors.addColor("green");
		colors.addColor("white");
		colors.addColor("white");	
		int expected = 3;
		int result = colors.getColorCount("white");
		assertEquals(expected, result);	
	}
	
	@Test
	public void testRemoveDuplicates1() {
		Colors colors = new Colors(null);
		colors.addColor("white");
		colors.addColor("green");
		colors.addColor("white");
		colors.addColor("white");
		colors.removeDuplicates();
		int expected = 1;
		int result = colors.getColorCount("white");
		assertEquals(expected, result);	
	}
	
	@Test
	public void testRemoveDuplicates2() {
		Colors colors = new Colors(null);
		colors.addColor("white");
		colors.addColor("green");
		colors.addColor("white");
		colors.addColor("white");
		colors.removeDuplicates();
		ArrayList<String> expected = new ArrayList<>();		
		expected.add("green");
		expected.add("white");
		assertEquals(expected, colors.getColorsList());	
	}
	
	
	@Test
	public void testreplaceColor1() {
		Colors colors = new Colors(null);
		colors.addColor("white");
		colors.addColor("green");
		colors.addColor("white");
		colors.addColor("white");
		boolean r = colors.replaceColor("white", "red");
		ArrayList<String> expected = new ArrayList<>();
		expected.add("red");
		expected.add("green");
		expected.add("red");
		expected.add("red");
		assertEquals(expected, colors.getColorsList());	
		assertTrue(r);
	}
	@Test
	public void testreplaceColor2() {
		Colors colors = new Colors(null);
		colors.addColor("red");
		colors.addColor("green");
		colors.addColor("white");
		colors.addColor("white");
		boolean r = colors.replaceColor("blue", "red");
		ArrayList<String> expected = new ArrayList<>();
		expected.add("red");
		expected.add("green");
		expected.add("white");
		expected.add("white");
		assertEquals(expected, colors.getColorsList());	
		assertFalse(r);
	}
}
;