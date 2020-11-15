import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class GUI {

    final String[] comboArr = new String[]{"Selection Sort", "Bubble Sort", "Insertion Sort", "Quick Sort"};
    JButton sortButton = new JButton();
    JButton randNumButton = new JButton();
    JPanel panel = new JPanel();
    JComboBox sortingSelector = new JComboBox(comboArr);
    JTextField textField = new JTextField();
    JTextField maxRand = new JTextField();
    int x;
    int[] unsortedInput;
    Sort sort = new Sort();
    GUI() {

        JFrame frame = new JFrame("Sorting Method Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        sortButton.setBounds(375, 433, 100, 20);
        randNumButton.setBounds(375, 400, 100, 20);
        sortingSelector.setBounds(225, 433, 130, 20);
        textField.setBounds(10, 433, 200, 20);
        maxRand.setBounds(325, 400, 50, 20);
        textField.setToolTipText("Add an unsorted list of integers separated by a comma");
        sortButton.setText("Sort");
        randNumButton.setText("Rand Num");
        maxRand.setToolTipText("Enter the maximum value the random number generator can go to");
        randNumButton.setToolTipText("Generate a random set of integers to sort");
        panel.add(randNumButton);
        panel.add(sortButton);
        panel.add(maxRand);
        panel.add(sortingSelector);
        panel.add(textField);
        panel.setLayout(null);

        frame.setContentPane(panel);
        sortingSelector.setVisible(true);
        maxRand.setVisible(true);
        sortButton.setVisible(true);
        randNumButton.setVisible(true);
        frame.setVisible(true);


        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int x = sortingSelector.getSelectedIndex();


                switch (x) {

                    case 0:
                        System.out.println("Selection Sort");
                        sort.SelectionSort(unsortedInput);

                        sort.printArray(unsortedInput);



                        break;

                    case 1:

                        System.out.println("Bubble Sort");

                        sort.BubbleSort(unsortedInput);


                        break;

                    case 2:

                        System.out.println("Insertion Sort");
                        sort.InsertionSort(unsortedInput);
                        break;

                    case 3:

                        System.out.println("Quick Sort");
                }


            }
        });


        randNumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = Integer.parseInt(maxRand.getText());
                unsortedInput = new int[x];

                for (int i = 0; i < unsortedInput.length; i++) {

                    unsortedInput[i] = new Random().nextInt(x) + 1;
                    System.out.println(unsortedInput[i]);
                }
                textField.setText(Arrays.toString(unsortedInput).replaceAll("\\[", "").replaceAll("]", ""));

            }


        });

    }

}