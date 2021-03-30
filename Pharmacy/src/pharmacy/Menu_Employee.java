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
class Menu_Employee extends JFrame {
    private Container c;
    private JButton stock,user,sale,report,back,home;
    private Font f;
    String pos;

    Menu_Employee(String unm10){
        pos=unm10;
        initComponents();
    }
    public void initComponents()
    {
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.setBounds(240, 80, 450, 340);
          this.setTitle("Employee Panel");
          this.setResizable(false);

         f=new Font("Arial",Font.BOLD,17);

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.cyan);

        /*stock=new JButton("Medicine Stock");
        stock.setBounds(100,45,150,30);
        stock.setFont(f);
        stock.setForeground(Color.BLACK);
        c.add(stock);*/

        stock=new JButton("Stock");
        stock.setBounds(140, 100, 170, 50);
        stock.setFont(f);
        stock.setForeground(Color.BLACK);
        c.add(stock);


        sale=new JButton("Sale");
        sale.setBounds(140, 170, 170, 50);
        sale.setFont(f);
        sale.setForeground(Color.BLACK);
        c.add(sale);

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
        stock.addActionListener(handler);
        //user.addActionListener(handler);
       back.addActionListener(handler);
        sale.addActionListener(handler);
        home.addActionListener(handler);

    }

    class Handler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            /*if(e.getSource()==stock)
            {
                dispose();
                Stock stock=new Stock();
             stock.setVisible(true);
            }*/
            if(e.getSource()==stock)
            {
             dispose();
             Stock user=new Stock(pos);
               // System.out.println(pos);
             user.setVisible(true);
            }
           else if(e.getSource()==back)
            {
            dispose();
            Login sale=new Login();
             sale.setVisible(true);
            }
            else if(e.getSource()==sale)
            {
             dispose();
            Sale report=new Sale(pos);
             report.setVisible(true);
            }
            else if(e.getSource()==home)
            {
            dispose();
            Login sale=new Login();
             sale.setVisible(true);
            }
        }
    }

    public static void main(String[] args) {

       Menu_Employee frame=new Menu_Employee("J.M");
       frame.setVisible(true);
    }

}
