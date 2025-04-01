package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class RightHandSolverTest 
{
    private Maze maze;
    private Player player;
    private RightHandSolver solver;

    @BeforeEach
    public void setUp() 
    {
        maze = new Maze();
        maze.displayMaze("./examples/direct.maz.txt");   // Process the maze
        int[] entryExit = maze.entryExitPoints();
        player = new Player(entryExit[0], entryExit[1]); 
        solver = new RightHandSolver(maze, player); 
    }

    @Test
    public void testFactorizedPathConversion() 
    {
        String canonicalPath = "FRFFLFFFRFLFRFLFF";
        List<Character> solvedPathway = new ArrayList<>();
        for (char c : canonicalPath.toCharArray()) 
        {
            solvedPathway.add(c);
        }
        assertEquals("FR2FL3FRFLFRFL2F", solver.convertToFactorizedPath(solvedPathway));
    }

    @Test
    public void testInvalidConversion() 
    {
        String canonicalPath = "FFFF";
        List<Character> solvedPathway = new ArrayList<>();
        for (char c : canonicalPath.toCharArray()) 
        {
            solvedPathway.add(c);
        }
        assertNotEquals("FR2FL3FRFLFRFL2F", solver.convertToFactorizedPath(solvedPathway));
    }
}