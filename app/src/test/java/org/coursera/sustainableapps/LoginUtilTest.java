package org.coursera.sustainableapps;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LoginUtilTest {
    private LoginUtil loginUtil = new LoginUtil();


    @Test
    public void isPassowrdValid() {
        assertTrue(loginUtil.isPasswordLengthValid("xhjkkkkkkfg"));
    }

    @Test
    public void isPassowrdInValid() {
        assertFalse(loginUtil.isPasswordLengthValid("x3"));
    }

    @Test
    public void isPasswordLengthValid() {
        assertTrue(loginUtil.isPasswordLengthValid("456tdgfhk"));
    }

    @Test
    public void isPassowrdLength() {
        assertFalse(loginUtil.isPasswordLengthValid("456thk"));
    }


    @Test
    public void passwordHasSpaces() {
        assertTrue(loginUtil.isPasswordSpaces(""));
    }

    @Test
    public void passwordHasNoSpaces() {
        assertFalse(loginUtil.isPasswordSpaces("dhdjdk"));
    }

    @Test
    public void isEmailValid() {
        assertTrue(loginUtil.isEmailValid("mavspeter@gmail.com"));
    }

    @Test
    public void isEmailInValid() {
        assertFalse(loginUtil.isEmailValid("m@gmailcom"));
    }
}