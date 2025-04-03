package ca.mcmaster.se2aa4.mazerunner;

public class AdvanceCommand implements MovingCommand 
{
    private Player player;
    private Maze maze;
    private int xCoordBackup; 
    private int yCoordBackup; 
    private char directionBackup;

    public AdvanceCommand(Player player, Maze maze) 
    {
        this.player = player;
        this.maze = maze;
    }

    @Override
    public void execute() 
    {
        xCoordBackup = player.getX();
        yCoordBackup = player.getY();
        directionBackup = player.getDirection();

        player.canAdvance(maze.getMaze());
    }

    @Override
    public void undo() 
    {
        player.set(xCoordBackup, yCoordBackup);
        player.setDirection(directionBackup);
    }
}