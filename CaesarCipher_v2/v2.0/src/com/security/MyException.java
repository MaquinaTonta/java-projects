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
 * This is a class created for the implementation of custom Exceptions. The 
 * way you customize them is via Exception message.
 * 
 * @author Eng. Eduardo Basurto
 */
public class MyException extends Exception{
    
    /**
     * Constructor for the MyException class. It is used to create custom 
     * exceptions for the usage of CaesarCipher program.
     * 
     * @param message The descriptive message about the thrown error
     */
    public MyException(String message){
        super(message);
    }
}
