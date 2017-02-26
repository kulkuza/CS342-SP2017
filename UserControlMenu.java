import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class UserControlMenu extends JPanel {
    public UserControlMenu() {
        Dimension menuDimensions = getSize();
        int width = menuDimensions.width;
        int height = menuDimensions.height;
        
        JButton toggleStartStopButton = new JButton("START");;
        
        setLayout(new GridBagLayout());
        setBackground(new Color(220, 220, 220));
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
        
        GridBagConstraints gridConstraints = getDefaultGridConstraints();
        
        gridConstraints.gridy = 4;
        add(toggleStartStopButton, gridConstraints);
    }
    
    private GridBagConstraints getDefaultGridConstraints() {
        GridBagConstraints gridConstraints = new GridBagConstraints();
        
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.gridwidth = 1;
        gridConstraints.gridheight = 1;
        gridConstraints.weightx = 50;
        gridConstraints.weighty = 100;
        gridConstraints.insets = new Insets(5, 5, 5, 5);
        gridConstraints.anchor = GridBagConstraints.CENTER;
        gridConstraints.fill = GridBagConstraints.BOTH;
        
        return gridConstraints;
    }
}
