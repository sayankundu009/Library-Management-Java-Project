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

public class Admin extends JFrame{
	
	private static final long serialVersionUID = 1L;
    String user_name,user_email,user_username,user_password;
    
	public Admin (String name ,int id) {
		

		//DB Work - Get the current user
		
			try{  
				Class.forName("com.mysql.jdbc.Driver");  
				
			    Connection con = DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/javadb","root","");  
			
				PreparedStatement stmt = con.prepareStatement("select * from test where id = ?"); 
				stmt.setInt(1,id);
			
				
				ResultSet rs = stmt.executeQuery();  

	 
				if(rs.next()) { 
					
					//Set User
					
		    		 user_name = rs.getString("name");
		    		 user_email = rs.getString("name");
		    		 user_username = rs.getString("name");
		    		 user_password = rs.getString("name");
		    		 
				}
		
				
			}catch(Exception e1){ System.out.println(e1);} 
			
			
		 setSize(1200,600); 
		 setResizable(false);
	
		 setTitle("Welcome " + user_name);
		 
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
					JLabel viewissuebookbtn =  new JLabel("<html>&nbsp;&nbsp;&#128221; View Issued Books</html>");  
					viewissuebookbtn.setBounds(0,300, 300,50); 
					viewissuebookbtn.setFont(new Font("Calibri", Font.PLAIN, 22));
					viewissuebookbtn.setForeground(Color.black);
					viewissuebookbtn.setBackground(Color.white);
					viewissuebookbtn.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
					viewissuebookbtn.setOpaque(true);
				    LeftSideBar.add(viewissuebookbtn);
				    
				  //logout------
					JLabel logout =  new JLabel("<html>&nbsp;&nbsp;&#128280; Log out</html>");  
					logout.setBounds(0,350, 300,50); 
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
					
					 // User Card
						JPanel usercard = new JPanel();
						usercard.setBounds(20,20,200,200);    
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
			    			
			    			    PreparedStatement stmt = con.prepareStatement("select count(*) as count from test"); 
			    	
			    				
			    				ResultSet rs = stmt.executeQuery();  
			    				rs.next();
			    				String numberofUsers = rs.getString(1);
			    				
			    				System.out.print(numberofUsers);
			    				
			    				numberUser.setText(numberofUsers);
			    				
			    				con.close();
				    		
			    			}catch(Exception e1){ System.out.println(e1);} 
			    			
			    			usercard.add(numberUser);
								
						dashboardPanel.add(usercard);
						
						
						//Books Card-----
						
						JPanel bookscard = new JPanel();
						bookscard.setBounds(250,20,200,200);    
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
			    			
			    			    PreparedStatement stmt = con.prepareStatement("select count(*) as count from books"); 
			    	
			    				
			    				ResultSet rs = stmt.executeQuery();  
			    				rs.next();
			    				String numberofBook = rs.getString(1);
			    				
			    				System.out.print(numberofBook);
			    				
			    				numberBook.setText(numberofBook);
			    				
			    				con.close();
				    		
			    			}catch(Exception e1){ System.out.println(e1);} 
			    			
			    			bookscard.add(numberBook);
								
						dashboardPanel.add(bookscard);
						
						
						
						
						
					
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
								        		System.out.print(Name);
								        		System.out.print(Author);
								        		System.out.print(Price);
								        		System.out.print(Qty);
								        		
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
								    			    
								    			    PreparedStatement stmt = con.prepareStatement("select * from test where id = ?"); 
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
								        		System.out.print(bookID);
								        		System.out.print(stuID);
								        		System.out.print(issueDate);
								        		System.out.print(returnDate);
								        		
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
			    			
			    				PreparedStatement stmt = con.prepareStatement("select * from test"); 
			    			
			    				
			    				ResultSet rs = stmt.executeQuery();  

		
			    				 JTable jt = new JTable();    
			    				 jt.setModel(DbUtils.resultSetToTableModel(rs));
				    			
				    			 jt.setFont(new Font("Calibri", Font.PLAIN, 18));
				    			 
				    			 JLabel lable = new JLabel("All Users");
				    			 lable.setBounds(10,0,100,100);
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
			    			
			    				PreparedStatement stmt = con.prepareStatement("select * from books"); 
			    			
			    				
			    				ResultSet rs = stmt.executeQuery();  

		
			    				 JTable jt = new JTable();    
			    				 jt.setModel(DbUtils.resultSetToTableModel(rs));
				    			
				    			 jt.setFont(new Font("Calibri", Font.PLAIN, 18));
				    			 
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
			    			
			    			    PreparedStatement stmt = con.prepareStatement("select count(*) as count from test"); 
			    	
			    				
			    				ResultSet rs = stmt.executeQuery();  
			    				rs.next();
			    				String numberofUsers = rs.getString(1);
			    				
			    				System.out.print(numberofUsers);
			    				
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
			    				
			    				System.out.print(numberofBook);
			    				
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
			    			
			    				PreparedStatement stmt = con.prepareStatement("SELECT issued_book.id as ID,BID as BookID,books.name as BookName,STUID as StudentID,test.name as StudentName,issue_Date,return_Date, GREATEST(DateDiff( now(), return_Date),0) as days_elapsed, GREATEST(DateDiff( now(), return_Date) * 10,0) as fine FROM `issued_book`,`books`,`test` WHERE BID = books.id and STUID = test.id;"); 
			    			
			    				
			    				ResultSet rs = stmt.executeQuery();  

		
			    				 JTable jt = new JTable();    
			    				 jt.setModel(DbUtils.resultSetToTableModel(rs));
				    			
				    			 jt.setFont(new Font("Calibri", Font.PLAIN, 18));
				    			 
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
					        	 
					        	 //--active
					        	 viewissuebookbtn.setForeground(Color.white);
					        	 viewissuebookbtn.setBackground(new Color(99, 179, 237));
			    				
			    			}catch(Exception e1){ System.out.println(e1);} 
			    			
			    			   

				        
				        	

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

