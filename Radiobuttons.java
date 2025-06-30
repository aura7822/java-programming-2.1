//code for simulating pet selection using radio buttons
/*
NAME : Aura Joshua
ADM :BSE-05-0180/2024
GROUP : 3
DATE : 30th june 2025
 */

/**
 * simple pet selection :
 *
 * This program demonstrates a simple pet selection dialogue  system using object-oriented programming (OOP) principles.
 * It includes radio buttons and png images displayed for each pet selected and the pet description
 *
 * Author: joshua Aura
 * Date: 30th june 2025
 * Language: Java
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Locale;

public class Radiobuttons extends JFrame{
    private JLabel petImageLabel;
    private static final String IMAGE_BASE_PATH = "/home/aurally/Pictures/logos/";
    public Radiobuttons(){
        setTitle("A simple pet selector");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setLayout(new BorderLayout());
        JRadioButton birdButton = new JRadioButton("Bird");
        JRadioButton catButton = new JRadioButton("cat");
        JRadioButton dogButton = new JRadioButton("Dog");
        JRadioButton rabbitButton = new JRadioButton("Rabbit");
        JRadioButton pigButton = new JRadioButton("Pig");

        ButtonGroup petGroup = new ButtonGroup();
        petGroup.add(birdButton);
        petGroup.add(catButton);
        petGroup.add(dogButton);
        petGroup.add(rabbitButton);
        petGroup.add(pigButton);
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(5, 1));
        radioPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);
        petImageLabel = new JLabel("", JLabel.CENTER);
        petImageLabel.setPreferredSize(new Dimension(200, 200));
        petImageLabel.setVerticalTextPosition(JLabel.BOTTOM);
        petImageLabel.setHorizontalTextPosition(JLabel.CENTER);
        ActionListener radioListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton source = (JRadioButton) e.getSource();
                String pet = source.getText().toLowerCase();
                updatePetImage(pet);
                        
            }

            private void updatePetImage(String pet) {
                String imagePath = IMAGE_BASE_PATH + pet + ".png";
                File imageFile = new File(imagePath);
                if (imageFile.exists()) {
                    ImageIcon icon = new ImageIcon(imagePath);

                    Image image = icon.getImage();
                    Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                    petImageLabel.setIcon(new ImageIcon(scaledImage));
                    petImageLabel.setText("You selected: " + pet.substring(0, 1).toUpperCase() + pet.substring(1));
                } else {
                    petImageLabel.setIcon(null);
                    petImageLabel.setText("Image not found for " + pet);
                    System.err.println("Image file not found: " + imagePath);
                }
            }
        };
        birdButton.addActionListener(radioListener);
        catButton.addActionListener(radioListener);
        dogButton.addActionListener(radioListener);
        rabbitButton.addActionListener(radioListener);
        pigButton.addActionListener(radioListener);
        add(radioPanel, BorderLayout.WEST);
        add(petImageLabel, BorderLayout.CENTER);


        }
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                Radiobuttons demo = new Radiobuttons();
                demo.setVisible(true);
            });
    }
}
