/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dkovalenko.games.snake.example;
 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author admin
 */
public class Space extends JPanel implements ActionListener {
    int size = 0;
    
    Timer time = new Timer(20,this);
    
    int timeOut = 0;
    int t = 0;
    
    Image img = new ImageIcon("img/palmi.jpg").getImage();
    
    Player play = null;
    
    ArrayList <Enemy> ast = new ArrayList <Enemy>();

    
    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        
        
        g2.drawImage(img, 0, 0, null);
        
        
        
        for(Enemy a : ast)
            {
                a.paintComponent(g);
                double k = play.k;
                if(play.k>Math.toRadians(180)) 
                {
                    k = play.k - Math.toRadians(180);
                 
            }
                if(k==0||k==Math.toRadians(180))
                {
                 if(a.y < play.y + 25 &&
                    a.y > play.y - 25 &&
                    a.x > play.x - 10 &&
                    a.x < play.x + 10)
                 {
                     a.v = 0;
                     a.kill(play);
                 }
                }
                else if(k<=Math.toRadians(90))
                {
                    if(a.y<func1(a.x-play.x,k)+play.y && 
                    a.y>func2(a.x-play.x,k)+play.y &&
                    a.y<func3(a.x-play.x,k)+play.y && 
                    a.y>func4(a.x-play.x,k)+play.y)
                    {
                        a.v = 0;
                        a.kill(play);
                    }
                }
                else
                {
                    if(a.y<func1_1(a.x-play.x,k)+play.y && 
                    a.y>func2_1(a.x-play.x,k)+play.y &&
                    a.y<func3_1(a.x-play.x,k)+play.y && 
                    a.y>func4_1(a.x-play.x,k)+play.y)
                    {
                        a.v = 0;
                        a.kill(play);
                    }
                }
                       
            
        }
        g2.drawString(String.valueOf(t), 0, 10);
        play.paint(g2);
        
    }
    
    public double func1(double x, double k)
    {
        return Math.tan(Math.toRadians(90)+k)*x+40/(2*Math.sin(k));
    }
    public double func2(double x, double k)
    {
        return Math.tan(Math.toRadians(90)+k)*x-40/(2*Math.sin(k));
    }
    public double func3(double x, double k)
    {
        return Math.tan(k)*x+50/(2*Math.cos(k));
    }
    public double func4(double x, double k)
    {
        return Math.tan(k)*x-50/(2*Math.cos(k));
    }
    
    public double func1_1(double x, double k)
    {
        return Math.tan(k-Math.toRadians(90))*x+40/(2*Math.sin(Math.toRadians(180)-k));
    }
    public double func2_1(double x, double k)
    {
        return Math.tan(k-Math.toRadians(90))*x-40/(2*Math.sin(Math.toRadians(180)-k));
    }
    public double func3_1(double x, double k)
    {
        return Math.tan(k)*x+50/(2*Math.cos(Math.toRadians(180)-k));
    }
    public double func4_1(double x, double k)
    {
        return Math.tan(k)*x-50/(2*Math.cos(Math.toRadians(180)-k));
    }
    
    
    public Space(int size)
    {
        this.size = size;
        play = new Player(size);
        for(int i = 0; i < 100; i++)
        {
        ast.add(new Enemy(size));
        }
        time.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(Enemy a : ast)
        {
            a.move(play);
             
        }
        timeOut += 1;
        if(timeOut == 50)
        {
            t++;
            timeOut = 0;
        }
        play.move();
        
        repaint();
    }
    
    private class MyKeyAdapter extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            //System.out.println("on - " + e.getKeyCode());
            play.keyPressed(e);
        }
        public void keyReleased(KeyEvent e)
        {
            //System.out.println("off - " + e.getKeyCode());
            play.keyReleased(e);
        }
    }
    
}
