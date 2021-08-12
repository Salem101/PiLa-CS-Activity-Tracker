import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter; 

public class PiLaActivityTracker implements ActionListener{

		//make the fields private
		private static JPanel panel1, panel2, panel3, panel4, panel5; 
		private static JComboBox weeks; 
		private static ButtonGroup group; 
	    private static JRadioButton optiont1, optiont2, optiont3, optiont4;
	    private static String week;
	    private static JFrame frame, frame1; 
	    private static Checkbox box1, box2, box3, box4, box5, box6, box7, box8; 
	    private static JLabel label1, label2, label3, label4, errorLabel; 
	    
	    public static void main(String[]args) {
		
		panel1 = new JPanel(); 
		//panel1.setBackground(Color.red);
		panel1.setBounds(0, 5, 100, 50);
	       JLabel trackLabel = new JLabel("Track #:");
	       trackLabel.setBounds(10, 10, 80, 25);
	       panel1.add(trackLabel);
		
		panel2 = new JPanel(); 
		//panel2.setBackground(Color.blue);
		panel2.setBounds(0, 55, 100, 50);
	       JLabel weekLabel = new JLabel("Week #:");
	       weekLabel.setBounds(10, 10, 80, 25);
	       panel2.add(weekLabel);
		
		panel3 = new JPanel(); 
		//panel3.setBackground(Color.orange);
		panel3.setBounds(100, 0, 300, 50);
			
	     //Let's use radio buttons to select track
	       optiont1 = new JRadioButton("Track 1"); 
	       optiont2 = new JRadioButton("Track 2"); 
	       optiont3 = new JRadioButton("Track 3");
	       optiont4 = new JRadioButton("Track 4"); 
	       optiont1.setSelected(true); 
	       	       
	       //group button so only 1 can be selected at a time
	       group = new ButtonGroup();
	       group.add(optiont1);
	       group.add(optiont2);
	       group.add(optiont3);
	       group.add(optiont4);
	       
	       panel3.add(optiont1);
	       panel3.add(optiont2); 
	       panel3.add(optiont3); 
	       panel3.add(optiont4); 
		
		panel4 = new JPanel(); 
		//panel4.setBackground(Color.yellow);
		panel4.setBounds(100, 50, 150, 50);
		
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
	       button.addActionListener(new PiLaActivityTracker());

		frame = new JFrame(); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setTitle("PiLa-CS PLC Activity Tracker");
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.add(panel1); 
		frame.add(panel2); 
		frame.add(panel3); 
		frame.add(panel4); 
		frame.add(panel5);	
		  
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		week = (weeks.getSelectedItem()).toString(); 
		frame1 = new JFrame(); 
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setLayout(null);
		frame1.setTitle("PiLa-CS Activity Tracker ");
		frame1.setVisible(true);
		frame.setVisible(false); 
		
		labela = new JLabel("A file named 'PiLa-CS activity list' has been downloaded. Check your folder. "); 
	    	labela.setBounds(10, 530, 500, 25);
		frame1.add(labela);
		
		if(week == "week 1") {
				frame1.setSize(475, 600);
				label1 = new JLabel("Week 1 - Orientation "); 
			    label1.setBounds(10, 10, 200, 25);
				frame1.add(label1); 
					
				box1 = new Checkbox("Join Slack. "); 
				box1.setBounds(10, 30, 300, 50);
				frame1.add(box1); 
					
				box2 = new Checkbox("Join Flipgrid. "); 
				box2.setBounds(10, 60, 300, 50);
				frame1.add(box2); 
				
				box3 = new Checkbox("Add our folder to Google Drive. "); 
				box3.setBounds(10, 90, 200, 50);
				frame1.add(box3); 
				
				box4 = new Checkbox("Submit the media-release form (storytelling permission). "); 
				box4.setBounds(10, 120, 350, 50);
				frame1.add(box4); 
				
				box5 = new Checkbox("Watch our project videos. "); 
				box5.setBounds(10, 150, 200, 50);
				frame1.add(box5); 
				
				label4 = new JLabel("Activities after Orientation: "); 
			    label4.setBounds(10, 200, 200, 25);
				frame1.add(label4);
				
				box6 = new Checkbox("Reflect on flipgrid. Topic 'week 1' "); 
				box6.setBounds(10, 230, 300, 50);
				frame1.add(box6); 
				
				box7 = new Checkbox("If you consent to research & submit consent form and submit survey. "); 
				box7.setBounds(10, 260, 380, 50);
				frame1.add(box7); 
				
				label2 = new JLabel("Goals for this week: "); 
			    label2.setBounds(10, 310, 200, 25);
				frame1.add(label2);
				
				if(optiont1.isSelected()){
				label3 = new JLabel("<html><ul>" +
				        "<li>To get reacquainted with the purpose of the summer. </li>" +      
				        "<li>Set a tone and community norms. </li>" + 
				        "<li>Share what you hope to learn and can offer. </li>" + 
				        "<li>Co-define equity and explore why this matters. </li>" +             
				        "<li>Become familiar with the processes that we'll use to learn together. </li>" + 
				        "<li>Learn about the formal research consenting process. </li>" + 
				        "</ul><html>");
				label3.setBounds(10, 330, 400, 150);
				label3.setBackground(Color.RED);
				frame1.add(label3); 
				
				}
					
				else if(optiont2.isSelected() || optiont3.isSelected() || optiont4.isSelected()) {
					label3 = new JLabel("<html><ul>" +
					        "<li>To get reacquainted with the purpose of the summer. </li>" +				        "</li>" +             
					        "<li>Set a tone and community norms. </li>" + 
					        "<li>Share what you hope to learn and can offer. /li>" + 
					        "<li>Co-define equity and explore why this matters. </li>" +             
					        "<li>Become familiar with the processes that we'll use to learn together. </li>" + 
					        "<li>Learn about the formal research consenting process. </li>" + 
					        "<li>Begin meeting with and becoming familiar with out design teams. </li>" + 
							"</ul><html>");
					label3.setBounds(10, 330, 400, 150);
					label3.setBackground(Color.RED);
					frame1.add(label3); 
					
				}		
				
			  	
			String text1 = label1.getText(); 
			String check1 = box1.getLabel(); 
			String check2 = box2.getLabel(); 
			String check3 = box3.getLabel(); 
			String check4 = box4.getLabel(); 
			String check5 = box5.getLabel();
			String text4 = label4.getText(); 
			String check7 = box6.getLabel(); 
			String check8 = box7.getLabel(); 
			String text2 = label2.getText();
			String text3 = label3.getText().replaceAll("\\<.*?>","");
			System.out.println("WEEK 1 is working");
			String check6 = ""; 
			exporter1(text1, check1, check2, check3, check4, check5, text4, check6, check7, check8, text2, text3); 
		}

		if(week == "week 2") {
			frame1.setSize(750, 600);
			label1 = new JLabel("Week 2 - Getting to Know Students & Devising a Unit Premise "); 
		    label1.setBounds(10, 10, 500, 25);
			frame1.add(label1); 
			
			box1 = new Checkbox("Reflect on Flipgrid. Topic 'week 2' "); 
			box1.setBounds(10, 30, 500, 50);
			frame1.add(box1); 

			box2 = new Checkbox("Read the themes that came out of our conversation about what we need to thrive this summer and share some community norms. "); 
			box2.setBounds(10, 60, 700, 50);
			frame1.add(box2); 
			
			box3 = new Checkbox("If you haven't done already, but want to consent to research: Turn in the consent form and complete this survey. "); 
			box3.setBounds(10, 90, 650, 50);
			frame1.add(box3); 

			if(optiont1.isSelected()) {
				label2 = new JLabel("Goals for this week: "); 
			    label2.setBounds(10, 170, 500, 25);
				frame1.add(label2);
				
				label3 = new JLabel("<html><ul>" +
				        "<li>Become familiar with our appproach to researching relevant community conversations you might integrate into a CS unit. </li>" +             
				        "<li>Become familiar with our approach to refining your unit design and compiling/creating example projects. </li>" + 
				        "</ul><html>");
				label3.setBounds(10, 200, 500, 100);
				frame1.add(label3); 
				  
				
				String text1 = label1.getText(); 
				String check1 = box1.getLabel(); 
				String check2 = box2.getLabel(); 
				String check3 = box3.getLabel(); 
				String check4 = ""; 
				String check5 = "";
				String check6 = "";
				String text4 = "";
				String check7 = "";
				String check8 = "";
				String text2 = label2.getText();
				String text3 = label3.getText().replaceAll("\\<.*?>","");
				System.out.println("WEEK 2 is working");
				exporter1(text1, check1, check2, check3, check4, check5, text4, check6, check7, check8, text2, text3); 
			
			}
			
			else if(optiont2.isSelected() || optiont3.isSelected() || optiont4.isSelected()) {
				box4 = new Checkbox("Keep us posted via your team's slack channel on the schedule for your team meetings. "); 
				box4.setBounds(10, 120, 500, 50);
				frame1.add(box4); 

				box5 = new Checkbox("Work on Template 1. "); 
				box5.setBounds(10, 150, 200, 50);
				frame1.add(box5); 
				
				box6 = new Checkbox("Work on Template 2. "); 
				box6.setBounds(10, 180, 500, 50);
				frame1.add(box6); 
				
				label2 = new JLabel("Goals for this week: "); 
			    label2.setBounds(10, 245, 300, 25);
				frame1.add(label2);
				
				label3 = new JLabel("<html><ul>" +
				        "<li>Become familiar with our appproach to researching relevant community conversations you might integrate into a CS unit. </li>" +             
				        "<li>Become familiar with our approach to refining your unit design and compiling/creating example projects. </li>" + 
				        "<li>Surface what you know about students to inspire design. </li>" + 
				        "<li>Generate a premise for a unit building on converstions our students take part in. </li>" + 
						"</ul><html>");
				label3.setBounds(10, 220, 600, 250);
				frame1.add(label3); 
				
				
				String text1 = label1.getText(); 
				String check1 = box1.getLabel(); 
				String check2 = box2.getLabel(); 
				String check3 = box3.getLabel(); 
				String check4 = box4.getLabel(); 
				String check5 = box5.getLabel(); 
				String check6 = box6.getLabel(); 
				String text4 = "";
				String check7 = "";
				String check8 = "";
				String text2 = label2.getText();
				String text3 = label3.getText().replaceAll("\\<.*?>","");
				exporter1(text1, check1, check2, check3, check4, check5, text4, check6, check7, check8, text2, text3); 
			
			}

		}
		
		if(week == "week 3") {
			label1 = new JLabel("Week 3 - Researching and Integrating Community Conversations, Refining Unit Premise "); 
		    label1.setBounds(10, 10, 550, 25);
			frame1.add(label1);
			
			box1 = new Checkbox("Reflect on Flipgrid. Topic: 'week 3' "); 
			box1.setBounds(10, 30, 300, 50);
			frame1.add(box1);

			if(optiont1.isSelected()) {
				frame1.setSize(600, 600);

				label2 = new JLabel("Goals for this week: "); 
			    label2.setBounds(10, 80, 200, 25);
				frame1.add(label2);
				
				label3 = new JLabel("<html><ul>" +
				        "<li>Become familiar with our approach to researching relevant community conversations you might integrate into a CS unit. </li>" +             
				        "<li>Become familiar with our approach to refining your unit design and compiling/creating example projects. </li>" + 
				        "</ul><html>");
				label3.setBounds(10, 100, 400, 100);
				frame1.add(label3); 
				  
				
				String text1 = label1.getText(); 
				String check1 = box1.getLabel(); 
				String check2 = ""; 
				String check3 =  ""; 
				String check4 =  ""; 
				String check5 =  ""; 
				String check6 =  ""; 
				String text4 = "";
				String check7 = "";
				String check8 = "";
				String text2 = label2.getText();
				String text3 = label3.getText().replaceAll("\\<.*?>","");
				System.out.println("WEEK 3a is working");
				exporter1(text1, check1, check2, check3, check4, check5, text4, check6, check7, check8, text2, text3); 
			
			}
			
			
			else if(optiont2.isSelected()) {
				frame1.setSize(600, 600);
				
				box2 = new Checkbox("Work on Template 3a and 3b. "); 
				box2.setBounds(10, 60, 500, 50);
				frame1.add(box2); 

				box3 = new Checkbox("Work on Template 4. "); 
				box3.setBounds(10, 90, 550, 50);
				frame1.add(box3); 
				
				label2 = new JLabel("Goals for this week: "); 
			    label2.setBounds(10, 150, 200, 25);
				frame1.add(label2);
				
				label3 = new JLabel("<html><ul>" +
				        "<li>Conduct some research into the topic(s) you hope to integrate into your CS units. </li>" +             
				        "<li>Consider how you might involve people, organizations, or examples from communities that engage with those topics in the real world. " + 
				        "<li>Refine your unit premise considering what you want students to do, make, talk about, etc. </li>" + 
				        "<li>Start compiling / creating example projects. </li>" + 
				        "<li>Generate a premise for a unit building on conversations our students take part in. " + 
				        "</li>" + 
				        "</ul><html>");
				label3.setBounds(10, 175, 500, 200);
				frame1.add(label3); 
				  
				String text1 = label1.getText(); 
				String check1 = box1.getLabel(); 
				String check2 = box2.getLabel(); 
				String check3 = box3.getLabel(); 
				String check4 =  ""; 
				String check5 =  ""; 
				String check6 =  ""; 
				String text4 = "";
				String check7 = "";
				String check8 = "";
				String text2 = label2.getText();
				String text3 = label3.getText().replaceAll("\\<.*?>","");
				System.out.println("WEEK 3b is working");
				exporter1(text1, check1, check2, check3, check4, check5, text4, check6, check7, check8, text2, text3); 
			}
			else if(optiont3.isSelected() || optiont4.isSelected()) {
				frame1.setSize(600, 600);
				
				box2 = new Checkbox("Work on Template 3a and 3b. "); 
				box2.setBounds(10, 60, 500, 50);
				frame1.add(box2); 

				box3 = new Checkbox("Work on Template 4. "); 
				box3.setBounds(10, 90, 550, 50);
				frame1.add(box3); 
				
				box4 = new Checkbox("Provide feedback on the intern's draft of your profile (verbal & comments on template). "); 
				box4.setBounds(10, 120, 550, 50);
				frame1.add(box4); 
				
				label2 = new JLabel("Goals for this week: "); 
			    label2.setBounds(10, 180, 500, 25);
				frame1.add(label2);
				
				label3 = new JLabel("<html><ul>" +
				        "<li>Conduct some research into the topic(s) you hope to integrate into your CS units. </li>" +             
				        "<li>Consider how you might involve people, organizations, or examples from communities that engage with those topics in the real world. " + 
				        "<li>Refine your unit premise considering what you want students to do, make, talk about, etc. </li>" + 
				        "<li>Start compiling / creating example projects. " + 
				        "<li>Generate a premise for a unit building on conversations our students take part in. " + 
				        "</li>" + 
				        "<li>Overview of Track 3. " + 
				        "<li>Understand role/responsiblities of Producer. " + 
				        "</ul><html>");
				label3.setBounds(10, 200, 500, 200);
				frame1.add(label3); 
				  
				String text1 = label1.getText(); 
				String check1 = box1.getLabel(); 
				String check2 = box2.getLabel(); 
				String check3 = box3.getLabel(); 
				String check4 = box4.getLabel();  
				String check5 =  ""; 
				String check6 =  ""; 
				String text4 = "";
				String check7 = "";
				String check8 = "";
				String text2 = label2.getText();
				String text3 = label3.getText().replaceAll("\\<.*?>","");
				System.out.println("WEEK 3b is working");
				exporter1(text1, check1, check2, check3, check4, check5, text4, check6, check7, check8, text2, text3); 
			}
			
		}
		
		if(week == "week 4") {
			
			label1 = new JLabel("Week 4 - Incorporating Goals Through a Translanguaging Lens "); 
		    label1.setBounds(10, 10, 550, 25);
			frame1.add(label1); 
			
			box1 = new Checkbox("Reflect on Flipgrid. Topic: 'week 4' "); 
			box1.setBounds(10, 30, 300, 50);
			frame1.add(box1); 

			if(optiont1.isSelected()) {
				frame1.setSize(500, 600);

				label2 = new JLabel("Goals for this week: "); 
			    label2.setBounds(10, 90, 150, 25);
				frame1.add(label2);
				
				label3 = new JLabel("<html><ul>" +
				        "<li>Learn a translanguaging approach to thinking about planning your unit's goals. </li>" +             
				        "</ul><html>");
				label3.setBounds(10, 100, 400, 100);
				frame1.add(label3); 
				  
				String text1 = label1.getText(); 
				String check1 = box1.getLabel(); 
				String check2 = ""; 
				String check3 =  ""; 
				String check4 =  ""; 
				String check5 =  ""; 
				String check6 =  ""; 
				String text4 = "";
				String check7 = "";
				String check8 = "";
				String text2 = label2.getText();
				String text3 = label3.getText().replaceAll("\\<.*?>","");
				System.out.println("WEEK 4a is working");
				exporter1(text1, check1, check2, check3, check4, check5, text4, check6, check7, check8, text2, text3); 
			}
			
			else if(optiont2.isSelected()) {
				frame1.setSize(500, 600);
				box2 = new Checkbox("Work on Template 5. "); 
				box2.setBounds(10, 60, 300, 50);
				frame1.add(box2); 
				
				label2 = new JLabel("Goals for this week: "); 
			    label2.setBounds(10, 110, 150, 25);
				frame1.add(label2);
				
				label3 = new JLabel("<html><ul>" +
				        "<li>Learn a translanguaging approach to thinking about planning your unit's goals. </li>" +        
				        "<li>Consider the language, content, CS, translanguaging and other goals you have for students at different points in your unit. </li>" +        
				        "<li>Make space for students' emergent goals and language practices in your unit. </li>" +           
				        "</ul><html>");
				label3.setBounds(10, 150, 450, 100);
				frame1.add(label3); 
				  
				String text1 = label1.getText(); 
				String check1 = box1.getLabel(); 
				String check2 = box2.getLabel();  
				String check3 =  ""; 
				String check4 =  ""; 
				String check5 =  ""; 
				String check6 =  ""; 
				String text4 = "";
				String check7 = "";
				String check8 = "";
				String text2 = label2.getText();
				String text3 = label3.getText().replaceAll("\\<.*?>","");
				System.out.println("WEEK 4b is working");
				exporter1(text1, check1, check2, check3, check4, check5, text4, check6, check7, check8, text2, text3); 
			
			}
			
			else if(optiont3.isSelected()) {
				frame1.setSize(550, 600);
				box2 = new Checkbox("Work on Template 5. "); 
				box2.setBounds(10, 60, 500, 50);
				frame1.add(box2); 
				
				box3 = new Checkbox("Consult this Track 3 meeting Agenda Document for the specific tasks. "); 
				box3.setBounds(10, 90, 550, 50);
				frame1.add(box3); 
				
				box4 = new Checkbox("Re-interviewing teachers to fill in any gaps in your story. "); 
				box4.setBounds(10, 120, 500, 50);
				frame1.add(box4); 
				
				box5 = new Checkbox("Incorporate multimedia (pictures, videos, etc) from the teacher. "); 
				box5.setBounds(10, 150, 500, 50);
				frame1.add(box5); 
				
				label2 = new JLabel("Goals for this week: "); 
			    label2.setBounds(10, 200, 150, 50);
				frame1.add(label2);
				
				label3 = new JLabel("<html><ul>" +
						"<li>Learn a translanguaging approach to thinking about planning your unit's goals. </li>" +
				        "<li>Consider the language, content, CS, translanguaging and other goals you have for students at different points in your unit. </li>" +        
				        "<li>Make space for students' emergent goals and language practices in your unit. </li>" +           
				        "<li>Enhance storytelling profiles and documentary. /li>" +           
						"</ul><html>");
				label3.setBounds(10, 250, 500, 100);
				frame1.add(label3); 
				 
				
				String text1 = label1.getText(); 
				String check1 = box1.getLabel(); 
				String check2 = box2.getLabel();  
				String check3 = box3.getLabel(); 
				String check4 = box4.getLabel(); 
				String check5 = box5.getLabel(); 
				String check6 =  ""; 
				String text4 = "";
				String check7 = "";
				String check8 = "";
				String text2 = label2.getText();
				String text3 = label3.getText().replaceAll("\\<.*?>","");
				System.out.println("WEEK 4c is working");
				exporter1(text1, check1, check2, check3, check4, check5, text4, check6, check7, check8, text2, text3); 
			}
			
			else if(optiont4.isSelected()) {
				frame1.setSize(500, 600);
				box2 = new Checkbox("Work on Template 5."); 
				box2.setBounds(10, 60, 500, 50);
				frame1.add(box2); 
				
				box3 = new Checkbox("Consult this Track 3 meeting Agenda Document for the specific tasks. "); 
				box3.setBounds(10, 90, 550, 50);
				frame1.add(box3); 
				
				box4 = new Checkbox("Re-interviewing teachers to fill in any gaps in your story. "); 
				box4.setBounds(10, 120, 500, 50);
				frame1.add(box4); 
				
				box5 = new Checkbox("Incorporate multimedia (pictures, videos, etc) from the teacher. "); 
				box5.setBounds(10, 150, 500, 50);
				frame1.add(box5); 
				
				box6 = new Checkbox("Fill out the google form to schedule time to meet with the Track 4 team. "); 
				box6.setBounds(10, 180, 500, 50);
				frame1.add(box6); 
				
				label2 = new JLabel("Goals for this week: "); 
			    label2.setBounds(10, 250, 150, 25);
				frame1.add(label2);
				
				label3 = new JLabel("<html><ul>" +
						"<li>Learn a translanguaging approach to thinking about planning your unit's goals. </li>" +
				        "<li>Consider the language, content, CS, translanguaging and other goals you have for students at different points in your unit. </li>" +        
				        "<li>Make space for students' emergent goals and language practices in your unit. </li>" +           
				        "<li>Enhance storytelling profiles and documentary. </li>" +   
				        "<li>Begin connecting with the showcase team to plan the end-of-summer showcase. </li>" +  
						"</ul><html>");
				label3.setBounds(10, 270, 400, 200);
				frame1.add(label3); 
				  
				String text1 = label1.getText(); 
				String check1 = box1.getLabel(); 
				String check2 = box2.getLabel();  
				String check3 = box3.getLabel(); 
				String check4 = box4.getLabel(); 
				String check5 = box5.getLabel(); 
				String check6 = box6.getLabel();  
				String text4 = "";
				String check7 = "";
				String check8 = "";
				String text2 = label2.getText();
				String text3 = label3.getText().replaceAll("\\<.*?>","");
				System.out.println("WEEK 4d is working");
				exporter1(text1, check1, check2, check3, check4, check5, text4, check6, check7, check8, text2, text3); 
			}
		}
		
		if(week == "week 5") {
			label1 = new JLabel("Week 5 - Creating Holistic Assessments "); 
		    label1.setBounds(10, 10, 550, 25);
			frame1.add(label1); 
			
			box1 = new Checkbox("Reflect on Flipgrid. Topic: 'week 5' "); 
			box1.setBounds(10, 30, 300, 50);
			frame1.add(box1); 

			if(optiont1.isSelected()) {
				frame1.setSize(500, 600);

				label2 = new JLabel("Goals for this week: "); 
			    label2.setBounds(10, 80, 200, 25);
				frame1.add(label2);
				
				label3 = new JLabel("<html><ul>" +
				        "<li>Become familiar with guiding questions for creating holistic assessments for your multilingual learners. </li>" +             
				        "<li>Beome familiar with a set of translanguaging strategies you might incorporate into lessons, and how to make decisions about which to use and when. </li>" + 
				        "</ul><html>");
				label3.setBounds(10, 100, 400, 100);
				frame1.add(label3); 
				  
				String text1 = label1.getText(); 
				String check1 = box1.getLabel(); 
				String check2 = ""; 
				String check3 = ""; 
				String check4 = ""; 
				String check5 = ""; 
				String check6 = ""; 
				String text4 = "";
				String check7 = "";
				String check8 = "";
				String text2 = label2.getText();
				String text3 = label3.getText().replaceAll("\\<.*?>","");
				System.out.println("WEEK 5a is working");
				exporter1(text1, check1, check2, check3, check4, check5, text4, check6, check7, check8, text2, text3); 
			}
			else if(optiont2.isSelected()) {
				frame1.setSize(550, 600);
				box2 = new Checkbox("Work on template 6. "); 
				box2.setBounds(10, 60, 300, 50);
				frame1.add(box2);
				
				box3 = new Checkbox("Work on template 7. "); 
				box3.setBounds(10, 90, 300, 50);
				frame1.add(box3); 
				
				label2 = new JLabel("Goals for this week: "); 
			    label2.setBounds(10, 140, 200, 25);
				frame1.add(label2);
				
				label3 = new JLabel("<html><ul>" +
				        "<li>Become familiar with guiding questions for creating holistic assessments for your multilingual learners. </li>" +             
				        "<li>Become familiar with a set of translanguaging strategies you might incorporate into lessons, and how to make decisions about which to use and when. </li>" + 
				        "<li>Consider how you will know when your students are participating successfully. </li>" + 
				        "<li>Plan backwards from your goals. </li>" + 
				        "<li>Consider the translanguaging strategies you might employ in your day to day lessons. </li>" + 
						"</ul><html>");
				label3.setBounds(10, 170, 400, 200);
				frame1.add(label3);
				 
				String text1 = label1.getText(); 
				String check1 = box1.getLabel(); 
				String check2 = box2.getLabel(); 
				String check3 = box3.getLabel(); 
				String check4 = ""; 
				String check5 = ""; 
				String check6 = ""; 
				String text4 = "";
				String check7 = "";
				String check8 = "";
				String text2 = label2.getText();
				String text3 = label3.getText().replaceAll("\\<.*?>","");
				System.out.println("WEEK 5b is working");
				exporter1(text1, check1, check2, check3, check4, check5, text4, check6, check7, check8, text2, text3); 
			}
					
			else if(optiont3.isSelected() || optiont4.isSelected()) {
				frame1.setSize(575, 600);
				box2 = new Checkbox("Work on template 6. "); 
				box2.setBounds(10, 60, 500, 50);
				frame1.add(box2);
				
				box3 = new Checkbox("Work on template 7. "); 
				box3.setBounds(10, 90, 500, 50);
				frame1.add(box3); 
				
				box4 = new Checkbox("Provide support and feedback on the incorportation of the flipgrid. "); 
				box4.setBounds(10, 120, 500, 50);
				frame1.add(box4);
				
				box5 = new Checkbox("Preparing for the showcase. "); 
				box5.setBounds(10, 150, 500, 50);
				frame1.add(box5); 
				
				label2 = new JLabel("Goals for this week: "); 
			    label2.setBounds(10, 200, 200, 25);
				frame1.add(label2);
				
				label3 = new JLabel("<html><ul>" +
				        "<li>Become familiar with guiding questions for creating holistic assessments for your multilingual learners. </li>" +             
				        "<li>Become familiar with a set of translanguaging strategies you might incorporate into lessons, and how to make decisions about which to use and when. </li>" + 
				        "<li>Consider how you will know when your students are participating successfully. </li>" + 
				        "<li>Plan backwards from your goals. </li>" + 
				        "<li>Consider the translanguaging strategies you might employ in your day to day lessons. </li>" + 
				        "<li>Continue finalizing your story by incorporating the flipgrid material and preparing for the showcase. </li>" + 
				        "<li>Get last feedback from your teacher. </li>" + 
				        "<li>Present a snippet of your story at our end of summer showcase. </li>" + 						
						"</ul><html>");
				label3.setBounds(10, 250, 500, 225);
				frame1.add(label3); 
				  
				String text1 = label1.getText(); 
				String check1 = box1.getLabel(); 
				String check2 = box2.getLabel(); 
				String check3 = box3.getLabel(); 
				String check4 = box4.getLabel(); 
				String check5 = box5.getLabel(); 
				String check6 = ""; 
				String text4 = "";
				String check7 = "";
				String check8 = "";
				String text2 = label2.getText();
				String text3 = label3.getText().replaceAll("\\<.*?>","");
				System.out.println("WEEK 5cd is working");
				exporter1(text1, check1, check2, check3, check4, check5, text4, check6, check7, check8, text2, text3); 
			}
			
		}
		
		if(week == "week 6") {
			label1 = new JLabel("Week 6 - Design Reviews and Feedback "); 
		    label1.setBounds(10, 10, 550, 25);
			frame1.add(label1); 
			
			box1 = new Checkbox("Reflect on Flipgrid. Topic: 'week 6' "); 
			box1.setBounds(10, 30, 300, 50);
			frame1.add(box1); 
			
			if(optiont1.isSelected()) {
				frame1.setSize(575, 600);
				label2 = new JLabel("Goals for this week: "); 
			    label2.setBounds(10, 90, 500, 25);
				frame1.add(label2);
				
				label3 = new JLabel("<html><ul>" +
				        "<li>Provide feedback to other teachers during a design review. </li>" + 
						"</ul><html>");
				label3.setBounds(10, 105, 400, 75);
				frame1.add(label3); 
				  
				String text1 = label1.getText(); 
				String check1 = box1.getLabel(); 
				String check2 = ""; 
				String check3 = ""; 
				String check4 = ""; 
				String check5 = ""; 
				String check6 = ""; 
				String text4 = "";
				String check7 = "";
				String check8 = "";
				String text2 = label2.getText();
				String text3 = label3.getText().replaceAll("\\<.*?>","");
				System.out.println("WEEK 6a is working");
				exporter1(text1, check1, check2, check3, check4, check5, text4, check6, check7, check8, text2, text3); 
			}
			
			else if(optiont2.isSelected()) {
				frame1.setSize(575, 600);
				
				box2 = new Checkbox("Work on Template 8. "); 
				box2.setBounds(10, 60, 300, 50);
				frame1.add(box2); 
				
				label2 = new JLabel("Goals for this week: "); 
			    label2.setBounds(10, 110, 500, 25);
				frame1.add(label2);
				
				label3 = new JLabel("<html><ul>" +
				        "<li>Give and receive feedback to other teachers during a design review. </li>" + 
				        "<li>Make any revisions to your unit and/or presentation and share it at the showcase! </li>" + 
						"</ul><html>");
				label3.setBounds(10, 140, 500, 75);
				frame1.add(label3); 
				  
				
				String text1 = label1.getText(); 
				String check1 = box1.getLabel(); 
				String check2 = box2.getLabel(); 
				String check3 = ""; 
				String check4 = ""; 
				String check5 = ""; 
				String check6 = ""; 
				String text4 = "";
				String check7 = "";
				String check8 = "";
				String text2 = label2.getText();
				String text3 = label3.getText().replaceAll("\\<.*?>","");
				System.out.println("WEEK 5cd is working");
				exporter1(text1, check1, check2, check3, check4, check5, text4, check6, check7, check8, text2, text3); 
			}
			
			else if(optiont3.isSelected() || optiont4.isSelected()) {
				frame1.setSize(575, 600);
				
				box2 = new Checkbox("Work on Template 8. "); 
				box2.setBounds(10, 60, 300, 50);
				frame1.add(box2); 
				
				box3 = new Checkbox("Provide final feedback on profiles and summer showcase. "); 
				box3.setBounds(10, 90, 300, 50);
				frame1.add(box3); 
				
				box4 = new Checkbox("Support interns with run through of presentation. "); 
				box4.setBounds(10, 120, 300, 50);
				frame1.add(box4); 
				
				label2 = new JLabel("Goals for this week: "); 
			    label2.setBounds(10, 170, 400, 25);
				frame1.add(label2);
				
				label3 = new JLabel("<html><ul>" +
				        "<li>Give and receive feedback to other teachers during a design review. </li>" + 
				        "<li>Make any revisions to your unit and/or presentation and share it at the showcase! </li>" + 
				        "<li>Finalize showcase & profiles. </li>" + 
						"</ul><html>");
				label3.setBounds(10, 190, 500, 100);
				frame1.add(label3); 
				  
				
				String text1 = label1.getText(); 
				String check1 = box1.getLabel(); 
				String check2 = box2.getLabel(); 
				String check3 = box3.getLabel();  
				String check4 = box4.getLabel(); 
				String check5 = ""; 
				String check6 = ""; 
				String text4 = "";
				String check7 = "";
				String check8 = "";
				String text2 = label2.getText();
				String text3 = label3.getText().replaceAll("\\<.*?>","");
				System.out.println("WEEK 5cd is working");
				exporter1(text1, check1, check2, check3, check4, check5, text4, check6, check7, check8, text2, text3); 
			}
			
		}
		
		if(week == "week 7") {
			label1 = new JLabel("Week 7 - Reflection "); 
		    label1.setBounds(10, 10, 550, 25);
			frame1.add(label1); 
			
			box1 = new Checkbox("Reflect on Flipgrid. Topic: 'week 7' "); 
			box1.setBounds(10, 30, 300, 50);
			frame1.add(box1); 
			
			if(optiont1.isSelected()) {
				
				
				frame1.setSize(500, 600);
				label2 = new JLabel("Goals for this week: "); 
			    label2.setBounds(10, 90, 500, 25);
				frame1.add(label2);
				
				label3 = new JLabel("<html><ul>" +
				        "<li>Reflect on core learnings and take-aways. </li>" + 
				        "<li>Devise next steps. </li>" +  
						"</ul><html>");
				label3.setBounds(10, 105, 400, 75);
				frame1.add(label3); 
				  
				String text1 = label1.getText(); 
				String check1 = box1.getLabel(); 
				String check2 = "";
				String check3 = "";  
				String check4 = ""; 
				String check5 = ""; 
				String check6 = ""; 
				String text4 = "";
				String check7 = "";
				String check8 = "";
				String text2 = label2.getText();
				String text3 = label3.getText().replaceAll("\\<.*?>","");
				System.out.println("WEEK 5cd is working");
				exporter1(text1, check1, check2, check3, check4, check5, text4, check6, check7, check8, text2, text3); 
			
			}
			
			else if(optiont2.isSelected()) {
				frame1.setSize(500, 600);
				
				box2 = new Checkbox("Work on Template 8. "); 
				box2.setBounds(10, 60, 300, 50);
				frame1.add(box2); 
				
				label2 = new JLabel("Goals for this week: "); 
			    label2.setBounds(10, 110, 500, 25);
				frame1.add(label2);
				
				label3 = new JLabel("<html><ul>" +
				        "<li>Reflect on core learnings and take-aways. </li>" + 
				        "<li>Devise next steps. </li>" + 
						"</ul><html>");
				label3.setBounds(10, 120, 400, 75);
				frame1.add(label3); 
				  
				String text1 = label1.getText(); 
				String check1 = box1.getLabel(); 
				String check2 = box2.getLabel(); 
				String check3 = "";  
				String check4 = ""; 
				String check5 = ""; 
				String check6 = ""; 
				String text4 = "";
				String check7 = "";
				String check8 = "";
				String text2 = label2.getText();
				String text3 = label3.getText().replaceAll("\\<.*?>","");
				System.out.println("WEEK 5cd is working");
				exporter1(text1, check1, check2, check3, check4, check5, text4, check6, check7, check8, text2, text3); 
			
			}
			
			else if(optiont3.isSelected() || optiont4.isSelected()) {
				frame1.setSize(500, 600);

				box2 = new Checkbox("Reflective exercise & feedback for PiLa-CS. "); 
				box2.setBounds(10, 60, 300, 50);
				frame1.add(box2); 
				
				box3 = new Checkbox("Fall 2021 opportunities. "); 
				box3.setBounds(10, 90, 300, 50);
				frame1.add(box3); 
				
				label2 = new JLabel("Goals for this week: "); 
			    label2.setBounds(10, 150, 500, 25);
				frame1.add(label2);
				
				label3 = new JLabel("<html><ul>" +
				        "<li>Finalize showcase & profiles. </li>" + 
						"</ul><html>");
				label3.setBounds(10, 170, 400, 75);
				frame1.add(label3); 
				
				String text1 = label1.getText(); 
				String check1 = box1.getLabel(); 
				String check2 = box2.getLabel(); 
				String check3 = box3.getLabel();   
				String check4 = ""; 
				String check5 = ""; 
				String check6 = ""; 
				String text4 = "";
				String check7 = "";
				String check8 = "";
				String text2 = label2.getText();
				String text3 = label3.getText().replaceAll("\\<.*?>","");
				System.out.println("WEEK 5cd is working");
				exporter1(text1, check1, check2, check3, check4, check5, text4, check6, check7, check8, text2, text3); 
			
			}
			
		}
		
		if(week == "select week"){
			frame1.setSize(400, 200);
			JPanel panelA = new JPanel(); 
			panelA.setBounds(10, 5, 300, 300);
			errorLabel = new JLabel("Error: Please select a week to view the planner. "); 
			panelA.add(errorLabel); 
			frame1.add(panelA); 
			JPanel panelB = new JPanel(); 
			panelB.setBounds(10, 45, 300, 50);
			JButton okButton = new JButton("OK"); 
			panelB.add(okButton); 
			frame1.add(panelB); 
			
			okButton.addActionListener(
			  new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	//if user presses ok. Window closes 
			    	//and menu window will open for them to select week 
			      frame1.setVisible(false);
			      frame.setVisible(true);
			    }
			  }
			);
		    }
		closeWindow(); 
	}
	
	
    public void closeWindow() {
		///TRY NEW BUTTON FOR FILE DOWNLOAD 
		JPanel panelC = new JPanel(); 
		panelC.setBounds(10, 500, 200, 100);
		JButton saveButton = new JButton("Close window"); 
		panelC.add(saveButton); 
		frame1.add(panelC); 
		
		saveButton.addActionListener(
		  new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		      frame1.setVisible(false);
		    }
		  }
		);
    }
    public void exporter1(String text1, String check1, String check2, String check3, String check4, String check5, String text4, String check6, String check7, String check8, String text2, String text3) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("PiLa-CS activity list ");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		writer.println(text1); 
		writer.print("\n []" + check1);
		if(check2 != "") {
		writer.print("\n []" + check2); }
		if(check3 != "") {
		writer.print("\n []" + check3); }
		if(check4 != "") {
		writer.print("\n []" + check4);} 
		if(check5 != "") {
		writer.print("\n []" + check5); }
		if(check6 != "") {
		writer.print("\n []" + check6 + "\n");}
			if(text4 != "") {
			writer.println("\n\n" + text4); 
			writer.println("\n []" + check7 + "\n []" +check8 + "\n"); 
			}
		writer.println("\n\n" + text2); 
		writer.println("\n" + text3);
		writer.close();
    }
}
