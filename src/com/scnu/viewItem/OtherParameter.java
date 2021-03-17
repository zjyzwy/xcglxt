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

public class OtherParameter extends JPanel {
	private JTextField studentValue;
	private JTextField collegeLW;
	private String[] jobWage;

	public OtherParameter(Parameter parameter) {
		setLayout(null);

		JLabel label = new JLabel("\u5176 \u4ED6");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		label.setBounds(298, 30, 92, 40);
		add(label);

		JLabel label_6 = new JLabel("\u5B66\u751F\u7CFB\u6570\u8BA1\u7B97\u6807\u51C6\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 16));
		label_6.setBounds(10, 98, 153, 21);
		add(label_6);

		studentValue = new JTextField();
		studentValue.setText(parameter.getStudentValue());
		studentValue.setColumns(10);
		studentValue.setBounds(156, 98, 128, 23);
		add(studentValue);

		JLabel label_7 = new JLabel("\u5355\u4F4D\u8BFE\u916C\uFF1A");
		label_7.setFont(new Font("宋体", Font.PLAIN, 16));
		label_7.setBounds(385, 98, 92, 21);
		add(label_7);

		collegeLW = new JTextField();
		collegeLW.setText(parameter.getCollegeLW());
		collegeLW.setColumns(10);
		collegeLW.setBounds(467, 98, 128, 23);
		add(collegeLW);

		JButton button = new JButton("\u66F4 \u65B0 \u53C2 \u6570");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				parameter.setStudentValue(studentValue.getText());
				;
				parameter.setcollegeLW(collegeLW.getText());

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

	}
}
