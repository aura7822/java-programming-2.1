package swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing extends JFrame{
    private JLabel titleLabel;
    private JLabel detailsLabel;
    private JRadioButton phdRadio, mastersRadio, degreeRadio, diplomaRadio, certificateRadio;
    private ButtonGroup educationGroup;
    
    public Swing(){
        initComponents();
    }
    private void initComponents(){
        setTitle("Education Level Selector");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,300);
        setLayout(new BorderLayout(10,10));
        
        titleLabel = new JLabel("Choose the level of your Education", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(titleLabel, BorderLayout.NORTH);
        
        detailsLabel = new JLabel("", JLabel.CENTER);
        detailsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(detailsLabel, BorderLayout.CENTER);
        
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(5,1,5,5));
        radioPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        phdRadio = new JRadioButton("PHD");
        mastersRadio = new JRadioButton("Masters");
        degreeRadio = new JRadioButton("Degree");
        diplomaRadio = new JRadioButton("Diploma");
        certificateRadio = new JRadioButton("Certificate");
        
        educationGroup = new ButtonGroup();
        educationGroup.add(phdRadio);
         educationGroup.add(mastersRadio);
          educationGroup.add(degreeRadio);
           educationGroup.add(diplomaRadio);
            educationGroup.add(certificateRadio);
            
            phdRadio.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    detailsLabel.setText("<html><b>PHD : <br>->Fee per semester is ksh 70000<br>->Duration is 6 semester<br>->Total is ksh 420000</html>");
                }
            });
            
            mastersRadio.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    detailsLabel.setText("<html><b>MASTERS : <br>->Fee per semester is ksh 70000<br>->Duration is 4 semester<br>->Total is ksh 280000</html>");
                }
            });
            
            degreeRadio.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    detailsLabel.setText("<html><b>DEGREE : <br>->Fee per semester is ksh 120000<br>->Duration is 12 semester<br>->Total is ksh 14400000</html>");
                }
            });
            
            diplomaRadio.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    detailsLabel.setText("<html><b>DIPLOMA : <br>->Fee per semester is ksh 50000<br>->Duration is 6 semester<br>->Total is ksh 300000</html>");
                }
            });
            
            certificateRadio.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    detailsLabel.setText("<html><b>CERTIFICATE : <br>->Fee per semester is ksh 40000<br>->Duration is 2 semester<br>->Total is ksh 80000</html>");
                }
            });
            
            radioPanel.add(phdRadio);
        radioPanel.add(mastersRadio);
        radioPanel.add(degreeRadio);
        radioPanel.add(diplomaRadio);
        radioPanel.add(certificateRadio);
        
        add(radioPanel, BorderLayout.WEST);
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
    }
    public static void main(String[]args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Swing().setVisible(true);
            }
        }
        );
    }
}