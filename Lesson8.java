/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson8;

import java.util.Random;

/**
 *
 * @author sbeli
 */
public class Lesson8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
              
        final int NUM_STEPS = 30;
        
        //drawTriangle(true,NUM_STEPS,30,1);
        
        Rectangle[] triangle = new Rectangle[5];
        Rectangle[] triangle2 = new Rectangle[5];
        Rectangle[] triangle3 = new Rectangle[10];
        Rectangle[] triangle4 = new Rectangle[10];
        

            for(int i = 5, j = 0; i > 0; --i, ++j) {
                triangle[j] = new Rectangle(1,i);
            }

            for(int i = 0; i < 5; ++i) {
                triangle2[i] = new Rectangle(1,i+1);
            }
        
            for(int i = 0; i < 5; ++i) {
                triangle3[i] = triangle[i];
                triangle3[i+5] = triangle2[i];
            }
            
            for(int i = 0; i < 5; ++i) {
                triangle4[i] = triangle2[i];
                triangle4[i + 5] = triangle[i];
            }
            
        advanceDraw(50,1,triangle3);
        advanceDraw(50,1,triangle3);

        
        advanceDraw(50,1,triangle4);
        advanceDraw(50,1,triangle4);
        
        Rectangle[] newRect = new Rectangle[10];
        newRect[0] = new Rectangle(10,1);
        newRect[1] = new Rectangle(10,2);
        newRect[2] = new Rectangle(6,1);
        newRect[3] = new Rectangle(3,1);
        newRect[4] = new Rectangle(1,1);
        newRect[5] = new Rectangle(2,1);
        newRect[6] = new Rectangle(1,1);
        newRect[7] = new Rectangle(2,1);
        newRect[8] = new Rectangle(4,1);
        newRect[9] = new Rectangle(2,3);
        
        advanceDraw(0,1,newRect);
        advanceDraw(0,2,newRect);

    }
    
    /**
     * Draws a triangle with advanceDraw
     * @param left if true triangle will be left justified
     * @param numSteps the number of Rectangle objects to create
     * @param offset the amount of offset to use
     * @param padding affects spacing within the triangle
     */
    public static void drawTriangle(boolean left, int numSteps, int offset, int padding) {
        Rectangle[] triangle = new Rectangle[numSteps];
        if(left) {
            for(int i = numSteps, j = 0; i > 0; --i, ++j) {
                triangle[j] = new Rectangle(2,i);
            } 
        }
        else {
            for(int i = 0; i < numSteps; ++i) {
                triangle[i] = new Rectangle(2,i+1);
            }
        }
        
        advanceDraw(offset,padding,triangle);
               
    }
    
    
        /**
     * takes a variable number of rectangles and draws them.
     * draw order is the same as input order. does not fill the rectangles
     * @param offset the amount to offset the rectangles from the left 
     * @param padding the amount of space between the rectangles
     * @param rect a variable number of Rectangle objects to draw
     */
    public static void advanceDraw(int offset, int padding, Rectangle... rect) {
        int largestWidth = 0, largeIndex = 0;
        // Find the rectangle with the largest width and get its index
        for(int i = 0; i < rect.length; ++i) {
            if(rect[i].getWidth() > largestWidth) {
                largestWidth = rect[i].getWidth();
                largeIndex = i;
            }
        }
        
        // Top line - offset
        for(int i = 0; i < offset; ++i) {
            System.out.print(" ");
        }
        // Draw the top line of the widest rectangle
        for(int i = 0; i < rect.length; ++i) {
            if(largeIndex == i) {
                for(int j = 0; j < rect[i].getLength(); ++j) {
                    System.out.print("*");
                }
                for(int j = 0; j < padding; ++j) {
                    System.out.print(" ");
                }
            }
            else if(rect[i].getWidth() == largestWidth) {
                for(int j = 0; j < rect[i].getLength(); ++j) {
                    System.out.print("*");
                }
                for(int j = 0; j < padding; ++j) {
                    System.out.print(" ");
                }
            }
            else {
                for(int j = 0; j < rect[i].getLength(); ++j) {
                    System.out.print(" ");
                }
                for(int j = 0; j < padding; ++j) {
                    System.out.print(" ");
                }
            }
        }
        
        System.out.println();
        
        // Draw the bodies of the rectangles
        // This will include the top line of any other rectangles
        // Need to loop largestWidth - 2 times
        // On each loop: print the offset, then loop through the rect array
        // each pass through this loop, you will draw the contents of the 
        // corresponding rectangle - will need to check if the width is > i.
        // If the width of a rect in the array matches the current value of i
        // that means you found the top line of another rectangle.
        // For each rect object, print the padding.
        for(int i = largestWidth - 2; i > 0; --i) {
            // print the offset
            for(int j = 0; j < offset; ++j) {
                System.out.print(" ");
            }
            
            // loop through the rect array
            for(int j = 0; j < rect.length; ++j) {
                if(rect[j].getWidth() == i + 1 && j != largeIndex) {
                    for(int k = 0; k < rect[j].getLength(); ++k) {
                        System.out.print("*");
                    }
                    for(int k = 0; k < padding; ++k) {
                        System.out.print(" ");
                    }
                }
                else if (rect[j].getWidth() > i) {
                    for(int k = 0; k < rect[j].getLength(); ++k) {
                        if(k == 0 || k == rect[j].getLength() - 1) {
                            System.out.print("*");
                        }
                        else {
                            System.out.print(" ");
                        }
                    }
                    for(int k = 0; k < padding; ++k) {
                        System.out.print(" ");
                    }
               }
               else {
                    for(int k = 0; k < rect[j].getLength() + padding; ++k) {
                        System.out.print(" ");
                    }
               }
            }
            System.out.println();
        }
        
        if(largestWidth == 1);  // Do nothing, because you already printed the rect + the newline
        else {
            // Print the bottom of the rectangles
            for(int i = 0; i < offset; ++i) {
                System.out.print(" ");
            }
            for(int i = 0; i < rect.length; ++i) {
                /*
                // This code was originally meant to handle cases where
                // the largest width of a rectangle was 1 (one). 
                // It is no longer necessary because the if statement above
                // handles the case where largestWidth == 1, and has been 
                // replaced by the much simpler code below. I am keeping it for 
                // now because I don't know if there any other bugs lurking
                if(rect[i].getWidth() > 1) {
                    for(int j = 0; j < rect[i].getLength(); ++j) {
                        System.out.print("*");
                    }
                }
                else if(rect[i].getWidth() == 1 && largestWidth > 1) {
                    for(int j = 0; j < rect[i].getLength(); ++j) {
                        System.out.print("*");
                    }
                }
                else {
                    for(int j = 0; j < rect[i].getLength(); ++j) {
                        System.out.print(" ");
                    }
                }
                */
                for(int j = 0; j < rect[i].getLength(); ++j) {
                    System.out.print("*");
                }
                for(int j = 0; j < padding; ++j) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            }
    }
    
}
