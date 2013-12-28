package com.ofeeldeuk.vjm.heap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class ReadXmlAdd {

	SimpleDateFormat formatter = new SimpleDateFormat(
			"yyyy : MM : dd : HH:mm:ss ");
	Calendar rightNow = Calendar.getInstance();
	String currentDate = formatter.format(rightNow.getTime());
	int count = 0;

	void xmlAdd(double heap) {
		try {
			String name = "C:\\Users\\bit\\Desktop\\project\\Project\\HeapInfo.xml";
			boolean isDir = (new File(name)).isDirectory();
			if (isDir == false) {
				// String str = "HeapPer = " + heapPer+
				// System.getProperty("line.separator");
				
				InputStream is = new FileInputStream(name);
				Scanner s = new Scanner(is);
				ArrayList<String> List = new ArrayList<String>();
				String saveStr = null;
				
				String str =  System.getProperty("line.separator") + "\t<heap>" + System.getProperty("line.separator")
						+ "\t\t<value>" + heap + "</value>"
						+ System.getProperty("line.separator") + "\t</heap>";
				
				while (s.hasNext()) {
					String str2 = s.nextLine();
					List.add(str2);
				}
				
				for(int i=0; i< List.size(); i++){
					System.out.println(List.get(i));
				}
				
				for (int i = 0; i < List.size(); i++) {
					if (List.get(i).equals("</heapinfo>")) {
						saveStr = List.get(i);
						List.remove(i);
					}
				}
				List.add(str);
				List.add(saveStr);
				
				for(int i =0; i<List.size(); i++){
					System.out.println(List.get(i));
				}
				OutputStream out = new FileOutputStream(name);
				for(int i=0; i<List.size(); i++){
					String str3 = List.get(i)+System.getProperty("line.separator");
					byte[] arr = str3.getBytes();
					out.write(arr);
				}
				out.close();
			} else{
				System.out.println("파일 존재하지 않습니다.");
				// File heapInfoFile = new File(
				// "C:\\Users\bit\\Desktop\\project\\Project\\HeapInfo.txt");
				OutputStream out = new FileOutputStream("HeapInfo.xml");
				String str = "<?xml version=" + "\"1.0\"" + "encoding="
						+ "\"utf-8\"?" + ">"
						+ System.getProperty("line.separator") + "<heapinfo>"
						+ System.getProperty("line.separator") + "\t<heap>"
						+ System.getProperty("line.separator")
						+ "\t\t<value>0</value>"
						+ System.getProperty("line.separator") + "\t</heap>"
						+ System.getProperty("line.separator") + "</heapinfo>" + System.getProperty("line.separator");
				byte[] arr = str.getBytes();
				out.write(arr);
				out.close();
			}
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
