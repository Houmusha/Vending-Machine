import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    int cola = 100;
    int candy = 65;
    int chips = 50;

    @Test
    void main() {
    }

    @Test
    void coinReturn() {
    }

    @Test
    void selectProduct() {
        // exact price tests for products
        assertEquals(0, Main.selectProduct(cola, "cola"));
        assertEquals(0, Main.selectProduct(chips, "chips"));
        assertEquals(0, Main.selectProduct(candy, "candy"));

        // not enough money
        assertEquals(95, Main.selectProduct(95, "cola"));
        assertEquals(45, Main.selectProduct(45, "chips"));
        assertEquals(60, Main.selectProduct(60, "candy"));

        // too much money dispense change
        assertEquals(5, Main.selectProduct(105, "cola"));
        assertEquals(5, Main.selectProduct(55, "chips"));
        assertEquals(5, Main.selectProduct(70, "candy"));
    }

    @Test
    void inStock() {
        //product is in stock
        assertTrue(Main.inStock("cola", 5));
        assertTrue(Main.inStock("chips", 5));
        assertTrue(Main.inStock("candy", 5));

        //product is out of stock
        assertFalse(Main.inStock("cola", 0));
        assertFalse(Main.inStock("chips", 0));
        assertFalse(Main.inStock("candy", 0));
    }

    @Test
    void makeChange() {
        assertTrue(Main.makeChange(100));
        assertTrue(Main.makeChange(95));

        assertFalse(Main.makeChange(80));
    }
}