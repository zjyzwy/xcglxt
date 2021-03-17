package com.scnu.viewItem;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ImageJPanel extends JPanel {

	private Image img;

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
	public ImageJPanel(String imageName) {
		URL imageURL = ImageJPanel.class.getResource("/img/"+imageName);
		if(imageURL!=null) {
			img = Toolkit.getDefaultToolkit().getImage(imageURL);
		}else {
			imageURL = ImageJPanel.class.getResource("/img/default.jpg");
			if(imageURL!=null) {
				img = Toolkit.getDefaultToolkit().getImage(imageURL);
			}else {
				JOptionPane.showMessageDialog(null, "img文件夹中default.jpg文件丟失");
			}
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, 0, 0, 400, 500, this);
	}
}
