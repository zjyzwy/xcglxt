package com.scnu.viewItem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.scnu.dao.ParameterDao;
import com.scnu.dao.PayoffDao;
import com.scnu.dao.TermTimeDao;
import com.scnu.modleItem.Parameter;
import com.scnu.modleItem.Payoff;
import com.scnu.modleItem.User;

import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;

public class PayoffView extends JPanel {
	private JTextField userId;
	private JTextField userName;
	private JTextField fullTime;
	private JTextField openTime;
	private JTextField phoenixTime;
	private JTextField adult;
	private JTextField leader;
	private JTextField middle;
	private JTextField administration;
	private JTextField jobSubsidies;
	private JTextField phoneSubsidies;
	private JTextField lifeSubsidies;
	private JTextField science;
	private JTextField festivalSubsidies;
	private JTextField overtimeSubsidies;
	private JTextField temporarySubsidy;
	private JTextField subOrAddWage;
	private JTextField other;
	private JTextField allWage;
	private JTextField description;
	private Payoff payoff;
	private JButton submit;
	private JButton update;
	private JComboBox term;

	/**
	 * Create the panel.
	 */
	public PayoffView(User user) {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(102, 47, 54, 18);
		add(lblNewLabel);

		userId = new JTextField();
		userId.setFont(new Font("宋体", Font.BOLD, 18));
		userId.setBounds(170, 42, 86, 24);
		add(userId);
		userId.setColumns(10);
		userId.setEnabled(false);
		userId.setText(user.getUserId());

		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_1.setBounds(286, 47, 72, 18);
		add(lblNewLabel_1);

		userName = new JTextField();
		userName.setFont(new Font("宋体", Font.BOLD, 18));
		userName.setBounds(356, 42, 86, 24);
		add(userName);
		userName.setColumns(10);
		userName.setEnabled(false);
		userName.setText(user.getUserName());

		JLabel lblNewLabel_2 = new JLabel("\u5B66\u671F\uFF1A");
		lblNewLabel_2.setBounds(498, 47, 72, 18);
		add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("\u672C\u79D1\u6559\u5B66\u4E1A\u7EE9\uFF1A");
		lblNewLabel_4.setBounds(26, 114, 111, 18);
		add(lblNewLabel_4);

		fullTime = new JTextField();
		fullTime.setFont(new Font("宋体", Font.BOLD, 18));
		fullTime.setBounds(165, 111, 98, 24);
		add(fullTime);
		fullTime.setColumns(10);
		fullTime.setEnabled(false);

		JLabel lblNewLabel_5 = new JLabel("\u5F00\u653E\u5B66\u9662\u6559\u5B66\u4E1A\u7EE9\uFF1A");
		lblNewLabel_5.setBounds(26, 168, 140, 18);
		add(lblNewLabel_5);

		openTime = new JTextField();
		openTime.setFont(new Font("宋体", Font.BOLD, 18));
		openTime.setBounds(165, 165, 98, 24);
		add(openTime);
		openTime.setColumns(10);
		openTime.setEnabled(false);

		JLabel lblNewLabel_6 = new JLabel("\u51E4\u51F0\u5B66\u9662\u6559\u5B66\u4E1A\u7EE9\uFF1A");
		lblNewLabel_6.setBounds(26, 222, 140, 18);
		add(lblNewLabel_6);

		phoenixTime = new JTextField();
		phoenixTime.setFont(new Font("宋体", Font.BOLD, 18));
		phoenixTime.setBounds(165, 219, 98, 24);
		add(phoenixTime);
		phoenixTime.setColumns(10);
		phoenixTime.setEnabled(false);

		JLabel label = new JLabel("\u6210\u4EBA\u6559\u80B2\u6559\u5B66\u4E1A\u7EE9\uFF1A");
		label.setBounds(26, 279, 140, 18);
		add(label);

		adult = new JTextField();
		adult.setFont(new Font("宋体", Font.BOLD, 18));
		adult.setBounds(165, 276, 97, 24);
		add(adult);
		adult.setColumns(10);
		adult.setEnabled(false);

		JLabel label_1 = new JLabel("\u5B66\u6821\u9886\u5BFC\u7BA1\u7406\u4E1A\u7EE9\uFF1A");
		label_1.setBounds(302, 114, 140, 18);
		add(label_1);

		leader = new JTextField();
		leader.setFont(new Font("宋体", Font.BOLD, 18));
		leader.setBounds(434, 111, 109, 24);
		add(leader);
		leader.setColumns(10);
		leader.setEnabled(false);

		JLabel label_2 = new JLabel("\u5B66\u9662\u4E2D\u5C42\u7BA1\u7406\u4E1A\u7EE9\uFF1A");
		label_2.setBounds(298, 168, 144, 18);
		add(label_2);

		middle = new JTextField();
		middle.setFont(new Font("宋体", Font.BOLD, 18));
		middle.setBounds(434, 165, 109, 24);
		add(middle);
		middle.setColumns(10);
		middle.setEnabled(false);

		JLabel lblNewLabel_7 = new JLabel("\u884C\u653F\u6559\u8F85\u7BA1\u7406\u4E1A\u7EE9\uFF1A");
		lblNewLabel_7.setBounds(302, 222, 140, 18);
		add(lblNewLabel_7);

		administration = new JTextField();
		administration.setFont(new Font("宋体", Font.BOLD, 18));
		administration.setBounds(435, 219, 108, 24);
		add(administration);
		administration.setColumns(10);
		administration.setEnabled(false);

		JLabel lblNewLabel_8 = new JLabel("\u804C\u52A1\u8865\u8D34\uFF1A");
		lblNewLabel_8.setBounds(567, 114, 86, 18);
		add(lblNewLabel_8);

		jobSubsidies = new JTextField();
		jobSubsidies.setFont(new Font("宋体", Font.BOLD, 18));
		jobSubsidies.setBounds(643, 111, 98, 24);
		add(jobSubsidies);
		jobSubsidies.setColumns(10);
		jobSubsidies.setEnabled(false);

		JLabel label_3 = new JLabel("\u7535\u8BDD\u8865\u8D34\uFF1A");
		label_3.setBounds(567, 168, 86, 18);
		add(label_3);

		phoneSubsidies = new JTextField();
		phoneSubsidies.setFont(new Font("宋体", Font.BOLD, 18));
		phoneSubsidies.setBounds(643, 165, 98, 24);
		add(phoneSubsidies);
		phoneSubsidies.setColumns(10);
		phoneSubsidies.setEnabled(false);

		JLabel lblNewLabel_9 = new JLabel("\u751F\u6D3B\u8865\u8D34\uFF1A");
		lblNewLabel_9.setBounds(567, 222, 86, 18);
		add(lblNewLabel_9);

		lifeSubsidies = new JTextField();
		lifeSubsidies.setFont(new Font("宋体", Font.BOLD, 18));
		lifeSubsidies.setBounds(643, 219, 98, 24);
		add(lifeSubsidies);
		lifeSubsidies.setColumns(10);
		lifeSubsidies.setEnabled(false);

		JLabel lblNewLabel_10 = new JLabel("\u79D1\u7814\u4E1A\u7EE9\uFF1A");
		lblNewLabel_10.setBounds(311, 279, 131, 18);
		add(lblNewLabel_10);

		science = new JTextField();
		science.setFont(new Font("宋体", Font.BOLD, 18));
		science.setBounds(434, 276, 109, 24);
		add(science);
		science.setColumns(10);
		science.setEnabled(false);

		JLabel label_4 = new JLabel("\u8282\u65E5\u8865\u8D34\uFF1A");
		label_4.setBounds(567, 279, 86, 18);
		add(label_4);

		festivalSubsidies = new JTextField();
		festivalSubsidies.setFont(new Font("宋体", Font.BOLD, 18));
		festivalSubsidies.setBounds(643, 276, 98, 24);
		add(festivalSubsidies);
		festivalSubsidies.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("\u52A0\u73ED\u8865\u8D34\uFF1A");
		lblNewLabel_11.setBounds(26, 340, 98, 18);
		add(lblNewLabel_11);

		overtimeSubsidies = new JTextField();
		overtimeSubsidies.setFont(new Font("宋体", Font.BOLD, 18));
		overtimeSubsidies.setBounds(165, 337, 97, 24);
		add(overtimeSubsidies);
		overtimeSubsidies.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("\u4E34\u65F6\u8865\u8D34\uFF1A");
		lblNewLabel_12.setBounds(302, 340, 91, 18);
		add(lblNewLabel_12);

		temporarySubsidy = new JTextField();
		temporarySubsidy.setFont(new Font("宋体", Font.BOLD, 18));
		temporarySubsidy.setBounds(434, 337, 109, 24);
		add(temporarySubsidy);
		temporarySubsidy.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("\u6263\u51CF\u3001\u8865\u53D1\uFF1A");
		lblNewLabel_13.setBounds(557, 340, 98, 18);
		add(lblNewLabel_13);

		subOrAddWage = new JTextField();
		subOrAddWage.setFont(new Font("宋体", Font.BOLD, 18));
		subOrAddWage.setBounds(643, 337, 98, 24);
		add(subOrAddWage);
		subOrAddWage.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("\u5176\u4ED6\u4E1A\u7EE9\uFF1A");
		lblNewLabel_14.setBounds(26, 394, 86, 18);
		add(lblNewLabel_14);

		other = new JTextField();
		other.setFont(new Font("宋体", Font.BOLD, 18));
		other.setBounds(165, 391, 98, 24);
		add(other);
		other.setColumns(10);

		JLabel label_5 = new JLabel("\u672C\u6708\u5408\u8BA1\uFF1A");
		label_5.setBounds(302, 394, 91, 18);
		add(label_5);

		allWage = new JTextField();
		allWage.setFont(new Font("宋体", Font.BOLD, 18));
		allWage.setEnabled(false);
		allWage.setBounds(433, 391, 110, 24);
		add(allWage);
		allWage.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("\u8865\u5145\u8BF4\u660E\uFF1A");
		lblNewLabel_15.setFont(new Font("宋体", Font.BOLD, 18));
		lblNewLabel_15.setBounds(26, 443, 98, 34);
		add(lblNewLabel_15);

		description = new JTextField();
		description.setFont(new Font("宋体", Font.BOLD, 18));
		description.setBounds(167, 443, 476, 37);
		add(description);
		description.setColumns(10);

		term = new JComboBox();
		term.setFont(new Font("宋体", Font.PLAIN, 16));
		Vector<String> dateTime = new TermTimeDao().getTermTimes();
		String[] dateTimes = new String[dateTime.size() + 1];
		dateTimes[0] = "\u8BF7\u9009\u62E9";
		for (int i = 1; i < dateTime.size() + 1; i++) {
			dateTimes[i] = dateTime.get(i - 1);
		}
		term.setModel(new DefaultComboBoxModel(dateTimes));
		term.setBounds(584, 45, 140, 24);
		add(term);

		term.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNull();
				java.text.DecimalFormat format = new java.text.DecimalFormat("#.00");

				if (user.getDepartment().equals("学院领导")) {
					leader.setText(getManagePayment(user) + "");
				}
				String userIds = user.getUserId();
				Vector<String> payoff = null;
				payoff = new PayoffDao().getPayoff(userIds, term.getSelectedItem().toString());
				if (payoff.size() > 0) {
					// 非专任教师
					if (!user.getmTOA_State().equals("专任教师")) {
						boolean flag = false;
						// 检测是否有课时
						for (int i = 9; i <= 12; i++) {
							if (!(payoff.get(i) + "").equals("null")) {
								flag = true;
							}
						}
						if (flag) {
							int course = 0;
							for (int i = 9; i <= 12; i++) {
								if (!payoff.get(i).equals("null")) {
									course += Integer.parseInt(payoff.get(i));
								}
							}
							jobSubsidies.setText(format.format(getClassPayment(user, course / 6 / 6)));
							phoneSubsidies.setText(format.format(getClassPayment(user, course / 6 / 6)));
							lifeSubsidies.setText(format.format(getClassPayment(user, course / 6 / 6)));
						}
					}

					if (!(payoff.get(9) + "").equals("null")) {
						fullTime.setText(format.format(getClassPayment(user, Integer.parseInt(payoff.get(9)) / 6))); // 保留两位小数
					}
					if (!(payoff.get(10) + "").equals("null")) {
						openTime.setText(format.format(getClassPayment(user, Integer.parseInt(payoff.get(10)) / 6)));
					}
					if (!(payoff.get(11) + "").equals("null")) {
						phoenixTime.setText(format.format(getClassPayment(user, Integer.parseInt(payoff.get(11)) / 6)));
					}
					if (!(payoff.get(12) + "").equals("null")) {
						adult.setText(format.format(getClassPayment(user, Integer.parseInt(payoff.get(12)) / 6)));
					}

					if (!(payoff.get(16) + "").equals("null")) {
						festivalSubsidies.setText(payoff.get(16));
					}

					if (!(payoff.get(17) + "").equals("null")) {
						overtimeSubsidies.setText(payoff.get(17));
					}

					if (!(payoff.get(18) + "").equals("null")) {
						temporarySubsidy.setText(payoff.get(18));
					}

					if (!(payoff.get(8) + "").equals("null")) {
						subOrAddWage.setText(payoff.get(8));
					}

					if (!(payoff.get(19) + "").equals("null")) {
						other.setText(payoff.get(19));
					}

					if (!(payoff.get(20) + "").equals("null")) {
						allWage.setText(payoff.get(20));
					}

					if (!(payoff.get(21) + "").equals("null")) {
						description.setText(payoff.get(21));
					}

					if ((payoff.get(20) + "").equals("null")) {
						submit.setEnabled(true);
						update.setEnabled(false);
					} else {
						submit.setEnabled(false);
						update.setEnabled(true);
					}
				} else {
					submit.setEnabled(true);
					update.setEnabled(false);
				}

				// 检查日期是否为10号
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("dd");
				if (!sdf.format(date).equals("10")) {
					 //submit.setEnabled(false);
					 //update.setEnabled(false);
				}

				getAllWage(user);
			}
		});

		submit = new JButton("\u63D0\u4EA4");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int n = 0;
				n = new PayoffDao().updatePayoff(getNewPayoff(user));
				if (n != 1) {
					n = new PayoffDao().addPayoff(getNewPayoff(user));
				}
				if (n == 1) {
					getAllWage(user);
					JOptionPane.showMessageDialog(null, "提交成功！", "提示信息", JOptionPane.OK_OPTION);
					submit.setEnabled(false);
					update.setEnabled(true);

				} else {
					JOptionPane.showMessageDialog(null, "提交失败！", "提示信息", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		submit.setBounds(198, 511, 113, 27);
		add(submit);

		update = new JButton("\u66F4\u65B0");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n = 0;
				n = new PayoffDao().updatePayoff(getNewPayoff(user));

				if (n == 1) {
					getAllWage(user);
					JOptionPane.showMessageDialog(null, "工资更新成功！", "提示信息", JOptionPane.OK_OPTION);
				} else {
					JOptionPane.showMessageDialog(null, "工资更新失败！", "提示信息", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		update.setBounds(416, 511, 113, 27);
		add(update);
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		df = new SimpleDateFormat("M");

	}

	private Payoff getNewPayoff(User user) {
		Payoff payoff = new Payoff();
		payoff.setJobSubsidies(jobSubsidies.getText());
		payoff.setPhoneSubsidies(phoneSubsidies.getText());
		payoff.setLifeSubsidies(lifeSubsidies.getText());
		payoff.setFestivalSubsidies(festivalSubsidies.getText());
		payoff.setOvertimeSubsidies(overtimeSubsidies.getText());
		payoff.setTemporarySubsidy(temporarySubsidy.getText());
		payoff.setOther(other.getText());
		payoff.setSubOrAddWage(subOrAddWage.getText());
		payoff.setAllwage(allWage.getText());
		payoff.setDescription(description.getText());
		Vector<String> previous = new PayoffDao().getPayoff(user.getUserId(), term.getSelectedItem().toString());
		if (previous.size() > 0) {
			payoff.setUserId(previous.get(0));
			payoff.setTermTime(previous.get(1));
			payoff.setJobWage(previous.get(2));
			payoff.setBasicPerformanceWage(previous.get(3));
			payoff.setLessonWage(previous.get(4));
			payoff.setJobManageWage(previous.get(5));
			payoff.setFullTime(previous.get(9));
			payoff.setOpenTime(previous.get(10));
			payoff.setPhoenixTime(previous.get(11));
			payoff.setAdultTime(previous.get(12));
		} else {
			payoff.setUserId(user.getUserId());
			payoff.setTermTime(term.getSelectedItem().toString());
			new PayoffDao().addPayoff(payoff);
		}

		return payoff;
	}

	private float getManagePayment(User user) {
		Parameter pt = new ParameterDao().getParameter("软件学院");
		String coefficient[] = pt.getJobManagePerformanceWage();
		String mTAO = user.getmTOA_State();
		float Av = getAv();
		if (mTAO.equals("院长") || mTAO.equals("书记")) {
			return Av * Float.parseFloat(coefficient[0]);
		} else if (mTAO.equals("副院长") || mTAO.equals("副书记")) {
			return Av * Float.parseFloat(coefficient[1]);
		} else if (mTAO.equals("系主任") || mTAO.equals("部主任") || mTAO.equals("中心主任")) {
			return Av * Float.parseFloat(coefficient[2]);
		} else if (mTAO.equals("系副主任") || mTAO.equals("部副主任") || mTAO.equals("中心副主任")) {
			return Av * Float.parseFloat(coefficient[3]);
		} else {
			return Av;
		}
	}

	private float getAv() {

		float Av = 0;
		Vector<Vector<String>> payoffVector = new PayoffDao().getmTAO_StatePayoff(term.getSelectedItem().toString());
		int course = 0;
		if (payoffVector.size() >= 1) {
			for (Vector<String> x : payoffVector) {
				for (int i = 9; i <= 12; i++) {
					if (!(x.get(i) + "").equals("null")) {
						course += Integer.parseInt(x.get(i));
					}
				}
			}
			Av = course * 35 / 6 / payoffVector.size();
		} else {
			Av = 0;
		}
		return Av;
	}

	private float getJobPayment(User user) {
		Parameter pt = new ParameterDao().getParameter("软件学院");
		String coefficient[] = pt.getJobWage();
		String bas = user.getBaseAllowanceState();
		if (bas.equals("教授")) {
			return Float.parseFloat(coefficient[0]);
		} else if (bas.equals("副教授")) {
			return Float.parseFloat(coefficient[1]);
		} else if (bas.equals("讲师")) {
			return Float.parseFloat(coefficient[2]);
		} else if (bas.equals("助教")) {
			return Float.parseFloat(coefficient[3]);
		} else if (bas.equals("院长") || bas.equals("书记")) {
			return Float.parseFloat(coefficient[4]);
		} else if (bas.equals("副院长") || bas.equals("副书记")) {
			return Float.parseFloat(coefficient[5]);
		} else if (bas.equals("系主任") || bas.equals("部主任") || bas.equals("中心主任")) {
			return Float.parseFloat(coefficient[6]);
		} else if (bas.equals("系副主任") || bas.equals("部副主任") || bas.equals("中心副主任")) {
			return Float.parseFloat(coefficient[7]);
		} else {
			return Float.parseFloat(coefficient[8]);
		}
	}

	private float basicPerformancePayment(User user) {
		Parameter pt = new ParameterDao().getParameter("软件学院");
		String coefficient[] = pt.getBasicPerformanceWage();
		String bas = user.getBaseAllowanceState();
		if (bas.equals("教授")) {
			return Float.parseFloat(coefficient[0]);
		} else if (bas.equals("副教授")) {
			return Float.parseFloat(coefficient[1]);
		} else if (bas.equals("讲师")) {
			return Float.parseFloat(coefficient[2]);
		} else if (bas.equals("助教")) {
			return Float.parseFloat(coefficient[3]);
		} else if (bas.equals("院长") || bas.equals("书记")) {
			return Float.parseFloat(coefficient[4]);
		} else if (bas.equals("副院长") || bas.equals("副书记")) {
			return Float.parseFloat(coefficient[5]);
		} else if (bas.equals("系主任") || bas.equals("部主任") || bas.equals("中心主任")) {
			return Float.parseFloat(coefficient[6]);
		} else if (bas.equals("系副主任") || bas.equals("部副主任") || bas.equals("中心副主任")) {
			return Float.parseFloat(coefficient[7]);
		} else {
			return Float.parseFloat(coefficient[8]);
		}
	}

	private float getClassPayment(User user, int course) {
		Parameter pt = new ParameterDao().getParameter("软件学院");
		String coefficient[] = pt.getTitleValueWage();
		String job = user.getBaseAllowanceState();
		float jobValue = 0;
		if (job.equals("教授")) {
			jobValue = Float.parseFloat(coefficient[0]);
		} else if (job.equals("副教授")) {
			jobValue = Float.parseFloat(coefficient[1]);
		} else if (job.equals("讲师")) {
			jobValue = Float.parseFloat(coefficient[2]);
		} else {
			jobValue = Float.parseFloat(coefficient[3]);
		}
		// 获得学生系数
		float studentValue = Float.parseFloat(pt.getStudentValue()) / 60;
		if (studentValue < 1) {
			studentValue = 1;
		}
		return jobValue * course * studentValue * 35;
	}

	private void setNull() {
		JTextField wageType[] = new JTextField[16];
		wageType[0] = fullTime;
		wageType[1] = openTime;
		wageType[2] = phoenixTime;
		wageType[3] = adult;
		wageType[4] = leader;
		wageType[5] = jobSubsidies;
		wageType[6] = phoneSubsidies;
		wageType[7] = lifeSubsidies;
		wageType[8] = festivalSubsidies;
		wageType[9] = overtimeSubsidies;
		wageType[10] = temporarySubsidy;
		wageType[11] = subOrAddWage;
		wageType[12] = other;
		wageType[13] = allWage;
		wageType[14] = description;

		for (int i = 0; i < 15; i++) {
			wageType[i].setText("");
		}
	}

	private void getAllWage(User user) {
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
		float sum = 0;

		JTextField wageType[] = new JTextField[16];
		wageType[0] = fullTime;
		wageType[1] = openTime;
		wageType[2] = phoenixTime;
		wageType[3] = adult;
		wageType[4] = leader;
		wageType[5] = jobSubsidies;
		wageType[6] = phoneSubsidies;
		wageType[7] = lifeSubsidies;
		wageType[8] = festivalSubsidies;
		wageType[9] = overtimeSubsidies;
		wageType[10] = temporarySubsidy;
		wageType[11] = subOrAddWage;
		wageType[12] = other;

		for (int i = 0; i < 13; i++) {
			if (!wageType[i].getText().equals("")) {
				sum += Float.parseFloat(wageType[i].getText());
			}
		}
		sum += getJobPayment(user);
		sum += basicPerformancePayment(user);
		allWage.setText(df.format(sum));
	}
}
