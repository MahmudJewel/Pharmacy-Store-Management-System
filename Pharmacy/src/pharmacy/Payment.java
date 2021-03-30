package pharmacy;
//import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.DatePicker;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mahmud
 */
public class Payment extends JFrame {

    private Container c;
    private Font f;
    private JLabel id, name, date, medcn, price, cost, prices, cash, rtrn, sale;
    private JButton rcpt, back, print, reset, rtrns, home;
    private JTextField id1, name1, date1, medcn1, price1, cost1, prices1, cash1, rtrn1, sale1;
    private JTable table, table1;
    private JScrollPane scrl, scrl1;
    private DefaultTableModel model, model1;
    private DatePicker date2;
    private JTextArea ta;
    private String uname2 = null;
    //private JDateChooser date3;

    Payment() {
        initComponents();
    }

    Payment(String user) {

        initComponents();
        uname2 = user;
    }

    Payment(String text, String text0, String text1, String text2) {
        initComponents();
        sale1.setText(text);
        name1.setText(text0);
        //((JTextField)date3.getDateEditor().getUiComponent()).setText(text1);
        date1.setText(text1);
        prices1.setText(text2);

    }

    public void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200, 50, 750, 500);
        this.setTitle("Payment System");
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.cyan);
        f = new Font("Arial", Font.ITALIC, 17);

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

        sale = new JLabel("Sale_ID");
        sale.setBounds(10, 60, 80, 30);
        sale.setForeground(Color.BLACK);
        sale.setFont(f);
        c.add(sale);
        sale1 = new JTextField();
        sale1.setBounds(160, 60, 160, 30);
        sale1.setForeground(Color.BLACK);
        sale1.setFont(f);
        c.add(sale1);

        name = new JLabel("User");
        name.setBounds(10, 100, 50, 30);
        name.setForeground(Color.BLACK);
        name.setFont(f);
        c.add(name);
        name1 = new JTextField();
        name1.setBounds(160, 100, 160, 30);
        name1.setForeground(Color.BLACK);
        name1.setFont(f);
        c.add(name1);

        date = new JLabel("Date");
        date.setBounds(10, 140, 50, 30);
        date.setForeground(Color.BLACK);
        date.setFont(f);
        c.add(date);
        date1 = new JTextField();
        date1.setBounds(160, 140, 160, 30);
        date1.setForeground(Color.BLACK);
        date1.setFont(f);
        c.add(date1);

        prices = new JLabel("Total_Price");
        prices.setBounds(10, 220, 140, 30);
        prices.setForeground(Color.BLACK);
        prices.setFont(f);
        c.add(prices);
        prices1 = new JTextField();
        prices1.setBounds(160, 220, 160, 30);
        prices1.setForeground(Color.BLACK);
        prices1.setFont(f);
        c.add(prices1);

        cash = new JLabel("Received_Cash");
        cash.setBounds(10, 180, 140, 30);
        cash.setForeground(Color.BLACK);
        cash.setFont(f);
        c.add(cash);
        cash1 = new JTextField();
        cash1.setBounds(160, 180, 160, 30);
        cash1.setForeground(Color.BLACK);
        cash1.setFont(f);
        c.add(cash1);

        rtrn = new JLabel("Cash_Return");
        rtrn.setBounds(10, 260, 140, 30);
        rtrn.setForeground(Color.BLACK);
        rtrn.setFont(f);
        c.add(rtrn);
        rtrn1 = new JTextField();
        rtrn1.setBounds(160, 260, 160, 30);
        rtrn1.setForeground(Color.BLACK);
        rtrn1.setFont(f);
        c.add(rtrn1);

        ta = new JTextArea();
        ta.setBounds(360, 70, 360, 300);
        ta.setForeground(Color.BLACK);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setFont(f);
        c.add(ta);

        rcpt = new JButton("Receipt");
        rcpt.setBounds(250, 370, 100, 50);
        rcpt.setForeground(Color.BLACK);
        rcpt.setFont(f);
        c.add(rcpt);
        /* back= new JButton("Back");
      back.setBounds(10,320,100,30);
       back.setForeground(Color.BLACK);
      back.setFont(f);*/
        c.add(back);
        print = new JButton("Print");
        print.setBounds(130, 370, 100, 50);
        print.setForeground(Color.BLACK);
        print.setFont(f);
        c.add(print);
        reset = new JButton("Reset");
        reset.setBounds(10, 370, 100, 50);
        reset.setForeground(Color.BLACK);
        reset.setFont(f);
        c.add(reset);
        rtrns = new JButton("Calculate");
        rtrns.setBounds(130, 305, 120, 50);
        rtrns.setForeground(Color.BLACK);
        rtrns.setFont(f);
        c.add(rtrns);

        Handler handler = new Handler();
        rcpt.addActionListener(handler);
        back.addActionListener(handler);
        print.addActionListener(handler);
        reset.addActionListener(handler);
        rtrns.addActionListener(handler);
        home.addActionListener(handler);

    }

    class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == back) {
                String s1 = name1.getText();
                dispose();
                Sale view = new Sale(s1);
                view.setVisible(true);

            } else if (e.getSource() == rcpt) {

                if (sale1.getText().equals("") || name1.getText().equals("") || date1.getText().equals("") || cash1.getText().equals("") || prices1.getText().equals("") || rtrn1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Some fields are empty !");
                } else {

                    ta.append("\tPayment receipt\n"
                            + "====================================\n"
                            + "      Sale_ID      :  " + sale1.getText() + "\n"
                            + "      User           :  " + name1.getText() + "\n"
                            + "      Date           :  " + date1.getText() + "\n"
                            + "      " + "Received Cash :  " + cash1.getText() + "\n\n"
                            + "     Total Price         :  " + prices1.getText() + "\n\n"
                            + "     Cash Return      :  " + rtrn1.getText() + "\n\n"
                    );
                }
            } else if (e.getSource() == print) {
                if (sale1.getText().equals("") || name1.getText().equals("") || date1.getText().equals("") || cash1.getText().equals("") || prices1.getText().equals("") || rtrn1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Some fields are empty !");
                } else {
                    try {
                        ta.print();
                        //JOptionPane.showMessageDialog(null, "Print Successfully");
                    } catch (PrinterException ex) {
                        Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (e.getSource() == reset) {

                ta.setText("");
                sale1.setText("");
                // name1.setText("");
                date1.setText("");
                //((JTextField)date3.getDateEditor().getUiComponent()).setText("");
                cash1.setText("");
                prices1.setText("");
                rtrn1.setText("");

            } else if (e.getSource() == rtrns) {

                Integer rc = Integer.parseInt(cash1.getText());
                Double tp = Double.parseDouble(prices1.getText());
                Double cr = rc - tp;
                rtrn1.setText("" + cr);

            } else if (e.getSource() == home) {

                dispose();
                Login login = new Login();
                login.setVisible(true);

            }
        }
    }

    public static void main(String[] args) {
        Payment frame = new Payment();
        frame.setVisible(true);

    }

}
