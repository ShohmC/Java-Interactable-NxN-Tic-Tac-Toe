import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LaunchWindow implements ActionListener{
	int dimensions;
	JFrame frame = new JFrame();
	JTextField textField = new JTextField();
	JLabel label = new JLabel("Pick a specific dimension you want to play with");
	JLabel label2 = new JLabel("Please pick an integer between 1 - 30");
	JLabel label3 = new JLabel("Cannot pick a number less than 1");
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JButton button;

	
	LaunchWindow() {
		
		label.setFont(new Font("MV Boli",Font.BOLD,22));
		label2.setFont(new Font("MV Boli",Font.BOLD,22));

		
		panel.setBounds(0,0,600,50);
		panel.setBackground(Color.red);
		panel.add(label);
		
		panel2.setBounds(0,312,600,50);
		panel2.setBackground(Color.red);
		panel2.add(label2);
		
		button = new JButton();
		button.setBounds(75, 50, 200, 100);
		button.addActionListener(this); 
		button.setBackground(Color.black); 
		button.setText("Press Me");
		button.setFocusable(false);
		button.setForeground(Color.red);
		
	
		textField.setBounds(275,50,250,100); 
		textField.setFont(new Font("MV Boli", Font.ITALIC, 30)); 
		textField.setForeground(Color.green); 
		textField.setBackground(Color.black); 
		textField.setCaretColor(Color.blue); 
		textField.setEnabled(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(600,400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		frame.add(button);
		frame.add(textField);


	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			int enteredDimension = getInput();
			if(enteredDimension != -1 && enteredDimension != 0) {
				dimensions = enteredDimension;
				frame.dispose();
				new TicTacToe(dimensions);
			}
			else {
				frame.add(panel2);
				frame.revalidate();
				frame.repaint();
			}
				
		}
	
	}
	
	public int getInput() {
		while(true) {
			try {
				String text = textField.getText();
				return Integer.parseInt(text);
			}catch(NumberFormatException ex) {
				return -1;
			}
		}		
	}
}

