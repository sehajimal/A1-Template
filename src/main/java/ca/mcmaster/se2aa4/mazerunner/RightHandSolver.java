package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class RightHandSolver implements Solver{
    private char[][] maze;
    private Player player;
    private int exitX;
    private int exitY;

    public RightHandSolver(Maze maze, Player player) {
        this.maze = maze.getMaze(); 
        this.player = player;
        int[] entryExit = maze.entryExitPoints(); 
        this.exitX = entryExit[2];
        this.exitY = entryExit[3];
    }

    // This method is used to solve the maze using the right-hand rule
    @Override
    public void solve() {
        List<Character> mazePath = new ArrayList<>();       // List to store the path taken by the player
        while (!reachedEnd(player.getX(), player.getY())) 
        {
            player.moveRight();        //checking if the player can move right
            if (player.canAdvance(maze)) 
            {
                mazePath.add('R');
                mazePath.add('F');
                continue;
            }

            player.moveLeft();        //checking if the player can advance
            if (player.canAdvance(maze)) 
            {
                mazePath.add('F');
                continue;
            }

            player.moveLeft();          //otherwise move left
            mazePath.add('L');
        }

        if (reachedEnd(player.getX(), player.getY())) 
        {
            //System.out.println("Reached the exit!");
            System.out.println(convertToFactorizedPath(mazePath));
        } 
        
        else 
        {
            //System.out.println("Not at the exit yet.");
        }
    }

    private boolean reachedEnd(int x, int y) 
    {
        return x == exitX && y == exitY;
    }

    public String convertToFactorizedPath(List<Character> solvedPathway) 
    {
        int count = 1;
        StringBuilder factorizedPath = new StringBuilder();
        for (int i = 1; i <= solvedPathway.size(); i++)       //counting the number of times the player moves in the same direction
        {
            if (i < solvedPathway.size() && solvedPathway.get(i - 1) == solvedPathway.get(i)) 
            {
                count++;
            } 
            
            else 
            {
                if (count > 1) 
                {
                    factorizedPath.append(count);
                }
                factorizedPath.append(solvedPathway.get(i - 1));
                count = 1;
            }
        }
        return factorizedPath.toString();
    }
}
