/*
 * Caesar Cipher
 *
 * This is a project that exemplifies the use of the Caesar Cipher. It also can
 * be used for personal purposes such as communication of information lacking 
 * relevance or whichever usage found by the user.
 *
 * Author: Eng. Eduardo Basurto VÃ¡zquez
 * Email: contacto.ebv@gmail.com
 *
 * 2017 (c) Maquina Tonta
 * Email: maquinatonta1@gmail.com
 * 
 */
package com.security;

/**
 * This is the Caesar class modified for the 3.0 version of the program. This 
 * class was designed to be used as a reference in the whole program, 
 * implementing only static attributes and methods.
 * 
 * @author Eng. Eduardo Basurto
 */
public class Caesar {

    //Declaration of private variables
    private static String alphabet="";
    private static String resultProcess="";
    //End of variable declaration

    /**
     * Default constructor of the Caesar class. When the class is created, the 
     * fields are empty. The user sets the alphabet afterwards and the 
     * resultProcess only when a process is executed.
     */
    public Caesar() {

    }


    /**
     * Get method for the <code>alphabet</code> field. This is used to verify 
     * if a character is in the <code>alphabet</code> or to know the length 
     * of the alphabet to select a <code>key</code> range.
     *
     * @return the String containing the alphabet.
     * @see String
     */
    public static String getAlphabet() {
        return Caesar.alphabet;
    }

    /**
     * Set method for the <code>alphabet</code>. It is used when the user inputs
     *  the alphabet and creates the class reference. 
     * 
     * @param alpha The alphabet inputted by the user
     */
    public static void setAlphabet(String alpha) {
        Caesar.alphabet = alpha;
    }
    
    /**
     * Get method for the <code>resultProcess</code> field. This is used when 
     * the <code>FinalResult</code> form is created. It retrieves the result of
     *  the process.
     * 
     * @return The String containing the result of the cipher/decipher process
     */
    public static String getResult(){
        return Caesar.resultProcess;
    }
    
    /**
     * Set method for the <code>resultProcess</code> field. It is used when the 
     * user executed a process in the <code>CaesarFrame</code> form. It sets 
     * the final result in the class field.
     * 
     * @param res The result obtained from the process
     */
    public static void setResult(String res){
        Caesar.resultProcess = res;
    }

    /**
     * Method used by the class to cipher the message using the whole alphabet. 
     * It is used after only after establishing the values for 
     * <code>k</code> and <code>message</code>. 
     * 
     * @param message The message for the ciphering
     * @param key The key for the ciphering
     * @return The String containing the message ciphered
     * @see String
     */
    public static String cipher(String message, int key) {
        int pos;
        int displacement;
        int finalPos;
        String result = "";

        for (int i = 0; i < message.length(); i++) {
            pos = alphabet.indexOf(message.charAt(i));
            displacement = pos + key;
            finalPos = displacement % alphabet.length();
            result += alphabet.toCharArray()[finalPos];
        }

        return result;
    }
    
    /**
     * Method used by the class to decipher the message using the whole
     * alphabet. It is used only after establishing the values for 
     * <code>k</code> and <code>message</code>.
     * 
     * @param message The message for the deciphering
     * @param key The key for the deciphering
     * @return The String containing the message deciphered
     * @see String
     */
    public static String decipher(String message, int key) {
        int pos;
        int displacement;
        int finalPos;
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            pos = alphabet.indexOf(message.charAt(i));
            if (pos - key < 0) {
                pos += alphabet.length();
            }
            displacement = pos - key;
            finalPos = displacement % alphabet.length();
            result += alphabet.toCharArray()[finalPos];
        }
        return result;
    }

}
