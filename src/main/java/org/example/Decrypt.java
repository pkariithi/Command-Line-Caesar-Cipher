package org.example;

public class Decrypt extends Crypt {

    public Decrypt(int key, String text) {
        super();
        this.key = key;
        this.text = text.toUpperCase();
    }

    public Decrypt() {
    }

    public String decrypt() {
        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < this.text.length(); i++) {
            int pos = this.alphabet.indexOf(this.text.charAt(i));
            if(pos != -1) {
                int key = (pos - this.key) % 26;
                if (key < 0) {
                    key = this.alphabet.length() + key;
                }
                decrypted.append(this.alphabet.charAt(key));
            } else {
                decrypted.append(this.text.charAt(i));
            }
        }
        return decrypted.toString();
    }
}
