package de.ait.homeworks34;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringProcessorTest {
    private StringProcessor stringProcessor;
    @BeforeEach
    public void setUp() {
        stringProcessor = new StringProcessor();
    }
    @Test
    @DisplayName("Проверка соединения строк")
    public void testConcatenate() {
        assertEquals("Hello Vitali", stringProcessor.concatenate("Hello", " Vitali"));
    }
    @Test
    @DisplayName("Проверка вычисления длины строки")
    public void testGetLength(){
        assertEquals(5,stringProcessor.getLength("Hello"));
    }
    @Test
    @DisplayName("Проверка реверса строки")
    public void testReverse(){
    assertEquals("olleH",stringProcessor.reverse("Hello"));
    }
    @Test
    @DisplayName("Проверка определения палиндрома")
    public void testIsPalindrome(){
        assertEquals(true,stringProcessor.isPalindrome("racecar"));
    }

}
