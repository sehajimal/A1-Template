package ca.mcmaster.se2aa4.mazerunner;

public class MoveLeftCommand implements MovingCommand 
{
    private Player player;

    public MoveLeftCommand(Player player) 
    {
        this.player = player;
    }

    @Override
    public void execute() 
    {
        player.moveLeft();
    }

    @Override
    public void undo() 
    {
        player.moveRight();
    }
}