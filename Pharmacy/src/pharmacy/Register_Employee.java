package pharmacy;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 *
 * @author Mahmud
 */
class Register_Employee extends JFrame
{

    private Container c;
    private JLabel id, frstname, lstname, psw, rpsw, uname, contno, gndr, adrr;
    private JButton reg, cncl, login,home,back;
    private JTextField id1, frstname1, lstname1, uname1, contno1;
    private JPasswordField pass, rpass;
    private JTextArea adrs;
    private JRadioButton male, female;
    private Font f;
    private ButtonGroup grp;

    public Register_Employee() {
        initComponents();
    }

    public void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200, 50, 700, 650);
        this.setTitle("Sign-Up Form");
        this.setResizable(false);
        f = new Font("Arial", Font.ITALIC, 17);
        grp = new ButtonGroup();

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.cyan);
        
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

        id = new JLabel("ID :");
        id.setBounds(230, 70, 140, 20);
        id.setFont(f);
        id.setForeground(Color.BLACK);
        c.add(id);
        id1 = new JTextField();
        id1.setBounds(270, 70, 160, 30);
        id1.setFont(f);
        id1.setForeground(Color.BLACK);
        c.add(id1);

        frstname = new JLabel("First Name :");
        frstname.setBounds(160, 120, 140, 30);
        frstname.setForeground(Color.BLACK);
        frstname.setFont(f);
        c.add(frstname);
        frstname1 = new JTextField();
        frstname1.setBounds(270, 120, 160, 30);
        frstname1.setForeground(Color.BLACK);
        frstname1.setFont(f);
        c.add(frstname1);

        lstname = new JLabel("Last Name :");
        lstname.setBounds(160, 170, 140, 30);
        lstname.setForeground(Color.BLACK);
        lstname.setFont(f);
        c.add(lstname);
        lstname1 = new JTextField();
        lstname1.setBounds(270, 170, 160, 30);
        lstname1.setForeground(Color.BLACK);
        lstname1.setFont(f);
        c.add(lstname1);

        uname = new JLabel("Username :");
        uname.setBounds(165, 220, 140, 30);
        uname.setForeground(Color.BLACK);
        uname.setFont(f);
        c.add(uname);
        uname1 = new JTextField();
        uname1.setBounds(270, 220, 160, 30);
        uname1.setForeground(Color.BLACK);
        uname1.setFont(f);
        c.add(uname1);

        psw = new JLabel("Password :");
        psw.setBounds(170, 270, 140, 30);
        psw.setForeground(Color.BLACK);
        psw.setFont(f);
        c.add(psw);
        pass = new JPasswordField();
        pass.setBounds(270, 270, 160, 30);
        pass.setForeground(Color.BLACK);
        pass.setFont(f);
        c.add(pass);

        rpsw = new JLabel("Re-Type Password :");
        rpsw.setBounds(100, 320, 180, 30);
        rpsw.setForeground(Color.BLACK);
        rpsw.setFont(f);
        c.add(rpsw);
        rpass = new JPasswordField();
        rpass.setBounds(270, 320, 160, 30);
        rpass.setForeground(Color.BLACK);
        rpass.setFont(f);
        c.add(rpass);

        contno = new JLabel("Contact No :");
        contno.setBounds(160, 370, 140, 30);
        contno.setForeground(Color.BLACK);
        contno.setFont(f);
        c.add(contno);
        contno1 = new JTextField();
        contno1.setBounds(270, 370, 160, 30);
        contno1.setForeground(Color.BLACK);
        contno1.setFont(f);
        c.add(contno1);

        gndr = new JLabel("Gender :");
        gndr.setBounds(190, 420, 140, 30);
        gndr.setForeground(Color.BLACK);
        gndr.setFont(f);
        c.add(gndr);
        male = new JRadioButton("Male");
        male.setBounds(270, 420, 70, 30);
        male.setForeground(Color.BLACK);
        c.add(male);
        female = new JRadioButton("Female");
        female.setBounds(360, 420, 70, 30);
        female.setForeground(Color.BLACK);
        c.add(female);
        grp.add(male);
        grp.add(female);

        adrr = new JLabel("Address :");
        adrr.setBounds(180, 470, 140, 30);
        adrr.setForeground(Color.BLACK);
        adrr.setFont(f);
        c.add(adrr);
        adrs = new JTextArea();
        adrs.setBounds(270, 470, 160, 50);
        adrs.setForeground(Color.BLACK);
        adrs.setLineWrap(true);
        adrs.setWrapStyleWord(true);
        adrs.setFont(f);
        c.add(adrs);

        reg = new JButton("Register");
        reg.setBounds(500, 200, 100, 50);
        reg.setForeground(Color.BLACK);
        reg.setFont(f);
        c.add(reg);

        cncl = new JButton("Cancel");
        cncl.setBounds(500, 260, 100, 50);
        cncl.setForeground(Color.BLACK);
        cncl.setFont(f);
        c.add(cncl);

        /*login = new JButton("Already have an account?");
        login.setBounds(50, 440, 250, 20);
        login.setForeground(Color.BLACK);
        login.setFont(f);
        c.add(login);*/

        cncl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.exit(0);
                dispose();
                Login m = new Login();
                m.setVisible(true);
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login login = new Login();
                login.setVisible(true);
            }
        });
         home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login login = new Login();
                login.setVisible(true);
            }
        });
        
        reg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String ab=pass.getText();
                String abc=rpass.getText();
                if(ab.equals(abc)){
                    Connection con = null;
                
                try {
                    
                    
                    /*String username = "Jewel";
                    String password = "11111";
                    String URL = "jdbc:mysql://localhost:3306/pharmacy?useSSL=false";
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    con = DriverManager.getConnection(URL, username, password);*/
                    
                    Class.forName("org.sqlite.JDBC");
                        con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
                         //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
                        
                        
                    System.out.println("SQLServer Connection Successffull");

                    String query = "insert into Employee_List(ID,F_name,L_name,U_name,Pass,Contact,Gender,Address)values(?,?,?,?,?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(query);
                    //ps.executeUpdate();
                    ps.setString(1, id1.getText());
                    ps.setString(2, frstname1.getText());
                    ps.setString(3, lstname1.getText());
                    ps.setString(4, uname1.getText());
                    ps.setString(5, pass.getText());
                    ps.setString(6,contno1.getText());
		     ps.setString(7,grp.getElements().nextElement().getText());
                     ps.setString(8,adrs.getText());
		     ps.executeUpdate();
                   
           JOptionPane.showMessageDialog(null,"Added Successfully");
                    con.close();
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex);
                    //System.out.println(ex);
                }
            }
                else
                {
                    JOptionPane.showMessageDialog(null,"Password doesn't match");
                }
            }
            
        });

    }

    public static void main(String[] args) {

        Register_Employee frame = new Register_Employee();
        frame.setVisible(true);

    }

}
