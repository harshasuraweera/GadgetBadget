package it19207896;

import java.util.Random;

public class RequiredMethod {
	
	
	public static String generateProductId() {
        String SALTCHARS = "ABCDE1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        
        return  "PD-" + saltStr;

    }

}
