package farm.dashboard;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class ItemTest {

    Item item;

    @Before
    public void setUp(){
       item = new Item();
    }

    @Test
    public void testSetName(){
        assertNull(item.getName());
        item.setName("Name 1");
        assertNotNull("Item name was not set", item.getName());
        assertEquals(item.getName(), "Name 1");
    }

    @Test
    public void testSetPrice(){
        assertEquals(item.getPrice(), 0.0, 0.1);
        item.setPrice(3.14);
        assertNotNull("Item price was not set", item.getPrice());
        assertEquals(item.getPrice(), 3.14, 0.001);
    }

    @Test
    public void testSetLocationX(){
        assertEquals(item.getLocationX(), 0, 0.001);
        item.setLocationX(3);
        assertNotNull("Item X location was not set", item.getLocationX());
        assertEquals(item.getLocationX(), 3, 0.001);
    }

    @Test
    public void testSetLocationY(){
        assertEquals(item.getLocationY(), 0, 0.001);
        item.setLocationY(6);
        assertNotNull("Item Y location was not set", item.getLocationY());
        assertEquals(item.getLocationY(), 6, 0.001);
    }

    @Test
    public void testSetPosition(){
        double originalX = item.getLocationX();
        double originalY = item.getLocationY();
        item.setPosition(8, 10);
        assertNotEquals(originalX, item.getLocationX());
        assertNotEquals(originalY, item.getLocationY());
        assertEquals(item.getLocationX(), 8, 0.001);
        assertEquals(item.getLocationY(), 10, 0.001);
    }

    @Test
    public void testSetLength(){
        assertEquals(item.getLength(), 0);
        item.setLength(7);
        assertNotNull("Item X location was not set", item.getLength());
        assertEquals(item.getLength(), 7);
    }

    @Test
    public void testSetWidth(){
        assertEquals(item.getWidth(), 0);
        item.setWidth(2);
        assertNotNull("Item X location was not set", item.getWidth());
        assertEquals(item.getWidth(), 2);
    }

    @Test
    public void testSetHeight(){
        assertEquals(item.getHeight(), 0);
        item.setHeight(18);
        assertNotNull("Item X location was not set", item.getHeight());
        assertEquals(item.getHeight(), 18);
    }

    @Test public void testClassExists() {
        DashboardApp classUnderTest = new DashboardApp();
        assertNotNull("You really must have messed up", 1);
    }

}
