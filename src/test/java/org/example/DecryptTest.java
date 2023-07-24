package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecryptTest {

    Decrypt decrypt;

    @BeforeEach
    void setUp() {
        decrypt = new Decrypt();
    }

    @Test
    @DisplayName("test getters and setters")
    void testGettersAndSetters() {
        decrypt.setKey(5);
        decrypt.setText("Test");
        assertEquals(5, decrypt.getKey());
        assertEquals("TEST", decrypt.getText());
    }

    @Test
    @DisplayName("test decrypt with key of 1 and simple text")
    void testDecryptWithSimpleText() {
        decrypt.setKey(1);
        decrypt.setText("UFTU");
        assertEquals("TEST", decrypt.decrypt());
    }

    @Test
    @DisplayName("test decrypt with key of 20 and simple text")
    void testDecryptWithSimpleTextAndKey20() {
        decrypt.setKey(20);
        decrypt.setText("Muzulcwig");
        assertEquals("SAFARICOM", decrypt.decrypt());
    }

    @Test
    @DisplayName("test decrypt with key of 1 and simple text beyond Z")
    void testDecryptWithSimpleTextBeyondZ() {
        decrypt.setKey(1);
        decrypt.setText("AFCSB");
        assertEquals("ZEBRA", decrypt.decrypt());
    }

    @Test
    @DisplayName("test decrypt with key of 1 and mixed case text")
    void testDecryptWithMixedCase() {
        decrypt.setKey(1);
        decrypt.setText("UFtUjOhLfzPGpOf");
        assertEquals("TESTINGKEYOFONE", decrypt.decrypt());
    }

    @Test
    @DisplayName("test decrypt with key of 1 and mixed case text, spaces and special characters")
    void testDecryptWithMixedCaseSpacesAndSpecialChars() {
        decrypt.setKey(1);
        decrypt.setText("Uftujoh, Lfz Pg Pof!");
        assertEquals("TESTING, KEY OF ONE!", decrypt.decrypt());
    }

    @Test
    @DisplayName("test decrypt with key of 18 and mixed case text, spaces and special characters")
    void testDecryptWithMixedCaseSpacesAndSpecialCharsKey18() {
        decrypt.setKey(18);
        decrypt.setText("\"Zwddg OGJdv\".LgUZSjSjjSq();");
        assertEquals("\"HELLO WORLD\".TOCHARARRAY();", decrypt.decrypt());
    }
}