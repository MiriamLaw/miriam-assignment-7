import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    	
    	//Set up the test
    	CustomList<String> customList = new CustomArrayList<>();
    	
    	//Ensure the list is empty to start with
    	assertEquals(0, customList.getSize());
    	
    	//Perform the action
    	boolean added = customList.add("Item1");
    	
    	//Assert the result
    	assertTrue(added);
    	assertEquals(1, customList.getSize());
    	
    }
    @Test
    public void testAddAtIndex0() {
    	//Set up test to see if items get shuffled to the right when adding item at beginning of list
    	CustomList<String> customList = new CustomArrayList<>();
    	
    	//Add initial items
    	customList.add("Item2");
    	customList.add("Item3");
    	
    	//Ensure list contains initial items
    	assertEquals(2, customList.getSize());
    	assertEquals("Item2", customList.get(0));
    	assertEquals("Item3", customList.get(1));
    	
    	//perform the action
    	boolean added = customList.add(0, "Item1");
    	
    	//Assert result
    	assertTrue(added);
    	assertEquals(3, customList.getSize());
    	
    	//Verify the new item has been added at index 0 and other items shuffled to right
    	assertEquals("Item1", customList.get(0));
    	assertEquals("Item2", customList.get(1));
    	assertEquals("Item3", customList.get(2));
    }
    @Test
    public void testAddItemToEndOfList() {
    	CustomList<String> customList = new CustomArrayList<>();
    	
    	//add items to list
    	customList.add("Item1");
    	customList.add("Item2");
    	
    	//make sure list size is correct
    	assertEquals(2, customList.getSize());
    	
    	//perform action
    	boolean added = customList.add("Item3");
    	
    	//assert the result
    	assertTrue(added);
    	assertEquals(3, customList.getSize());
    	assertEquals("Item3", customList.get(2));
    }
    @Test
    public void testAddItemAtSpecificIndex() {
    	CustomList<String> customList = new CustomArrayList<>();
    	
    	customList.add("Item1");
    	customList.add("Item2");
    	
    	//ensure size is correct
    	assertEquals(2, customList.getSize());
    	
    	//perform action
    	boolean added = customList.add(1, "Item3");
    	
    	//assert result
    	assertTrue(added);
    	assertEquals(3, customList.getSize());
    	assertEquals("Item1", customList.get(0));
    	assertEquals("Item3", customList.get(1));
    	assertEquals("Item2", customList.get(2));
    }
}
