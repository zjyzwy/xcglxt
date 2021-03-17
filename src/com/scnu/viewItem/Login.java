package com.scnu.viewItem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.scnu.dao.LoginDao;
import com.scnu.modleItem.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField userPsw;

	static Login LoginFrame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame = new Login();
					LoginFrame.setVisible(true);
					LoginFrame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("\u6B22\u8FCE\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.BOLD, 18));
		label.setBounds(46, 33, 87, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setFont(new Font("宋体", Font.BOLD, 18));
		label_1.setBounds(46, 73, 72, 18);
		contentPane.add(label_1);
		
		userName = new JTextField();
		userName.setFont(new Font("宋体", Font.BOLD, 16));
		userName.setBounds(147, 30, 215, 24);
		contentPane.add(userName);
		userName.setColumns(10);
		
		userPsw = new JPasswordField();
		userPsw.setFont(new Font("宋体", Font.BOLD, 16));
		userPsw.setBounds(147, 70, 215, 24);
		contentPane.add(userPsw);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = userName.getText();
				String psw = new String(userPsw.getPassword()).trim();
				
				User user = new LoginDao().checkUser(name, psw);
				if(name.length()>0) {
					if(psw.length()>0) {
						if(user!=null) {
							MainFrame mainFrame = new MainFrame(user);
							mainFrame.setLocationRelativeTo(null);
							mainFrame.setVisible(true);
							
							LoginFrame.dispose();
						}else {
							JOptionPane.showMessageDialog(null, "用户名或密码错误！",null,JOptionPane.WARNING_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "请输入密码！",null,JOptionPane.WARNING_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "请输入用户名！",null,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 15));
		button.setBounds(70, 134, 87, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_1.setFont(new Font("宋体", Font.BOLD, 15));
		button_1.setBounds(236, 134, 87, 27);
		contentPane.add(button_1);
	}
}
