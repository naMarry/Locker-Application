
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LockerApplication extends JFrame {
    private JLabel titleLabel, passcodeLabel;
    private JTextField passcodeField;
    private JButton enterButton;

    private String password;
    private boolean passwordSet = false;

    public LockerApplication() {
        setTitle("Lock Class");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3, 3));
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        gridPanel.add(button1);
        gridPanel.add(button2);
        gridPanel.add(button3);
        gridPanel.add(button4);
        gridPanel.add(button5);
        gridPanel.add(button6);

        add(gridPanel, BorderLayout.NORTH);

        JPanel inputLayout = new JPanel();
        inputLayout.setLayout(new FlowLayout());

        JButton clearButton = new JButton("Clear");
        JTextField inputPasswordBox = new JTextField(12);
        JButton submitButton = new JButton("Enter");
        JLabel resultStatus = new JLabel();
        inputLayout.add(clearButton);
        inputLayout.add(inputPasswordBox);
        inputLayout.add(submitButton);
        inputLayout.add(resultStatus);

        add(inputLayout, BorderLayout.WEST);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = inputPasswordBox.getText().trim();

                if (!passwordSet) {
                    password = userInput;
                    passwordSet = true;
                    resultStatus.setText("Password Set");
                } else {
                    if (userInput.equals(password)) {
                        resultStatus.setText("Correct Password");
                    } else {
                        resultStatus.setText("Incorrect Password");
                    }
                }

                inputPasswordBox.setText("");
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputPasswordBox.setText("");
                resultStatus.setText("");
            }
        });
    }
}
