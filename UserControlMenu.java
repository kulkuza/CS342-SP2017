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
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class UserControlMenu extends JPanel {

    private final String[] algorithmNames = {"BubbleSort", "InsertionSort", "MergeSort", "SelectionSort", "QuickSort"};
    private JPanel leftAlgorithmPanel;
    private JLabel leftAlgorithmLabel;
    private JComboBox<String> leftAlgorithmComboBox;
    
    private JPanel rightAlgorithmPanel;
    private JLabel rightAlgorithmLabel;
    private JComboBox<String> rightAlgorithmComboBox;

    private JPanel comparePanel;
    private JCheckBox compareCheckBox;

    private final String[] arraySizes = {"5", "10", "15", "20", "25", "30", "35", "40", "45", "50"};
    private JPanel sizePanel;
    private JLabel sizeLabel;
    private JComboBox<String> sizeComboBox;
    
    private final int MAX_SPEED = 500;
    private final int MIN_SPEED = 50;
    private final int INIT_SPEED = 150;
    private JPanel speedPanel;
    private JLabel speedLabel;
    private JSlider speedSlider = new JSlider(JSlider.HORIZONTAL, MIN_SPEED, MAX_SPEED, INIT_SPEED);
    
    private JPanel toggleStartStopPanel;
    private JButton toggleStartStopButton;

    public UserControlMenu() {
        initializeLeftAlgorithmComponents();
        initializeRightAlgorithmComponents();
        initializeCompareComponents();
        initializeSizeComponents();
        initializeSpeedComponents();
        initializeStartStopComponents();
        
        setupLeftAlgorithmSection();
        setupRightAlgorithmSection();
        setupCompareSection();
        setupSizeSection();
        setupSpeedSection();
        setupStartStopSection();
        
        setLayout(new GridBagLayout());
        setBackground(new Color(220, 220, 220));
        setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.black));

        GridBagConstraints gridConstraints = getDefaultGridConstraints();
        gridConstraints.gridy = 1;
        add(rightAlgorithmPanel, gridConstraints);
        gridConstraints.gridy = 3;
        add(comparePanel, gridConstraints);
        gridConstraints.gridy = 4;
        add(sizePanel, gridConstraints);
        gridConstraints.gridy = 5;
        add(speedPanel, gridConstraints);
        gridConstraints.gridy = 6;
        gridConstraints.weighty = 10;
        add(toggleStartStopPanel, gridConstraints);
    }
    
    public void toggleStartStopText() {
        if (toggleStartStopButton.getText().equals("START")) {
            toggleStartStopButton.setText("RUNNING");
        } else {
            toggleStartStopButton.setText("START");
        }
    }
    
    public void setDefaultSettings() {
        ViDSortGUI gui = ViDSortGUI.getInstance();
        gui.setSelectedLeftAlgorithm(algorithmNames[0]); // set default
        gui.setSelectedRightAlgorithm(algorithmNames[0]); // set default
        gui.setSelectedSize(Integer.parseInt(arraySizes[0])); // set default
        gui.setSelectedSpeed(INIT_SPEED);
    }

    public void resetMenuComponents() {
        GridBagConstraints gridConstraints = getDefaultGridConstraints();

        removeComponent(leftAlgorithmPanel, this);
        removeComponent(rightAlgorithmPanel, this);
        
        ViDSortGUI.Mode mode = ViDSortGUI.getInstance().getMode();
        if (mode == ViDSortGUI.Mode.SINGLE_ALGORITHM_MODE) {
            rightAlgorithmLabel.setText("Algorithm");
            add(rightAlgorithmPanel, gridConstraints);
        } else if (mode == ViDSortGUI.Mode.COMPARISON_MODE) {
            rightAlgorithmLabel.setText("Right Algorithm");
            add(leftAlgorithmPanel, gridConstraints);
            gridConstraints.gridy = 2;
            add(rightAlgorithmPanel, gridConstraints);
        }
    }
    
    private void initializeLeftAlgorithmComponents() {
        leftAlgorithmLabel = new JLabel("Left Algorithm", JLabel.CENTER);
        leftAlgorithmComboBox = new JComboBox<>(algorithmNames);
        leftAlgorithmComboBox.setSelectedIndex(0);
        leftAlgorithmComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String alg = (String)cb.getSelectedItem();
                ViDSortGUI.getInstance().setSelectedLeftAlgorithm(alg);
                System.out.println("left algorithm: " + alg);
            }
        });
        leftAlgorithmPanel = new JPanel();
    }
    
    private void initializeRightAlgorithmComponents() {
        rightAlgorithmLabel = new JLabel("Right Algorithm", JLabel.CENTER);
        rightAlgorithmComboBox = new JComboBox<>(algorithmNames);
        rightAlgorithmComboBox.setSelectedIndex(0);
        rightAlgorithmComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String alg = (String)cb.getSelectedItem();
                ViDSortGUI.getInstance().setSelectedRightAlgorithm(alg);
                System.out.println("right algorithm: " + alg);
            }
        });
        rightAlgorithmPanel = new JPanel();
    }
    
    private void initializeCompareComponents() {
        compareCheckBox = new JCheckBox("Compare");
        compareCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                ViDSortGUI.getInstance().toggleMode();
            }
        });
        comparePanel = new JPanel();
    }
    
    private void initializeSizeComponents() {
        sizeLabel = new JLabel("# Of Elements", JLabel.CENTER);
        sizeComboBox = new JComboBox<>(arraySizes);
        sizeComboBox.setSelectedIndex(0);
        sizeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                int size = Integer.parseInt((String)cb.getSelectedItem());
                ViDSortGUI.getInstance().setSelectedSize(size);
            }
        });
        sizePanel = new JPanel();
    }
    
    private void initializeSpeedComponents() {
        speedLabel = new JLabel("Speed", JLabel.CENTER);
        speedSlider.setInverted(true);
        speedSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider)e.getSource();

                if (!slider.getValueIsAdjusting()) {
                    int speed = (int)slider.getValue();
                    ViDSortGUI.getInstance().setSelectedSpeed(speed);
                }
            }
        });
        speedPanel = new JPanel();
    }
    
    private void initializeStartStopComponents() {
        toggleStartStopButton = new JButton("START");
        toggleStartStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViDSortGUI gui = ViDSortGUI.getInstance();
                if (!gui.isRunningSort())
                    gui.toggleRunningSort();
            }
        });
        toggleStartStopPanel = new JPanel();
    }
    
    private void setupLeftAlgorithmSection() {
        setupLabeledSection(leftAlgorithmPanel, leftAlgorithmLabel, leftAlgorithmComboBox);
    }
    
    private void setupRightAlgorithmSection() {
        setupLabeledSection(rightAlgorithmPanel, rightAlgorithmLabel, rightAlgorithmComboBox);
    }
    
    private void setupCompareSection() {
        setupSingleComponentSection(comparePanel, compareCheckBox);
    }
    
    private void setupSizeSection() {
        setupLabeledSection(sizePanel, sizeLabel, sizeComboBox);
    }
    
    private void setupSpeedSection() {
        setupLabeledSection(speedPanel, speedLabel, speedSlider);
    }
    
    private void setupStartStopSection() {
        setupSingleComponentSection(toggleStartStopPanel, toggleStartStopButton);
    }
    
    private void setupLabeledSection(JPanel panel, JLabel label, JComponent field) {
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(220, 220, 220));
        
        GridBagConstraints gridConstraints = getDefaultGridConstraints();
        gridConstraints.weightx = 10;
        panel.add(label, gridConstraints);
        gridConstraints.gridx = 2;
        gridConstraints.weightx = 90;
        panel.add(field, gridConstraints);
    }
    
    private void setupSingleComponentSection(JPanel panel, JComponent field) {
        panel.setBackground(new Color(220, 220, 220));
        panel.add(field);
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

    private void removeComponent(JComponent component, JPanel panel) {
        if (component.getParent() == panel)
            panel.remove(component);
    }
}
