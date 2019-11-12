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
public class Member extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String user_name;
	
	public Member(String name ,int id) {
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
		LeftSideBar.setBounds(0,0,400,600);    
		LeftSideBar.setBackground(new Color(39, 43, 52));
		LeftSideBar.setLayout(null);
		
		//Menu Bar List
			
	
		  //User Icon
		
			JLabel headingIcon =  new JLabel("<html>&#128214;</html>",SwingConstants.CENTER);  
			headingIcon.setBounds(90,20, 200,200); 
			headingIcon.setFont(new Font("Calibri", Font.PLAIN, 150));
			headingIcon.setForeground(Color.white);
			headingIcon.setOpaque(false);
			LeftSideBar.add(headingIcon);
			
		    JLabel headingName =  new JLabel("Welcome to our library",SwingConstants.CENTER);  
		    headingName.setBounds(40,200, 300,50); 
		    headingName.setFont(new Font("Calibri", Font.PLAIN, 25));
		    headingName.setForeground(Color.white);
		    headingName.setOpaque(false);
		    LeftSideBar.add(headingName);
		
		  //View Books------
			JLabel viewBook =  new JLabel("<html>Books</html>",SwingConstants.CENTER);  
			viewBook.setBounds(80,300, 230,50);
			viewBook.setFont(new Font("Calibri", Font.PLAIN, 22));
			viewBook.setForeground(Color.white);
			viewBook.setBackground(new Color(99, 179, 237));
			viewBook.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
			viewBook.setOpaque(true);
		    LeftSideBar.add(viewBook);
		
		
		    
		  //View Issued Books------
			JLabel viewissuebookbtn =  new JLabel("<html>My Books</html>",SwingConstants.CENTER);  
			viewissuebookbtn.setBounds(80,370, 230,50);
			viewissuebookbtn.setFont(new Font("Calibri", Font.PLAIN, 22));
			viewissuebookbtn.setForeground(Color.white);
			viewissuebookbtn.setBackground(new Color(99, 179, 237));
			viewissuebookbtn.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
			viewissuebookbtn.setOpaque(true);
		    LeftSideBar.add(viewissuebookbtn);
		 
		    
		  //logout------
			JLabel logout =  new JLabel("<html>Log out </html>",SwingConstants.CENTER);  
			logout.setBounds(80,440, 230,50);
			logout.setFont(new Font("Calibri", Font.PLAIN, 22));
			logout.setForeground(Color.white);
			logout.setBackground(new Color(99, 179, 237));
			logout.setOpaque(true);
		    logout.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		    LeftSideBar.add(logout);
		    
		    
		   
		    
			
		add(LeftSideBar);
		
		//Right Side Panel===
		
		JPanel RightSideBar = new JPanel(); 
		RightSideBar.setBounds(400,0,900,600);    
		RightSideBar.setLayout(null);
		
	    //	&#128075;HAND WAVE
		
			//Welcome Panel
			
			JPanel welcomePanel = new JPanel(); 
			welcomePanel.setBounds(0,0,800,600);    
			welcomePanel.setBackground(new Color(231, 234, 243));
			welcomePanel.setLayout(null);
			welcomePanel.setVisible(true);
			

				JLabel dashboardText =  new JLabel(String.format("<html>Hi! %s <br><br> <font size=6>Welcome to our library"
						+ ", Here you can see all the books which are <br> available at our library and you can also find out about <br> the books which are been issued to you. </font></html>", name) );  
				dashboardText.setBounds(20,0, 800,300); 
				dashboardText.setFont(new Font("Calibri", Font.PLAIN, 40));
				dashboardText.setForeground(new Color(74, 85, 104));
				welcomePanel.add(dashboardText);
				

				RightSideBar.add(welcomePanel);
				
				
			//View Books Panel
			
			JPanel viewBooksPanel = new JPanel(); 
			viewBooksPanel.setBounds(0,0,900,600);    
			viewBooksPanel.setBackground(new Color(231, 234, 243));
			viewBooksPanel.setLayout(null);
			viewBooksPanel.setVisible(false);
			RightSideBar.add(viewBooksPanel);
			
			//View Books Panel
			
			JPanel viewissueBookPanel = new JPanel(); 
			viewissueBookPanel.setBounds(0,0,900,600);    
			viewissueBookPanel.setBackground(Color.white);
			viewissueBookPanel.setLayout(null);
			viewissueBookPanel.setVisible(false);
			RightSideBar.add(viewissueBookPanel);
			
			
	    add(RightSideBar);
	    
	    viewBook.addMouseListener(new MouseAdapter()  
		{  
		    	public void mouseEntered(MouseEvent e) {
	                super.mouseEntered(e);
	                
	               
	                viewBook.setBounds(65,300, 260,60);
	    			viewBook.setFont(new Font("Calibri", Font.PLAIN, 22));
	    			viewBook.setForeground(Color.white);
	    			viewBook.setBackground(new Color(99, 179, 237));
	            }
	
	            @Override
	            public void mouseExited(MouseEvent e) {
	                super.mouseExited(e); 
	                
	                if(viewBooksPanel.isVisible()) {
	                	viewBook.setBounds(80,300, 230,50);
		    			viewBook.setFont(new Font("Calibri", Font.PLAIN, 22));
		    			viewBook.setForeground(Color.white);
		    			viewBook.setBackground(new Color(87, 146, 189));
	                }else {
	                	viewBook.setBounds(80,300, 230,50);
		    			viewBook.setFont(new Font("Calibri", Font.PLAIN, 22));
		    			viewBook.setForeground(Color.white);
		    			viewBook.setBackground(new Color(99, 179, 237));
	                }
	                
	            }
	            
		        public void mouseClicked(MouseEvent e)  
		        {  
		           
		        	
		        	//DB Work - check for valid user
	    			try{  
	    				Class.forName("com.mysql.jdbc.Driver");  
	    				
	    			    Connection con = DriverManager.getConnection(  
	    				"jdbc:mysql://localhost:3306/javadb","root","");  
	    			
	    				PreparedStatement stmt = con.prepareStatement("select name as Name,author as Author,price as Price,qty as Stock from books where qty <> 0"); 
	    			
	    				
	    				ResultSet rs = stmt.executeQuery();  


	    				 JTable jt = new JTable();    
	    				 jt.setModel(DbUtils.resultSetToTableModel(rs));
	    				
	    				 
		    			 jt.setFont(new Font("Calibri", Font.PLAIN, 18));
		    			 jt.getTableHeader().setBackground(new Color(86, 97, 119));
		    			 jt.getTableHeader().setForeground(Color.white);
		    			 jt.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
		    			 jt.setRowHeight(45);
		    			 jt.setRowMargin(10);
		    			 jt.setShowHorizontalLines(true);
		    			 jt.setShowVerticalLines(true);
		    			 jt.setIntercellSpacing(new Dimension (20,20));
		    			 
		    			 
		    			 
		    			 JScrollPane scrollPane = new  JScrollPane(jt);
		    			 scrollPane.setBounds(0,0,800,600);
//		    			 scrollPane.setBackground(Color.white);
		    			 scrollPane.getViewport().setBackground(Color.WHITE);
		    			 
		    			//Enable View books Tab
			        
		    			 viewBooksPanel.removeAll();
		    			 viewBooksPanel.add(scrollPane);
		    		
			        	 
			        	 //Set All Panels
		    			
		    			 viewBooksPanel.setVisible(true);
			        	 viewissueBookPanel.setVisible(false);	
			        	 welcomePanel.setVisible(false);
			        	
			        	 
			        	 viewissuebookbtn.setForeground(Color.white);
			 			 viewissuebookbtn.setBackground(new Color(99, 179, 237));
			        	 
			        	 //--active
			 			viewBook.setBounds(80,300, 230,50);
		    			viewBook.setFont(new Font("Calibri", Font.PLAIN, 22));
		    			viewBook.setForeground(Color.white);
		    			viewBook.setBackground(new Color(87, 146, 189));
			        	
			        	
	    				
	    			}catch(Exception e1){ System.out.println(e1);} 
	    			
	    			   

		        
		        	

		        }  
		}); 
	    
	    viewissuebookbtn.addMouseListener(new MouseAdapter()  
		{  
		    	@Override
	            public void mouseEntered(MouseEvent e) {
	                super.mouseEntered(e);
	                
	                viewissuebookbtn.setBounds(65,370, 260,60);
	    			viewissuebookbtn.setFont(new Font("Calibri", Font.PLAIN, 22));
	    			viewissuebookbtn.setForeground(Color.white);
	    			viewissuebookbtn.setBackground(new Color(99, 179, 237));
	            }
	
	            @Override
	            public void mouseExited(MouseEvent e) {
	                super.mouseExited(e); 
	                
	                if(viewissueBookPanel.isVisible()) {
	                    viewissuebookbtn.setBounds(80,370, 230,50);
		    			viewissuebookbtn.setFont(new Font("Calibri", Font.PLAIN, 22));
		    			viewissuebookbtn.setForeground(Color.white);
		    			viewissuebookbtn.setBackground(new Color(87, 146, 189));
	                }else {
	                	viewissuebookbtn.setBounds(80,370, 230,50);
		    			viewissuebookbtn.setFont(new Font("Calibri", Font.PLAIN, 22));
		    			viewissuebookbtn.setForeground(Color.white);
		    			viewissuebookbtn.setBackground(new Color(99, 179, 237));
	                }
	                
	            }
	            
		        public void mouseClicked(MouseEvent e)  
		        {  
		           
		        	
		        	//DB Work - check for valid user
	    			try{  
	    				Class.forName("com.mysql.jdbc.Driver");  
	    				
	    			    Connection con = DriverManager.getConnection(  
	    				"jdbc:mysql://localhost:3306/javadb","root","");  
	    			
	    				PreparedStatement stmt = con.prepareStatement("SELECT books.name as BookName,STUID as StudentID,user.name as StudentName,issue_Date as Issued_Date,return_Date as Return_Date, GREATEST(DateDiff( now(), return_Date),0) as Days_Elapsed, GREATEST(DateDiff( now(), return_Date) * 10,0) as Fine FROM `issued_book`,`books`,`user` WHERE BID = books.id and STUID = user.id and STUID = ? ;"); 
	    				stmt.setInt(1,id);
	    				
	    				ResultSet rs = stmt.executeQuery();  


	    				 JTable jt = new JTable();    
	    				 jt.setModel(DbUtils.resultSetToTableModel(rs));
		    			
		    			
		    			 jt.setFont(new Font("Calibri", Font.PLAIN, 18));
		    			 jt.getTableHeader().setBackground(new Color(86, 97, 119));
		    			 jt.getTableHeader().setForeground(Color.white);
		    			 jt.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 18));
		    			 jt.setRowHeight(50);
		    			 jt.setRowMargin(30);
		    			 jt.setShowHorizontalLines(true);
		    			 jt.setShowVerticalLines(true);
		    			 jt.setIntercellSpacing(new Dimension (20,20));
		    			 
		    			 JLabel lable = new JLabel("My Books");
		    			 lable.setBounds(10,0,300,100);
		    			 lable.setFont(new Font("Calibri", Font.PLAIN, 30));
		    			 lable.setForeground(new Color(74, 85, 104));
		    			 
		    			 JScrollPane scrollPane = new  JScrollPane(jt);
		    			 scrollPane.setBounds(0,100,800,600);
		    			 scrollPane.getViewport().setBackground(Color.WHITE);
		    			 
		    			//Enable View books Tab
			        
		    			 viewissueBookPanel.removeAll();
		    			 viewissueBookPanel.add(scrollPane);
		    			 viewissueBookPanel.add(lable);
			        	 
			        	 //Set All Panels
			        	 viewBooksPanel.setVisible(false);
			        	 viewissueBookPanel.setVisible(true);	
			        	 welcomePanel.setVisible(false);
			        	
			        	 
			        	 //set link active style
			        	
			        	//--active
			        	    viewissuebookbtn.setBounds(80,370, 230,50);
			    			viewissuebookbtn.setFont(new Font("Calibri", Font.PLAIN, 22));
			    			viewissuebookbtn.setForeground(Color.white);
			    			viewissuebookbtn.setBackground(new Color(87, 146, 189));
			        	 
			        	 
			        	 viewBook.setForeground(Color.white);
			        	 viewBook.setBackground(new Color(99, 179, 237));
	    				
	    			}catch(Exception e1){ System.out.println(e1);} 
	    			
	    			   

		        
		        	

		        }  
		}); 
	    
	    logout.addMouseListener(new MouseAdapter()  
		{  
		    	@Override
	            public void mouseEntered(MouseEvent e) {
	                super.mouseEntered(e);
	                
	                logout.setBounds(65,440, 260,60);
	    			logout.setFont(new Font("Calibri", Font.PLAIN, 22));
	    			logout.setForeground(Color.white);
	    			logout.setBackground(new Color(99, 179, 237));
	            }
	
	            @Override
	            public void mouseExited(MouseEvent e) {
	                super.mouseExited(e); 
	                
	                logout.setBounds(80,440, 230,50);
	    			logout.setFont(new Font("Calibri", Font.PLAIN, 22));
	    			logout.setForeground(Color.white);
	    			logout.setBackground(new Color(99, 179, 237));
	            }
	            
		        public void mouseClicked(MouseEvent e)  
		        { 
		        	new loginform(); 
		    		dispose();
		        }  
		});
	//=========================
	//Code Here======================================
	//=========================
	 
	 setLayout(null); 
	 
	 //center Location
	 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	 setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	 
	 setVisible(true);
	}

}
