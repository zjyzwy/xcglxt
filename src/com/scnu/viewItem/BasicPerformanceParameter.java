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

public class BasicPerformanceParameter extends JPanel {

	private JTextField professor;

	private JTextField other;
	private JTextField viceProfessor;
	private JTextField teacher;
	private JTextField assistant;
	private JTextField president;
	private JTextField vicePresident;
	private JTextField director;
	private JTextField viceDirector;
	private String[] jobWage;

	public BasicPerformanceParameter(Parameter parameter) {
		setLayout(null);

		jobWage = parameter.getBasicPerformanceWage();

		JLabel label = new JLabel("\u57FA \u7840 \u7EE9 \u6548 \u5DE5 \u8D44");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		label.setBounds(243, 30, 196, 40);
		add(label);

		JLabel label_1 = new JLabel("\u6559\u6388\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(60, 98, 54, 21);
		add(label_1);

		JLabel label_2 = new JLabel("\u526F\u6559\u6388\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(404, 99, 66, 18);
		add(label_2);

		JLabel label_6 = new JLabel("\u9662\u957F/\u4E66\u8BB0\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 16));
		label_6.setBounds(30, 161, 92, 21);
		add(label_6);

		JLabel label_5 = new JLabel("\u5176\u4ED6\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 16));
		label_5.setBounds(60, 354, 54, 21);
		add(label_5);

		professor = new JTextField();
		professor.setBounds(136, 97, 128, 23);
		professor.setText(jobWage[0]);
		add(professor);
		professor.setColumns(10);

		other = new JTextField();
		other.setBounds(136, 353, 128, 23);
		other.setText(jobWage[8]);
		add(other);
		other.setColumns(10);

		JLabel label_4 = new JLabel("\u52A9\u6559\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 16));
		label_4.setBounds(415, 221, 66, 20);
		add(label_4);

		viceProfessor = new JTextField();
		viceProfessor.setText(jobWage[1]);
		viceProfessor.setColumns(10);
		viceProfessor.setBounds(484, 97, 128, 23);
		add(viceProfessor);

		JLabel label_3 = new JLabel("\u8BB2\u5E08\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(66, 222, 48, 18);
		add(label_3);

		teacher = new JTextField();
		teacher.setText(jobWage[2]);
		teacher.setColumns(10);
		teacher.setBounds(136, 220, 128, 23);
		add(teacher);

		assistant = new JTextField();
		assistant.setText(jobWage[3]);
		assistant.setColumns(10);
		assistant.setBounds(484, 220, 128, 23);
		add(assistant);

		president = new JTextField();
		president.setText(jobWage[4]);
		president.setColumns(10);
		president.setBounds(136, 160, 128, 23);
		add(president);

		JLabel label_7 = new JLabel("\u526F\u9662\u957F/\u526F\u4E66\u8BB0\uFF1A");
		label_7.setFont(new Font("宋体", Font.PLAIN, 16));
		label_7.setBounds(350, 161, 120, 21);
		add(label_7);

		vicePresident = new JTextField();
		vicePresident.setText(jobWage[5]);
		vicePresident.setColumns(10);
		vicePresident.setBounds(484, 161, 128, 23);
		add(vicePresident);

		JLabel label_8 = new JLabel("\u7CFB\\\u90E8\\\u4E2D\u5FC3\u4E3B\u4EFB\uFF1A");
		label_8.setFont(new Font("宋体", Font.PLAIN, 16));
		label_8.setBounds(0, 286, 128, 21);
		add(label_8);

		director = new JTextField();
		director.setText(jobWage[6]);
		director.setColumns(10);
		director.setBounds(136, 285, 128, 23);
		add(director);

		JLabel label_9 = new JLabel("\u7CFB\\\u90E8\\\u4E2D\u5FC3\u526F\u4E3B\u4EFB\uFF1A");
		label_9.setFont(new Font("宋体", Font.PLAIN, 16));
		label_9.setBounds(326, 286, 144, 21);
		add(label_9);

		viceDirector = new JTextField();
		viceDirector.setText(jobWage[7]);
		viceDirector.setColumns(10);
		viceDirector.setBounds(484, 286, 128, 23);
		add(viceDirector);

		JButton button = new JButton("\u66F4 \u65B0 \u53C2 \u6570");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jobWage = null;
				jobWage = professor.getText() + "," + viceProfessor.getText() + "," + teacher.getText() + ","
						+ assistant.getText() + "," + president.getText() + "," + vicePresident.getText() + ","
						+ director.getText() + "," + viceDirector.getText() + "," + other.getText();

				parameter.setBasicPerformance(jobWage);

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
		button.setBounds(272, 464, 159, 30);
		add(button);

	}
}
