package ca.mcmaster.se2aa4.mazerunner;

public class MoveRightCommand implements MovingCommand 
{
    private Player player;

    public MoveRightCommand(Player player) 
    {
        this.player = player;
    }

    @Override
    public void execute() 
    {
        player.moveRight();
    }

    @Override
    public void undo() 
    {
        player.moveLeft(); 
    }
}