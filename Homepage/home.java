//package Homepage;
//import adminMenu.AdminMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class home{
    public static void main(String[] args){
        
        new Menu().homeContainer();
    }
}

class Menu extends JFrame{
    public void homeContainer(){

        try {
            // 解决 UI 主题问题，确保 Swing 组件正确渲染
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        JFrame frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        frame.setLocationRelativeTo(null); // 让窗口居中显示

        // 使用 GridBagLayout 来精确控制位置
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // 让组件位于网格的第一列
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // 设置间距

        // 添加图片LOGO
        ImageIcon icon = new ImageIcon("Java assignment 0.0.1/Images/books and love logo.png");
        JLabel imageLabel = new JLabel(icon); // 用 JLabel 显示图片
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // 让图片居中

        JLabel label = new JLabel("----------------------------", JLabel.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 50));
        panel.add(label);

        JLabel welcome = new JLabel("WELCOME TO RWYS SmartLib", JLabel.CENTER);
        welcome.setFont(new Font("SansSerif", Font.BOLD, 30));
        panel.add(welcome);

        JLabel label1 = new JLabel("--------------------------", JLabel.CENTER);
        label1.setFont(new Font("SansSerif", Font.BOLD, 50));
        panel.add(label1);

        panel.add(Box.createVerticalStrut(20)); // 增加间距

        // 创建按钮并居中对齐
        JButton button1 = new JButton("Admin Login");
        JButton button2 = new JButton("User and Login");
        JButton button3 = new JButton("Register");

        button1.setFont(new Font("SansSerif", Font.BOLD, 20));
        button2.setFont(new Font("SansSerif", Font.BOLD, 20));
        button3.setFont(new Font("SansSerif", Font.BOLD, 20));

        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(button1);
        panel.add(Box.createVerticalStrut(10)); // 按钮之间的间距
        panel.add(button2);
        panel.add(Box.createVerticalStrut(10));
        panel.add(button3);

        // 添加一个空白区域，使内容在面板内居中
        panel.add(Box.createVerticalGlue());

        // 调整组件排列
        gbc.gridy = 0;
        panel.add(label, gbc);
        gbc.gridy = 1;
        panel.add(welcome, gbc);
        gbc.gridy = 2;
        panel.add(label1, gbc);
        gbc.gridy = 3;
        panel.add(Box.createVerticalStrut(20), gbc);

        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE; // 让按钮大小合适
        gbc.anchor = GridBagConstraints.CENTER; // 让按钮居中
        panel.add(button1, gbc);
        gbc.gridy = 5;
        panel.add(button2, gbc);
        gbc.gridy = 6;
        panel.add(button3, gbc);

        frame.add(panel);
        frame.setVisible(true);

        // 主页按钮
        button1.addActionListener(e -> new AdminLogin());
        button2.addActionListener(e -> new UserAndLogin());
        button3.addActionListener(e -> new Register());
    }
}

class AdminLogin extends JFrame{
    public AdminLogin(){
        
        JFrame frame = new JFrame("Admin Login");
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null); // 居中窗口
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 创建面板，使用 GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE; // 自动换行
        gbc.insets = new Insets(5, 10, 5, 10); // 上下左右的间距
        gbc.anchor = GridBagConstraints.CENTER; // 让组件居中
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 创建组件
        JLabel usernameLabel = new JLabel("Admin Name:");
        JTextField usernameField = new JTextField(15);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);

        JButton submitButton = new JButton("Submit");

        // 添加弹窗
        submitButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword()); // 获取密码字段内容

            if (username.equals("admin") && password.equals("admin")) {
                JOptionPane.showMessageDialog(frame, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                new AdminMenu();  // 这里确保 AdminMenu 是一个 JFrame 或者 JPanel
                frame.dispose(); // 关闭当前窗口
            } else {
                JOptionPane.showMessageDialog(frame, "Login Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // 添加组件到面板
        panel.add(usernameLabel, gbc);
        panel.add(usernameField, gbc);
        panel.add(passwordLabel, gbc);
        panel.add(passwordField, gbc);

        gbc.fill = GridBagConstraints.NONE; // 让按钮不拉伸
        panel.add(submitButton, gbc);

        // 添加面板到窗口
        frame.add(panel);
        frame.setVisible(true);
    }
}

class UserAndLogin extends JFrame{
        private CardLayout cardLayout;
    private JPanel mainPanel;
    
    // 创建组件
    private JTextField usernameField;
    private JPasswordField passwordField;

    public UserAndLogin() {
        // 设置窗口
        setTitle("User Login System");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建 CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // 添加 3 个界面
        mainPanel.add(createLoginPanel(), "Login");
        mainPanel.add(createUsernamePanel(), "Username");
        mainPanel.add(createPasswordPanel(), "Password");

        add(mainPanel);
        setVisible(true);
    }

    /** 登录界面 **/
    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Customer Login Page", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 20));

        JButton usernameButton = new JButton("Enter Username");
        JButton passwordButton = new JButton("Enter Password");

        // 按钮：切换到用户名界面
        usernameButton.addActionListener(e -> cardLayout.show(mainPanel, "Username"));
        passwordButton.addActionListener(e -> cardLayout.show(mainPanel, "Password"));

        panel.add(title, gbc);
        panel.add(usernameButton, gbc);
        panel.add(passwordButton, gbc);
        return panel;
    }

    /** 用户名界面 **/
    private JPanel createUsernamePanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel label = new JLabel("Username:");
        label.setFont(new Font("SansSerif", Font.BOLD, 14));

        usernameField = new JTextField(15);
        JButton okButton = new JButton("OK");

        // 确认按钮：切换到密码界面
        okButton.addActionListener(e -> cardLayout.show(mainPanel, "Password"));

        panel.add(label, gbc);
        panel.add(usernameField, gbc);
        panel.add(okButton, gbc);
        return panel;
    }

    /** 密码界面 **/
    private JPanel createPasswordPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel label = new JLabel("Password:");
        label.setFont(new Font("SansSerif", Font.BOLD, 14));

        passwordField = new JPasswordField(15);
        JButton submitButton = new JButton("Submit");

        // 仅允许 8 位密码
        passwordField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (passwordField.getPassword().length >= 8) {
                    e.consume();
                }
            }
        });

        // 提交按钮逻辑
        submitButton.addActionListener(e -> {
            String password = new String(passwordField.getPassword());

            if (password.length() < 8) {
                JOptionPane.showMessageDialog(this, 
                    "Password must be exactly 8 characters!", 
                    "Invalid Password", 
                    JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        panel.add(label, gbc);
        panel.add(passwordField, gbc);
        panel.add(submitButton, gbc);
        return panel;
    }
}

class  Register extends JFrame{
    
    public Register(){
        JFrame frame = new JFrame("#Register");
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null); // 窗口居中
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 使用 GridBagLayout 让组件居中
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE; // 自动换行
        gbc.insets = new Insets(5, 10, 5, 10); // 间距
        gbc.anchor = GridBagConstraints.CENTER; // 居中对齐
        gbc.fill = GridBagConstraints.HORIZONTAL; // 让文本框和按钮拉伸
        
        // Email
        JLabel email = new JLabel("Email:");
        JTextField emailField = new JTextField("example@gmail.com", 15);

        // 电话号码
        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneNumber = new JTextField(15);
        
        // 生日日期选项
        // **日**
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = String.valueOf(i + 1);
        }
        JComboBox<String> dayBox = new JComboBox<>(days);

        // **月**
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        JComboBox<String> monthBox = new JComboBox<>(months);

        // **年**
        String[] years = new String[126]; // 1900 - 2025
        for (int i = 0; i < 126; i++) {
            years[i] = String.valueOf(1900 + i);
        }
        JComboBox<String> yearBox = new JComboBox<>(years);
        yearBox.setSelectedItem("2000"); // 默认选中 2000 年

        // 性别选项
        String[] genderOption = {"Male", "Female"};
        JComboBox<String> genderBox = new JComboBox<>(genderOption);

        // 按钮
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setFont(new Font("SansSerif", Font.BOLD, 14)); // 按钮加粗

        // 电话号码输入，只允许数字
        phoneNumber.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // 阻止非数字输入
                }
            }
        });

        // 按钮点击弹窗
        confirmButton.addActionListener(e -> {
            int message = JOptionPane.showConfirmDialog(frame, "Are You Confirmed Your Informations?", "QUESTION", JOptionPane.YES_NO_OPTION);
            if (message == JOptionPane.YES_OPTION) {
                //new Member();
                frame.dispose();
            } else {
                new Menu().homeContainer();
            }
        });

        // 添加组件到面板
        panel.add(email, gbc);
        panel.add(emailField, gbc);
        panel.add(phoneLabel, gbc);
        panel.add(phoneNumber, gbc);
        panel.add(new JLabel("Day:"), gbc);
        panel.add(dayBox, gbc);
        panel.add(new JLabel("Month:"), gbc);
        panel.add(monthBox, gbc);
        panel.add(new JLabel("Year:"), gbc);
        panel.add(yearBox, gbc);
        panel.add(new JLabel("Gender:"), gbc);
        panel.add(genderBox, gbc);

        // 让按钮单独占一行，并居中
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(confirmButton, gbc);

        // 添加面板到窗口
        frame.add(panel);
        frame.setVisible(true);
    }
}

class Book extends JFrame{
    public Book(){
        JFrame frame = new JFrame("Book Categories");
        JPanel panel = new JPanel(new GridLayout(6,6,6,6));
        frame.setSize(400,300);
        frame.setVisible(true);
        frame.setLocation(500,100);
    }
}

class BookMenu extends Frame{
    public BookMenu(){
        JFrame frame = new JFrame("#Book Menu");
        JPanel panel =  new JPanel(new GridLayout(6,6,6,6));
        frame.setLocation(500,100);
        frame.setVisible(true);
        frame.setSize(400,300);
    }
}

class member extends Frame{
    public member(){
        JFrame frame = new JFrame("#Member");
        JPanel panel =  new JPanel(new GridLayout(6,6,6,6));
        frame.setLocation(500,100);
        frame.setVisible(true);
        frame.setSize(400,300);
    }
}

class AdminMenu extends Frame{
    public AdminMenu() {
        JFrame frame = new JFrame("Admin Menu");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1));
        
        JLabel titleLabel = new JLabel("Welcome, Admin!", JLabel.CENTER);
        frame.add(titleLabel);
        
        JButton manageUsersButton = new JButton("Manage Users");
        JButton manageBooksButton = new JButton("Manage Books");
        JButton viewRecordsButton = new JButton("View Records");
        JButton backButton = new JButton("Back to Main Menu");
        
        frame.add(manageUsersButton);
        frame.add(manageBooksButton);
        frame.add(viewRecordsButton);
        frame.add(backButton);
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // 关闭当前窗口
                new AdminLogin(); // 返回登录界面
            }
        });
        
        frame.setVisible(true);
    }
}