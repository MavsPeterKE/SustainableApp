package org.coursera.sustainableapps;

public class LoginUtil {

    public boolean isPasswordLengthValid(String pass){
        return pass != null && pass.length() >= 8;
    }

    public boolean isPasswordSpaces(String pass){
        return pass.isEmpty();
    }

    public boolean isEmailValid(String email){
        boolean hasAtSign = email.contains("@");
        boolean hasAtleastOneCharacterBeforeAt = email.substring(0,email.indexOf("@")).matches(".*[a-z].*");
        boolean hasThreeCharacterIncludingAfterAt = email.substring(email.indexOf("@")).length()>3 && email.substring(email.indexOf("@")).contains(".");
        return hasAtSign && hasAtleastOneCharacterBeforeAt && hasThreeCharacterIncludingAfterAt;
    }
}
