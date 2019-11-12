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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

import net.proteanit.sql.DbUtils;

@SuppressWarnings("unused")
public class Admin extends JFrame{
	
	private static final long serialVersionUID = 1L;
    String user_name;
    
	public Admin (String name ,int id) {
		

		//DB Work - Get the current user
		
			try{  
				Class.forName("com.mysql.jdbc.Driver");  
				
			    Connection con = DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/javadb","root","");  
			
				PreparedStatement stmt = con.prepareStatement("select * from user where id = ?"); 
				stmt.setInt(1,id);
			
				
				ResultSet rs = stmt.executeQuery();  

	 
				if(rs.next()) { 
					
					//Set User
					
		    		 user_name = rs.getString("name");
		    		
		    		 
				}
		
				
			}catch(Exception e1){ System.out.println(e1);} 
			
			
		 setSize(1200,600); 
		 setResizable(false);
	
		 setTitle("Library Management System / " + user_name);
		 
		 //=========================
		 //Code Here======================================
		 //=========================
		 
		 	//Left Side Panel===
	
				JPanel LeftSideBar = new JPanel(); 
				LeftSideBar.setBounds(0,0,300,600);    
				LeftSideBar.setBackground(Color.white);
				LeftSideBar.setLayout(null);
				
				//Menu Bar List
					
				//dashboard------
					JLabel dashboardbtn =  new JLabel("<html>&nbsp;&nbsp;&#127968; Dashboard</html>");  
					dashboardbtn.setBounds(0,50, 300,50); 
					dashboardbtn.setFont(new Font("Calibri", Font.PLAIN, 22));
					dashboardbtn.setForeground(Color.white);
					dashboardbtn.setBackground(new Color(99, 179, 237));
					dashboardbtn.setOpaque(true);	
					dashboardbtn.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
				    LeftSideBar.add(dashboardbtn);
				    
				//view users------
					JLabel viewUserbtn =  new JLabel("<html>&nbsp;&nbsp;&#128101; View Users</html>");  
					viewUserbtn.setBounds(0,100, 300,50); 
					viewUserbtn.setFont(new Font("Calibri", Font.PLAIN, 22));
					viewUserbtn.setForeground(Color.black);
					viewUserbtn.setBackground(Color.WHITE);
					viewUserbtn.setOpaque(true);	
					viewUserbtn.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
				    LeftSideBar.add(viewUserbtn);
				    
				  //ADD books------
					JLabel addBook =  new JLabel("<html>&nbsp;&nbsp;&#128215; Add Book</html>");  
					addBook.setBounds(0,150, 300,50); 
					addBook.setFont(new Font("Calibri", Font.PLAIN, 22));
					addBook.setForeground(Color.black);
					addBook.setBackground(Color.white);
					addBook.setOpaque(true);
					addBook.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
				    LeftSideBar.add(addBook); 
				    
				  //View Books------
					JLabel viewBook =  new JLabel("<html>&nbsp;&nbsp;&#128218; View Books</html>");  
					viewBook.setBounds(0,200, 300,50); 
					viewBook.setFont(new Font("Calibri", Font.PLAIN, 22));
					viewBook.setForeground(Color.black);
					viewBook.setBackground(Color.white);
					viewBook.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
					viewBook.setOpaque(true);
				    LeftSideBar.add(viewBook);
				    
				  //Issue Books------
					JLabel issuebookbtn =  new JLabel("<html>&nbsp;&nbsp;&#128221; Issue Book</html>");  
					issuebookbtn.setBounds(0,250, 300,50); 
					issuebookbtn.setFont(new Font("Calibri", Font.PLAIN, 22));
					issuebookbtn.setForeground(Color.black);
					issuebookbtn.setBackground(Color.white);
					issuebookbtn.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
					issuebookbtn.setOpaque(true);
				    LeftSideBar.add(issuebookbtn);
				    
				    
				  //View Issued Books------
					JLabel viewissuebookbtn =  new JLabel("<html>&nbsp;&nbsp;&#128214; View Issued Books</html>");  
					viewissuebookbtn.setBounds(0,300, 300,50); 
					viewissuebookbtn.setFont(new Font("Calibri", Font.PLAIN, 22));
					viewissuebookbtn.setForeground(Color.black);
					viewissuebookbtn.setBackground(Color.white);
					viewissuebookbtn.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
					viewissuebookbtn.setOpaque(true);
				    LeftSideBar.add(viewissuebookbtn);
				    
				  //Return Issued Books------
					JLabel returnbookbtn =  new JLabel("<html>&nbsp;&nbsp;&#128209; Return Books</html>");  
					returnbookbtn.setBounds(0,350, 300,50); 
					returnbookbtn.setFont(new Font("Calibri", Font.PLAIN, 22));
					returnbookbtn.setForeground(Color.black);
					returnbookbtn.setBackground(Color.white);
					returnbookbtn.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
					returnbookbtn.setOpaque(true);
				    LeftSideBar.add(returnbookbtn);
				    
				  //logout------
					JLabel logout =  new JLabel("<html>&nbsp;&nbsp;&#128280; Log out</html>");  
					logout.setBounds(0,400, 300,50); 
					logout.setFont(new Font("Calibri", Font.PLAIN, 22));
					logout.setForeground(Color.black);
					logout.setBackground(new Color(220,220,220));
				    logout.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
				    LeftSideBar.add(logout);
				    
				    
				   
				    
					
				add(LeftSideBar);
		 		
		   //Right Side Panel===
				
				JPanel RightSideBar = new JPanel(); 
				RightSideBar.setBounds(300,0,900,600);    
				RightSideBar.setBackground(Color.red);
				RightSideBar.setLayout(null);
				
					//Side Panels
				
					//Dash Board Panel
					
					JPanel dashboardPanel = new JPanel(); 
					dashboardPanel.setBounds(0,0,900,600);    
					dashboardPanel.setBackground(new Color(247,247,247));
					dashboardPanel.setLayout(null);
					dashboardPanel.setVisible(true);
					
					JLabel dashboardText =  new JLabel("<html>Dashboard</html>");  
					dashboardText.setBounds(20,20, 700,50); 
					dashboardText.setFont(new Font("Calibri", Font.PLAIN, 40));
					dashboardText.setForeground(new Color(74, 85, 104));
					dashboardPanel.add(dashboardText);
					
					dashboardPanel.add(dashboardText);
					
					JLabel dashboardLine =  new JLabel("<html>__________________________________________________________________________________________________________________________________</html>");  
					dashboardLine.setBounds(20,50, 700,50); 
					dashboardLine.setFont(new Font("Calibri", Font.PLAIN, 40));
					dashboardLine.setForeground(new Color(226, 232, 240));
					dashboardPanel.add(dashboardLine);
					
					dashboardPanel.add(dashboardText);
					
					 // User Card
						JPanel usercard = new JPanel();
						usercard.setBounds(20,140,200,200);    
						usercard.setBackground(new Color(104, 211, 145));
						usercard.setLayout(null);
						usercard.setVisible(true);
						
						
						  //No. of Users
							JLabel numberUser =  new JLabel("",SwingConstants.CENTER);  
							numberUser.setBounds(0,50, 200,100); 
							numberUser.setFont(new Font("Calibri", Font.PLAIN, 100));
							numberUser.setForeground(Color.white);
						    numberUser.setOpaque(false);
						    
						    JLabel numberUsersub =  new JLabel("Number of members",SwingConstants.CENTER);  
						    numberUsersub.setBounds(0,140, 200,50); 
						    numberUsersub.setFont(new Font("Calibri", Font.PLAIN, 19));
						    numberUsersub.setForeground(Color.white);
						    numberUsersub.setOpaque(false);
						    usercard.add(numberUsersub);
						
							//DB Work - Number of everything
			    			try{  
			    				Class.forName("com.mysql.jdbc.Driver");  
			    				
			    			    Connection con = DriverManager.getConnection(  
			    				"jdbc:mysql://localhost:3306/javadb","root","");  
			    			
			    			    PreparedStatement stmt = con.prepareStatement("select count(*) as count from user where role = 'member' "); 
			    	
			    				
			    				ResultSet rs = stmt.executeQuery();  
			    				rs.next();
			    				String numberofUsers = rs.getString(1);
			    	
			    				
			    				numberUser.setText(numberofUsers);
			    				
			    				con.close();
				    		
			    			}catch(Exception e1){ System.out.println(e1);} 
			    			
			    			usercard.add(numberUser);
								
						dashboardPanel.add(usercard);
						
						
						//Books Card-----
						
						JPanel bookscard = new JPanel();
						bookscard.setBounds(250,140,200,200);    
						bookscard.setBackground(new Color(183, 148, 244));
						bookscard.setLayout(null);
						bookscard.setVisible(true);
						
						
						  //No. of Users
							JLabel numberBook =  new JLabel("",SwingConstants.CENTER);  
							numberBook.setBounds(0,50, 200,100); 
							numberBook.setFont(new Font("Calibri", Font.PLAIN, 100));
							numberBook.setForeground(Color.white);
							numberBook.setOpaque(false);
						    
						    JLabel numberBooksub =  new JLabel("Number of Books",SwingConstants.CENTER);  
						    numberBooksub.setBounds(0,140, 200,50); 
						    numberBooksub.setFont(new Font("Calibri", Font.PLAIN, 19));
						    numberBooksub.setForeground(Color.white);
						    numberBooksub.setOpaque(false);
						    bookscard.add(numberBooksub);
						
							//DB Work - Number of Books
			    			try{  
			    				Class.forName("com.mysql.jdbc.Driver");  
			    				
			    			    Connection con = DriverManager.getConnection(  
			    				"jdbc:mysql://localhost:3306/javadb","root","");  
			    			
			    			    PreparedStatement stmt = con.prepareStatement("select count(*) as count from books where qty <> 0"); 
			    	
			    				
			    				ResultSet rs = stmt.executeQuery();  
			    				rs.next();
			    				String numberofBook = rs.getString(1);
			    				
			    				
			    				
			    				numberBook.setText(numberofBook);
			    				
			    				con.close();
				    		
			    			}catch(Exception e1){ System.out.println(e1);} 
			    			
			    			bookscard.add(numberBook);
								
						dashboardPanel.add(bookscard);
						
						
						//issued Card-----
						
						JPanel issuedcard = new JPanel();
						issuedcard.setBounds(480,140,200,200);    
						issuedcard.setBackground(new Color(246, 173, 85));
						issuedcard.setLayout(null);
						issuedcard.setVisible(true);
						
						
						  //No. of Users
							JLabel numberIssued =  new JLabel("",SwingConstants.CENTER);  
							numberIssued.setBounds(0,50, 200,100); 
							numberIssued.setFont(new Font("Calibri", Font.PLAIN, 100));
							numberIssued.setForeground(Color.white);
							numberIssued.setOpaque(false);
						    
						    JLabel numberIssuedsub =  new JLabel("Books Issued",SwingConstants.CENTER);  
						    numberIssuedsub.setBounds(0,140, 200,50); 
						    numberIssuedsub.setFont(new Font("Calibri", Font.PLAIN, 19));
						    numberIssuedsub.setForeground(Color.white);
						    numberIssuedsub.setOpaque(false);
						    issuedcard.add(numberIssuedsub);
						
							//DB Work - Number of Books
			    			try{  
			    				Class.forName("com.mysql.jdbc.Driver");  
			    				
			    			    Connection con = DriverManager.getConnection(  
			    				"jdbc:mysql://localhost:3306/javadb","root","");  
			    			
			    			    PreparedStatement stmt = con.prepareStatement("select count(*) as count from issued_book"); 
			    	
			    				
			    				ResultSet rs = stmt.executeQuery();  
			    				rs.next();
			    				String numberofissued = rs.getString(1);
			    				
			    			
			    				
			    				numberIssued.setText(numberofissued);
			    				
			    				con.close();
				    		
			    			}catch(Exception e1){ System.out.println(e1);} 
			    			
			    			issuedcard.add(numberIssued);
								
						dashboardPanel.add(issuedcard);
						
						
						
						
						
					
					RightSideBar.add(dashboardPanel);
				
					//View Users Panel
				
						JPanel viewUserPanel = new JPanel(); 
						viewUserPanel.setBounds(0,0,900,600);    
						viewUserPanel.setBackground(new Color(247,247,247));
						viewUserPanel.setLayout(null);
						viewUserPanel.setVisible(false);
						RightSideBar.add(viewUserPanel);
					
						
					//Add Books Panel	
						
						//Side Panels
						
						JPanel addbookPanel = new JPanel(); 
						addbookPanel.setBounds(0,0,900,600);    
						addbookPanel.setBackground(new Color(247,247,247));
						addbookPanel.setLayout(null);
						addbookPanel.setVisible(false);
						
							//Add Book Form
							
						   //Book name
								JLabel BookNameLableForm =  new JLabel("Book Name");  
								BookNameLableForm.setBounds(20,50, 300,50); 
								BookNameLableForm.setFont(new Font("Calibri", Font.PLAIN, 22));
								addbookPanel.add(BookNameLableForm);
								
								JTextField BookNameField = new JTextField("");  
								BookNameField.setBounds(20,100,300,50); 
								BookNameField.setBorder(BorderFactory.createCompoundBorder(
								BookNameField.getBorder(), 
							    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
								addbookPanel.add(BookNameField); 
							//Book name
							
							//Book Author
								JLabel BookAuthorLableForm =  new JLabel("Book Author");  
								BookAuthorLableForm.setBounds(350,50, 300,50); 
								BookAuthorLableForm.setFont(new Font("Calibri", Font.PLAIN, 22));
								addbookPanel.add(BookAuthorLableForm);
								
								JTextField BookAuthorField = new JTextField("");  
								BookAuthorField.setBounds(350,100,300,50); 
								BookAuthorField.setBorder(BorderFactory.createCompoundBorder(
								BookAuthorField.getBorder(), 
							    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
								addbookPanel.add(BookAuthorField); 
							//Book Author
								
							//Book Price
								JLabel BookPriceLableForm =  new JLabel("Book Price");  
								BookPriceLableForm.setBounds(20,150, 300,50); 
								BookPriceLableForm.setFont(new Font("Calibri", Font.PLAIN, 22));
								addbookPanel.add(BookPriceLableForm);
								
								JTextField BookPriceField = new JTextField("");  
								BookPriceField.setBounds(20,200,300,50); 
								BookPriceField.setBorder(BorderFactory.createCompoundBorder(
								BookPriceField.getBorder(), 
							    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
								addbookPanel.add(BookPriceField); 
							//Book Price
								
							//Book Qty
								JLabel BookQtyLableForm =  new JLabel("Quantity");  
								BookQtyLableForm.setBounds(20,250, 300,50); 
								BookQtyLableForm.setFont(new Font("Calibri", Font.PLAIN, 22));
								addbookPanel.add(BookQtyLableForm);
								
								JTextField BookQtyField = new JTextField("");  
								BookQtyField.setBounds(20,300,100,50); 
								BookQtyField.setBorder(BorderFactory.createCompoundBorder(
										BookQtyField.getBorder(), 
							    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
								addbookPanel.add(BookQtyField); 
							//Book Qty	
								
							//Book Add Button
								JButton BookAddBtnForm = new JButton("Add"); 
								BookAddBtnForm.setBounds(20,400, 100,50); 
								BookAddBtnForm.setFont(new Font("Calibri", Font.PLAIN, 22));
							    BookAddBtnForm.setBorderPainted(false);
								BookAddBtnForm.setFocusPainted(false);
								BookAddBtnForm.setContentAreaFilled(true);
								BookAddBtnForm.setForeground(Color.white);
								BookAddBtnForm.setBackground(new Color(99, 179, 237));
								BookAddBtnForm.setCursor(new Cursor(Cursor.HAND_CURSOR));
								addbookPanel.add(BookAddBtnForm);
								
								BookAddBtnForm.addActionListener(new ActionListener(){  
								    	public void actionPerformed(ActionEvent e){  
								    		
								    		//Do All DB Work And Stuff
								        	String Name = BookNameField.getText();
								        	String Author = BookAuthorField.getText();
								        	String Price = BookPriceField.getText();
								        	String Qty = BookQtyField.getText();
								        	
								        	
								        	if(
								        			Name.equals("") 
								        			|| Author.equals("") 
								        			|| Price.equals("")
								        			|| Qty.equals("")
								        	   
								        	) {
								        		JFrame f = new JFrame(); 
								    			JOptionPane.showMessageDialog(f,"please fill in all the fields");
								        	}else {
								        		
								        		
								        		//DB Work - check for valid user
								    			try{  
								    				Class.forName("com.mysql.jdbc.Driver");  
								    				
								    			    Connection con = DriverManager.getConnection(  
								    				"jdbc:mysql://localhost:3306/javadb","root","");  
								    			
								    			    PreparedStatement stmt = con.prepareStatement("insert into books(name,author,price,qty) values(?,?,?,?)"); 
								    				stmt.setString(1,Name);
								    				stmt.setString(2,Author);
								    				stmt.setString(3,Price);
								    				stmt.setString(4,Qty);
								    				
								    
								    			    int i = stmt.executeUpdate();
								    			    
								    				if(i != 0) {	
								    					
								    					JFrame f = new JFrame(); 
										    			JOptionPane.showMessageDialog(f,"Book Inserted Successfully");
										    			BookNameField.setText("");
											        	BookAuthorField.setText("");
											        	BookPriceField.setText("");
											        	BookQtyField.setText("");
								    		
								    				}else {
								    					
								    					JFrame f = new JFrame(); 
										    			JOptionPane.showMessageDialog(f,"Unable to insert,Please try again");
								    					
								    				}
							
									    			 
									    		
								    			}catch(Exception e1){ System.out.println(e1);} 
								        		
								        		
								        	}
								    	
								    	}  
								});
							//Book Add Button	
								
								
								
								
						RightSideBar.add(addbookPanel);
						
						//View Books Panel
						
						JPanel viewBooksPanel = new JPanel(); 
						viewBooksPanel.setBounds(0,0,900,600);    
						viewBooksPanel.setBackground(new Color(247,247,247));
						viewBooksPanel.setLayout(null);
						viewBooksPanel.setVisible(false);
						
							
						
						RightSideBar.add(viewBooksPanel);
						
						//Issue book Panel
						
						JPanel issueBookPanel = new JPanel(); 
						issueBookPanel.setBounds(0,0,900,600);    
						issueBookPanel.setBackground(new Color(247,247,247));
						issueBookPanel.setLayout(null);
						issueBookPanel.setVisible(false);
						
						//===========================
						
						//Issue Book Form
						
					
								JLabel BookIdLableForm =  new JLabel("Book ID");  
								BookIdLableForm.setBounds(20,50, 100,50); 
								BookIdLableForm.setFont(new Font("Calibri", Font.PLAIN, 22));
								issueBookPanel.add(BookIdLableForm);
							
								
								JTextField BookIdField = new JTextField("");  
								BookIdField.setBounds(20,100,300,50); 
								BookIdField.setBorder(BorderFactory.createCompoundBorder(
										BookIdField.getBorder(), 
							    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
								issueBookPanel.add(BookIdField); 
								
								
								JLabel BooknameLableForm =  new JLabel("Book Name");  
								BooknameLableForm.setBounds(20,150, 300,50); 
								BooknameLableForm.setFont(new Font("Calibri", Font.PLAIN, 22));
								issueBookPanel.add(BooknameLableForm);
								
								
								JTextField BooknameField = new JTextField("");  
								BooknameField.setBounds(20,200,300,50); 
								BooknameField.setBorder(BorderFactory.createCompoundBorder(
										BooknameField.getBorder(), 
							    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
								issueBookPanel.add(BooknameField); 
								BooknameField.setEditable(false);
								
								
								//Book search button
								JLabel Booksearch =  new JLabel("<html>&#x1F50D;</html>",SwingConstants.CENTER);  
								Booksearch.setBounds(250,50, 80,50); 
								Booksearch.setFont(new Font("Calibri", Font.PLAIN, 22));
								Booksearch.setOpaque(false);
								Booksearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
								issueBookPanel.add(Booksearch);
								
								//Click Action---
								Booksearch.addMouseListener(new MouseAdapter()  
								{  
								        public void mouseClicked(MouseEvent e)  
								        { 
								        	
								        	if(BookIdField.getText() == "") {
								        		 JFrame f = new JFrame(); 
								    			 JOptionPane.showMessageDialog(f,"Please enter a book ID");	
								        	}else{
								        		
								        		//DB Work - Book Search
								    			try{  
								    				Class.forName("com.mysql.jdbc.Driver");  
								    				
								    			    Connection con = DriverManager.getConnection(  
								    				"jdbc:mysql://localhost:3306/javadb","root","");  
								    			
								    			    
								    			    String BookID = BookIdField.getText();
								    			    
								    			    PreparedStatement stmt = con.prepareStatement("select * from books where id = ?"); 
								    				stmt.setString(1,BookID);
								    				
								    				ResultSet rs = stmt.executeQuery();  
								    				
								    				
								    				if(rs.next()) {
								    				
								    					
								    					int bookQty = rs.getInt("qty");
								    					
								    					if(bookQty > 0) {

								    						BooknameField.setText(rs.getString("name"));
								    						
										    				con.close();
								    						
								    					}else {
								    						JFrame f = new JFrame(); 
											    			JOptionPane.showMessageDialog(f,"Book Out Of Stock");
											    			BooknameField.setText("");
											    			
											    			con.close();
								    					}
								    				}else {
								    					JFrame f = new JFrame(); 
										    			JOptionPane.showMessageDialog(f,"Please enter a valid book ID");
										    			BooknameField.setText("");
										    		
										    			con.close();
								    				}
								    				
									    		
								    			}catch(Exception e1){ System.out.println(e1);} 
								        		
								        	}
								        	
								        	
							    			
								        }
								  });
									
								//===============
							//===============
								
								
								JLabel StudentIdLableForm =  new JLabel("Student ID");  
								StudentIdLableForm.setBounds(400,50, 100,50); 
								StudentIdLableForm.setFont(new Font("Calibri", Font.PLAIN, 22));
								issueBookPanel.add(StudentIdLableForm);
								
								JTextField StudentIdField = new JTextField("");  
								StudentIdField.setBounds(400,100,300,50); 
								StudentIdField.setBorder(BorderFactory.createCompoundBorder(
										StudentIdField.getBorder(), 
							    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
								issueBookPanel.add(StudentIdField); 
								
								JLabel StudentnameLableForm =  new JLabel("Student Name");  
								StudentnameLableForm.setBounds(400,150, 300,50); 
								StudentnameLableForm.setFont(new Font("Calibri", Font.PLAIN, 22));
								issueBookPanel.add(StudentnameLableForm);
								
								JTextField StudentnameField = new JTextField("");  
								StudentnameField.setBounds(400,200,300,50); 
								StudentnameField.setBorder(BorderFactory.createCompoundBorder(
										StudentnameField.getBorder(), 
							    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
								issueBookPanel.add(StudentnameField); 
								StudentnameField.setEditable(false);
								
								//Student search button
								JLabel Studentsearch =  new JLabel("<html>&#x1F50D;</html>",SwingConstants.CENTER);  
								Studentsearch.setBounds(640,50, 80,50); 
								Studentsearch.setFont(new Font("Calibri", Font.PLAIN, 22));
								Studentsearch.setOpaque(false);
								Studentsearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
								issueBookPanel.add(Studentsearch);
								
								//Click Action---
								Studentsearch.addMouseListener(new MouseAdapter()  
								{  
								        public void mouseClicked(MouseEvent e)  
								        { 
								        	
								        	if(StudentIdField.getText() == "") {
								        		 JFrame f = new JFrame(); 
								    			 JOptionPane.showMessageDialog(f,"Please enter a Student ID");	
								        	}else{
								        		
								        		//DB Work - Book Search
								    			try{  
								    				Class.forName("com.mysql.jdbc.Driver");  
								    				
								    			    Connection con = DriverManager.getConnection(  
								    				"jdbc:mysql://localhost:3306/javadb","root","");  
								    			
								    			    
								    			    String StudentID = StudentIdField.getText();
								    			    
								    			    PreparedStatement stmt = con.prepareStatement("select * from user where id = ?"); 
								    				stmt.setString(1,StudentID);
								    				
								    				ResultSet rs = stmt.executeQuery();  
								    				
								    				
								    				if(rs.next()) {
								    				
								    					StudentnameField.setText(rs.getString("name"));
										    			con.close();
								    				
								    				}else {
								    					JFrame f = new JFrame(); 
										    			JOptionPane.showMessageDialog(f,"Please enter a valid Student ID");
										    			StudentnameField.setText("");
										    			con.close();
								    				}
								    				
									    		
								    			}catch(Exception e1){ System.out.println(e1);} 
								        		
								        	}
								        	
								        	
							    			
								        }
								  });
									
								//===============
							//===============
								
								JLabel IssueDateLableForm =  new JLabel("Issue Date (YYYY-MM-DD)");  
								IssueDateLableForm.setBounds(20,300, 300,50); 
								IssueDateLableForm.setFont(new Font("Calibri", Font.PLAIN, 22));
								issueBookPanel.add(IssueDateLableForm);
								
								//Get Date
								 LocalDateTime date = LocalDateTime.now();
								 DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyy-MM-dd");
								 String todayDate = date.format(dateFormat);
								//====================
								 
								JTextField IssueDateField = new JTextField(todayDate);  
								IssueDateField.setBounds(20,350,200,50); 
								IssueDateField.setBorder(BorderFactory.createCompoundBorder(
										IssueDateField.getBorder(), 
							    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
								issueBookPanel.add(IssueDateField); 
								
								
						
								JLabel ReturnDateLableForm =  new JLabel("Return Date (YYYY-MM-DD)");  
								ReturnDateLableForm.setBounds(400,300, 300,50); 
								ReturnDateLableForm.setFont(new Font("Calibri", Font.PLAIN, 22));
								issueBookPanel.add(ReturnDateLableForm);
								
								JTextField ReturnDateField = new JTextField("");  
								ReturnDateField.setBounds(400,350,200,50); 
								ReturnDateField.setBorder(BorderFactory.createCompoundBorder(
										ReturnDateField.getBorder(), 
							    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
								issueBookPanel.add(ReturnDateField); 
											
									
							
								JButton IssueBookBtnForm = new JButton("Issue"); 
								IssueBookBtnForm.setBounds(20,450, 100,50); 
								IssueBookBtnForm.setFont(new Font("Calibri", Font.PLAIN, 22));
								IssueBookBtnForm.setBorderPainted(false);
								IssueBookBtnForm.setFocusPainted(false);
								IssueBookBtnForm.setContentAreaFilled(true);
								IssueBookBtnForm.setForeground(Color.white);
								IssueBookBtnForm.setBackground(new Color(99, 179, 237));
								IssueBookBtnForm.setCursor(new Cursor(Cursor.HAND_CURSOR));
								issueBookPanel.add(IssueBookBtnForm);
								
								IssueBookBtnForm.addActionListener(new ActionListener(){  
								    	public void actionPerformed(ActionEvent e){  
								    		
								    		//Do All DB Work And Stuff
								        	String bookID = BookIdField.getText();
								        	String stuID = StudentIdField.getText();
								        	String issueDate = IssueDateField.getText();
								        	String returnDate = ReturnDateField.getText();
								        	
								        	
								        	if(
								        			bookID.equals("") 
								        			|| stuID.equals("") 
								        			|| issueDate.equals("")
								        			|| returnDate.equals("")
								        	   
								        	) {
								        		JFrame f = new JFrame(); 
								    			JOptionPane.showMessageDialog(f,"please fill in all the fields");
								        	}else {
								        		
								        		
								        		//DB Work - check for valid user
								    			try{  
								    				Class.forName("com.mysql.jdbc.Driver");  
								    				
								    			    Connection con = DriverManager.getConnection(  
								    				"jdbc:mysql://localhost:3306/javadb","root","");  
								    			
								    			    PreparedStatement stmt = con.prepareStatement("insert into issued_book(BID,STUID,issue_Date,return_Date) values(?,?,?,?)"); 
								    				stmt.setString(1,bookID);
								    				stmt.setString(2,stuID);
								    				stmt.setString(3,issueDate);
								    				stmt.setString(4,returnDate);
								    				
								    
								    			    int i = stmt.executeUpdate();
								    			    
								    				if(i != 0) {	
								    					
								    					JFrame f = new JFrame(); 
										    			JOptionPane.showMessageDialog(f,"Book Issued Successfully");
										    			BookIdField.setText("");
										    			BooknameField.setText("");
										    			StudentnameField.setText("");
											        	StudentIdField.setText("");
											        	ReturnDateField.setText("");
											        	
											        	
											        	stmt = con.prepareStatement("UPDATE books SET qty = qty - 1 WHERE id = ?"); 
									    				stmt.setString(1,bookID);
									    			    stmt.executeUpdate();
								    		
								    				}else {
								    					
								    					JFrame f = new JFrame(); 
										    			JOptionPane.showMessageDialog(f,"Unable to insert,Please try again");
								    					
								    				}
							
									    			 
									    		
								    			}catch(Exception e1){ System.out.println(e1);} 
								        		
								        		
								        	}
								    	
								    	}  
								});
							//issue
								
						//===========================
							
						
						RightSideBar.add(issueBookPanel);
						
                        //View Books Panel
						
						JPanel viewissueBookPanel = new JPanel(); 
						viewissueBookPanel.setBounds(0,0,900,600);    
						viewissueBookPanel.setBackground(new Color(247,247,247));
						viewissueBookPanel.setLayout(null);
						viewissueBookPanel.setVisible(false);
						RightSideBar.add(viewissueBookPanel);
						
						
						
						//Issue book Panel
						
						JPanel returnBookPanel = new JPanel(); 
						returnBookPanel.setBounds(0,0,900,600);    
						returnBookPanel.setBackground(new Color(247,247,247));
						returnBookPanel.setLayout(null);
						returnBookPanel.setVisible(false);
						
						//===========================
						
						//Issue Book Form
						
					
								JLabel returnIssueIdLableForm =  new JLabel("Enter the Issued ID of the book");  
								returnIssueIdLableForm.setBounds(20,50, 400,50); 
								returnIssueIdLableForm.setFont(new Font("Calibri", Font.PLAIN, 22));
								returnBookPanel.add(returnIssueIdLableForm);
							
								
								JTextField returnIssueIdField = new JTextField("");  
								returnIssueIdField.setBounds(20,100,300,50); 
								returnIssueIdField.setBorder(BorderFactory.createCompoundBorder(
										returnIssueIdField.getBorder(), 
							    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
								returnBookPanel.add(returnIssueIdField); 
								
								
								//Book search button
								JLabel issueBookSearch =  new JLabel("<html>&#x1F50D;</html>",SwingConstants.CENTER);  
								issueBookSearch.setBounds(315,100, 80,49); 
								issueBookSearch.setFont(new Font("Calibri", Font.PLAIN, 22));
								issueBookSearch.setOpaque(true);
								issueBookSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
								issueBookSearch.setForeground(Color.white);
								issueBookSearch.setBackground(new Color(99, 179, 237));
								returnBookPanel.add(issueBookSearch);
								
								//Info Lables
								
								JLabel returnBookID = new JLabel(""); 
								returnBookID.setVisible(false);
								
								JLabel returnIssueID = new JLabel(""); 
								returnBookID.setVisible(false);
								
								JLabel returnBookNameLableForm =  new JLabel("Book name");  
								returnBookNameLableForm.setBounds(20,160, 150,50); 
								returnBookNameLableForm.setFont(new Font("Calibri", Font.PLAIN, 18));
								returnBookPanel.add(returnBookNameLableForm);
								
								JLabel returnBookNameField =  new JLabel("  ---");  
								returnBookNameField.setBounds(20,200, 300,50); 
								returnBookNameField.setFont(new Font("Calibri", Font.PLAIN, 25));
								returnBookNameField.setOpaque(true);
								returnBookNameField.setBackground(new Color(226, 232, 240));
								returnBookPanel.add(returnBookNameField);
								
								JLabel returnStudentNameLableForm =  new JLabel("Student name");  
								returnStudentNameLableForm.setBounds(350,160, 200,50); 
								returnStudentNameLableForm.setFont(new Font("Calibri", Font.PLAIN, 18));
								returnBookPanel.add(returnStudentNameLableForm);
								
								JLabel returnStudentNameField =  new JLabel("  ---");  
								returnStudentNameField.setBounds(350,200, 400,50); 
								returnStudentNameField.setFont(new Font("Calibri", Font.PLAIN, 25));
								returnStudentNameField.setOpaque(true);
								returnStudentNameField.setBackground(new Color(226, 232, 240));
								returnBookPanel.add(returnStudentNameField);
								
								JLabel returnIssueDateLableForm =  new JLabel("Issue Date");  
								returnIssueDateLableForm.setBounds(20,260, 150,50); 
								returnIssueDateLableForm.setFont(new Font("Calibri", Font.PLAIN, 18));
								returnBookPanel.add(returnIssueDateLableForm);
								
								JLabel returnIssueDateField =  new JLabel("  ---");  
								returnIssueDateField.setBounds(20,300, 160,50); 
								returnIssueDateField.setFont(new Font("Calibri", Font.PLAIN, 25));
								returnIssueDateField.setOpaque(true);
								returnIssueDateField.setBackground(new Color(226, 232, 240));
								returnBookPanel.add(returnIssueDateField);
								
								JLabel returnReturnDateLableForm =  new JLabel("Return Date");  
								returnReturnDateLableForm.setBounds(200,260, 150,50); 
								returnReturnDateLableForm.setFont(new Font("Calibri", Font.PLAIN, 18));
								returnBookPanel.add(returnReturnDateLableForm);
								
								JLabel returnReturnDateField =  new JLabel("  ---");  
								returnReturnDateField.setBounds(200,300, 160,50); 
								returnReturnDateField.setFont(new Font("Calibri", Font.PLAIN, 25));
								returnReturnDateField.setOpaque(true);
								returnReturnDateField.setBackground(new Color(226, 232, 240));
								returnBookPanel.add(returnReturnDateField); 
								
								JLabel returnDaysLableForm =  new JLabel("Days Elapsed");  
								returnDaysLableForm.setBounds(380,260, 100,50); 
								returnDaysLableForm.setFont(new Font("Calibri", Font.PLAIN, 18));
								returnBookPanel.add(returnDaysLableForm);
								
								JLabel returnDaysField =  new JLabel("  ---");  
								returnDaysField.setBounds(380,300, 150,50); 
								returnDaysField.setFont(new Font("Calibri", Font.PLAIN, 25));
								returnDaysField.setOpaque(true);
								returnDaysField.setBackground(new Color(226, 232, 240));
								returnBookPanel.add(returnDaysField);
								
								JLabel returnFineLableForm =  new JLabel("Fine");  
								returnFineLableForm.setBounds(20,360, 100,50); 
								returnFineLableForm.setFont(new Font("Calibri", Font.PLAIN, 18));
								returnBookPanel.add(returnFineLableForm);
								
								JLabel returnFineField =  new JLabel("  ---");  
								returnFineField.setBounds(20,400, 150,50); 
								returnFineField.setFont(new Font("Calibri", Font.PLAIN, 25));
								returnFineField.setOpaque(true);
								returnFineField.setBackground(new Color(226, 232, 240));
								returnBookPanel.add(returnFineField);
								

								JButton returnBookBtnForm = new JButton("Return"); 
								returnBookBtnForm.setBounds(20,480, 200,50); 
								returnBookBtnForm.setFont(new Font("Calibri", Font.PLAIN, 22));
								returnBookBtnForm.setBorderPainted(false);
								returnBookBtnForm.setFocusPainted(false);
								returnBookBtnForm.setContentAreaFilled(true);
								returnBookBtnForm.setForeground(Color.white);
								returnBookBtnForm.setBackground(new Color(99, 179, 237));
								returnBookBtnForm.setCursor(new Cursor(Cursor.HAND_CURSOR));
								returnBookPanel.add(returnBookBtnForm);
								
								returnBookBtnForm.addActionListener(new ActionListener(){  
								    	public void actionPerformed(ActionEvent e){  
								    		
								    		//Do All DB Work And Stuff
								        	
								        	String bookid = returnBookID.getText();
								        	String issueid = returnIssueID.getText();
								        	
					    					   
								        	
								        	if(
								        			bookid.equals("") 
								        			|| issueid.equals("") 
								        		
								        	   
								        	) {
								        		JFrame f = new JFrame(); 
								    			JOptionPane.showMessageDialog(f,"please provide a Issued ID");
								        	}else {
								        	
								        		
								        		//DB Work - check for valid user
								    			try{  
								    				Class.forName("com.mysql.jdbc.Driver");  
								    				
								    			    Connection con = DriverManager.getConnection(  
								    				"jdbc:mysql://localhost:3306/javadb","root","");  
								    			
								    			    PreparedStatement stmt = con.prepareStatement("DELETE FROM issued_book WHERE id = ?;"); 
								    				stmt.setString(1,issueid);
								    				
								    				
								    
								    			    int i = stmt.executeUpdate();
								    			    
								    				if(i != 0) {	
								    					
								    					JFrame f = new JFrame(); 
										    			JOptionPane.showMessageDialog(f,"Book Returned Successfully");
										    			
										    			stmt = con.prepareStatement("UPDATE books SET qty = qty + 1 WHERE id = ?"); 
									    				stmt.setString(1,bookid);
									    			    stmt.executeUpdate();
									    			    
										    			   returnIssueIdField.setText("");
										    			
										    			   returnBookID.setText("");
								    					   returnIssueID.setText("");
								    					   
								    					   returnFineField.setText("  ---"); 
								    					   returnDaysField.setText("  ---"); 
								    					   returnBookNameField.setText("  ---");
								    					   returnStudentNameField.setText("  ---");
								    					   returnReturnDateField.setText("  ---");
								    					   returnIssueDateField.setText("  ---");
								    		
								    				}else {
								    					
								    					JFrame f = new JFrame(); 
										    			JOptionPane.showMessageDialog(f,"Unable to return,Please try again");
								    					
								    				}
							
									    			 
									    		
								    			}catch(Exception e1){ System.out.println(e1);} 
								        		
								        		
								        	}
								    	
								    	}  
								});
								
								//----------------
								
								//Click Action---
								issueBookSearch.addMouseListener(new MouseAdapter()  
								{  
								        public void mouseClicked(MouseEvent e)  
								        { 
								        	
								        	if(returnIssueIdField.getText() == "") {
								        		 JFrame f = new JFrame(); 
								    			 JOptionPane.showMessageDialog(f,"Please enter the issued ID");	
								        	}else{
								        		
								        		//DB Work - Book Search
								    			try{  
								    				Class.forName("com.mysql.jdbc.Driver");  
								    				
								    			    Connection con = DriverManager.getConnection(  
								    				"jdbc:mysql://localhost:3306/javadb","root","");  
								    			
								    			    
								    			    String IssueID = returnIssueIdField.getText();
								    			    
								    			    PreparedStatement stmt = con.prepareStatement("SELECT issued_book.id as ID,BID as BookID,books.name as BookName,STUID as StudentID,user.name as StudentName,issue_Date,return_Date, GREATEST(DateDiff( now(), return_Date),0) as days_elapsed, GREATEST(DateDiff( now(), return_Date) * 10,0) as fine FROM `issued_book`,`books`,`user` WHERE BID = books.id and STUID = user.id and issued_book.id = ?;"); 
								    				stmt.setString(1,IssueID);
								    				
								    				ResultSet rs = stmt.executeQuery();  
								    				
								    				
								    				if(rs.next()) {
								    				
								    					
								    					   String bookname = rs.getString("BookName");
								    					   String studentname = rs.getString("StudentName");
								    					   String issuedate = rs.getString("issue_Date");
								    					   String returndate = rs.getString("return_Date");
								    					   String fine = rs.getString("fine");
								    					   String dayselapsed = rs.getString("days_elapsed");
								    					   
								    					   returnBookID.setText(rs.getString("BookID"));
								    					   returnIssueID.setText(rs.getString("id"));
								    					   
								    					   returnFineField.setText("  ₹"+fine); 
								    					   returnDaysField.setText("  "+dayselapsed); 
								    					   returnBookNameField.setText("  "+bookname);
								    					   returnStudentNameField.setText("  "+studentname);
								    					   returnReturnDateField.setText("  "+returndate);
								    					   returnIssueDateField.setText("  "+issuedate);
								    					   
								    					   con.close();
								    					
								    				}else {
								    					JFrame f = new JFrame(); 
										    			JOptionPane.showMessageDialog(f,"Please enter a valid Issued ID");
										    			returnIssueIdField.setText("");
										    			
										    			   returnBookID.setText("");
								    					   returnIssueID.setText("");
								    					   
								    					   returnFineField.setText("  ---"); 
								    					   returnDaysField.setText("  ---"); 
								    					   returnBookNameField.setText("  ---");
								    					   returnStudentNameField.setText("  ---");
								    					   returnReturnDateField.setText("  ---");
								    					   returnIssueDateField.setText("  ---");
								    					   
										    			con.close();
								    				}
								    				
									    		
								    			}catch(Exception e1){ System.out.println(e1);} 
								        		
								        	}
								        	
								        	
							    			
								        }
								  });
									
								//===============
								
								
								
								
								
							//===============
							RightSideBar.add(returnBookPanel);
				
							
				add(RightSideBar);
		 //=========================
	     //Code Here======================================
		 //=========================
				
	     //All Menu Actions
				viewUserbtn.addMouseListener(new MouseAdapter()  
				{  
				        public void mouseClicked(MouseEvent e)  
				        {  
				           
				        	
				        	//DB Work - check for valid user
			    			try{  
			    				Class.forName("com.mysql.jdbc.Driver");  
			    				
			    			    Connection con = DriverManager.getConnection(  
			    				"jdbc:mysql://localhost:3306/javadb","root","");  







			    				PreparedStatement stmt = con.prepareStatement("select id as ID,name as Name,email as Email,phone as Phone from user where role = 'member' "); 
			    			
			    				
			    				ResultSet rs = stmt.executeQuery();  

		
			    				 JTable jt = new JTable();    
			    				 jt.setModel(DbUtils.resultSetToTableModel(rs));
				    			
			    				 jt.setFont(new Font("Calibri", Font.PLAIN, 18));
				    			 jt.getTableHeader().setBackground(new Color(86, 97, 119));
				    			 jt.getTableHeader().setForeground(Color.white);
				    			 jt.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
				    			 jt.setRowHeight(50);
				    			 jt.setRowMargin(30);
				    			 
				    			 JLabel lable = new JLabel("All Members");
				    			 lable.setBounds(10,0,300,100);
				    			 lable.setFont(new Font("Calibri", Font.PLAIN, 25));
				    			 
				    			 JScrollPane scrollPane = new  JScrollPane(jt);
				    			 scrollPane.setBounds(0,100,900,600);
				    			 
				    			//Enable View Users Tab
					        
					        
					        	 viewUserPanel.add(scrollPane);
					        	 viewUserPanel.add(lable);
					        	 
					        	 //Set All Panels
					        	 viewUserPanel.setVisible(true);
					        	 addbookPanel.setVisible(false);
					        	 dashboardPanel.setVisible(false);
					        	 viewBooksPanel.setVisible(false);
					        	 issueBookPanel.setVisible(false);
					        	 viewissueBookPanel.setVisible(false);
					        	 returnBookPanel.setVisible(false);
					        	 
					        	 //set link active style
					        	 dashboardbtn.setForeground(Color.black);
					        	 dashboardbtn.setBackground(Color.white);
					        	 
					        	 viewUserbtn.setForeground(Color.white);
					        	 viewUserbtn.setBackground(new Color(99, 179, 237));
					        	 
					        	 addBook.setForeground(Color.black);
					        	 addBook.setBackground(Color.white);
					        	 
					        	 viewBook.setForeground(Color.black);
					        	 viewBook.setBackground(Color.white);
					        	 
					        	 issuebookbtn.setForeground(Color.black);
					        	 issuebookbtn.setBackground(Color.white);
					        	 
					        	 viewissuebookbtn.setForeground(Color.black);
					        	 viewissuebookbtn.setBackground(Color.white);
					        	 
					        	 returnbookbtn.setForeground(Color.black);
					        	 returnbookbtn.setBackground(Color.white);
					        	
					        	
			    				
			    			}catch(Exception e1){ System.out.println(e1);} 
			    			
			    			   

				        
				        	

				        }  
				}); 
				
				
				addBook.addMouseListener(new MouseAdapter()  
				{  
				        public void mouseClicked(MouseEvent e)  
				        { 
				        
				        	//Set All Panels
				        	 dashboardPanel.setVisible(false);
				        	 viewUserPanel.setVisible(false);
				        	 addbookPanel.setVisible(true);
				        	 viewBooksPanel.setVisible(false);
				        	 issueBookPanel.setVisible(false);
				        	 viewissueBookPanel.setVisible(false);
				        	 returnBookPanel.setVisible(false);
				        	 
				        	 //set link active style
				        	 addBook.setForeground(Color.white);
				        	 addBook.setBackground(new Color(99, 179, 237));
				        	 
				        	 viewUserbtn.setForeground(Color.black);
				        	 viewUserbtn.setBackground(Color.white);
				        	 
				        	 dashboardbtn.setForeground(Color.black);
				        	 dashboardbtn.setBackground(Color.white);
				        	 
				        	 viewBook.setForeground(Color.black);
				        	 viewBook.setBackground(Color.white);
				        	 
				        	 issuebookbtn.setForeground(Color.black);
				        	 issuebookbtn.setBackground(Color.white);
				        	 
				        	 viewissuebookbtn.setForeground(Color.black);
				        	 viewissuebookbtn.setBackground(Color.white);
				        	 
				        	 returnbookbtn.setForeground(Color.black);
				        	 returnbookbtn.setBackground(Color.white);
				        	
				        }  
				});
				
				viewBook.addMouseListener(new MouseAdapter()  
				{  
				        public void mouseClicked(MouseEvent e)  
				        {  
				           
				        	
				        	//DB Work - check for valid user
			    			try{  
			    				Class.forName("com.mysql.jdbc.Driver");  
			    				
			    			    Connection con = DriverManager.getConnection(  
			    				"jdbc:mysql://localhost:3306/javadb","root","");  
			    			
			    				PreparedStatement stmt = con.prepareStatement("select id as ID,name as Name,author as Author,price as Price,qty as Quantity from books"); 
			    			
			    				
			    				ResultSet rs = stmt.executeQuery();  

		
			    				 JTable jt = new JTable();    
			    				 jt.setModel(DbUtils.resultSetToTableModel(rs));
				    			
			    				 jt.setFont(new Font("Calibri", Font.PLAIN, 18));
				    			 jt.getTableHeader().setBackground(new Color(86, 97, 119));
				    			 jt.getTableHeader().setForeground(Color.white);
				    			 jt.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
				    			 jt.setRowHeight(50);
				    			 jt.setRowMargin(30);
				    			 
				    			 JLabel lable = new JLabel("All Books");
				    			 lable.setBounds(10,0,100,100);
				    			 lable.setFont(new Font("Calibri", Font.PLAIN, 25));
				    			 
				    			 JScrollPane scrollPane = new  JScrollPane(jt);
				    			 scrollPane.setBounds(0,100,900,600);
				    			 
				    			//Enable View books Tab
					        
				    			 viewBooksPanel.removeAll();
				    			 viewBooksPanel.add(scrollPane);
				    			 viewBooksPanel.add(lable);
					        	 
					        	 //Set All Panels
				    			 dashboardPanel.setVisible(false);
					        	 viewUserPanel.setVisible(false);
					        	 addbookPanel.setVisible(false);
					        	 viewBooksPanel.setVisible(true);
					        	 issueBookPanel.setVisible(false);
					        	 viewissueBookPanel.setVisible(false);
					        	 returnBookPanel.setVisible(false);
					        	 
					        	 //set link active style
					        	 dashboardbtn.setForeground(Color.black);
					        	 dashboardbtn.setBackground(Color.white);
					        	 
					        	 viewUserbtn.setForeground(Color.black);
					        	 viewUserbtn.setBackground(Color.white);
					        	 
					        	 addBook.setForeground(Color.black);
					        	 addBook.setBackground(Color.white);
					        	 
					        	 issuebookbtn.setForeground(Color.black);
					        	 issuebookbtn.setBackground(Color.white);
					        	 
					        	 viewissuebookbtn.setForeground(Color.black);
					        	 viewissuebookbtn.setBackground(Color.white);
					        	 
					        	 returnbookbtn.setForeground(Color.black);
					        	 returnbookbtn.setBackground(Color.white);
					        	 
					        	 //--active
					        	 viewBook.setForeground(Color.white);
					        	 viewBook.setBackground(new Color(99, 179, 237));
					        	
					        	
			    				
			    			}catch(Exception e1){ System.out.println(e1);} 
			    			
			    			   

				        
				        	

				        }  
				}); 
				
				dashboardbtn.addMouseListener(new MouseAdapter()  
				{  
				        public void mouseClicked(MouseEvent e)  
				        { 
				        	
				        	//reload panel
				        	
				        	//DB Work - Number of users
			    			try{  
			    				Class.forName("com.mysql.jdbc.Driver");  
			    				
			    			    Connection con = DriverManager.getConnection(  
			    				"jdbc:mysql://localhost:3306/javadb","root","");  
			    			
			    			    PreparedStatement stmt = con.prepareStatement("select count(*) as count from user"); 
			    	
			    				
			    				ResultSet rs = stmt.executeQuery();  
			    				rs.next();
			    				String numberofUsers = rs.getString(1);
			    				
			    				
			    				
			    				numberUser.setText(numberofUsers);
			    				
			    				con.close();
				    		
			    			}catch(Exception e1){ System.out.println(e1);} 
			    			
			    			//DB Work - Number of Books
			    			try{  
			    				Class.forName("com.mysql.jdbc.Driver");  
			    				
			    			    Connection con = DriverManager.getConnection(  
			    				"jdbc:mysql://localhost:3306/javadb","root","");  
			    			
			    			    PreparedStatement stmt = con.prepareStatement("select count(*) as count from books"); 
			    	
			    				
			    				ResultSet rs = stmt.executeQuery();  
			    				rs.next();
			    				String numberofBook = rs.getString(1);
			    				
			    				
			    				
			    				numberBook.setText(numberofBook);
			    				
			    				con.close();
				    		
			    			}catch(Exception e1){ System.out.println(e1);} 
			    			
				        	
				        	//Set All Panels
				        	 dashboardPanel.setVisible(true);
				        	 viewUserPanel.setVisible(false);
				        	 addbookPanel.setVisible(false);
				        	 viewBooksPanel.setVisible(false);
				        	 issueBookPanel.setVisible(false);
				        	 viewissueBookPanel.setVisible(false);
				        	 returnBookPanel.setVisible(false);
				        	 
				        	 //set link active style
				        	 dashboardbtn.setForeground(Color.white);
				        	 dashboardbtn.setBackground(new Color(99, 179, 237));
				        	 
				        	 addBook.setForeground(Color.black);
				        	 addBook.setBackground(Color.white);
				        	 
				        	 viewUserbtn.setForeground(Color.black);
				        	 viewUserbtn.setBackground(Color.white);
				        	 
				        	 viewBook.setForeground(Color.black);
				        	 viewBook.setBackground(Color.white);
				        	 
				        	 issuebookbtn.setForeground(Color.black);
				        	 issuebookbtn.setBackground(Color.white);
				        	 
				        	 viewissuebookbtn.setForeground(Color.black);
				        	 viewissuebookbtn.setBackground(Color.white);
				        	 
				        	 returnbookbtn.setForeground(Color.black);
				        	 returnbookbtn.setBackground(Color.white);
				        	 
				        	 
				        }  
				});
				
				
				issuebookbtn.addMouseListener(new MouseAdapter()  
				{  
				        public void mouseClicked(MouseEvent e)  
				        { 
				        	//Set All Panels
				        	 dashboardPanel.setVisible(false);
				        	 viewUserPanel.setVisible(false);
				        	 addbookPanel.setVisible(false);
				        	 viewBooksPanel.setVisible(false);
				        	 issueBookPanel.setVisible(true);
				        	 viewissueBookPanel.setVisible(false);				        	 
				        	 returnBookPanel.setVisible(false);
				        	 
				        	 //set link active style
				        	 dashboardbtn.setForeground(Color.black);
				        	 dashboardbtn.setBackground(Color.white);
				        	 
				        	 addBook.setForeground(Color.black);
				        	 addBook.setBackground(Color.white);
				        	 
				        	 viewUserbtn.setForeground(Color.black);
				        	 viewUserbtn.setBackground(Color.white);
				        	 
				        	 viewBook.setForeground(Color.black);
				        	 viewBook.setBackground(Color.white);
				        	 
				        	 issuebookbtn.setForeground(Color.white);
				        	 issuebookbtn.setBackground(new Color(99, 179, 237));
				        	 
				        	 viewissuebookbtn.setForeground(Color.black);
				        	 viewissuebookbtn.setBackground(Color.white);
				        	 
				        	 returnbookbtn.setForeground(Color.black);
				        	 returnbookbtn.setBackground(Color.white);
				        }  
				});
				
				viewissuebookbtn.addMouseListener(new MouseAdapter()  
				{  
				        public void mouseClicked(MouseEvent e)  
				        {  
				           
				        	
				        	//DB Work - check for valid user
			    			try{  
			    				Class.forName("com.mysql.jdbc.Driver");  
			    				
			    			    Connection con = DriverManager.getConnection(  
			    				"jdbc:mysql://localhost:3306/javadb","root","");  
			    			
			    				PreparedStatement stmt = con.prepareStatement("SELECT issued_book.id as ID,BID as BookID,books.name as BookName,STUID as StudentID,user.name as StudentName,issue_Date,return_Date, GREATEST(DateDiff( now(), return_Date),0) as Days_Elapsed, GREATEST(DateDiff( now(), return_Date) * 10,0) as Fine FROM `issued_book`,`books`,`user` WHERE BID = books.id and STUID = user.id;"); 
			    			
			    				
			    				ResultSet rs = stmt.executeQuery();  

		
			    				 JTable jt = new JTable();    
			    				 jt.setModel(DbUtils.resultSetToTableModel(rs));
				    			
			    				 jt.setFont(new Font("Calibri", Font.PLAIN, 18));
				    			 jt.getTableHeader().setBackground(new Color(86, 97, 119));
				    			 jt.getTableHeader().setForeground(Color.white);
				    			 jt.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
				    			 jt.setRowHeight(50);
				    			 jt.setRowMargin(30);
				    			 
				    			 JLabel lable = new JLabel("Issued Books");
				    			 lable.setBounds(10,0,300,100);
				    			 lable.setFont(new Font("Calibri", Font.PLAIN, 25));
				    			 
				    			 JScrollPane scrollPane = new  JScrollPane(jt);
				    			 scrollPane.setBounds(0,100,900,600);
				    			 
				    			//Enable View books Tab
					        
				    			 viewissueBookPanel.removeAll();
				    			 viewissueBookPanel.add(scrollPane);
				    			 viewissueBookPanel.add(lable);
					        	 
					        	 //Set All Panels
				    			 dashboardPanel.setVisible(false);
					        	 viewUserPanel.setVisible(false);
					        	 addbookPanel.setVisible(false);
					        	 viewBooksPanel.setVisible(false);
					        	 issueBookPanel.setVisible(false);
					        	 viewissueBookPanel.setVisible(true);					        	 
					        	 returnBookPanel.setVisible(false);
					        	 
					        	 //set link active style
					        	 dashboardbtn.setForeground(Color.black);
					        	 dashboardbtn.setBackground(Color.white);
					        	 
					        	 viewUserbtn.setForeground(Color.black);
					        	 viewUserbtn.setBackground(Color.white);
					        	 
					        	 addBook.setForeground(Color.black);
					        	 addBook.setBackground(Color.white);
					        	 
					        	 issuebookbtn.setForeground(Color.black);
					        	 issuebookbtn.setBackground(Color.white);
					        	 
					        	 viewBook.setForeground(Color.black);
					        	 viewBook.setBackground(Color.white);
					        	 
					        	 returnbookbtn.setForeground(Color.black);
					        	 returnbookbtn.setBackground(Color.white);
					        	 
					        	 //--active
					        	 viewissuebookbtn.setForeground(Color.white);
					        	 viewissuebookbtn.setBackground(new Color(99, 179, 237));
			    				
			    			}catch(Exception e1){ System.out.println(e1);} 
			    			
			    			   

				        
				        	

				        }  
				}); 
				
				returnbookbtn.addMouseListener(new MouseAdapter()  
				{  
				        public void mouseClicked(MouseEvent e)  
				        { 
				        	//Set All Panels
				        	 dashboardPanel.setVisible(false);
				        	 viewUserPanel.setVisible(false);
				        	 addbookPanel.setVisible(false);
				        	 viewBooksPanel.setVisible(false);
				        	 issueBookPanel.setVisible(false);
				        	 viewissueBookPanel.setVisible(false);
				        	 returnBookPanel.setVisible(true);
				        	
				        	 
				        	 //set link active style
				        	 dashboardbtn.setForeground(Color.black);
				        	 dashboardbtn.setBackground(Color.white);
				        	 
				        	 addBook.setForeground(Color.black);
				        	 addBook.setBackground(Color.white);
				        	 
				        	 viewUserbtn.setForeground(Color.black);
				        	 viewUserbtn.setBackground(Color.white);
				        	 
				        	 viewBook.setForeground(Color.black);
				        	 viewBook.setBackground(Color.white);
				        	 
				        	 issuebookbtn.setForeground(Color.black);
				        	 issuebookbtn.setBackground(Color.white);
				        	 
				        	 viewissuebookbtn.setForeground(Color.black);
				        	 viewissuebookbtn.setBackground(Color.white);
				        	 
				        	 returnbookbtn.setForeground(Color.white);
				        	 returnbookbtn.setBackground(new Color(99, 179, 237));
				        	 
				        	 //Set all Text
				        	 
				        	   returnIssueIdField.setText("");
				    			
			    			   returnBookID.setText("");
	    					   returnIssueID.setText("");
	    					   
	    					   returnFineField.setText("  ---"); 
	    					   returnDaysField.setText("  ---"); 
	    					   returnBookNameField.setText("  ---");
	    					   returnStudentNameField.setText("  ---");
	    					   returnReturnDateField.setText("  ---");
	    					   returnIssueDateField.setText("  ---");
				        }  
				});
				
				
				logout.addMouseListener(new MouseAdapter()  
				{  
				        public void mouseClicked(MouseEvent e)  
				        { 
				        	new loginform(); 
				    		dispose();
				        }  
				});
				
				
				
				
				
//==================================
		 setLayout(null); 
		 
		 //center Location
		 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		 setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		 
		 setVisible(true);
	}

}

