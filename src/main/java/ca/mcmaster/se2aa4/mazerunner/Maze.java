package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Maze 
{
    private static final Logger logger = LogManager.getLogger(Maze.class);
    private char[][] maze;
    int rows = 0;
    int columns;

    //constructor
    //public Maze() 
    //{

    //}

    //getter method
    public char[][] getMaze() 
    {
        return maze;
    } 

    public void displayMaze(String mazeFilePath)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(mazeFilePath))) 
        {
            //reading the first line to get the number of columns
            String line = reader.readLine();
            columns = line.length();
            rows++;

            while ((line = reader.readLine()) != null) 
            {
                rows++;
            }

            maze = new char[rows][columns];

            BufferedReader newReader = new BufferedReader(new FileReader(mazeFilePath));
            rows = 0;
            
            //storing values in the maze array
            while((line = newReader.readLine()) != null)
            {
                for(int column = 0; column < columns; column++)
                {
                    maze[rows][column] = line.charAt(column);
                }
                
                rows++;
            }

            for (int i = 0; i < maze.length; i++) 
            {
                for (int j = 0; j < maze[i].length; j++) 
                {
                    System.out.print(maze[i][j]);
                }
                System.out.print("\n");
            }
        } 
        
        catch(Exception e) 
        {
            logger.error("/!\\ An error has occured /!\\");
        }
    }
}
