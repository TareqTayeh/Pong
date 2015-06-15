package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player2
{
    private int y = Pong.windowHeight / 2;
    private int yVelocity = 0;
    private final int width = 10;
    private final int height = 35;

    public Player2() {
    }

    public void update() 
    {
        y = y + yVelocity;
    }

    public void paint(Graphics g) 
    {
        g.setColor(Color.green);
        g.fillRect(Pong.windowWidth - (35 + width), y, width, height);
    }

    public int getX() 
    {
        return Pong.windowWidth - 6 - (35 + width);
    }
    public void setYVelocity(int speed) 
    {
        yVelocity = speed;
    }

    public int getY() 
    {
        return y;
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

