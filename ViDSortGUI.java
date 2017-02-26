/*
 * // Usage:
 * ViDSortGUI gui = new ViDSortGUI("ViDSort");
 *
 * ...
 * 
 * gui.updateArray(arr); // draw representation of array
 */

public class ViDSortGUI {
    private Window window;
    private UserControlMenu userControlMenu = new UserControlMenu();
    private ArrayCanvas arrayCanvas = new ArrayCanvas();
    
    public ViDSortGUI(String windowTitle) {
        window = new Window(windowTitle);
        window.addLeftPanel(userControlMenu);
        window.addRightPanel(arrayCanvas);
        window.revalidate();
    }
        
    public ViDSortGUI(int windowWidth, int windowHeight, String windowTitle) {
        window = new Window(windowWidth, windowHeight, windowTitle);
        window.addLeftPanel(userControlMenu);
        window.addRightPanel(arrayCanvas);
        window.revalidate();
    }
    
    public void updateArray(int[] arr) {
        arrayCanvas.drawArray(arr);
    }
}
