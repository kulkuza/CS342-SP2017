import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
    JPanel windowContent;

	public Window(String title) {
		setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setVisible(true);
	}
    
    public Window(int width, int height, String title) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setVisible(true);
    }
    
    public void addLeftPanel(JPanel leftPanel) {
        GridBagConstraints gridConstraints = getDefaultGridConstraints();
        
        add(leftPanel, gridConstraints);
    }
    
    public void addRightPanel(JPanel rightPanel) {
        GridBagConstraints gridConstraints = getDefaultGridConstraints();
        
        gridConstraints.gridx = 1;
        gridConstraints.weightx = 100; 
        add(rightPanel, gridConstraints);
    }
    
    private GridBagConstraints getDefaultGridConstraints() {
        GridBagConstraints gridConstraints = new GridBagConstraints();
        
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.gridwidth = 1;
        gridConstraints.gridheight = 1;
        gridConstraints.weightx = 50;
        gridConstraints.weighty = 100;
        gridConstraints.insets = new Insets(0, 0, 0, 0);
        gridConstraints.anchor = GridBagConstraints.CENTER;
        gridConstraints.fill = GridBagConstraints.BOTH;
        
        return gridConstraints;
    }
}
