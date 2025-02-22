package physics;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Physics_PIT extends JFrame {
    private JPanel contentPane;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textFieldResult;
    private JComboBox<String> comboBox;
    private JLabel lblInput1, lblInput2;
    private JLabel lblBackground;
    private JLabel lblNewLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Physics_PIT frame = new Physics_PIT();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Physics_PIT() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Documents\\2nd Sem_Finals\\Physics\\PIT\\Icon.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 573, 621);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        String[] formulas = {"Select Formula", "Force (F = m * a)", "Mass (m = F / a)", "Acceleration (a = F / m)", "Average Velocity (v = d / t)", "Average Acceleration (a = v / t)"};
        comboBox = new JComboBox<>(formulas);
        comboBox.setBackground(new Color(255, 255, 255));
        comboBox.setForeground(Color.DARK_GRAY);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Formula", "Force (F = m * a)", "Mass (m = F / a)", "Acceleration (a = F / m)", "Average Velocity (v = d / t)", "Average Acceleration (a = v / t)"}));
        comboBox.setFont(new Font("Kristen ITC", Font.BOLD, 18));
        comboBox.setBounds(113, 267, 330, 31);
        contentPane.add(comboBox);
        
        lblInput1 = new JLabel("Input 1:");
        lblInput1.setForeground(Color.DARK_GRAY);
        lblInput1.setFont(new Font("Kristen ITC", Font.BOLD, 16));
        lblInput1.setBounds(127, 323, 173, 31);
        contentPane.add(lblInput1);
        
        lblInput2 = new JLabel("Input 2:");
        lblInput2.setForeground(Color.DARK_GRAY);
        lblInput2.setFont(new Font("Kristen ITC", Font.BOLD, 16));
        lblInput2.setBounds(127, 384, 173, 31);
        contentPane.add(lblInput2);
        
        textField1 = new JTextField();
        textField1.setBackground(new Color(255, 255, 255));
        textField1.setFont(new Font("Kristen ITC", Font.BOLD, 18));
        textField1.setBounds(296, 318, 105, 41);
        contentPane.add(textField1);
        textField1.setColumns(10);
        
        textField2 = new JTextField();
        textField2.setBackground(new Color(255, 255, 255));
        textField2.setFont(new Font("Kristen ITC", Font.BOLD, 18));
        textField2.setBounds(296, 379, 105, 41);
        contentPane.add(textField2);
        textField2.setColumns(10);
        
        JButton btnSolve = new JButton("Solve");
        btnSolve.setBackground(new Color(255, 255, 255));
        btnSolve.setForeground(Color.DARK_GRAY);
        btnSolve.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
        btnSolve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                solveFormula();
            }
        });
        btnSolve.setBounds(172, 516, 89, 41);
        contentPane.add(btnSolve);
        
        JLabel lblResult = new JLabel("Result:");
        lblResult.setForeground(Color.DARK_GRAY);
        lblResult.setFont(new Font("Kristen ITC", Font.BOLD, 16));
        lblResult.setBounds(127, 445, 173, 31);
        contentPane.add(lblResult);
        
        textFieldResult = new JTextField();
        textFieldResult.setEditable(false);
        textFieldResult.setBackground(new Color(255, 255, 255));
        textFieldResult.setFont(new Font("Kristen ITC", Font.BOLD, 18));
        textFieldResult.setBounds(296, 440, 105, 41);
        contentPane.add(textFieldResult);
        textFieldResult.setColumns(10);
        
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateFields();
            }
        });
        
        JButton btnExit = new JButton("Exit");
        btnExit.setBackground(new Color(255, 255, 255));
        btnExit.setForeground(Color.DARK_GRAY);
        btnExit.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setBounds(287, 516, 89, 41);
        contentPane.add(btnExit);
        
        lblNewLabel = new JLabel("Physics PIT: Clutario, Elorde, Margate, Oga, Yañez");
        lblNewLabel.setFont(new Font("Kristen ITC", Font.BOLD, 13));
        lblNewLabel.setBounds(67, 176, 376, 19);
        contentPane.add(lblNewLabel);
        
        lblBackground = new JLabel("");
        lblBackground.setIcon(new ImageIcon("C:\\Users\\user\\Documents\\2nd Sem_Finals\\Physics\\PIT\\background 2.jpg"));
        lblBackground.setBounds(0, 0, 563, 341);
        contentPane.add(lblBackground);
    }

    protected void updateFields() {
        String selectedFormula = (String) comboBox.getSelectedItem();
        switch (selectedFormula) {
            case "Force (F = m * a)":
            	lblInput1.setVisible(true);
                lblInput1.setText("Mass (m):");
                lblInput2.setText("Acceleration (a):");
                break;
            case "Mass (m = F / a)":
                lblInput1.setText("Force (F):");
                lblInput2.setText("Acceleration (a):");
                break;
            case "Acceleration (a = F / m)":
                lblInput1.setText("Force (F):");
                lblInput2.setText("Mass (m):");
                break;
            case "Average Velocity (v = d / t)":
                lblInput1.setText("Distance (d):");
                lblInput2.setText("Time (t):");
                break;
            case "Average Acceleration (a = v / t)":
                lblInput1.setText("Velocity (v):");
                lblInput2.setText("Time (t):");
                break;
            default:
                lblInput1.setText("Input 1:");
                lblInput2.setText("Input 2:");
                break;
        }
    }
    
    protected void solveFormula() {
        String selectedFormula = (String) comboBox.getSelectedItem();
        double input1, input2, result = 0;

        try {
            input1 = Double.parseDouble(textField1.getText());
            input2 = Double.parseDouble(textField2.getText());
        } catch (NumberFormatException e) {
            textFieldResult.setText("Invalid Input");
            textFieldResult.setFont(new Font("Kristen ITC", Font.BOLD, 14));
            return;
        }
        
        switch (selectedFormula) {
            case "Force (F = m * a)":
                result = input1 * input2;
                break;
            case "Mass (m = F / a)":
                result = input1 / input2;
                break;
            case "Acceleration (a = F / m)":
                result = input1 / input2;
                break;
            case "Average Velocity (v = d / t)":
                result = input1 / input2;
                break;
            case "Average Acceleration (a = v / t)":
                result = input1 / input2;
                break;
            default:
                textFieldResult.setText("Select a formula");
                textFieldResult.setFont(new Font("Kristen ITC", Font.BOLD, 11));
                return;
        }
        
        textFieldResult.setText(Double.toString(result));
    }
}