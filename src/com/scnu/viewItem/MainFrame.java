package com.scnu.viewItem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.scnu.modleItem.User;

import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrame frame = new MainFrame();
//					frame.setVisible(true);
//					frame.setLocationRelativeTo(null);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MainFrame(User user) {
		setTitle("н�����ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 964, 652);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel userInfoView = new UserInfoViewFrame(user);//�û���Ϣ
		tabbedPane.addTab("\u7528\u6237\u4FE1\u606F", null, userInfoView, null);
		
		JPanel paymentDataView = new PaymentJQueryFrame("all",user);//���ʲ�ѯ
		tabbedPane.addTab("\u5DE5\u8D44\u67E5\u8BE2", null, paymentDataView, null);
		
		JPanel userManager = new UserManager();//�û�����
		tabbedPane.addTab("\u7528\u6237\u7BA1\u7406", null, userManager, null);
		
		if(user.getLoginAuthority()!=null&&user.getLoginAuthority().equals("����Ա")) {
		
		JPanel payoffView = new PayoffFrame(user);//���ʷ���
		tabbedPane.addTab("\u5DE5\u8D44\u53D1\u653E", null, payoffView, null);
		
		
		JPanel workloadInsertView = new WorkloadEntryManager(user);//������¼��
		//tabbedPane.addTab("\u5DE5\u8D44\u91CF\u5F55\u5165", null, workloadInsertView, null);
		tabbedPane.addTab("������¼��", null, workloadInsertView, null);
		
		JPanel parameterSettingView =new ParameterFrame("���ѧԺ");//��������
		tabbedPane.addTab("\u53C2\u6570\u8BBE\u7F6E", null, parameterSettingView, null);
		}
	}

}
