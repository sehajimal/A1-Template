package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class Player 
{
    private int xCoord;
    private int yCoord;
    private char direction = 'N';
    private Maze maze;
    private ArrayList<String> moves; //list of moves


    //constructor
    public Player(int x, int y) 
    {
        xCoord = x;
        yCoord = y;
        moves = new ArrayList<String>();
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
        moves.add("A");
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
        moves.add("L");
    }

    public void moveRight() 
    {
        moves.add("R");
    }
    
    //public boolean completedPath()
    //{
        //maze.entryExitPoints();     //need to refactor so that this method returns the entry and exit points
        //return xCoord = exit[0] && yCoord = exit[1];
    //} 


}
