package com.scnu.viewItem;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JSplitPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;

import com.scnu.dao.UserDao;
import com.scnu.modleItem.User;
import com.scnu.viewItem.UserManager.myTree;

public class UserInfoViewFrame extends JPanel {

	/**
	 * Create the panel.
	 */
	
	JSplitPane splitPane;
	public UserInfoViewFrame(User user) {
		setLayout(new BorderLayout(0, 0));
		
		splitPane = new JSplitPane();
		splitPane.setLeftComponent(new MyTree());
		splitPane.setRightComponent(new UserInfoView(user));
		add(splitPane, BorderLayout.CENTER);

	}

	class MyTree extends UserTree {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			splitPane.setLeftComponent(new MyTree());
		}

		@Override
		public void leftNodeSelected(DefaultMutableTreeNode node) {
			// TODO �Զ����ɵķ������
//			User user = new UserDao().getUserByName(node.toString());
//			splitPane.setRightComponent(new UserInfoView(user));
			
			//���ڽ�������ļ���ΪҶ�ӽڵ��׳����쳣
			if(!node.getParent().toString().equals("���ѧԺ")) {
				User user = new UserDao().getUserByName(node.toString());
			
				splitPane.setRightComponent(new UserInfoView(user));
			}
			
		}
		
	}
}
