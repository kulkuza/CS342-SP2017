
import java.util.concurrent.TimeUnit;
import javax.swing.JPanel;

public class ViDSortGUI {

    private static ViDSortGUI instance; // singleton

    private Window window;
    private UserControlMenu userControlMenu = new UserControlMenu();
    private VisualArrayCanvas leftVisualArrayCanvas = new VisualArrayCanvas();
    private VisualArrayCanvas rightVisualArrayCanvas = new VisualArrayCanvas();

    private boolean runningSort = false;

    private String selectedLeftAlgorithm;
    private String selectedRightAlgorithm;
    private int selectedSize;
    private int selectedSpeed;

    public enum Mode {
        SINGLE_ALGORITHM_MODE,
        COMPARISON_MODE
    };

    private Mode mode = Mode.SINGLE_ALGORITHM_MODE;

    private ViDSortGUI() {
        window = new Window(1000, 500, "ViDSort");

        setupPanels();
    }

    public static ViDSortGUI getInstance() {
        if (instance == null)
            instance = new ViDSortGUI();

        return instance;
    }
    
    public void setDefaultSettings() {
        userControlMenu.setDefaultSettings();
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
        if (panel.getParent() == window.getContentPane()) {
            window.remove(panel);
        }
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
        userControlMenu.toggleStartStopText();
    }

    public boolean isRunningSort() {
        return runningSort;
    }

    public String getSelectedLeftAlgorithm() {
        return selectedLeftAlgorithm;
    }

    public void setSelectedLeftAlgorithm(String algorithm) {
        System.out.println("Setting left algorithm to: " + algorithm);
        selectedLeftAlgorithm = algorithm;
    }

    public String getSelectedRightAlgorithm() {
        return selectedRightAlgorithm;
    }

    public void setSelectedRightAlgorithm(String algorithm) {
        System.out.println("Setting right algorithm to: " + algorithm);
        selectedRightAlgorithm = algorithm;
    }

    public int getSelectedSize() {
        return selectedSize;
    }

    public void setSelectedSize(int size) {
        System.out.println("Setting array size to: " + String.valueOf(size));
        selectedSize = size;
    }
    
    public int getSelectedSpeed() {
        return selectedSpeed;
    }
    
    public void setSelectedSpeed(int speed) {
        System.out.println("Setting animation frame delay to: " + String.valueOf(speed));
        selectedSpeed = speed;
    }

    public void update(int[] arr) {
        rightVisualArrayCanvas.drawArray(arr);
    }
    
    public void setVisualArray(int[] arr) {
        rightVisualArrayCanvas.setArray(arr);
    }

    public void update(int index1, int index2) {
        rightVisualArrayCanvas.drawArray(index1, index2); // highlight indices to be swapped
        delay();
        rightVisualArrayCanvas.swapArrayValues(index1, index2);
        rightVisualArrayCanvas.drawArray(index1, index2); // highlight swapped indices
        delay();
        rightVisualArrayCanvas.drawArray(); // draw VisualArray without highlighting
    }
    
    public void update(int[] leftArr, int[] rightArr) {
        leftVisualArrayCanvas.drawArray(leftArr);
        rightVisualArrayCanvas.drawArray(rightArr);
    }
    
    public void delay() {
        try {
            TimeUnit.MILLISECONDS.sleep(this.selectedSpeed);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
