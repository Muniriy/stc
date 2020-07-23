package ru.makhmutov.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;

import static java.lang.Thread.sleep;

public class FileProcessor {
    private static final Logger log = LogManager.getLogger(FileProcessor.class);

    /**
     * The entry point of FileProcessor program.
     * The file is created, renamed, copied and deleted
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        String path = "lesson15/src/";
        String fileName = "file4.txt";
        String renamedFileName = "renamed file4.txt";
        String copiedFileName = "copied file4.txt";
        try {
            processFile(path, fileName, renamedFileName, copiedFileName);
        } catch (NoSuchFileException e) {
            log.error(new NoSuchFileException("File " + e.getFile()) + " was not found");
            e.printStackTrace();
        } catch (SecurityException e) {
            log.error(e.getMessage(), new SecurityException());
            e.printStackTrace();
        } catch (IOException e) {
            log.error(e.getMessage(), new IOException());
            e.printStackTrace();
        } catch (InterruptedException e) {
            log.error(new InterruptedException());
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    /**
     * This method provides processing of file:
     * its creation, renaming, copying and deletion
     *
     * @param path            The path to the task root
     * @param fileName        The name of original file
     * @param renamedFileName The name of renamed file
     * @param copiedFileName  The name of copied file
     * @throws SecurityException    Thrown by the security manager to
     *                              indicate a security violation
     * @throws IOException          Signals that an I/O exception of some sort
     *                              has occurred. This class is the general class of exceptions
     *                              produced by failed or interrupted I/O operations.
     * @throws InterruptedException Thrown when a thread is waiting,
     *                              sleeping, or otherwise occupied, and the thread is interrupted,
     *                              either before or during the activity.
     */
    private static void processFile(String path, String fileName, String renamedFileName, String copiedFileName)
            throws SecurityException, IOException, InterruptedException {
        File file = new File(path.concat(fileName));
        if (!file.exists()) {
            if (file.createNewFile()) {
                log.info("File \"{}\" is created", fileName);
                sleep(2000);
                File renamedFile = new File(path.concat(renamedFileName));
                if (!renamedFile.exists()) {
                    if (file.renameTo(renamedFile)) {
                        log.info("File \"{}\" is renamed to \"{}\"", fileName, renamedFileName);
                        sleep(2000);
                        File copiedFile = new File(path.concat(copiedFileName));
                        if (!copiedFile.exists()) {
                            Files.copy(renamedFile.toPath(), copiedFile.toPath());
                            log.info("File \"{}\" is copied from \"{}\"", copiedFileName, renamedFileName);
                            sleep(2000);
                            if (renamedFile.delete()) {
                                log.info("File \"{}\" is deleted", renamedFileName);
                            } else {
                                log.error("File \"{}\" cannot be deleted", renamedFileName, new SecurityException());
                            }
                        } else {
                            log.error("File \"{}\" already exists", copiedFileName);
                        }
                    } else {
                        log.error("File \"{}\" cannot be renamed", fileName, new SecurityException());
                    }
                } else {
                    log.error("File \"{}\" already exists", renamedFileName);
                }
            } else {
                log.error("File \"{}\" is not created", fileName, new SecurityException());
            }
        } else {
            log.error("File \"{}\" already exists", fileName);
        }
    }
}
