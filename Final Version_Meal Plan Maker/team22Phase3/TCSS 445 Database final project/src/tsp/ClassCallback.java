/*
 * TCSS 305
 * Assignment 5B - PowerPaint part B.
 */
package tsp;

/**
 * An interface class for the undo/ redo action.
 * And also for the clear action
 * 
 * @author nnam1994
 * @version v1.0
 */
public interface ClassCallback {
    
    /**
     * Enable/ disable the undo button.
     * 
     * @param adminMode a simple boolean variable
     * @param login a simple boolean variable
     */
    void setLoginStatus(final boolean login, final boolean adminMode, String theUserName);
    
    /**
     * Enable/ disable the re - do button.
     * 
     * @param theOn a simple boolean variable
     */
    void setLogoutStatus(final boolean theOn);
    
}
