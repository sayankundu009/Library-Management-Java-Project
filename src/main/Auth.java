package main;
import java.sql.*;  
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Auth {

	public static void main(String[] args) {  
		
		@SuppressWarnings("unused")
		loginform l = new loginform();	 
		
		
	}  
		
} 

//======================================================
//Login Form======================================================
//======================================================

class loginform extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public loginform() {
		
		
		
		 
		
		
		 setSize(900,600); 
		 setResizable(false);
	
		 setTitle("Login");
		
		//Left Side Bar
		JPanel LeftSideBar = new JPanel(); 
		LeftSideBar.setBounds(0,0,400,500);    
		LeftSideBar.setBackground(new Color(237,237,237));
		LeftSideBar.setLayout(null);
		
		//..Heading Text
		    JLabel leftHeading; 
		    ImageIcon topimg = new ImageIcon(new ImageIcon("D:\\Joy\\Java Projects\\img\\books5.jpg").getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT));
		    leftHeading = new JLabel("");  
		    leftHeading.setIcon(topimg);
		    leftHeading.setBounds(0,120, 400,200);  

		    
		    JLabel welcome = new JLabel("Welcome to our library"); 
		    welcome.setFont(new Font("Calibri", Font.PLAIN, 26));
		    welcome.setBounds(70,300, 300,100); 
		    welcome.setForeground(Color.black);
		    welcome.setBackground(Color.black);
		    
		    
		    LeftSideBar.add(leftHeading);
		    LeftSideBar.add(welcome);
		 
		 
		
		//..Add Bar To LoginPage
		 	 add(LeftSideBar);  
		
	    //=============================================
		
		//Right Side Bar
			JPanel RightSideBar = new JPanel(); 
			RightSideBar.setBounds(400,0,500,600);    
			RightSideBar.setBackground(Color.white);
			RightSideBar.setLayout(null);
			
			//..Heading Text
			    JLabel rightHeading; 
			    rightHeading = new JLabel("Sign in");  
			    rightHeading.setBounds(185,50, 500,100); 
			    rightHeading.setFont(new Font("Calibri", Font.PLAIN, 38));
			    
			    RightSideBar.add(rightHeading);
			    
			//..Form
			    JTextField email,password,emptyfield;
			    email = new JTextField("Email ");  
			    email.setBounds(95,170,300,50); 
			    
			    email.setBorder(BorderFactory.createCompoundBorder(
			    		email.getBorder(), 
			            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
			    password = new JPasswordField("Password ");  
			    password.setBounds(95,250, 300,50); 
			    password.setBorder(BorderFactory.createCompoundBorder(
			    		password.getBorder(), 
			            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			   
			  //PlaceHolders
			    email.addFocusListener(new FocusListener(){  
			    	
			    	 String str = "Email ";
			    	 
			    	 public void focusGained(FocusEvent e) {
			    		 if (email.getText().equals(str)) {
			    			 email.setText("");
			    			 email.setForeground(Color.BLACK);
			    	     }  
			    	 }

				
					public void focusLost(FocusEvent e) {
						 if (email.getText().equals("")) {
							 email.setText(str);
							 email.setForeground(Color.BLACK);
			    	     } 
						
					}
			    }); 
			    
			    password.addFocusListener(new FocusListener(){  
			    	
			    	 String str = "Password ";
			    	 
			    	 public void focusGained(FocusEvent e) {
			    		 if (password.getText().equals(str)) {
			    			 password.setText("");
			    			 password.setForeground(Color.BLACK);
			    	     }  
			    	 }

				
					public void focusLost(FocusEvent e) {
						 if (password.getText().equals("")) {
							 password.setText(str);
							 password.setForeground(Color.BLACK);
			    	     } 
						
					}
			    });
			    
			    
			   
			    JButton loginbtn = new JButton("Log in"); 
			    loginbtn.setBounds(115,350,250, 40); 
			    
			    loginbtn.setBorderPainted(false);
			    loginbtn.setFocusPainted(false);
			    loginbtn.setContentAreaFilled(true);
			    loginbtn.setBackground(new Color(237,237,237));
			    loginbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			    
			    loginbtn.addActionListener(new ActionListener(){  
			    	public void actionPerformed(ActionEvent e){  
			    		
			    		String user_name = email.getText(); 
			    		String user_pass = password.getText();
			    		
			    		if(user_name.equals("") || user_pass.equals("")) {
			    			
			    			 JFrame f = new JFrame(); 
			    			 JOptionPane.showMessageDialog(f,"please fill in all the fields");
			 	 
			    		}else if(user_name.equals("Email ") || user_pass.equals("Password ")){
			    			 JFrame f = new JFrame(); 
			    			 JOptionPane.showMessageDialog(f,"please fill in all the fields");
			    		}else {
 			    			 
			    			//DB Work - check for valid user
				    			try{  
				    				Class.forName("com.mysql.jdbc.Driver");  
				    				
				    			    Connection con = DriverManager.getConnection(  
				    				"jdbc:mysql://localhost:3306/javadb","root","");  
				    			
				    				PreparedStatement stmt = con.prepareStatement("select * from test where email = ? and password = ?"); 
				    				stmt.setString(1,user_name);
				    				stmt.setString(2,user_pass);
				    				
				    				ResultSet rs = stmt.executeQuery();  

				    	 
				    				if(rs.next()) {

				    					//Call AdminPage
							    		 new Admin(rs.getString("name"),rs.getInt("id")); 
							    		 dispose();
							    		 
				    				}else {
				    					 System.out.println("No records found!");
						    			 JFrame f = new JFrame(); 
						    			 JOptionPane.showMessageDialog(f,"Invalid credentials");
				    				}
				    		
				    				
				    			}catch(Exception e1){ System.out.println(e1);} 
				    			
				    			
			    		}
			    		
			    		
			    	}  
			    });  
			    
			    //create account button
			    JButton createacc = new JButton("Create Account?"); 
			    createacc.setBounds(115,400,250, 40); 
			    
			    createacc.setBorderPainted(false);
			    createacc.setFocusPainted(false);
			    createacc.setContentAreaFilled(false);
			    createacc.setForeground(new Color(59,89,152));
			    createacc.setCursor(new Cursor(Cursor.HAND_CURSOR));
			    
			    createacc.addActionListener(new ActionListener(){  
			    	public void actionPerformed(ActionEvent e){  
			    		
			    		//Call Registration Page
			    		 new register(); 
			    		 dispose();
			    	
			    	}  
			    }); 
			    
			    //redirect focus - important
			    emptyfield = new JTextField("");  
			    emptyfield.setBounds(0,0,0,0); 
			    emptyfield.requestFocus();
			    RightSideBar.add(emptyfield);
			    
			    RightSideBar.add(email);
			    RightSideBar.add(password);
			    RightSideBar.add(loginbtn);
			    RightSideBar.add(createacc);
			
			//..Add Bar To LoginPage
			 	 add(RightSideBar);  
			
		    //============================================= 	
		 	
			 	 setLayout(null);  
			 	 
			 	 //center Location
				 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				 setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
				 
			 	 setVisible(true);
	}
}

//======================================================
//Registration Form======================================================
//======================================================

class register extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public register() {

        
	     setSize(900,600); 
		 setResizable(false);
		
		 setTitle("Registration");
		
		
		//Left Side Bar
		JPanel LeftSideBar = new JPanel(); 
		LeftSideBar.setBounds(0,0,400,500);    
		LeftSideBar.setBackground(new Color(237,237,237));
		LeftSideBar.setLayout(null);
		
		//..Heading Text
		    JLabel leftHeading; 
		    ImageIcon topimg = new ImageIcon(new ImageIcon("D:\\Joy\\Java Projects\\img\\books5.jpg").getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT));
		    leftHeading = new JLabel("");  
		    leftHeading.setIcon(topimg);
		    leftHeading.setBounds(0,120, 400,200);  

		    
		    JLabel welcome = new JLabel("Welcome to our librery"); 
		    welcome.setFont(new Font("Calibri", Font.PLAIN, 26));
		    welcome.setBounds(70,300, 300,100); 
		    welcome.setForeground(Color.black);
		    welcome.setBackground(Color.black);
		    
		    
		    LeftSideBar.add(leftHeading);
		    LeftSideBar.add(welcome);
		 
		    
	
		
		//..Add Bar To LoginPage
		     add(LeftSideBar);  
		
	    //=============================================
		
		//Right Side Bar
			JPanel RightSideBar = new JPanel(); 
			RightSideBar.setBounds(400,0,500,600);    
			RightSideBar.setBackground(Color.white);
			RightSideBar.setLayout(null);
			
			//..Heading Text
			    JLabel rightHeading; 
			    rightHeading = new JLabel("Sign up");  
			    rightHeading.setBounds(185,50, 500,100); 
			    rightHeading.setFont(new Font("Calibri", Font.PLAIN, 38));
			    
			    RightSideBar.add(rightHeading);
			    
			//..Form
			    JTextField name,email,username,password,emptyfield;
			    
			    name = new JTextField("Name ");  
			    name.setBounds(95,150,300,50); 
			    
			    name.setBorder(BorderFactory.createCompoundBorder(
			    		name.getBorder(), 
			            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			    
			    
			    email = new JTextField("Email ");  
			    email.setBounds(95,220,300,50); 
			    
			    email.setBorder(BorderFactory.createCompoundBorder(
			    		email.getBorder(), 
			            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			    
			    
			    
			    username = new JTextField("Username ");  
			    username.setBounds(95,290,300,50); 
			    
			    username.setBorder(BorderFactory.createCompoundBorder(
			    		username.getBorder(), 
			            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			    
			    
		
			    password = new JTextField("Password ");  
			    password.setBounds(95,360, 300,50); 
			    password.setBorder(BorderFactory.createCompoundBorder(
			    		password.getBorder(), 
			            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			    
			    
			    
			    //PlaceHolders
			    name.addFocusListener(new FocusListener(){  
			    	
			    	 String str = "Name ";
			    	 
			    	 public void focusGained(FocusEvent e) {
			    		 if (name.getText().equals(str)) {
			    			 name.setText("");
			    			 name.setForeground(Color.BLACK);
			    	     }  
			    	 }

				
					public void focusLost(FocusEvent e) {
						 if (name.getText().equals("")) {
			    			 name.setText(str);
			    			 name.setForeground(Color.BLACK);
			    	     } 
						
					}
			    }); 
			    
			    email.addFocusListener(new FocusListener(){  
			    	
			    	 String str = "Email ";
			    	 
			    	 public void focusGained(FocusEvent e) {
			    		 if (email.getText().equals(str)) {
			    			 email.setText("");
			    			 email.setForeground(Color.BLACK);
			    	     }  
			    	 }

				
					public void focusLost(FocusEvent e) {
						 if (email.getText().equals("")) {
			    			 email.setText(str);
			    			 email.setForeground(Color.BLACK);
			    	     } 
						
					}
			    }); 
			    
			    username.addFocusListener(new FocusListener(){  
			    	
			    	 String str = "Username ";
			    	 
			    	 public void focusGained(FocusEvent e) {
			    		 if (username.getText().equals(str)) {
			    			 username.setText("");
			    			 username.setForeground(Color.BLACK);
			    	     }  
			    	 }

				
					public void focusLost(FocusEvent e) {
						 if (username.getText().equals("")) {
							 username.setText(str);
							 username.setForeground(Color.BLACK);
			    	     } 
						
					}
			    }); 
			    
			    password.addFocusListener(new FocusListener(){  
			    	
			    	 String str = "Password ";
			    	 
			    	 public void focusGained(FocusEvent e) {
			    		 if (password.getText().equals(str)) {
			    			 password.setText("");
			    			 password.setForeground(Color.BLACK);
			    	     }  
			    	 }

				
					public void focusLost(FocusEvent e) {
						 if (password.getText().equals("")) {
							 password.setText(str);
							 password.setForeground(Color.BLACK);
			    	     } 
						
					}
			    }); 
			    
			   
			    JButton registerbtn = new JButton("Register"); 
			    registerbtn.setBounds(115,450,250, 40); 
			    
			    registerbtn.setBorderPainted(false);
			    registerbtn.setFocusPainted(false);
			    registerbtn.setContentAreaFilled(true);
			    registerbtn.setBackground(new Color(237,237,237));
			    registerbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			    
			    registerbtn.addActionListener(new ActionListener(){  
			    	public void actionPerformed(ActionEvent e){  
			    		
			    		String student_name = name.getText(); 
			    		String student_email = email.getText();
			    		String student_username = username.getText(); 
			    		String student_pass = password.getText();
			    		
			    		
			    		//if all fields are empty
			    		if(
			    				student_name.equals("Name ") 
			    				|| student_email.equals("Email ")
			    				|| student_username.equals("Username ")
			    				|| student_pass.equals("Password ")
			    		   ){

			    			 JFrame f = new JFrame(); 
			    			 JOptionPane.showMessageDialog(f,"Please fill in all fields"); 
			    		}else {
			    			
			    			//DB Work - insert
			    			try{  
			    				Class.forName("com.mysql.jdbc.Driver");  
			    				
			    			    Connection con = DriverManager.getConnection(  
			    				"jdbc:mysql://localhost:3306/javadb","root","");  
			    			    

			    				PreparedStatement stmt = con.prepareStatement("select * from test where email = ?"); 
			    				stmt.setString(1,student_email);
			    				
			    				ResultSet rs = stmt.executeQuery();  

			    				//Check if email is registered or not
			    				if(rs.next()) {		    				
			    					 JFrame f = new JFrame(); 
					    			 JOptionPane.showMessageDialog(f,"Email is already registerd");	
					    			 con.close();
			    				}else {
			    					
			    					
				    			    stmt = con.prepareStatement("insert into test(name,email,username,password) values(?,?,?,?)"); 
				    				stmt.setString(1,student_name);
				    				stmt.setString(2,student_email);
				    				stmt.setString(3,student_username);
				    				stmt.setString(4,student_pass);
				    				
				    
				    			    int i = stmt.executeUpdate();
				    			    
				    				if(i != 0) {	
				    					
				    					stmt = con.prepareStatement("select * from test where email = ?"); 
					    				stmt.setString(1,student_email);
					    				
					    			    rs = stmt.executeQuery();  

					    	 
					    				if(rs.next()) {	
					    					
					    					//Call AdminPage
								    		 new Admin(rs.getString("name"),rs.getInt("id")); 
								    		 dispose();
					    					 con.close();
					    				}
				    					
							    		 
				    				}
				    		
			    				}
			    				
			    				
			    
			    				
			    			}catch(Exception e1){ System.out.println(e1);} 
			    			
			    		}
			    		
			    		
			    	}  
			    }); 
			    
			    
			    
			  //create account button
			    JButton signin = new JButton("Already have an account?"); 
			    signin.setBounds(115,500,250, 40); 
			    
			    signin.setBorderPainted(false);
			    signin.setFocusPainted(false);
			    signin.setContentAreaFilled(false);
			    signin.setForeground(new Color(59,89,152));
			    signin.setCursor(new Cursor(Cursor.HAND_CURSOR));
			    
			    signin.addActionListener(new ActionListener(){  
			    	public void actionPerformed(ActionEvent e){  
			    		
			    		//Call Registration Page
			    		 new loginform(); 
			    		 dispose();
			    	
			    	}  
			    }); 
			    
			  //redirect focus - important
			    emptyfield = new JTextField("");  
			    emptyfield.setBounds(0,0,0,0); 
			    emptyfield.requestFocus();
			    RightSideBar.add(emptyfield);
			    
			    RightSideBar.add(name);
			    RightSideBar.add(email);
			    RightSideBar.add(username);
			    RightSideBar.add(password);
			    RightSideBar.add(registerbtn);
			    RightSideBar.add(signin);
			
			   
			    
			//..Add Bar To LoginPage
			     add(RightSideBar);  
			
		    //============================================= 	

		 setLayout(null);  
		
		 //center Location
		 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		 setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		 
		setVisible(true);
	}
}