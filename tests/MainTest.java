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
        assertEquals(49, Main.selectProduct(49, "chips"));
        assertEquals(64, Main.selectProduct(64, "candy"));
        assertEquals(99, Main.selectProduct(99, "cola"));
    }
}