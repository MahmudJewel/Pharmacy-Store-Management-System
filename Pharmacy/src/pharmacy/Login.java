package pharmacy;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Background;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.View;

/**
 *
 * @author Mahmud
 */
public class Login extends JFrame {

    private Container c;
    private JLabel userLabel, passLabel, l1, l2;
    private Font f;
    private JTextField txt;
    private JPasswordField pass;
    private JButton sign, login, reset, exit, about;
    private JComboBox cb;
    private int cbIndexNumber;
    PreparedStatement ps;
    //Background

    Login() {
        initComponents();
    }

    public void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300, 50, 500, 350);
        this.setTitle("Login Form");
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.cyan);
        f = new Font("Arial", Font.ITALIC, 18);

        about = new JButton("About");
        about.setBounds(1, 1, 100, 30);
        about.setFont(f);
        about.setForeground(Color.BLACK);
        c.add(about);

        l2 = new JLabel("Welcome To ");
        l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        l2.setBounds(190, 10, 600, 40);
        l2.setForeground(Color.blue);
        c.add(l2);

        l1 = new JLabel("Pharmacy Store Manangement System");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        l1.setBounds(40, 35, 600, 40);
        l1.setForeground(Color.blue);
        c.add(l1);

        userLabel = new JLabel();
        userLabel.setText("User Name");
        userLabel.setBounds(50, 90, 100, 20);
        //userLabel.setBackground(Color.cyan);
        userLabel.setFont(f);
        userLabel.setForeground(Color.black);
        c.add(userLabel);

        passLabel = new JLabel();
        passLabel.setText("Password");
        passLabel.setBounds(50, 150, 100, 20);
        passLabel.setFont(f);
        passLabel.setForeground(Color.BLACK);
        c.add(passLabel);

        txt = new JTextField();
        txt.setBounds(170, 90, 150, 30);
        txt.setFont(f);
        c.add(txt);

        pass = new JPasswordField();
        pass.setBounds(170, 150, 150, 30);
        pass.setEchoChar('*');
        pass.setFont(f);
        c.add(pass);
        String[] s = {"Admin", "Employee"};
        cb = new JComboBox(s);
        cb.setBounds(170, 190, 100, 40);
        cb.setFont(f);
        c.add(cb);

        sign = new JButton("Sign Up");
        sign.setBounds(60, 250, 120, 50);
        //sign.setBackground(Color.cyan);
        sign.setFont(f);
        c.add(sign);

        login = new JButton("Login");
        login.setBounds(240, 250, 110, 50);
        login.setFont(f);
        //login.setBackground(Color.cyan);
        c.add(login);

        reset = new JButton("Reset");
        reset.setBounds(350, 90, 100, 50);
        reset.setFont(f);
        //reset.setBackground(Color.cyan);
        c.add(reset);
        exit = new JButton("Exit");
        exit.setBounds(350, 150, 100, 50);
        //exit.setBackground(Color.cyan);
        exit.setFont(f);
        c.add(exit);

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt.setText("");
                pass.setText("");
            }
        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = txt.getText();
                String password = pass.getText();

                cbIndexNumber = cb.getSelectedIndex();

                if (cbIndexNumber == 0) {  //Login for admin.
                    int foundrec = 0;
                    Connection con;
                    try {

                        Class.forName("org.sqlite.JDBC");
                        con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
                        //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db");  
                        
                        /*Class.forName("com.mysql.jdbc.Driver");
                        String user1 = "Jewel";
                        String pass1 = "11111";
                        String URL = "jdbc:mysql://localhost:3306/pharmacy?useSSL=false";
                        con = DriverManager.getConnection(URL, user1, pass1);*/
                        System.out.println("Connected to database as Admin");

                        ps = con.prepareStatement("select pass from admin_panel where U_name='" + txt.getText() + "'");
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {

                            foundrec = 1;
                            if (rs.getString("pass").equals(pass.getText())) {
                                JOptionPane.showMessageDialog(null, "Login Successfully as an Admin");
                                con.close();
                                dispose();
                                Main_Menu mn = new Main_Menu();
                                //setVisible(false);
                                mn.setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid Password !!", "Dialog", JOptionPane.WARNING_MESSAGE);
                            }

                        }
                        if (foundrec == 0) {
                            JOptionPane.showMessageDialog(null, "Username not available", "Dialog", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                } //Login for Employee.
                else {
                    int foundrec = 0;
                    Connection con;
                    try {
                        Class.forName("org.sqlite.JDBC");
                        con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
                       //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
                        
                        /*Class.forName("com.mysql.jdbc.Driver");
                        String user1 = "Jewel";
                        String pass1 = "11111";
                        String URL = "jdbc:mysql://localhost:3306/pharmacy?useSSL=false";
                        con = DriverManager.getConnection(URL, user1, pass1);*/
                        System.out.println("Connected to database");

                        ps = con.prepareStatement("select pass from employee_list where U_name='" + txt.getText() + "'");
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {

                            foundrec = 1;
                            if (rs.getString("pass").equals(pass.getText())) {
                                JOptionPane.showMessageDialog(null, "Login Successfully as an employee");
                                con.close();
                                dispose();
                                Menu_Employee mn = new Menu_Employee(txt.getText());
                                //setVisible(false);
                                mn.setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid Password !!", "Dialog", JOptionPane.WARNING_MESSAGE);
                            }

                        }
                        if (foundrec == 0) {
                            JOptionPane.showMessageDialog(null, "Username not available", "Dialog", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }

            }
        });
        sign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbIndexNumber = cb.getSelectedIndex();
                if (cbIndexNumber == 0) {
                    dispose();
                    Register fr = new Register();
                    fr.setVisible(true);
                    //System.out.println(cbIndexNumber);
                } else {
                    dispose();
                    Register_Employee fr = new Register_Employee();
                    fr.setVisible(true);
                    //System.out.println(cbIndexNumber);
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dispose();
                About a = new About();
                // a.setVisible(true);
            }
        });

    }

    public static void main(String[] args) {
        Login frame = new Login();
        frame.setVisible(true);

    }

}
