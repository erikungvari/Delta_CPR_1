package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalcTest {
    @Test
    public void addTest(){
        assertEquals(3, 1+2);
    }
    @Test
    public void subTest(){
        assertEquals(3, 4-1);
    }
    @Test
    public void mulTest(){
        assertEquals(6, 2*3);
    }
    @Test
    public void divTest(){
        assertEquals(3, 21/7);
        assertThrows(ArithmeticException.class, () -> Integer.divideUnsigned(2, 0));
    }
}
