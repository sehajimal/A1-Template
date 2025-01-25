package ca.mcmaster.se2aa4.mazerunner;

public class Player 
{
    private int xCoord;
    private int yCoord;
    private char direction = 'N';

    //constructor
    public Player(int x, int y) 
    {
        xCoord = x;
        yCoord = y;
    }

    public int getX() 
    {
        return xCoord;
    }

    public int getY() 
    {
        return yCoord;
    }

    public char getDirection() 
    {
        return direction;
    }

    //method to move player ahead
    public void advance() 
    {
        if (direction == 'N') 
        {
            xCoord--;
        } 
        
        else if (direction == 'E') 
        {
            yCoord++;
        } 
        
        else if (direction == 'S') 
        {
            xCoord++;
        } 
        
        else if (direction == 'W') 
        {
            yCoord--;
        }
    }

    public void moveLeft() 
    {
    }

    public void moveRight() 
    {
    }
    


}
