/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dmitriysinitsyn
 */
public class divideTest {
    
    public divideTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of divideTest method, of class divide.
     */
    // assertEquals()
    @Test
    public void testDivideTest1() {
        divide newDivide = new divide();
        int i = newDivide.divideTest(100, 5);
        assertEquals(20, i);
    }

    
    // assertTrue()
    @Test
    public void testDivideTest2() {
        divide newDivide = new divide();
        int i = newDivide.divideTest(100, 5);
        assertTrue(i == 20);
    }
    
    // assertFalse()
    @Test
    public void testDivideTest3() {
        divide newDivide = new divide();
        int i = newDivide.divideTest(100, 5);
        assertFalse(i == 10);
    }
    
    // assertNotNull()
    @Test
    public void testDivideTest4() {
        divide newDivide = new divide();
        int i = newDivide.divideTest(100, 5);
        assertNotNull(i);
    }
    
    //assertNull()
    @Test
    public void testDivideTest5() {
        divide newDivide = new divide();
        int i = newDivide.divideTest(0, 5);
        assertNull(i);
    }
    
    //assertSame()
    @Test
    public void testDivideTest6() {
        divide newDivide = new divide();
        int i = newDivide.divideTest(100, 5);
        int x = newDivide.divideTest(200, 10);
        assertSame(i, x);
    }

    //assertNotSame()    
    @Test
    public void testDivideTest7() {
        divide newDivide = new divide();
        int i = newDivide.divideTest(100, 5);
        int x = newDivide.divideTest(100, 10);
        assertNotSame(i, x);
    }
    
    //assertArrayEquals()
    public void testDivideTest8() {
        divide newDivide = new divide();
        int [] i = new int[] {newDivide.divideTest(100, 5)};
        int [] x = new int []{newDivide.divideTest(100, 10)};
        assertArrayEquals(i, x);
        
    }
}
