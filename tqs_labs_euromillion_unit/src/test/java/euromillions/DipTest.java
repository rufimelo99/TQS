/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euromillions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * @author ico0
 */
public class DipTest {

    private Dip instance;


    public DipTest() {
    }

    @BeforeEach
    public void setUp() {
        instance = new Dip(new int[]{10, 20, 30, 40, 50}, new int[]{1, 2});
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    //@Disabled
    @Test
    public void testConstructorFromBadArrays() {
        /*doubts
        como ver se é levantada uma excecao no gral, nao apenas uma especifica?
         */

        assertThrows(IllegalArgumentException.class, () -> {
            instance = new Dip(new int[]{10, 20, 30, 40, 70}, new int[]{1, 2});
        }, " exception was not raised when the arrays have invalid numbers");

    }

    @Test
    public void testFormat() {
        // note: correct the implementation of the format(), not the test...
        String result = instance.format();
        assertEquals("N[ 10 20 30 40 50] S[ 1 2]", result, "format as string: formatted string not as expected. ");
    }

}
