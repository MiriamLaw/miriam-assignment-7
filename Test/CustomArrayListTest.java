import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.coderscampus.assignment7.CustomArrayList;
import com.coderscampus.assignment7.CustomList;

public class CustomArrayListTest {

	@Test
	public void testAdd() {

		CustomArrayList<String> customArrayList = new CustomArrayList<>();

		boolean result = customArrayList.add("Test Item");

		assertTrue(result);

		assertEquals("Test Item", customArrayList.get(0));
	}

	@Test
	public void testAddToEmptyList() {

		CustomList<String> customList = new CustomArrayList<>();

		assertEquals(0, customList.getSize());

		boolean added = customList.add("Item1");

		assertTrue(added);
		assertEquals(1, customList.getSize());

	}

	@Test
	public void testAddAtIndex() {

		CustomList<String> customList = new CustomArrayList<>();

		customList.add("Item2");
		customList.add("Item3");

		assertEquals(2, customList.getSize());
		assertEquals("Item2", customList.get(0));
		assertEquals("Item3", customList.get(1));

		boolean added = customList.add(0, "Item1");

		assertTrue(added);
		assertEquals(3, customList.getSize());

		assertEquals("Item1", customList.get(0));
		assertEquals("Item2", customList.get(1));
		assertEquals("Item3", customList.get(2));
	}

	@Test
	public void testAddItemToEndOfList() {
		CustomList<String> customList = new CustomArrayList<>();

		customList.add("Item1");
		customList.add("Item2");

		assertEquals(2, customList.getSize());

		boolean added = customList.add("Item3");

		assertTrue(added);
		assertEquals(3, customList.getSize());
		assertEquals("Item3", customList.get(2));
	}

	@Test
	public void testAddItemAtSpecificIndex() {
		CustomList<String> customList = new CustomArrayList<>();

		customList.add("Item1");
		customList.add("Item2");

		assertEquals(2, customList.getSize());

		boolean added = customList.add(1, "Item3");

		assertTrue(added);
		assertEquals(3, customList.getSize());
		assertEquals("Item1", customList.get(0));
		assertEquals("Item3", customList.get(1));
		assertEquals("Item2", customList.get(2));
	}

	@Test
	public void testAddAtOutOfBoundsIndex() {
		CustomList<String> customList = new CustomArrayList<>();

		customList.add("Item1");
		customList.add("Item2");

		assertEquals(2, customList.getSize());

		try {
			customList.add(5, "Item3");
			fail("Expected IndexOutOfBoundsException but it wasn't thrown");
		} catch (IndexOutOfBoundsException e) {

			assertEquals(2, customList.getSize());
		}

	}

	@Test
	public void testAddMultipleItemsAtVariousPositions() {
		CustomList<String> customList = new CustomArrayList<>();

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
	public void testAddToFullList() {
		CustomList<String> customList = new CustomArrayList<>();

		for (int i = 1; i <= 10; i++) {
			customList.add("Item" + i);
		}

		assertEquals(10, customList.getSize());

		customList.add("Item11");

		assertEquals(11, customList.getSize());
		assertEquals("Item11", customList.get(10));
	}

	@Test
	public void testAddNullItem() {
		CustomList<String> customList = new CustomArrayList<>();

		boolean added = customList.add(null);

		assertTrue(added);
		assertEquals(1, customList.getSize());

		assertNull(customList.get(0));
	}

	@Test
	public void testRemove() {
		CustomList<String> customList = new CustomArrayList<>();

		customList.add("Item1");
		customList.add("Item2");
		customList.add("Item3");

		String removedItem = customList.remove(1);

		assertEquals("Item2", removedItem);
		assertEquals(2, customList.getSize());
		assertEquals("Item1", customList.get(0));
		assertEquals("Item3", customList.get(1));

	}

	@Test
	public void testRemoveFromEmptyList() {

		CustomList<String> customList = new CustomArrayList<>();

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
	public void testRemoveFromBeginning() {

		CustomList<String> customList = new CustomArrayList<>();

		customList.add("Item1");
		customList.add("Item2");
		customList.add("Item3");

		String removedItem = customList.remove(0);

		assertEquals("Item1", removedItem);
		assertEquals(2, customList.getSize());
		assertEquals("Item2", customList.get(0));
		assertEquals("Item3", customList.get(1));
	}

	@Test
	public void testRemoveFromEnd() {
		CustomList<String> customList = new CustomArrayList<>();

		customList.add("Item1");
		customList.add("Item2");
		customList.add("Item3");

		String removedItem = customList.remove(2);

		assertEquals("Item3", removedItem);
		assertEquals(2, customList.getSize());
		assertEquals("Item1", customList.get(0));
		assertEquals("Item2", customList.get(1));

	}

	@Test
	public void testRemoveFromMiddle() {
		CustomList<String> customList = new CustomArrayList<>();

		customList.add("Item1");
		customList.add("Item2");
		customList.add("Item3");

		String removedItem = customList.remove(1);

		assertEquals("Item2", removedItem);
		assertEquals(2, customList.getSize());
		assertEquals("Item1", customList.get(0));
		assertEquals("Item3", customList.get(1));
	}

	@Test
	public void testRemoveLastItem() {
		CustomList<String> customList = new CustomArrayList<>();

		customList.add("Item1");

		String removedItem = customList.remove(0);

		assertEquals("Item1", removedItem);
		assertEquals(0, customList.getSize());
	}
}
