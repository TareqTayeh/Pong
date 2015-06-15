package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player 
{
    private int y = Pong.windowHeight / 2;
    private int yVelocity = 0;
    private final int width = 10;
    private final int height = 35;

    public Player() {
    }

    public void update() 
    {
        y = y + yVelocity;
    }

    public void paint(Graphics g) 
    {
        g.setColor(Color.green);
        g.fillRect(35, y, width, height);
    }

    public void setYVelocity(int speed) 
    {
        yVelocity = speed;
    }

    public int getY() 
    {
        return y;
    }
    
    public int getX()
    {
        return 35;
    }

    public int getWidth() 
    {
        return width;
    }

    public int getHeight() 
    {
        return height;
    }
}

