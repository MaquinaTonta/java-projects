/*
 * Caesar Cipher
 *
 * This is a project that exemplifies the use of the Caesar Cipher. It also can
 * be used for personal purposes such as communication of information lacking 
 * relevance or whichever usage found by the user.
 *
 * Author: Eng. Eduardo Basurto Vázquez
 * Email: contacto.ebv@gmail.com
 *
 * 2017 (c) Maquina Tonta
 * Email: maquinatonta1@gmail.com
 * 
 */
package com.util;

import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 * Class with a single static method used to verify if a string has repeated 
 * characters and locate the exact position of them.
 *
 * @author Ing. Eduardo Basurto
 */
public class RepeatedCharacters {


    /**
     * Default constructor of the class loaded with the the <code>Object</code> 
     * constructor.
     */
    public RepeatedCharacters(){
        super();
    }
    /**
     * Method used to verify if a string has a repeated character in it. If the
     * string has zero characters repeated, it returns an empty HashMap,
     * otherwise, it returns a Map object with Key as the position of the
     * repeated character in the original string, and Value as the Character
     * itself.
     *
     *
     * @param str The string to be verified
     * @return The map containing the pairs of repeated characters with the 
     * position of them in the original alphabet.
     */
    public Map<Integer,Character> setRepeatedChars(String str) {
        Map<Integer, Character> repeated = new TreeMap<>();
        char[] charactersInString = str.toCharArray();

        for (int i = 0; i < charactersInString.length; i++) {
            int errors = 0;
            for (int j = 0; j < str.length(); j++) {
                if (charactersInString[i] == str.charAt(j)) {
                    errors++;
                }
                if (errors > 1 && (charactersInString[i] == str.charAt(j))) {
                    repeated.put(j, charactersInString[i]);
                }

            }
        }
        return repeated;
    }

    /**
     * Gets a string with the positions of the repeated characters in the 
     * following format:
     * <ul>
     * <li>x:x:x:x</li>
     * </ul>
     * Where the x's are the number of the position where the error was found.
     * If the string evaluated doesn't have errors, it returns an empty string.
     * 
     * @param repeated The Map containing the position and the character
     * @return The string with the position of the errors in the characters 
     * evaluated
     */
    public String toStringPositions(Map<Integer,Character> repeated) {
        if(repeated.isEmpty()){
            JOptionPane.showMessageDialog(null, "There is an internal error in "
                    + "the RepeatedCharacters class.",
                    "ERROR 117",JOptionPane.ERROR_MESSAGE);
        }
        String positions = "";
        positions = repeated.entrySet().stream().map((chars) -> ":" + (chars.getKey()+1)).reduce(positions, String::concat);

        return positions.substring(1);
    }

}
