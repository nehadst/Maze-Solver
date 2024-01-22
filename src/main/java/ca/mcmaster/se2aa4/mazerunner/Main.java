package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        // The walking skeleton
        /*
        String pathfile = "path/to/maze.txt"
        Maze maze = readConfiguration(pathfile);
        String solution = explrmaze(Maze);
        String path = input_path;
        maze = readConfiguration(args[i + 1]);
        factored_path = solution.turntofactorized();
        logger.info("Path to exit: " + solution);
        path_is_valid = path.verifypath();
        path_output(path_is_valid);
        */
        Configuration config = Configuration.readMaze(args);
        System.out.println("1");
        Maze maze = new Maze(config.getMazeConfig());
        System.out.println("2");
        System.out.println(maze.explrmaze());
        logger.info("** Starting Maze Runner");
        System.out.println("**** Computing path");
        System.out.println("PATH NOT COMPUTED");
        System.out.println("** End of MazeRunner");
    }
}
