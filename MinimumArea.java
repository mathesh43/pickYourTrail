package com.mathesh.sample.application;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Point class contains the x point and y point.
 */
class Point { 
    
    private int x;
    
    private int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Point() {
        
    }
    
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

}

/**
 * Find the minimum square area to cover the given point
 * 
 */
public class MinimumArea {

    public static void main(String args[]) {
        
        Map<Integer, Integer> map = getInputMap();
        
        int xMin = Collections.min(map.keySet()) - 1;
        int xMax = Collections.max(map.keySet()) + 1;
        int yMin = Collections.min(map.values()) - 1;
        int yMax = Collections.max(map.values()) + 1;
        
        
        int xPointSum = Math.abs(xMin) + Math.abs(xMax);
        
        int yPointSum = Math.abs(yMin) + Math.abs(yMax);
        
        if (xPointSum < yPointSum) {
            int diffValue = yPointSum - xPointSum;
            xMax += diffValue; 
        } else {
            int diffValue = yPointSum - xPointSum;
            yMax += diffValue; 
        }
       
       System.out.println((Math.abs(xMin) + Math.abs(xMax)) * (Math.abs(xMin) + Math.abs(xMax)));
    }

    /**
     * Get the all input values and store it in the map.
     * 
     * @return the map of points.
     */
    private static Map<Integer, Integer> getInputMap() {
        Scanner scanner = new Scanner(System.in);
        
        int xAxisArraySize = scanner.nextInt();
        
        Integer[] xPoints = new Integer[xAxisArraySize];
        
        for (int index = 0; index < xAxisArraySize; index++) {
            xPoints[index] = scanner.nextInt();
        }

        int yAxisArraySize = scanner.nextInt();
        
        Integer[] yPoints = new Integer[yAxisArraySize];
        
        for (int index = 0; index < yAxisArraySize; index++) {
            yPoints[index] = scanner.nextInt();
        }

        int minPointsTOCover = scanner.nextInt();
        
        Map<Integer, Integer> pointsMap = new HashMap<Integer, Integer>();
        
        for (int size = 0; size < xPoints.length; size++) {
            pointsMap.put(xPoints[size], yPoints[size]);
        }
        
        return pointsMap;
    }

}
