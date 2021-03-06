package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

/**
 * Test class for the Triangle implementation.
 */
public class TriangleTest {

	
	//Statement Tests
    
    
    @Test
    public void test_state_invalid(){
    	int a = 0;
    	int b = 0;
    	int c = 0; 
    	
    	//Test a non-existent triangle
    	Type actual = Triangle.classify(a,b,c);
    	Type expected = INVALID;
    	assertEquals(actual, expected);
    	
    	a = 10;
    	b = 10;
    	
    	//test incase of impossible Triangle dimensions
    	actual = Triangle.classify(a,b,c);
    	assertEquals(actual,expected);
    	
    	c = 200;
    	
    	actual = Triangle.classify(a,b,c);
    	
    	assertEquals(actual,expected);
    	
    }
    
    @Test
    public void test_state_equilateral() {
        Type actual = Triangle.classify(10, 10, 10);
        Type expected = EQUILATERAL;
        assertEquals(actual, expected);
    }
    
    @Test
    public void test_state_scalene() {
    	Type actual = Triangle.classify(3,5,6);
    	Type expected = SCALENE;
    	
    	assertEquals(actual,expected);
    	
    }
    
    @Test
    public void test_state_isosceles() {
    	Type actual1 = Triangle.classify(3,5,5);
    	Type actual2 = Triangle.classify(5,3,5);
    	Type actual3 = Triangle.classify(5,5,3);
    	Type expected = ISOSCELES;
    	
    	assertEquals(actual1,expected);
    	assertEquals(actual2,expected);
    	assertEquals(actual3,expected);
    	
    }
    
    
    @Test
    public void test_condition() {
        Type expected;
        Type actual;
        
        //Tests 'false' for all conditions in line 20
        expected = INVALID;
        actual = Triangle.classify(0,0,0);
        assertEquals(actual, expected);
        
        //Tests 'true' for lines 24, 27, 30
        //Tests 'false' for line 33
        //Tests 'true' for line 40
        expected = EQUILATERAL;
        actual = Triangle.classify(1,1,1);
        assertEquals(actual, expected);
        
        //Test true and false for all conditions in line 34. 
        //Tests 'true' for line 20 conditions
        //Tests 'false' for lines 24, 27, 30, 33
        expected = INVALID;
        actual = Triangle.classify(1, 2, 3);
        assertEquals(actual, expected);
        
        expected = INVALID;
        actual = Triangle.classify(2, 3, 1);
        assertEquals(actual, expected);
        
        expected = INVALID;
        actual = Triangle.classify(3, 1 ,2);
        assertEquals(actual, expected);
        
         //'true' for both conditionals in line 43
        expected = ISOSCELES;
        actual = Triangle.classify(2, 2, 1);
        assertEquals(actual, expected);
        
        //'true' for both conditionals in line 45 (and false for first condition of 43)
        expected = ISOSCELES;
        actual = Triangle.classify(2, 1, 2);
        assertEquals(actual, expected);
        
        //'true' for both conditionals in line 47
        expected = ISOSCELES;
        actual = Triangle.classify(1, 2, 2);
        assertEquals(actual, expected);
    	
        //'false' for all conditionals in line 43, 45, and 47 (except first condition of 43)
        expected = INVALID;
        actual = Triangle.classify(Integer.MAX_VALUE, Integer.MIN_VALUE, 10);
        assertEquals(actual, expected);
    	
    }
    
    
}
