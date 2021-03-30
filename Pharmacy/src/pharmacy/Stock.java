package pharmacy;

//import com.mysql.jdbc.Connection;
//import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.sql.*;

/**
 *
 * @author Mahmud
 */
class Stock extends JFrame {

    private Container c;
    private JLabel id, dname, mname, chname, ctgry, price, qntty, rack, edate, srch;
    private JTextField id1, dname1, mname1, chname1, ctgry1, price1, qntty1, rack1, edates, srch1;
    private JButton add, edit, del, reset, back, view, home;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scrl;
    private Font f, f1;
    private JComboBox cb;
    String pos;
    //private JTextField edate1;
    //private JDateChooser edate1;
    private String[] ctgry2 = {"Tablet", "Capsule", "Syrup", "Injection"};

    private void table1() {
        try {

            Connection con = null;

            /*String username = "Jewel";
            String password = "11111";
            String URL = "jdbc:mysql://localhost:3306/pharmacy?useSSL=false";          // DBName=Database name 
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection(URL, username, password);*/
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
             //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
             
             
            System.out.println("SQLServer Connection Successffull 1");

            String query = "select * from medicine_stock";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));

            con.close();

        } catch (Exception ex) {
            System.out.println("Error!!! 1");
            //JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void table2() {
        try {
            Connection con = null;
            /*String username = "Jewel";
            String password = "11111";
            String URL = "jdbc:mysql://localhost:3306/pharmacy?useSSL=false";          // DBName=Database name 
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection(URL, username, password);*/
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
              //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
              
              
            System.out.println("SQLServer Connection Successffull 2");

            String query = "select * from medicine_stock where ID= ? or Disease_Name=? or Medicine_Name=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, srch1.getText());
            pst.setString(2, srch1.getText());
            pst.setString(3, srch1.getText());
            ResultSet rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));

            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    //private String[] cols = {"ID", "Disease_Name", "Medicine_Name", "Chemical_Name", "Category", "Unit_Price", "Quantity", "Rack_No", "Exp Date"};
    //private String[] rows = new String[9];
    Stock(String unm10) {
        //String U=unm10;
        initComponents(unm10);
        table1();
        table2();
    }

    public void initComponents(String pos) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 50, 980, 680);
        this.setTitle("Medicine Stock");
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.cyan);
        f = new Font("Arial", Font.ITALIC, 17);
        f1 = new Font("Arial", Font.PLAIN, 14);

        table = new JTable();
        model = new DefaultTableModel();
        //model.setColumnIdentifiers(cols);
        table.setModel(model);
        table.setFont(f1);
        table.setForeground(Color.blue);
        table.setSelectionBackground(Color.CYAN);
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);

        scrl = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrl.setBounds(15, 465, 920, 180);
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
        id.setBounds(150, 60, 140, 30);
        id.setFont(f);
        id.setForeground(Color.BLACK);
        c.add(id);
        id1 = new JTextField();
        id1.setBounds(250, 60, 160, 30);
        id1.setFont(f);
        id1.setForeground(Color.BLACK);
        c.add(id1);

        dname = new JLabel("Disease_Name");
        dname.setBounds(100, 100, 140, 30);
        dname.setForeground(Color.BLACK);
        dname.setFont(f);
        c.add(dname);
        dname1 = new JTextField();
        dname1.setBounds(250, 100, 160, 30);
        dname1.setForeground(Color.BLACK);
        dname1.setFont(f);
        c.add(dname1);

        mname = new JLabel("Medicine_Name");
        mname.setBounds(100, 140, 140, 30);
        mname.setForeground(Color.BLACK);
        mname.setFont(f);
        c.add(mname);
        mname1 = new JTextField();
        mname1.setBounds(250, 140, 160, 30);
        mname1.setForeground(Color.BLACK);
        mname1.setFont(f);
        c.add(mname1);

        chname = new JLabel("Chemical_Name");
        chname.setBounds(100, 180, 140, 30);
        chname.setForeground(Color.BLACK);
        chname.setFont(f);
        c.add(chname);
        chname1 = new JTextField();
        chname1.setBounds(250, 180, 160, 30);
        chname1.setForeground(Color.BLACK);
        chname1.setFont(f);
        c.add(chname1);

        ctgry = new JLabel("Category");
        ctgry.setBounds(100, 220, 140, 30);
        ctgry.setForeground(Color.BLACK);
        ctgry.setFont(f);
        c.add(ctgry);
        cb = new JComboBox(ctgry2);
        cb.setBounds(250, 220, 160, 30);
        cb.setForeground(Color.BLACK);
        cb.setFont(f);
        c.add(cb);

        price = new JLabel("Unit_Price");
        price.setBounds(100, 260, 140, 30);
        price.setForeground(Color.BLACK);
        price.setFont(f);
        c.add(price);
        price1 = new JTextField();
        price1.setBounds(250, 260, 160, 30);
        price1.setForeground(Color.BLACK);
        price1.setFont(f);
        c.add(price1);

        qntty = new JLabel("Quantity");
        qntty.setBounds(100, 300, 140, 30);
        qntty.setForeground(Color.BLACK);
        qntty.setFont(f);
        c.add(qntty);
        qntty1 = new JTextField();
        qntty1.setBounds(250, 300, 160, 30);
        qntty1.setForeground(Color.BLACK);
        qntty1.setFont(f);
        c.add(qntty1);

        rack = new JLabel("Rack_No");
        rack.setBounds(100, 340, 140, 30);
        rack.setForeground(Color.BLACK);
        rack.setFont(f);
        c.add(rack);
        rack1 = new JTextField();
        rack1.setBounds(250, 340, 160, 30);
        rack1.setForeground(Color.BLACK);
        rack1.setFont(f);
        c.add(rack1);

        edate = new JLabel("Expire Date");
        edate.setBounds(100, 380, 140, 30);
        edate.setForeground(Color.BLACK);
        edate.setFont(f);
        c.add(edate);
        /*edate1 = new JDateChooser();
        //edate1.setBounds(180, 340, 160, 20);
        //edate1.setForeground(Color.BLACK);
        //edate1.setFont(f);
        //edate1.setDateFormatString("dd-MM-yyyy");
        //c.add(edate1);*/
        edates = new JTextField();
        edates.setBounds(250, 380, 160, 30);
        edates.setForeground(Color.BLACK);
        edates.setFont(f);
        c.add(edates);

        srch = new JLabel("Search :");
        srch.setBounds(470, 350, 80, 40);
        srch.setForeground(Color.BLACK);
        srch.setFont(f);
        c.add(srch);
        srch1 = new JTextField();
        srch1.setBounds(550, 350, 140, 40);
        srch1.setForeground(Color.BLACK);
        srch1.setFont(f);
        c.add(srch1);

        view = new JButton("View");
        view.setBounds(80, 415, 100, 40);
        view.setForeground(Color.BLACK);
        view.setFont(f);
        c.add(view);

        add = new JButton("Add");
        add.setBounds(550, 70, 100, 50);
        add.setForeground(Color.BLACK);
        add.setFont(f);
        c.add(add);

        edit = new JButton("Edit");
        edit.setBounds(550, 140, 100, 50);
        edit.setForeground(Color.BLACK);
        edit.setFont(f);
        c.add(edit);

        del = new JButton("Delete");
        del.setBounds(550, 210, 100, 50);
        del.setForeground(Color.BLACK);
        del.setFont(f);
        c.add(del);

        reset = new JButton("Reset");
        reset.setBounds(550, 280, 100, 50);
        reset.setForeground(Color.BLACK);
        reset.setFont(f);
        c.add(reset);

        /*back = new JButton("Back");
        back.setBounds(10, 610, 100, 30);
        back.setForeground(Color.BLACK);
        back.setFont(f);
        c.add(back);*/
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
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?useSSL=false", "Jewel", "11111");*/

                    Class.forName("org.sqlite.JDBC");
                    con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
                      //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
                      
                      
                    int nrow = table.getSelectedRow();
                    String ids = (table.getModel().getValueAt(nrow, 0).toString());
                    String query = "select * from medicine_stock where ID='" + ids + "'";

                    pst = con.prepareStatement(query);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String id = rs.getString("ID");
                        id1.setText(id);
                        String dname = rs.getString("Disease_Name");
                        dname1.setText(dname);
                        String mname = rs.getString("Medicine_Name");
                        mname1.setText(mname);
                        String chname = rs.getString("Chemical_Name");
                        chname1.setText(chname);
                        String ctgry = cb.getSelectedItem().toString();
                        cb.setSelectedItem(ctgry);
                        String price = rs.getString("Unit_Price");
                        price1.setText(price);
                        String qntty = rs.getString("Quantity");
                        qntty1.setText(qntty);
                        String rack = rs.getString("Rack_No");
                        rack1.setText(rack);
                        String edate = rs.getString("Expire_Date");
                        edates.setText(edate);
                        //((JTextField)edate1.getDateEditor().getUiComponent()).setText(edate);

                    }
                    con.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                /*finally {
                    if (con != null) {
                        try {
                            con.close(); // <-- This is important
                        } catch (SQLException yr) {
                            handle exception 
                        }
                    }
                }*/

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
                try {
                    Connection con = null;
                    PreparedStatement pst = null;
                    ResultSet rs = null;

                    /* Class.forName("com.mysql.jdbc.Driver");
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?useSSL=false", "Jewel", "11111");*/
                    Class.forName("org.sqlite.JDBC");
                    con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
                      //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
                      
                      
                    String query = "select * from medicine_stock where ID= ? or Disease_Name = ? or Medicine_Name= ?";
                    String srch = srch1.getText();
                    pst = con.prepareStatement(query);
                    pst.setString(1, srch);
                    pst.setString(2, srch);
                    pst.setString(3, srch);
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
                String disease = dname1.getText();
                String medicine = mname1.getText();
                String chemical = chname1.getText();
                String category = cb.getSelectedItem().toString();
                String price = price1.getText();
                String quantity = qntty1.getText();
                String rack = rack1.getText();
                String date = edates.getText();
                //String date =((JTextField)edate1.getDateEditor().getUiComponent()).getText();

                Connection con = null;
                PreparedStatement pst = null;
                ResultSet rs = null;
                if (id.equals("") || disease.equals("") || medicine.equals("") || chemical.equals("") || category.equals("") || price.equals("") || quantity.equals("") || rack.equals("") || date.equals("")) {
                    JOptionPane.showMessageDialog(null, "Some Fields Are Empty! ");
                } else {
                    try {
                        /*Class.forName("com.mysql.jdbc.Driver");
                        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?useSSL=false", "Jewel", "11111");
                         */

                        Class.forName("org.sqlite.JDBC");
                        con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
                          //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
                          
                          
                        String query = "insert into medicine_stock values(?,?,?,?,?,?,?,?,?)";

                        pst = con.prepareStatement(query);
                        pst.setString(1, id1.getText());
                        pst.setString(2, dname1.getText());
                        pst.setString(3, mname1.getText());
                        pst.setString(4, chname1.getText());
                        pst.setString(5, cb.getSelectedItem().toString());
                        pst.setString(6, price1.getText());
                        pst.setString(7, qntty1.getText());
                        pst.setString(8, rack1.getText());
                        pst.setString(9, edates.getText());
                        //pst.setString(9, edate1.getText());
                        //pst.setString(9, ((JTextField)edate1.getDateEditor().getUiComponent()).getText());

                        int i = pst.executeUpdate();
                        if (i > 0) {
                            JOptionPane.showMessageDialog(null, "Added Successfully");
                        } else {
                            JOptionPane.showMessageDialog(null, "Not Added");
                        }
                        table1();

                        con.close();

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Medicine or ID Already exist.Edit to increasing Additional medicine.");
                    }
                }
            } else if (e.getSource() == edit) {
                String id = id1.getText();
                String dname = dname1.getText();
                String mname = mname1.getText();
                String chname = chname1.getText();
                String ctgry = cb.getSelectedItem().toString();
                String price = price1.getText();
                String qntty = qntty1.getText();
                String rack = rack1.getText();
                String d = edates.getText();
                //String edate = edate1.getText();
                //String edate = ((JTextField)edate1.getDateEditor().getUiComponent()).getText();

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
                        String query = "update medicine_stock set Disease_Name='" + dname + "',Medicine_Name='" + mname + "',Chemical_Name='" + chname + "',Category='" + ctgry + "',Unit_Price='" + price + "',Quantity='" + qntty + "',Rack_no='" + rack + "',Expire_Date='" + d + "' where ID='" + id + "'";
                        pst = con.prepareStatement(query);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Edited Successfully");
                        table1();

                    }
                    con.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }/*finally {
                    if (con != null) {
                        try {
                            con.close(); // <-- This is important
                        } catch (SQLException yr) {
                           
                        }
                    }
                }*/


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
                        String query = "delete from medicine_stock where id=?";
                        pst = con.prepareStatement(query);
                        pst.setString(1, id2);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Delete Successfully");
                        table1();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                } finally {
                    if (con != null) {
                        try {
                            con.close(); // <-- This is important
                        } catch (SQLException yr) {
                            /* handle exception */
                        }
                    }
                }

            } else if (e.getSource() == reset) {
                id1.setText("");
                dname1.setText("");
                mname1.setText("");
                chname1.setText("");
                cb.setSelectedIndex(0);
                price1.setText("");
                qntty1.setText("");
                rack1.setText("");
                edates.setText("");
                //((JTextField)edate1.getDateEditor().getUiComponent()).setText("");
            } else if (e.getSource() == back) {
                dispose();
                Menu_Employee fr = new Menu_Employee(pos);
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

        Stock stock = new Stock("Jewel");
        stock.setVisible(true);

    }

}
