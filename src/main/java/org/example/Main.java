package org.example;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kindly choose your action: \n 1. Encrypt \n 2. Decrypt \n 3. Quit ");

        // The users input
        int choice = scanner.nextInt();
        scanner.nextLine();

        // check choice
        if (choice == 1) {

            // get text ROVVY GYBVN!
            System.out.println("Step 1/2 : Kindly enter the text to be encrypted");
            String plainText = scanner.nextLine().toUpperCase();
            if(plainText.isEmpty()) {
                System.out.println("You have not entered any text to be encrypted. kindly try again");
                System.exit(0);
            }

            // get key
            System.out.println("Step 2/2 : Kindly choose a key to cipher the text (A number greater than zero)");
            int encryptKey = scanner.nextInt();
            if(encryptKey < 1) {
                System.out.println("Kindly enter a key greater than zero and try again.");
                System.exit(0);
            }

            // encrypt
            Encrypt encrypt = new Encrypt(encryptKey, plainText);
            System.out.println(String.format("Your encrypted text is: %s ", encrypt.encrypt()));
        } else if (choice == 2) {

            // get text
            System.out.println("Step 1/2 : Kindly enter the text to be decrypted");
            String encryptedText = scanner.nextLine().toUpperCase();
            if(encryptedText.isEmpty()) {
                System.out.println("You have not entered any text to be decrypted. kindly try again");
                System.exit(0);
            }

            // get key
            System.out.println("Step 2/2 : Kindly enter the cipher key used to encrypt the text (A number greater than zero)");
            int decryptKey = scanner.nextInt();
            if(decryptKey < 1) {
                System.out.println("Kindly enter a key greater than zero and try again.");
                System.exit(0);
            }

            // decrypt
            Decrypt decrypt = new Decrypt(decryptKey, encryptedText);
            System.out.println(String.format("Your decrypted text is: %s", decrypt.decrypt()) );
        } else if (choice == 3){
            System.exit(0);
        } else {
            System.out.println("You have entered the wrong input. Kindly try again");
        }
    }
}