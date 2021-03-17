package com.scnu.viewItem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.tree.DefaultMutableTreeNode;

import com.scnu.dao.PayoffDao;
import com.scnu.dao.UserDao;
import com.scnu.modleItem.User;
import com.scnu.viewItem.WorkloadEntryManager.myTree;

public class PayoffFrame extends JPanel {

	/**
	 * Create the panel.
	 */
	JSplitPane splitPane;

	public PayoffFrame(User user) {
		setLayout(new BorderLayout(0, 0));

		splitPane = new JSplitPane();
		splitPane.setLeftComponent(new MyTree());
		splitPane.setRightComponent(new PayoffView(user));
		add(splitPane, BorderLayout.CENTER);
	}

	class MyTree extends UserTree {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO 自动生成的方法存根
			splitPane.setLeftComponent(new MyTree());
		}

		@Override
		public void leftNodeSelected(DefaultMutableTreeNode node) {
			// TODO 自动生成的方法存根
			User user = new UserDao().getUserByName(node.toString());
			splitPane.setRightComponent(new PayoffView(user));

		}

	}
}
