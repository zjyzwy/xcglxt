package com.scnu.viewItem;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.scnu.dao.ParameterDao;
import com.scnu.modleItem.Parameter;

import java.util.Map;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleParameter extends JPanel {

	private JTextField professor;

	private JTextField other;
	private JTextField viceProfessor;
	private JTextField teacher;
	private JTextField assistant;
	private String[] jobWage;

	public TitleParameter(Parameter parameter) {
		setLayout(null);

		jobWage = parameter.getTitleValueWage();

		JLabel label = new JLabel("\u804C \u79F0 \u7CFB \u6570");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		label.setBounds(243, 30, 166, 40);
		add(label);

		JLabel label_1 = new JLabel("\u6559\u6388\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(60, 98, 54, 21);
		add(label_1);

		JLabel label_2 = new JLabel("\u526F\u6559\u6388\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(357, 99, 66, 18);
		add(label_2);

		JLabel label_5 = new JLabel("\u5176\u4ED6\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 16));
		label_5.setBounds(60, 273, 54, 21);
		add(label_5);

		professor = new JTextField();
		professor.setBounds(116, 98, 128, 23);
		professor.setText(jobWage[0]);
		add(professor);
		professor.setColumns(10);

		other = new JTextField();
		other.setBounds(116, 273, 128, 23);
		other.setText(jobWage[4]);
		add(other);
		other.setColumns(10);

		JLabel label_4 = new JLabel("\u52A9\u6559\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 16));
		label_4.setBounds(365, 181, 66, 20);
		add(label_4);

		viceProfessor = new JTextField();
		viceProfessor.setText(jobWage[1]);
		viceProfessor.setColumns(10);
		viceProfessor.setBounds(433, 98, 128, 23);
		add(viceProfessor);

		JLabel label_3 = new JLabel("\u8BB2\u5E08\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(60, 182, 48, 18);
		add(label_3);

		teacher = new JTextField();
		teacher.setText(jobWage[2]);
		teacher.setColumns(10);
		teacher.setBounds(116, 181, 128, 23);
		add(teacher);

		assistant = new JTextField();
		assistant.setText(jobWage[3]);
		assistant.setColumns(10);
		assistant.setBounds(433, 181, 128, 23);
		add(assistant);

		JButton button = new JButton("\u66F4 \u65B0 \u53C2 \u6570");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jobWage = null;
				jobWage = professor.getText() + "," + viceProfessor.getText() + "," + teacher.getText() + ","
						+ assistant.getText() + "," + other.getText();

				parameter.setTitleValue(jobWage);

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
		button.setBounds(263, 390, 159, 30);
		add(button);

	}
}
