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
        
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("i")) 
            {
                String mazeFilePath = cmd.getOptionValue("i");
                logger.info("**** Reading the maze from file " + mazeFilePath);
                Maze maze = new Maze();
                maze.displayMaze(mazeFilePath);
            }
            
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }

        logger.info("**** Computing path");
        logger.error("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
