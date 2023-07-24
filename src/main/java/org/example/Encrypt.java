package org.example;

public class Encrypt extends Crypt {

    public Encrypt(int key, String text) {
        this.key = key;
        this.text = text.toUpperCase();
    }

    public Encrypt() {
    }

    public String encrypt() {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < this.text.length(); i++) {
            int pos = this.alphabet.indexOf(this.text.charAt(i));
            if(pos != -1) {
                int key = (this.key + pos) % 26;
                encrypted.append(this.alphabet.charAt(key));
            } else {
                encrypted.append(this.text.charAt(i));
            }
        }
        return encrypted.toString();
    }

}
