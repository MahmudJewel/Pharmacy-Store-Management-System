package pharmacy;


import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Mahmud
 */


class About extends JFrame
{
	JFrame jf;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JButton b1,b2,b3;

	About()
	{
		jf=new JFrame();

		jf.setLayout(null);

		l1 = new JLabel("Pharmacy Store Manangement System");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        l1.setBounds(200, 30, 600, 40);
        l1.setForeground(Color.blue);
        jf.add(l1);

        l2 = new JLabel("This System developed by,");
        //l2.setFont(new Font("Times New Roman",Font.BOLD,20));
        l2.setBounds(100, 150, 600, 40);
        jf.add(l2);

        l3 = new JLabel("Md. Juwel Mahmud");
        l3.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        l3.setBounds(300, 180, 390, 40);
        l3.setForeground(Color.red);
        jf.add(l3);

        l4 = new JLabel("Under the guidance of ");
        //l4.setFont(new Font("Times New Roman", Font.BOLD, 18));
        l4.setForeground(Color.red);
        l4.setBounds(100, 240, 800, 40);
        jf.add(l4);
        
        l10 = new JLabel("Mohammad Ashraful Islam");
        l10.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        l10.setForeground(Color.red);
        l10.setBounds(300, 250, 800, 40);
        jf.add(l10);
        
        l8 = new JLabel("Lecturer");
        l8.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        l8.setForeground(Color.red);
        l8.setBounds(300, 270, 800, 40);
        jf.add(l8);
        
        l9 = new JLabel("Dept. of CSE, MBSTU.");
        l9.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        l9.setForeground(Color.red);
        l9.setBounds(300, 290, 800, 40);
        jf.add(l9);
        

        l5 = new JLabel("In this system we can add details of Medicines,Suppliers & sell Medicines.");
        //l5.setFont(new Font("Times New Roman",Font.BOLD,20));
        l5.setBounds(100, 360, 800, 40);
        jf.add(l5);

        l6 = new JLabel("We can also upadte,delete & search the existing details.");
        //l6.setFont(new Font("Times New Roman",Font.BOLD,20));
        l6.setBounds(100, 400, 800, 40);
        jf.add(l6);

        l7 = new JLabel("It is helpfull for stock of Medicine & whrere we placed the medicine in store & sell Medicines.");
        //l7.setFont(new Font("Times New Roman",Font.BOLD,20));
        l7.setBounds(100, 440, 800, 40);
        jf.add(l7);

        jf.setTitle("About System");
		jf.setSize(900,700);
		jf.setLocation(20,20);
		jf.setResizable(false);
		jf.getContentPane().setBackground(Color.cyan);
		jf.setVisible(true);

	}

	public static void main(String args[])
	{
          new About();

	}
}
