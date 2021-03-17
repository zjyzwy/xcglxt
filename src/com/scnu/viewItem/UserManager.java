package com.scnu.viewItem;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JSplitPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;

import com.scnu.dao.UserDao;
import com.scnu.modleItem.User;

public class UserManager extends JPanel {

	/**
	 * Create the panel.
	 */
	JSplitPane splitPane;
	
	public UserManager() {
		setLayout(new BorderLayout(0, 0));
		
		splitPane = new JSplitPane();
		splitPane.setLeftComponent(new myTree());
		splitPane.setRightComponent(new UserInfoCreate());
		add(splitPane, BorderLayout.CENTER);

	}
	
	class myTree extends UserTree{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			splitPane.setLeftComponent(new myTree());
		}



		@Override
		public void valueChanged(TreeSelectionEvent e) {
			// TODO �Զ����ɵķ������
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			if(node == null) {
				return;
			}
			
			if(node.isLeaf()) {
				leftNodeSelected(node);
			}
		}


		@Override
		public void leftNodeSelected(DefaultMutableTreeNode node) {
			// TODO �Զ����ɵķ������
			
//			User user = new UserDao().getUserByName(node.toString());
//			
//			splitPane.setRightComponent(new UserInfoUpdate(user));
			
			//���ڽ�������ļ���ΪҶ�ӽڵ��׳����쳣
			if(!node.getParent().toString().equals("���ѧԺ")) {
				User user = new UserDao().getUserByName(node.toString());
			
				splitPane.setRightComponent(new UserInfoUpdate(user));
			}
		}

		
	}
}
