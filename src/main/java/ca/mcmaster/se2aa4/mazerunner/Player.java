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
        this.direction = 'E'; //setting to initialy face east
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

    //ensuring the player does not go out of bounds
    public boolean checkBounds(char[][] maze, int xCoordNew, int yCoordNew) 
    {
        return maze[xCoordNew][yCoordNew] != '#' && yCoordNew >= 0 && yCoordNew < maze[0].length && xCoordNew >= 0 && xCoordNew < maze.length;
    }

    //checking if the player can advance
    public boolean canAdvance(char[][] maze)
    {
        int xCoordNew = xCoord;
        int yCoordNew = yCoord;
        if (direction == 'N') 
        {
            xCoordNew--;
        } 
        else if (direction == 'E') 
        {
            yCoordNew++;
        } 
        else if (direction == 'S') 
        {
            xCoordNew++;
        } 
        else if (direction == 'W') 
        {
            yCoordNew--;
        }

        if (checkBounds(maze, xCoordNew, yCoordNew))
        {
            xCoord = xCoordNew;
            yCoord = yCoordNew;
            return true;
        } 
        else 
        {
            return false;
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
}
