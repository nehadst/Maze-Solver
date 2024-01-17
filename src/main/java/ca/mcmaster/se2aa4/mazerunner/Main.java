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
        
        logger.info("** Starting Maze Runner");
        Options options = new Options();
        options.addOption("i", true, "inputfile");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);
        }
        catch (ParseException e){
            logger.info("Parsing error " + e.getMessage());
        }
        String file  = cmd.getOptionValue("i");
        try {
            logger.info("**** Reading the maze from file " + file);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        System.out.print("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        System.out.print("PASS ");
                    }
                }
                System.out.print(System.lineSeparator());
            }
        } catch(Exception e) {
            System.err.println("/!\\ An error has occured /!\\");
        }
        System.out.println("**** Computing path");
        System.out.println("PATH NOT COMPUTED");
        System.out.println("** End of MazeRunner");
    }
}
