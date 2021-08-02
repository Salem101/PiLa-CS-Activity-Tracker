import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton; 
import java.awt.*; 
import java.awt.event.*; 

public class javagui1 implements ActionListener{

		//make the fields private
		private static JPanel panel1; 
		private static JPanel panel2; 
		private static JPanel panel3; 
		private static JPanel panel4; 
		private static JPanel panel5; 
		private static JComboBox weeks; 
		private static ButtonGroup group; 
		private static JLabel success; 
	    private static JRadioButton optiont1;
	    private static JRadioButton optiont2;
	    private static JRadioButton optiont3;
	    
	    public static void main(String[]args) {
		
		panel1 = new JPanel(); 
		//panel1.setBackground(Color.red);
		panel1.setBounds(0, 0, 100, 50);
	       JLabel trackLabel = new JLabel("Track #:");
	       trackLabel.setBounds(10, 10, 80, 25);
	       panel1.add(trackLabel);
		
		panel2 = new JPanel(); 
		//panel2.setBackground(Color.blue);
		panel2.setBounds(0, 50, 100, 50);
	       JLabel weekLabel = new JLabel("Week #:");
	       weekLabel.setBounds(10, 10, 80, 25);
	       panel2.add(weekLabel);
		
		panel3 = new JPanel(); 
		//panel3.setBackground(Color.orange);
		panel3.setBounds(100, 0, 250, 50);
			
	     //Let's use radio buttons to select track
	       optiont1 = new JRadioButton("Track 1"); 
	       optiont2 = new JRadioButton("Track 2"); 
	       optiont3 = new JRadioButton("Track 3");
	       optiont1.setSelected(true); 
	       	       
	       //group button so only 1 can be selected at a time
	       group = new ButtonGroup();
	       group.add(optiont1);
	       group.add(optiont2);
	       group.add(optiont3);
	       
	       panel3.add(optiont1);
	       panel3.add(optiont2); 
	       panel3.add(optiont3); 
		
		panel4 = new JPanel(); 
		//panel4.setBackground(Color.yellow);
		panel4.setBounds(100, 50, 250, 50);
		
			//make dropdown for week #
	       String[] weekList = {"select week", "week 1", "week 2", "week 3", "week 4", "week 5", "week 6", "week 7"};
	       weeks = new JComboBox(weekList);
	       weeks.setSelectedIndex(0);
	       panel4.add(weeks); 
		
		panel5 = new JPanel(); 
		//panel5.setBackground(Color.green);
		panel5.setBounds(0, 100, 250, 50);
	       //make 'Start' button to press
	       JButton button = new JButton("Start");
	       panel5.add(button);
	       button.addActionListener(new javagui1());
	       
//	       		button.addActionListener(new ActionListener() {
//	       			public void actionPerformed(ActionEvent e) {
//	       				System.out.println("START 1"); 
//	       			}
//	    		});
	       
	
		JFrame frame = new JFrame(); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setTitle("PiLa-CS Activity Tracker");
		frame.setSize(750, 750);
		frame.setVisible(true);
		frame.add(panel1); 
		frame.add(panel2); 
		frame.add(panel3); 
		frame.add(panel4); 
		frame.add(panel5);	
		  
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("This method is winning "); 
		//now try to get results of track and week and make action happen
		if(optiont1.isSelected()) {
			System.out.println("Track 1 is selected") ;
			
			weeks.getSelectedItem(); 
		}
		
		else if(optiont2.isSelected()){
			System.out.println("Track 2 is selected") ;

		}
		else if(optiont3.isSelected()){
			System.out.println("Track 3 is selected") ;

		}
		
			
	}


}