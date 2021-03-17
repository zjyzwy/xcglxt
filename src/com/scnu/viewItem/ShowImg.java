package com.scnu.viewItem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.scnu.tools.Upload;

import java.awt.Font;
import java.awt.Toolkit;

public class ShowImg extends JDialog implements ActionListener{

	private ImageJPanel contentPanel;
	private JTextField textField;
	private String userId;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public ShowImg(String userId) {
		this.userId = userId;
		setBounds(0, 0, 609, 554);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel = new ImageJPanel(userId+".jpg");
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				textField = new JTextField();
				buttonPane.add(textField);
				textField.setColumns(40);
			}
			{
				JButton btnNewButton = new JButton("\u66F4\u65B0\u56FE\u50CF");
				btnNewButton.addActionListener(this);
				btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
				buttonPane.add(btnNewButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle("选择jpg图像文件");
		int result = jfc.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			File fFrom = jfc.getSelectedFile();
			String fromPath = fFrom.getAbsolutePath();
			textField.setText(fromPath);
			
			String toPath;
			
			URL imgPath = ShowImg.class.getResource("/img/");
			if(imgPath == null) {
				String path = ShowImg.class.getResource("/").getPath()+"/img/";
				File f = new File(path);
				f.mkdir();
				toPath = ShowImg.class.getResource("/img/").getPath()+userId +".jpg";
			}else {
				toPath = ShowImg.class.getResource("/img/").getPath() + userId +".jpg";
			}
			
			int state = Upload.upLoad(fromPath, toPath);
			if(state ==1) {
				contentPanel.setImg(Toolkit.getDefaultToolkit().getImage(fromPath));
				contentPanel.repaint();
				//System.out.println("contentPanel");
			}else {
				JOptionPane.showMessageDialog(null, "图像上传失败请重试");
			}
			
		}
	}

}
