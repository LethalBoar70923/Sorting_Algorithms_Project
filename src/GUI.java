import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class GUI {

    final String[] comboArr = new String[]{"Selection Sort", "Bubble Sort", "Insertion Sort", "Quick Sort", "Heap Sort", "Shell Sort"};
    JButton sortButton = new JButton();
    JButton randNumButton = new JButton();
    JPanel panel = new JPanel();
    JComboBox sortingSelector = new JComboBox(comboArr);
    JTextField textField = new JTextField();
    JTextField maxRand = new JTextField();
    JTextField minRand = new JTextField();
    JTextField mutationCounter = new JTextField();
    JTextField comparisonCounter = new JTextField();
    int x;
    int y;
    int[] unsortedInput;
    Sort sort = new Sort();

    GUI() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFrame frame = new JFrame("Sorting Method Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        sortButton.setBounds(375, 433, 100, 20);
        randNumButton.setBounds(375, 400, 100, 20);
        sortingSelector.setBounds(225, 433, 130, 20);
        textField.setBounds(10, 433, 200, 20);
        maxRand.setBounds(305, 400, 50, 20);
        minRand.setBounds(250, 400, 50, 20);
        mutationCounter.setBounds(0, 350, 250, 20);
        comparisonCounter.setBounds(250, 350, 250, 20);
        mutationCounter.setEditable(false);
        comparisonCounter.setEditable(false);
        textField.setToolTipText("Add an unsorted list of integers separated by a comma");
        sortButton.setText("Sort");
        randNumButton.setText("Rand Num");
        maxRand.setToolTipText("Enter the maximum value the random number generator can go to");
        minRand.setToolTipText(("Enter the minimum value the random number generator can go to"));
        randNumButton.setToolTipText("Generate a random set of integers to sort");
        sortingSelector.setToolTipText("Select a sorting algorithm");
        mutationCounter.setToolTipText("The amount of times the sorting algorithm swapped numbers");
        comparisonCounter.setToolTipText("The amount of comparisons the sorting algorithm has done");
        panel.add(randNumButton);
        panel.add(sortButton);
        panel.add(maxRand);
        panel.add(minRand);
        panel.add(sortingSelector);
        panel.add(textField);
        panel.add(mutationCounter);
        panel.add(comparisonCounter);
        panel.setLayout(null);

        frame.setContentPane(panel);
        sortingSelector.setVisible(true);
        maxRand.setVisible(true);
        minRand.setVisible(true);
        sortButton.setVisible(true);
        randNumButton.setVisible(true);
        comparisonCounter.setVisible(true);
        mutationCounter.setVisible(true);
        frame.setVisible(true);


        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unsortedInput = Arrays.stream(textField.getText().split(",")).mapToInt(Integer::parseInt).toArray();
                int y = sortingSelector.getSelectedIndex();
                sort.comparison = 0;
                sort.mutation = 0;

                switch (y) {

                    case 0:

                        System.out.println("Selection Sort");
                        sort.SelectionSort(unsortedInput);
                        sort.printArray(unsortedInput);
                        mutationCounter.setText(String.valueOf((sort.mutation)));
                        comparisonCounter.setText(String.valueOf(sort.comparison));

                        break;

                    case 1:

                        System.out.println("Bubble Sort");

                        sort.BubbleSort(unsortedInput);
                        sort.printArray(unsortedInput);
                        mutationCounter.setText(String.valueOf((sort.mutation)));
                        comparisonCounter.setText(String.valueOf(sort.comparison));

                        break;

                    case 2:
                        System.out.println("Insertion Sort");
                        sort.InsertionSort(unsortedInput);
                        sort.printArray(unsortedInput);
                        mutationCounter.setText(String.valueOf((sort.mutation)));
                        comparisonCounter.setText(String.valueOf(sort.comparison));
                        break;

                    case 3:

                        System.out.println("Quick Sort");
                        sort.partition(unsortedInput, 0, unsortedInput.length - 1);
                        sort.QuickSort(unsortedInput, 0, unsortedInput.length - 1);
                        sort.printArray(unsortedInput);
                        mutationCounter.setText(String.valueOf((sort.mutation)));
                        comparisonCounter.setText(String.valueOf(sort.comparison));
                        break;
                    case 4:

                        System.out.println("Heap Sort");
                        sort.heapSort(unsortedInput, unsortedInput.length);
                        sort.printArray(unsortedInput);
                        mutationCounter.setText(String.valueOf((sort.mutation)));
                        comparisonCounter.setText(String.valueOf(sort.comparison));
                    case 5:
                        System.out.println("Shell Sort");
                        sort.ShellSort(unsortedInput);
                        sort.printArray(unsortedInput);

                }

            }
        });


        randNumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                x = Integer.parseInt(maxRand.getText());
                y = Integer.parseInt(minRand.getText());
                unsortedInput = new int[x];

                for (int i = 0; i < unsortedInput.length; i++) {

                    unsortedInput[i] = new Random().nextInt(x - y) + y;
                    System.out.print(unsortedInput[i] + ",");
                }
                textField.setText(Arrays.toString(unsortedInput).replaceAll("\\[", "").replaceAll("]", "").replaceAll(" ", ""));

            }

        });

    }

}