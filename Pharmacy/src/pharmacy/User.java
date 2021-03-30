package pharmacy;

//import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mahmud
 */
class User extends JFrame {

    private JLabel user, srch, id, fname, lname, cno, gndr, adrs, uname, pass;
    private Container c;
    private Font f;
    private JTextArea adrs1;
    private JTextField srch1, id1, fname1, lname1, cno1, gndr1, uname1, pass1;
    private JButton add, del, edit, back, reset, view, home;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scrl;
    private JRadioButton male, female;
    private ButtonGroup grp;
    private String gender;

    private String[] col = {"ID", "F_name", "L_name", "U_name", "Pass", "Contact", "Gender", "Address"};

    private String[] rows = new String[8];

    private void table1() {
        try {
            Connection con = null;

            /*Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?useSSL=false", "Jewel", "11111");
             */
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
             //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
              
              
            String query = "select * from employee_list";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void table2() {
        try {
            Connection con = null;

            /*Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?useSSL=false", "Jewel", "11111");
             */
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
              //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
              
              
            String query = "select * from employee_list where  ID= ? or  F_name=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, srch1.getText());
            pst.setString(2, srch1.getText());
            ResultSet rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    User() {
        initComponents();
        // table1();
        table2();
    }

    public void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200, 50, 700, 650);
        this.setTitle("User Documents");
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);
        f = new Font("Arial", Font.ITALIC, 17);
        grp = new ButtonGroup();

        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(col);
        table.setModel(model);
        table.setFont(f);
        table.setForeground(Color.BLACK);
        table.setSelectionBackground(Color.CYAN);
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);

        scrl = new JScrollPane(table);
        scrl.setBounds(15, 450, 650, 150);
        c.add(scrl);

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

        id = new JLabel("ID");
        id.setBounds(10, 40, 140, 30);
        id.setFont(f);
        id.setForeground(Color.BLACK);
        c.add(id);
        id1 = new JTextField();
        id1.setBounds(160, 40, 160, 30);
        id1.setFont(f);
        id1.setForeground(Color.BLACK);
        c.add(id1);

        fname = new JLabel("First Name");
        fname.setBounds(10, 75, 140, 30);
        fname.setForeground(Color.BLACK);
        fname.setFont(f);
        c.add(fname);
        fname1 = new JTextField();
        fname1.setBounds(160, 75, 160, 30);
        fname1.setForeground(Color.BLACK);
        fname1.setFont(f);
        c.add(fname1);

        lname = new JLabel("Last Name");
        lname.setBounds(10, 110, 140, 30);
        lname.setForeground(Color.BLACK);
        lname.setFont(f);
        c.add(lname);
        lname1 = new JTextField();
        lname1.setBounds(160, 110, 160, 30);
        lname1.setForeground(Color.BLACK);
        lname1.setFont(f);
        c.add(lname1);

        uname = new JLabel("User Name");
        uname.setBounds(10, 150, 140, 30);
        uname.setForeground(Color.BLACK);
        uname.setFont(f);
        c.add(uname);
        uname1 = new JTextField();
        uname1.setBounds(160, 150, 160, 30);
        uname1.setForeground(Color.BLACK);
        uname1.setFont(f);
        c.add(uname1);

        pass = new JLabel("Password");
        pass.setBounds(10, 190, 140, 30);
        pass.setForeground(Color.BLACK);
        pass.setFont(f);
        c.add(pass);
        pass1 = new JTextField();
        pass1.setBounds(160, 190, 160, 30);
        pass1.setForeground(Color.BLACK);
        pass1.setFont(f);
        c.add(pass1);

        cno = new JLabel("Contact_No");
        cno.setBounds(10, 240, 140, 30);
        cno.setForeground(Color.BLACK);
        cno.setFont(f);
        c.add(cno);
        cno1 = new JTextField();
        cno1.setBounds(160, 240, 160, 30);
        cno1.setForeground(Color.BLACK);
        cno1.setFont(f);
        c.add(cno1);

        gndr = new JLabel("Gender");
        gndr.setBounds(10, 280, 140, 30);
        gndr.setForeground(Color.BLACK);
        gndr.setFont(f);
        c.add(gndr);
        male = new JRadioButton("Male");
        male.setBounds(160, 280, 70, 30);
        male.setForeground(Color.BLACK);
        c.add(male);
        female = new JRadioButton("Female");
        female.setBounds(250, 280, 70, 30);
        female.setForeground(Color.BLACK);
        c.add(female);

        grp.add(male);
        grp.add(female);

        adrs = new JLabel("Address :");
        adrs.setBounds(10, 320, 140, 20);
        adrs.setForeground(Color.BLACK);
        adrs.setFont(f);
        c.add(adrs);
        adrs1 = new JTextArea();
        adrs1.setBounds(160, 320, 160, 35);
        adrs1.setForeground(Color.BLACK);
        adrs1.setLineWrap(true);
        adrs1.setWrapStyleWord(true);
        adrs1.setFont(f);
        c.add(adrs1);

        srch = new JLabel("Search(Name or ID)");
        srch.setBounds(380, 280, 160, 30);
        srch.setForeground(Color.BLACK);
        srch.setFont(f);
        c.add(srch);
        srch1 = new JTextField();
        srch1.setBounds(480, 310, 100, 30);
        srch1.setForeground(Color.BLACK);
        srch1.setFont(f);
        c.add(srch1);

        user = new JLabel("User Documents");
        user.setBounds(220, 400, 150, 20);
        user.setForeground(Color.BLACK);
        user.setFont(f);
        c.add(user);

        add = new JButton("Add");
        add.setBounds(450, 60, 100, 30);
        add.setForeground(Color.BLACK);
        add.setFont(f);
        c.add(add);

        edit = new JButton("Edit");
        edit.setBounds(450, 100, 100, 30);
        edit.setForeground(Color.BLACK);
        edit.setFont(f);
        c.add(edit);

        del = new JButton("Delete");
        del.setBounds(450, 140, 100, 30);
        del.setForeground(Color.BLACK);
        del.setFont(f);
        c.add(del);

        reset = new JButton("Reset");
        reset.setBounds(450, 180, 100, 30);
        reset.setForeground(Color.BLACK);
        reset.setFont(f);
        c.add(reset);

        view = new JButton("View");
        view.setBounds(30, 400, 100, 30);
        view.setForeground(Color.BLACK);
        view.setFont(f);
        c.add(view);

        Handler handler = new Handler();
        add.addActionListener(handler);
        edit.addActionListener(handler);
        del.addActionListener(handler);
        reset.addActionListener(handler);
        back.addActionListener(handler);
        view.addActionListener(handler);
        home.addActionListener(handler);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Connection con = null;
                PreparedStatement pst = null;
                ResultSet rs = null;
                try {
                    /*Class.forName("com.mysql.jdbc.Driver");
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "Jewel", "11111");
                     */

                    Class.forName("org.sqlite.JDBC");
                    con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
                      //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
                      
                      
                    int nrow = table.getSelectedRow();
                    String ids = (table.getModel().getValueAt(nrow, 0).toString());
                    String query = "select * from employee_list where ID='" + ids + "'";
                    pst = con.prepareStatement(query);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String id = rs.getString("ID");
                        id1.setText(id);
                        String fname = rs.getString("F_name");
                        fname1.setText(fname);
                        String lname = rs.getString("L_name");
                        lname1.setText(lname);

                        String uname = rs.getString("U_name");
                        uname1.setText(uname);
                        String pass = rs.getString("Pass");
                        pass1.setText(pass);

                        String gndr1 = rs.getString("Gender");
                        if (male.isSelected()) {
                            female.setSelected(true);
                        } else {
                            male.setSelected(true);
                        }

                        String cno = rs.getString("Contact");
                        cno1.setText(cno);
                        String adrs = rs.getString("Address");
                        adrs1.setText(adrs);

                    }
                    con.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            }
        });
        srch1.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

                Connection con = null;
                PreparedStatement pst = null;
                ResultSet rs = null;
                try {
                    /*Class.forName("com.mysql.jdbc.Driver");
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?useSSL=false", "Jewel", "11111");
                     */

                    Class.forName("org.sqlite.JDBC");
                    con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
                      //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
                      
                      
                    String srch = srch1.getText();
                    String query = "select * from employee_list where   ID= ? or F_name = ?";
                    pst = con.prepareStatement(query);
                    pst.setString(1, srch);
                    pst.setString(2, srch);
                    rs = pst.executeQuery();
                    table2();
                    con.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }

        });

    }

    class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == add) {
                String id = id1.getText();
                String fname = fname1.getText();
                String lname = lname1.getText();
                String uname = uname1.getText();
                String pass = pass1.getText();
                String gndr = male.getText().toString();
                String gndr1 = female.getText().toString();
                String connno = cno1.getText();
                String adrr = adrs1.getText();

                Connection con = null;
                PreparedStatement pst = null;
                ResultSet rs = null;
                if (id.equals("") || fname.equals("") || lname.equals("") || uname.equals("") || pass.equals("") || gndr.equals("") || gndr1.equals("") || connno.equals("") || adrr.equals("")) {
                    JOptionPane.showMessageDialog(null, "Some fields are empty!");
                } else {
                    try {
                        /* Class.forName("com.mysql.jdbc.Driver");
                        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "Jewel", "11111");
                         */

                        Class.forName("org.sqlite.JDBC");
                        con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
                          //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
                          
                          
                        String query = "insert into employee_list values(?,?,?,?,?,?,?,?)";

                        pst = con.prepareStatement(query);
                        pst.setString(1, id1.getText());
                        pst.setString(2, fname1.getText());
                        pst.setString(3, lname1.getText());
                        pst.setString(4, uname1.getText());
                        pst.setString(5, pass1.getText());
                        pst.setString(6, cno1.getText());
                        if (male.isSelected()) {
                            gndr = "Male";
                        }
                        if (female.isSelected()) {
                            gndr = "Female";
                        }

                        pst.setString(7, gndr);
                        //pst.setString(4, cno1.getText());
                        pst.setString(8, adrs1.getText());

                        int i = pst.executeUpdate();
                        if (i > 0) {
                            JOptionPane.showMessageDialog(null, "Added Successfully");
                        } else {
                            JOptionPane.showMessageDialog(null, "Not Added");
                        }
                        table1();
                        con.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "ID or User name Already Exist !");
                    }
                }
            
            } else if (e.getSource() == edit) {

                Connection con = null;
                PreparedStatement pst = null;
                ResultSet rs = null;
                try {
                    /*Class.forName("com.mysql.jdbc.Driver");
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?useSSL=false", "Jewel", "11111");
                     */

                    Class.forName("org.sqlite.JDBC");
                    con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
                      //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
                      
                      
                    int x = JOptionPane.showConfirmDialog(null, "Do you want to edit it", "Edit", JOptionPane.YES_NO_OPTION);
                    if (x == 0) {
                        String ids = id1.getText();
                        String query = ("update employee_list set F_name=?,L_name=?,U_name=?,Pass=?,Contact=?,Gender=?,Address=? where ID='" + ids + "'");
                        pst = con.prepareStatement(query);

                        // pst.setString(1, id1.getText());
                        pst.setString(1, fname1.getText());
                        pst.setString(2, lname1.getText());
                        pst.setString(3, uname1.getText());
                        pst.setString(4, pass1.getText());
                        pst.setString(5, cno1.getText());

                        if (male.isSelected()) {
                            gender = "Male";
                        }
                        if (female.isSelected()) {
                            gender = "Female";
                        }

                        pst.setString(6, gender);
                        pst.setString(7, adrs1.getText());

                        int i = pst.executeUpdate();
                        if (i > 0) {
                            JOptionPane.showMessageDialog(null, "Edited Successfully");
                        } else {
                            JOptionPane.showMessageDialog(null, "Not Edit");
                        }
                        table1();
                      con.close();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                //con.close();
            } else if (e.getSource() == del) {
                String id2 = id1.getText();
                Connection con = null;
                PreparedStatement pst = null;
                ResultSet rs = null;
                try {
                    /*Class.forName("com.mysql.jdbc.Driver");
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?useSSL=false", "Jewel", "11111");
                     */

                    Class.forName("org.sqlite.JDBC");
                    con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
                      //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
                      
                      
                    int x = JOptionPane.showConfirmDialog(null, "Do you want to delete it", "Delete", JOptionPane.YES_NO_OPTION);
                    if (x == 0) {
                        String query = "delete from employee_list where ID=?";
                        pst = con.prepareStatement(query);
                        pst.setString(1, id2);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Delete Successfully");
                        table1();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "You don't delete it !");
                }
            } else if (e.getSource() == reset) {
                id1.setText("");
                fname1.setText("");
                lname1.setText("");
                uname1.setText("");
                pass1.setText("");

                grp.clearSelection();
                cno1.setText("");
                adrs1.setText("");
            } else if (e.getSource() == back) {
                dispose();
                Main_Menu fr = new Main_Menu();
                fr.setVisible(true);
            } else if (e.getSource() == view) {
                table1();
            } else if (e.getSource() == home) {
                dispose();
                Login login = new Login();
                login.setVisible(true);
            }
        }
    }

    public static void main(String[] args) {

        User frame = new User();
        frame.setVisible(true);

    }

}
