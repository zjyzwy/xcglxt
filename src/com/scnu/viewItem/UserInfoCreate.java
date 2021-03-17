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

public class UserInfoCreate extends JPanel {
	private JTextField userId;
	private JTextField userName;
	private JTextField post;

	/**
	 * Create the panel.
	 */
	public UserInfoCreate() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel.setBounds(78, 83, 72, 18);
		add(lblNewLabel);
		
		JLabel label = new JLabel("\u6DFB\u52A0\u65B0\u7528\u6237");
		label.setFont(new Font("宋体", Font.BOLD, 18));
		label.setBounds(271, 13, 120, 38);
		add(label);
		
		userId = new JTextField();
		userId.setHorizontalAlignment(SwingConstants.CENTER);
		userId.setFont(new Font("宋体", Font.BOLD, 16));
		userId.setBounds(156, 81, 111, 24);
		add(userId);
		userId.setColumns(10);
		
		JLabel label_1 = new JLabel("\u804C\u79F0\u7EA7\u522B\uFF1A");
		label_1.setFont(new Font("宋体", Font.BOLD, 16));
		label_1.setBounds(344, 87, 100, 18);
		add(label_1);
		
		JComboBox professionalTitle = new JComboBox();
		professionalTitle.setFont(new Font("宋体", Font.BOLD, 16));
		professionalTitle.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u9009\u62E9", "\u6B63\u9AD8-\u6B63\u5904", "\u526F\u9AD8-\u526F\u5904", "\u4E2D\u7EA7-\u6B63\u79D1", "\u521D\u7EA7-\u526F\u79D1", "\u65E0"}));
		professionalTitle.setBounds(474, 80, 129, 24);
		add(professionalTitle);
		
		JLabel label_2 = new JLabel("\u59D3\u540D\uFF1A");
		label_2.setFont(new Font("宋体", Font.BOLD, 16));
		label_2.setBounds(78, 142, 72, 18);
		add(label_2);
		
		userName = new JTextField();
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		userName.setFont(new Font("宋体", Font.BOLD, 16));
		userName.setBounds(156, 140, 111, 24);
		add(userName);
		userName.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6027\u522B\uFF1A");
		label_3.setFont(new Font("宋体", Font.BOLD, 16));
		label_3.setBounds(78, 197, 72, 18);
		add(label_3);
		
		JComboBox sex = new JComboBox();
		sex.setFont(new Font("宋体", Font.BOLD, 16));
		sex.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u9009\u62E9", "\u7537", "\u5973"}));
		sex.setBounds(156, 195, 111, 24);
		add(sex);
		
		JComboBox department = new JComboBox();
		department.setFont(new Font("宋体", Font.BOLD, 16));
		department.setModel(new DefaultComboBoxModel(new String[] {"\u5B66\u9662\u9886\u5BFC", "\u8F6F\u4EF6\u5DE5\u7A0B\u7CFB", "\u8BA1\u7B97\u673A\u57FA\u7840\u90E8", "\u6570\u5B66\u6559\u5B66\u90E8", "\u5B66\u9662\u529E\u516C\u5BA4", "\u5B66\u9662\u5B9E\u9A8C\u4E2D\u5FC3", "\u79BB\u804C\u9000\u4F11\u4EBA\u5458"}));
		department.setBounds(156, 255, 111, 24);
		add(department);
		
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
		add(post);
		post.setColumns(10);
		
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
		
		JComboBox mTAO_State = new JComboBox();
		mTAO_State.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u9009\u62E9", "\u4E13\u4EFB\u6559\u5E08", "\u975E\u4E13\u4EFB\u6559\u5E08"}));
		mTAO_State.setFont(new Font("宋体", Font.BOLD, 16));
		mTAO_State.setBounds(474, 139, 129, 24);
		add(mTAO_State);
		
		JComboBox baseAllowanceState = new JComboBox();
		baseAllowanceState.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u9009\u62E9", "\u9662\u957F\u4E66\u8BB0", "\u526F\u4E66\u8BB0", "\u8BB2\u5E08", "\u52A9\u6559", "\u6559\u6388", "\u526F\u6559\u6388", "\u9662\u957F", "\u526F\u9662\u957F", "\u5DE5\u4F1A\u4E3B\u5E2D", "\u7CFB\u4E3B\u4EFB", "\u529E\u516C\u5BA4\u4E3B\u4EFB", "\u56E2\u59D4\u4E66\u8BB0", "\u5B66\u672F\u59D4\u4E3B\u4EFB\u59D4\u5458", "\u9662\u957F\u52A9\u7406"}));
		baseAllowanceState.setFont(new Font("宋体", Font.BOLD, 16));
		baseAllowanceState.setBounds(474, 194, 129, 24);
		add(baseAllowanceState);
		
		JComboBox dutyAllowanceState = new JComboBox();
		dutyAllowanceState.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u9009\u62E9", "\u9662\u957F", "\u4E66\u8BB0", "\u526F\u9662\u957F", "\u526F\u4E66\u8BB0", "\u8BB2\u5E08", "\u6559\u6388", "\u526F\u6559\u6388", "\u52A9\u6559", "\u7CFB\u4E3B\u4EFB", "\u5DE5\u4F1A\u4E3B\u5E2D", "\u529E\u516C\u5BA4\u4E3B\u4EFB", "\u56E2\u59D4\u4E66\u8BB0", "\u7EE7\u6559\u529E\u4E3B\u4EFB", "\u5404\u4E2D\u5FC3\u4E3B\u4EFB", "\u9662\u957F\u52A9\u7406", "\u5B66\u672F\u59D4\u4E3B\u4EFB\u59D4\u5458"}));
		dutyAllowanceState.setFont(new Font("宋体", Font.BOLD, 16));
		dutyAllowanceState.setBounds(474, 255, 129, 24);
		add(dutyAllowanceState);
		
		JComboBox telAllowanceState = new JComboBox();
		telAllowanceState.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u9009\u62E9", "\u9662\u957F", "\u4E66\u8BB0", "\u526F\u9662\u957F", "\u526F\u4E66\u8BB0", "\u8BB2\u5E08", "\u52A9\u6559", "\u6559\u6388", "\u526F\u6559\u6388", "\u7CFB\u4E3B\u4EFB", "\u9662\u957F\u52A9\u7406", "\u5DE5\u4F1A\u4E3B\u5E2D", "\u529E\u516C\u5BA4\u4E3B\u4EFB", "\u56E2\u59D4\u4E66\u8BB0", "\u5B66\u672F\u59D4\u4E3B\u4EFB\u59D4\u5458", "\u7EE7\u6559\u529E\u4E3B\u4EFB", "\u5404\u4E2D\u5FC3\u4E3B\u4EFB", "\u9662\u957F\u52A9\u7406"}));
		telAllowanceState.setFont(new Font("宋体", Font.BOLD, 16));
		telAllowanceState.setBounds(474, 304, 129, 24);
		add(telAllowanceState);
		
		JLabel label_10 = new JLabel("\u7528\u6237\u7CFB\u7EDF\u767B\u5F55\u8EAB\u4EFD\u6743\u9650\uFF1A");
		label_10.setFont(new Font("宋体", Font.BOLD, 16));
		label_10.setBounds(124, 359, 187, 18);
		add(label_10);
		
		JComboBox loginAuthority = new JComboBox();
		loginAuthority.setFont(new Font("宋体", Font.BOLD, 16));
		loginAuthority.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u9009\u62E9", "\u9662\u957F", "\u4E66\u8BB0", "\u526F\u9662\u957F", "\u526F\u4E66\u8BB0", "\u6559\u6388", "\u526F\u6559\u6388", "\u8BB2\u5E08", "\u52A9\u6559", "\u7CFB\u4E3B\u4EFB", "\u8D22\u52A1\u5458"}));
		loginAuthority.setBounds(329, 357, 83, 24);
		add(loginAuthority);
		
		JButton createUserBt = new JButton("\u521B\u5EFA\u65B0\u7528\u6237");
		createUserBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				user.setUserId(userId.getText());
				user.setUserName(userName.getText());
				user.setUserPsw("abc123456");
				user.setSex(sex.getSelectedItem().toString());
				user.setDepartment(department.getSelectedItem().toString());
				user.setPost(post.getText());
				user.setProfessionalTitle(professionalTitle.getSelectedItem().toString());
				user.setmTOA_State(mTAO_State.getSelectedItem().toString());
				user.setBaseAllowanceState(baseAllowanceState.getSelectedItem().toString());
				user.setDutyAllowanceState(dutyAllowanceState.getSelectedItem().toString());
				user.setTelAllowanceState(telAllowanceState.getSelectedItem().toString());
				user.setLoginAuthority(loginAuthority.getSelectedItem().toString());
				
				UserDao userDao = new UserDao();
				int n = userDao.addUser(user);
				
				if(n==1) {
					JOptionPane.showMessageDialog(null, "添加用户成功", "提示信息",JOptionPane.OK_OPTION);
				}else {
					JOptionPane.showMessageDialog(null, "添加用户失败", "提示信息",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		createUserBt.setFont(new Font("宋体", Font.BOLD, 16));
		createUserBt.setBounds(271, 414, 135, 27);
		add(createUserBt);
		
		JButton button = new JButton("\u4E0A\u4F20\u7528\u6237\u56FE\u50CF");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = userId.getText().trim();
				ShowImg showImg = new ShowImg(id);
				showImg.setLocationRelativeTo(null);
				showImg.setVisible(true);
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 16));
		button.setBounds(444, 356, 157, 27);
		add(button);

	}
}
