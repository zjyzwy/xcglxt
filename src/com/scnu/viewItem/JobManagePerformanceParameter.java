package com.scnu.viewItem;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.scnu.dao.ParameterDao;
import com.scnu.modleItem.Parameter;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobManagePerformanceParameter extends JPanel {

	private JTextField other;
	private JTextField president;
	private JTextField vicePresident;
	private JTextField director;
	private JTextField viceDirector;
	private String[] jobWage;

	public JobManagePerformanceParameter(Parameter parameter) {
		setLayout(null);

		jobWage = parameter.getJobManagePerformanceWage();

		JLabel label = new JLabel("\u7BA1 \u7406 \u5C97 \u7EE9 \u6548 \u7CFB \u6570");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		label.setBounds(220, 30, 230, 40);
		add(label);

		JLabel label_6 = new JLabel("\u9662\u957F/\u4E66\u8BB0\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 16));
		label_6.setBounds(62, 98, 92, 21);
		add(label_6);

		other = new JTextField();
		other.setBounds(156, 284, 128, 23);
		other.setText(jobWage[4]);
		add(other);
		other.setColumns(10);

		president = new JTextField();
		president.setText(jobWage[0]);
		president.setColumns(10);
		president.setBounds(156, 98, 128, 23);
		add(president);

		JLabel label_7 = new JLabel("\u526F\u9662\u957F/\u526F\u4E66\u8BB0\uFF1A");
		label_7.setFont(new Font("宋体", Font.PLAIN, 16));
		label_7.setBounds(365, 98, 120, 21);
		add(label_7);

		vicePresident = new JTextField();
		vicePresident.setText(jobWage[1]);
		vicePresident.setColumns(10);
		vicePresident.setBounds(487, 98, 128, 23);
		add(vicePresident);

		JLabel label_8 = new JLabel("\u7CFB\\\u90E8\\\u4E2D\u5FC3\u4E3B\u4EFB\uFF1A");
		label_8.setFont(new Font("宋体", Font.PLAIN, 16));
		label_8.setBounds(26, 192, 128, 21);
		add(label_8);

		director = new JTextField();
		director.setText(jobWage[2]);
		director.setColumns(10);
		director.setBounds(156, 192, 128, 23);
		add(director);

		JLabel label_9 = new JLabel("\u7CFB\\\u90E8\\\u4E2D\u5FC3\u526F\u4E3B\u4EFB\uFF1A");
		label_9.setFont(new Font("宋体", Font.PLAIN, 16));
		label_9.setBounds(345, 192, 144, 21);
		add(label_9);

		viceDirector = new JTextField();
		viceDirector.setText(jobWage[3]);
		viceDirector.setColumns(10);
		viceDirector.setBounds(487, 192, 128, 23);
		add(viceDirector);

		JButton button = new JButton("\u66F4 \u65B0 \u53C2 \u6570");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jobWage = null;
				jobWage = president.getText() + "," + vicePresident.getText() + "," + director.getText() + ","
						+ viceDirector.getText() + "," + other.getText();

				parameter.setJobManagePerformance(jobWage);

				ParameterDao parameterDao = new ParameterDao();
				int n = parameterDao.updateParameter(parameter);

				if (n == 1) {
					JOptionPane.showMessageDialog(null, "更新参数成功", "提示信息", JOptionPane.OK_OPTION);
				} else {
					JOptionPane.showMessageDialog(null, "更新参数失败", "提示信息", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBounds(267, 393, 159, 30);
		add(button);

		JLabel label_6_1 = new JLabel("\u5176\u4ED6\uFF1A");
		label_6_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_6_1.setBounds(103, 284, 48, 21);
		add(label_6_1);

	}
}
