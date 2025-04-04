package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Maze 
{
    private static final Logger logger = LogManager.getLogger(Maze.class);
    private char[][] maze;
    int rows;
    int columns;

    /* //constructor
    public Maze() 
    {

    } */

    //getter method
    public char[][] getMaze() 
    {
        return maze;
    }  

    //method to get the entry and exit points
    public int[] entryExitPoints()   
    {
        int[] entry = new int[4];
        for (int i = 0; i < rows; i++) 
        {
            if (maze[i][0] == ' ') 
            {
                entry[0] = i;
                entry[1] = 0;
            }

            if (maze[i][columns - 1] == ' ') 
            {
                entry[2] = i;
                entry[3] = columns-1;
            }
        }
        return entry;
        //System.out.println("Entry point: " + entry[0] + ", " + entry[1]);
        //System.out.println("Exit point: " + entry[2] + ", " + entry[3]);
    }

    //method to process maze file
    public void displayMaze(String mazeFilePath)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(mazeFilePath))) 
        {
            String line;
            rows = 0;

            //counting rows
            while ((line = reader.readLine()) != null) 
            {
                //counting columns
                if (rows == 0) 
                {
                    columns = line.length();
                }
                rows++;
            }

            maze = new char[rows][columns];

            try (BufferedReader newReader = new BufferedReader(new FileReader(mazeFilePath)))
            {
                int row = 0;
                //storing values in the maze array
                while((line = newReader.readLine()) != null)
                {
                    maze[row] = line.toCharArray();
                    row++;
                }
            }

            /* //displaying the maze
            for (int i = 0; i < maze.length; i++) 
            {
                for (int j = 0; j < maze[i].length; j++) 
                {
                    System.out.print(maze[i][j]);
                }
                System.out.print("\n");
            } */
        } 
        
        catch(Exception e) 
        {
            logger.error("/!\\ An error has occured /!\\");
        }
    }
}
