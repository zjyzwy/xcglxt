package com.scnu.viewItem;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

public abstract class ParameterTree extends JPanel implements ActionListener, TreeSelectionListener {
	JTree tree;

	public ParameterTree() {
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("���ѧԺ");
		DefaultMutableTreeNode dep1 = new DefaultMutableTreeNode("��λ����");
		DefaultMutableTreeNode dep2 = new DefaultMutableTreeNode("������Ч����");
		DefaultMutableTreeNode dep3 = new DefaultMutableTreeNode("ְ��ϵ��");
		DefaultMutableTreeNode dep4 = new DefaultMutableTreeNode("����ڼ�Чϵ��");
		DefaultMutableTreeNode dep5 = new DefaultMutableTreeNode("����");
		rootNode.add(dep1);
		rootNode.add(dep2);
		rootNode.add(dep3);
		rootNode.add(dep4);
		rootNode.add(dep5);

		setLayout(new BorderLayout(0, 0));

		tree = new JTree(rootNode);
		tree.addTreeSelectionListener(this);
		this.add(tree, BorderLayout.CENTER);

	}

	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		if (node == null) {
			return;
		}
		if (node.isLeaf()) {
			leftNodeSelected(node);
		}
	}

	public abstract void leftNodeSelected(DefaultMutableTreeNode node);

}
