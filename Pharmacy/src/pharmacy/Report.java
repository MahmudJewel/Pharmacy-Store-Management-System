package pharmacy;


import java.sql.*;
//import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Mahmud
 */
class Report extends JFrame{
    
    private Container c;
    private JLabel report,medcn;
    private JTextField report1,medcn1,mname1,qntty1;
    private JButton back,view,view1,home;
    private Font f;
    private JPasswordField pass1;
    private JTable table,table1;
    private DefaultTableModel model,model1;
    private JScrollPane scrl,scrl1;
    //private String[] col={"Sale_ID","Date","User_Name","Disease_Name","Medicine_Name","Unit_Price","Quantity","Price"};
    
    //private String[] rows=new String[8];

     //private String[] cols ={"ID","Medicine_Name","Unit_Price","Quantity"};
    //private String[] rows1=new String[4];
   private void table1(){
        try {
            Connection con=null;
        
               /*Class.forName("com.mysql.jdbc.Driver");
            con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?useSSL=false","Jewel","11111");
        */
               
               Class.forName("org.sqlite.JDBC");
                        con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
                         //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
                        
               
               String query="select * from sale_details ";
           PreparedStatement pst=con.prepareStatement(query);
          ResultSet rs=pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));}
     catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex);
                }  
}
     /*private void table2(){
        try {
            Connection con=null;
        
               Class.forName("com.mysql.jdbc.Driver");
            con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy","Jewel","11111");
               
                    String query = "select * from req_medicine";
               PreparedStatement pst = con.prepareStatement(query);
               ResultSet rs = pst.executeQuery();
                   
            table1.setModel(DbUtils.resultSetToTableModel(rs));}
     catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex);
                }  
}*/

    Report()
    {
        initComponents();
        table1();
       // table2();
    }
    public void initComponents()
    {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setBounds(200,50,900,450);
      this.setTitle("View Report");
       this.setResizable(false);  
     
      
      c=this.getContentPane();
      c.setLayout(null);
      c.setBackground(Color.LIGHT_GRAY);
        f= new Font("Arial",Font.ITALIC,17);
      
       table = new JTable();
        model=new DefaultTableModel();
        //model.setColumnIdentifiers(col);
        table.setModel(model);
        table.setFont(f);
        table.setForeground(Color.BLACK);
        table.setSelectionBackground(Color.CYAN);
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
   
       scrl=new JScrollPane(table);
       scrl.setBounds(15,60,850,300);
       c.add(scrl);
       
        /*table1 = new JTable();
        model1=new DefaultTableModel();
        model1.setColumnIdentifiers(cols);
        table1.setModel(model1);
        table1.setFont(f);
        table1.setForeground(Color.BLACK);
        table1.setSelectionBackground(Color.CYAN);
        table1.setBackground(Color.WHITE);
        table1.setRowHeight(30);
   
       scrl1=new JScrollPane(table1);
       scrl1.setBounds(15,240,850,100);
       c.add(scrl1);*/
       
        report=new JLabel("Sales Report");
        report.setBounds(400,20,140,20);
         report.setFont(f);
         report.setForeground(Color.BLACK);
        c.add( report);
         
        
      /*medcn=new  JLabel("Required Medicine");
        medcn.setBounds(400,210,150,20);
         medcn.setForeground(Color.BLACK);
        medcn.setFont(f);
        c.add( medcn);*/
        
         /*view= new JButton("View");
       view.setBounds(10,210,100,20);
        view.setForeground(Color.BLACK);
        view.setFont(f);
        c.add(view);*/
        
         /*back= new JButton("Back");
        back.setBounds(10,370,100,20);
        back.setForeground(Color.BLACK);
        back.setFont(f);
        c.add(back);*/
         
        home = new JButton("Home");
        home.setBounds(1, 1, 80, 30);
        home.setFont(f);
        home.setForeground(Color.BLACK);
        c.add(home);

        back = new JButton("Back");
        back.setBounds(82, 1, 80, 30);
        back.setFont(f);
        back.setForeground(Color.BLACK);
        c.add(back);
        
  
         
        Handler handler=new Handler();
        back.addActionListener(handler);
        home.addActionListener(handler);
      //view.addActionListener(handler);
      
      
    }
    
    class Handler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==back){
            
                dispose();
                Main_Menu v=new Main_Menu();
                v.setVisible(true);
                
                }
           else if(e.getSource()==home){
            
                dispose();
                Login login = new Login();
                login.setVisible(true);
                
                }

        }
    
    }
    public static void main(String[] args) {
        Report frame=new Report();
        frame.setVisible(true);
        
    }
    
}
