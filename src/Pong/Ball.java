package Pong;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class Ball 
{   
    private int x = Pong.windowWidth / 2;
    private int y = Pong.windowHeight / 2;
    private final int pingPongSize = 15;
    private int player1Score = 0;
    private int player2Score = 0;
    private int xVelocity = -4;
    private int yVelocity = 4;
    
    public void update() 
    {
        x = x + xVelocity;
        y = y + yVelocity;

        if (x < 0) 
        {
            xVelocity = 4;
            player2Score = player2Score + 1;
            x = Pong.windowWidth / 2;
        } 
        else if (x + pingPongSize > Pong.windowWidth - 6) 
        {
            xVelocity = -4;
            player1Score = player1Score + 1;
            x = Pong.windowWidth / 2;
        }

        if (y < 0) 
        {
            yVelocity = 4;   
        } 
        else if (y + pingPongSize > Pong.windowHeight - 48) 
        {
            yVelocity = -4;
        }
     
        scoreCheck();
    }

    public void paint(Graphics g) 
    {
        g.setColor(Color.white);
        g.fillOval(x, y, pingPongSize, pingPongSize);
        g.drawString(toPlayer(), 130, 15);
        g.drawString(toComputer(), 560, 15);
    }

    private void reverseDirection() 
    {
        xVelocity = -xVelocity;
    }

    private void reverseDirectionY() 
    {
        yVelocity = -yVelocity;
    }

    public void checkCollisionWith(Player player) 
    {
        for (int i = -20; i < 36; i++)
        {
            if (this.x > player.getX()+20 && this.x < player.getX()+20 + player.getWidth() && 
                this.y > player.getY()+i && this.y < player.getY() + player.getHeight()) 
               {reverseDirection();}
   
        }
    }
    public void checkCollisionWith(Player2 player) 
    {
        for (int i = -20; i < 36; i++)
        {
            if (this.x > player.getX()+20 && this.x < player.getX()+20 + player.getWidth() && 
                this.y > player.getY()+i && this.y < player.getY() + player.getHeight()) 
               {reverseDirection();}
        }
    }
    public void hitWall() 
    {
        if (this.y < 30) 
            reverseDirectionY();
        
    }

    public void checkCollisionWith(Computer computer) 
    {
        for (int i = -20; i < 36; i++)
        {
            if (this.x > computer.getX()+20 && this.x < computer.getX()+20 + computer.getWidth() && 
                this.y > computer.getY()+i && this.y < computer.getY()+i + computer.getHeight()) 
            {reverseDirection();}
            
        }
    }
    
    public int getPlayerScore() 
    {
        return player1Score;
    }

    public int getComputerScore() 
    {
        return player2Score;
    }

    public int getX() 
    {
        return x;
    }

    public int getY() 
    {
        return y;
    }

    public String toPlayer() 
    {
        String playerScoreString = "";
        playerScoreString = "Player 1 Score: " + player1Score;
        return playerScoreString;
    }

    public String toComputer() 
    {
        String computerScoreString = "";
        computerScoreString = "Player 2 Score: " + player2Score;
        return computerScoreString;
    }
    
    public void scoreCheck()
    {
        if (player1Score == 5)
        {
            JOptionPane.showMessageDialog(null, "Player1 beat Player2  " + player1Score + "-" 
                    + player2Score +"! Press Ok to play again.");
            player1Score = 0;
            player2Score = 0;
        }
        if (player2Score == 5)
        {
            JOptionPane.showMessageDialog(null, "Player2 beat Player1  " + player2Score + "-"
                    + player1Score +"! Press Ok to play again.");
            player1Score = 0;
            player2Score = 0;
        }
    }
}