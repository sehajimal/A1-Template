package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.CommandPattern.*;
import java.util.ArrayList;
import java.util.List;

public class RightHandSolver implements Solver 
{
    private char[][] maze;
    private Player player;
    private int exitX;
    private int exitY;

    private MovingCommand moveRightCommand;
    private MovingCommand moveLeftCommand;
    private AdvanceCommand advanceCommand;

    public RightHandSolver(Maze maze, Player player) 
    {
        this.maze = maze.getMaze();
        this.player = player;
        int[] entryExit = maze.entryExitPoints();
        this.exitX = entryExit[2];
        this.exitY = entryExit[3];

        this.moveRightCommand = new MoveRightCommand(player);
        this.moveLeftCommand = new MoveLeftCommand(player);
        this.advanceCommand = new AdvanceCommand(player, maze);
    }

    @Override
    public void solve() 
    {
        List<Character> mazePath = new ArrayList<>(); 

        while (!reachedEnd(player.getX(), player.getY())) 
        {
            moveRightCommand.execute();
            if (player.canAdvance(maze)) 
            {
                mazePath.add('R');
                mazePath.add('F');
                continue;
            }

            // Undo moveRightCommand if advancing is not possible
            moveRightCommand.undo();

            if (player.canAdvance(maze)) 
            {
                mazePath.add('F');
                continue;
            }

            // Execute moveLeftCommand
            moveLeftCommand.execute();
            mazePath.add('L');
        }

        if (reachedEnd(player.getX(), player.getY())) 
        {
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
        for (int i = 1; i <= solvedPathway.size(); i++) 
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
