package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class Solver {
    private char[][] maze;
    private Player player;
    private int exitX;
    private int exitY;

    public Solver(Maze maze, Player player) {
        this.maze = maze.getMaze(); // Assuming Maze class has a method to get the maze array
        this.player = player;
        int[] entryExit = maze.entryExitPoints(); // Assuming Maze class has a method to get entry and exit points
        this.exitX = entryExit[2];
        this.exitY = entryExit[3];
    }

    public void solve() {
        List<Character> mazePath = new ArrayList<>();
        while (!reachedEnd(player.getX(), player.getY())) {
            player.moveRight();
            if (player.canAdvance(maze)) {
                mazePath.add('R');
                mazePath.add('F');
                continue;
            }

            player.moveLeft();
            if (player.canAdvance(maze)) {
                mazePath.add('F');
                continue;
            }

            player.moveLeft();
            mazePath.add('L');
        }

        if (reachedEnd(player.getX(), player.getY())) {
            System.out.println("Reached the exit!");
            System.out.println("Path: " + mazePath.toString());
        } else {
            System.out.println("Not at the exit yet.");
        }
    }

    private boolean reachedEnd(int x, int y) {
        return x == exitX && y == exitY;
    }

    public void checkPath(String path) {
        // method to check the path
    }
}
