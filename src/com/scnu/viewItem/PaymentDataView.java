package com.scnu.viewItem;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import com.scnu.dao.DataDao;
import com.scnu.modleItem.User;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.regex.Pattern;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class PaymentDataView extends JPanel {
	private JTable table;
	private int currentPage = 0;
	private int totalPage = 0;
	private int count = 20;
	private int dataLength = 0;
	private int radioJudge = 0;
	private boolean searchData = false;
	private String[] t_head = new String[] { "工号", "时间", "岗位工资", "薪级工资", "绩效工资", "住房补贴", "补发工资", "养老保险", "医疗保险", "补扣",
			"个税" };
	private String[][] t_data;
	private String[][] all_data;
	private String sql;
	private JTextField year;
	private JTextField month;

	/**
	 * Create the panel.
	 */
	public PaymentDataView(String flag, User user) {
		setLayout(null);
		if ("user".equals(flag))
			sql = "select * from payment where user_Id='" + user.getUserId() + "' order by payment_date desc";
		else if ("all".equals(flag))
			sql = "select * from payment order by user_Id,payment_date desc";
		else
			sql = "select * from payment where userId in(select userId from user where dapartment ='" + flag
					+ "' ) order by user_Id,payment_date desc";

		t_data = new DataDao().get_t_datas(this.sql);
		all_data = new DataDao().get_t_datas(this.sql);
		dataLength = all_data.length;
		totalPage = dataLength / count + (dataLength % count == 0 ? 0 : 1);
		t_data = changeNum(1);

		table = new JTable();
		table.setFont(new Font("宋体", Font.BOLD, 16));
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(t_data, t_head));
		fitTableColumns(table);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 44, 820, 371);
		add(scrollPane);
		scrollPane.setViewportView(table);

		JRadioButton three_month = new JRadioButton("\u8FD1\u4E09\u4E2A\u6708");
		three_month.setFont(new Font("宋体", Font.BOLD, 16));
		three_month.setBounds(14, 8, 105, 27);
		add(three_month);

		three_month.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				radioJudge = 1;
			}
		});

		JRadioButton half_year = new JRadioButton("\u8FD1\u534A\u5E74");
		half_year.setFont(new Font("宋体", Font.BOLD, 16));
		half_year.setBounds(125, 8, 93, 27);
		add(half_year);

		half_year.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				radioJudge = 2;
			}
		});

		JRadioButton a_year = new JRadioButton("\u6700\u8FD1\u4E00\u5E74");
		a_year.setFont(new Font("宋体", Font.BOLD, 16));
		a_year.setBounds(224, 8, 105, 27);
		add(a_year);

		a_year.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				radioJudge = 3;
			}
		});

		JRadioButton elseDetail = new JRadioButton("\u5176\u4ED6");
		elseDetail.setFont(new Font("宋体", Font.BOLD, 16));
		elseDetail.setBounds(329, 8, 69, 27);
		add(elseDetail);

		elseDetail.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				radioJudge = 4;
			}
		});

		ButtonGroup group = new ButtonGroup();
		group.add(three_month);
		group.add(half_year);
		group.add(a_year);
		group.add(elseDetail);

		year = new JTextField();
		year.setFont(new Font("宋体", Font.BOLD, 16));
		year.setBounds(403, 9, 86, 24);
		add(year);
		year.setColumns(10);

		JLabel label = new JLabel("\u5E74");
		label.setFont(new Font("宋体", Font.BOLD, 16));
		label.setBounds(503, 13, 22, 18);
		add(label);

		month = new JTextField();
		month.setFont(new Font("宋体", Font.BOLD, 16));
		month.setBounds(528, 9, 86, 24);
		add(month);
		month.setColumns(10);

		JLabel label_1 = new JLabel("\u6708");
		label_1.setFont(new Font("宋体", Font.BOLD, 16));
		label_1.setBounds(628, 12, 28, 18);
		add(label_1);

		JButton lastPage = new JButton("\u4E0A\u4E00\u9875");
		lastPage.setFont(new Font("宋体", Font.BOLD, 16));
		lastPage.setBounds(258, 428, 113, 27);
		add(lastPage);

		JButton nextPage = new JButton("\u4E0B\u4E00\u9875");
		nextPage.setFont(new Font("宋体", Font.BOLD, 16));
		nextPage.setBounds(480, 428, 113, 27);
		add(nextPage);

		lastPage.setEnabled(false);
		lastPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t_data = changeNum(-1);
				table.setModel(new DefaultTableModel(t_data, t_head));
				scrollPane.setViewportView(table);
				fitTableColumns(table);
				nextPage.setEnabled(true);
				if (currentPage == 1)
					lastPage.setEnabled(false);
				else
					lastPage.setEnabled(true);
			}
		});

		nextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t_data = changeNum(1);
				table.setModel(new DefaultTableModel(t_data, t_head));
				fitTableColumns(table);
				scrollPane.setViewportView(table);
				lastPage.setEnabled(true);
				if (currentPage == totalPage) {
					nextPage.setEnabled(false);
				} else {
					nextPage.setEnabled(true);
				}
			}
		});

		JButton search = new JButton("\u67E5\u8BE2");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchData = true;
				currentPage = 0;
				totalPage = 0;
				switch (radioJudge) {
				case 0:
					JOptionPane.showMessageDialog(null, "请选择要进行的操作！", null, JOptionPane.WARNING_MESSAGE);
					break;
				case 1:
					sql = "select * from payment where user_Id='" + user.getUserId()
							+ "'and date_sub(curdate(),interval 3 month)<=date(payment_date) order by payment_date desc";
					month.setText("");
					year.setText("");
					break;
				case 2:
					sql = "select * from payment where user_Id='" + user.getUserId()
							+ "'and date_sub(curdate(),interval 6 month)<=date(payment_date) order by payment_date desc";
					month.setText("");
					year.setText("");
					break;
				case 3:
					sql = "select * from payment where user_Id='" + user.getUserId()
							+ "'and date_sub(curdate(),interval 1 year)<=date(payment_date) order by payment_date desc";
					month.setText("");
					year.setText("");
					break;
				case 4:
					Calendar date = Calendar.getInstance();
					String curyear = String.valueOf(date.get(Calendar.YEAR));
					String curmonth = String.valueOf(date.get(Calendar.MONTH) + 1);
					if (year.getText().equals("") || month.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "请不要输入空白信息！", null, JOptionPane.WARNING_MESSAGE);
					} else if (isInteger(year.getText()) == false || isInteger(month.getText()) == false) {
						JOptionPane.showMessageDialog(null, "请输入数字！", null, JOptionPane.WARNING_MESSAGE);
					} else if (Integer.valueOf(year.getText()) > Integer.valueOf(curyear)
							|| Integer.valueOf(year.getText()) < 2005) {
						JOptionPane.showMessageDialog(null, "请输入正确年份！", null, JOptionPane.WARNING_MESSAGE);
					} else if (Integer.valueOf(month.getText()) > 12 || Integer.valueOf(month.getText()) < 0) {
						JOptionPane.showMessageDialog(null, "请输入正确月份！", null, JOptionPane.WARNING_MESSAGE);
					} else {
						if (Integer.valueOf(month.getText()) < 10)
							sql = "select * from payment where user_Id='" + user.getUserId()
									+ "' and substring(payment_date,1,7)='" + year.getText() + "-0" + month.getText()
									+ "'";
						else
							sql = "select * from payment where user_Id='" + user.getUserId()
									+ "' and substring(payment_date,1,7)='" + year.getText() + "-" + month.getText()
									+ "'";
					}
					break;
				}
				if (radioJudge != 0) {// 避免未选择操作也出数据
					all_data = new DataDao().get_t_datas(sql);
					dataLength = all_data.length;
					totalPage = dataLength / count + (dataLength % count == 0 ? 0 : 1);
					currentPage = 0;
					t_data = changeNum(1);
					table.setModel(new DefaultTableModel(t_data, t_head));
					lastPage.setEnabled(false);// 避免数组越界报错
					if (searchData)// 避免由于全局变量currentPage和totalPage在进行相同查询后再查询一次导致下一页按键不可用
						nextPage.setEnabled(true);
					if (totalPage == 1 || totalPage == 0) {
						lastPage.setEnabled(false);
						nextPage.setEnabled(false);
					}
					if (totalPage == currentPage)
						nextPage.setEnabled(false);
					fitTableColumns(table);
					scrollPane.setViewportView(table);
				}
			}
		});

		search.setFont(new Font("宋体", Font.BOLD, 16));
		search.setBounds(656, 8, 77, 27);
		add(search);

	}

	private void repaintThis() {
		this.repaint();
	}

	// 设置表格内容自适应并居中
	private void fitTableColumns(JTable myTable) {

		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		myTable.setDefaultRenderer(Object.class, r);

		myTable.setFocusable(false);

		JTableHeader header = myTable.getTableHeader();
		int rowCount = myTable.getRowCount();
		Enumeration columns = myTable.getColumnModel().getColumns();
		while (columns.hasMoreElements()) {
			TableColumn column = (TableColumn) columns.nextElement();
			int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
			int width = (int) myTable.getTableHeader().getDefaultRenderer()
					.getTableCellRendererComponent(myTable, column.getIdentifier(), false, false, -1, col)
					.getPreferredSize().getWidth();
			for (int row = 0; row < rowCount; row++) {
				int preferedWidth = (int) myTable.getCellRenderer(row, col)
						.getTableCellRendererComponent(myTable, myTable.getValueAt(row, col), false, false, row, col)
						.getPreferredSize().getWidth();
				width = Math.max(width, preferedWidth);
			}
			header.setResizingColumn(column);
			column.setWidth(width + myTable.getIntercellSpacing().width);
		}
	}

	private static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

	private String[][] changeNum(int change) {
		String[][] data = new String[count][11];
		if (change == 1) {
			for (int i = currentPage * count, j = 0; i < dataLength && j < count; i++, j++)
				data[j] = all_data[i];
		} else {
			for (int i = (currentPage - 2) * count, j = 0; j < count; i++, j++)
				data[j] = all_data[i];
		}
		currentPage = currentPage + change;
		return data;

	}
}
