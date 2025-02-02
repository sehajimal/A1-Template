package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption("i", true, "loading maze");
        options.addOption("p", true, "checking path");
        Maze maze = new Maze();
        Player player = new Player(1, 1);
        Solver solver = new Solver(maze, player);

        try {
            CommandLine cmd = parser.parse(options, args);
            int entryExit[] = null;
            if (cmd.hasOption("i")) 
            {
                String mazeFilePath = cmd.getOptionValue("i");
                logger.info("**** Reading the maze from file " + mazeFilePath);
                maze.displayMaze(mazeFilePath);
                entryExit = maze.entryExitPoints();
                System.out.println("Entry point: " + entryExit[0] + ", " + entryExit[1]);
                System.out.println("Exit point: " + entryExit[2] + ", " + entryExit[3]);
                if (entryExit != null) {
                    solver.solve(entryExit[0], entryExit[1], entryExit[2], entryExit[3]);
                } else {
                    logger.error("Entry and exit points are not defined.");
                }
            } 
            
            else 
            {
                logger.warn("Please use the -i flag.");
            }

            if (cmd.hasOption("p")) 
            {
                String path = cmd.getOptionValue("p");
                logger.info("**** Checking path " + path);
            
            } 
            
            else 
            {
                logger.warn("Please use the -p flag.");
            }
        
            
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }


        logger.info("**** Computing path");
        //logger.error("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
