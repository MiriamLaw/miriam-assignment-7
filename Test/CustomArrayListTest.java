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
		// Arrange: Create an instance of CustomArrayList
		CustomArrayList<String> customArrayList = new CustomArrayList<>();

		// Act: Add an item to the list
		boolean result = customArrayList.add("Test Item");

		// Assert: Check if the add method returns true (success)
		assertTrue(result);

		// Assert: Check if the list contains the added item
		assertEquals("Test Item", customArrayList.get(0));
	}

	@Test
	public void testAddToEmptyList() {

		// Set up the test
		CustomList<String> customList = new CustomArrayList<>();

		// Ensure the list is empty to start with
		assertEquals(0, customList.getSize());

		// Perform the action
		boolean added = customList.add("Item1");

		// Assert the result
		assertTrue(added);
		assertEquals(1, customList.getSize());

	}

	@Test
	public void testAddAtIndex() {
		// Set up test to see if items get shuffled to the right when adding item at
		// beginning of list
		CustomList<String> customList = new CustomArrayList<>();

		// Add initial items
		customList.add("Item2");
		customList.add("Item3");

		// Ensure list contains initial items
		assertEquals(2, customList.getSize());
		assertEquals("Item2", customList.get(0));
		assertEquals("Item3", customList.get(1));

		// perform the action
		boolean added = customList.add(0, "Item1");

		// Assert result
		assertTrue(added);
		assertEquals(3, customList.getSize());

		// Verify the new item has been added at index 0 and other items shuffled to
		// right
		assertEquals("Item1", customList.get(0));
		assertEquals("Item2", customList.get(1));
		assertEquals("Item3", customList.get(2));
	}

	@Test
	public void testAddItemToEndOfList() {
		CustomList<String> customList = new CustomArrayList<>();

		// add items to list
		customList.add("Item1");
		customList.add("Item2");

		// make sure list size is correct
		assertEquals(2, customList.getSize());

		// perform action
		boolean added = customList.add("Item3");

		// assert the result
		assertTrue(added);
		assertEquals(3, customList.getSize());
		assertEquals("Item3", customList.get(2));
	}

	@Test
	public void testAddItemAtSpecificIndex() {
		CustomList<String> customList = new CustomArrayList<>();

		customList.add("Item1");
		customList.add("Item2");

		// ensure size is correct
		assertEquals(2, customList.getSize());

		// perform action
		boolean added = customList.add(1, "Item3");

		// assert result
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

		// attempt to add item at out of bounds index
		try {
			customList.add(5, "Item3"); // out of bounds index
			fail("Expected IndexOutOfBoundsException but it wasn't thrown");
		} catch (IndexOutOfBoundsException e) {
			// should be thrown, test should pass
			assertEquals(2, customList.getSize());
		}

	}

	@Test
	public void testAddMultipleItemsAtVariousPositions() {
		CustomList<String> customList = new CustomArrayList<>();

		// add to end
		customList.add("Item1");
		assertEquals(1, customList.getSize());
		assertEquals("Item1", customList.get(0));

		// add to beginning
		customList.add(0, "Item2");
		assertEquals(2, customList.getSize());
		assertEquals("Item2", customList.get(0));
		assertEquals("Item1", customList.get(1));

		// add to middle
		customList.add(1, "Item3");
		assertEquals(3, customList.getSize());
		assertEquals("Item2", customList.get(0));
		assertEquals("Item3", customList.get(1));
		assertEquals("Item1", customList.get(2));
	}

	@Test
	public void testAddToFullList() {
		CustomList<String> customList = new CustomArrayList<>();

		// fill list to capacity
		for (int i = 1; i <= 10; i++) {
			customList.add("Item" + i);
		}
		// should be a full list
		assertEquals(10, customList.getSize());

		// add additional item
		customList.add("Item11");

		// list should dynamically resize to accommodate new item
		assertEquals(11, customList.getSize());
		assertEquals("Item11", customList.get(10));
	}

	@Test
	public void testAddNullItem() {
		CustomList<String> customList = new CustomArrayList<>();

		// add null item
		boolean added = customList.add(null);

		// assert result
		assertTrue(added);
		assertEquals(1, customList.getSize());

		// verify item added is null
		assertNull(customList.get(0));
	}

	@Test
	public void testRemove() {
		CustomList<String> customList = new CustomArrayList<>();
		// Arrange
		customList.add("Item1");
		customList.add("Item2");
		customList.add("Item3");

		// Act: remove item from list
		String removedItem = customList.remove(1);

		// Assert: check if was removed and list adjusted
		assertEquals("Item2", removedItem);
		assertEquals(2, customList.getSize());
		assertEquals("Item1", customList.get(0));
		assertEquals("Item3", customList.get(1));

	}

	@Test
	public void testRemoveFromEmptyList() {
		// Arrange
		CustomList<String> customList = new CustomArrayList<>();
		// Act: attempt to remove from empty list
		try {
			customList.remove(0);
			fail("Expected IndexOutOfBoundsException but it wasn't thrown");
		} catch (IndexOutOfBoundsException e) {
			// Ensure exception is thrown
			assertEquals(0, customList.getSize());
		} catch (NullPointerException e) {
			// handle null clazz
			assertEquals(0, customList.getSize());
		}

	}

	@Test
	public void testRemoveFromBeginning() {
		// Arrange
		CustomList<String> customList = new CustomArrayList<>();

		customList.add("Item1");
		customList.add("Item2");
		customList.add("Item3");

		// Act: remove at index 0
		String removedItem = customList.remove(0);

		// Assert: check if removed and list adjusted
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
