package com.scnu.viewItem;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.tree.DefaultMutableTreeNode;

import com.scnu.dao.UserDao;
import com.scnu.modleItem.User;
import com.scnu.viewItem.WorkloadEntry;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class WorkloadEntryManager extends JPanel {

	/**
	 * Create the panel.
	 */
	public JSplitPane splitPane = new JSplitPane();

	public WorkloadEntryManager(User user) {
		setLayout(new BorderLayout(0, 0));

		splitPane.setLeftComponent(new myTree());
		splitPane.setRightComponent(new WorkloadEntry(user));
		add(splitPane, BorderLayout.CENTER);

	}

	class myTree extends UserTree {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根

			splitPane.setLeftComponent(new myTree());

		}

		@Override
		public void leftNodeSelected(DefaultMutableTreeNode node) {
			// TODO 自动生成的方法存根
			User user = new UserDao().getUserByName(node.toString());
			WorkloadEntry w = new WorkloadEntry(user);
			w.setUserId(user.getUserId());
			w.setName(user.getUserName());
			splitPane.setRightComponent(new WorkloadEntryUpdate(user));

		}
	}
}