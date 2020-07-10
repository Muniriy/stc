package ru.makhmutov.task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.File;

public class RecursivePass {
    private static final Logger log = (Logger) LogManager.getLogger(RecursivePass.class);

    /**
     * The entry point of RecursivePass program.
     * The program shows all files and directories
     * recursively going through all directories
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        String path = "lesson15/src/files/";
        RecursivePass recursivePass = new RecursivePass();
        recursivePass.goThrough(path, 0);
    }

    /**
     * This method shows the list of all files and directories
     *
     * @param path The path to the root directory
     */
    private void goThrough(String path, int depth) {
        File dir = new File(path);
        if (dir.listFiles() != null) {
            for (File file : dir.listFiles()) {
                String prefix = getPrefix(depth);
                if (file.isFile()) {
                    String fileName = String.format("%s[%s]", prefix, file.getName());
                    log.info(fileName);
                } else if (file.isDirectory()) {
                    String fileName = String.format("%s[%s]", prefix, file.getName());
                    log.info(fileName);
                    goThrough(file.getAbsolutePath(), depth + 1);
                }
            }
        }
    }

    /**
     * This method returns prefix for each file/directory
     * in form of spaces
     *
     * @return Prefix for the file/directory
     */
    private String getPrefix(int depth) {
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            prefix.append("\t");
        }
        return prefix.toString();
    }
}
