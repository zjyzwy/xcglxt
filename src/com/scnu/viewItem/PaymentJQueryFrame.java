package com.scnu.viewItem;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.tree.DefaultMutableTreeNode;

import com.scnu.dao.UserDao;
import com.scnu.modleItem.User;
import com.scnu.viewItem.UserManager.myTree;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class PaymentJQueryFrame extends JPanel {

	/**
	 * Create the panel.
	 */
	
	JSplitPane splitPane;
	
	public PaymentJQueryFrame(String flag,User user) {
		setLayout(new BorderLayout(0, 0));
		splitPane = new JSplitPane();
		splitPane.setLeftComponent(new myTree());
		splitPane.setRightComponent(new PaymentDataView(flag,user));
		add(splitPane, BorderLayout.CENTER);

	}
	
	class myTree extends UserTree{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			splitPane.setLeftComponent(new myTree());
		}

		@Override
		public void leftNodeSelected(DefaultMutableTreeNode node) {
			// TODO �Զ����ɵķ������
//			User user = new UserDao().getUserByName(node.toString());
//			
//			splitPane.setRightComponent(new PaymentDataView("user", user));
			
			//���ڽ�������ļ���ΪҶ�ӽڵ��׳����쳣
			if(!node.getParent().toString().equals("���ѧԺ")) {
				User user = new UserDao().getUserByName(node.toString());
			
				splitPane.setRightComponent(new PaymentDataView("user", user));
			}
		}
		
	}

}
