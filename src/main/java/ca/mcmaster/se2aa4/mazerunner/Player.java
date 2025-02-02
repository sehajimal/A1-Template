package ca.mcmaster.se2aa4.mazerunner;

public class Player 
{
    private int xCoord;
    private int yCoord;
    private char direction;

    //constructor
    public Player(int xCoord, int yCoord) 
    {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.direction = 'N';
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

    public boolean checkBounds(char[][] maze) 
    {
        return xCoord >= 0 && xCoord < maze.length && yCoord >= 0 && yCoord < maze[0].length&& maze[xCoord][yCoord] != '#';
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
        if (direction == 'N') 
        {
            direction = 'W';
        } 
        
        else if (direction == 'E') 
        {
            direction = 'N';
        } 
        
        else if (direction == 'S') 
        {
            direction = 'E';
        } 
        
        else if (direction == 'W') 
        {
            direction = 'S';
        }
    }

    public void moveRight() 
    {
        if (direction == 'N') 
        {
            direction = 'E';
        } 
        
        else if (direction == 'E') 
        {
            direction = 'S';
        } 
        
        else if (direction == 'S') 
        {
            direction = 'W';
        } 
        
        else if (direction == 'W') 
        {
            direction = 'N';
        }

    }
    
    //public boolean completedPath()
    //{
        //maze.entryExitPoints();     //need to refactor so that this method returns the entry and exit points
        //return xCoord = exit[0] && yCoord = exit[1];
    //} 


}
