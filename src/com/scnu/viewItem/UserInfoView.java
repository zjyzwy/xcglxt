package com.scnu.viewItem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import com.scnu.dao.UserDao;
import com.scnu.modleItem.User;

public class UserInfoView extends JPanel {
	private JTextField userId;
	private JTextField userName;
	private JTextField post;
	private JTextField professionalTitle;
	private JTextField sex;
	private JTextField department;
	private JTextField mTAO_State;
	private JTextField baseAllowanceState;
	private JTextField dutyAllowanceState;
	private JTextField telAllowanceState;

	/**
	 * Create the panel.
	 */
	public UserInfoView(User user) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel.setBounds(78, 83, 72, 18);
		add(lblNewLabel);
		
		JLabel label = new JLabel("\u7528\u6237\u4FE1\u606F");
		label.setFont(new Font("宋体", Font.BOLD, 18));
		label.setBounds(271, 13, 120, 38);
		add(label);
		
		userId = new JTextField();
		userId.setHorizontalAlignment(SwingConstants.CENTER);
		userId.setFont(new Font("宋体", Font.BOLD, 16));
		userId.setBounds(156, 81, 111, 24);
		userId.setText(user.getUserId());
		add(userId);
		userId.setColumns(10);
		userId.setEnabled(false);
		
		JLabel label_1 = new JLabel("\u804C\u79F0\u7EA7\u522B\uFF1A");
		label_1.setFont(new Font("宋体", Font.BOLD, 16));
		label_1.setBounds(344, 87, 100, 18);
		add(label_1);
		
		JLabel label_2 = new JLabel("\u59D3\u540D\uFF1A");
		label_2.setFont(new Font("宋体", Font.BOLD, 16));
		label_2.setBounds(78, 142, 72, 18);
		add(label_2);
		
		userName = new JTextField();
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		userName.setFont(new Font("宋体", Font.BOLD, 16));
		userName.setBounds(156, 140, 111, 24);
		userName.setText(user.getUserName());
		add(userName);
		userName.setColumns(10);
		userName.setEnabled(false);
		
		JLabel label_3 = new JLabel("\u6027\u522B\uFF1A");
		label_3.setFont(new Font("宋体", Font.BOLD, 16));
		label_3.setBounds(78, 197, 72, 18);
		add(label_3);
		
		JLabel label_4 = new JLabel("\u90E8\u95E8\uFF1A");
		label_4.setFont(new Font("宋体", Font.BOLD, 16));
		label_4.setBounds(78, 257, 72, 18);
		add(label_4);
		
		JLabel label_5 = new JLabel("\u804C\u52A1\uFF1A");
		label_5.setFont(new Font("宋体", Font.BOLD, 16));
		label_5.setBounds(78, 307, 72, 18);
		add(label_5);
		
		post = new JTextField();
		post.setHorizontalAlignment(SwingConstants.CENTER);
		post.setFont(new Font("宋体", Font.BOLD, 16));
		post.setBounds(156, 304, 111, 24);
		post.setText(user.getPost());
		add(post);
		post.setColumns(10);
		post.setEnabled(false);
		
		JLabel label_6 = new JLabel("\u7EE9\u6548\u7EDF\u8BA1\u8EAB\u4EFD\uFF1A");
		label_6.setFont(new Font("宋体", Font.BOLD, 16));
		label_6.setBounds(344, 143, 120, 18);
		add(label_6);
		
		JLabel label_7 = new JLabel("\u751F\u6D3B\u6D25\u8D34\u8EAB\u4EFD\uFF1A");
		label_7.setFont(new Font("宋体", Font.BOLD, 16));
		label_7.setBounds(344, 198, 120, 18);
		add(label_7);
		
		JLabel label_8 = new JLabel("\u804C\u52A1\u6D25\u8D34\u8EAB\u4EFD\uFF1A");
		label_8.setFont(new Font("宋体", Font.BOLD, 16));
		label_8.setBounds(344, 258, 120, 18);
		add(label_8);
		
		JLabel label_9 = new JLabel("\u7535\u8BDD\u8865\u8D34\u8EAB\u4EFD\uFF1A");
		label_9.setFont(new Font("宋体", Font.BOLD, 16));
		label_9.setBounds(344, 308, 120, 18);
		add(label_9);
		
		professionalTitle = new JTextField();
		professionalTitle.setHorizontalAlignment(SwingConstants.CENTER);
		professionalTitle.setFont(new Font("宋体", Font.BOLD, 16));
		professionalTitle.setBounds(474, 81, 129, 24);
		professionalTitle.setText(user.getProfessionalTitle());
		add(professionalTitle);
		professionalTitle.setColumns(10);
		professionalTitle.setEnabled(false);
		
		sex = new JTextField();
		sex.setHorizontalAlignment(SwingConstants.CENTER);
		sex.setFont(new Font("宋体", Font.BOLD, 16));
		sex.setBounds(156, 195, 111, 24);
		sex.setText(user.getSex());
		add(sex);
		sex.setColumns(10);
		sex.setEnabled(false);
		
		department = new JTextField();
		department.setHorizontalAlignment(SwingConstants.CENTER);
		department.setFont(new Font("宋体", Font.BOLD, 16));
		department.setBounds(156, 255, 111, 24);
		department.setText(user.getDepartment());
		add(department);
		department.setColumns(10);
		department.setEnabled(false);
		
		mTAO_State = new JTextField();
		mTAO_State.setHorizontalAlignment(SwingConstants.CENTER);
		mTAO_State.setFont(new Font("宋体", Font.BOLD, 16));
		mTAO_State.setBounds(474, 140, 129, 24);
		mTAO_State.setText(user.getmTOA_State());
		add(mTAO_State);
		mTAO_State.setColumns(10);
		mTAO_State.setEnabled(false);
		
		baseAllowanceState = new JTextField();
		baseAllowanceState.setHorizontalAlignment(SwingConstants.CENTER);
		baseAllowanceState.setFont(new Font("宋体", Font.BOLD, 16));
		baseAllowanceState.setBounds(474, 195, 129, 24);
		baseAllowanceState.setText(user.getBaseAllowanceState());
		add(baseAllowanceState);
		baseAllowanceState.setColumns(10);
		baseAllowanceState.setEnabled(false);
		
		dutyAllowanceState = new JTextField();
		dutyAllowanceState.setHorizontalAlignment(SwingConstants.CENTER);
		dutyAllowanceState.setFont(new Font("宋体", Font.BOLD, 16));
		dutyAllowanceState.setBounds(474, 251, 129, 24);
		dutyAllowanceState.setText(user.getDutyAllowanceState());
		add(dutyAllowanceState);
		dutyAllowanceState.setColumns(10);
		dutyAllowanceState.setEnabled(false);
		
		telAllowanceState = new JTextField();
		telAllowanceState.setHorizontalAlignment(SwingConstants.CENTER);
		telAllowanceState.setFont(new Font("宋体", Font.BOLD, 16));
		telAllowanceState.setBounds(478, 301, 125, 24);
		telAllowanceState.setText(user.getTelAllowanceState());
		add(telAllowanceState);
		telAllowanceState.setColumns(10);
		telAllowanceState.setEnabled(false);
		
		JButton showUserImg = new JButton("\u663E\u793A\u7528\u6237\u56FE\u50CF");
		showUserImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = userId.getText().trim();
				ShowImg showImg = new ShowImg(id);
				showImg.setLocationRelativeTo(null);
				showImg.setVisible(true);
			}
		});
		showUserImg.setFont(new Font("宋体", Font.BOLD, 16));
		showUserImg.setBounds(257, 362, 157, 27);
		add(showUserImg);

	}
}
