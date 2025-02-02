package ca.mcmaster.se2aa4.mazerunner;

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

    public void solve(int x1, int y1, int x2, int y2) {
        StringBuilder mazePath = new StringBuilder();
        while(!reachedEnd(x1, y1)) {
            // logic to move the player
            // update x1 and y1
            player.moveRight();
            if (player.checkBounds(maze)) {
                mazePath.append("R");
            }

            player.moveLeft();
            if (player.checkBounds(maze)) {
                mazePath.append("F");
            }

            player.moveLeft();
            if (player.checkBounds(maze)) {
                mazePath.append("L");
            }



        }
        if (reachedEnd(x1, y1)) {
            System.out.println("Reached the exit!");
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
