/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luis
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
