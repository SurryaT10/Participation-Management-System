/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signup;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author User
 */
public class Validation {
    private final String email_regex = "[a-zA-z0-9_.-]+@(skct|skcet)\\.edu\\.in+";
    private final String password_regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=\\S+$).{8,20}$";
    public boolean isEmailValid(String email) {
        Pattern emailPattern = Pattern.compile(email_regex);
        Matcher emailMatcher = emailPattern.matcher(email);
        return emailMatcher.matches();
    }
    
    public boolean isPassValid(String password) {
        Pattern passwordPattern = Pattern.compile(password_regex);
        Matcher passwordMatcher = passwordPattern.matcher(password);
        return passwordMatcher.matches();
    }
}