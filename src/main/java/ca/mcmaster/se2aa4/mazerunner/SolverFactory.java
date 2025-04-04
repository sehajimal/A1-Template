package ca.mcmaster.se2aa4.mazerunner;

public class SolverFactory 
{
    public Solver getSolver(String solverType, Maze maze, Player player) 
    {
        if (solverType == null)
        {
            return null;
        }

        if (solverType.equalsIgnoreCase("righthand")) 
        {
            return new RightHandSolver(maze, player);
        }

        /* else if (solverType.equalsIgnoreCase("bestfirst")) 
        {
            return new BestFirstSolver(maze, player);
            // This is an example of how more solvers can be initialized   

        } */

        
        // Add more solvers here in the future

        return null;
    }
}