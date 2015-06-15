package Pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener 
{
    Player player = new Player();
    Ball ball = new Ball();
    Computer computer = new Computer(this);
    Player2 player2 = new Player2();
    
    public boolean is2player;
    
    public GamePanel() 
    {
        Timer time = new Timer(10, this);
        time.start();
        this.addKeyListener(this);
        this.setFocusable(true);
        is2player=true;
    }
    public GamePanel(boolean x) 
    {
        Timer time = new Timer(10, this);
        time.start();
        this.addKeyListener(this);
        this.setFocusable(true);
        is2player=x;
    }
    private void update() 
    {
        player.update();
        if(!is2player)
        player2.update();
        ball.update();
        if(is2player)
            computer.update();

        ball.checkCollisionWith(player);
        if(!is2player)
        ball.checkCollisionWith(player2);
        if(is2player)
        ball.checkCollisionWith(computer);
        ball.hitWall();

    }

    public void paintComponent(Graphics g) 
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Pong.windowWidth, Pong.windowHeight);

        player.paint(g);
        ball.paint(g);
        if(!is2player)
        player2.paint(g);
        if(is2player)
        computer.paint(g);

        g.setColor(Color.RED);
        g.drawLine(0, 30, Pong.windowWidth, 30);
        g.drawLine(20, 30, 20, Pong.windowHeight);
        g.drawLine(Pong.windowWidth / 2, 30, Pong.windowWidth / 2, Pong.windowHeight);
        g.drawLine(Pong.windowWidth - 20, 30, Pong.windowWidth - 20, Pong.windowHeight);
        g.drawLine(0, 447, Pong.windowWidth, 447);
        g.drawOval((Pong.windowWidth / 2) - 30, Pong.windowHeight / 2 - 30, 60, 60);
        g.setColor(Color.yellow);
    }

    public Ball getBall() 
    {
        return ball;
    }

    public void actionPerformed(ActionEvent e) 
    {
        update();
        repaint();
    }

    public void keyPressed(KeyEvent e) 
    {
        if (e.getKeyCode() == KeyEvent.VK_UP) 
        {
            player2.setYVelocity(-5);
            if (player2.getY() < 40) 
                player2.setYVelocity(0);   
        } 
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            player2.setYVelocity(5);
            if (player2.getY() + 100 > Pong.windowHeight) 
                player2.setYVelocity(0);         
        }
        if (e.getKeyCode() == KeyEvent.VK_W) 
        {
            player.setYVelocity(-5);
            if (player.getY() < 40) 
                player.setYVelocity(0);   
        } 
        if (e.getKeyCode() == KeyEvent.VK_S) 
        {
            player.setYVelocity(5);
            if (player.getY() + 100 > Pong.windowHeight) 
                player.setYVelocity(0);         
        }
    }

    public void keyTyped(KeyEvent e) {
    }
    
    public void keyReleased(KeyEvent e) 
    {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN )
        {
            player.setYVelocity(0);
            player2.setYVelocity(0);
                    
        }
        if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S)
        {
            player2.setYVelocity(0);
            player.setYVelocity(0);
        }
    }
}