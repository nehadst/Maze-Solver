package ca.mcmaster.se2aa4.mazerunner;

public class Maze {
    private char[][] maze;

    public Maze(char[][] maze) {
        this.maze = maze;
    }

    public char[][] getMaze() {
        return this.maze;
    }

    public String explrmaze() {
        int startX = 0;
        int startY = 0;

        int currentX = startX;
        int currentY = startY;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int currentDirection = 0;

        StringBuilder path = new StringBuilder();

        while (true) {
            if (maze[currentX][currentY] == 'G') {
                return path.toString();
            }

            int nextX = currentX + directions[currentDirection][0];
            int nextY = currentY + directions[currentDirection][1];
            if (nextX >= 0 && nextX < maze.length && nextY >= 0 && nextY < maze[0].length && maze[nextX][nextY] != '#') {
                currentX = nextX;
                currentY = nextY;
                path.append("F");
                continue;
            }

            nextX = currentX + directions[(currentDirection + 1) % 4][0];
            nextY = currentY + directions[(currentDirection + 1) % 4][1];
            if (nextX >= 0 && nextX < maze.length && nextY >= 0 && nextY < maze[0].length && maze[nextX][nextY] != '#') {
                currentX = nextX;
                currentY = nextY;
                currentDirection = (currentDirection + 1) % 4;
                path.append("R");
                continue;
            }
            currentDirection = (currentDirection + 3) % 4;
            path.append("L");
        }
    }

    public String solveMaze() {
        return explrmaze();
    }
}