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
        
        Rectangle rect = new Rectangle(187, 34);
        rect.drawRect();
        
        Random rand = new Random();
        
        Rectangle[] rects = new Rectangle[3];
        //System.out.println("There are " + Rectangle.getNumRect() + " rectangle objects)");
        
        for(int i = 0; i < rects.length; ++i) {  
            int l = rand.nextInt(150) + 1;
            rects[i] = new Rectangle(50);
            //System.out.println("There are " + Rectangle.getNumRect() + " rectangle objects)");

        }
        for(int i = 0; i < rects.length; ++i) {
            rects[i].drawRect(true);
        }
        
        Rectangle recty = new Rectangle(10);
        System.out.println("Now drawing recty\n" + recty);
        recty.drawRectOffset(25);
        
        //Draw something
        Rectangle top = new Rectangle(50,18);
        Rectangle bottom = new Rectangle(10,23);
        
        top.drawRect();
        bottom.drawRectOffset(3);
        
    }
    
}
