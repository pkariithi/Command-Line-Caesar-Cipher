package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncryptTest {
    Encrypt encrypt;

    @BeforeEach
    void setUp() {
        encrypt = new Encrypt();
    }

    @Test
    @DisplayName("test getters and setters")
    void testGettersAndSetters() {
        encrypt.setKey(5);
        encrypt.setText("Test");
        assertEquals(5, encrypt.getKey());
        assertEquals("TEST", encrypt.getText());
    }

    @Test
    @DisplayName("test encrypt with key of 1 and simple text")
    void testEncryptWithSimpleText() {
        encrypt.setKey(1);
        encrypt.setText("test");
        assertEquals("UFTU", encrypt.encrypt());
    }

    @Test
    @DisplayName("test encrypt with key of 20 and simple text")
    void testEncryptWithSimpleTextAndKey20() {
        encrypt.setKey(20);
        encrypt.setText("Safaricom");
        assertEquals("MUZULCWIG", encrypt.encrypt());
    }

    @Test
    @DisplayName("test encrypt with key of 1 and simple text beyond Z")
    void testEncryptWithSimpleTextBeyondZ() {
        encrypt.setKey(1);
        encrypt.setText("zebra");
        assertEquals("AFCSB", encrypt.encrypt());
    }

    @Test
    @DisplayName("test encrypt with key of 1 and mixed case text")
    void testEncryptWithMixedCase() {
        encrypt.setKey(1);
        encrypt.setText("TeStinGKeYOFone");
        assertEquals("UFTUJOHLFZPGPOF", encrypt.encrypt());
    }

    @Test
    @DisplayName("test encrypt with key of 1 and mixed case text, spaces and special characters")
    void testEncryptWithMixedCaseSpacesAndSpecialChars() {
        encrypt.setKey(1);
        encrypt.setText("TeStinG, KeY OF one!");
        assertEquals("UFTUJOH, LFZ PG POF!", encrypt.encrypt());
    }

    @Test
    @DisplayName("test encrypt with key of 18 and mixed case text, spaces and special characters")
    void testEncryptWithMixedCaseSpacesAndSpecialCharsKey18() {
        encrypt.setKey(18);
        encrypt.setText("\"Hello world\".toCharArray();");
        assertEquals("\"ZWDDG OGJDV\".LGUZSJSJJSQ();", encrypt.encrypt());
    }
}