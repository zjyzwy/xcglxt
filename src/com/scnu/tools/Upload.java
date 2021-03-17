package com.scnu.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class Upload {

	public static int upLoad(String fileFrom,String fileTo) {
		int state = 0; //state = 0,�ϴ�ʧ�ܣ�1�ϴ��ɹ�
		File fFrom = new File(fileFrom);
		File fTo = new File(fileTo);
		File parentPath = new File(fTo.getParent());
		if(!parentPath.exists()) {
			parentPath.mkdir();
		}
		FileInputStream fIn =null;
		FileOutputStream fOut = null;
		try {
			fIn = new FileInputStream(fFrom);
			fOut = new FileOutputStream(fTo);
			FileChannel fileChannelIn = fIn.getChannel();
			FileChannel fileChannelOut = fOut.getChannel();
			fileChannelIn.transferTo(0, fileChannelIn.size(), fileChannelOut);
			fileChannelOut.close();
			fileChannelIn.close();
			fOut.close();
			fIn.close();
			state = 1;
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return state;
	}
}
