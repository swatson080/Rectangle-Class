/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson8;

import java.util.Random;

/**
 * Creates an object that describes a rectangle.
 * @author sbeli
 */
public class Rectangle {
    /**
     * the number of Rectangle objects that have been made
     */
    private static int count = 0;
    /**
     * the rectangle's id
     */
    private int id;
    /**
     * the rectangle's length
     */
    private int length;
    /**
     * the rectangle's width
     */
    private int width;
    
    /**
     * gets the number of objects created
     * @return the number of Rectangle objects created
     */
    public static int getNumRect() {
        return count;
    }
    
    /**
     * no-arg constructor, sets both length and width fields to 1
     */
    public Rectangle() {
        length = 1;
        width = 1;
        id = ++count;
    }
    
    /**
     * makes a rectangle with the specified length and width
     * @param length 
     * @param width 
     */
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
        id = ++count;
    }
    
    public Rectangle(int length) {
        Random rand = new Random();
        width = rand.nextInt(50) + 1;
        this.length = length;
        id = ++count;
    }
    
    public int getLength() {
        return length;
    }
    
    public int getWidth() {
        return width;
    }
    
    /**
     * draws a rectangle of dimensions length and width
     * @param includeInfo if true, includes information about the 
     * Rectangle object being drawn.
     */
    public void drawRect(boolean includeInfo) {
        if(includeInfo) {
            System.out.println(this.toString());
        }
        // Top row
        for(int i = 0; i < length; ++i) {
            System.out.print("*");
        }
        // Move down 1
        System.out.println();
        
        for(int i = 0; i < width - 2; ++i) {
            for(int j = 0; j < length; ++j) {
                if(j == 0 || j == length - 1) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        
        if(width > 1) {
            for(int i = 0; i < length; ++i) {
                System.out.print("*");
            }
        }
        
        System.out.print("\n");
    }
    
    /**
     * no-arg version of drawRect().
     * draws a rectangle of dimensions length and width
     * with no included information about the rectangle
     */
    public void drawRect() {
        // Top row
        for(int i = 0; i < length; ++i) {
            System.out.print("*");
        }
        // Move down 1
        System.out.println();
        
        for(int i = 0; i < width - 2; ++i) {
            for(int j = 0; j < length; ++j) {
                if(j == 0 || j == length - 1) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        
        if(width > 1) {
            for(int i = 0; i < length; ++i) {
                System.out.print("*");
            }
        }
        
        System.out.print("\n");
    }
    
    public void drawRectOffset(int offset) {
        for(int i = 0; i < offset; ++i) {
            System.out.print(" ");
        }
        // Top row
        for(int i = 0; i < length; ++i) {
            System.out.print("*");
        }
        // Move down 1
        System.out.println();
        
        for(int i = 0; i < width - 2; ++i) {
            // Print offset
            for(int k = 0; k < offset; ++k) {
                System.out.print(" ");
            }
            
            for(int j = 0; j < length; ++j) {
                if(j == 0 || j == length - 1) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for(int i = 0; i < offset; ++i) {
            System.out.print(" ");
        }
        // Bottom row
        if(width > 1) {
            for(int i = 0; i < length; ++i) {
                System.out.print("*");
            }
        }
        
        System.out.print("\n");
    }
    
    /**
     * returns true if the length and width of both objects are equal
     * @param rect2 a Rectangle object to compare
     * @return true if length and width fields are both equal, otherwise 
     * returns false
     */
    public boolean equals(Rectangle rect2) {
        return length == rect2.getLength() && width == rect2.getWidth();
    }
    
    /**
     * @Override
     */
    public String toString() {
        return String.format("Rectangle _%d:\n   Length: %d\n   Width: %d\n:", id, length, width);
    }
    
}
