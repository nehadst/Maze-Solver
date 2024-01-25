package ca.mcmaster.se2aa4.mazerunner;

public class Maze {

    private static final char WALL = '#';
    private static final char PATH = ' ';
    private char[][] maze;
    private int x, y;
    private Direction dir;

    private enum Direction {
        UP, RIGHT, DOWN, LEFT
    }

    public Maze(char[][] maze) {
        this.maze = maze;
        for (int i = 0; i < maze.length; i++) {
            if (maze[i][0] == PATH) {
                x = i;
                y = 0;
                break;
            }
        }
        this.dir = Direction.RIGHT;
    }
    
    public String explrmaze() {
        StringBuilder path = new StringBuilder();
        int forwardCount = 0;
    
        while (y < maze[0].length - 1) {
            if (canMove(turnRight(dir))) {
                if (forwardCount > 0) {
                    path.append(forwardCount).append('F');
                    forwardCount = 0;
                }
                turnRight();
                path.append('R');
                if (canMove(dir)) { 
                    moveForward();
                    forwardCount = 1;
                }
            } else if (canMove(dir)) {
                forwardCount++;
                moveForward();
            } else {

                if (forwardCount > 0) {
                    path.append(forwardCount).append('F');
                    forwardCount = 0;
                }
                turnLeft();
                path.append('L');
                while (!canMove(dir)) {
                    turnLeft();
                    path.append('L');
                }
                moveForward();
                forwardCount = 1;
            }
        }
        if (forwardCount > 0) {
            path.append(forwardCount).append('F');
        }
    
        return path.toString();
    }
    
    private boolean canMove() {
        return canMove(this.dir);
    }

    private boolean canMove(Direction direction) {
        switch (direction) {
            case UP: return x > 0 && maze[x - 1][y] == PATH;
            case RIGHT: return y < maze[0].length - 1 && maze[x][y + 1] == PATH;
            case DOWN: return x < maze.length - 1 && maze[x + 1][y] == PATH;
            case LEFT: return y > 0 && maze[x][y - 1] == PATH;
            default: return false;
        }
    }

    private void moveForward() {
        switch (dir) {
            case UP: x--; break;
            case RIGHT: y++; break;
            case DOWN: x++; break;
            case LEFT: y--; break;
        }
    }

    private void turnRight() {
        dir = Direction.values()[(dir.ordinal() + 1) % 4];
    }

    private void turnLeft() {
        dir = Direction.values()[(dir.ordinal() + 3) % 4];
    }

    private Direction turnRight(Direction direction) {
        return Direction.values()[(direction.ordinal() + 1) % 4];
    }

    private Direction turnLeft(Direction direction) {
        return Direction.values()[(direction.ordinal() + 3) % 4];
    }

    private String factorizePath(String path) {
        StringBuilder factoredPath = new StringBuilder();
        char lastChar = path.charAt(0);
        int count = 1;
        for (int i = 1; i < path.length(); i++) {
            char currentChar = path.charAt(i);
            if (currentChar == lastChar) {
                count++;
            } else {
                if (count > 1) {
                    factoredPath.append(count);
                }
                factoredPath.append(lastChar);
                lastChar = currentChar;
                count = 1;
            }
        }
        if (count > 1) {
            factoredPath.append(count);
        }
        factoredPath.append(lastChar);
        return factoredPath.toString();
    }
        public boolean verifyPath(String pathString) {
            int localX = x;
            int localY = y;
            Direction localDir = dir;
    
            for (char step : pathString.toCharArray()) {
                switch (step) {
                    case 'F':
                        if (!canMove(localX, localY, localDir)) {
                            return false;
                        }
                        if (localDir == Direction.UP) localX--;
                        if (localDir == Direction.RIGHT) localY++;
                        if (localDir == Direction.DOWN) localX++;
                        if (localDir == Direction.LEFT) localY--;
                        break;
                    case 'R':
                        localDir = turnRight(localDir);
                        break;
                    case 'L':
                        localDir = turnLeft(localDir);
                        break;
                    default:
                        return false;
                }
                if (localX < 0 || localX >= maze.length || localY < 0 || localY >= maze[0].length || maze[localX][localY] == WALL) {
                    return false;
                }
            }
            return localY == maze[0].length - 1;
        }
    
        private boolean canMove(int localX, int localY, Direction localDir) {
            switch (localDir) {
                case UP: return localX > 0 && maze[localX - 1][localY] == PATH;
                case RIGHT: return localY < maze[0].length - 1 && maze[localX][localY + 1] == PATH;
                case DOWN: return localX < maze.length - 1 && maze[localX + 1][localY] == PATH;
                case LEFT: return localY > 0 && maze[localX][localY - 1] == PATH;
                default: return false;
            }
        }
    }
