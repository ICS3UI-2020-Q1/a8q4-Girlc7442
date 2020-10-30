import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel nLabel;
  JLabel factorialLabel;

  JTextField inputNumber;
  JTextField factorialNumber;

  JButton calculateBtn;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    //initialize the main JPanel
    mainPanel = new JPanel();
    //disable layout helpers
    mainPanel.setLayout(null);

    //initialize the labels
    nLabel = new JLabel("n");
    factorialLabel = new JLabel("factorial(n)");

    //set location and bounds
    nLabel.setBounds(50,25,25,25);
    factorialLabel.setBounds(190,25,100,25);

    //initialize the text fields
    inputNumber = new JTextField();
    factorialNumber = new JTextField();

    //set location and bounds
    inputNumber.setBounds(95,25,75,25);
    factorialNumber.setBounds(310,25,150,25);

    //initialize the button
    calculateBtn = new JButton("CALC");

    //add an action listener to the button
    calculateBtn.addActionListener(this);

    //set the action command on the buttons
    calculateBtn.setActionCommand("Calc");

    //set location and bounds
    calculateBtn.setBounds(480,25,75,25);

    //add the button to the mainPanel
    mainPanel.add(calculateBtn);

    //add the text fields to the mainPanel
    mainPanel.add(inputNumber);
    mainPanel.add(factorialNumber);

    //add the labels to the mainPanel
    mainPanel.add(nLabel);
    mainPanel.add(factorialLabel);

    //add the mainPanel to the frame
    frame.add(mainPanel);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if(command.equals("Calc")){
      //get the text from the inputNumber text box
      String firstText = inputNumber.getText();
      
      //change the string into an integer
      int n = Integer.parseInt(firstText);

      //initialize the accumulator
      int accumulator = 1;

      for(int i = 1; i <= n; i++){
        //multiplies the accumulator with i until it reaches n
        accumulator = accumulator * i; 
     }

      //display the number factorialed
      factorialNumber.setText("" + accumulator);
    }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
