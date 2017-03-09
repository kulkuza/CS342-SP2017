import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
    JPanel windowContent;
    
    public enum Position {
        LEFT,
        MIDDLE,
        RIGHT
    };
    
    public Window(int width, int height, String title) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setVisible(true);
    }
    
    public void addCanvasPanel(JPanel canvasPanel, Position pos) {
        GridBagConstraints gridConstraints = getDefaultGridConstraints();
        gridConstraints.weightx = 100;
        
        if (pos == Position.LEFT) {
            gridConstraints.gridx = 0;
        } else if (pos == Position.RIGHT) {
            gridConstraints.gridx = 2;
        }
        
        add(canvasPanel, gridConstraints);
    }
    
    public void addMenuPanel(JPanel menuPanel, Position pos) {
        GridBagConstraints gridConstraints = getDefaultGridConstraints();
        gridConstraints.gridx = 1;
        
        if (pos == Position.LEFT) {
            gridConstraints.weightx = 50;
        } else if (pos == Position.MIDDLE) {
            gridConstraints.weightx = 25;
        }
        
        add(menuPanel, gridConstraints);
    }
    
    private GridBagConstraints getDefaultGridConstraints() {
        GridBagConstraints gridConstraints = new GridBagConstraints();
        
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.gridwidth = 1;
        gridConstraints.gridheight = 1;
        gridConstraints.weightx = 100;
        gridConstraints.weighty = 100;
        gridConstraints.insets = new Insets(0, 0, 0, 0);
        gridConstraints.anchor = GridBagConstraints.CENTER;
        gridConstraints.fill = GridBagConstraints.BOTH;
        
        return gridConstraints;
    }
}
