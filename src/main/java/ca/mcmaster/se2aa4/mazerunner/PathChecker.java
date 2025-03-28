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

    private boolean checkingMove(char move) 
    {
        if (move == 'F') 
        {
            return player.canAdvance(maze);
        } 
        else if (move == 'L') 
        {
            player.moveLeft();
            return true;
        } 
        else if (move == 'R') 
        {
            player.moveRight();
            return true;
        } 
        else 
        {
            return false;
        }
    }

    public void checkPath(String path) 
    {
        StringBuilder expandedPath = new StringBuilder();

        // Expand the factorized path into a regular path
        for (int i = 0; i < path.length(); i++) 
        {
            char value = path.charAt(i);

            if (Character.isDigit(value)) 
            {
                // Parse the full number (multi-digit support)
                int digitStart = i;
                while (i < path.length() && Character.isDigit(path.charAt(i))) 
                {
                    i++;
                }
                int repeatCount = Integer.parseInt(path.substring(digitStart, i));
                if (i < path.length()) 
                {
                    char move = path.charAt(i);
                    for (int j = 0; j < repeatCount; j++) 
                    {
                        expandedPath.append(move);
                    }
                }
            } 
            else 
            {
                expandedPath.append(value);
            }
        }

        // Validate the expanded path
        for (int i = 0; i < expandedPath.length(); i++) 
        {
            char move = expandedPath.charAt(i);
            if (!checkingMove(move)) 
            {
                return;
            }

            // Check if the player is out of bounds
            if (player.getX() < 0 || player.getY() < 0 || player.getX() >= maze.length || player.getY() >= maze[0].length) 
            {
                return;
            }
        }
        
        // Check if the player reached the exit
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