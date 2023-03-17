# Vigenere-Cipher-Breaker
Vigenere cipher breaker in Java. Reads encrypted text, attempts to decipher it using the Vigenere cipher. Supports multiple languages.

This is a Java program that can decrypt messages encrypted with a Vigenere cipher. It uses a combination of frequency analysis, guessing the length of the key, and brute force to crack the cipher.
Getting Started
Prerequisites

To run this program, you will need to have the following installed:

    Java JDK (version 8 or higher)
    Gradle (version 6.0 or higher)

Installation

    Clone this repository to your local machine.
    Open a terminal or command prompt and navigate to the root directory of the project.
    Build the project using Gradle: gradle build

Usage

To use the program, you can run the VigenereBreaker class with the following command:

css

java VigenereBreaker [dictionary_file] [encrypted_file]

The dictionary_file should be a text file containing a list of words in the language of the encrypted message. The encrypted_file should be a text file containing the encrypted message.

For example, to decrypt an English message using the included dictionary file and encrypted message file, run:

bash

java VigenereBreaker dictionaries/English words.txt messages/encrypted message.txt

The program will print out the decrypted message and the key used to decrypt it.
Contributing

If you would like to contribute to this project, please open a pull request with your changes. Make sure to include tests for any new functionality.
License

# documentation
Introduction:

The VigenereBreaker project is a Java program that can decrypt messages that have been encoded using the Vigenère cipher. The Vigenère cipher is a polyalphabetic substitution cipher that uses a keyword to determine which Caesar cipher to use to encode each letter in the message. This project implements a brute-force attack to crack the Vigenère cipher by guessing the length of the keyword and using frequency analysis to determine the most likely letter for each position in the keyword.

The project has been expanded to include the ability to crack messages in multiple languages. This is accomplished by writing two new methods and modifying two methods that were already written.

How to use the program:

To use the VigenereBreaker program, follow these steps:

Step 1: Download and install Java

Before you can use the VigenereBreaker program, you need to have Java installed on your computer. You can download Java from the official website: https://www.java.com/en/download/

Step 2: Download the project files

Download the VigenereBreaker project files from the provided source.

Step 3: Run the program

Once you have downloaded the project files, open a command prompt or terminal window and navigate to the directory containing the project files. Then, type the following command to run the program:

java VigenereBreaker

This will run the program and prompt you to enter the name of the file containing the encrypted message.

Step 4: Enter the name of the encrypted message file

When prompted, enter the name of the file containing the encrypted message. The file should be in the same directory as the program.

Step 5: Choose the language of the message

The program will prompt you to choose the language of the message. You can choose from the following languages: Danish, Dutch, English, French, German, Italian, Portuguese, and Spanish.

Step 6: Wait for the program to decrypt the message

The program will use a brute-force attack to crack the Vigenère cipher and determine the most likely key. This may take some time, depending on the length of the message and the complexity of the key.

Step 7: View the decrypted message

Once the program has finished running, it will display the decrypted message on the screen.

Additional methods:

In addition to the basic usage described above, the VigenereBreaker program also includes the following methods:

    mostCommonCharIn:

This method takes a HashSet of Strings as a parameter and finds out which character, of the letters in the English alphabet, appears most often in the words in the HashSet. It returns this most commonly occurring character.

    breakForAllLangs:

This method takes a String representing an encrypted message and a HashMap mapping a String representing the name of a language to a HashSet of Strings containing the words in that language. It tries breaking the encryption for each language, and sees which gives the best results. The decrypted message as well as the language that was identified for the message is printed.

    breakForLanguage:

This method has been modified to make use of the mostCommonCharIn method to find the most common character in the language, and pass that to tryKeyLength instead of ‘e’.

    breakVigenere:

This method has been modified to read many dictionaries instead of just one. It makes a HashMap mapping Strings to a HashSet of Strings that maps each language name to the set of words in its dictionary. It reads each of the dictionaries that have been provided (Danish, Dutch, English, French, German, Italian, Portuguese, and Spanish) and stores the words in the HashMap. Once this has been done, breakForAllLangs is called, passing in the message
