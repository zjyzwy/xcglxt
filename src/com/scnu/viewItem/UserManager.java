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
			// TODO 自动生成的方法存根
			splitPane.setLeftComponent(new myTree());
		}



		@Override
		public void valueChanged(TreeSelectionEvent e) {
			// TODO 自动生成的方法存根
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
			// TODO 自动生成的方法存根
			
//			User user = new UserDao().getUserByName(node.toString());
//			
//			splitPane.setRightComponent(new UserInfoUpdate(user));
			
			//用于解决由于文件夹为叶子节点抛出的异常
			if(!node.getParent().toString().equals("软件学院")) {
				User user = new UserDao().getUserByName(node.toString());
			
				splitPane.setRightComponent(new UserInfoUpdate(user));
			}
		}

		
	}
}
