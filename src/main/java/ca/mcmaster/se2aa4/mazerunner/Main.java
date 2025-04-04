package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) 
    {
        logger.info("** Starting Maze Runner");

        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption("i", true, "loading maze");
        options.addOption("p", true, "checking path");

        try {
            CommandLine cmd = parser.parse(options, args);
            if (!cmd.hasOption("i")) 
            {
                logger.warn("Please use the -i flag.");
                return;
            } 
            
            String mazeFilePath = cmd.getOptionValue("i");
            logger.info("**** Reading the maze from file " + mazeFilePath);
            
            Maze maze = new Maze();
            maze.displayMaze(mazeFilePath);
            
            int entryExit[] = maze.entryExitPoints();
            
            Player player1 = new Player(entryExit[0], entryExit[1]);

            if (cmd.hasOption("p")) 
            {
                String path = cmd.getOptionValue("p");
                logger.info("**** Checking path " + path);
                PathChecker pathChecker = new PathChecker(maze, player1);
                pathChecker.checkPath(path);
            } 
            
            else 
            {
                Player player = new Player(entryExit[0], entryExit[1]);
                SolverFactory solverFactory = new SolverFactory();
                Solver solver = solverFactory.getSolver("righthand", maze, player);       //get an object of righthand
                solver.solve();    //call solve method of righthand solver
                
                // Solver solver2 = solverFactory.getSolver("bestfirst", maze, player);    
                // solver2.solve(); 

                // Above is an example of how more solvers can be initialized

            }
        
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }


        logger.info("**** Computing path");
        //logger.error("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
