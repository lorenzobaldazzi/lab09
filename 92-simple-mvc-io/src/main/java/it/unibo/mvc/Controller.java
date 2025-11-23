package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File currentFile;

    /**
     * default current file path.
     */
    public Controller() {
        this.currentFile = new File(
            System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "output.txt");
    }

    /**
     * Set different file.
     * 
     * @param newFile the file to be set as the current one
     */
    public void setFile(final File newFile) {
        this.currentFile = newFile;
    }

    /**
     * get current file.
     * 
     * @return the current file
     */
    public File getFile() {
        return this.currentFile;
    }

    /**
     * current path file.
     * 
     * @return current path file
     */
    public String getPathFile() {
        return this.currentFile.getPath();
    }

    /**
     * save the txt inside the file.
     * 
     * @param text the text to write inside the file
     * @throws IOException exception
     */
    public void save(final String text) throws IOException {
        try (PrintStream writer = new PrintStream(this.currentFile, StandardCharsets.UTF_8)) {
            writer.println(text);
        }
    }
}
