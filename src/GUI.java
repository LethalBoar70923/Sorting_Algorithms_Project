import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GUI {

    final String[] comboArr = new String[]{"Selection Sort", "Bubble Sort", "Insertion Sort", "Quick Sort"};
    JButton sortButton = new JButton();
    JButton randNumButton = new JButton();
    JPanel panel = new JPanel();
    JComboBox sortingSelector = new JComboBox(comboArr);
    JTextField textField = new JTextField();
    String[] unsortedInput;

    GUI() {

        JFrame frame = new JFrame("Sorting Method Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        sortButton.setBounds(375, 433, 100, 20);
        randNumButton.setBounds(375, 400, 100, 20);
        sortingSelector.setBounds(225, 433, 130, 20);
        textField.setBounds(10, 433, 200, 20);
        textField.setToolTipText("Add an unsorted list of integers separated by a comma");
        sortButton.setText("Sort");
        randNumButton.setText("Rand Num");
        randNumButton.setToolTipText("Generate a random set of integers to sort");
        panel.add(randNumButton);
        panel.add(sortButton);
        panel.add(sortingSelector);
        panel.add(textField);
        panel.setLayout(null);

        frame.setContentPane(panel);
        sortingSelector.setVisible(true);
        sortButton.setVisible(true);
        randNumButton.setVisible(true);
        frame.setVisible(true);


        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int x = sortingSelector.getSelectedIndex();

                switch (x) {

                    case 0:
                        unsortedInput = textField.getText().split(",");

                        for (int i = 0; i < unsortedInput.length; i++) {
                            System.out.println(unsortedInput[i]);
                        }

                        break;

                    case 1:
                        unsortedInput = textField.getText().split(",");
                        System.out.println("Bubble Sort");

                        break;

                    case 2:
                        unsortedInput = textField.getText().split(",");
                        System.out.println("Insertion Sort");

                        break;

                    case 3:
                        unsortedInput = textField.getText().split(",");
                        System.out.println("Quick Sort");

                }


            }
        });


        randNumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int randnum = new Random().nextInt(11) + 1;

                textField.setText(String.valueOf(randnum));


            }


        });

    }

}