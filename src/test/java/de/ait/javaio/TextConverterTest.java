package de.ait.javaio;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

class TextConverterTest {
    @Test
    void testConvertToLowerCase() throws IOException {
        TextConverter textConvertor =new TextConverter();
        StringReader stringReader = new StringReader("HeLLo JAVA");
        StringWriter stringWriter =new StringWriter();
        String result = textConvertor.convertToLowerCase(stringReader,stringWriter);
        assertEquals("java", result);
    }
}