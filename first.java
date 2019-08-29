
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

class demo extends JFrame implements ActionListener
{
	JLabel name1,phone1,sex1,national1,marital1,dob1;
	String fullname,phone,national,sex,maritalstatus,dob;
	JButton b;
	Font font;
	demo(String fullname,String phone,String sex,String maritalstatus,String national,String dob)
	{	
		this.fullname=fullname;
		this.phone=phone;
		this.sex=sex;
		this.maritalstatus=maritalstatus;
		this.national=national;
		this.dob=dob;
		
		font = new Font("Courier", Font.BOLD,20);
	
		name1=new JLabel();
		phone1=new JLabel();
		sex1=new JLabel();
		national1=new JLabel();
		marital1=new JLabel();
		dob1=new JLabel();
		
		name1.setFont(font);
		phone1.setFont(font);
		sex1.setFont(font);
		national1.setFont(font);
		dob1.setFont(font);
		marital1.setFont(font);

		name1.setBounds(200,140,200,30);
		dob1.setBounds(200,180,200,30);
		phone1.setBounds(200,220,200,30);			
		sex1.setBounds(200,260,200,30);
		marital1.setBounds(200,300,200,30);
		national1.setBounds(200,340,200,30);

		name1.setText(fullname);
		dob1.setText("D.O.B--"+dob);
		phone1.setText("phone--"+phone);
		sex1.setText("gender--"+sex);
		marital1.setText(maritalstatus);
		national1.setText(national+"n");
		
		add(name1);
		add(dob1);
		add(phone1);
		add(sex1);
		add(marital1);
		add(national1);
		
		
		setLayout(null);
		setTitle("Service");
		b=new JButton("back");
		b.addActionListener(this);
		b.setBounds(12,22,100,40);
		add(b);
		setResizable(false);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void actionPerformed(ActionEvent ae)
	{
		new main();
		dispose();
	}
}

class main extends JFrame implements ActionListener
{	
	JTextField tf;
	JPasswordField tf1;
	JLabel l1,l2,l3,l4;
	JButton b,b1;
	Font font;
	main()
	{
		 font = new Font("Courier", Font.BOLD,20);
		setLayout(null);
		tf=new JTextField();
		tf.setFont(font);
		tf1=new JPasswordField();
		tf1.setFont(font);
		l1=new JLabel("Username:");
		l2=new JLabel("Password:");
		l3=new JLabel();
		b=new JButton("login");
		b1=new JButton("sign up");
		
		l1.setBounds(135,100,85,70);
		tf.setBounds(215,115,190,40);
		
		
		l2.setBounds(135,170,85,70);
		tf1.setBounds(215,185,190,40);

		b.setBounds(255,235,115,55);
		b.setActionCommand("login");
		
		l3.setBounds(290,280,260,70);
		l4=new JLabel("don't have any account?");
		
		setResizable(false);
		
		
		
		l4.setBounds(255,340,240,50);
		b1.setBounds(255,390,115,55);
		b1.setActionCommand("signup");
		
		

		

		

		add(l1);
		add(tf);
		add(l2);
		add(tf1);
		add(l3);
		add(b);
		add(l4);
		add(b1);
		tf1.setEchoChar('*');

		tf.setBackground(Color.CYAN);
		tf1.setBackground(Color.CYAN);
	
		setTitle("Login");	
		
		
		b.addActionListener(this);
		b1.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,250,600,600);
		setVisible(true);
		
		
	}
	public static void main(String arg[])
	{
		new main();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String s=tf.getText();
		String s1=String.valueOf(tf1.getPassword());
		JButton btn=(JButton)ae.getSource();
		String s3=btn.getActionCommand();
		if(s3.equalsIgnoreCase("login"))
		{

			String username=tf.getText();
			String pass=tf1.getText();
		
			if(username.equals("") || pass.equals(""))
			{
				JOptionPane.showMessageDialog(this,"enter credentials");
			}
			else
			{
				boolean filecheck=new File(username+".txt").exists();
				
				
				if(filecheck==true)
				{	
					String arr[]=new String[8];
					int i=0;
					String line = null;
					try
					{
					FileInputStream fis = new FileInputStream(username+".txt");
 
								
					BufferedReader br = new BufferedReader(new InputStreamReader(fis));
 
					
					while ((line = br.readLine()) != null) {
					arr[i]=line;
					i++;
					
					}
					br.close();
					}
		
					catch(Exception e){}
 
					
	
					if(pass.equals(arr[1]))
					{
						demo ob=new demo(arr[2],arr[3],arr[4],arr[5],arr[6],arr[7]);
						ob.setVisible(true);
						ob.setBounds(500,250,620,600);
						ob.setTitle("Logged");
						ob.setResizable(false);

						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(this,"incorrect password");
					}
						
   	
				}
				else
				{
					JOptionPane.showMessageDialog(this,"not a existing user");
				}	
					
					
			}
		
		}

		else if(s3.equalsIgnoreCase("signup"))
		{
			signup sgn=new signup();
			
			sgn.setVisible(true);
			sgn.setBounds(500,250,620,600);
			sgn.setTitle("SignUp");
			sgn.setResizable(false);

			dispose();
		}
	  }
	}

class signup extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextField tf,tf1,tf2,tf4;
	

	JPasswordField tf3;
	
	Font font;

	JButton b,b1,b2;	
	Checkbox cb1,cb2,cb3,cb4,cb5,cb6;
	CheckboxGroup cgb,cgb1;
	Choice ch,ch1,ch2,ch3;
	signup()
	{

		font = new Font("Courier", Font.BOLD,20);
		setLayout(null);

		ch=new Choice();
		ch.add("india");
		ch.add("pakistan");
		ch.add("china");
		ch.add("nepal");
		ch.add("sri lanka");
		ch.add("USA");
		ch.add("russia");
		ch.add("others");

		ch1=new Choice();
		ch2=new Choice();
		ch3=new Choice();
		ch1.add("day");
		ch2.add("month");
		ch3.add("year");

		for(int i=1;i<=31;i++)
		{
			ch1.add(String.valueOf(i));
		}
		for(int i=1;i<=12;i++)
		{
			ch2.add(String.valueOf(i));
		}
		for(int i=1947;i<=2015;i++)
		{
			ch3.add(String.valueOf(i));
		}
	
		
		
		
			
		cgb=new CheckboxGroup();
		cgb1=new CheckboxGroup();
		
		cb1=new Checkbox("male",cgb,false);
		cb2=new Checkbox("female",false,cgb);
		cb3=new Checkbox("others",false,cgb);

		cb4=new Checkbox("Married",cgb1,false);
		cb5=new Checkbox("Unmarried",false,cgb1);
		cb6=new Checkbox("others",false,cgb1);
		
		l1=new JLabel("first name:");
		l2=new JLabel("last name:");
		l3=new JLabel("username:");
		l4=new JLabel("password:");
		l5=new JLabel("marital status:");
		l6=new JLabel("nationality:");
		l7=new JLabel("sex:");
		l8=new JLabel("phone no:");
		l9=new JLabel("d.o.b:");
		
		
		tf=new JTextField();
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JPasswordField();
		tf4=new JTextField();


		tf.setFont(font);
		tf1.setFont(font);
		tf2.setFont(font);
		tf3.setFont(font);
		tf4.setFont(font);
		

		b=new JButton("back");
		b1=new JButton("submit");
		b2=new JButton("choose");

		l1.setBounds(135,70,70,40);
		l2.setBounds(135,120,70,40);
		l3.setBounds(135,170,70,40);
		l4.setBounds(135,220,70,40);
		l5.setBounds(135,425,90,40);
		l6.setBounds(135,390,70,40);
		l7.setBounds(135,355,70,40);
		l8.setBounds(135,270,70,40);
		l9.setBounds(135,315,70,40);

		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);

		tf.setBounds(210,70,220,40);
		tf1.setBounds(210,120,220,40);
		tf2.setBounds(210,170,220,40);
		tf3.setBounds(210,220,220,40);
		tf4.setBounds(210,270,220,40);
		tf3.setEchoChar('*');
		tf.setBackground(Color.CYAN);
		tf1.setBackground(Color.CYAN);
		tf2.setBackground(Color.CYAN);
		tf3.setBackground(Color.CYAN);
		tf4.setBackground(Color.CYAN);
		
		add(tf);
		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);

		cb1.setBounds(210,365,50,20);
		cb2.setBounds(278,365,60,20);
		cb3.setBounds(356,365,55,20);
		cb4.setBounds(230,435,60,20);
		cb5.setBounds(305,435,76,20);
		cb6.setBounds(395,435,60,20);
		add(cb1);	
		add(cb2);
		add(cb3);
		add(cb4);
		add(cb5);
		add(cb6);
			
		b.setBounds(16,20,100,30);
		b.setActionCommand("back");
		b1.setActionCommand("submit");
		b1.addActionListener(this);
		b.addActionListener(this);
		b1.setBounds(290,475,80,45);
		add(b);
		add(b1);

		ch.setBounds(210,400,70,90);
		ch1.setBounds(210,323,58,90);
		ch2.setBounds(278,323,68,90);
		ch3.setBounds(356,323,58,90);
		
		add(ch);
		add(ch1);
		add(ch2);
		add(ch3);
	
		
		
		
		
		
			
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
		
	public void actionPerformed(ActionEvent ae)
	{
	 	JButton btn=(JButton)ae.getSource();
		String s=btn.getActionCommand();
		
		if(s.equalsIgnoreCase("back"))
		{
			new main();
			dispose();
		}
		else if(s.equalsIgnoreCase("submit"))
		{  
			
			if(tf.getText().isEmpty() || tf1.getText().isEmpty() || tf2.getText().isEmpty()  || tf3.getText().isEmpty() )
			{
				JOptionPane.showMessageDialog(this,"fill all details"); 
			}
			else if(tf4.getText().length()>10)
			{
				JOptionPane.showMessageDialog(this,"phone digits must be 10");
			}		
			else
			{
				
				try
				{
				FileWriter fw=new FileWriter(tf2.getText()+".txt");
				fw.write(tf2.getText());
				fw.write(System.lineSeparator());
				fw.write(tf3.getText());
				fw.write(System.lineSeparator());
				fw.write(tf.getText()+" "+tf1.getText());
				fw.write(System.lineSeparator());
				fw.write(tf4.getText());
				fw.write(System.lineSeparator());
				Checkbox chbox=cgb.getSelectedCheckbox();
				fw.write(chbox.getLabel());
				fw.write(System.lineSeparator());
				fw.write(cgb1.getSelectedCheckbox().getLabel());
				fw.write(System.lineSeparator());
				fw.write(ch.getSelectedItem());
				fw.write(System.lineSeparator());
				fw.write(ch1.getSelectedItem()+"/"+ch2.getSelectedItem()+"/"+ch3.getSelectedItem());
				
				

				
				
				
										
				
				
				tf.setText("");
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");

				
				fw.close();
				}
				catch(Exception e){}
				JOptionPane.showMessageDialog(this,"successfully registered");
				
			}
				
				
		}
		
		
	}
	
	
}



