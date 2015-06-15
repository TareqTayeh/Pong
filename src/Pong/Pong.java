package Pong;

import javax.swing.JFrame;
 
public class Pong extends JFrame 
{
    static int windowWidth = 850;
    static int windowHeight = 500;
    
    public Pong() 
    {
        setSize(windowWidth, windowHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new GamePanel());
        setVisible(true);
        setResizable(false);
    }
    public Pong(boolean x) 
    {
        setSize(windowWidth, windowHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new GamePanel(false));
        setVisible(true);
        setResizable(false);
    }
    
    public static void main(String[] args) 
    {
        new Start();
    }
}
