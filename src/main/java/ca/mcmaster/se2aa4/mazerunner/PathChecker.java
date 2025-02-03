package ca.mcmaster.se2aa4.mazerunner;

public class PathChecker 
{
    private char[][] maze;
    private Player player;
    private int exitX;
    private int exitY;

    public PathChecker(Maze maze, Player player) 
    {
        this.maze = maze.getMaze(); 
        this.player = player;
        int[] entryExit = maze.entryExitPoints(); 
        this.exitX = entryExit[2];
        this.exitY = entryExit[3];
    }

    private void checkingMove(char move) 
    {
        if (move == 'F') 
        {
            player.canAdvance(maze);
        } 
        else if (move == 'L') 
        {
            player.moveLeft();
        } 
        else if (move == 'R') 
        {
            player.moveRight();
        }
    }

    public void checkPath(String path) 
    {
        for (int i = 0; i < path.length(); i++) 
        {
            char value = path.charAt(i);
            
            if (Character.isDigit(value)) 
            {
                int digitValue = value - '0'; // Convert char digit to int
                if (i + 1 < path.length()) 
                {
                    char value1 = path.charAt(i + 1);
                    for (int j = 0; j < digitValue; j++) 
                    {
                        checkingMove(value1);
                    }
                    i++;   //after done with the repeated character go to next character
                }
            } 
            else 
            {
                checkingMove(value);
            }
        }
        
        
        if (player.getX() == exitX && player.getY() == exitY) 
        {
            System.out.println("correct path");
        } 
        else 
        {
            System.out.println("incorrect path");
        }
    }
}
