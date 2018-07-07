/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dkovalenko.games.snake.example;

import javax.swing.*;
/**
 *
 * @author admin
 */
public class SpaceBoard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame f = new JFrame("Space");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int size =600;
        f.setSize(size, size+20);
        
        f.add(new Space(size));
        f.setVisible(true);
    }
    
}
