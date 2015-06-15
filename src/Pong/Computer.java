package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class Computer 
{
    private final GamePanel court;
    private int y = Pong.windowHeight / 2;
    private int yVelocity = 0;
    private final int width = 10;
    private final int height = 35;

    public Computer(GamePanel game) 
    {
        this.court = game;
    }

    public void update() 
    {
        if (court.getBall().getY() < this.y) 
            yVelocity = -5;
        else if (court.getBall().getY() > this.y) 
            yVelocity = 3;
        
        y = y + yVelocity;
    }

    public void paint(Graphics g) 
    {
        g.setColor(Color.blue);
        g.fillRect(Pong.windowWidth - (35 + width), y, width, height);
    }

    public int getX() 
    {
        return Pong.windowWidth - 6 - (35 + width);
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

