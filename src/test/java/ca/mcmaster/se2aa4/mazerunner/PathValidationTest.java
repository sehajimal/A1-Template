package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PathValidationTest 
{
    private Player player; 
    private Maze maze;
    private PathChecker pathChecker;

    @BeforeEach
    public void setUp() 
    {
        maze = new Maze(); 
        maze.displayMaze("./examples/direct.maz.txt"); // Process the direct maze
        int entryExit[] = maze.entryExitPoints();
        player = new Player(entryExit[0], entryExit[1]); 
        pathChecker = new PathChecker(maze, player);
    }

    @Test
    public void testValidPath() 
    {
        String path = "FR2FL3FRFLFRFL2F";       // correct path
        pathChecker.checkPath(path);
        assertEquals(maze.entryExitPoints()[2], player.getX());
        assertEquals(maze.entryExitPoints()[3], player.getY());
    }

    @Test
    public void testValidCanonicalPath() 
    {
        String path = "FRFFLFFFRFLFRFLFF";       // correct path
        pathChecker.checkPath(path);
        assertEquals(maze.entryExitPoints()[2], player.getX());
        assertEquals(maze.entryExitPoints()[3], player.getY());
    }

    @Test
    public void testInvalidPath() 
    {
        String path = "4F";         // incorrect path
        pathChecker.checkPath(path);
        assertNotEquals(maze.entryExitPoints()[2], player.getX());
        assertNotEquals(maze.entryExitPoints()[3], player.getY());
    }
} 