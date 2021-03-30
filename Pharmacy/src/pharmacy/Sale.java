package pharmacy;

import java.sql.*;
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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mahmud
 */
class Sale extends JFrame {

    private Container c;
    private JTextField id1, user1, date1, srch1, qntty1, price1, mname1, prices1, scan1;
    private JLabel id, user, date, srch, qntty, price, stock1, sale1, mname, prices, scan, noth;
    private JButton stock, sale, pay, back, view, view1, reset, home;
    private Font f;
    private JTable table, table1;
    private JScrollPane scrl, scrl1;
    private DefaultTableModel model, model1;
    //private JDateChooser edate1;
    private String tc;

    private String[] col = {"Date", "Sale_ID", "User_Name", "Medicine_Name", "Unit_Price", "Quantity", "T_Price"};

    private String[] rows = new String[7];
    private String uname10 = null;
    String pos;

    private void table() {
        try {
            Connection con = null;

            /*Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?useSSL=false", "Jewel", "11111");
             */
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
              //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
            
            String query = "select * from medicine_stock";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void table1() {
        try {
            Connection con = null;

            /*Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?useSSL=false", "Jewel", "11111");
             */
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
              //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
              
              
            String query = "select * from sale_details ";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
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
              
              
            String query = "select * from medicine_stock where Disease_Name=? or Medicine_Name=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, srch1.getText());
            pst.setString(2, srch1.getText());
            //pst.setString(3, srch1.getText());
            ResultSet rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void table3() {
        try {
            Connection con = null;

            /*Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?useSSL=false", "Jewel", "11111");
             */
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
            //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
            
            
            String query = "select * from medicine_stock where ID=? ";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, scan1.getText());
            //pst.setString(2, scan1.getText());
            //pst.setString(3, scan1.getText());
            ResultSet rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /* Sale() {
        initComponents();
        table();

        //table1();
        table2();

    }*/
    Sale(String uname2) {
        initComponents();
        table();

        //table1();
        table2();
        //uname10=uname2;
        user1.setText(uname2);
        pos = uname2;
    }

    public void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200, 50, 910, 650);
        this.setTitle("Sale Management");
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.cyan);
        f = new Font("Arial", Font.ITALIC, 17);

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
        scrl.setBounds(15, 450, 880, 100);
        c.add(scrl);

        table1 = new JTable();
        model1 = new DefaultTableModel();
        //model1.setColumnIdentifiers(cols);
        table1.setModel(model1);
        table1.setFont(f);
        table1.setForeground(Color.BLACK);
        table1.setSelectionBackground(Color.CYAN);
        table1.setBackground(Color.WHITE);
        table1.setRowHeight(30);

        scrl1 = new JScrollPane(table1);
        scrl1.setBounds(15, 290, 880, 100);
        c.add(scrl1);

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

        id = new JLabel("Sale_ID");
        id.setBounds(50, 60, 140, 30);
        id.setFont(f);
        id.setForeground(Color.BLACK);
        c.add(id);
        id1 = new JTextField();
        id1.setBounds(200, 60, 160, 30);
        id1.setFont(f);
        id1.setForeground(Color.BLACK);
        c.add(id1);

        user = new JLabel("User_Name");
        user.setBounds(50, 100, 140, 30);
        user.setForeground(Color.BLACK);
        user.setFont(f);
        c.add(user);
        user1 = new JTextField();
        user1.setBounds(200, 100, 160, 30);
        user1.setForeground(Color.BLACK);
        user1.setFont(f);
        c.add(user1);

        date = new JLabel("Date");
        date.setBounds(50, 180, 140, 30);
        date.setForeground(Color.BLACK);
        date.setFont(f);
        c.add(date);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cld = Calendar.getInstance();
        //cld.setTime(new Date()); // Now use today date.
        //cld.add(Calendar.DATE, 5); // Adding 5 days
        String today = sdf.format(cld.getTime());

        date1 = new JTextField();
        date1.setBounds(200, 180, 160, 30);
        date1.setForeground(Color.BLACK);
        date1.setFont(f);
        date1.setText(today);
        c.add(date1);

        qntty = new JLabel("Quantity");
        qntty.setBounds(50, 140, 140, 30);
        qntty.setForeground(Color.BLACK);
        qntty.setFont(f);
        c.add(qntty);
        qntty1 = new JTextField();
        qntty1.setBounds(200, 140, 160, 30);
        qntty1.setForeground(Color.BLACK);
        qntty1.setFont(f);
        c.add(qntty1);

        mname = new JLabel("Medicine_name");
        mname.setBounds(500, 60, 160, 30);
        mname.setForeground(Color.BLACK);
        mname.setFont(f);
        c.add(mname);
        mname1 = new JTextField();
        mname1.setBounds(670, 60, 160, 30);
        mname1.setForeground(Color.BLACK);
        mname1.setFont(f);
        c.add(mname1);

        prices = new JLabel("Unit_Price");
        prices.setBounds(500, 100, 100, 30);
        prices.setForeground(Color.BLACK);
        prices.setFont(f);
        c.add(prices);
        prices1 = new JTextField();
        prices1.setBounds(670, 100, 160, 30);
        prices1.setForeground(Color.BLACK);
        prices1.setFont(f);
        c.add(prices1);

        noth = new JLabel("Search By");
        noth.setBounds(500, 130, 100, 30);
        noth.setForeground(Color.BLACK);
        noth.setFont(f);
        c.add(noth);

        srch = new JLabel("Disease or Medicine");
        srch.setBounds(510, 150, 160, 30);
        srch.setForeground(Color.BLACK);
        srch.setFont(f);
        c.add(srch);
        srch1 = new JTextField();
        srch1.setBounds(670, 140, 160, 35);
        srch1.setForeground(Color.BLACK);
        srch1.setFont(f);
        c.add(srch1);

        scan = new JLabel("Scanner");
        scan.setBounds(500, 185, 160, 30);
        scan.setForeground(Color.BLACK);
        scan.setFont(f);
        c.add(scan);
        scan1 = new JTextField();
        scan1.setBounds(670, 180, 160, 30);
        scan1.setForeground(Color.BLACK);
        scan1.setFont(f);
        c.add(scan1);

        price = new JLabel("Total_Price");
        price.setBounds(300, 565, 100, 30);
        price.setForeground(Color.BLACK);
        price.setFont(f);
        c.add(price);
        price1 = new JTextField();
        price1.setBounds(410, 565, 160, 30);
        price1.setForeground(Color.BLACK);
        price1.setFont(f);
        c.add(price1);

        stock1 = new JLabel("Medicine Stock Details");
        stock1.setBounds(350, 245, 200, 40);
        stock1.setFont(f);
        stock1.setForeground(Color.BLACK);
        c.add(stock1);

        sale1 = new JLabel("Sale Details");
        sale1.setBounds(370, 400, 140, 30);
        sale1.setFont(f);
        sale1.setForeground(Color.BLACK);
        c.add(sale1);

        pay = new JButton("Payment");
        pay.setBounds(700, 565, 150, 40);
        pay.setForeground(Color.BLACK);
        pay.setFont(f);
        c.add(pay);

        view = new JButton("View");
        view.setBounds(30, 245, 80, 30);
        view.setForeground(Color.BLACK);
        view.setFont(f);
        c.add(view);
        view1 = new JButton("Sale");
        view1.setBounds(30, 400, 80, 40);
        view1.setForeground(Color.BLACK);
        view1.setFont(f);
        c.add(view1);

        reset = new JButton("Reset");
        reset.setBounds(120, 565, 100, 40);
        reset.setForeground(Color.BLACK);
        reset.setFont(f);
        c.add(reset);

        Handler handler = new Handler();
        pay.addActionListener(handler);
        back.addActionListener(handler);
        view.addActionListener(handler);
        view1.addActionListener(handler);
        reset.addActionListener(handler);
        home.addActionListener(handler);

        table1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                int selectedRowIndex = table1.getSelectedRow();
                id1.setText(model.getValueAt(selectedRowIndex, 0).toString());
                mname1.setText(model.getValueAt(selectedRowIndex, 2).toString());
                prices1.setText(model.getValueAt(selectedRowIndex, 5).toString());

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
                    /* Class.forName("com.mysql.jdbc.Driver");
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "Jewel", "11111");
                     */

                    Class.forName("org.sqlite.JDBC");
                    con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
                      //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
                      
                      
                    String srch = srch1.getText();
                    String query = "select * from medicine_stock where Disease_Name =? or Medicine_Name=? ";
                    pst = con.prepareStatement(query);
                    pst.setString(1, srch);
                    pst.setString(2, srch);
                    //pst.setString(3, srch);

                    rs = pst.executeQuery();
                    table2();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }

        });

        scan1.addKeyListener(new KeyListener() {
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
                    /* Class.forName("com.mysql.jdbc.Driver");
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "Jewel", "11111");
                     */

                    Class.forName("org.sqlite.JDBC");
                    con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
                      //con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
                      
                      
                    String srch = scan1.getText();
                    String query = "select * from medicine_stock where  ID=? ";
                    pst = con.prepareStatement(query);
                    pst.setString(1, srch);
                    //pst.setString(2, srch);
                    //pst.setString(3, srch);

                    rs = pst.executeQuery();
                    table3();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }

        });

    }

    class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == pay) {

                String s1 = id1.getText(), s2 = user1.getText(), s3 = date1.getText(), s4 = price1.getText();
                dispose();
                Payment pay = new Payment(s1, s2, s3, s4);
                pay.setVisible(true);

            } else if (e.getSource() == back) {
                String s1 = user1.getText();
                dispose();
                Menu_Employee m = new Menu_Employee(pos);
                m.setVisible(true);
                /*Sales view = new Sales(s1);
                view.setVisible(true);*/

            } else if (e.getSource() == view) {
                table();
            } else if (e.getSource() == reset) {
                table.setModel(new DefaultTableModel(null, new String[]{"Date", "Sale_ID", "Username", "Medicine_Name", "Unit_Price", "Quantity", "T_Price"}));
                date1.setText("");
                id1.setText("");
                user1.setText("");
                mname1.setText("");
                prices1.setText("");
                qntty1.setText("");
                price1.setText("");

            } else if (e.getSource() == home) {

                dispose();
                Login login = new Login();
                login.setVisible(true);

            } else if (e.getSource() == view1) {

                String user = user1.getText();
                String date = date1.getText();
                String id = id1.getText();
                String medicine = mname1.getText();
                String price = prices1.getText();
                String quantity = qntty1.getText();
                if (user.equals("") || id.equals("") || date.equals("") || medicine.equals("") || price.equals("") || quantity.equals("")) {
                    JOptionPane.showMessageDialog(null, "Some fields are empty !");
                } else {
                    Integer qnty = Integer.parseInt(qntty1.getText());
                    Float prce = Float.parseFloat(prices1.getText());
                    Float tc = qnty * prce;
                    String value = String.valueOf(tc);

                    rows[0] = date1.getText();
                    rows[1] = id1.getText();
                    rows[2] = user1.getText();
                    rows[3] = mname1.getText();
                    rows[4] = prices1.getText();
                    rows[5] = qntty1.getText();
                    rows[6] = value;

                    Connection con = null;
                    PreparedStatement pst = null;
                    ResultSet rs = null;

                    try {
                        /*Class.forName("com.mysql.jdbc.Driver");
                        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "Jewel", "11111");
                         */

                        Class.forName("org.sqlite.JDBC");
                        con = DriverManager.getConnection("jdbc:sqlite:D:\\Project\\Java\\Pharma DB sqlight\\pharmacy.db");
                         // con = DriverManager.getConnection("jdbc:sqlite:pharmacy.db"); 
                          
                          
                        String query = "insert into sale_details values(?,?,?,?,?,?,?)";
                        String qq1 = "select Quantity from medicine_stock where Medicine_Name='" + mname1.getText() + "'";
                        pst = con.prepareStatement(qq1);
                        ResultSet res1 = pst.executeQuery();

                        int xx = 0;
                        if (res1.next()) {
                            xx = res1.getInt(1);
                        }
                        if (Integer.parseInt(qntty1.getText()) > xx) {
                            JOptionPane.showMessageDialog(null, "Quantity not Available!!\nAvailable Quantity=" + xx);
                        } else {

                            model.addRow(rows);
                            pst = con.prepareStatement(query);
                            pst.setString(1, date1.getText());
                            pst.setString(2, id1.getText());
                            pst.setString(3, user1.getText());
                            pst.setString(4, mname1.getText());
                            pst.setString(5, prices1.getText());
                            pst.setString(6, qntty1.getText());
                            pst.setFloat(7, tc);

                            int i = pst.executeUpdate();
                            String q1 = "select Quantity from medicine_stock where ID='" + id1.getText() + "'";
                            pst = con.prepareStatement(q1);
                            ResultSet res = pst.executeQuery();
                            int x;
                            if (res.next()) {
                                x = res.getInt(1);
                                String que = "update medicine_stock set Quantity=" + (x - Integer.parseInt(qntty1.getText())) + " where ID='" + id1.getText() + "'";
                                pst = con.prepareStatement(que);
                                pst.executeUpdate();
                                con.close();
                                //table1();
                            }
                            if (i > 0) {
                                JOptionPane.showMessageDialog(null, "Sale Successfull");
                            } else {
                                JOptionPane.showMessageDialog(null, "Not Sold");
                            }
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                    float sum = 0;
                    for (int i = 0; i < table.getRowCount(); i++) {

                        Float amnt = Float.parseFloat((String) table.getValueAt(i, 6));
                        sum = sum + amnt;

                    }
                    price1.setText(String.valueOf(sum));
                }
            }
        }
    }

    public static void main(String[] args) {
        Sale frame = new Sale("Jewel123");
        frame.setVisible(true);

    }
}
