package MainMenu;

import javax.swing.*;

public class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("Admin Menu");
        setSize(400, 300);
        setLocationRelativeTo(null); // 窗口居中
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Welcome to Main Menu", SwingConstants.CENTER);
        add(label);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}