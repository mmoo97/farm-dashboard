package farm.dashboard;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class ItemContainerTest {

    ItemContainer itemContainer;

    @Before
    public void setUp(){
       itemContainer = new ItemContainer();
    }

    @Test
    public void testSetName(){
        assertNull(itemContainer.getName());
        itemContainer.setName("Name 1");
        assertNotNull("ItemContainer name was not set", itemContainer.getName());
        assertEquals(itemContainer.getName(), "Name 1");
    }

    @Test
    public void testSetPrice(){
        assertEquals(itemContainer.getPrice(), 0.0, 0.1);
        itemContainer.setPrice(3.14);
        assertNotNull("ItemContainer price was not set", itemContainer.getPrice());
        assertEquals(itemContainer.getPrice(), 3.14, 0.001);
    }

    @Test
    public void testSetLocationX(){
        assertEquals(itemContainer.getLocationX(), 0, 0.001);
        itemContainer.setLocationX(3);
        assertNotNull("ItemContainer X location was not set", itemContainer.getLocationX());
        assertEquals(itemContainer.getLocationX(), 3, 0.001);
    }

    @Test
    public void testSetLocationY(){
        assertEquals(itemContainer.getLocationY(), 0, 0.001);
        itemContainer.setLocationY(6);
        assertNotNull("ItemContainer Y location was not set", itemContainer.getLocationY());
        assertEquals(itemContainer.getLocationY(), 6, 0.001);
    }

    @Test
    public void testSetPosition(){
        double originalX = itemContainer.getLocationX();
        double originalY = itemContainer.getLocationY();
        itemContainer.setPosition(8, 10);
        assertNotEquals(originalX, itemContainer.getLocationX());
        assertNotEquals(originalY, itemContainer.getLocationY());
        assertEquals(itemContainer.getLocationX(), 8, 0.001);
        assertEquals(itemContainer.getLocationY(), 10, 0.001);
    }

    @Test
    public void testSetLength(){
        assertEquals(itemContainer.getLength(), 0);
        itemContainer.setLength(7);
        assertNotNull("ItemContainer X location was not set", itemContainer.getLength());
        assertEquals(itemContainer.getLength(), 7);
    }

    @Test
    public void testSetWidth(){
        assertEquals(itemContainer.getWidth(), 0);
        itemContainer.setWidth(2);
        assertNotNull("ItemContainer X location was not set", itemContainer.getWidth());
        assertEquals(itemContainer.getWidth(), 2);
    }

    @Test
    public void testSetHeight(){
        assertEquals(itemContainer.getHeight(), 0);
        itemContainer.setHeight(18);
        assertNotNull("ItemContainer X location was not set", itemContainer.getHeight());
        assertEquals(itemContainer.getHeight(), 18);
    }

    @Test
    public void testRemove(){
        ItemContainer temp = new ItemContainer();
        temp.setName("ree");
        itemContainer.add(temp);
        assertNotEquals(itemContainer.getChildren().size(), 0);
        assertNotNull("Did not remove the item", itemContainer.remove(temp));
        assertEquals(itemContainer.getChildren().size(), 0);
    }

}
