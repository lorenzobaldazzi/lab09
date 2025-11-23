package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /** 
     * Setting the next string to print.
     * 
     * @param nextString the string to set
     * @throws IllegalArgumentException if the string is null
     */
    void setNextString(String nextString);

    /** 
     * Getting the next string to print.
     * 
     * @return the next string
     */
    String getNextString();

    /**
     * Getting the history of the printed strings.
     * 
     * @return the history of the printed strings
     */
    List<String> getHistoryStrings();

    /**
     * Prints the current string.
     * 
     * @throws IllegalStateException If the current string is unset
     */
    void printCurrentString();

}
