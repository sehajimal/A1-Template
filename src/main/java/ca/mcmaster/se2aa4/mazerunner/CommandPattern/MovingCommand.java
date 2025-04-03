package ca.mcmaster.se2aa4.mazerunner;

public interface MovingCommand 
{
    void execute();
    void undo();
}