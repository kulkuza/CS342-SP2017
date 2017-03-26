
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class VisualArrayCanvas extends JPanel {
    private int height, width;
    private int maxBarHeight;
    private int[] arrayValues;
    private int index1, index2; // indices to swap
    
    public VisualArrayCanvas() {
        index1 = index2 = -1;
        setBackground(Color.white);
    }
    
    public void setArray(int[] arr) {
        arrayValues = arr;
    }
    
    public void swapArrayValues(int index1, int index2) {
        int temp = arrayValues[index1];
        arrayValues[index1] = arrayValues[index2];
        arrayValues[index2] = temp;
    }
    
    /*
     * deprecated:
     * new drawArray() allows highlighting swapped values
     */
    public void drawArray(int arr[]) {
        getCanvasDimensions();
        maxBarHeight = height * 9 / 10; // 90% of canvas height
        
        arrayValues = arr;
        
        repaint();
    }
    
    /*
     * draw array without highlighting
     */
    public void drawArray() {
        getCanvasDimensions();
        maxBarHeight = height * 9 / 10; // 90% of canvas height
        
        this.index1 = -1;
        this.index2 = -1;
        
        repaint();
    }
    
    /*
     * draw array with highlighting at indices
     * index1 & index2
     */
    public void drawArray(int index1, int index2) {
        getCanvasDimensions();
        maxBarHeight = height * 9 / 10; // 90% of canvas height
        
        this.index1 = index1;
        this.index2 = index2;
        
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        if (arrayValues == null)
            return;
        
        int maxValueInArray = maxValueIn(arrayValues);
        int changeRatio = maxBarHeight / maxValueInArray;
        int barWidth = width / arrayValues.length;
        
        graphics.setColor(new Color(150, 150, 150));
        
        int index = 0;
        while (true) {
            int currentValue = arrayValues[index];
            int barHeight = currentValue * changeRatio;
            int barX = barWidth * index;
            int barY = height - barHeight;
            
            if (index == arrayValues.length - 1) {
                graphics.drawRect(barX, barY, width - barX, barHeight);
                break;
            }
            
            if (index == index1) {
                graphics.setColor(Color.BLUE);
                graphics.fillRect(barX, barY, width - barX, barHeight);
            } else if (index == index2) {
                graphics.setColor(Color.RED);
                graphics.fillRect(barX, barY, width - barX, barHeight);
            } else {
                graphics.drawRect(barX, barY, barWidth, barHeight);
            }
            
            index++;
        }
    }
    
    private int maxValueIn(int[] arr) {
        int max = Integer.MIN_VALUE;
        
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] > max) {
                max = arr[index];
            }
        }
        
        return max;
    }
    
    public void getCanvasDimensions() {
        Dimension arrayCanvasDimensions = getSize();
        width = arrayCanvasDimensions.width;
        height = arrayCanvasDimensions.height;
    }
}
