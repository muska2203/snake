/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dkovalenko.games.snake.example;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author admin
 */
public class Player extends JPanel {
    int size = 0;
    
    
    Image img = new ImageIcon("img/obama.png").getImage();
    
    
    int vMax = 100;
    double x = 300;
    double y = 300; 
    double v = 0;
    double a = 0;
    double vSpeed = 0;
    double vRotate = Math.toRadians(90)/10;
    
    Player(int size)
    {
        super();
        this.size = size;
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.rotate(k,x,y);
        g2.drawImage(img, (int)x-img.getWidth(null)/2, (int)y-img.getHeight(null)/2, this);
        
    }
    double k = Math.toRadians(135);
    
    public void move()
    {
        System.out.println(k);
        if(k/Math.toRadians(360)>1)
            k-=Math.toRadians(360);
        if(k<0)
            k+=Math.toRadians(360);
        
        v+=a;
        if(v>vMax)
        {
            v = vMax;
            a = 0;
        }
        k+=vSpeed;
        if(v<0)
            v=0;
        double vx =v*Math.sin(k);
        double vy =-v*Math.cos(k);
        
        x+=vx;
        y+=vy;
        
        if(x>=size+img.getWidth(this)/3)
            x = -img.getWidth(this)/3+1;
        if(x<=-img.getWidth(this)/3)
            x = size+img.getWidth(this)/3-1;
        if(y>=size+img.getWidth(this)/3)
            y = -img.getWidth(this)/3+1;
        if(y<=-img.getWidth(this)/3)
            y = size+img.getWidth(this)/3-1;
    }
    
    
    
    
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT)
        {
            vSpeed = -vRotate;
        }
        if(key == KeyEvent.VK_RIGHT)
        {
            vSpeed = vRotate;
        }
        if(key == KeyEvent.VK_UP)
        {
            if(v<vMax)
            a=0.5;
        }
        if(key == KeyEvent.VK_DOWN)
        {
            if(v>=0)
            a=-2;
        }
    }
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP)
        {
            a=-0.5;
        }
        if(key == KeyEvent.VK_DOWN)
        {
            if(v>=0)
            a=-0.5;
        }
        if(key == KeyEvent.VK_LEFT)
        {
            vSpeed = 0;
        }
        if(key == KeyEvent.VK_RIGHT)
        {
            vSpeed = 0;
        }
        
    }
    
    
}
