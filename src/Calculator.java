//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    Color functionColor = new Color(245, 168, 187);
    Color numberColor = new Color(232,232,232);
    Color panelColor = new Color(209,209,209);

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decimalButton, equalsButton, deleteButton, clearButton, negativeButton;
    JPanel panel;

    Font calculatorFont = new Font("Arial", Font.BOLD, 30);

    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;

    public Calculator() {
        frame = new JFrame("Calculator"); // what is a frame?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null); //what

        textField = new JTextField();
        textField.setBounds(100,25,300,50);
        textField.setFont(calculatorFont);
        textField.setEditable(false);
        frame.add(textField);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        decimalButton = new JButton(".");
        equalsButton = new JButton("=");
        deleteButton = new JButton("Del");
        clearButton = new JButton("Clr");
        negativeButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalsButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = negativeButton;

        for (JButton button: functionButtons) {
            button.addActionListener(this);
            button.setFont(calculatorFont);
            button.setFocusable(false);
            button.setBackground(functionColor);
            button.setOpaque(true);
            button.setBorderPainted(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i)); // convert integer to string
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(calculatorFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setOpaque(true);
            numberButtons[i].setBackground(numberColor);
            numberButtons[i].setBorderPainted(false);


        }

        deleteButton.setBounds(100,430,100,50);
        clearButton.setBounds(200,430,100,50);
        negativeButton.setBounds(300,430, 100, 50);

        panel = new JPanel();
        panel.setBounds(100,100,300,300);
        panel.setLayout(new GridLayout(4,4,5,5));
        panel.setBackground(panelColor);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negativeButton);
        frame.add(deleteButton);
        frame.add(clearButton);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            for(int i = 0; i < 10; i++){
                if(e.getSource() == numberButtons[i]) {
                    textField.setText(textField.getText().concat(String.valueOf(i))); // add the button value to the end of the current string
                }
            }
            if(e.getSource() == decimalButton) {
                textField.setText(textField.getText().concat("."));
            }
            if(e.getSource() == addButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
            }
            if (e.getSource() == subButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
            if(e.getSource() == mulButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }
            if(e.getSource() == divButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }
            if(e.getSource() == equalsButton) {
                num2 = Double.parseDouble(textField.getText());

                switch(operator) {
                    case'+':
                        result = num1 + num2;
                        break;
                    case'-':
                        result = num1 - num2;
                        break;
                    case'*':
                        result = num1 * num2;
                        break;
                    case'/':
                        result = num1 / num2;
                        break;
                }
                textField.setText(String.valueOf(result));
                num1 = result;


            }
            if(e.getSource() == clearButton) {
                textField.setText("");
                num1 = 0;
                num2 = 0;
                result = 0;
            }

            if(e.getSource() == deleteButton) {
                String str = textField.getText();
                str = str.substring(0, str.length() - 1);
                textField.setText(str);
            }

            if(e.getSource() == negativeButton) {
                if(Integer.parseInt(textField.getText()) != 0) {
                    textField.setText('-' + textField.getText());
                }

            }


    }
}
