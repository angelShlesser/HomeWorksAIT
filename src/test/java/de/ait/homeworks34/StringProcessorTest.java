package de.ait.homeworks34;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringProcessorTest {
    private StringProcessor stringProcessor;

    @BeforeEach
    void setUp() {
        stringProcessor = new StringProcessor();
    }

    @Test
    @DisplayName("Проверка соединения строк")
    void testConcatenate() {
        assertEquals("Hello Vitali", stringProcessor.concatenate("Hello", " Vitali"));
    }

    @Test
    @DisplayName("Проверка соединения строк null One")
    void testConcatenateNull() {
        assertEquals("Hello", stringProcessor.concatenate("Hello", null));
    }
    @Test
    @DisplayName("Проверка соединения строк null Two")
    void testConcatenateNullTwo() {
        Assertions.assertEquals("Vitali", stringProcessor.concatenate(null, "Vitali"));
    }

    @Test
    @DisplayName("Проверка вычисления длины строки")
    void testGetLength() {
        assertEquals(5, stringProcessor.getLength("Hello"));
    }
    @Test
    @DisplayName("Проверка вычисления длины строки null")
    void testGetLengthNull() {
        assertEquals(0, stringProcessor.getLength(null));
    }
    @Test
    @DisplayName("Проверка реверса строки")
    void testReverse() {
        assertEquals("olleH", stringProcessor.reverse("Hello"));
    }
    @Test
    @DisplayName("Проверка реверса строки Plus Null")
    void testReversePlusNull(){
        assertEquals(null,stringProcessor.reversePlus(null));
    }
    @Test
    @DisplayName("Проверка реверса строки Plus")
    void testReversePlus(){
        assertEquals("йилатиВ",stringProcessor.reversePlus("Виталий"));
    }
    @Test
    @DisplayName("Проверка определения палиндрома")
    void testIsPalindrome() {
        assertTrue(stringProcessor.isPalindrome("racecar"));
    }
    @Test
    @DisplayName("Проверка определения палиндрома Plus")
    void testIsPalindromePlus(){
        assertEquals(true, stringProcessor.isPalindromePlus("Заказ"));
    }
    @Test
    @DisplayName("Проверка определения палиндрома Plus Null")
    void testIsPalindromePlusNull(){
        assertFalse(stringProcessor.isPalindromePlus(null));
    }
    @Test
    @DisplayName("Проверка определения палиндрома Plus False")
    void testIsPalindromePlusFalse(){
        assertEquals(false, stringProcessor.isPalindromePlus("Виталий"));
    }
}
