import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.coderscampus.assignment7.CustomArrayList;
import com.coderscampus.assignment7.CustomList;

public class CustomArrayListTest {

	@Test
	public void test_Add() {

		CustomArrayList<Object> customArrayList = new CustomArrayList<>();

		assertTrue(customArrayList.add("Test Item"));
		assertEquals("Test Item", customArrayList.get(0));
	}

	@Test
	public void test_Add_To_Empty_List() {

		CustomList<Object> customList = new CustomArrayList<>();

		assertEquals(0, customList.getSize());
		assertTrue(customList.add("Item1"));
		assertEquals(1, customList.getSize());
		assertTrue(customList.get(0) instanceof String);
		assertEquals("Item1", customList.get(0));

	}

	@Test
	public void test_Add_At_Index() {

		CustomList<Object> customList = new CustomArrayList<>();

		customList.add("Item2");
		customList.add("Item3");

		assertEquals(2, customList.getSize());
		assertTrue(customList.add(0, "Item1"));
		assertEquals(3, customList.getSize());
		assertTrue(customList.get(0) instanceof String);
		assertEquals("Item1", customList.get(0));
		assertTrue(customList.get(1) instanceof String);
		assertEquals("Item2", customList.get(1));
		assertTrue(customList.get(2) instanceof String);
		assertEquals("Item3", customList.get(2));

	}

	@Test
	public void test_Add_Item_To_End_Of_List() {
		CustomList<Object> customList = new CustomArrayList<>();

		customList.add("Item1");
		customList.add("Item2");

		assertEquals(2, customList.getSize());
		assertTrue(customList.add("Item3"));
		assertEquals(3, customList.getSize());
		assertTrue(customList.get(2) instanceof String);
		assertEquals("Item3", customList.get(2));
	}

	@Test
	public void test_Add_Item_At_Specific_Index() {
		CustomList<Object> customList = new CustomArrayList<>();

		customList.add("Item1");
		customList.add("Item2");

		assertEquals(2, customList.getSize());
		assertTrue(customList.add(1, "Item3"));
		assertEquals(3, customList.getSize());
		assertTrue(customList.get(0) instanceof String);
		assertEquals("Item1", customList.get(0));
		assertTrue(customList.get(1) instanceof String);
		assertEquals("Item3", customList.get(1));
		assertTrue(customList.get(2) instanceof String);
		assertEquals("Item2", customList.get(2));
	}

	@Test
	public void test_Add_At_OutOfBoundsIndex() {
		CustomList<Object> customList = new CustomArrayList<>();

		customList.add("Item1");
		customList.add("Item2");

		assertEquals(2, customList.getSize());
		assertThrows(IndexOutOfBoundsException.class, () -> customList.add(5, "Item3"));
		assertEquals(2, customList.getSize());

	}

	@Test
	public void test_Add_Multiple_Items_At_Various_Positions() {
		CustomList<Object> customList = new CustomArrayList<>();

		customList.add("Item1");
		assertEquals(1, customList.getSize());
		assertEquals("Item1", customList.get(0));

		customList.add(0, "Item2");
		assertEquals(2, customList.getSize());
		assertEquals("Item2", customList.get(0));
		assertEquals("Item1", customList.get(1));

		customList.add(1, "Item3");
		assertEquals(3, customList.getSize());
		assertEquals("Item2", customList.get(0));
		assertEquals("Item3", customList.get(1));
		assertEquals("Item1", customList.get(2));
	}

	@Test
	public void test_Add_To_Full_List() {
		CustomList<Object> customList = new CustomArrayList<>();

		for (int i = 1; i <= 10; i++) {
			customList.add("Item" + i);
		}

		assertEquals(10, customList.getSize());
		customList.add("Item11");
		assertEquals(11, customList.getSize());
		assertEquals("Item11", customList.get(10));
	}

	@Test
	public void test_Add_Null_Item() {
		CustomList<Object> customList = new CustomArrayList<>();

		boolean added = customList.add(null);

		assertTrue(added);
		assertEquals(1, customList.getSize());
		assertNull(customList.get(0));
	}

	@Test
	public void test_Remove() {
		CustomList<Object> customList = new CustomArrayList<>();

		customList.add("Item1");
		customList.add("Item2");
		customList.add("Item3");

		assertTrue(customList.get(1) instanceof String);

		String removedItem = (String) customList.remove(1);

		assertEquals("Item2", removedItem);
		assertEquals(2, customList.getSize());
		assertTrue(customList.get(0) instanceof String);
		assertEquals("Item1", customList.get(0));
		assertTrue(customList.get(1) instanceof String);
		assertEquals("Item3", customList.get(1));

	}

	@Test
	public void test_Remove_From_Empty_List() {

		CustomList<Object> customList = new CustomArrayList<>();

		try {
			customList.remove(0);
			fail("Expected IndexOutOfBoundsException but it wasn't thrown");
		} catch (IndexOutOfBoundsException e) {

			assertEquals(0, customList.getSize());
		} catch (NullPointerException e) {

			assertEquals(0, customList.getSize());
		}

	}

	@Test
	public void test_Remove_From_Beginning() {

		CustomList<Object> customList = new CustomArrayList<>();

		customList.add("Item1");
		customList.add("Item2");
		customList.add("Item3");

		String removedItem = (String) customList.remove(0);

		assertEquals("Item1", removedItem);
		assertEquals(2, customList.getSize());
		assertEquals("Item2", customList.get(0));
		assertEquals("Item3", customList.get(1));
	}

	@Test
	public void test_Remove_From_End() {
		CustomList<Object> customList = new CustomArrayList<>();

		customList.add("Item1");
		customList.add("Item2");
		customList.add("Item3");

		String removedItem = (String) customList.remove(2);

		assertEquals("Item3", removedItem);
		assertEquals(2, customList.getSize());
		assertEquals("Item1", customList.get(0));
		assertEquals("Item2", customList.get(1));

	}

	@Test
	public void test_Remove_From_Middle() {
		CustomList<Object> customList = new CustomArrayList<>();

		customList.add("Item1");
		customList.add("Item2");
		customList.add("Item3");

		String removedItem = (String) customList.remove(1);

		assertEquals("Item2", removedItem);
		assertEquals(2, customList.getSize());
		assertEquals("Item1", customList.get(0));
		assertEquals("Item3", customList.get(1));
	}

	@Test
	public void test_Remove_Last_Item() {
		CustomList<Object> customList = new CustomArrayList<>();

		customList.add("Item1");
		assertTrue(customList.get(0) instanceof String);

		String removedItem = (String) customList.remove(0);

		assertEquals("Item1", removedItem);
		assertEquals(0, customList.getSize());
	}
}
