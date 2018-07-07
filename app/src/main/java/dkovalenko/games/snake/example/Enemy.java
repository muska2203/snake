/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dkovalenko.games.snake.example;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public class Enemy extends JPanel{
    
    int size = 0;
    
    double k = Math.random()*10;
    double x = Math.random()*500+50;
    double y = Math.random()*500+50; 
    double v = Math.random()*14+1;
    double a = 0;
    
    int kill = -1;
    
    Image img = new ImageIcon("img/asteroid.png").getImage();
    
    Enemy(int size)
    {
        super();
        this.size = size;
    }
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(img, (int)x-img.getWidth(null)/2, (int)y-img.getHeight(null)/2, null);
        
    }
    
    public void move(Player play)
    {
        v+=a;
        if(v<0)
            v=0;
        double vx =v*Math.sin(k);
        double vy =-v*Math.cos(k);
        
        x+=vx;
        if(x>=size-img.getWidth(this)/2)
            k=-k;
        if(x<=img.getWidth(this)/2)
            k=-k;
        
        y+=vy;
        if(y>=size-img.getHeight(this)/2)
            k= Math.toRadians(180)-k;
        if(y<=img.getHeight(this)/2)
            k= Math.toRadians(180)-k;
        
        if(kill!=-1)
        {
            kill++;
        }
        if(kill == 1)
        {
            //img = new ImageIcon("img/boom.png").getImage();
            
            play.img = new ImageIcon("img/luck2.png").getImage();
        }
        
        if(kill == 5)
        {
            x = -20;
            play.img = new ImageIcon("img/luck.png").getImage();
        }
        
        if(kill == 10)
        {
            play.img = new ImageIcon("img/luck2.png").getImage();
        }
        if(kill == 20)
        {
            play.img = new ImageIcon("img/luck.png").getImage();
        }
    }
    
    public void kill(Player play)
    {
        if(kill==-1)
        {
            kill=0;
            
        }
        
    }
    
}
