package ca.mcmaster.se2aa4.mazerunner;

public abstract class Solver 
{
    public abstract void solve(); 
}

/* public class BestFirstSolver extends Solver
{
    @Override
    public void solve() 
    {
        // Best First Search algorithm would be implemented here
        // This is a placeholder implementation just to show the power of the factory pattern
    }
} */


// I can implement more types of solvers in the future and put them in there own files
// Then simply utilize the factory pattern to create the solver


