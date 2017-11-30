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
 * The Caesar class is the responsible of the functionality behind the Caesar
 * cipher program. Here it contains the methods to cipher, or decipher, 
 * depending on which mode is selected.
 * 
 * @author Eng. Eduardo Basurto
 */
public class Caesar {

    //Declaration of private variables
    private int k;
    private String message;
    private final String alphabet = "QW0ERTYU1IOPAS2DFGHJ3KLZX4CVBNM5qwert6yui"
            + "op7asdfg8hjkl9zxcvbnm,.-{}´+¿'|<>°>¬!\"#$%&/()=?¡*¨][_;:";
    private final String restrictedAlphabet = "QW0ERTYU1IOPAS2DFGHJ3KLZX4CVBNM5"
            + "qwert6yuiop7asdfg8hjkl9zxcvbnm";
    //End of variable declaration

    /**
     * Default constructor of the Caesar class. This is used only for reference
     * in the CaesarFrame class.
     * <p>
     * The behaviour of this object is:
     * <ul>
     * <li>value for <code>k</code> is zero </li>
     * <li>value for <code>message</code> is null</li>
     * <li><code>alphabet</code> and <code>restrictedAlphabet</code>
     * fields are <code>final</code></li>
     * </ul>
     */
    public Caesar() {

    }

    /**
     * <code>onstructor</code> to establish the key and the message for the 
     * <code>Caesar</code> object. This is used mainly to initiate a 
     * cipher/decipher process
     *
     * @param ka The key for the <code>Caesar</code> object
     * @param text The text to be ciphered/deciphered
     */
    public Caesar(int ka, String text) {
        k = ka;
        message = text;
    }

    /**
     * Get method for the <code>alphabet</code> field. This is used to verify 
     * if a character is in the <code>alphabet</code> or to know the length 
     * of the alphabet to select a <code>key</code> range.
     *
     * @return the String containing the <code>alphabet</code>
     * @see String
     */
    public String getAlphabet() {
        return alphabet;
    }

    /**
     * Get method for the <code>restrictedAlphabet</code> field. This is used 
     * to verify if a character is in the <code>restrictedAlphabet</code> or to 
     * know the length of the alphabet to select a <code>key</code> range.
     *
     * @return the String containing the <code>restricedAlphabet</code>
     * @see String
     */
    public String getRestrictedAlphabet() {
        return restrictedAlphabet;
    }

    /**
     * Method used by the class to cipher the message using the whole alphabet. 
     * It is used after only after establishing the values for 
     * <code>k</code> and <code>message</code>. 
     * 
     * @return The String containing the message ciphered
     * @see String
     */
    public String cipher() {
        int pos;
        int displacement;
        int finalPos;
        String result = "";

        for (int i = 0; i < message.length(); i++) {
            pos = alphabet.indexOf(message.charAt(i));
            displacement = pos + k;
            finalPos = displacement % alphabet.length();
            result += alphabet.toCharArray()[finalPos];
        }

        return result;
    }
    
    /**
     * Method used by the class to cipher the message using only alfanumeric
     * characters. It is used only after establishing the values for 
     * <code>k</code> and <code>message</code>.
     * 
     * @return The alfanumeric String containing the message ciphered
     * @see String
     */
    public String restrictedCipher() {
        int pos;
        int displacement;
        int finalPos;
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            pos = restrictedAlphabet.indexOf(message.charAt(i));
            displacement = pos + k;
            finalPos = displacement % restrictedAlphabet.length();
            result += restrictedAlphabet.toCharArray()[finalPos];
        }

        return result;
    }

    /**
     * Method used by the class to decipher the message using the whole
     * alphabet. It is used only after establishing the values for 
     * <code>k</code> and <code>message</code>.
     * 
     * @return The String containing the message deciphered
     * @see String
     */
    public String decipher() {
        int pos;
        int displacement;
        int finalPos;
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            pos = alphabet.indexOf(message.charAt(i));
            if (pos - k < 0) {
                pos += alphabet.length();
            }
            displacement = pos - k;
            finalPos = displacement % alphabet.length();
            result += alphabet.toCharArray()[finalPos];
        }
        return result;
    }

    /**
     * Method used by the class to decipher the message using only alfanumeric
     * characters. It is used only after establishing the values for 
     * <code>k</code> and <code>message</code>.
     * 
     * @return The alphanumeric String containing the message deciphered
     * @see String 
     */
    public String restrictedDecipher() {
        int pos;
        int displacement;
        int finalPos;
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            pos = restrictedAlphabet.indexOf(message.charAt(i));
            if (pos - k < 0) {
                pos += restrictedAlphabet.length();
            }
            displacement = pos - k;
            finalPos = displacement % restrictedAlphabet.length();
            result += restrictedAlphabet.toCharArray()[finalPos];
        }
        return result;
    }

}
