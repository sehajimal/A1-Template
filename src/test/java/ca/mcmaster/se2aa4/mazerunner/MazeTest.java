package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MazeTest {

    private static final String mazepath = "./examples/direct.maz.txt"; 
    private Maze maze;

    @BeforeEach
    public void createMaze() 
    {
        maze = new Maze();
        maze.displayMaze(mazepath); 
    }

    @Test
    public void testFileReading() 
    {
        assertNotNull(maze.getMaze());
    }

    @Test
    public void testNumberOfColumns() 
    {
        int columns = maze.getMaze()[0].length; 
        assertEquals(8, columns);
    }

    @Test
    public void testNumberOfRows() 
    {
        int rows = maze.getMaze().length; 
        assertEquals(7, rows);
    }

    @Test
    public void testPlayerStartPos() 
    {
        int[] entryExit = maze.entryExitPoints();
        Player player = new Player(entryExit[0], entryExit[1]);          // Validate player starts at the entrance
        assertEquals(entryExit[0], player.getX());
        assertEquals(entryExit[1], player.getY());
    }
}