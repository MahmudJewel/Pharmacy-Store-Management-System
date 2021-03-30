package pharmacy;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Mahmud
 */
class Main_Menu extends JFrame {

    private Container c;
    private JButton stock, user, sale, report, back,home;
    private Font f;
    
    Main_Menu() {
        
        initComponents();
    }

    public void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(240, 80, 450, 340);
        this.setTitle("Admin Panel");
        this.setResizable(false);
        
        f = new Font("Arial", Font.BOLD, 17);
        
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.cyan);

        /*stock=new JButton("Medicine Stock");
        stock.setBounds(100,45,150,30);
        stock.setFont(f);
        stock.setForeground(Color.BLACK);
        c.add(stock);*/
        report = new JButton("Transaction");
        report.setBounds(140, 100, 170, 50);
        //user.setBackground(Color.green);
        report.setFont(f);
        report.setForeground(Color.BLACK);
        c.add(report);
        
        user = new JButton("Employee List");
        user.setBounds(140, 170, 170, 50);
        //report.setBackground(Color.green);
        user.setFont(f);
        user.setForeground(Color.BLACK);
        c.add(user);
        
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
        
        Handler handler = new Handler();
        //stock.addActionListener(handler);
        user.addActionListener(handler);
        back.addActionListener(handler);
        report.addActionListener(handler);
        home.addActionListener(handler);
        
    }
    
    class Handler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            /*if(e.getSource()==stock)
            {
                dispose();
                Stock stock=new Stock();
             stock.setVisible(true);
            }*/
            if (e.getSource() == user) {
                dispose();
                User user = new User();
                user.setVisible(true);
            } else if (e.getSource() == back) {
                dispose();
                Login sale = new Login();
                sale.setVisible(true);
            } else if (e.getSource() == report) {
                dispose();
                Report report = new Report();
                report.setVisible(true);
            }
            else if (e.getSource() == home) {
                dispose();
                Login sale = new Login();
                sale.setVisible(true);
            }
        }
    }
    
    public static void main(String[] args) {
        
        Main_Menu frame = new Main_Menu();
        frame.setVisible(true);
    }
    
}
