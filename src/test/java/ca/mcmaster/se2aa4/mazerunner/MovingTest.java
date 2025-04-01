package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovingTest 
{
    private Player player; 
    private Maze straightMaze;

    @BeforeEach
    public void setUp() 
    {
        straightMaze = new Maze(); 
        straightMaze.displayMaze("./examples/straight.maz.txt"); // Process the straight maze
        int entryExit[] = straightMaze.entryExitPoints();
        player = new Player(entryExit[0], entryExit[1]); 
    }

    @Test
    public void testMoveRight() 
    {
        player.moveRight();
        assertEquals('S', player.getDirection());

        player.moveRight();
        assertEquals('W', player.getDirection());

        player.moveRight();
        assertEquals('N', player.getDirection());

        player.moveRight();
        assertEquals('E', player.getDirection());
    }

    @Test
    public void testMoveLeft() 
    {
        player.moveLeft();
        assertEquals('N', player.getDirection());

        player.moveLeft();
        assertEquals('W', player.getDirection());

        player.moveLeft();
        assertEquals('S', player.getDirection());

        player.moveLeft();
        assertEquals('E', player.getDirection());
    }

    @Test
    public void testCanAdvance() 
    {
        // Move forward while facing East
        assertTrue(player.canAdvance(straightMaze.getMaze()));
        assertEquals(2, player.getX());
        assertEquals(1, player.getY());

        // Turn left to face North and attempt to move forward
        player.moveLeft();
        assertFalse(player.canAdvance(straightMaze.getMaze()));
    } 
}


