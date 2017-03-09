
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class UserControlMenu extends JPanel {
    private final String[] algorithmNames = {"Bubble Sort", "Insertion Sort", "Merge Sort"};
    private JComboBox leftAlgorithmComboBox;
    private JComboBox rightAlgorithmComboBox;
    
    private JCheckBox compareCheckBox;
    
    private final String[] arraySizes = {"5", "10", "15"};
    private JComboBox sizeComboBox;
    
    private JButton toggleStartStopButton;
    
    public UserControlMenu() {
        leftAlgorithmComboBox = new JComboBox(algorithmNames);
        leftAlgorithmComboBox.setSelectedIndex(0);
        rightAlgorithmComboBox = new JComboBox(algorithmNames);
        rightAlgorithmComboBox.setSelectedIndex(0);
        
        compareCheckBox = new JCheckBox("Compare");
        compareCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                ViDSortGUI.getInstance().toggleMode();
            }
        });
        
        sizeComboBox = new JComboBox(arraySizes);
        rightAlgorithmComboBox.setSelectedIndex(0);
        
        toggleStartStopButton = new JButton("START");
        toggleStartStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("START"))
                    toggleStartStopButton.setText("STOP");
                else
                    toggleStartStopButton.setText("START");
                
                ViDSortGUI.getInstance().toggleRunningSort();
            }
        });
        
        setLayout(new GridBagLayout());
        setBackground(new Color(220, 220, 220));
        setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.black));
        
        GridBagConstraints gridConstraints = getDefaultGridConstraints();
        gridConstraints.gridy = 1;
        add(rightAlgorithmComboBox, gridConstraints);
        gridConstraints.gridy = 3;
        add(compareCheckBox, gridConstraints);
        gridConstraints.gridy = 4;
        add(sizeComboBox, gridConstraints);
        gridConstraints.gridy = 5;
        gridConstraints.weighty = 10;
        add(toggleStartStopButton, gridConstraints);
    }
    
    public void resetMenuComponents() {
        ViDSortGUI.Mode mode = ViDSortGUI.getInstance().getMode();
        GridBagConstraints gridConstraints = getDefaultGridConstraints();
        
        if (mode == ViDSortGUI.Mode.SINGLE_ALGORITHM_MODE) {
            removeComboBox(rightAlgorithmComboBox);
            gridConstraints.gridy = 1;
            add(rightAlgorithmComboBox, gridConstraints);
        } else if (mode == ViDSortGUI.Mode.COMPARISON_MODE) {
            removeComboBox(leftAlgorithmComboBox);
            removeComboBox(rightAlgorithmComboBox);
            gridConstraints.gridy = 1;
            add(leftAlgorithmComboBox, gridConstraints);
            gridConstraints.gridy = 2;
            add(rightAlgorithmComboBox, gridConstraints);
        }
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
    
    public void toggleStartStopText() {
        if (toggleStartStopButton.getText() == "START")
            toggleStartStopButton.setText("STOP");
        else
            toggleStartStopButton.setText("START");
    }
    
    private void removeComboBox(JComboBox comboBox) {
        if (comboBox.getParent() == this)
            remove(comboBox);
    }
}
