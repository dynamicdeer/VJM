package com.ofeeldeuk.vjm.heap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class SaveXml {

	SimpleDateFormat formatter = new SimpleDateFormat(
			"yyyy : MM : dd : HH:mm:ss ");
	Calendar rightNow = Calendar.getInstance();
	String currentDate = formatter.format(rightNow.getTime());
	int count = 0;

	void xmlAdd(double heap) {
		try {
			OutputStream out = new FileOutputStream("HeapInfo2.xml");
			String str = "<?xml version=" + "\"1.0\"" + "encoding="
					+ "\"utf-8\"?" + ">" + System.getProperty("line.separator")
					+ "<heapinfo>" + System.getProperty("line.separator")
					+ "\t<heap>" + System.getProperty("line.separator")
					+ "\t\t<value>" + heap + "</value>"
					+ System.getProperty("line.separator") + "\t</heap>"
					+ System.getProperty("line.separator") + "</heapinfo>"
					+ System.getProperty("line.separator");
			byte[] arr = str.getBytes();
			out.write(arr);
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private boolean fileIsLive(String isLivefile) {

		File f1 = new File(isLivefile);

		if (f1.exists()) {
			return true;
		} else {
			return false;
		}
		// TODO Auto-generated method stub
	}

}
