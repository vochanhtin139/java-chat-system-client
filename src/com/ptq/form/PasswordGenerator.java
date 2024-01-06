
package com.ptq.form;

/**
 *
 * @author quynhphan
 */
import java.security.SecureRandom;
import java.util.Random;


public class PasswordGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
    public static String generateRandomPassword(int length) {
        StringBuilder password = new StringBuilder();
        Random random = new SecureRandom();
        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }
        
        return password.toString();
    }
}
