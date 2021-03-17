package com.scnu.viewItem;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.scnu.dao.PayoffDao;
import com.scnu.dao.TermTimeDao;
import com.scnu.dao.WorkloadEntryDao;
import com.scnu.modleItem.Payoff;
import com.scnu.modleItem.User;
import com.scnu.modleItem.Workload;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;

public class WorkloadEntry extends JPanel {
	private JTextField userId;
	private JTextField fullTime;
	private JTextField openTime;
	private JTextField userName;
	private JTextField phoenixTime;
	private JTextField adultTime;
	String termTime[] = null;
	JButton submit = new JButton("\u63D0\u4EA4");
	JButton update = new JButton("\u66F4\u65B0");
	JComboBox term = new JComboBox();

	/**
	 * Create the panel.
	 */

	public WorkloadEntry(User user) {
		setLayout(null);

		JLabel label = new JLabel("\u6559  \u5B66  \u5DE5  \u4F5C  \u91CF");
		label.setFont(new Font("宋体", Font.PLAIN, 30));
		label.setBounds(250, 11, 318, 58);
		add(label);

		JLabel label_1 = new JLabel("\u5B66\u5E74\u5EA6\uFF08\u5B66\u671F\uFF09:");
		label_1.setBounds(100, 90, 130, 30);
		add(label_1);

		JLabel tID = new JLabel("\u6559 \u5E08 \u7F16 \u53F7 \uFF1A");
		tID.setBounds(96, 140, 124, 26);
		add(tID);

		JLabel label1 = new JLabel("\u5168\u65E5\u5236\u672C\u603B\u8BFE\u5B66\u65F6\uFF1A");
		label1.setBounds(69, 190, 140, 30);
		add(label1);

		JLabel label3 = new JLabel("\u51E4\u51F0\u5B66\u9662\u603B\u8BFE\u65F6\uFF1A");
		label3.setBounds(100, 240, 130, 30);
		add(label3);
		term.setFont(new Font("宋体", Font.PLAIN, 16));

		term.setBounds(230, 90, 150, 30);
		add(term);
		String sql = "SELECT term FROM termTime GROUP BY term ORDER BY term DESC";
		termTime = new TermTimeDao().getTermInfo(sql);
		for (int i = 0; i < termTime.length; i++) {
			term.addItem(termTime[i]);
		}

		JButton addNewTerm = new JButton("\u6DFB\u52A0");
		addNewTerm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k = 1;
				String input = JOptionPane.showInputDialog(null, "请按该格式输入：2019-2020(2)", "学年信息", JOptionPane.OK_OPTION);
				termTime = new TermTimeDao().getTermInfo(sql);
				TermTimeDao termDao = new TermTimeDao();
				for (int i = 0; i < termTime.length; i++) {
					if (input.equals(termTime[i]) || input.equals(""))
						k = 0;
				}
				if (k == 1) {

					int n = termDao.addTerm(input);
					if (n == 1) {
						JOptionPane.showMessageDialog(null, "添加成功", "Success", JOptionPane.OK_OPTION);
						term.removeAllItems();
						termTime = termDao.getTermInfo(sql);
						for (int i = 0; i < termTime.length; i++) {
							term.addItem(termTime[i]);
						}
					} else {
						JOptionPane.showMessageDialog(null, "添加失败", "Error", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "添加失败", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		addNewTerm.setBounds(380, 90, 72, 30);
		add(addNewTerm);

		userId = new JTextField(null);
		userId.setFont(new Font("宋体", Font.BOLD, 18));
		userId.setEnabled(false);
		userId.setBounds(230, 140, 120, 30);
		add(userId);
		userId.setColumns(10);

		fullTime = new JTextField();
		fullTime.setFont(new Font("宋体", Font.BOLD, 18));
		fullTime.setBounds(230, 190, 120, 30);
		add(fullTime);
		fullTime.setColumns(10);

		openTime = new JTextField();
		openTime.setFont(new Font("宋体", Font.BOLD, 18));
		openTime.setBounds(230, 240, 120, 30);
		add(openTime);
		openTime.setColumns(10);

		JLabel tName = new JLabel("\u6559 \u5E08 \u59D3 \u540D\uFF1A");
		tName.setBounds(460, 140, 100, 30);
		add(tName);

		JLabel label2 = new JLabel("\u5F00\u653E\u5B66\u9662\u603B\u8BFE\u65F6\uFF1A");
		label2.setBounds(450, 190, 130, 30);
		add(label2);

		JLabel label4 = new JLabel("\u6210\u4EBA\u6559\u80B2\u603B\u8BFE\u65F6\uFF1A");
		label4.setBounds(450, 240, 130, 30);
		add(label4);

		userName = new JTextField();
		userName.setFont(new Font("宋体", Font.BOLD, 18));
		userName.setEnabled(false);
		userName.setBounds(580, 138, 120, 30);
		add(userName);
		userName.setColumns(10);

		phoenixTime = new JTextField();
		phoenixTime.setFont(new Font("宋体", Font.BOLD, 18));
		phoenixTime.setBounds(580, 190, 120, 30);
		add(phoenixTime);
		phoenixTime.setColumns(10);

		adultTime = new JTextField();
		adultTime.setFont(new Font("宋体", Font.BOLD, 18));
		adultTime.setBounds(580, 240, 120, 30);
		add(adultTime);
		adultTime.setColumns(10);

		submit.setEnabled(false);

		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql1 = "SELECT username FROM USER WHERE userId='" + userId.getText() + "' GROUP BY username ";
				String sql2 = "SELECT term FROM workload WHERE userId='" + userId.getText() + "'";
				String[] termN = new TermTimeDao().getTermInfo(sql2);
				String[] name = new TermTimeDao().getTermInfo(sql1);
				int k = 0;
				for (int i = 0; i < termN.length; i++) {
					if (term.getSelectedItem().toString().equals(termN[i]))
						k = 1;
				}
				if (k == 1) {
					JOptionPane.showMessageDialog(null, "该学年已存在", "Error", JOptionPane.WARNING_MESSAGE);
				} else if (name[0].equals(userName.getText()) && k == 0) {
					Workload workload = new Workload();
					workload.setTerm(term.getSelectedItem().toString());
					workload.setUserID(userId.getText());
					workload.setUserName(userName.getText());
					workload.setFullTime(fullTime.getText());
					workload.setOpenTime(openTime.getText());
					workload.setPhoenixTime(phoenixTime.getText());
					workload.setAdultTime(adultTime.getText());
					WorkloadEntryDao workloadDao = new WorkloadEntryDao();

					Payoff payoff = new Payoff();
					payoff.setUserId(userId.getText());
					payoff.setTermTime(term.getSelectedItem().toString());
					payoff.setFullTime(fullTime.getText());
					payoff.setOpenTime(openTime.getText());
					payoff.setPhoenixTime(phoenixTime.getText());
					payoff.setAdultTime(adultTime.getText());

					int n = workloadDao.addWorkload(workload);

					int m = new PayoffDao().updatePayoff(payoff);
					if (m != 1)
						new PayoffDao().addPayoff(payoff);

					if (n == 1) {
						JOptionPane.showMessageDialog(null, "插入成功", "Success", JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "插入失败", "Error", JOptionPane.WARNING_MESSAGE);
					}
					k = 1;
				} else {
					JOptionPane.showMessageDialog(null, "插入失败", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		submit.setBounds(280, 310, 100, 30);
		add(submit);

		update.setEnabled(false);
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		update.setBounds(468, 310, 100, 30);
		add(update);

		JLabel lblNewLabel_3 = new JLabel(
				"\u8BF4\u660E\uFF1A1\u3001\u5DE5\u4F5C\u91CF\u6BCF\u4E2A\u5B66\u671F\u53EA\u9700\u8981\u586B\u5199\u4E00\u6B21\u3002\r\n");
		lblNewLabel_3.setBounds(165, 380, 440, 25);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel(
				"2\u3001\u603B\u4E0A\u8BFE\u65F6=\u57FA\u672C\u8BFE\u65F6\u603B\u6570*\uFF081+\u8BFE\u7A0B\u7C7B\u578B\u7CFB\u6570+\u5B66\u751F\u4EBA\u6570\u7CFB\u6570\uFF09");
		lblNewLabel_4.setBounds(165, 405, 440, 25);
		add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel(
				"   \u8BFE\u7A0B\u7CFB\u6570\uFF1A\u672C\u79D12\uFF0C\u5176\u4ED62.5\uFF1B\r\n\t  ");
		lblNewLabel_5.setBounds(165, 430, 440, 25);
		add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel(
				"   \u5B66\u751F\u4EBA\u6570\u7CFB\u6570\uFF1A<80,\u7CFB\u6570\u4E3A0\uFF1B80-120\uFF0C\u7CFB\u6570\u4E3A0.1\uFF1B");
		lblNewLabel_6.setBounds(165, 455, 440, 25);
		add(lblNewLabel_6);

	}

	public void setUserId(String st) {
		userId.setText(st);
	}

	public void setName(String st) {
		userName.setText(st);
	}

}
