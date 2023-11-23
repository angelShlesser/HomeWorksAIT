package de.ait.homeworks51;

import de.ait.homeworks43.BankAccount;
import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

class TextTransformationOnlineTest {
    private  TextTransformation textTransformation;
    LogCaptor logCaptor = LogCaptor.forClass(TextTransformationOnline.class);

    @BeforeEach
    void setUp() {
        textTransformation = new TextTransformation();
    }

    @Test
    void testWriteReversedTextFileSuccess() throws IOException {
        StringReader stringReader = new StringReader("Amazon");
        StringWriter stringWriter = new StringWriter();
        logCaptor.setLogLevelToInfo();
        TextTransformationOnline.writeReversedTextFile(stringReader,stringWriter);
        assertTrue(logCaptor.getInfoLogs().contains("Запись успешно завершена"));
    }

    @Test
    void testReverserStringSuccess() {
        String reverseResult = TextTransformationOnline.reverserString("Amazon");
        assertEquals("nozamA",reverseResult);
    }
}