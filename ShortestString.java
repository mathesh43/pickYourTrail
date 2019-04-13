package com.mathesh.sample.application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Given a string comprised of lowercase letters in the range ascii[a-z],
determine the length of the smallest substring that contains all of the
letters present in the string.
For example, given the string s = dabbcabcd, the list of all characters in
the string is [a, b, c, d]. Two of the substrings that contain all letters are
dabbc and abcd. The shortest substring containing all the letters is
4 characters long, abcd.
 */
public class ShortestString {

    /** 
     * Main class of the shortest sub string.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        findShortestStringValue();
    }

    /**
     * Find the shortest string value.
     * 
     */
    private static void findShortestStringValue() {
       
        String inputValue = getInputValue();
        
        Set<String> setOfUniqueCharacters = getSetOfPresentedChars(inputValue);
        
        List<String> listOfSubString = getListOfSubString(inputValue);

        printShortestStringValue(setOfUniqueCharacters, listOfSubString);
        
    }
    
    /**
     * Get the input string.
     * 
     * @return the valid input string
     */
    private static String getInputValue() {
        
        Scanner scanner = new Scanner(System.in);

        String inputValue = "";
        
        boolean isValidInputValue = false;
        
        while (!isValidInputValue) {
            
            inputValue = scanner.next();
            
            isValidInputValue = checkInputValueIsValid(inputValue);
        }
        
        return inputValue;
    }
    
    /**
     * Check the given input value is valid.
     * 
     * @param inputValue the input value.
     * @return the valid or not.
     */
    private static boolean checkInputValueIsValid(String inputValue) {
        
        boolean isValidInputValue = false;
        
        Boolean isNonAlphaNumericCharacter = checkAlphaNumeric(inputValue);
        
        if (isNonAlphaNumericCharacter) {
            System.out.println("Please enter the alpha numberic value only");
        } else if (inputValue.isEmpty() || inputValue.length() > 100000) {
            System.out.println("Please enter the string length between 1 to 10^5");
        } else {
            isValidInputValue = true;
        }
        
        return isValidInputValue;
    }

    /**
     * Get the list of sub string.
     * 
     * @param inputValue the input value
     * @return the list of sub string
     */
    private static List<String> getListOfSubString(String inputValue) {
       
         List<String> listOfSubString = new ArrayList<>();

        for (int i = 0; i < inputValue.length(); i++) {
            for (int j = i + 1; j <= inputValue.length(); j++) {
                listOfSubString.add(inputValue.substring(i, j));
            }
        }
        
        return listOfSubString;

    }

    /**
     * Get the characters present in the string. 
     * 
     * @param inputValue the input value
     * @return the set of presented characters.
     */
    private static Set<String> getSetOfPresentedChars(String inputValue) {
        
        Set<String> setOfPresentedCharacters = new HashSet<>();
        
        char[] arrayOfInputValue = inputValue.toCharArray();        
        
        for (int index = 0; index < arrayOfInputValue.length; index ++) {
            
            setOfPresentedCharacters.add(String.valueOf(arrayOfInputValue[index]));
        }
        
        return setOfPresentedCharacters;
    }

    /**
     * Print the shortest string value.
     * 
     * @param setOfUniqueCharacters
     * @param listOfSubString
     */
    private static void printShortestStringValue(Set<String> setOfUniqueCharacters, List<String> listOfSubString) {

        String shortestSubstring = null;
        
        for (String subString : listOfSubString) {
            
            Boolean isAllSubStringPresent = true;
            
            for (String setValue : setOfUniqueCharacters) {
             
                if (!subString.contains(setValue)) {
                    isAllSubStringPresent = false;
                    break;
                }
            }
            if (isAllSubStringPresent) {
                if (shortestSubstring != null && shortestSubstring.length() > subString.length()) {
                    shortestSubstring = subString;
                }
                if (shortestSubstring == null) {
                    shortestSubstring = subString;
                }
            }
        }
     
        System.out.println(shortestSubstring.length());
    }
    
    
    /**
     * Check the given input value is alpha numeric or not.
     * 
     * @param inputValue the input value
     * @return the input value is alpha numeric or not.
     */
    private static boolean checkAlphaNumeric(String inputValue) {

        char[] chars = inputValue.toCharArray();
        
        boolean isNonAlphaNumericCharacter = false;
        
        for (int index = 0; index < chars.length; index++) {
            char c = chars[index];
            //check if the character is alphanumeric 
            if (!Character.isLetterOrDigit(c)) {
                //if non-alphanumeric, set a flag
                isNonAlphaNumericCharacter = true;
            }
        }
        
        return isNonAlphaNumericCharacter;
    }
}
