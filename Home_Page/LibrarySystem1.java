package Home_Page;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.JavaBean;
import java.util.ArrayList;
import javax.swing.text.*;
import javax.print.attribute.standard.JobName;


public class LibrarySystem1{
    public static void main(String[] args){
        
        new Menu();
    }
}

class Menu extends JFrame{
    public Menu(){
     JFrame frame = new JFrame("Library System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setBackground(Color.BLACK);
        frame.setLocation(500,100);

        frame.setSize(600, 700);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        

        
        
        JLabel label = new JLabel("------------------------------------");
        label.setFont(new Font("SansSerif", Font.BOLD ,30));
        panel.add(label);

        JLabel Welcome = new JLabel("Welcome to Our Happy Library");
        Welcome.setFont(new Font("SansSerif", Font.BOLD ,30));
        panel.add(Welcome);

        JLabel label1 = new JLabel("-----------------------------------");
        label1.setFont(new Font("SansSerif", Font.BOLD ,30));
        panel.add(label1);
        panel.add(Box.createVerticalStrut(29));

        Button button1 = new Button("Admin Login");
        button1.setFont(new Font("SansSerif",Font.BOLD,30));
        panel.add(button1);

        Button button2 = new Button("User and Login");
        button2.setFont(new Font("SansSerif",Font.BOLD,30));
        panel.add(button2);

        Button button3 = new Button("Register");
        button3.setFont(new Font("SansSerif",Font.BOLD,30));
        panel.add(button3);

       
        
        
        frame.add(panel);
        frame.setVisible(true);

        button1.addActionListener(e -> new AdminLogin());
        button2.addActionListener(e -> new UserAndLogin());
        button3.addActionListener(e -> new Register());
        
        
        
    }
}
class Book extends JFrame{
    public Book(){
        JFrame frame = new JFrame("Book Categories");
        JPanel panel = new JPanel(new GridLayout(6,6,6,6));
        frame.setSize(400,300);
        frame.setVisible(true);
        frame.setLocation(500,100);
        dispose();
    }
}

class Password extends JFrame  {
    public Password(){
       JFrame frame = new JFrame("Customer Name");
       JPanel panel = new JPanel(new GridLayout(9,9,9,9));
       frame.setVisible(true);
       frame.setSize(300,300);
       frame.setLocation(500,100);
       dispose();

       JLabel passlabel = new JLabel("Password :");
       JPasswordField wfield = new JPasswordField("4041");
       JButton sumbitpass = new JButton("sumbit");

       frame.add(panel);
       panel.add(passlabel);
       panel.add(wfield);
       panel.add(sumbitpass);
       
       sumbitpass.addActionListener(e -> {
          
        int Confirm = JOptionPane.showConfirmDialog(null,"Password Your are Confirm ?","QUESTION",JOptionPane.YES_NO_OPTION
       );
        if(Confirm == JOptionPane.YES_OPTION){
            new BookMenu();
        }
        else{
            new Menu();
        }
        });
        wfield.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isLetter(c)) {
                    e.consume(); // 阻止输入
                    JOptionPane.showMessageDialog(null, 
                        "Only letters are allowed (a-z, A-Z)!", 
                        "Invalid Input", 
                        JOptionPane.WARNING_MESSAGE);
                }
            }
            
        });
    }
    
}

class  Username extends JFrame{
    public Username(){
        JFrame frame = new JFrame("#Login User");
        JPanel panel =  new JPanel(new GridLayout(6,6,6,6));
        frame.setLocation(500,100);
        frame.setVisible(true);
        frame.setSize(400,300);
        dispose();

        JLabel username = new JLabel("Username :");
        JTextField wusername = new JTextField("    username");
        JButton OK = new JButton("OK");
        OK.addActionListener(e -> {
          
            int Confirm = JOptionPane.showConfirmDialog(null," Your are Ok or Not ?","QUESTION",JOptionPane.YES_NO_OPTION
           );
            if(Confirm == JOptionPane.YES_OPTION){
                new Password();
            }
            else{
                new Menu();
            }
            });
     frame.add(panel);
     panel.add(username);
     panel.add(wusername);
     panel.add(OK);




    }
}
class AdminLogin extends JFrame{
    public AdminLogin(){
        
        JFrame frame = new JFrame("Admin Login");
        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));
        frame.setSize(400,300);
        frame.setVisible(true);
        frame.setLocation(500,100);
        dispose();

        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();
        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneNumber = new JTextField();
        JLabel username1 = new JLabel("Admin Name :");
        JLabel password1 = new JLabel("Password :");
        JButton sumbit = new JButton("Sumbit");
        
        
        phoneNumber.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                
                char  d = e.getKeyChar();
                // 如果输入的不是字母，阻止输入
                if ( !Character.isDigit(d)) {
                    e.consume(); // 阻止输入
                    JOptionPane.showMessageDialog(null, 
                        "Wrong Phone Number", 
                        "Invalid Phone Number", 
                        JOptionPane.WARNING_MESSAGE);
                }
            }
            
        });
        
      sumbit.addActionListener(e -> {
          
        int result = JOptionPane.showConfirmDialog(null,"Username and Password Your are Confirm ?","QUESTION",JOptionPane.YES_NO_OPTION
       );
        if(result == JOptionPane.YES_OPTION){
            new Book();
        }
        else{
            new Menu();
        }
        });

      
        panel.add(username1);
        panel.add(username);
        panel.add(password1);
        panel.add(password);
        panel.add(phoneLabel);
        panel.add(phoneNumber);
        panel.add(sumbit);
        frame.add(panel);

    }
}

class UserAndLogin extends JFrame{
    public UserAndLogin(){
        JFrame frame = new JFrame("#Login User");
        JPanel panel =  new JPanel(new GridLayout(6,6,6,6));
        frame.setLocation(500,100);
        frame.setVisible(true);
        frame.setSize(500,400);
        
       
        JLabel UserAndLoginPage = new JLabel("Customer Login Page");
        UserAndLoginPage.setFont(new Font("SansSerif",Font.BOLD,30));
        UserAndLoginPage.setBackground(Color.GREEN);
        JButton user = new JButton("Customer Username");
        JButton password = new JButton("Customer Password");

        frame.add(panel);
        panel.add(UserAndLoginPage);
        panel.add(user);
        panel.add(password);

        dispose();
        user.addActionListener(e -> new Username());
        password.addActionListener(e ->new Password());

    }
    
}

class BookMenu extends Frame{
    public BookMenu(){
        JFrame frame = new JFrame("#Book Menu");
        JPanel panel =  new JPanel(new GridLayout(6,6,6,6));
        frame.setLocation(500,100);
        frame.setVisible(true);
        frame.setSize(400,300);
        dispose();
    }
}

class member extends Frame{
    public member(){
        JFrame frame = new JFrame("#Member");
        JPanel panel =  new JPanel(new GridLayout(6,6,6,6));
        frame.setLocation(500,100);
        frame.setVisible(true);
        frame.setSize(400,300);
        dispose();
    }
}

class  Register extends JFrame{

    public Register(){
        JFrame frame = new JFrame("#Register");
        JPanel panel =  new JPanel(new GridLayout(6,6,6,6));
        frame.setLocation(500,100);
        frame.setVisible(true);
        frame.setSize(460,340);
        dispose();
      
        JLabel email = new JLabel("\t Email: \t");
        JTextField Email = new JTextField("\t\t gmail.com");
        String[] dayOption = {"1/1/2025 -- 1/4/2025","2/4/2025 -- 2/8/2025","3/8/2025 -- 31/12/2025"};
        JComboBox<String> dayBox = new JComboBox<>(dayOption);
        String[] genderOption = {"Male","Famale"};
        JComboBox<String> genderBox = new JComboBox<>(genderOption);
        JButton ConfirmInformation = new JButton("Comfirm");
        ConfirmInformation.addActionListener(e -> {
            int message = JOptionPane.showConfirmDialog(null, " Your information are Confirm ?","QUESTION",JOptionPane.YES_NO_OPTION

       );
       if(message == JOptionPane.YES_OPTION){
          new member();

       }
       else{
        new Menu();
       }
        });
        
        frame.add(panel);
        panel.add(email);
        panel.add(Email);
        panel.add(new JLabel("Day Option :"));
        panel.add(dayBox);
        panel.add(new JLabel("Gender :"));
        panel.add(genderBox);
        panel.add(ConfirmInformation);

    }
    
}
