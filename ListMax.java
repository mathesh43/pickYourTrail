package com.mathesh.sample.application;

import java.util.Arrays;
import java.util.Scanner;

/**
 * After n number of operations in the array, print the maximum value in that array.
 */
public class ListMax {

    /**
     * Main method of the list max.
     * @param args the arguments.
     */
    public static void main(String args[]) {
        
        Scanner scanner = new Scanner(System.in);        
        
        int arraySize = getArraySize(scanner);
        
        int [] arrayOfValues = new int[arraySize];
        
        int numberOfOperations = getNumberOfOperations(scanner); 
                
        int incrementOfNumberOfOperations = 0;
        
        int numberOfElementsInEachOpr = scanner.nextInt();
        
        while (incrementOfNumberOfOperations < numberOfOperations) {

            arrayOfValues = getInputAndProcessIt(arrayOfValues, numberOfElementsInEachOpr, scanner);
            
            incrementOfNumberOfOperations = incrementOfNumberOfOperations + 1;
        }
        
        System.out.println(Arrays.stream(arrayOfValues).max().getAsInt());
               
    }

    /**
     * Get the number of operations from the console.
     * 
     * @param scanner the scanner to get input
     * @return the number of operations.
     */
    private static int getNumberOfOperations(Scanner scanner) {
        
        Boolean isValidInput = false;
        
        int numberOfOperations = 0;
        do {
        
            numberOfOperations = scanner.nextInt();
            
            if (numberOfOperations < 1 && numberOfOperations > (2 * Math.pow(10.0, 5.0))) {
                System.out.println("Please enter the size between 1 to (2 * 10^5)");
            } else {
                isValidInput = true;
            }
            
        } while (!isValidInput);
        
        return numberOfOperations;
    }

    /**
     * Get the array size from the console.
     *  
     * @param scanner the scanner to get input
     * @return the array size
     */
    private static int getArraySize(Scanner scanner) {

        Boolean isValidInput = false;
        
        int arraySize = 0;
        do {
        
            arraySize = scanner.nextInt();
            
            if (arraySize < 3 && arraySize > Math.pow(10.0, 7.0)) {
                System.out.println("Please enter the size between 3 to 10^7");
            } else {
                isValidInput = true;
            }
            
        } while (!isValidInput);
        
        return arraySize;
    }

    /**
     * Get the input and process them into the array.
     * 
     * @param arrayOfValues the array value
     * @param numberOfElementsInEachOpr the numberOfElementsInEachOpr.
     * @param scanner the scanner
     * @return the array of values.
     */
    private static int[] getInputAndProcessIt(int[] arrayOfValues, int numberOfElementsInEachOpr, Scanner scanner) {
        
        int startIndex = scanner.nextInt();
        
        int endIndex = scanner.nextInt();
        
        int value = scanner.nextInt();
        
        for (int index = startIndex-1; index < endIndex; index ++) {
            arrayOfValues[index] = arrayOfValues[index] + value;
        }

        return arrayOfValues;
    }
}
