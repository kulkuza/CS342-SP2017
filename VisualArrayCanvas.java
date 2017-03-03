import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class VisualArrayCanvas extends JPanel {
    private int height, width;
    private int maxBarHeight;
    private int[] arrayValues;
    
    public VisualArrayCanvas() {
        setBackground(Color.white);
    }
    
    public void drawArray(int arr[]) {
        Dimension arrayCanvasDimensions = getSize();
        width = arrayCanvasDimensions.width;
        height = arrayCanvasDimensions.height;
        
        maxBarHeight = height * 9 / 10; // 90% of canvas height
        
        arrayValues = arr;
        
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
            
            graphics.drawRect(barX, barY, barWidth, barHeight);
            
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
}
