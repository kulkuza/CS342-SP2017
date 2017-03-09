
import javax.swing.JPanel;

/*
 * // Usage:
 * ViDSortGUI gui = ViDSortGUI.getInstance("Window Title Here");
 *
 * ...
 *
 * gui.updateVisualArray(arr); // draw representation of array
 */

public class ViDSortGUI {
    private static ViDSortGUI instance; // singleton
    
    private Window window;
    private UserControlMenu userControlMenu = new UserControlMenu();
    private VisualArrayCanvas leftVisualArrayCanvas = new VisualArrayCanvas();
    private VisualArrayCanvas rightVisualArrayCanvas = new VisualArrayCanvas();
    
    private boolean runningSort = false;
    
    public enum Mode {
        SINGLE_ALGORITHM_MODE,
        COMPARISON_MODE
    };
    
    private Mode mode = Mode.SINGLE_ALGORITHM_MODE;
    
    private ViDSortGUI(String windowTitle) {
        this(1000, 500, windowTitle);
    }
        
    private ViDSortGUI(int windowWidth, int windowHeight, String windowTitle) {
        window = new Window(windowWidth, windowHeight, windowTitle);
        
        setupPanels();
    }
    
    public static ViDSortGUI getInstance() {
        if (instance == null)
            instance = new ViDSortGUI("Default Title");
        
        return instance;
    }
    
    public static ViDSortGUI getInstance(String windowTitle) {
        if (instance == null)
            instance = new ViDSortGUI(windowTitle);
        
        return instance;
    }
    
    public static ViDSortGUI getInstance(int windowWidth, int windowHeight, String windowTitle) {
        if (instance == null)
            instance = new ViDSortGUI(windowWidth, windowHeight, windowTitle);
        
        return instance;
    }
    
    private void setupPanels() {
        removePanel(userControlMenu);
        removePanel(leftVisualArrayCanvas);
        removePanel(rightVisualArrayCanvas);
        
        if (mode == Mode.SINGLE_ALGORITHM_MODE) {
            window.addMenuPanel(userControlMenu, Window.Position.LEFT);
            window.addCanvasPanel(rightVisualArrayCanvas, Window.Position.RIGHT);
        } else if (mode == Mode.COMPARISON_MODE) {
            window.addCanvasPanel(leftVisualArrayCanvas, Window.Position.LEFT);
            window.addMenuPanel(userControlMenu, Window.Position.MIDDLE);
            window.addCanvasPanel(rightVisualArrayCanvas, Window.Position.RIGHT);
        }
        
        window.revalidate();
    }
    
    private void removePanel(JPanel panel) {
        if (panel.getParent() == window.getContentPane())
            window.remove(panel);
    }
    
    public void toggleMode() {
        if (mode == Mode.COMPARISON_MODE) {
            mode = Mode.SINGLE_ALGORITHM_MODE;
        } else {
            mode = Mode.COMPARISON_MODE;
        }
        
        userControlMenu.resetMenuComponents();
        setupPanels();
    }
    
    public Mode getMode() {
        return mode;
    }
    
    public void toggleRunningSort() {
        runningSort = !runningSort;
    }
    
    public boolean isRunningSort() {
        return runningSort;
    }
    
    public void update(int[] arr) {
        rightVisualArrayCanvas.drawArray(arr);
    }
    
    public void update(int[] leftArr, int[]rightArr) {
        leftVisualArrayCanvas.drawArray(leftArr);
        rightVisualArrayCanvas.drawArray(rightArr);
    }
}
