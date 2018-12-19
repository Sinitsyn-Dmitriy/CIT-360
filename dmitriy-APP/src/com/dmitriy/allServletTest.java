package com.dmitriy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class allServletTest {
//    public authorInfo() {
//        
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
    
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
    @Test
    public void authorInfo() {
    	allServlet authorInfo = new allServlet();
    	String i = authorInfo.authorInfo("Dmitriy", "Sinitsyn");
        assertEquals("Dmitriy Sinitsyn", i);
    }

    
    // assertTrue()
    @Test
    public void authorInfo2() {
    	allServlet authorInfo = new allServlet();
        String i = authorInfo.authorInfo("Dmitriy", "Sinitsyn");
        assertTrue(i == "Dmitriy Sinitsyn");
    }
    
    // assertFalse()
    @Test
    public void authorInfo3() {
    	allServlet authorInfo = new allServlet();
    	String i = authorInfo.authorInfo("Dmitriy", "Sinitsyn");
        assertFalse(i == "John Doe");
    }	
    
    // assertNotNull()
    @Test
    public void testDivideTest4() {
    	allServlet authorInfo = new allServlet();
        String i = authorInfo.authorInfo("Dmitriy", "Sinitsyn");
        assertNotNull(i);
    }
	

}
