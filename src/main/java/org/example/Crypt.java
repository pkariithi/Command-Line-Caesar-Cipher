package org.example;

public class Crypt {
    protected int key;
    protected String text;
    protected String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String getAlphabet() {
        return alphabet;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet.toUpperCase();
    }

    public void setText(String text) {
        this.text = text.toUpperCase();
    }

    public String getText() {
        return text;
    }
}
