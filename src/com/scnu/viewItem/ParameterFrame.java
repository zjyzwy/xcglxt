package com.scnu.viewItem;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.tree.DefaultMutableTreeNode;

import com.scnu.dao.ParameterDao;
import com.scnu.dao.UserDao;
import com.scnu.modleItem.Parameter;
import com.scnu.modleItem.User;

import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class ParameterFrame extends JPanel {

	/**
	 * Create the panel.
	 */
	private Parameter parameter;
	private JSplitPane splitPane;

	public ParameterFrame(String unitName) {
		setLayout(new BorderLayout(0, 0));
		parameter = new ParameterDao().getParameter(unitName);
		splitPane = new JSplitPane();
		splitPane.setLeftComponent(new myTree());
		splitPane.setRightComponent(new JobParameter(parameter));
		add(splitPane, BorderLayout.CENTER);

	}

	class myTree extends ParameterTree {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			splitPane.setLeftComponent(new myTree());
		}

		@Override
		public void leftNodeSelected(DefaultMutableTreeNode node) {
			// TODO Auto-generated method stub
			String info = node.toString();
			switch (info) {
			case "��λ����":
				splitPane.setRightComponent(new JobParameter(parameter));
				break;
			case "������Ч����":
				splitPane.setRightComponent(new BasicPerformanceParameter(parameter));
				break;
			case "ְ��ϵ��":
				splitPane.setRightComponent(new TitleParameter(parameter));
				break;
			case "����ڼ�Чϵ��":
				splitPane.setRightComponent(new JobManagePerformanceParameter(parameter));
				break;
			default:
				splitPane.setRightComponent(new OtherParameter(parameter));
				break;
			}

		}
	}
}
